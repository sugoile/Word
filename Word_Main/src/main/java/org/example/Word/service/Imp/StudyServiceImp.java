package org.example.Word.service.Imp;

import org.example.Word.dao.StudyDao;
import org.example.Word.dto.CorrectWord;
import org.example.Word.dto.Study_Word;
import org.example.Word.mapper.*;
import org.example.Word.model.*;
import org.example.Word.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @des:
 * @package: org.example.Word.service.Imp
 * @author: xsg
 * @date: 2021/5/10
 **/
@Service
public class StudyServiceImp implements StudyService {

    @Autowired
    private WWordMapper wWordMapper;

    @Autowired
    private WBookMapper wBookMapper;

    @Autowired
    private WBookWordMapper wBookWordMapper;

    @Autowired
    private StudyDao studyDao;

    @Autowired
    private UAdminMapper uAdminMapper;

    @Autowired
    private UAdminBookMapper uAdminBookMapper;

    @Autowired
    private WLearnedwordMapper wLearnedwordMapper;

    @Override
    public List<List<Study_Word>> StudyWordList(long uid, long bid, int wordnum) {
        List<List<Study_Word>> wWords = new ArrayList<>();
        WBook wBook = wBookMapper.selectByPrimaryKey(bid);
        String range = wBook.getRanges();
        String[] ranges = range.split(",");
        int min = Integer.parseInt(ranges[0]);
        int max = Integer.parseInt(ranges[1]);

        WLearnedwordExample wLearnedwordExample = new WLearnedwordExample();
        wLearnedwordExample.createCriteria().andBidEqualTo(bid).andUidEqualTo(uid);
        List<WLearnedword> wLearnedwords = wLearnedwordMapper.selectByExample(wLearnedwordExample);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < wLearnedwords.size(); i++) {
            set.add(wLearnedwords.get(i).getWid());
        }

        int count = 0;

        while(count < wordnum){
            int t = (int)(Math.random () * (max - min + 1));
            WBookWord wBookWord = wBookWordMapper.selectByPrimaryKey((long) t);
            if (set.contains(wBookWord.getWid())){
                continue;
            }else{
                set.add(wBookWord.getWid());
                Long WID = wBookWord.getWid();
                List<Study_Word> studyWords = this.getStudyWords(WID);
                wWords.add(studyWords);
                count++;
            }
        }
        return wWords;
    }

    @Override
    public List<List<Study_Word>> RandomTest() {
        List<List<Study_Word>> wWords = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        List<Long> wordNum = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            long l = (long) (Math.random() * (10400));
            set.add(l);
            wordNum.add(l);
        }
        int count = 0;

        while(count < wordNum.size()){
            WBookWord wBookWord = wBookWordMapper.selectByPrimaryKey(wordNum.get(count));
            if (set.contains(wBookWord.getWid())){
                continue;
            }else{
                Long WID = wBookWord.getWid();
                List<Study_Word> studyWords = this.getStudyWords(WID);
                wWords.add(studyWords);
                count++;
            }
        }
        return wWords;
    }

    @Override
    public List<List<Study_Word>> LastReciteWord(long uid) {
        List<List<Study_Word>> wWords = new ArrayList<>();
        WLearnedwordExample wLearnedwordExample = new WLearnedwordExample();
        wLearnedwordExample.createCriteria().andRecentEqualTo(1).andUidEqualTo(uid);
        List<WLearnedword> wLearnedwords = wLearnedwordMapper.selectByExample(wLearnedwordExample);

        if(wLearnedwords.size() == 0) return wWords;

        WLearnedwordExample wLearnedwordExample1 = new WLearnedwordExample();
        wLearnedwordExample1.createCriteria().andStudyTimeEqualTo(wLearnedwords.get(0).getStudyTime())
                                            .andUidEqualTo(uid);
        List<WLearnedword> wLearnedwords1 = wLearnedwordMapper.selectByExample(wLearnedwordExample1);

        int count = wLearnedwords1.size();
        if(count > 10) count = 10;

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < count; i++){
            set.add(wLearnedwords1.get(i).getWid());
        }

        for (int i = 0; i < count; i++){
            List<Study_Word> study_words = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int t = (int)(Math.random () * (10000));
                if(set.contains((long)t)){
                    continue;
                }
                else{
                    Study_Word study_word = this.setReviewStudyWord(t, false);
                    set.add(study_word.getId());
                    study_words.add(study_word);
                }
            }

            Study_Word study_word = this.setReviewStudyWord(wLearnedwords1.get(i).getBid(), true);
            study_words.add(study_word);
            set.add(study_word.getId());
            wWords.add(study_words);
        }
        return wWords;
    }


    public Study_Word setReviewStudyWord(long wid, boolean flag){
        WWord wWord = wWordMapper.selectByPrimaryKey(wid);
        Study_Word study_word = new Study_Word();
        study_word.setId(wWord.getId());
        study_word.setTrueWord(flag);
        study_word.setMeaningstr(wWord.getMeaningstr());
        study_word.setSpell(wWord.getSpell());
        return study_word;
    }

    @Override
    public int setStudyBook(long bid, long uid) {
        StudyServiceImp serviceImp = new StudyServiceImp();
        int existBORU = serviceImp.isExistBORU(bid, uid);
        if(existBORU < 0){
            return existBORU;
        }

        UAdminBook uAdminBook = new UAdminBook();
        uAdminBook.setBid(bid);
        uAdminBook.setUid(uid);
        return uAdminBookMapper.insertSelective(uAdminBook);
    }

    @Override
    public int commitLearnedWord(List<CorrectWord> words, long bid, long uid) {
        int count = 0;

        int existBORU = this.isExistBORU(bid, uid);
        if(existBORU < 0){
            return existBORU;
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        String day = simpleDateFormat.format(date);
        String[] Year_Month_Day = simpleDateFormat.format(date).split("-");

        WLearnedwordExample wLearnedwordExample = new WLearnedwordExample();
        wLearnedwordExample.createCriteria().andUidEqualTo(uid).andRecentEqualTo(1);
        List<WLearnedword> wLearnedwords = wLearnedwordMapper.selectByExample(wLearnedwordExample);
        if(wLearnedwords.size() > 0){
            this.setRecentFlag(wLearnedwords.get(0).getId(), 0);
        }

        long id = -1;
        for(CorrectWord word : words){
            WLearnedword wLearnedword = new WLearnedword();
            wLearnedword.setBid(bid);
            wLearnedword.setUid(uid);
            wLearnedword.setWid(word.getId());
            wLearnedword.setIscorrect(word.getIscorrect());
            wLearnedword.setStudyTimeYear(Integer.parseInt(Year_Month_Day[0]));
            wLearnedword.setStudyTimeMonth(Integer.parseInt(Year_Month_Day[1]));
            wLearnedword.setStudyTimeDay(Integer.parseInt(Year_Month_Day[2]));
            wLearnedword.setStudyTime(day);
            int res = wLearnedwordMapper.insertSelective(wLearnedword);
            count += res;
            id = wLearnedword.getId();
        }

        this.setRecentFlag(id, 1);
        return count;
    }

    public void setRecentFlag(long id, int flag){
        WLearnedword wLearnedword = new WLearnedword();
        wLearnedword.setId(id);
        wLearnedword.setRecent(flag);
        wLearnedwordMapper.updateByPrimaryKeySelective(wLearnedword);
    }

    @Override
    public List<Long> getLearnedWords(long uid, long bid) {
        WLearnedwordExample wLearnedwordExample = new WLearnedwordExample();
        wLearnedwordExample.createCriteria().andBidEqualTo(bid).andUidEqualTo(uid);
        List<WLearnedword> wLearnedwords = wLearnedwordMapper.selectByExample(wLearnedwordExample);
        List<Long> wordIds = new ArrayList<>();
        for(WLearnedword word : wLearnedwords){
            wordIds.add(word.getWid());
        }
        return wordIds;
    }

    @Override
    public int setStudyBookList(List<Long> bid, long uid) {
        UAdmin uAdmin = uAdminMapper.selectByPrimaryKey(uid);
        if(uAdmin == null) return -2;

        for (int i = 0; i <bid.size(); i++) {
            WBook wBook = wBookMapper.selectByPrimaryKey(bid.get(i));
            if(wBook == null) return -1;
        }

        UAdminBookExample uAdminBookExample = new UAdminBookExample();
        uAdminBookExample.createCriteria().andUidEqualTo(uid);
        List<UAdminBook> uAdminBooks = uAdminBookMapper.selectByExample(uAdminBookExample);

        if(uAdminBooks.size() == 0){
            for (int i = 0; i < bid.size(); i++) {
                UAdminBook uAdminBook = new UAdminBook();
                uAdminBook.setUid(uid);
                uAdminBook.setBid(bid.get(i));
                uAdminBook.setIshide(0);
                uAdminBookMapper.insertSelective(uAdminBook);
            }
            return 1;
        }

        for(UAdminBook uAdminBook : uAdminBooks){
            uAdminBook.setIshide(1);
            uAdminBookMapper.updateByPrimaryKeySelective(uAdminBook);
        }

        List<Long> bids = bid;
        for (int i = 0; i < uAdminBooks.size(); i++) {
            for (int j = 0; j < bid.size(); j++) {
                if(uAdminBooks.get(i).getBid() == bid.get(j)){
                    if(uAdminBooks.get(i).getIshide() == 1){
                        uAdminBooks.get(i).setIshide(0);
                        uAdminBookMapper.updateByPrimaryKeySelective(uAdminBooks.get(i));
                        bids.remove(bid.get(j));
                        break;
                    }
                }
            }
        }

        if(bids.size() != 0){
            for (int i = 0; i < bids.size(); i++) {
                UAdminBook uAdminBook = new UAdminBook();
                uAdminBook.setUid(uid);
                uAdminBook.setBid(bids.get(i));
                uAdminBook.setIshide(0);
                uAdminBookMapper.insertSelective(uAdminBook);
            }
        }
        return 1;
    }


    public int isExistBORU(long bid, long uid){
        WBook wBook = wBookMapper.selectByPrimaryKey(bid);
        if(wBook == null) return -1;

        UAdmin uAdmin = uAdminMapper.selectByPrimaryKey(uid);
        if(uAdmin == null) return -2;

        else return 0;
    }

    public List<Study_Word> getStudyWords(long WID){
        Study_Word trueWord = studyDao.selectTrueWord(WID);
        trueWord.setTrueWord(true);
        List<Study_Word> otherWord = studyDao.otherFalseWord(WID);
        for(Study_Word w : otherWord){
            w.setTrueWord(false);
        }
        otherWord.add(trueWord);
        return otherWord;
    }

    //动态代理判断不同dao接口是否存在该id
    public int isExist(long id){
        return 0;
    }
}
