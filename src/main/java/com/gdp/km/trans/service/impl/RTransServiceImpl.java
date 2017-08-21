package com.gdp.km.trans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdp.km.core.util.Page;
import com.gdp.km.core.util.RepositoryUtil;
import com.gdp.km.trans.bean.RTransformationWithBLOBs;
import com.gdp.km.trans.service.RTransService;
import com.gdp.km.trans.service.impl.dao.RTransformationMapper;

@Service
public class RTransServiceImpl implements RTransService {
	@Autowired
	private RepositoryUtil repositoryutil;
	
	@Autowired
	private RTransformationMapper rtransformationmapper;
	
	@Override
	@Transactional
	public Map<String,Object> getTranss(int currentPage,int pageNumber) {
		Map<String,Object> map = new HashMap<String,Object>();
		Page page = new Page();
		page.setPageNumber(pageNumber);
		page.setCurrentPage(currentPage);
		map.put("page", page);
		map.put("data", rtransformationmapper.selectByPage(map));
		return map;
	}

	@Override
	public RTransformationWithBLOBs getTransbyid(Long id) {
		return rtransformationmapper.selectByPrimaryKey(id);
	}

	@Override
	public void doTrans(RTransformationWithBLOBs rtrans) {
		
	}
	
	// 执行存储在数据库资源库中的转换
	public void executeTrans() {
		try {
			KettleDatabaseRepository repository = repositoryutil.getKdrepository();
			
			RepositoryDirectoryInterface directoryInterface = repository.loadRepositoryDirectoryTree();
			// 选择转换
			TransMeta transMeta = repository.loadTransformation("trans1",directoryInterface, null, true, null);
			Trans trans = new Trans(transMeta);
			// 执行转换
			trans.execute(null);
			// 等待转换执行结束
			trans.waitUntilFinished();
			if (trans.getErrors() > 0) {
				System.out.println("transformation error");
			} else {
				System.out.println("transformation successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
