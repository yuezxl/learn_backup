package lesson_lock;

public class VolatileTest {
	public static volatile int count = 0;
	
	public static void increase() {
		count++;
	}
	
	public static void main(String[] args) {
		int num = 20;
		Thread[] threads = new Thread[num];
		for(int i = 0; i < num; i ++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					for(int j = 0; j < 10000; j++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		while(Thread.activeCount() > 1)
			Thread.yield();
		
		System.out.println(count);
	}
}	
