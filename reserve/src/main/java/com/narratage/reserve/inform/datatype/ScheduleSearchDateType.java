package com.narratage.reserve.inform.datatype;

public enum ScheduleSearchDateType {
	TAKE_OFF_DATE("take_off_date"), LANDING_DATE("landing_date");
	
	String sqlColName;
	ScheduleSearchDateType(String sqlColName){
		this.sqlColName = sqlColName;
	}
	
	public String getSqlColName() {
		return sqlColName;
	}
	
}
