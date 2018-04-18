package zxl.learn.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zxl.learn.boot.producer.Producer;

@RestController
public class ProducerController {
	@Autowired
	private Producer producer;
	
	@RequestMapping("producer/create_msg")
	public Object createMessage(String msg, Integer num) {
		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < num; i++) {
			String message = i + "----" + msg;
			producer.send(message);
		}
		
		map.put("code", "0");
		return map;
	}
}
