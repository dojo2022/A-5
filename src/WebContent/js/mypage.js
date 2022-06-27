'use strict';

// タイトルのバリデーションチェック
const user_name = document.getElementById('user_name')

const form = document.getElementById('user-name-form')

function userNameValidation() {
	if (user_name.value == null || user_name.value == "") {
		document.getElementById('user_name_error_message').textContent = 'ユーザーネームを入力してください'
	} else if (user_name.value.length < 1 || user_name.value.length > 15) {
		document.getElementById('user_name_error_message').textContent = '1～15文字で入力してください'
	} else {
		document.getElementById('user_name_error_message').textContent = ''
	}
}

// バリデーションチェック
user_name.addEventListener('blur', userNameValidation)

// 送信時のバリデーションチェック
form.onsubmit = function(event) {
	// バリデーションチェックを実行
	userNameValidation()
	if (document.getElementById('user_name_error_message').textContent.length === 0) {
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