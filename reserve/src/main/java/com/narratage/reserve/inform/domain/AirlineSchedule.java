package com.narratage.reserve.inform.domain;

import java.util.Date;

public class AirlineSchedule {
	private int airlineScheduleNo;
	private String takeOffAirport;
	private String landingAirport;
	private Date takeOffDate;
	private Date landingDate;
	private String aircraft;
	private int price;

	public AirlineSchedule() {
		super();
	}

	public AirlineSchedule(String takeOffAirport, String landingAirport, Date takeOffDate, Date landingDate,
			String aircraft, int price) {
		super();
		this.takeOffAirport = takeOffAirport;
		this.landingAirport = landingAirport;
		this.takeOffDate = takeOffDate;
		this.landingDate = landingDate;
		this.aircraft = aircraft;
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

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AirlineSchedule [airlineScheduleNo=" + airlineScheduleNo + ", takeOffAirport=" + takeOffAirport
				+ ", landingAirport=" + landingAirport + ", takeOffDate=" + takeOffDate + ", landingDate="
				+ landingDate + ", aircraft=" + aircraft + ", price=" + price + "]";
	}

}
