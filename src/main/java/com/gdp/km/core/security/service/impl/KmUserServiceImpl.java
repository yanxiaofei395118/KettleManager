package com.gdp.km.core.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdp.km.core.security.bean.KmUser;
import com.gdp.km.core.security.service.KmUserService;
import com.gdp.km.core.security.service.impl.dao.KmUserMapper;

@Service
public class KmUserServiceImpl implements KmUserService{
	@Autowired
	private KmUserMapper kmusermapper;
	
	@Override
	@Transactional
	public List<KmUser> getUserByUsername(String username) {
		return kmusermapper.selectByUserName(username);
	}
	
}
