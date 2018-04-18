package com.zxl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zxl.model.Person;
import com.zxl.service.PersonService;

@Service("newPersonService")
public class NewPersonSericeImpl implements PersonService{

	@Override
	public List<Person> findAll() {
		Person person = new Person();
		person.setAge(55);
		person.setEmail("gfasdgeaqg");
		person.setName("dsfafeawg");
		List<Person> list = new ArrayList<>();
		list.add(person);
		return list;
	}

	@Override
	public void updateConfig(String value) throws Exception {
		
	}

}
