package org.example.Word.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.Word.model.UAdmin;
import org.example.Word.model.UInfo;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.dto
 * @author: xsg
 * @date: 2021/4/19
 **/
@Getter
@Setter
public class AdminInfo_Param {
    UAdmin uAdmins;
    UInfo uInfos;
}
