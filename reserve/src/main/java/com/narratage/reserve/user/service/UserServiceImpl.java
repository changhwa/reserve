package com.narratage.reserve.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narratage.reserve.user.bean.UserBean;
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

	public List<UserBean> selectAllUsers(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserBean selectUser(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateUser(String user_id, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteUser(String user_id, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

}
