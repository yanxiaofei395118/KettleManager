	package com.gdp.km.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.beans.factory.annotation.Autowired;

public class QuartzListener implements JobListener{
	@Autowired
	private QuartzManager quartzmanager;
	
	@Override
	public String getName() {
		return new Date().getTime() + "QuartzListener";
	}
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
	}
	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
	}
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		String jobName = context.getJobDetail().getKey().getName();
		String jobGroupName = context.getJobDetail().getKey().getGroup();
		String triggerName = context.getTrigger().getKey().getName();
		String triggerGroupName = context.getTrigger().getKey().getGroup();
		//一次性任务，执行完之后需要移除
		quartzmanager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
	}
}
