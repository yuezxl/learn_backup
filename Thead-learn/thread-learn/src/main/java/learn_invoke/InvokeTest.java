package learn_invoke;

import java.lang.reflect.Field;

import learn_invoke.bean.TestBean;

public class InvokeTest {
	public static void main(String[] args) {
		Class<TestBean> beanClass = TestBean.class;
		
		Field[] fields = beanClass.getFields();
		
		for(Field field : fields) {
			System.out.println(field);
		}
	}
}
