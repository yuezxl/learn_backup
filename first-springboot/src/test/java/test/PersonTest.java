package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.annotation.TestLog;
import com.spring.StartUp;
import com.zxl.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {StartUp.class})
public class PersonTest {
	@Autowired
	private PersonService personService;
	
	@Test
	public void updateConfig() throws Exception {
		//personService.updateConfig("jimClientBk");
		System.out.println("++++");
		test();
		System.out.println("++++");
	}
	
	@Async
	private void test() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("-------------------------");
	}
}
