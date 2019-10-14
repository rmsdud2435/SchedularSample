package com.spring5.sample.batch.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.spring5.sample.batch.service.SimpleService;

//중복을 방지하기 위한 어노테이션
//@DisallowConcurrentExecution
public class SimpleJob extends QuartzJobBean{

	private static final Logger logger = LoggerFactory.getLogger(SimpleJob.class);
	
	private SimpleService simpleService;
	
	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException{
		
		excuteBatch();
	}
	
	private void excuteBatch(){
		logger.info("Batch Start");
		//simpleService.printHelloWorld();
		try {
			simpleService.sleepFor10seconds();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Batch End");
	}
	
	public SimpleService getSimpleService(){
		return simpleService;
	}
	
	public void setSimpleService(SimpleService simpleService){
		this.simpleService = simpleService;
	}
}
