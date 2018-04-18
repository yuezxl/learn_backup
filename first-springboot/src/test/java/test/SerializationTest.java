package test;

import net.sf.json.util.JSONUtils;

import com.alibaba.fastjson.JSON;
import com.util.SerializationUtil;
import com.zxl.bean.Employee;

public class SerializationTest {
	public static void main(String[] args) {
		/*String fileName = "person.txt";
		Employee person = new Employee();
		person.setAddress("北京");
		person.setAge(20);
		person.setEmail("the@163.com");
		person.setId(1L);
		person.setName("the");
		
		try {
			SerializationUtil.serialize(person, fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Employee personNew = null;
		
		try {
			personNew = (Employee) SerializationUtil.deserialize(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Employee.testId = 10L;
		System.out.println("person Object :" + person);
		System.out.println("personNew Object: " + personNew);
		
		System.out.println(JSON.toJSONString(person));
		System.out.println(JSON.toJSONString(personNew));*/
		
		
		/**
		 * 继承的反序列化
		 */
		/*String fileName = "child.txt";
		Child child = new Child();
		child.setId(1);
		child.setAge(21);
		child.setEmail("@163.com");
		child.setName("haha");
		
		
		try {
			SerializationUtil.serialize(child, fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Child newChild = new Child();
		try {
			newChild = (Child) SerializationUtil.deserialize(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(JSON.toJSONString(child));
		System.out.println(JSON.toJSONString(newChild));
		
		new File(fileName).delete();*/
		
		
		String fileName = "person.txt";
		/*Employee person = new Employee();
		person.setAddress("北京");
		person.setAge(20);
		person.setEmail("the@163.com");
		person.setId(1L);
		person.setName("the");
		
		try {
			SerializationUtil.serialize(person, fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}*/
		
		Employee personNew = null;
		try {
			personNew = (Employee) SerializationUtil.deserialize(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(JSON.toJSONString(personNew));
	}
}
