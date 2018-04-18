package com.zxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.constant.ConstantInfo;
import com.zxl.annotation.RunTime;
import com.zxl.model.Person;
import com.zxl.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonService newPersonService;
	
	@RunTime
	@ResponseBody
	@RequestMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.POST, RequestMethod.GET})
	public Person person(@PathVariable Long id){
		logger.info("method person start ==>");
		Person person = new Person();
		person.setId(id);
		person.setName("zhangsan" + id);
		person.setAddress("zhongguo");
		person.setEmail("zhangsan" + id + "@example.com");
		person.setAge(21 + id.intValue());
		logger.info("method person end ==>");
		return person;
	}
	
	@RunTime
	@RequestMapping(value="index", method=RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
	public String index(Model model, HttpServletRequest request){
		System.out.println(request.getSession().getId());
		List<Person> list = personService.findAll();
		model.addAttribute("list", list);
		System.out.println(list.get(0).getAddress().toString());
		System.out.println(ConstantInfo.VERSION_VALUE);
		
		List<Person> newList = newPersonService.findAll();
		
		System.out.println(JSON.toJSON(newList));
		
		list.addAll(newList);
		
		return "person/index";
	}
}
