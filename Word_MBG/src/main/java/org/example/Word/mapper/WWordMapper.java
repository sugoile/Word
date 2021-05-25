package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.WWord;
import org.example.Word.model.WWordExample;

public interface WWordMapper {
    long countByExample(WWordExample example);

    int deleteByExample(WWordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WWord record);

    int insertSelective(WWord record);

    List<WWord> selectByExample(WWordExample example);

    WWord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WWord record, @Param("example") WWordExample example);

    int updateByExample(@Param("record") WWord record, @Param("example") WWordExample example);

    int updateByPrimaryKeySelective(WWord record);

    int updateByPrimaryKey(WWord record);
}