package learn.link_test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

public class StringTest {
	
	public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println(getMostSbuString(str));
	}
	
	private static int getMostSbuString(String str) {
		if(StringUtils.isEmpty(str)) {
			return 0;
		}
		int length = str.length();
		String subStr = null;
		int lay = 0;
		while(lay < length) {
			for(int i=0; i <= lay; i ++) {
				subStr = str.substring(i, length-lay+i);
				if(checkStr(subStr)) {
					System.out.println(subStr);
					return subStr.length();
				}
			}
			lay ++;
		}
		
		return 0;
	}
	
	private static boolean checkStr(String str) {
		char[] data = str.toCharArray();
		Set<String> set = new HashSet<>();
		for(int i = 0; i < data.length; i ++) {
			set.add(String.valueOf(data[i]));
		}
		return set.size() == data.length;
	}
}
