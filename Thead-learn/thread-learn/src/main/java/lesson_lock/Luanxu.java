package lesson_lock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;

public class Luanxu {
	
	public static  boolean inited = false;
	
	public static int count1 = 0;
	
	static int count0 = 0;
	
	 static int x = 0;
	static int y = 0;
	 static int a = 0;
	static int  b = 0;
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 1000000; i ++) {
			x=0; y=0;a=0;b=0;
			Thread thread1 = new Thread(new Runnable() {
				
				public void run() {
					a = 1;
					x = b;
					
				}
			});
			
			Thread thread2 = new Thread(new Runnable() {
				
				public void run() {
					b = 1;
					y = a;
				}
			});
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
			if(x ==0 && y == 0) {
				System.out.println(i + "--" + 0);
				count0 ++;
			}else if(x == 1 && y == 1) {
				System.out.println("i" + "--" + 1);
				count1 ++;
			}
			map.put(x, y);
		}
		
		System.out.println(JSON.toJSON(map));
		System.out.println("count0:" + count0);
		System.out.println("count1:" + count1);
	}
}
