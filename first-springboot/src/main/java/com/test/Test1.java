package com.test;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("n=" + test(32,60,10800D, 12000D));
	}
	
	public static int test(int beginAge, int getAge, Double money, Double getMoney) {
		Double returnMoney = money*0.2;
		Double result = 0D;
		int age = 0;
		while(result >= 0) {
			beginAge = beginAge + 1;
			if(beginAge < getAge) {
				result = result + result * 0.05 + returnMoney + returnMoney*0.05;
			} else {
				result = result + result * 0.05 + returnMoney + returnMoney*0.05 - getMoney;
				if(result > 0) {
					age = age + 1;
				}
			}
		}
		return age;
	}
}
