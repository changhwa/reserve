package com.narratage.reserve.flightinformation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narratage.reserve.flightinformation.domain.Airport;

@Repository("airportDao")
public class AirportDaoMybatis extends SqlSessionDaoSupport implements
		AirportDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Airport getAirportInfo(String IATA) {
		//return (Airport) getSqlSession().selectOne("flightinformation.getAirport", IATA);
		return null;
	}

	public void updatePlusOneAtQueriedNumber(String IATA) {
	}
	
	public List<Airport> getAirports4Map(double topLeftLat, double topLeftLong,
			double botRightLat, double botRightLong, int MaximumCitiesNumber) {
		// TODO Auto-generatded method stub
		return null;
	}

}
