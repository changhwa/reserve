package com.narratage.reserve.inform.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class AirportDistanceDaoJdbc implements AirportDistanceDao {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public double getDistance(String IATA01, String IATA02) {
		return this.jdbcTemplate.queryForObject(
				"SELECT distance FROM airport_distance WHERE first_airport=? AND second_airport=?", new Object[] {
						IATA01, IATA02 }, Double.class);
	}

	public void addDistance(String IATA01, String IATA02, double distance) {
		this.jdbcTemplate.update(
				"insert into airport_distance(first_airport, second_airport, distance) values(?,?,s?)", IATA01, IATA02,
				distance);
	}

}
