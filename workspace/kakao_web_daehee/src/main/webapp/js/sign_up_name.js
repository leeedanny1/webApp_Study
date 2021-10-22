const btn_g = document.querySelector('.btn_g');
const item_ip = document.querySelector('.item_ip');

item_ip.onkeypress = () => {
	if (window.event.keyCode == 13) {
		window.event.preventDefault();
		onSubmit();
	}
}

btn_g.onclick = () => {
	onSubmit();
}

// 빈칸인지 검사
function onSubmit() {
	const msg1 = document.querySelector('.msg1');

	if (item_ip.value.length == 0) {
		msg1.style.display = 'block';
	} else {
		const form = document.querySelector('form');
		form.submit();
	}
}