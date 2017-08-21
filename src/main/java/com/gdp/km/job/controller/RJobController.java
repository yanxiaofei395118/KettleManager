package com.gdp.km.job.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdp.km.core.util.ReturnMessage;
import com.gdp.km.job.bean.RJobWithBLOBs;
import com.gdp.km.job.service.RJobService;

@RestController
@RequestMapping("/jobs")
public class RJobController {
	@Autowired
	private RJobService rjobservice;
	
	/**
	 * 查询转换列表
	 * */
	@GetMapping
	public Map<String,Object> getJobs(int currentPage,int pageNumber){
		return rjobservice.getJobs(currentPage,pageNumber);
	}
	
	/**
	 * 增删改转换
	 * */
	@PostMapping("/type/{do}")
	public ReturnMessage doJobs(RJobWithBLOBs rjob,@PathVariable("do")String type){
		int sueccess = rjobservice.doJobs(type,rjob);
		if(sueccess==1){
			return new ReturnMessage("操作成功","");
		}else{
			return new ReturnMessage("操作失败");
		}
	}
	
	@GetMapping("/run/{id}")
	public ReturnMessage runJob(@PathVariable("id")Long id){
		try{
			rjobservice.runJob(id);
		}catch(Exception e){
			e.printStackTrace();
			return new ReturnMessage("操作失败");
		}
		return new ReturnMessage("操作成功","");
	}
	
	@GetMapping("/stop/{id}")
	public ReturnMessage stopJob(@PathVariable("id")Long id){
		try{
			rjobservice.stopJob(id);
		}catch(Exception e){
			e.printStackTrace();
			return new ReturnMessage("操作失败");
		}
		return new ReturnMessage("操作成功","");
	}
}
