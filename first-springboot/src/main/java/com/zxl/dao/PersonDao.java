package com.zxl.dao;

import java.util.List;

import com.zxl.model.Person;


public interface PersonDao {
	int insert(Person person);
	
	int update(Person person);
	
	List<Person> findPerson();
	
	int deleteById(Long id);
}
