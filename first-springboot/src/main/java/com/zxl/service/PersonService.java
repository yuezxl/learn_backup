package com.zxl.service;

import java.util.List;

import com.zxl.model.Person;


public interface PersonService {
	List<Person> findAll();
	
	void updateConfig(String value) throws Exception;
}
