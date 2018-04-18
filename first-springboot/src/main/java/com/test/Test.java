package com.test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import com.alibaba.fastjson.JSON;
import com.constant.ConstantInfo;
import com.jd.std.ucc.client.ConfClient;
import com.jd.std.ucc.client.client.ConfClientFactory;

public class Test {
	
	public static String version = "0.0.1";
	
	public static void updateVersion(String value) {
		version = value;
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(WebApplicationContext.class.getName());
		
		System.out.println(DispatcherServlet.class.getName());
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-boot.xml");
		System.out.println(ac.getBeanDefinitionCount());
		DispatcherServlet dis = new DispatcherServlet();
		System.out.println(dis.getServletName());
		
		System.out.println(JSON.toJSON(ConstantInfo.VALUE_MAP));
		/*ConfClient confClient = ConfClientFactory.getConfClient();
		//confClient.subscribe(arg0, arg1, arg2, arg3);
		
		String str1 = "1 1 1 2 2 3 4 4 5";
		String str2 = "A B C B D C D E E";
		//每一个转成数组,并且两个数组长度必须一样
		String[] strArr1 = str1.split(" ");
		String[] strArr2 = str2.split(" ");
		
		System.out.println(strArr1.length);
		System.out.println(strArr2.length);
		
		//将对应的数据转成集合
		Map<String, Set<String>> dataMap = new HashMap<String, Set<String>>();
		
		//将两个数组转换成集合
		
		for(int i = 0; i < strArr1.length; i++) {
			Set<String> keySet = dataMap.keySet();
			Set<String> dataSet = new HashSet<>();
			if(null != keySet && keySet.contains(strArr1[i])) {
				dataSet = dataMap.get(strArr1[i]);
				dataSet.add(strArr2[i]);
			} else {
				dataSet.add(strArr2[i]);
			}
			dataMap.put(strArr1[i], dataSet);
		}
		
		System.out.println(JSON.toJSONString(dataMap));
		
		//融合集合的元素，构建一个新的map
		Map<String, Set<String>> newDataMap = new HashMap<String, Set<String>>();
		
		for(String key : dataMap.keySet()) {
			Set<String> keySet = newDataMap.keySet();
			Set<String> dataSet = new HashSet<>();
			if(null == keySet || keySet.size() == 0) {
				dataSet = dataMap.get(key);
				newDataMap.put(key, dataSet);
			} else {
				if(keySet.contains(key)) {
					Set<String> newDataSet = newDataMap.get(key);
					dataSet = dataMap.get(key);
					//求两个元素的并集
					newDataSet.addAll(dataSet);
				} else {
					//判断两个集合是否有交集，如果有交集，则两个集合合并
					Boolean flag = false;
					dataSet = dataMap.get(key);
					for(String newKey : keySet) {
						Set<String> newDataSet = newDataMap.get(newKey);
						if(!Collections.disjoint(newDataSet, dataSet)) {
							newDataSet.addAll(dataSet);
							flag = true;
							newDataMap.put(newKey, newDataSet);
							break;
						}
					}
					
					if(!flag) {
						newDataMap.put(key, dataSet);
					}
				}
			}
			
		}
		System.out.println(JSON.toJSONString(newDataMap));*/
		
	}
}
