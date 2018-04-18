package com.zxl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.constant.ConstantInfo;

@Controller
public class Index {
	
	@Value(value="${application.version}")
	private String version;
	
	@RequestMapping({"/","login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping("index")
	public String index() {
		System.out.println(ConstantInfo.VERSION_VALUE);
		System.out.println(version);
		ConstantInfo.updateVersion(version);
		System.out.println(ConstantInfo.VERSION_VALUE);
		//ContantInfo.updateVersion("0.0.2");
		//System.out.println(ContantInfo.VERSION_VALUE);
		return "index";
	}
}
