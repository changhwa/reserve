package com.narratage.reserve.airplane.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narratage.reserve.airplane.dao.SeatDao;
import com.narratage.reserve.reservation.service.ReservationService;
import com.narratage.reserve.util.StringUtil;


@Service("seatService")
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private ReservationService reserveService;

	
	
	public String findSeat(String airinformCode) {
		ArrayList reserveSeatList = new ArrayList();
		
		String oriSeat = seatDao.findSeat(airinformCode);
		reserveSeatList = reserveService.findAirinformCodeReserve(airinformCode);
		
		String seat = makeSeatForm(oriSeat,reserveSeatList);
		
		return seat;	
		
	}

	public boolean modifySeat(String airplaneCode) {
		
		return false;
	}
	
	public static String makeSeatForm(String oriSeat, ArrayList reserveList){
		
		String[] oriTemp = oriSeat.split("#");
		
		return seatRow(oriTemp, reserveList);
		
	}
	
	public static String seatRow(String[] oriTemp, ArrayList reserveList){
		
		for (int i=0;i<reserveList.size();i++){
			
			HashMap map = (HashMap) reserveList.get(i);
			
			String seatName = (String) map.get("seatName");
			
			int arr  = firstChar(seatName);
			
			char[] temp = oriTemp[arr].toCharArray();
			
			int seatNum = Integer.parseInt(seatName.substring(1));
			
			temp[seatNum] = '2';
			
			oriTemp[arr] = StringUtil.arrayToString(temp);
		}
		
		return StringUtil.arrayToString(oriTemp);
	}
	
	public static int firstChar(String str){
		int i=0;
		for(char c = 65; c<91 ; c++){
			if(str.startsWith(c+"")){
				return i;
			}
			i++;
		}
		return i;
	}
	
}
