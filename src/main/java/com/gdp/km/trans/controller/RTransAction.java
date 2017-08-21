package com.gdp.km.trans.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdp.km.trans.bean.RTransformationWithBLOBs;
import com.gdp.km.trans.service.RTransService;

@RestController
@RequestMapping("/trans")
public class RTransAction {
	@Autowired
	private RTransService rtransservice;
	
	/**
	 * 查询转换列表
	 * */
	@GetMapping
	public Map<String,Object> getTranss(int currentPage,int pageNumber){
		return rtransservice.getTranss(currentPage,pageNumber);
	}
	
	/**
	 * 增删改转换
	 * */
	@PostMapping
	public RTransformationWithBLOBs doTranss(RTransformationWithBLOBs rtrans){
		return null;
	}
	
	/**
	 * 根据id查询转换
	 * */
	@RequestMapping("/{id}")
	public RTransformationWithBLOBs getTrans(@PathVariable("id")Long id){
		return rtransservice.getTransbyid(id);
	}
}
