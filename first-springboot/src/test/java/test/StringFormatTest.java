package test;

import java.net.URLEncoder;

public class StringFormatTest {
	
	public static void main(String[] args) {
		String str = "http://diviner.jd.local/diviner?p=619030&uuid=69021425&sku=&skus=&pin=%s&c1=&c2=&c3=&lid=%s&lim=%s&sp=&hi=&fe=&fne=&ro=&ec=utf-8";
		String userPin = "王苇杭mmm";
		String areaId = "18";
		String count = "18";
		String url = String.format(str, userPin, areaId, count);
		
		System.out.println(url);
		
		String str1 = "http://diviner.jd.local/diviner?p=619030&uuid=69021425&sku=&skus=&pin=%s&c1=&c2=&c3=&lid=%s&lim=%s&sp=&hi=&fe=&fne=&ro=&ec=utf-8";
		try {
			userPin = URLEncoder.encode(userPin, "utf-8");
		}catch(Exception e) {
			
		}
		String url1 = String.format(str1, userPin, areaId, count);
		System.out.println(url1);
	}

}
