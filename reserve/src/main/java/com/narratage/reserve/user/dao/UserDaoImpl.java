package com.narratage.reserve.user.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public int userCount() {
		return (Integer) getSqlSession().selectOne("com.narratage.reserve.user.dao.UserDao.userCount");
			
	}

}