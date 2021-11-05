const flag = document.querySelector('#flag');

if(flag.value == 1){
	const msg2 = document.querySelector('.msg2');
	msg2.style.display = 'block';
}

const item_ip = document.querySelector('.item_ip');
const btn_g = document.querySelector('.btn_g');

item_ip.onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		onSubmit();
	}
}

btn_g.onclick = () => {
	onSubmit();
}

function onSubmit(){
	if(item_ip.value.length == 0){
		const msg1 = document.querySelector('.msg1');
		const msg2 = document.querySelector('.msg2');
		msg1.style.display = 'block';
		msg2.style.display = 'none';
	} else {
		const form = document.querySelector('form');
		form.submit();
	}
}