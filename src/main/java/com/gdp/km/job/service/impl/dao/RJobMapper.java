package com.gdp.km.job.service.impl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdp.km.job.bean.RJob;
import com.gdp.km.job.bean.RJobWithBLOBs;

@Mapper
public interface RJobMapper {
	
	List<RJobWithBLOBs> selectByPage(Map<String,Object> map);
	
    int deleteByPrimaryKey(Long idJob);

    int insert(RJobWithBLOBs record);

    int insertSelective(RJobWithBLOBs record);

    RJobWithBLOBs selectByPrimaryKey(Long idJob);

    int updateByPrimaryKeySelective(RJobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RJobWithBLOBs record);

    int updateByPrimaryKey(RJob record);
}