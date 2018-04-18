package org.spring.boot.data.demo.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		TestBean bean1 = new TestBean();
		bean1.setPro2("hah");
		
		Class bean1Class = bean1.getClass();
		Field filed = bean1Class.getField("pro2");
		
		System.out.println(filed.getName());
		System.out.println(filed.get(bean1));
		
		Method method = bean1Class.getMethod("add", new Class[] {Integer.class, Integer.class});
		
		Object object = method.invoke(bean1, new Object[] {1, 2});
		System.out.println(object);
		
		Method method2 = bean1Class.getMethod("concat", new Class[] {String.class, String.class});
		Object object2 = method2.invoke(null, new String[] {"dsa", "dasfd"});
		
		System.out.println(object2);
		
		
		Class newBeanClass = Class.forName("org.spring.boot.data.demo.test.TestBean");
		System.out.println(newBeanClass);
		
		TestBean newBean = (TestBean) newBeanClass.newInstance();
		newBean.setPro1("1");
		newBean.setPro3(2);
		
	}
}
