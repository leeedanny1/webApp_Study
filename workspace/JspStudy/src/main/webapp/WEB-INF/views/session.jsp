<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="junil">준일로 전달</a>
	<div>
		<label>아이디</label>
		<label><%=application.getAttribute("id") %></label>
		<label>비밀번호</label>
		<label><%=application.getAttribute("password") %></label>
		<label>이름</label>
		<label><%=application.getAttribute("myName") %></label>
		<label>flag</label>
		<label><%=application.getAttribute("flag") %></label>
		<label><%=application.getAttribute("test") %></label>
	</div>
</body>
</html>