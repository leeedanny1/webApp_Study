package com.kakao.web.notice.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.web.index.model.dto.User;
import com.kakao.web.notice.model.dto.NoticeDto;
import com.kakao.web.notice.service.NoticeService;
import com.kakao.web.notice.service.NoticeServiceImpl;

@WebServlet("/notice-insert")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoticeService noticeService;
    
    public NoticeInsert() {
    	noticeService = new NoticeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("login_user");
		if(user == null) {
			response.sendRedirect("signIn");
		}else {
			request.setAttribute("now", new Date());
			request.getRequestDispatcher("/WEB-INF/views/notice_insert.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setNotice_title(request.getParameter("notice_title"));
		noticeDto.setNotice_writer(request.getParameter("notice_writer"));
		noticeDto.setNotice_content(request.getParameter("notice_content"));
		
		int result = noticeService.insertNotice(noticeDto);
		if(result == 0) {
			System.out.println("공지사항 작성 오류!");
			request.getRequestDispatcher("/WEB-INF/views/notice_insert.jsp").forward(request, response);
		}else {
			System.out.println("공지사항 작성 완료!");
			response.sendRedirect("notice");
		}
	}

}










