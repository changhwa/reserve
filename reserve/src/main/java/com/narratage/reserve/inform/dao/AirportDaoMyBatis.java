package com.narratage.reserve.inform.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narratage.reserve.inform.domain.Airport;

@Repository("AirportDao")
public class AirportDaoMyBatis extends SqlSessionDaoSupport implements AirportDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Airport get(String IATA) {
		return (Airport) getSqlSession().selectOne(InformConst.PATH + "AirportDao.get", IATA);
	}

	public void updatePlusOneAtQueriedNumber(String IATA) {
		getSqlSession().update(InformConst.PATH + "AirportDao.get.updatePlusOneAtQueriedNumber", IATA);
	}

	public List<Airport> getAirports4Map(double topLeftLat, double topLeftLong, double botRightLat,
			double botRightLong, int MaximumCitiesNumber) {
		throw new RuntimeException("not yet realized");
	}

	public void add(Airport airport) {
		getSqlSession().insert(InformConst.PATH + "AirportDao.get", airport);
	}

}
