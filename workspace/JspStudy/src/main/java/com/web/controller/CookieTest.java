package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getValue());
		}
		
		request.getRequestDispatcher("/WEB-INF/views/cookie.jsp").forward(request, response);
	}

	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			
			Cookie yCookie = new Cookie("year", year);
			Cookie mCookie = new Cookie("month", month);
			Cookie dCookie = new Cookie("day", day);
			
			response.addCookie(yCookie);
			response.addCookie(mCookie);
			response.addCookie(dCookie);
		}
	
}
