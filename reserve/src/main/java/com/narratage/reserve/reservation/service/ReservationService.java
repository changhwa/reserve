package com.narratage.reserve.reservation.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReservationService {
	
	public boolean insertReserve(HashMap map);
	public boolean deleteReserve(int reservCode);
	public ArrayList findDateReserve(String userId,String startDate);
	public ArrayList findAllReserve(String userId);
	public ArrayList findAirinformCodeReserve(String airinformCode);

}
