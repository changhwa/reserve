package com.narratage.reserve.user.service;

import java.util.List;

import com.narratage.reserve.user.bean.*;

public interface UserService {
	
	public boolean duplicateUser(String user_id);
	public List<UserBean> selectAllUsers(UserBean user);
	public UserBean selectUser(UserBean user);
	public int updateUser(String user_id, String password);
	public int deleteUser(String user_id, String password);

}
