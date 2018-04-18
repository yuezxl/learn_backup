package com.zxl.service.impl;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.constant.ConstantInfo;
import com.jd.std.ucc.client.event.PathListener;

public class PathListenerImpl implements PathListener {

	@Override
	public void exceptionCaught(Throwable cause) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleConfig(Map<String, String> pathConfig) {
		System.out.println("++++++++++++++++++++++++++");
		System.out.println(JSON.toJSONString(pathConfig));
		
		String properties = pathConfig.get("properties");
		
		JSONObject proJson = JSONObject.parseObject(properties);
		
		String version = proJson.getString("staticVersion");
		
		ConstantInfo.VERSION_VALUE = version;
		
		System.out.println("staticVersion:" + ConstantInfo.VERSION_VALUE);
		System.out.println("++++++++++++++++++++++++++");
	}

}
