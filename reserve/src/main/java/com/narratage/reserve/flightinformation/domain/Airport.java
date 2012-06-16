package com.narratage.reserve.flightinformation.domain;

public class Airport {
	private int AirportNo;
	private String IATA;
	private String City;
	private String Contry;
	private Double Latitude;
	private Double Longtitude;
	private float Altitude;
	private float Timezone;
	private String DST;
	private int Queried_number;

	public Airport() {
		super();
	}

	public int getAirportNo() {
		return AirportNo;
	}

	public void setAirportNo(int airportNo) {
		AirportNo = airportNo;
	}

	public String getIATA() {
		return IATA;
	}

	public void setIATA(String iATA) {
		IATA = iATA;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getContry() {
		return Contry;
	}

	public void setContry(String contry) {
		Contry = contry;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongtitude() {
		return Longtitude;
	}

	public void setLongtitude(Double longtitude) {
		Longtitude = longtitude;
	}

	public float getAltitude() {
		return Altitude;
	}

	public void setAltitude(float altitude) {
		Altitude = altitude;
	}

	public float getTimezone() {
		return Timezone;
	}

	public void setTimezone(float timezone) {
		Timezone = timezone;
	}

	public String getDST() {
		return DST;
	}

	public void setDST(String dST) {
		DST = dST;
	}

	public int getQueried_number() {
		return Queried_number;
	}

	public void setQueried_number(int queried_number) {
		Queried_number = queried_number;
	}

}
