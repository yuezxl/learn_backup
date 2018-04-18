package org.spring.boot.data.demo.test;

import java.io.Serializable;

public class TestBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String pro1;
	
	public String pro2;
	
	public static Integer pro3;
	
	public Integer add(Integer a, Integer b) {
		System.out.println("---");
		return a + b;
	}
	
	public static String concat(String a, String b) {
		return a + b;
	}

	public String getPro1() {
		return pro1;
	}

	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}

	public String getPro2() {
		return pro2;
	}

	public void setPro2(String pro2) {
		this.pro2 = pro2;
	}

	public static Integer getPro3() {
		return pro3;
	}

	public static void setPro3(Integer pro3) {
		TestBean.pro3 = pro3;
	}

}
