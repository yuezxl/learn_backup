package zxl.learn.course.boot;

import java.util.List;

import lombok.Data;

@Data
public class CourseResponse {
	private List<CourseInfo> courseInfos;
}
