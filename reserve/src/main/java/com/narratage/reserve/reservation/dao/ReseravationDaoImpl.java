package com.narratage.reserve.reservation.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("reservationDao")
public class ReseravationDaoImpl extends SqlSessionDaoSupport implements ReservationDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public ArrayList findAirinformCodeReserve(String airinformCode) {
		
		return (ArrayList) getSqlSession().selectList("com.narratage.reserve.reservation.dao.ReservationDao.findAirinformCodeReserve", airinformCode);
	}

}
