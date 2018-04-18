package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	Logger logger = LoggerFactory.getLogger(SimpleController.class);
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		if(logger.isInfoEnabled()){
			logger.info("SimpleController.hello == > hello");
		}
		return "hello world";
	}
}
