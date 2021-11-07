<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
</head>

<body>
	<label>쿠키에 저장된 생년월일</label>
	<div>
		<form action="cookieTest" method="post">
			생년월일
			<input type="text" name="year">
			<input type="text" name="month">
			<input type="text" name="day">
			<input type="submit" value="전송">	
		</form>
	</div>

</body>
</html>