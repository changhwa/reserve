package com.narratage.reserve.user.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narratage.reserve.user.bean.UserBean;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public int duplicateUser(String user_id) {
		return (Integer) getSqlSession().selectOne("com.narratage.reserve.user.dao.UserDao.duplicateUser", user_id);
	}

	public UserBean getUserInfo(String user_id) {
		// TODO Auto-generated method stub
		return (UserBean) getSqlSession().selectOne("com.narratage.reserve.user.dao.UserDao", user_id);
	}

}