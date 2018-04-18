package zxl.learn.course.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StartUp extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}
}
