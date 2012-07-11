package com.narratage.reserve.inform.datatype;

public enum SearchAirportType {
	TAKE_OFF("take_off_airport"), LANDING("landing_airport");

	String sqlColName;

	SearchAirportType(String sqlColName) {
		this.sqlColName = sqlColName;
	}

	public String getSqlColName() {
		return sqlColName;
	}

}
