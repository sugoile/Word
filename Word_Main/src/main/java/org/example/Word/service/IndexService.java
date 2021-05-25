package org.example.Word.service;

import org.example.Word.Po.AdminInfo_PO;
import org.example.Word.dto.AdminInfo_Param;
import org.example.Word.model.UAdmin;

/**
 * @des:
 * @package: org.example.Word.service
 * @author: xsg
 * @date: 2021/4/19
 **/
public interface IndexService {
    AdminInfo_Param login(String username, String passwrd);

    int Register(AdminInfo_PO adminInfo_po);
}
