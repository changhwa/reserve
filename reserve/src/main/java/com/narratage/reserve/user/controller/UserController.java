package com.narratage.reserve.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narratage.reserve.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/user/duplicate")
	public String duplicateUser(HttpServletRequest request) {
		
		System.out.println("test:::");
		
		String id = request.getParameter("user_id");
		
		if(userService.duplicateUser(id)){
			System.out.println("Ok");
		} else{
			System.out.println("No");
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/user/getUserInfo")
	public String getUserInfo(ModelMap model, HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		ArrayList list = null;
		
		if (userService.getUserInfo(user_id) != null) {
			System.out.println(user_id + " you choosed");
			
			list = userService.getUserInfo(user_id);
		}
		
		model.addAttribute("list", list);
		
		return "/user/joinus";
	}

}
