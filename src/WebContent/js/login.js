'use strict';

const userName = document.getElementById('user_name')
const password = document.getElementById('password')

const form = document.getElementById('login-form')

function userValidation() {
	if (userName.value == null || userName.value == "") {
		document.getElementById('user_name_error_message').textContent = 'ユーザーネームを入力してください'
	} else {
		document.getElementById('user_name_error_message').textContent = ''
	}
}
function passwordValidation() {
	if (password.value == null || password.value == "") {
		document.getElementById('password_error_message').textContent = 'パスワードを入力してください'
	} else if (password.value.length < 8) {
		document.getElementById('password_error_message').textContent = 'パスワードは8文字以上です'
	} else {
		document.getElementById('password_error_message').textContent = ''
	}
}

// バリデーションチェック
userName.addEventListener('blur', userValidation)
password.addEventListener('blur', passwordValidation)

// 送信時のバリデーションチェック
form.onsubmit = function(event) {
	// バリデーションチェックを実行
	userValidation()
	passwordValidation()
	if (document.getElementById('user_name_error_message').textContent.length === 0 &&
		document.getElementById('password_error_message').textContent.length === 0) {
		//  エラーメッセージなければ送信
	} else {
		return false
	}
}

// アラートを表示
const errMessage = document.getElementById("err_message").value
if (errMessage !== "") {
	alert(errMessage)
}