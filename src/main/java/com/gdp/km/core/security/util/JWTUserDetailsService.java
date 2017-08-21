package com.gdp.km.core.security.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gdp.km.core.security.bean.KmUser;
import com.gdp.km.core.security.service.KmUserService;

@Service
public class JWTUserDetailsService implements UserDetailsService {
	@Autowired
	private KmUserService kmuserservice;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<KmUser> listuser=kmuserservice.getUserByUsername(username);
		if(listuser.size()==0){
			throw new UsernameNotFoundException("not find user:"+username);
		}
		KmUser user=listuser.get(0);
		return new User(user.getUsername(),user.getPassword(), new ArrayList<GrantedAuthority>());
	}

}
