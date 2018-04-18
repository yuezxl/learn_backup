package com.test;

public class StaticTest {
	public static void main(String[] args) {
		System.out.println(Test.version);
		Test.updateVersion("0.0.2");
		System.out.println(Test.version);
		Test.version = "0.0.3";
		System.out.println(Test.version);
	}
}
