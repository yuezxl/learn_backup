package person.zxl.quart_learn.boot.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobAndTrigger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jobName;
	private String jobGroup;
	private String className;
	private String triggerName;
	private String triggerGroup;
	private String timesTriggerd;

}
