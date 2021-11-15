<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>카카오 로그인</title>

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/sign_in.css">

        <script src="http://code.jquery.com./jquery-latest.min.js"></script>

        <!-- 구글 로그인 OAuth 라이브러리 -->
        <meta name="google-signin-client_id" content="225885690621-kh90eb3igifh0b1mn36n7sm08e4q561g.apps.googleusercontent.com">

    </head>

    <body>
        <div class="container">
            <header>
                <main>
                    <div class="warp_banner">
                        <div class="info_banner">
                            <strong>카카오계정 하나로 충분합니다.</strong>
                            <p>카카오 서비스 뿐 아니라 Daum, Melon 및 다양한 외부 서비스까지<br>
                                카카오계정 하나로 편리하게 이용해보세요!</p>
                        </div>
                        <div>
                            <img src="images/login_main.png" width="540" alt="">
                        </div>
                    </div>
                    <div class="warp_form">
                        <h1 class="brand_logo">kakao</h1>
                        <div class="item_tf">
                            <input type="text" class="item_ip" placeholder="카카오메일 아이디, 이메일, 전화번호">
                            <div class="util_tf">
                                <span class="info_mail">@kakao.com</span>
                            </div>
                        </div>
                        <p class="info_tip">
                            <span class="txt_tip">TIP</span>
                            카카오메일이 있다면 메일 아이디만 입력해 보세요.
                        </p>
                        <div class="item_msg">
                            <span class="emailErrorMsg"></span>
                        </div>
                        <div class="item_tf">
                            <input type="password" class="item_ip" placeholder="비밀번호">
                        </div>
                        <div class="item_msg">
                            <span class="passwordErrorMsg"></span>
                        </div>
                        <div class="item_chk">
                            <input type="checkbox" class="item_cb" id="chk">
                            <label class="chk_on" for="chk">
                                <i class="far fa-check-circle"></i>
                            </label>
                            <label class="chk_off" for="chk">
                                <i class="fas fa-check-circle"></i>
                            </label>
                            <label for="chk" class="chk_lab">로그인 상태 유지</label>
                        </div>
                        <div class="warp_btn">
                            <button type="button" class="item_btn btn_login">로그인</button>
                            <div class="hr-sect">
                                <span>또는</span>
                            </div>
                            <button class="item_btn btn_qr"><i class="fas fa-qrcode"></i>&nbsp; QR코드 로그인</button>
                        </div>


                        <!-- 구글 로그인 -->
                        <div class="g-signin2" data-onsuccess="onSignIn"></div>
                        <a href="#" onclick="signOut();">Sign out</a>


                        <div class="info_user">
                            <a href="signUp">회원가입</a>
                            <div>
                                <a href="">카카오계정</a>
                                <label> | </label>
                                <a href="">비밀번호 찾기</a>
                            </div>
                        </div>
                    </div>
                </main>
            </header>
            <footer>
                <div class="service_info">
                    <a href="https://www.kakao.com/policy/terms?lang=ko" class="link_info">이용약관</a><span
                        class="txt_bar"></span>
                    <a href="https://www.kakao.com/policy/privacy?lang=ko" class="link_info link_policy">개인정보
                        처리방침</a><span class="txt_bar"></span>
                    <a href="https://www.kakao.com/policy/oppolicy?lang=ko" class="link_info">운영정책</a><span
                        class="txt_bar"></span>
                    <a href="https://cs.kakao.com/" class="link_info">고객센터</a>
                    <a href="https://www.kakao.com/notices?lang=ko" class="link_info">공지사항</a><span
                        class="txt_bar"></span>
                    <a href="">한국어^</a>
                </div>
                <small class="txt_copyright">Copyright © <a href="https://www.kakaocorp.com/?lang=ko"
                        class="link_kakao">Kakao Corp.</a>
                    All rights reserved.
                </small>
            </footer>
        </div>
        <script src="js/sign_in.js"></script>
        <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>

        <!-- 구글 로그인 세팅 -->
            <script type="text/javascript">
    	function init() {
    		gapi.load('auth2', function() {
    			let gauth = gapi.auth2.init({
    				client_id: '225885690621-kh90eb3igifh0b1mn36n7sm08e4q561g.apps.googleusercontent.com'
    			});
    			/*
    			gauth.then(
    				function(){
    					if(gauth.isSignedIn.get()){
    						alert('로그인 중');
    					}else{
    						alert('로그인 필요');
    					}
    				},
    				function(){
    					alert('로그인 실패');
    				}
    			)
    			*/
    		});
    	}
    	
    	function signIn(profileObj){
    		$.ajax({
    			type: "post",
    			url: "/oauth2/signin",
    			data: JSON.stringify(profileObj),
    			dataType: "text",
    			contentType: "application/json;charset=UTF-8",
    			success: function(data){
    				if(data == '1'){
    					alert("로그인 성공");
    					location.href = "/index";
    				}
    			},
    			error:function(){
    				alert('회원가입 데이터 전송 실패');
    			}
    			
    		})
    	}
    	
    	function signUp(profileObj){
    		$.ajax({
    			type: "post",
    			url: "/oauth2/signup",
    			data: JSON.stringify(profileObj),
    			dataType: "text",
    			contentType: "application/json;charset=UTF-8",
    			success: function(data){
    				if(data == '1'){
    					signIn(profileObj);
    				}
    			},
    			error:function(){
    				alert('회원가입 데이터 전송 실패');
    			}
    			
    		})
    	}
    	
    	function signUpCheck(profileObj){
    		$.ajax({
    			type: 'post',
    			url: '/oauth2/signupcheck',
    			data: JSON.stringify(profileObj),
    			dataType: "text",
    			contentType: "application/json; charset=UTF-8",
    			success: function(data){
    				if(data == '0'){
    					// 회원가입 필요
    					signUp(profileObj);
    				}else{
    					// 로그인
    					signIn(profileObj);
    				}
    			},
    			error: function(){
    				alert('전송오류!');
    			}
    		})
    	}
    	
    	function onSignIn(googleUser) {
    		  var profile = googleUser.getBasicProfile();
    		  let profileObj = {
    	    			signUpEmail: profile.getEmail(),
    	    			emailFlag: 1,
    	    			signUpPassword: '',
    	    			signUpName: profile.getName(),
    	    			signUpPhone: '',
    	    			phoneFlag: 1
    	    	};
    		  signUpCheck(profileObj);
    	}
    </script>


        <!-- !!!!! 제일 마지막에 와야 함 !!!!! -->
        <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    </body>

    </html>