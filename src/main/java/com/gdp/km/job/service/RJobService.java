package com.gdp.km.job.service;

import java.util.Map;

import com.gdp.km.job.bean.RJobWithBLOBs;

public interface RJobService {
	/**
	 * 获取转换列表
	 * @param currentPage 第几页
	 * */
	Map<String,Object> getJobs(int currentPage,int pageNumber);
	
	int doJobs(String type,RJobWithBLOBs rjob);
	
	void runJob(Long id);

	void stopJob(Long id);
	
}
