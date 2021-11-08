<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송정보조회</title>
</head>

<body>

	고객명: ${customerModel.customer_name }<br>
	배송지(주소): ${customerModel.customer_address }<br>
	고객연락처: ${customerModel.customer_phone }<br>
	요청사항: ${customerModel.customer_etc }

</body>
</html>