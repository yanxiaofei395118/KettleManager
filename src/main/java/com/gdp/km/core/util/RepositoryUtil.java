package com.gdp.km.core.util;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * 初始化kettle
 * 创建kettle资源库连接
 * */
@Service
public class RepositoryUtil implements InitializingBean{
	@Value("${kettle.datasource.ip}")
	private String ip;
	@Value("${kettle.datasource.workspace}")
	private String workspace;
	@Value("${kettle.datasource.prot}")
	private String prot;
	@Value("${kettle.datasource.username}")
	private String username;
	@Value("${kettle.datasource.password}")
	private String password;
	
	//kettle资源库连接
	public KettleDatabaseRepository kdrepository;
	
	public KettleDatabaseRepository getKdrepository() {
		return kdrepository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化kettle
		KettleEnvironment.init();
		//创建资源库
		KettleDatabaseRepository repository = new KettleDatabaseRepository();
		//创建数据库连接对象
		DatabaseMeta databaseMeta = new DatabaseMeta("kettle", "mysql", "jdbc",
				ip, workspace, prot, username, password);
		//创建资源库元对象
		KettleDatabaseRepositoryMeta kettleDatabaseRepositoryMeta = new KettleDatabaseRepositoryMeta(
				"kettle", "kettle", "kettle", databaseMeta);
		//把资源库元对象添加到资源库中
		repository.init(kettleDatabaseRepositoryMeta);
		// 连接资源库
		repository.connect("admin", "admin");
		
		this.kdrepository=repository;
	}

}
