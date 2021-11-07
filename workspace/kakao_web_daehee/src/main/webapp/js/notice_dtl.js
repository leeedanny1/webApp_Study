const notice_update_button = document.querySelector('.notice_update_button');

notice_update_button.onclick = () => {
    const notice_code = document.querySelector("#notice_code");
    location.href = 'notice-update?code=' + notice_code.value;
}


const notice_delete_button = document.querySelector('.notice_delete_button');

notice_delete_button.onclick = () => {
    const notice_code = document.querySelector("#notice_code");
    location.href = 'notice-delete?code=' + notice_code.value;
}