package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.UAdmin;
import org.example.Word.model.UAdminExample;

public interface UAdminMapper {
    long countByExample(UAdminExample example);

    int deleteByExample(UAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UAdmin record);

    int insertSelective(UAdmin record);

    List<UAdmin> selectByExample(UAdminExample example);

    UAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UAdmin record, @Param("example") UAdminExample example);

    int updateByExample(@Param("record") UAdmin record, @Param("example") UAdminExample example);

    int updateByPrimaryKeySelective(UAdmin record);

    int updateByPrimaryKey(UAdmin record);
}