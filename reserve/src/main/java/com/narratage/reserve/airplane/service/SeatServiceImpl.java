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

	
	public String findSeat(String airinformCode){
		String oriSeat = seatDao.findSeat(airinformCode);
		return oriSeat;
	}


	public char[] viewReserved(char[] joinSeatValuetoArray, ArrayList<String> seatNameList, String airinformCode){
		
		ArrayList reserveSeatList = new ArrayList();
		reserveSeatList = reserveService.findAirinformCodeReserve(airinformCode);
		
		for (int i=0;i<reserveSeatList.size();i++){

			HashMap map = (HashMap) reserveSeatList.get(i);
			String seatName = (String) map.get("seatName");
			joinSeatValuetoArray = changedArrayIndex(Integer.parseInt(searchSeatIndex(seatNameList, seatName))
				, joinSeatValuetoArray, '2');
		}

		return joinSeatValuetoArray;
	}




	public String ingReserve(String seatValue, ArrayList<String> seatNameList){

		return null;
	}



	public ArrayList<String> makeSeatNameFromSeatArray(String[] seatValuetoArray) {
		
		ArrayList<String> list = new ArrayList<String>();
		int seatNum=1;
		int yl=0;
		boolean gongback = false;
		for(int i=0;i<seatValuetoArray.length;i++){
			char[] ch = seatValuetoArray[i].toCharArray();
			for(int j=0;j<ch.length;j++){				
				if(ch[j]=='0'){
					list.add("0");
				}
				else if(ch[j]=='1'){
					list.add(firstChar(yl)+seatNum);
					seatNum++;
					gongback = true;
				}
				else{
					list.add("3");
				}
				if(j==ch.length-1 && gongback){
					++yl;
				}
			}
			gongback = false;
			seatNum=1;
		}
		
		return list;
	}

	public static String firstChar(int i){
		int howNum = i+65;
		char c;
		for(c=65 ; c<91 ; c++){
			if(c==howNum){
				break;
			}
			else{
				continue;
			}
		}
		return c+"";
	}
	
	public static String searchSeatIndex(ArrayList<String> seatNameList, Object obj){
		if(obj instanceof Integer){
			return seatNameList.get(Integer.parseInt(obj.toString()));
		}else{
			return seatNameList.indexOf(obj.toString())+"";
		}
		
	}


	//StringUtil클래스로 옮길 예정 토요일 스터디시간에 작업
	public static char[] changedArrayIndex(int i, char[] str, char replace){
		str[i]=replace;
		return str;
	}


	
	
	/*
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
	}*/
	
}
