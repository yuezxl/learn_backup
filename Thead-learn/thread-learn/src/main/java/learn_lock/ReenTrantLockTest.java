package learn_lock;

import java.util.Hashtable;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockTest extends Thread{
	public static int count = 1;
	
	public static ReentrantLock lock = new ReentrantLock();
	
	public ReenTrantLockTest(String name) {
		super.setName(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100000; i++) {
			lock.lock();
			try {
				System.out.println(this.getName() + " " + count);
				count++;
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		/*ReenTrantLockTest test1 = new ReenTrantLockTest("Thread1");
		ReenTrantLockTest test2 = new ReenTrantLockTest("Thread2");
		
		ReentrantLock reentrantLock = new ReentrantLock();
		// 独占锁
		reentrantLock.lock();
		try {
			// do something
		} finally {
			// 释放锁
			reentrantLock.unlock();
		}
		
		test1.start();
		test2.start();
		System.out.println(count);*/
		
		//ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		//System.out.println(1 << 30);
		//String a = "a";
//		
//		Integer h = 2^17;
//		//System.out.println(h.toBinaryString(32));
//		
//		System.out.println( 1 ^ 3);
//		
//		//HashSet<Integer> set = new HashSet<Integer>();
//		Hashtable<String, String> table = new Hashtable<String, String>();
	}
}
