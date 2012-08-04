package com.narratage.reserve.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.narratage.reserve.user.bean.UserBean;

public interface UserService {
	
	/**
	 * @param user_id
	 * @return
	 */
	public boolean duplicateUser(String user_id);
	
	/**
	 * @param user_id
	 * @return
	 */
	public List<UserBean> getAllUsersInfo(String user_id);
	public ArrayList getUserInfo(String user_id);
	public int insertUser(HashMap map);
	public boolean updateUser(String user_id, String password);
	public boolean deleteUser(String user_id, String password);
}
