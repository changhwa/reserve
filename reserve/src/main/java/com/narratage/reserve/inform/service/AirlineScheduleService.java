package com.narratage.reserve.inform.service;

import java.util.Date;
import java.util.List;

import com.narratage.reserve.inform.domain.AirlineSchedule;

public interface AirlineScheduleService {
	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate);
}
