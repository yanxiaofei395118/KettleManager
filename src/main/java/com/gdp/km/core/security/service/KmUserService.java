package com.gdp.km.core.security.service;

import java.util.List;

import com.gdp.km.core.security.bean.KmUser;

public interface KmUserService {
	List<KmUser> getUserByUsername(String username);
}
