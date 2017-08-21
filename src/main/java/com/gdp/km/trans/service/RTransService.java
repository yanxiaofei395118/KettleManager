package com.gdp.km.trans.service;

import java.util.List;
import java.util.Map;

import com.gdp.km.trans.bean.RTransformationWithBLOBs;

public interface RTransService {
	/**
	 * 获取转换列表
	 * @param currentPage 第几页
	 * */
	Map<String,Object> getTranss(int currentPage,int pageNumber);
	
	RTransformationWithBLOBs getTransbyid(Long id);
	
	void doTrans(RTransformationWithBLOBs rtrans);
	
	
}
