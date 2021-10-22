<%@page import="com.kakao.web.dao.SignUpDao"%>
<%@page import="com.kakao.web.dao.SignUpDaoImpl"%>
<%@page import="com.kakao.web.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String submit_flag = request.getParameter("submit_flag");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	
	SignUpDao signUpDao = new SignUpDaoImpl();
	
	if(submit_flag.equals("1")){
		//가입요청
		UserDto userDto = new UserDto();
		userDto.setUser_email(id);
		userDto.setUser_password(password);
		userDto.setUser_name(name);
		userDto.setUser_phone(phone);
		
		boolean flag = signUpDao.signUp(userDto);
		
		if(flag == true){
			response.sendRedirect("sign_in.jsp");
		}
		
		
	}else if(submit_flag.equals("2")) {
		//전화번호 인증요청
		int flag =  signUpDao.phoneNumberCheck(phone, name);
		System.out.println(phone+name);
%>
		<jsp:forward page="sign_up_phone.jsp">
			<jsp:param value="<%=flag %>" name="flag"/>
		</jsp:forward>
<%
	}
%>