package org.spring.boot.data.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.StartUp;
import org.spring.boot.data.model.UserModel;
import org.spring.boot.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@SpringBootTest(classes=StartUp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void save() {
		UserModel userModel = new UserModel();
		userModel.setName("xixiix");
		userModel.setAge(20);
		userModel.setAddress("xixixixi");
		UserModel result = userService.save(userModel);
		System.out.println(JSON.toJSON(result));
	}
}
