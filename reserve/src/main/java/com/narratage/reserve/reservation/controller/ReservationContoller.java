package com.narratage.reserve.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narratage.reserve.airplane.service.SeatService;
import com.narratage.reserve.reservation.service.ReservationService;

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
		
		model.addAttribute("seatNum",seat.toCharArray());
		
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
}
