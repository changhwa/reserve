package com.narratage.reserve.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narratage.reserve.airplane.service.SeatService;
import com.narratage.reserve.reservation.service.ReservationService;
import com.narratage.reserve.util.StringUtil;

@Controller
public class ReservationContoller {
	
	@Autowired
	private ReservationService reserveService;
	
	@Autowired
	private SeatService seatService;
	
	
	@RequestMapping(value="/reserv/seat")
	public String seatView(ModelMap model, HttpServletRequest req){
		
		String airinformCode = req.getParameter("airinformCode");
		String seat = seatService.findSeat(airinformCode);
		String[] seatValueSplit = StringUtil.split(seat,"#");
		char[] joinSeatValuetoArray = StringUtil.arrayToString(seatValueSplit).toCharArray();
		ArrayList<String> seatNameList = seatService.makeSeatNameFromSeatArray(seatValueSplit);

		joinSeatValuetoArray = seatService.viewReserved(joinSeatValuetoArray, seatNameList, airinformCode);		

		model.addAttribute("seatNum",joinSeatValuetoArray);
		
		return "/reserve/seat";
	}

	@RequestMapping(value="/reserv/process")
	
	public @ResponseBody String reservationProcess(ModelMap model, HttpServletRequest req){
		
		String[] aa = req.getParameterValues("seatNum");
		
		for(int i =0 ; i<aa.length;i++){
			System.out.println(aa[i]);
		}
		return "sss";
	}
	
	/*@RequestMapping(value="/reserv/insert")
	public String reservationInsert(ModelMap model, 
			@RequestParam("airline_schedule_no") String airlineScheduleNo,
			@RequestParam("seatName") String seatName,
			@RequestParam("user_id") String userId){
		
		reserveService.insertReserve(airlineScheduleNo,seatName,userId); 
						
		return "";
	}*/
	@RequestMapping(value="/reserv/insert")
	public String reservationInsert(ModelMap model, 
			@RequestParam HashMap<String,String> paramMap){
		
		//reserveService.insertReserve(paramMap);
		
		Iterator it = paramMap.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			System.out.println(entry.getKey()+" : " + entry.getValue());
		}
						
		return "home";
	}
}
