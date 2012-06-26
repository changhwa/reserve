package com.narratage.reserve.flightinformation.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narratage.reserve.flightinformation.domain.AirlineSchedule;

@Repository("airlineScheduleDao")
public class AirlineScheduleDaoMybatis implements AirlineScheduleDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public List<AirlineSchedule> getFromAirportAirlineScheduleList(String fromAirpotIATA, Date fromArriveTime,
			Date toArriveTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AirlineSchedule> getToAirportAirlineScheduleList(String toAirportIATA, Date fromArriveTime,
			Date toArriveTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AirlineSchedule> getFromAirportToAirportAirlineScheduleList(String fromAirportIATA,
			String toAirportIATA, Date fromArriveTime, Date toArriveTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
