package person.zxl.quart_learn.boot.job.impl;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import person.zxl.quart_learn.boot.job.BaseJob;

public class HelloJob implements BaseJob{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public HelloJob() {
		
	}

	public void execute(JobExecutionContext content) throws JobExecutionException {
		logger.info("hello Job Ö´ÐÐÊ±¼ä {}", new Date());
	}
	
	

}
