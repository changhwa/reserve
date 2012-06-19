package com.narratage.reserve.airplane.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("seatDao")
public class SeatDaoImpl extends SqlSessionDaoSupport implements SeatDao{

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public String findSeat(String airinformCode) {
		
		return (String) getSqlSession().selectOne("com.narratage.reserve.airplane.dao.SeatDao.findSeat", airinformCode);
	}

}
