package com.narratage.reserve.inform.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CommonDaoJdbc implements CommonDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void deleteAll(String tableName) {
		jdbcTemplate.update("DELETE FROM " + tableName);
	}

	public int getCount(String tableName) {
		return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM " + tableName);
	}
}
