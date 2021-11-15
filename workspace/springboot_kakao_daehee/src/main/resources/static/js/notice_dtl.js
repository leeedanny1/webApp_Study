const notice_update_button = document.querySelector('.notice_update_button');
const notice_delete_button = document.querySelector('.notice_delete_button');


notice_update_button.onclick = () => {
	const notice_code = document.querySelector('#notice_code');
	location.href = '/notice/update/' + notice_code.value;
}

notice_delete_button.onclick = () => {
	const notice_code = document.querySelector('#notice_code');
	
	$.ajax({
		type: "delete",
		url: "/notice/" + notice_code.value,
		success: function(data){
			alert("게시글이 성공적으로 삭제되었습니다.")
		},
		error: function(){
			alert("삭제 실패!")
		}
	})
}