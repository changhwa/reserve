package com.narratage.reserve.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narratage.reserve.user.bean.UserBean;
import com.narratage.reserve.user.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public boolean duplicateUser(String user_id) {
		int flag = userDao.duplicateUser(user_id);
		if(flag == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public List<UserBean> getAllUsersInfo(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList getUserInfo(String user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserInfo(user_id);
	}

	public boolean updateUser(String user_id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(String user_id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public int insertUser(HashMap map) {
		// TODO Auto-generated method stub
		userDao.insertUser(map);
		return 0;
	}
	
}
