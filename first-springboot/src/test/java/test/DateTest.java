package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		/*String date1 = "2016-02-28";
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		  Date date2=new Date();
		  System.out.println(df.format(date2));
		  String date3 = "2016-03-01";
		  long to = df.parse(date1).getTime();
		  Long from = df.parse(date3).getTime();;
		  System.out.println((from - to) / (1000 * 60 * 60 * 24));*/
		/*SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(date.getTime());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,2); 
		String expireDateStr = sdf1.format(cal.getTime());
		System.out.println(expireDateStr);
		Date date2 = sdf1.parse(expireDateStr); 
		System.out.println(date2.getTime());
		
		Long expireTime = date2.getTime() - date.getTime();
		
		System.out.println(expireTime/(60*1000));
		System.out.println(expireTime%(60*1000));
		
		System.out.println((24+4) * 60 + 47);*/
		
		String s = "Thu Jun 30 14:06:54 CST 2016";  
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.UK);  
        DateFormat sdf = new SimpleDateFormat("w D k yyyy-MM-dd a HH:mm:ss");  
        System.out.println(sdf.format(df.parse(s)));  
        
        
	}
}
