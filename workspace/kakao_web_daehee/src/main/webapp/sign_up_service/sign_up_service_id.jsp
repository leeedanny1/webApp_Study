<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");

	
	
	response.sendRedirect("../sign_up_password.jsp?id=" + id);
%>