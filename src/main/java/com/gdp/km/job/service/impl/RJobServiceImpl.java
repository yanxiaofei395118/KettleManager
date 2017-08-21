package com.gdp.km.job.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdp.km.core.util.Page;
import com.gdp.km.core.util.RepositoryUtil;
import com.gdp.km.core.util.ReturnMessage;
import com.gdp.km.job.bean.RJobWithBLOBs;
import com.gdp.km.job.service.RJobService;
import com.gdp.km.job.service.impl.dao.RJobMapper;
import com.gdp.km.quartz.JobQuartz;
import com.gdp.km.quartz.QuartzManager;

@Service
public class RJobServiceImpl implements RJobService,ApplicationContextAware {
	
	private ApplicationContext applicationcontext;
	
	@Autowired
	private RJobMapper rjobmapper;
	
	@Autowired
	private RepositoryUtil repositoryutil;
	
	@Autowired
	private QuartzManager quartzmanager;
	
	@Override
	@Transactional
	public Map<String,Object> getJobs(int currentPage,int pageNumber) {
		Map<String,Object> map = new HashMap<String,Object>();
		Page page = new Page();
		page.setPageNumber(pageNumber);
		page.setCurrentPage(currentPage);
		map.put("page", page);
		map.put("data", rjobmapper.selectByPage(map));
		
		return map;
	}
	
	@Override
	@Transactional
	public int doJobs(String type,RJobWithBLOBs rjob) {
		if(type.equals("i")){
			return rjobmapper.insert(rjob);
		}
		if(type.equals("u")){
			if(rjob.getJobRunrule()!=null){
				String jobName="JOB@"+rjob.getIdJob();
				String jobGroupName="JOB_GROUP@"+rjob.getIdJob();
				String triggerName="TRIGGER@"+rjob.getIdJob();
				String triggerGroupName="TRIGGER_GROUP@"+rjob.getIdJob();
				String cron=rjob.getJobRunrule();
				quartzmanager.modifyJobTime(jobName,jobGroupName,triggerName,triggerGroupName,cron);
			}
			return rjobmapper.updateByPrimaryKeySelective(rjob);
		}
		if(type.equals("d")){
			return rjobmapper.deleteByPrimaryKey(rjob.getIdJob());
		}
		return 0;
	}
	
	// 执行存储在数据库资源库中的转换
	@Override
	@Transactional
	public void runJob(Long id){
		RJobWithBLOBs rjob=rjobmapper.selectByPrimaryKey(id);
		String jobName="JOB@"+id;
		String jobGroupName="JOB_GROUP@"+id;
		String triggerName="TRIGGER@"+id;
		String triggerGroupName="TRIGGER_GROUP@"+id;
		String cron=rjob.getJobRunrule();
		KettleDatabaseRepository repository = repositoryutil.getKdrepository();
		
		Map<String, Object> parameter=new HashMap<String, Object>();
		parameter.put("jobinfo", rjob);
		parameter.put("datarepository", repository);
		parameter.put("applicationcontext", applicationcontext);
		
		quartzmanager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, JobQuartz.class, cron, parameter);
		rjob.setJobStatus(1);
		rjobmapper.updateByPrimaryKeySelective(rjob);
	}
	
	// 执行存储在数据库资源库中的转换
	@Override
	@Transactional
	public void stopJob(Long id){
		String jobName="JOB@"+id;
		String jobGroupName="JOB_GROUP@"+id;
		String triggerName="TRIGGER@"+id;
		String triggerGroupName="TRIGGER_GROUP@"+id;
		
		quartzmanager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
		RJobWithBLOBs rjob=new RJobWithBLOBs();
		rjob.setIdJob(id);
		rjob.setJobStatus(0);
		rjobmapper.updateByPrimaryKeySelective(rjob);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationcontext=applicationContext;
		
	}

}
