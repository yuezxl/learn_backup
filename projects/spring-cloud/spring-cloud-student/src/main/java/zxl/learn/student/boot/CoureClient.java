package zxl.learn.student.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class CoureClient {
	
	@Autowired
	private TheClient theClient;
	
	@FeignClient("course")
	interface TheClient {
		@RequestMapping(value = "/api/courses", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
		@ResponseBody
		Object getCourse();
	}
	
	public Object testCourse() {
		return theClient.getCourse();
	}
}
