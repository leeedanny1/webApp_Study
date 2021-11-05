package com.kakao.web.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.web.notice.model.dto.NoticeDto;
import com.kakao.web.notice.service.NoticeService;
import com.kakao.web.notice.service.NoticeServiceImpl;

@WebServlet("/notice-dtl")
public class NoticeDtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoticeService noticeService = null;
    
    public NoticeDtl() {
    	noticeService = new NoticeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		NoticeDto noticeDto = noticeService.getNotice(code);
		
		request.setAttribute("notice", noticeDto);
		
		request.getRequestDispatcher("/WEB-INF/views/notice_dtl.jsp").forward(request, response);
	}

}
