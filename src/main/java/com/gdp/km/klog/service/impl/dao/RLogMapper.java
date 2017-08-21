package com.gdp.km.klog.service.impl.dao;

import org.apache.ibatis.annotations.Mapper;

import com.gdp.km.klog.bean.RLog;

@Mapper
public interface RLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RLog record);

    int insertSelective(RLog record);

    RLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RLog record);

    int updateByPrimaryKey(RLog record);
}