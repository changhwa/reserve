package com.narratage.reserve.flightinformation.domain;

import java.util.Date;

public class AirlineSchedule {
	private String fromIATA;
	private String toIATA;
	private Date takeOffTime;
	private int durationMinute;
	private String aircraft;
	private int price;

	public AirlineSchedule() {
		super();
	}

	public AirlineSchedule(String fromIATA, String toIATA, Date takeOffTime, int durationMinute, String aircraft,
			int price) {
		super();
		this.fromIATA = fromIATA;
		this.toIATA = toIATA;
		this.takeOffTime = takeOffTime;
		this.durationMinute = durationMinute;
		this.aircraft = aircraft;
		this.price = price;
	}

	public String getFromIATA() {
		return fromIATA;
	}

	public void setFromIATA(String fromIATA) {
		this.fromIATA = fromIATA;
	}

	public String getToIATA() {
		return toIATA;
	}

	public void setToIATA(String toIATA) {
		this.toIATA = toIATA;
	}

	public Date getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(Date takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public int getDurationMinute() {
		return durationMinute;
	}

	public void setDurationMinute(int durationMinute) {
		this.durationMinute = durationMinute;
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
}
