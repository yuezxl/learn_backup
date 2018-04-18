package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式测试
 * 
 * @author zhangxiaoliang
 * 
 */
public class PatternTest {
	private static final String REGEX = "\\bcat";
	private static final String INPUT = "cat cat cat cattie cat";
	
	private static final String MOBILE_REGES = "";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT); // 获取 matcher 对象

		int count = 0;

		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m.start());
			System.out.println("end(): " + m.end());
		}
	}
}
