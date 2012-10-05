package com.narratage.reserve.inform.domain;


public class AirportDistance {
	private String firstAirport;
	private String secondAirport;
	private double distance;

	public AirportDistance() {
		super();
	}

	public AirportDistance(String firstAirport, String secondAirport, double distance) {
		super();
		this.firstAirport = firstAirport;
		this.secondAirport = secondAirport;
		this.distance = distance;
	}

	public String getFirstAirport() {
		return firstAirport;
	}

	public void setFirstAirport(String firstAirport) {
		this.firstAirport = firstAirport;
	}

	public String getSecondAirport() {
		return secondAirport;
	}

	public void setSecondAirport(String secondAirport) {
		this.secondAirport = secondAirport;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}