package com.narratage.reserve.inform.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narratage.reserve.inform.datatype.AirportType;
import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;
import com.narratage.reserve.inform.domain.Airport;

@Repository("AirlineScheduleDao")
public class AirlineScheduleDaoMyBatis extends SqlSessionDaoSupport implements AirlineScheduleDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmm");

	@SuppressWarnings("unchecked")
	public List<AirlineSchedule> get(AirportType airportType, DateType dateType, String airportIATA, Date beginDate,
			Date endDate) {
		HashMap<String, String> scheduleMap = new HashMap<String, String>();
		scheduleMap.put("airportType", airportType.getSqlColName());
		scheduleMap.put("dateType", dateType.getSqlColName());
		scheduleMap.put("iata", airportIATA);
		scheduleMap.put("beginDate", dateFormat.format(beginDate));
		scheduleMap.put("endDate", dateFormat.format(endDate));

		return (List<AirlineSchedule>) getSqlSession().selectList(
				InformConst.PATH + "AirlineSchedule.getWithSingleAirport", scheduleMap);
	}

	@SuppressWarnings("unchecked")
	public List<AirlineSchedule> get(DateType dateType, String takeOffAirport, String landingAirport, Date beginDate,
			Date endDate) {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmmss");
		HashMap<String, String> scheduleMap = new HashMap<String, String>();
		scheduleMap.put("dateType", dateType.getSqlColName());
		scheduleMap.put("takeOffAirport", takeOffAirport);
		scheduleMap.put("landingAirport", landingAirport);
		scheduleMap.put("beginDate", dateFormat.format(beginDate));
		scheduleMap.put("endDate", dateFormat.format(endDate));

		return (List<AirlineSchedule>) getSqlSession().selectList(
				InformConst.PATH + "AirlineSchedule.getWithDoubleAirport", scheduleMap);
	}

	public void add(AirlineSchedule airlineSchedule) {
		getSqlSession().insert(InformConst.PATH + "AirlineSchedule.add", airlineSchedule);
	}

}
