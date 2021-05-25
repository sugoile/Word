package org.example.Word.service;

import org.example.Word.dto.AdminInfo_Param;
import org.example.Word.dto.LearnedCount;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.service
 * @author: xsg
 * @date: 2021/4/19
 **/
public interface IndexService {
    AdminInfo_Param login(String username, String passwrod);

    int Register(String username, String passwrod);

    List<Integer> RecordTimeForWord(long uid);

    List<LearnedCount> BookLearnedCount(long uid);
}
