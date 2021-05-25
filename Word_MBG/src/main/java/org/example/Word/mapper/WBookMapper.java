package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WBook;
import org.example.Word.model.WBookExample;

public interface WBookMapper {
    long countByExample(WBookExample example);

    int deleteByExample(WBookExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WBook record);

    int insertSelective(WBook record);

    List<WBook> selectByExample(WBookExample example);

    WBook selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WBook record, @Param("example") WBookExample example);

    int updateByExample(@Param("record") WBook record, @Param("example") WBookExample example);

    int updateByPrimaryKeySelective(WBook record);

    int updateByPrimaryKey(WBook record);
}