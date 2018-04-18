package com.zxl.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@ResponseBody
	@RequestMapping(value = "/test.json", method = {RequestMethod.POST, RequestMethod.GET})
	public Object test(HttpServletRequest request, HttpServletResponse response) {
		String  str = "test";
		try {
			InputStream is = request.getInputStream();
			str = IOUtils.toString(is);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test("hello world");
		
		return str;
	}
	
	public void test(String param) {
		System.out.println("test ---------" + param);
	}
}
