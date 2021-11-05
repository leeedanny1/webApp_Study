<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송정보입력</title>

</head>

<body>

	<form action="delivery-request" method="post">
		배송받는사람(이름) <input type="text" name="customer_name"><br>
		배송지 <input type="text" name="customer_address"><br>
		연락처 <input type="tel" name="customer_phone"><br>
		택배 요청사항 <input type="text" name="customer_etc"><br>
		<input type="submit" value="전송">
	</form>

</body>
</html>