<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doPost Study</title>
</head>
<body>
	<div style="border: 1px solid black;">
		<form action="junil" method="get">
			<input type="hidden" name="flag" value="1">
			<label>아이디</label>
			<input type="text" name="id" value="">
			<label>비밀번호</label>
			<input type="password" name="pwd" value="">
			<label>이름</label>
			<input type="text" name="user_name" value="">
			<input type="submit" value="get전송">
		</form>
	</div>
	
	<div style="border: 1px solid black;">
		<form action="junil" method="post">
			<input type="hidden" name="flag" value="1">
			<label>아이디</label>
			<input type="text" name="id" value="">
			<label>비밀번호</label>
			<input type="password" name="pwd" value="">
			<label>이름</label>
			<input type="text" name="user_name" value="">
			<input type="submit" value="post전송">
		</form>
	</div>
	
	<div>
		<label>아이디</label>
		<label><%=session.getAttribute("id") %></label>
		<label>비밀번호</label>
		<label><%=session.getAttribute("password") %></label>
		<label>이름</label>
		<label><%=session.getAttribute("myName") %></label>
		<label>flag</label>
		<label><%=session.getAttribute("flag") %></label>
		<label><%=session.getAttribute("test") %></label>
	</div>
</body>
</html>