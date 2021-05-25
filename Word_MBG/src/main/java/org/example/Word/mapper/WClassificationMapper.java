package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WClassification;
import org.example.Word.model.WClassificationExample;

public interface WClassificationMapper {
    long countByExample(WClassificationExample example);

    int deleteByExample(WClassificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WClassification record);

    int insertSelective(WClassification record);

    List<WClassification> selectByExample(WClassificationExample example);

    WClassification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WClassification record, @Param("example") WClassificationExample example);

    int updateByExample(@Param("record") WClassification record, @Param("example") WClassificationExample example);

    int updateByPrimaryKeySelective(WClassification record);

    int updateByPrimaryKey(WClassification record);
}