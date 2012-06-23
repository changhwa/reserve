package com.narratage.reserve.airplane.service;

public interface SeatService {
	
	public String findSeat(String airinformCode);
	public boolean modifySeat(String airplaneCode);

}
