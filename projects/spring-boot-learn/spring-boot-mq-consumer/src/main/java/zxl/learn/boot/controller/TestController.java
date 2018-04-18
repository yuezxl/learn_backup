package zxl.learn.boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zxl.learn.boot.mysocket.CounterHandler;

@RestController
@CrossOrigin
public class TestController {
	@Autowired
	private CounterHandler counterHandler;
	
	//用请求的方式模拟推送消息的时候
	    @RequestMapping(path="notice", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	    public String notice(String count) {
			counterHandler.sendMessageToUser(count, "当前时间是：" + new Date());
	        return "已发送";
	    }
}
