package person.zxl.quart_learn.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import person.zxl.quart_learn.boot.dao.JobAndTriggerDao;
import person.zxl.quart_learn.boot.model.JobAndTrigger;
import person.zxl.quart_learn.boot.service.IJobAndTriggerService;

@Service("iJobAndTriggerService")
public class JobAndTriggerService implements IJobAndTriggerService {
	
	@Autowired
	private JobAndTriggerDao jobAndTriggerDao;
	
	public PageInfo<JobAndTrigger> getJobAndTriggers(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		
		List<JobAndTrigger> resultList = jobAndTriggerDao.getJobAndTriggerDetails();
		return new PageInfo<JobAndTrigger>(resultList);
	}

}
