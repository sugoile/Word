package org.example.Word.service.Imp;

import org.example.Word.config.JasyptUtils;
import org.example.Word.dto.AdminInfo_Param;
import org.example.Word.dto.LearnedCount;
import org.example.Word.mapper.*;
import org.example.Word.model.*;
import org.example.Word.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @des:
 * @package: org.example.Word.service.Imp
 * @author: xsg
 * @date: 2021/4/19
 **/
@Service
public class IndexServiceImp implements IndexService {

    @Autowired
    private UAdminMapper uAdminMapper;

    @Autowired
    private UInfoMapper uInfoMapper;

    @Autowired
    private JasyptUtils jasyptUtils;

    @Autowired
    private WLearnedwordMapper wLearnedwordMapper;

    @Autowired
    private UAdminBookMapper uAdminBookMapper;

    @Autowired
    private WBookMapper wBookMapper;

    @Override
    public AdminInfo_Param login(String username, String password) {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if (uAdmins.size() == 0) return null;
        String password1 = uAdmins.get(0).getPassword();
        if (!jasyptUtils.decyptPwd(password1).equals(password)) {
            return null;
        }
        UAdmin uAdmin = uAdmins.get(0);
        uAdmin.setPassword(password);
        UInfo uInfo = uInfoMapper.selectByPrimaryKey(uAdmin.getInfoId());

        AdminInfo_Param adminInfo_param = new AdminInfo_Param();
        adminInfo_param.setUAdmins(uAdmin);
        adminInfo_param.setUInfos(uInfo);
        return adminInfo_param;
    }

    @Override
    public int Register(String username, String password) {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if (uAdmins.size() > 0) return -1;
        UAdmin uAdmin = new UAdmin();
        String Truepassword = jasyptUtils.encryptPwd(password);
        uAdmin.setUsername(username);
        uAdmin.setPassword(Truepassword);
        int count = uAdminMapper.insertSelective(uAdmin);
        if(count > 0){
            return uAdmin.getId().intValue();
        }
        return 0;
    }

    @Override
    public List<Integer> RecordTimeForWord(long uid) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] Year_Day = simpleDateFormat.format(date).split("-");

        WLearnedwordExample wLearnedwordExample = new WLearnedwordExample();
        wLearnedwordExample.createCriteria().andStudyTimeYearEqualTo(Integer.parseInt(Year_Day[0]))
                .andStudyTimeMonthEqualTo(Integer.parseInt(Year_Day[1])).andUidEqualTo(uid);
        List<WLearnedword> wLearnedwords = wLearnedwordMapper.selectByExample(wLearnedwordExample);

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        //获得本月第一天
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String[] firstDays = simpleDateFormat.format(cal.getTime()).split("-");
        int firstDay = Integer.parseInt(firstDays[2]);
        //获得本月最后一天
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String[] lastDays = simpleDateFormat.format(cal.getTime()).split("-");
        int lastDay = Integer.parseInt(lastDays[2]);

        Map<Integer, Integer> map = new HashMap<>();
        for (WLearnedword wLearnedword : wLearnedwords) {
            if (map.containsKey(wLearnedword.getStudyTimeDay())) {
                map.put(wLearnedword.getStudyTimeDay(), map.get(wLearnedword.getStudyTimeDay()) + 1);
            } else {
                map.put(wLearnedword.getStudyTimeDay(), 1);
            }
        }

        List<Integer> TimeWords = new ArrayList<>();
        for (int i = 1; i <= lastDay; i++) {
            if (map.containsKey(i)) {
                TimeWords.add(map.get(i));
            } else {
                TimeWords.add(0);
            }
        }
        return TimeWords;
    }

    @Override
    public List<LearnedCount> BookLearnedCount(long uid) {
        List<LearnedCount> learnedCounts = new ArrayList<>();
        UAdminBookExample uAdminBookExample = new UAdminBookExample();
        uAdminBookExample.createCriteria().andUidEqualTo(uid);
        List<UAdminBook> uAdminBooks = uAdminBookMapper.selectByExample(uAdminBookExample);
        for (int i = 0; i < uAdminBooks.size(); i++) {
            LearnedCount learnedCount = new LearnedCount();

            WLearnedwordExample wLearnedwordExample = new WLearnedwordExample();
            wLearnedwordExample.createCriteria().andBidEqualTo(uAdminBooks.get(i).getBid()).andUidEqualTo(uid);
            List<WLearnedword> wLearnedwords = wLearnedwordMapper.selectByExample(wLearnedwordExample);

            WBookExample wBookExample = new WBookExample();
            wBookExample.createCriteria().andIdEqualTo(uAdminBooks.get(i).getBid());
            List<WBook> wBooks = wBookMapper.selectByExample(wBookExample);

            learnedCount.setBookName(wBooks.get(0).getBookname());
            learnedCount.setLearnCount(wLearnedwords.size());
            learnedCount.setWBook(wBooks.get(0));
            String[] ranges = wBooks.get(0).getRanges().split(",");
            int present =  wLearnedwords.size() / (Integer.parseInt(ranges[1]) - Integer.parseInt(ranges[0]) + 1);
            learnedCount.setWordCount(Integer.parseInt(ranges[1]) - Integer.parseInt(ranges[0]) + 1);
            learnedCount.setPrecent((present * 100) + "%");

            learnedCounts.add(learnedCount);
        }
        return learnedCounts;
    }
}
