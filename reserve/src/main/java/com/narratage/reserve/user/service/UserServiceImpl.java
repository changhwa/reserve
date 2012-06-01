package com.narratage.reserve.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narratage.reserve.user.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public boolean duplicateUser(String id) {
		int flag = userDao.duplicateUser(id);
		if(flag ==0){
			return false;
		}
		else{
			return true;
		}
	}

}
