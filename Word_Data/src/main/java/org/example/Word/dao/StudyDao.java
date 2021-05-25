package org.example.Word.dao;

import org.apache.ibatis.annotations.Param;
import org.example.Word.dto.Study_Word;

import java.util.List;

/**
 * @des:
 * @package: org.example.Word.dao
 * @author: xsg
 * @date: 2021/5/12
 **/
public interface StudyDao {

    Study_Word selectTrueWord(@Param(value = "WID") Long WID);

    List<Study_Word> otherFalseWord(@Param(value = "WID") Long WID);

}
