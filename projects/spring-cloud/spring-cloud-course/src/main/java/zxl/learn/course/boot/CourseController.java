package zxl.learn.course.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class CourseController {
	
	public static Map<Long, CourseInfo> coureseMap = new HashMap<Long, CourseInfo>();
	
	static {
		for(Long i = 0L; i < 10; i++) {
			CourseInfo courseInfo = new CourseInfo(i, "课程" + i, i.intValue());
			coureseMap.put(i, courseInfo);
		}
	}
	
	@RequestMapping(value = "/api/courses", method = RequestMethod.GET, produces ={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Object getCourses() {
		CourseResponse courseResponse = new CourseResponse();
		List<CourseInfo> courses = new ArrayList<CourseInfo>();
		
		for(Long id : coureseMap.keySet()) {
			CourseInfo courseInfo = coureseMap.get(id);
			courses.add(courseInfo);
		}
		courseResponse.setCourseInfos(courses);
		return courseResponse;
	}
}
