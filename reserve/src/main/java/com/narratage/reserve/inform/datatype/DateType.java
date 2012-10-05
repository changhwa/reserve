package com.narratage.reserve.inform.datatype;

public enum DateType {
	TAKE_OFF_DATE("take_off_date"), LANDING("landing_date");
	
	String sqlColName;
	DateType(String sqlColName){
		this.sqlColName = sqlColName;
	}
	
	public String getSqlColName() {
		return sqlColName;
	}
	
}
