package person.zxl.quart_learn.boot.service;

import com.github.pagehelper.PageInfo;

import person.zxl.quart_learn.boot.model.JobAndTrigger;

public interface IJobAndTriggerService {
	PageInfo<JobAndTrigger> getJobAndTriggers(Integer pageNo, Integer pageSize);
}
