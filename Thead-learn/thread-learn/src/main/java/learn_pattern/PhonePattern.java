package learn_pattern;

import java.util.regex.Pattern;

public class PhonePattern {
	public static void main(String[] args) {
		// 1(3,4,5,7,8) 后面9为数字
		Pattern pettern = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{8}$");
		String phone = "1860083823";
		System.out.println(pettern.matcher(phone).find());
		
		String str2 = "2314fjkweljnfne";
		Pattern p2 = Pattern.compile("\\d{3}\\w+");
		System.out.println(p2.pattern());
		System.out.println("p2 " + p2.matcher(str2).find());
	}
}
