package com.narratage.reserve.inform.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AirlineSchedule implements Comparable<AirlineSchedule> {
	private int airlineScheduleNo;
	private String takeOffAirport;
	private String landingAirport;
	private Date takeOffDate;
	private Date landingDate;
	private int airplaneCode;
	private int price;

	public AirlineSchedule() {
		super();
	}

	public AirlineSchedule(String takeOffAirport,
			String landingAirport, Date takeOffDate, Date landingDate,
			int airplaneCode, int price) {
		super();
		this.takeOffAirport = takeOffAirport;
		this.landingAirport = landingAirport;
		this.takeOffDate = takeOffDate;
		this.landingDate = landingDate;
		this.airplaneCode = airplaneCode;
		this.price = price;
	}

	public int getAirlineScheduleNo() {
		return airlineScheduleNo;
	}

	public void setAirlineScheduleNo(int airlineScheduleNo) {
		this.airlineScheduleNo = airlineScheduleNo;
	}

	public String getTakeOffAirport() {
		return takeOffAirport;
	}

	public void setTakeOffAirport(String takeOffAirport) {
		this.takeOffAirport = takeOffAirport;
	}

	public String getLandingAirport() {
		return landingAirport;
	}

	public void setLandingAirport(String landingAirport) {
		this.landingAirport = landingAirport;
	}

	public Date getTakeOffDate() {
		return takeOffDate;
	}

	public void setTakeOffDate(Date takeOffDate) {
		this.takeOffDate = takeOffDate;
	}

	public Date getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}

	public int getAirplaneCode() {
		return airplaneCode;
	}

	public void setAirplaneCode(int airplaneCode) {
		this.airplaneCode = airplaneCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 날짜 테스트용
	public static SimpleDateFormat SDF = new SimpleDateFormat(
			"YYYY년MM월DD일 hh:mm:ss");

	@Override
	public String toString() {
		return "AirlineSchedule [airlineScheduleNo=" + airlineScheduleNo
				+ ", takeOffAirport=" + takeOffAirport + ", landingAirport="
				+ landingAirport + ", takeOffDate=" + takeOffDate
				+ ", landingDate=" + landingDate + ", airplaneCode="
				+ airplaneCode + ", price=" + price + "]";
	}

	public int compareTo(AirlineSchedule o) {
		return this.takeOffDate.getTime() <= o.takeOffDate.getTime() ? 1 : -1;
	}

}
