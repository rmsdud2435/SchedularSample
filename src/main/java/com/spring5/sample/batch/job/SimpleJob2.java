package com.spring5.sample.batch.job;

import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.spring5.sample.batch.service.SimpleService;

public class SimpleJob2 extends QuartzJobBean{

	private static final Logger logger = LoggerFactory.getLogger(SimpleJob2.class);
	
	private SimpleService simpleService;
	
	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException{
		
			try {
				if(!isJobRunning(jobexecutioncontext, jobexecutioncontext.getJobDetail().getKey().getName())){			
					excuteBatch();
				}
			} catch (SchedulerException e) {
				logger.error("Error ocured during Checking while Job is Running");
			}
	}
	
	private void excuteBatch(){
		logger.info("Batch Start");
		try {
			simpleService.sleepFor10seconds();
		} catch (InterruptedException e) {
			logger.error("Error ocured during job logic excuting");
		}
		logger.info("Batch End");
	}
	
	private boolean isJobRunning(JobExecutionContext ctx, String jobName) throws SchedulerException{
		
		List<JobExecutionContext> currentJobs = ctx.getScheduler().getCurrentlyExecutingJobs();
		
	    for (JobExecutionContext jobCtx : currentJobs) {
	        String thisJobName = jobCtx.getJobDetail().getKey().getName();
	        if (jobName.equalsIgnoreCase(thisJobName) && !jobCtx.getFireTime().equals(ctx.getFireTime())) {
	        	logger.info("Job is already Running!");
	            return true;
	        }
	    }
	    return false;
	}
	
	public SimpleService getSimpleService(){
		return simpleService;
	}
	
	public void setSimpleService(SimpleService simpleService){
		this.simpleService = simpleService;
	}
}
