package com.gdp.km.klog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdp.km.klog.bean.RLog;
import com.gdp.km.klog.service.impl.dao.RLogMapper;

@Service
public class KLogServiceImpl {
	@Autowired
	private RLogMapper rlogmapper;
	
	@Transactional
	public int insertlog(RLog rlog){
		return rlogmapper.insert(rlog);
	}
}
