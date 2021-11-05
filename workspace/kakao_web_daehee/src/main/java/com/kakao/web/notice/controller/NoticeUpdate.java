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


@WebServlet("/notice-update")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = null;
       
    public NoticeUpdate() {
    	noticeService = new NoticeServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		request.setAttribute("notice", noticeService.getNotice(code));
		request.getRequestDispatcher("WEB-INF/views/notice_update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NoticeDto noticeDto = new NoticeDto();
		
		noticeDto.setNotice_code(Integer.parseInt(request.getParameter("notice_code")));
		noticeDto.setNotice_title(request.getParameter("notice_title"));
		noticeDto.setNotice_content(request.getParameter("notice_content"));
		
		int result = noticeService.updateNotice(noticeDto);
		if(result == 1) {
			response.sendRedirect("notice-dtl?code=" + noticeDto.getNotice_code());
		} else {
			NoticeDto preNoticeDto = noticeService.getNotice(request.getParameter("notice_code"));
			preNoticeDto.setNotice_title(noticeDto.getNextNotice_title());
			preNoticeDto.setNotice_content(noticeDto.getNotice_content());
			
			request.setAttribute("notice", preNoticeDto);
			request.getRequestDispatcher("WEB-INF/views/notice_update.jsp").forward(request, response);
		}
	}

}
