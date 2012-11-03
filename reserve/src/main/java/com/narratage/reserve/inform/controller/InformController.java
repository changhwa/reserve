package com.narratage.reserve.inform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformController {

	@RequestMapping(value = "/inform")
	public String inform(ModelMap model, HttpServletRequest req) {
		
		return "/inform/inform";
	}
}
