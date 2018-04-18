package test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class Child extends Parent{
	private String content;

	protected Child(String title, String content) {
		super(title);
		this.content = content;
		out();
	}

	@Override
	public void out() {
		System.out.println("out..." + content);
	}

	public static void main(String[] args) {
		//Parent p = new Child("title", "content");
		//System.out.println(getLongestSubString("abcdsd"));
		
		String[] arr = new String[] {"1","2"};
		String[] arr1 = arr;
		System.out.println(JSONObject.toJSON(arr1));
		
		List<String> l = new ArrayList<>();
		l.add("1");
		List<String> l1 = l;
		l.remove("1");
		System.out.println(JSONObject.toJSON(l1));
	}
	
	private static String getLongestSubString(String str) {
		String subStr = null;
		int[] m = new int[256];
		Arrays.fill(m, -1);
		int res = 0, left = -1;
		for(int i = 0; i < str.length(); i++) {
			left =  Math.max(left, m[str.charAt(i)]);
			m[str.charAt(i)] = i;
			if(res < Math.max(res, i-left)) {
				res = Math.max(res, i-left);
				subStr = str.substring(left+1, i+1);
			}
		}
		
		return subStr;
	}
}
