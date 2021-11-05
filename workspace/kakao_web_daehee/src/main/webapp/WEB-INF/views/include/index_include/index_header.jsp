<%@page import="com.kakao.web.index.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL 사용 후 태그라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="nav">
		<a href="index" class="brand_logo"><h1>kakao</h1></a>
		<ul class="nav_item">
			<a href=""><li>카카오</li></a>
			<a href="notice"><li>뉴스</li></a>
			<a href=""><li>기술과 서비스</li></a>
			<a href=""><li>약속과 책임</li></a>
		</ul>
		
		<!-- 그냥 변수 만들어 준 것임 -->
		<c:set var="emailAddress" value="@kakao.com"></c:set>
		
		<!-- if문 -->
		<c:choose>
			<c:when test="${empty login_user }">
				<ul class="nav_user">
					<a href="signIn"><li><i class="fas fa-user"></i></li></a>
					<a href="signUp"><li><i class="fas fa-user-plus"></i></li></a>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="nav_user">
					<a href="mypage"><li><i class="fas fa-user-circle"></i>${login_user.id }<span>${emailAddress }</span></li></a>
					<a href="logout"><li><i class="fas fa-sign-out-alt"></i></li></a>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>
</header>