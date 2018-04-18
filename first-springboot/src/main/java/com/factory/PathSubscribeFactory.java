package com.factory;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.constant.ConstantInfo;
import com.jd.std.ucc.client.ConfClient;
import com.jd.std.ucc.client.client.ConfClientFactory;
import com.jd.std.ucc.client.event.PathListener;

public class PathSubscribeFactory  {
	
	private static ConfClient confClient = ConfClientFactory.getConfClient();
	
	@Value("${application.version}")
	private String token;
	
	private PathListener pathListener;
	
	@PostConstruct
	public void subcrible() {
		try {
			//PathListener pathListener = new PathListenerImpl();
			
			Map<String, String> map = confClient.getPathValues(ConstantInfo.SUBSCRIBE_PATH, ConstantInfo.PATH_READ_TOKEN);
			
			System.out.println(JSON.toJSON(map.keySet()));
			
			confClient.subscribePath(ConstantInfo.SUBSCRIBE_PATH, ConstantInfo.PATH_READ_TOKEN, pathListener);
			System.out.println(">>>>>>>>>>>>>订阅路径 " + ConstantInfo.SUBSCRIBE_PATH + " 成功");
		}catch (Exception e) {
			try{
				confClient.removeSubPath(ConstantInfo.SUBSCRIBE_PATH, ConstantInfo.PATH_READ_TOKEN);
			} catch (Exception ex) {
				System.out.println("取消订阅路径" + ConstantInfo.SUBSCRIBE_PATH + ex);
			}
			
			System.out.println("订阅路径 " + ConstantInfo.SUBSCRIBE_PATH + " EX" + e);
		}
		System.out.println("执行PathSubscribeFactory");
	}

	public PathListener getPathListener() {
		return pathListener;
	}

	public void setPathListener(PathListener pathListener) {
		this.pathListener = pathListener;
	}
}
