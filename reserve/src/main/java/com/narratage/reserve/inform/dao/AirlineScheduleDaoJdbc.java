package com.narratage.reserve.inform.dao;

import java.util.Date;
import java.util.List;

import com.narratage.reserve.inform.domain.AirlineSchedule;

public class AirlineScheduleDaoJdbc implements AirlineScheduleDao {

	public List<AirlineSchedule> getFromAirportAirlineScheduleList(String fromAirpotIATA, Date startArriveDate,
			Date endArriveDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AirlineSchedule> getToAirportAirlineScheduleList(String toAirportIATA, Date startArriveDate,
			Date endArriveDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AirlineSchedule> getDirectAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
