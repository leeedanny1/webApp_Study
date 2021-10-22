<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<!-- 자바소스코드 사이에 태그를 삽입 할 수 없으니, 중간에 끊고 다시 이어 갈 수 있다. -->

	<%
	//인코딩, 한글해결위함
	//post방식으로 전송 할 때는 필수
	request.setCharacterEncoding("UTF-8");
	
	String testId = "junil";
	String testPwd = "1234";
	//파라미터 추가
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	if (id.equals(testId)) {
		if (pwd.equals(testPwd)) {
	%>
	<jsp:forward page="index2.jsp">
		<!-- 파라미터 추가 -->
		<jsp:param value="이대희" name="name"/>
		<jsp:param value="010-1234-5678" name="phone"/>
	</jsp:forward>
	<%
	} else {
	%>
	<h1>비밀번호가 틀렸습니다.</h1>

	<%
	}
	} else {
	%>
	<h1>아이디가 존재하지 않습니다.</h1>
	<%
	}
	%>



</body>
</html>