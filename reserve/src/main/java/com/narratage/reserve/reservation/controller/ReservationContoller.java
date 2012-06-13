package com.narratage.reserve.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationContoller {
	
	@RequestMapping(value="/reserv/seat")
	public String seatView(ModelMap model){
		String a = "00120110023001001001";
		char test[] = a.toCharArray();
		model.addAttribute("nums", test);
	
		return "/reserve/seat";
	}

}
