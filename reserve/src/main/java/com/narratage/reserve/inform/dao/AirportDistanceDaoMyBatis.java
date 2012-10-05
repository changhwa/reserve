package com.narratage.reserve.inform.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narratage.reserve.inform.domain.AirportDistance;

@Repository("AirportDistanceDao")
public class AirportDistanceDaoMyBatis extends SqlSessionDaoSupport implements AirportDistanceDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public double get(String IATA01, String IATA02) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("firstAirprot", IATA01);
		paramMap.put("secondAirport", IATA02);
		return (Double) getSqlSession().selectOne(InformConst.PATH + "AirportDistance.get", paramMap);
	}

	public void add(AirportDistance airportDistance) {
		getSqlSession().insert(InformConst.PATH + "AirportDistance.add", airportDistance);
	}

}