package com.narratage.reserve.user.dao;

import com.narratage.reserve.user.bean.UserBean;

public interface UserDao
{
  public int duplicateUser(String user_id);
  public UserBean getUserInfo(String user_id);
}