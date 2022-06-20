'use strict';
const userName = document.getElementById('new_user_name')
const password = document.getElementById('new_password')

const form = document.getElementById('account-create-form')

function userValidation() {
	if (userName.value == null || userName.value == "") {
		document.getElementById('user_name_error_message').textContent = 'パスワードを入力してください'
	} else if (userName.value.length < 1 || userName.value.length > 15) {
		document.getElementById('user_name_error_message').textContent = '1～15文字で入力してください'
	} else {
		document.getElementById('user_name_error_message').textContent = ''
	}
}
function passwordValidation() {
	if (password.value == null || password.value == "") {
		document.getElementById('password_error_message').textContent = 'パスワードを入力してください'
	} else if (password.value.length < 8 || password.value.length > 32) {
		document.getElementById('password_error_message').textContent = '8～32文字で入力してください'
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