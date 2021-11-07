<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/mainNav.css">
    <link rel="stylesheet" href="css/mypage.css">
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <div class="container">
        <jsp:include page="include/index_include/index_header.jsp"></jsp:include>
        <main>
            <div class="mypage-content">
                <div>
                    <h1>마이페이지</h1>
                </div>
                <div class="mypage-items">
                	<form action="mypage" method="post">
                		<div class="item_tf">
	                        <input type="hidden" id="user_email" name="user_email" value="${login_user.id }">
	                        <label class="item_lb" for="">${login_user.id }@kakao.com</label>
	                    </div>
	                    <div class="item_tf">
	                    	<input type="hidden" id="password_flag" name="password_flag" value="2">
	                    	<input type="hidden" id="user_password" name="user_password" value="${login_user.password }">
	                        <input type="password" class="item_ip" name="update_password"  placeholder="비밀번호 입력">
	                    </div>
	                    <div class="item_msg">
	                        <span class="msg1"></span>
	                    </div>
	                    <div class="item_tf">
	                    	<input type="hidden" id="repassword_flag" name="repassword_flag" value="2">
	                        <input type="password" class="item_ip" placeholder="비밀번호 확인">
	                    </div>
	                    <div class="item_msg">
	                        <span class="msg1">비밀번호가 일치하지 않습니다.</span>
	                    </div>
	                    <div class="item_tf">
	                        <input type="hidden" id="user_name" name="user_name" value="${login_user.name }">
	                        <label class="item_lb" for="">${login_user.name }</label>
	                    </div>
	                    <div class="item_tf">
	                        <input type="hidden" id="user_phone" name="user_phone" value="${login_user.phone }">
	                        <label class="item_lb" for="">${login_user.phone }</label>
	                    </div>
	                    <div class="item_tf">
	                    	<input type="hidden" id="phone_flag" name="phone_flag" value="2">
	                        <input type="tel" class="item_ip" name="update_phone" placeholder="전화번호 입력">
	                        <div class="util_tf">
	                            <button type="button" class="button_round">인증요청</button>
	                        </div>
	                    </div>
	                    <div class="item_msg">
	                        <span class="msg1">이미 가입된 연락처 입니다.</span>
	                        <span class="msg2">인증실패. 연락처를 다시 확인해 주세요.</span>
	                        <span class="msg3">인증성공.</span>
	                    </div>
	                    <div class="confirm_btn">
	                        <button type="button" class="btn_g">회원정보 수정</button>
	                    </div>
                	</form>
                </div>
            </div>
        </main>
        <footer>

        </footer>
    </div>
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
    <script src="js/mypage.js"></script>
</body>
</html>