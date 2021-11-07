package com.kakao.web.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.web.notice.service.NoticeService;
import com.kakao.web.notice.service.NoticeServiceImpl;

@WebServlet("/notice-delete")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private NoticeService noticeService = null;
	
    public NoticeDelete() {
    	noticeService = new NoticeServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		int result = noticeService.deleteNotice(code);
		if(result == 1) {
			response.sendRedirect("notice");			
		} else {
			response.sendRedirect("notice-dtl?code=" + code);
		}
		
	}



}
