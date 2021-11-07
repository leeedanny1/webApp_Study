package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitTest
 */
@WebServlet("/junil")
public class SubmitTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("user_name");
		String flag = request.getParameter("flag");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(flag);
		
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		application.setAttribute("id", id);
		application.setAttribute("password", pwd);
		application.setAttribute("myName", name);
		application.setAttribute("flag", flag);
		
		
		request.getRequestDispatcher("/WEB-INF/views/doPost.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("post요청");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("user_name");
		String flag = request.getParameter("flag");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(flag);
		
		request.setAttribute("id", id);
		request.setAttribute("password", pwd);
		request.setAttribute("myName", name);
		request.setAttribute("flag", flag);
		
		request.getRequestDispatcher("/WEB-INF/views/doPost.jsp").forward(request, response);
	}

}
