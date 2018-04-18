package test;

import java.util.HashMap;
import java.util.Map;

import sun.org.mozilla.javascript.internal.json.JsonParser;

public class Test {
	public static void main(String[] args) {
		int index = 5; 
		index = index << 1;
		System.out.println(index);
		
		int index2 = 15;
		index2 = index2 >> 1;
		System.out.println(index2);
		
		
		int num = 10;
		int n = 1;
		
		while(n <= num) {
			n = n << 1;
		}
		
		System.out.println(n);
		
		int m = n >> 1;
			System.out.println(m);
			
		Map<String, Object> map = new HashMap<String, Object>();
		
		A[] arr = new A[5];
		for(int i = 0; i < 5; i ++) {
			A a = new A(i, i + 1);
			arr[i] = a;
		}
		 
		for(A a : arr) {
			System.out.println(a.toString());
		}
		
		for(A a : arr) {
			A a2 = new A(10, 10);
			a = a2;
		}
		
		System.out.println("-----------");
		for(A a : arr) {
			System.out.println(a.toString());
		}
	}
	
	static class A {
		int a;
		int b;
		A(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public void setA(int a) {
			this.a = a;
		}
		
		public String toString() {
			return "a:" + a + ",b:" + b;
		}
	}
}
