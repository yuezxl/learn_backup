package person.zxl.quart_learn.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import person.zxl.quart_learn.boot.model.JobAndTrigger;
import person.zxl.quart_learn.boot.mybatis.AllMapper;

public interface JobAndTriggerDao extends AllMapper<JobAndTrigger>{
	
	@Select("SELECT" + 
			"            qrtz_job_details.JOB_NAME as jobName," + 
			"            qrtz_job_details.JOB_GROUP as jobGroup," + 
			"            qrtz_job_details.JOB_CLASS_NAME as className," + 
			"            qrtz_triggers.TRIGGER_NAME as triggerName," + 
			"            qrtz_triggers.TRIGGER_GROUP as triggerGoup," + 
			"            qrtz_simple_triggers.REPEAT_INTERVAL," + 
			"            qrtz_simple_triggers.TIMES_TRIGGERED" + 
			"        FROM" + 
			"            qrtz_job_details" + 
			"        JOIN qrtz_triggers" + 
			"        JOIN qrtz_simple_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME" + 
			"        AND qrtz_triggers.TRIGGER_NAME = qrtz_simple_triggers.TRIGGER_NAME" + 
			"        AND qrtz_triggers.TRIGGER_GROUP = qrtz_simple_triggers.TRIGGER_GROUP ")
	List<JobAndTrigger> getJobAndTriggerDetails();
}
