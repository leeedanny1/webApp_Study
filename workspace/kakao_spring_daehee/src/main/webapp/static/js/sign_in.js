const item_ip = document.querySelectorAll('.item_ip');
const btn_login = document.querySelector('.btn_login');

var signInData = {
	user_email: '',
	user_password: '',
	signIncb: '',
	signInFlag: 0
}


// 메시지 자식노드 삭제 함수
function clearMsgNode(msg){
	while(msg.hasChildNodes()){
		msg.removeChild(msg.firstChild);
	}
	msg.style.display = 'none';
}
// 노드 추가 함수
function messageService(msgText, msgFlag){
	const emailErrorMsg = document.querySelector('.emailErrorMsg');
	const passwordErrorMsg = document.querySelector('.passwordErrorMsg');
	
	clearMsgNode(emailErrorMsg);
	clearMsgNode(passwordErrorMsg);
	
	let msgTextNode = document.createTextNode(msgText);
	
	// msgFlag가 0이면 아이디 오류, 1이면 비밀번호 오류
	if(msgFlag == 0){
		emailErrorMsg.appendChild(msgTextNode);
		emailErrorMsg.style.display = 'block';
	}else {
		passwordErrorMsg.appendChild(msgTextNode);
		passwordErrorMsg.style.display = 'block';
	}
}


// 각종 팁들
item_ip[0].onclick = () => {
    const info_tip = document.querySelector('.info_tip');
    info_tip.style.display = 'block';
}

item_ip[0].onkeyup = () => {
    const util_tf = document.querySelector('.util_tf');
    util_tf.style.display = 'block';
    if(item_ip[0].value.length == 0){
        util_tf.style.display = 'none';
    }
}

item_ip[0].onblur = () => {
    const info_tip = document.querySelector('.info_tip');
    if(item_ip[0].value.length == 0){
        const util_tf = document.querySelector('.util_tf');
        info_tip.style.display = 'none';
        util_tf.style.display = 'none';
    }
}


// input 비어있는 경우
function emptyCheck(){
	if(item_ip[0].value.length == 0){
		let msgText = '이메일을 입력해 주세요';
		messageService(msgText, 0);
		return false;
	} else if(item_ip[1].value.length == 0){
		let msgText = '비밀번호를 입력해 주세요';
		messageService(msgText, 1);
		return false;
	} else {
		return true;
	}
}


// 로그인 input flag값 확인
function signInSubmit(){
	$.ajax({
		type: "post",
		url: "sign-in",
		data: JSON.stringify(signInData),
		contentType: "application/json; charset=UTF-8",
		dataType: "text",
		success: function(data){
			signInData = JSON.parse(data);
			// 이메일이 존재하지 않음
			if(signInData.signInFlag == 0){
				let textMsg = '존재하지 않는 이메일입니다.'
				messageService(textMsg, 0);
			} 
			// 비밀번호 틀림
			else if(signInData.signInFlag == 1){
				let textMsg = '비밀번호가 일치하지 않습니다.'
				messageService(textMsg, 1);
			} 
			// 로그인 성공
			else if(signInData.signInFlag == 2){
				alert('로그인 성공!');
				location.replace('index');
			}
		},
		error: function(){
			alert('비동기 처리 오류!');
		}

	})
}


// 로그인 호출시(로그인 버튼 클릭시 호출되는 함수)
function signInService(){
	//ajax호출
	if(emptyCheck() == true){
		const item_cb = document.querySelector('.item_cb');
		signInData.user_email = item_ip[0].value;
		signInData.user_password = item_ip[1].value;

		signInData.signIncb = item_cb.value;
		signInSubmit();
	}
}


// 엔터와 로그인 버튼을 눌렀을 때의 동작
item_ip[0].onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		item_ip[1].focus();
	}
}

item_ip[1].onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		signInService();
	}
}

btn_login.onclick = () => {
	signInService();
}