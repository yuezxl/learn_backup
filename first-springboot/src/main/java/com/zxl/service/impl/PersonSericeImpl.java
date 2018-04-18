package com.zxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.std.ucc.client.ConfClient;
import com.jd.std.ucc.client.client.ConfClientFactory;
import com.jd.std.ucc.client.event.ConfListener;
import com.zxl.dao.PersonDao;
import com.zxl.model.Person;
import com.zxl.service.PersonService;



@Service("personService")
public class PersonSericeImpl implements PersonService {
	
	private ConfClient confClient = ConfClientFactory.getConfClient();
	
	@Autowired
	private PersonDao personDao;

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personDao.findPerson();
	}

	@Override
	public void updateConfig(String value) throws Exception {
		ConfListener confListener = new ConfListenerImpl();
		confClient.updateConfValue("/cdrd/ka/dht2", "uenGfjH4", "redisClient", value);
		confClient.subscribe("/cdrd/ka/dht2", "nCK0Fl3b", "redisClient", confListener);
		
		System.out.println("success");
	}
	
}
