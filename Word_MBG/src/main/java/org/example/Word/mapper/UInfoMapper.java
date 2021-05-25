package org.example.Word.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.Word.model.UInfo;
import org.example.Word.model.UInfoExample;

public interface UInfoMapper {
    long countByExample(UInfoExample example);

    int deleteByExample(UInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UInfo record);

    int insertSelective(UInfo record);

    List<UInfo> selectByExample(UInfoExample example);

    UInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UInfo record, @Param("example") UInfoExample example);

    int updateByExample(@Param("record") UInfo record, @Param("example") UInfoExample example);

    int updateByPrimaryKeySelective(UInfo record);

    int updateByPrimaryKey(UInfo record);
}