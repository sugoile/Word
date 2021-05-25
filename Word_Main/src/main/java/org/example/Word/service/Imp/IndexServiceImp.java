package org.example.Word.service.Imp;

import org.example.Word.Po.AdminInfo_PO;
import org.example.Word.config.JasyptUtils;
import org.example.Word.dto.AdminInfo_Param;
import org.example.Word.mapper.UAdminMapper;
import org.example.Word.mapper.UInfoMapper;
import org.example.Word.model.UAdmin;
import org.example.Word.model.UAdminExample;
import org.example.Word.model.UInfo;
import org.example.Word.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public AdminInfo_Param login(String username, String password) {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if(uAdmins.size() == 0) return null;
        UAdmin uAdmin = uAdmins.get(0);
        UInfo uInfo = uInfoMapper.selectByPrimaryKey(uAdmin.getInfoId());

        AdminInfo_Param adminInfo_param = new AdminInfo_Param();
        adminInfo_param.setUAdmins(uAdmin);
        adminInfo_param.setUInfos(uInfo);
        return adminInfo_param;
    }

    @Override
    public int Register(AdminInfo_PO adminInfo_po) {
        UInfo uInfo = new UInfo();
        uInfo.setEmail(adminInfo_po.getEmail());
        uInfo.setNickName(adminInfo_po.getNickName());
        int count = uInfoMapper.insertSelective(uInfo);

        if(count > 0){
            UAdmin uAdmin = new UAdmin();
            String password = jasyptUtils.encryptPwd(adminInfo_po.getUsername());
            uAdmin.setUsername(adminInfo_po.getUsername());
            uAdmin.setPassword(password);
            uAdmin.setInfoId(uInfo.getId());
            return uAdminMapper.insertSelective(uAdmin);
        }
        else return 0;
    }
}
