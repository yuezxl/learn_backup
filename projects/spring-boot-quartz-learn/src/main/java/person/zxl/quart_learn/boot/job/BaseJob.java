package person.zxl.quart_learn.boot.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface BaseJob extends Job{
	void execute(JobExecutionContext content) throws JobExecutionException;
}
