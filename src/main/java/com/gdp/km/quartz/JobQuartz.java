package com.gdp.km.quartz;

import java.util.Date;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.core.logging.LoggingBuffer;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import com.gdp.km.job.bean.RJobWithBLOBs;
import com.gdp.km.klog.bean.RLog;
import com.gdp.km.klog.service.impl.KLogServiceImpl;

public class JobQuartz  implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//获取传入的参数
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		RJobWithBLOBs rjob = (RJobWithBLOBs)jobDataMap.get("jobinfo");
		KettleDatabaseRepository repository = (KettleDatabaseRepository)jobDataMap.get("datarepository");
		ApplicationContext applicationcontext = (ApplicationContext)jobDataMap.get("applicationcontext");
		try {
			runjob(rjob,repository,applicationcontext);
		} catch (KettleException e) {
			e.printStackTrace();
		}
	}

	public void runjob(RJobWithBLOBs rjob,KettleDatabaseRepository repository,ApplicationContext applicationcontext) throws KettleException {
		RepositoryDirectoryInterface directoryInterface = repository.loadRepositoryDirectoryTree();
		// 选择转换
		JobMeta JobMeta = repository.loadJob(rjob.getName(), directoryInterface, null, null);
		org.pentaho.di.job.Job job = new org.pentaho.di.job.Job(repository, JobMeta);
		Date jobStartDate = null;
		Date jobStopDate = null;
		try {
			// 执行作业
			jobStartDate = new Date();
			job.run();
			job.waitUntilFinished();
			jobStopDate = new Date();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (job.isFinished()) {
				if (job.getErrors() > 0) {
					System.out.println("decompress fail!");
				}
				String logChannelId = job.getLogChannelId();
				LoggingBuffer appender = KettleLogStore.getAppender();
				String logText = appender.getBuffer(logChannelId, true).toString();
				KLogServiceImpl kLogServiceImpl=(KLogServiceImpl)applicationcontext.getBean(KLogServiceImpl.class);
				RLog rlog = new RLog();
				rlog.setIdLog(rjob.getIdJob());
				rlog.setName(rjob.getName());
				rlog.setIdLoglevel(5);
				rlog.setStartDate(jobStartDate);
				rlog.setStopTime(jobStopDate);
				rlog.setLogContent(logText);
				kLogServiceImpl.insertlog(rlog);
			}
		}
	}

}
