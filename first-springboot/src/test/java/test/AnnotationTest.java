package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.StartUp;
import com.zxl.annotation.RunTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartUp.class)
public class AnnotationTest {
	
	@Test
	@RunTime
	public void test() {
		for(int i = 0; i < 10; i ++) {
			System.out.println(i + "---");
		}
	}
}
