package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WClassificationBook;
import org.example.Word.model.WClassificationBookExample;

public interface WClassificationBookMapper {
    long countByExample(WClassificationBookExample example);

    int deleteByExample(WClassificationBookExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WClassificationBook record);

    int insertSelective(WClassificationBook record);

    List<WClassificationBook> selectByExample(WClassificationBookExample example);

    WClassificationBook selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WClassificationBook record, @Param("example") WClassificationBookExample example);

    int updateByExample(@Param("record") WClassificationBook record, @Param("example") WClassificationBookExample example);

    int updateByPrimaryKeySelective(WClassificationBook record);

    int updateByPrimaryKey(WClassificationBook record);
}