package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

public class Test {
	// Field descriptor #21 I
	  public static final int HAS_EXPIRED_GOODS = 1;
	  
	  // Field descriptor #21 I
	  public static final int HAS_EXPIRE_GOODS = 2;
	  
	  // Field descriptor #21 I
	  public static final int HAS_RECOGNIZED_GOODS = 3;
	  
	  // Field descriptor #21 I
	  public static final int NO_RECOGNIZED_GOODS = 4;
	public static void main(String[] args) throws ClassNotFoundException, LinkageError {
		/*Class<?> parent = ClassUtils.forName("test.bean.Parent", Parent.class.getClassLoader());
		System.out.println(JSON.toJSON(parent));
		
		BeanUtils.instantiate(parent);
		
		System.out.println(JSON.toJSON(parent));*/
		
		/*List<Person> list = new ArrayList<Person>();
		for(long i = 0; i < 3; i++) {
			Person person = new Person();
			person.setId(i);
			person.setName("zhang" + i);
			list.add(person);
		}
		
		for(Person person : list) {
			System.out.print(person.getName());
		}
		
		for(Person person : list) {
			person.setName(person.getName() + 1);
		}
		
		for(Person person : list) {
			System.out.print(person.getName());
		}*/
		
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list = list.subList(0, 2);
		for(Integer i : list) {
			System.out.println(i);
		}
		Long a = 1L;
		Long b = 1L;
		if(a.equals(b)) {
			System.out.println("true");
		}
		
		if(a == b) {
			System.out.println("false");
		}*/
		
		/*Set<Integer> set = new HashSet<Integer>();
		set.add(4);
		set.add(2);
		set.add(3);
		set.add(4);
		for(Integer i : set) {
			System.out.println(i);
		}*/
		
		
		//溢出回绕
		/*System.out.println("Integer Min Value : " + Integer.MIN_VALUE);
		System.out.println("Integer Max Value : " + Integer.MAX_VALUE);
		System.out.println("Integer Max Value Plus 1 : " + (Integer.MAX_VALUE + 1));*/
		
		/*List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			list.add(i);
		}
		list = list.subList(0, 5);
		
		list.addAll(list);

		System.out.println(list.toString());
		
		Random random = new Random();
		System.out.println(random.nextInt(2));
		
		String fid = "146684896683847979";
		
		System.out.println(Long.getLong(fid));
		
		String dateStr = "Fri Jun 24 17:07:54 CST 2016";
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		
		try {
			Date date = (Date) sdf.parse(dateStr);
			
			String formatStr = new SimpleDateFormat("yyyy/MM/dd").format(date);
			
			System.out.println(formatStr);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = "JDSmartFridge/01 (Android; 4.4; zh-cn; Midea BCD-280WTGPZM/RK3066;1280*800)";
		
		System.out.println(StringUtils.contains(str, "JDSmartFridge/01"));*/
		
		/*List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i < 5; i ++) {
			list.add(i);
		} 
		List<Integer> list1 = new ArrayList<>();
		list1 = list;
		
		System.out.println(list.indexOf(0));
		
		System.out.println(list.toString());
		
	

		
		list1.remove(0);
		
		System.out.println(list.toString());*/
		/*String str = null;
		Integer a = Integer.parseInt(str);
		System.out.println(a);
		
		Integer aa = 123;*/
		
		
		
		/*Integer disPlayType = 2;
		int type = disPlayType;
		
		
		if(HAS_EXPIRED_GOODS == type) {
			System.out.println(0);
		} else if(HAS_EXPIRE_GOODS == type) {
			System.out.println(1);
		} else {
			System.out.println(3);
		}*/
		
		
		
	} 
}
