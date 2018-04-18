package com.zxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxl.dao.UserDao;
import com.zxl.model.User;
import com.zxl.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public Boolean checkUser(User user) {
		if(null == userDao.getUser(user)) {
			return false;
		} else {
			return true;
		}
	}

}
