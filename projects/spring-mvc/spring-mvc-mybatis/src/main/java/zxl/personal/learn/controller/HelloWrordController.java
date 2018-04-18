package zxl.personal.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWrordController {
	@ResponseBody
	@RequestMapping("/hello")
	public Object hello() {
		return "Hello World!";
	}
}
