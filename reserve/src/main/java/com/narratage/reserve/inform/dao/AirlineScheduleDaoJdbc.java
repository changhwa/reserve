package com.narratage.reserve.inform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.narratage.reserve.inform.datatype.ScheduleSearchAirportType;
import com.narratage.reserve.inform.datatype.ScheduleSerchDateType;
import com.narratage.reserve.inform.domain.AirlineSchedule;

public class AirlineScheduleDaoJdbc implements AirlineScheduleDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<AirlineSchedule> airlineScheduleMapper = new RowMapper<AirlineSchedule>() {

		public AirlineSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
			AirlineSchedule airlineSchedule = new AirlineSchedule();
			airlineSchedule.setTakeOffAirport(rs.getString("take_off_airport"));
			airlineSchedule.setLandingAirport(rs.getString("landing_airport"));
			airlineSchedule.setTakeOffDate(rs.getDate("take_off_time"));
			airlineSchedule.setLandingDate(rs.getDate("landing_time"));
			airlineSchedule.setAircraft(rs.getString("aircraft"));
			airlineSchedule.setPrice(rs.getInt("price"));

			return null;
		}
	};

	public List<AirlineSchedule> getSingleAirportAirlineScheduleList(ScheduleSearchAirportType airportType,
			ScheduleSerchDateType dateType, String airportIATA, Date beginDate, Date endDate) {
		String sql = "SELECT * FROM AIRLINE_SCHEDULE WHERE " + airportType.getSqlColName() + "=? AND "
				+ dateType.getSqlColName() + " BETWEEN ? AND ?";
		return this.jdbcTemplate.query(sql, new Object[] { airportIATA, beginDate, endDate },
				this.airlineScheduleMapper);
	}

	public List<AirlineSchedule> getDualAirportAirlineScheduleList(ScheduleSerchDateType dateType,
			String takeOffAirport, String landingAirport, Date beginDate, Date endDate) {
		String sql = "SELECT * FROM AIRLINE_SCHEDULE WHERE take_off_airport = ? AND landing_airport = ? "
				+ dateType.getSqlColName() + " BETWEEN ? AND ?";
		return this.jdbcTemplate.query(sql, new Object[] { takeOffAirport, landingAirport, beginDate, endDate },
				this.airlineScheduleMapper);
	}

	public void add(AirlineSchedule airlineSchedule) {
		this.jdbcTemplate.update(
				"INSERT INTO airline_schedule(take_off_airport,landing_airport,take_off_date,landing_date,aircraft,price)"
						+ " VALUES(?,?,?,?,?,?)", airlineSchedule.getTakeOffAirport(),
				airlineSchedule.getLandingAirport(), airlineSchedule.getTakeOffDate(),
				airlineSchedule.getLandingDate(), airlineSchedule.getAircraft(), airlineSchedule.getPrice());
	}

}
