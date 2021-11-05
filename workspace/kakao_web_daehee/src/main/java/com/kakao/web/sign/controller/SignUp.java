package com.kakao.web.sign.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.web.sign.model.dto.UserDto;
import com.kakao.web.sign.service.SignUpService;
import com.kakao.web.sign.service.SignUpServiceImpl;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignUpService signUpService;
	
	public SignUp() {
		signUpService = new SignUpServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("WEB-INF/views/sign_up_email.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String submitStatus = request.getParameter("submit_status");
		
		if(submitStatus.equals("email")) {
			String id = request.getParameter("id");
			
			int flag = signUpService.idCheck(id);
			request.setAttribute("id", id);
			
			if(flag == 1) {
				request.setAttribute("flag", flag);
				
				request.getRequestDispatcher("WEB-INF/views/sign_up_email.jsp").forward(request, response);
			}else {
				//비밀번호
				request.getRequestDispatcher("WEB-INF/views/sign_up_password.jsp").forward(request, response);
			}
		}else if(submitStatus.equals("password")) {
			//비밀번호 확인
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("password", request.getParameter("password"));
			request.getRequestDispatcher("WEB-INF/views/sign_up_repassword.jsp").forward(request, response);
			
		}else if(submitStatus.equals("repassword")) {
			//이름
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("password", request.getParameter("password"));
			request.getRequestDispatcher("WEB-INF/views/sign_up_name.jsp").forward(request, response);
			
		}else if(submitStatus.equals("name")) {
			//전화번호
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("password", request.getParameter("password"));
			request.setAttribute("name", request.getParameter("name"));
			request.getRequestDispatcher("WEB-INF/views/sign_up_phone.jsp").forward(request, response);
			
		}else if(submitStatus.equals("phone")) {
			//전화번호 인증요청, 마침버튼
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("password", request.getParameter("password"));
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("phone", request.getParameter("phone"));
			String submitFlag = request.getParameter("submit_flag");
			if(submitFlag.equals("1")) {
				//가입요청
				UserDto userDto = new UserDto();
				userDto.setUser_email(request.getParameter("id"));
				userDto.setUser_password(request.getParameter("password"));
				userDto.setUser_name(request.getParameter("name"));
				userDto.setUser_phone(request.getParameter("phone"));
				
				boolean signUpFlag = signUpService.signUp(userDto);
				if(signUpFlag == true) {
					response.sendRedirect("signIn");
				}else {
					request.getRequestDispatcher("WEB-INF/views/sign_up_phone.jsp").forward(request, response);
				}
				
			}else if(submitFlag.equals("2")) {
				//전화번호 인증요청
				String phone = request.getParameter("phone");
				String name = request.getParameter("name");
				if(phone != null && name != null) {
					int flag = signUpService.phoneNumberCheck(phone, name);
					request.setAttribute("flag", flag);
					
					request.getRequestDispatcher("WEB-INF/views/sign_up_phone.jsp").forward(request, response);
				}
			}
		}else {
			System.out.println("접속오류!(잘못된 접근)");
		}
	
	}

}
