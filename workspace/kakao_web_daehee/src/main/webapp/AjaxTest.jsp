<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax</title>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <input type="text" id="user_name" value="이대희">
    <script>
        // js
        const user_name = document.querySelector("#user_name");
        alert(user_name.value);

        // jQuery
        const user_name2 = $("#user_name");
        alert(user_name2.val() + '2');
        
        
        var dataOrigin = {
                user_name:"이대희",
                user_phone:"01012345678"                
		}


        //aJax
        $.ajax({
            type: "get",     //"get, post, put, delete"
            async: "true",    //"true, false" => 비동기화(t), 동기화(f)
            url: "ajaxTest", //요청할 서버 주소
            data:{
            	dataOrigin: JSON.stringify(dataOrigin)
            }, 
            dataType: "text", //xml, JSON, html, text....
            success: function(data){
                alert('비동기 전송 성공');
                let dataParse = JSON.parse(data);
                alert(dataParse.id);
                alert(dataParse.password);
                alert(dataParse.name);
                alert(dataParse.phone);
            }, //응답 성공시 실행되는 영역 => 예외처리 구문에서 try부분
            error: function(){
                alert('비동기 전송 실패');
            }, //응답 실패시 실행되는 영역 => 예외처리 구문에서 catch부분
            complete: function(){
                alert('비동기 처리 실행.');
            } //요청과 응답 후 항상 실행, => 예외처리 구분에서 finally부분
        })


    </script>
    
</body>
</html>