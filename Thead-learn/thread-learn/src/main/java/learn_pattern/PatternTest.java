package learn_pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

public class PatternTest {
	public static void main(String[] args) {
		String str1 = "this is   a   string";
		Pattern p1 = Pattern.compile("\\s+");
		
		String[] strarr = p1.split(str1);
		System.out.println(JSONObject.toJSON(strarr));
		System.out.println(p1.pattern());
		Matcher m1 =p1.matcher(str1);
		System.out.println(m1.find());
	}
}
