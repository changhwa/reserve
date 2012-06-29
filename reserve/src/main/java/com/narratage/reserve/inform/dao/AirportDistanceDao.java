package com.narratage.reserve.inform.dao;

public interface AirportDistanceDao{
	public double getDistance(String IATA01, String IATA02);
	public void addDistance(String IATA01, String IATA02, double distance);	
}
