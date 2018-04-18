package person.zxl.quart_learn.boot.job.impl;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import person.zxl.quart_learn.boot.job.BaseJob;

public class NewJob implements BaseJob {
	
	private Logger logger = LoggerFactory.getLogger(NewJob.class);
	
	public NewJob() {
		
	}

	public void execute(JobExecutionContext content) throws JobExecutionException {
		 logger.error("New Job÷¥–– ±º‰: " + new Date()); 
		
	}
}
