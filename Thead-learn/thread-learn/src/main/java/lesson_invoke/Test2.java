package lesson_invoke;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("age1" + Test1.age);
		System.out.println("age2" + Test1.age);
		FutureTask<Integer> futrue = new FutureTask<Integer>(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				for(int i =0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
		}, 1);
		futrue.run();
		System.out.println(futrue.get());
	}
	
}
