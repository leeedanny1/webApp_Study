package com.kakao.web.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.web.notice.model.dto.NoticeDto;
import com.kakao.web.notice.service.NoticeService;
import com.kakao.web.notice.service.NoticeServiceImpl;

@WebServlet("/notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoticeService noticeService;
    
    public Notice() {
    	noticeService = new NoticeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("notice-page") == null ? "1" : request.getParameter("notice-page");
		
		List<NoticeDto> noticeList = noticeService.getNoticeList(pageNum);
		int[] pages = noticeService.getNoticePages(pageNum);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pages", pages);
		request.getRequestDispatcher("/WEB-INF/views/notice.jsp").forward(request, response);
	}

}






