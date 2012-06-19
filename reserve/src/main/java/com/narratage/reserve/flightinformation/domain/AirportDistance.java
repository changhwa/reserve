package com.narratage.reserve.flightinformation.domain;

public class AirportDistance {
	private String firstAirport;
	private String secondAirport;
	private double distance;

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