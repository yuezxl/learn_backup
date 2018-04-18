package test;

import org.springframework.scheduling.annotation.Async;

public class AsyncTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("++++++++++++++++++++++");
		test();
		System.out.println("++++++++++++++++++++++");
	}
	
	@Async
	private static void test() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("-------------------------");
	}
}
