package com.narratage.reserve.inform.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface AirlineScheduleService{
	public List<HashMap<String, Object>> getPathList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate);
}
