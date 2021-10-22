<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>include 연습</title>

<link rel="stylesheet" href="css/bootstrap.min.css">

</head>

<body>
	<div class="container">
		<!--  include 폴더 안에 파일 만들어두고 한번에 가져다 씀 -->
		<jsp:include page="include/header_include.jsp" ></jsp:include>

		<main>
			<hr>
			<h1>메인페이지</h1>
			
			<form action="forwardEx.jsp" method="get">
				<lebel>아이디</lebel>
				<input type="text" name="id">
				<lebel>비밀번호</lebel>
				<input type="password" name="pwd">
				<input type="submit" value="전송">
			</form>
		</main>


		<jsp:include page="include/footer_include.jsp" />

	</div>


	<!-- font Awesome CDN -->
	<script src="https://kit.fontawesome.com/85db88a229.js"
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>

</html>