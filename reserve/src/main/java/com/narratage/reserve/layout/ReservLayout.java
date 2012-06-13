package com.narratage.reserve.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservLayout {
	
	@RequestMapping(value="/reserv/main")
	public String showMain(){
		return "/reserv/main";
	}
	
	@RequestMapping(value="/reserv/ticket")
	public String showTicket(){
		return "/reserv/ticket";
	}
}
