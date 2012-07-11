package com.narratage.reserve.inform.datatype;

public enum SearchDateType {
	TAKE_OFF_DATE("take_off_date"), LANDING("landing_date");
	
	String sqlColName;
	SearchDateType(String sqlColName){
		this.sqlColName = sqlColName;
	}
	
	public String getSqlColName() {
		return sqlColName;
	}
	
}
