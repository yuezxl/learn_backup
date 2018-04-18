package org.spring.boot.data.service.impl;

import org.spring.boot.data.dao.UserDao;
import org.spring.boot.data.model.UserModel;
import org.spring.boot.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserModel save(UserModel userModel) {
		return userDao.save(userModel);
	}

}
