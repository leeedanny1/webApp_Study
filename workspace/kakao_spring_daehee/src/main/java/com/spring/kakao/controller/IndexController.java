package com.spring.kakao.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.kakao.model.dto.UserDto;
import com.spring.kakao.service.UserService;

@Controller
public class IndexController {
	
	private UserService userService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("cookie_email")) {
					HttpSession session = request.getSession();
					UserDto userDto = userService.getUser(c.getValue());
				}
			}
		}
		return new ModelAndView("index");
	}
	
}
