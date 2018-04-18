package zxl.learn.course.boot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class CourseInfo {
	private Long id; //课程ID
	private String courseName; // 课程名称
	private Integer courseScore; // 学分
}
