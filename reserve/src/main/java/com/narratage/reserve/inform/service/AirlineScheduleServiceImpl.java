package com.narratage.reserve.inform.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.narratage.reserve.inform.dao.AirlineScheduleDao;
import com.narratage.reserve.inform.domain.AirlineSchedule;

public class AirlineScheduleServiceImpl implements AirlineScheduleService {

	public static final int LIMIT_TRANSFER_AIRPORT_NUMBER = 3;
	public static final int TRAVEL_LIMIT_MINUTE = 40 * 60;

	private AirlineScheduleDao airlineScheduleDao;

	public void setAirlineScheduleDao(AirlineScheduleDao airlineScheduleDao) {
		this.airlineScheduleDao = airlineScheduleDao;
	}

	private RowMapper<AirlineSchedule> airlineScheduleMapper = new RowMapper<AirlineSchedule>() {
		public AirlineSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
			AirlineSchedule airlineSchedule = new AirlineSchedule();
			airlineSchedule.setAircraft(rs.getString("Aircraft"));
			airlineSchedule.setDurationMinute(rs.getInt("DurationMinute"));
			airlineSchedule.setFromIATA(rs.getString("FromIATA"));
			airlineSchedule.setPrice(rs.getInt("Price"));
			airlineSchedule.setTakeOffTime(rs.getDate("TakeOffTime"));
			airlineSchedule.setToIATA(rs.getString("ToIATA"));
			return airlineSchedule;
		}
	};

	public List<AirlineSchedule> getSortedAirlineScheduleList(String fromAirportIATA, String toAirportIATA,
			Date startArriveDate, Date endArriveDate) {
		return airlineScheduleDao.getDirectAirlineScheduleList(fromAirportIATA, toAirportIATA, startArriveDate,
				endArriveDate);
	}
}
