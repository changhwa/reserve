package com.narratage.reserve.inform.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.narratage.reserve.inform.domain.AirportDistance;

public class AirportDistanceDaoJdbc implements AirportDistanceDao {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public double get(String firstAirprot, String secondAirport) {
		return this.jdbcTemplate.queryForObject(
				"SELECT distance FROM airport_distance WHERE first_airport=? AND second_airport=?", new Object[] {
						firstAirprot, secondAirport }, Double.class);
	}

	public void add(AirportDistance airportDistance) {
		this.jdbcTemplate.update("insert into airport_distance(first_airport, second_airport, distance) values(?,?,?)",
				airportDistance.getFirstAirport(), airportDistance.getSecondAirport(), airportDistance.getDistance());
	}

}
