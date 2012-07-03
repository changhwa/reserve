package com.narratage.reserve.inform.datatype;

public enum ScheduleSearchAirportType {
	TAKE_OFF_AIRPORT("take_off_airport"), LANDING_AIRPORT("landing_airport");

	String sqlColName;

	ScheduleSearchAirportType(String sqlColName) {
		this.sqlColName = sqlColName;
	}

	public String getSqlColName() {
		return sqlColName;
	}

}
