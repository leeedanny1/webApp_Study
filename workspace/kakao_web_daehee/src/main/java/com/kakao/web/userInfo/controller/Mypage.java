package com.kakao.web.userInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.web.index.model.dto.User;
import com.kakao.web.index.service.UserService;
import com.kakao.web.index.service.UserServiceImpl;
import com.kakao.web.userInfo.model.dto.UpdateUserDto;
import com.kakao.web.userInfo.service.UserInfoService;
import com.kakao.web.userInfo.service.UserInfoServiceImpl;

@WebServlet("/mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserInfoService userInfoService = null;
	private UserService userService = null;
	
    public Mypage() {
    	userInfoService = new UserInfoServiceImpl();
    	userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User login_user = (User)session.getAttribute("login_user");
		if(login_user == null) {
			response.sendRedirect("signIn");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UpdateUserDto updateUserDto = new UpdateUserDto();
		updateUserDto.setEmail(request.getParameter("user_email"));
		updateUserDto.setPassword(request.getParameter("update_password"));
		updateUserDto.setName(request.getParameter("user_name"));
		updateUserDto.setPhone(request.getParameter("user_phone"));
		updateUserDto.setPhone(request.getParameter("user_phone"));
		
		int result = userInfoService.updateUserInfo(updateUserDto);
		if(result == 1) {
			HttpSession session = request.getSession();
			User login_user = userService.getUser(updateUserDto.getEmail());
			session.setAttribute("login_user", login_user);
		}
		response.sendRedirect("mypage");
	}

}











