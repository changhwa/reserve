package com.narratage.reserve.inform.domain;


public class Airport {
	private String iata;
	private String city;
	private String contry;
	private Double latitude;
	private Double longtitude;
	private float altitude;
	private float timezone;
	private String dst;
	private int queriedNumber;

	public Airport() {
		super();
	}

	
	public Airport(String iata, String city, String contry, Double latitude, Double longtitude, float altitude,
			float timezone, String dst, int queriedNumber) {
		super();
		this.iata = iata;
		this.city = city;
		this.contry = contry;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.altitude = altitude;
		this.timezone = timezone;
		this.dst = dst;
		this.queriedNumber = queriedNumber;
	}


	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public float getTimezone() {
		return timezone;
	}

	public void setTimezone(float timezone) {
		this.timezone = timezone;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public int getQueriedNumber() {
		return queriedNumber;
	}

	public void setQueriedNumber(int queriedNumber) {
		this.queriedNumber = queriedNumber;
	}

}
