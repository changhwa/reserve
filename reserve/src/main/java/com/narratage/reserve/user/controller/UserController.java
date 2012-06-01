package com.narratage.reserve.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narratage.reserve.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/user/duplicate")
	public String duplicateUser(HttpServletRequest request) {
		
		System.out.println("test:::");
		
		String id = request.getParameter("userId");
		
		if(userService.duplicateUser(id)){
			System.out.println("Ok");
		} else{
			System.out.println("No");
		}
		
		return "home";
	}

}
