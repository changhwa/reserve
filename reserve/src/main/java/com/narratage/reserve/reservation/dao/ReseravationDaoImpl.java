package com.narratage.reserve.reservation.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("reservationDao")
public class ReseravationDaoImpl extends SqlSessionDaoSupport implements ReservationDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	private String nameSpace="com.narratage.reserve.reservation.dao.ReservationDao.";
	
	public ArrayList findAirinformCodeReserve(String airinformCode) {
		
		return (ArrayList) getSqlSession().selectList(nameSpace+"findAirinformCodeReserve", airinformCode);
	}

	public Object insertReserve(HashMap map) {
	
		return getSqlSession().insert(nameSpace+"insertReserve",map);
	}

	public int deleteReserve(String reservationCode) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().delete(nameSpace+"reservationCode",reservationCode);
	}

	public int insertReserve(HashMap map) {
	
		return (Integer) getSqlSession().insert("com.narratage.reserve.reservation.dao.ReservationDao.insertReserve",map);
	}

	public int deleteReserve(String reservationCode) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().delete("com.narratage.reserve.reservation.dao.ReservationDao.reservationCode",reservationCode);
	}

}
