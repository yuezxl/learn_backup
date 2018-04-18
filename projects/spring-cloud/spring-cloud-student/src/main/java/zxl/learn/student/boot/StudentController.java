package zxl.learn.student.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private CoureClient client;
	
	@RequestMapping(path = "/student/course", method=RequestMethod.GET)
	public Object findCourse() {
		return client.testCourse();
	}
	
}
