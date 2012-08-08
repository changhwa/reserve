package com.narratage.reserve.reservation.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReservationDao {
	public ArrayList findAirinformCodeReserve(String airinformCode);	
	public int insertReserve(HashMap map);
	public int deleteReserve(String reservationCode);

}
