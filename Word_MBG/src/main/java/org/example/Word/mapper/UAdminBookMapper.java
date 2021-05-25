package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.UAdminBook;
import org.example.Word.model.UAdminBookExample;

public interface UAdminBookMapper {
    long countByExample(UAdminBookExample example);

    int deleteByExample(UAdminBookExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UAdminBook record);

    int insertSelective(UAdminBook record);

    List<UAdminBook> selectByExample(UAdminBookExample example);

    UAdminBook selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UAdminBook record, @Param("example") UAdminBookExample example);

    int updateByExample(@Param("record") UAdminBook record, @Param("example") UAdminBookExample example);

    int updateByPrimaryKeySelective(UAdminBook record);

    int updateByPrimaryKey(UAdminBook record);
}