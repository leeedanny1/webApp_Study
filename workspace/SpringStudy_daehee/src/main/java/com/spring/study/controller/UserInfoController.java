package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.UserInfoModel;

@Controller
public class UserInfoController {

	@RequestMapping(value="user-info-insert",method=RequestMethod.GET)
	public ModelAndView userInfoIsert() {
		ModelAndView mav = new ModelAndView("userInfoInsert");
		return mav;
	}
	
	@RequestMapping(value = "/insert-data", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String insertData(UserInfoModel userInfoModel) {
		
//		데이터를 변경하는것도 가
//		userInfoModel.setUser_name("삼대희");
		
//		System.out.println(userInfoModel.getUser_id());
//		System.out.println(userInfoModel.getUser_password());
//		System.out.println(userInfoModel.getUser_name());
//		System.out.println(userInfoModel.getUser_phone());
		
		return userInfoModel.getUser_id() + ", " + userInfoModel.getUser_password() + ", " + userInfoModel.getUser_name() + ", " + userInfoModel.getUser_phone();


	}

}
