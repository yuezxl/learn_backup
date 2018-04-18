package learn_threadlocal;

public class ThreadLocalTest {
	public static ThreadLocal<Integer> sequence = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return  0;
		}
	};
	
	
	
	public int getNextSequence() {
		sequence.set(sequence.get() + 1);
		return sequence.get();
	}
	
	public static void main(String[] args) {
		/*ThreadLocalTest threadLocalTest = new ThreadLocalTest();
		TestClient t1 = new TestClient(threadLocalTest);
		TestClient t2 = new TestClient(threadLocalTest);
		TestClient t3 = new TestClient(threadLocalTest);
		
		t1.start();
		t2.start();
		t3.start();*/
		
		int HASH_INCREMENT = 0x61c88647;
		System.out.println(HASH_INCREMENT);
		
		int n = 16;
		for(int i = 1; i <=n; i++) {
			int nextHashCode = i * 0x61c88647 + 0x61c88647;
			System.out.print(nextHashCode & (n-1));
			System.out.print(" ");
		}
	}
	
	private static class TestClient extends Thread {
		private ThreadLocalTest threadLocalTest;
		
		public TestClient(ThreadLocalTest threadLocalTest) {
			this.threadLocalTest = threadLocalTest;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 3; i ++) {
				System.out.println("thread[" + Thread.currentThread().getName() + "] ---> sequence[" + threadLocalTest.getNextSequence() + "]" );
			}
		}
	}
}
