package com.gdp.km.core.security.service.impl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdp.km.core.security.bean.KmUser;

@Mapper
public interface KmUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KmUser record);

	int insertSelective(KmUser record);

	KmUser selectByPrimaryKey(Integer id);

	List<KmUser> selectByUserName(String username);

	int updateByPrimaryKeySelective(KmUser record);

	int updateByPrimaryKey(KmUser record);
}