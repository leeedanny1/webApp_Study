package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.CustomerModel;

@Controller
public class PostManController {

	@RequestMapping(value = "/postManTest", method = RequestMethod.POST, produces = "text/html; charset=UTF-8" )
	@ResponseBody
	public String postResponse(
			@RequestParam String id, 
			@RequestParam String pwd,
			@RequestParam String name,
			@RequestParam String phone) {
		
		return "사용자 id: " + id + ", 사용자 pwd: " + pwd + ", 사용자 이름: " + name + ", 사용자 전화번호: " + phone; 
	}
	
	
	
	
	// 단순 String
//	@RequestMapping(value = "/postManDelivery", method = RequestMethod.POST, produces = "text/html; charset=UTF-8" )
//	@ResponseBody
//	public String postDelivery(
//			@RequestParam String customer, 
//			@RequestParam String address,
//			@RequestParam String phone,
//			@RequestParam String etc) {
//		
//		return "고객명: " + customer + "\n 배송지 주소: " + address + "\n 고객 전화번호: " + phone + "\n 고객 요청사항: " + etc; 
//	}
	
	// 모델 만들어서..
	@RequestMapping(value = "/postManDelivery", method = RequestMethod.POST, produces = "text/html; charset=UTF-8" )
	@ResponseBody
	public String postDelivery(CustomerModel customerModel) {		
		return "고객명: " + customerModel.getCustomer_name() + " 배송지(주소): " + customerModel.getCustomer_address() + " 연락처: " + customerModel.getCustomer_phone() + " 기타사항: " + customerModel.getCustomer_etc();
	}
	

	
	
	
	
	
	
	
	
	
}
