package org.spring.learn.bean;

public class TestCode {

	private static TestCode singleTon = new TestCode();
	public static int count1;
	public static int count2 = 0;

	private TestCode() {
		count1++;
		count2++;
	}

	public static TestCode getInstance() {
		return singleTon;
	}
	
	public static void change() {
		count2 = 4;
	}

	public static void main(String[] args) {
		TestCode singleTon = TestCode.getInstance();
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);
		
		change();
		
		System.out.println("count2=" + singleTon.count2);
	}
}