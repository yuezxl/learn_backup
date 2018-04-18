package zxl.personal.learn.controller;



public class Test {
	public static void main(String[] args) {
		for(int i = 1; i < 20; i++) {
			System.out.println(i + "ÔÂ---- " + getCount(i));
		}
	}
	
	
	public static int getCount(int n) {
		//µÍ1¡¢2ÔÂ
		if(n <= 2) {
			return 1;
		}
		
		if(n > 2) {
			return getCount(n-1) + getCount(n-2);
		}
		return 0;
	}
}
