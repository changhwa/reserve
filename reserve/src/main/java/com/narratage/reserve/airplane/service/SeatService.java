package com.narratage.reserve.airplane.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface SeatService {
	
	public String findSeat(String airinformCode);
	public char[] viewReserved(char[] joinSeatValuetoArray, ArrayList<String> seatNameList, String airinformCode);
	//public String viewReserved(String[] joinSeatValuetoArray, ArrayList<String> seatNameList, String airinformCode);
	public ArrayList<String> makeSeatNameFromSeatArray(String[] seatValuetoArray);
	public String ingReserve(HashMap map, ArrayList<String> list);


}
