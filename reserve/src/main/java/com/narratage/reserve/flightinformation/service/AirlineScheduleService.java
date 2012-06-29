package com.narratage.reserve.flightinformation.service;

import java.util.Date;
import java.util.List;

import com.narratage.reserve.flightinformation.domain.AirlineSchedule;

public interface AirlineScheduleService {
	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate);
}
