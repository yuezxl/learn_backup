package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.StartUp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartUp.class)
public class JunitTest {
	//启动之前就运行了
	@BeforeClass public static void before() {
		System.out.println("The test will begin!");
	}
	
	@Test public void test1() {
		System.out.println("Test1 is running!");
	}
	
	@Test public void test2() {
		System.out.println("Test2 is running!");
	}
	
	@AfterClass public static void after() {
		System.out.println("The test is over");
	}
}
