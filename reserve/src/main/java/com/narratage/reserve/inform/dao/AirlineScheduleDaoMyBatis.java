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

import com.narratage.reserve.inform.datatype.DateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;

@Repository("AirlineScheduleDao")
public class AirlineScheduleDaoMyBatis extends SqlSessionDaoSupport implements AirlineScheduleDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmm");

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

	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getPath(String takeOffAirport, String landingAirport, Date beginArriveDate,
			Date endArriveDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmm");
		HashMap<String, String> scheduleMap = new HashMap<String, String>();

		scheduleMap.put("takeOffAirport", takeOffAirport);
		scheduleMap.put("landingAirport", landingAirport);
		scheduleMap.put("beginDate", dateFormat.format(beginArriveDate));
		scheduleMap.put("endDate", dateFormat.format(endArriveDate));

		return (List<HashMap<String, Object>>) getSqlSession().selectList(InformConst.PATH + "AirlineSchedule.getPath",
				scheduleMap);
	}

	public AirlineSchedule get(int airlineScheduleNo) {
		return (AirlineSchedule) getSqlSession().selectOne(InformConst.PATH + "AirlineSchedule.get", airlineScheduleNo);
	}
}
