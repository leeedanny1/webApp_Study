package com.kakao.web.index.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.web.index.model.dto.User;
import com.kakao.web.index.service.UserService;
import com.kakao.web.index.service.UserServiceImpl;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public Index() {
		userService = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("userId")) {
					HttpSession session = request.getSession();
					User user = userService.getUser(c.getValue());
					
					session.setAttribute("login_user", user);
				}
			}
		}
		
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
	}

}
