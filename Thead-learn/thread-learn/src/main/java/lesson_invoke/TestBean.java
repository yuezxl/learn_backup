package lesson_invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.Data;

@Data
public class TestBean {
	private int age;
	public String name;
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		TestBean bean1 = new TestBean();
		TestBean.class.getDeclaredField("age").setInt(bean1, 2);
		TestBean.class.getDeclaredField("name").set(bean1, "ccc");
		for(Field filed : TestBean.class.getDeclaredFields()) {
			String name = filed.getName();
			name = name.substring(0, 1).toUpperCase() + name.substring(1); 
			Method m = bean1.getClass().getMethod("get"+name);
			System.out.println(filed.getName() + "---" + m.invoke(bean1));
		}
	}
}
