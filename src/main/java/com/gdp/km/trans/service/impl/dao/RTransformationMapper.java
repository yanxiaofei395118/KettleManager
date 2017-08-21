package com.gdp.km.trans.service.impl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gdp.km.trans.bean.RTransformation;
import com.gdp.km.trans.bean.RTransformationWithBLOBs;

@Mapper
public interface RTransformationMapper {
    int deleteByPrimaryKey(Long idTransformation);

    int insert(RTransformationWithBLOBs record);

    int insertSelective(RTransformationWithBLOBs record);

    RTransformationWithBLOBs selectByPrimaryKey(Long idTransformation);

    List<RTransformationWithBLOBs> selectByPage(Map<String,Object> map);

    int updateByPrimaryKeySelective(RTransformationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RTransformationWithBLOBs record);

    int updateByPrimaryKey(RTransformation record);
}