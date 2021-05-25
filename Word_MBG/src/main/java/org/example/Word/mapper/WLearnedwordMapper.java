package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WLearnedword;
import org.example.Word.model.WLearnedwordExample;

public interface WLearnedwordMapper {
    long countByExample(WLearnedwordExample example);

    int deleteByExample(WLearnedwordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WLearnedword record);

    int insertSelective(WLearnedword record);

    List<WLearnedword> selectByExample(WLearnedwordExample example);

    WLearnedword selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WLearnedword record, @Param("example") WLearnedwordExample example);

    int updateByExample(@Param("record") WLearnedword record, @Param("example") WLearnedwordExample example);

    int updateByPrimaryKeySelective(WLearnedword record);

    int updateByPrimaryKey(WLearnedword record);
}