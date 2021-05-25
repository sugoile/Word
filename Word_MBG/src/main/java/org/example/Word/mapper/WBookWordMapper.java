package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WBookWord;
import org.example.Word.model.WBookWordExample;

public interface WBookWordMapper {
    long countByExample(WBookWordExample example);

    int deleteByExample(WBookWordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WBookWord record);

    int insertSelective(WBookWord record);

    List<WBookWord> selectByExample(WBookWordExample example);

    WBookWord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WBookWord record, @Param("example") WBookWordExample example);

    int updateByExample(@Param("record") WBookWord record, @Param("example") WBookWordExample example);

    int updateByPrimaryKeySelective(WBookWord record);

    int updateByPrimaryKey(WBookWord record);
}