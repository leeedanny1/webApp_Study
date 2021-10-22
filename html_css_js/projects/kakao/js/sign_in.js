// 로그인칸 클릭 시 TIP표시
const id = document.querySelector('.id');
const info_tip = document.querySelector('.info_tip');
// 클릭 시
id.onclick = () => {
    const info_tip = document.querySelector('.info_tip');
    info_tip.style.display = 'block';
}

// 로그인칸 @kakao.com 표시
// item_ip[0].onkeyup = () => {
//     const util_tf = document.querySelector('.util_tf');
//     util_tf.style.display = 'block';
//     if(item_ip[0].value.length < 1){
//         util_tf.style.display = 'none';
//     }
// }

// 클릭 해제시
id.onblur = () => {
    if(id.value.length == 0){
        // const util_tf = document.querySelector('.util_tf');
        info_tip.style.display = 'none';
        // util_tf.style.display = 'none';
    }
}