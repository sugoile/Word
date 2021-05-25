package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WBookClassification;
import org.example.Word.model.WBookClassificationExample;

public interface WBookClassificationMapper {
    long countByExample(WBookClassificationExample example);

    int deleteByExample(WBookClassificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WBookClassification record);

    int insertSelective(WBookClassification record);

    List<WBookClassification> selectByExample(WBookClassificationExample example);

    WBookClassification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WBookClassification record, @Param("example") WBookClassificationExample example);

    int updateByExample(@Param("record") WBookClassification record, @Param("example") WBookClassificationExample example);

    int updateByPrimaryKeySelective(WBookClassification record);

    int updateByPrimaryKey(WBookClassification record);
}