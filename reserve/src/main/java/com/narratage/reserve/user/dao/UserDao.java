package com.narratage.reserve.user.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserDao
{
  public int duplicateUser(String user_id);
  public ArrayList getUserInfo(String user_id);
  public Object insertUser(HashMap map);
  public int deleteUser(String user_id);
}