package com.narratage.reserve.user.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public int duplicateUser(String user_id) {
		return (Integer) getSqlSession().selectOne("com.narratage.reserve.user.dao.UserDao.duplicateUser", user_id);
	}

	public ArrayList getUserInfo(String user_id) {
		// TODO Auto-generated method stub
		return (ArrayList) getSqlSession().selectList("com.narratage.reserve.user.dao.UserDao.getUserInfo", user_id);
	}

	public Object insertUser(HashMap map) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("com.narratage.reserve.user.dao.UserDao.insertUser", map);
	}

	public int deleteUser(String user_id) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().delete("com.narratage.reserve.user.dao.UserDao.deleteUser", user_id);
	}

}