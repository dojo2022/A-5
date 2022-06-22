'use strict';

const title = document.getElementById('calendar_title')

const form = document.getElementById('automatic-schedule-form')

function userValidation() {
	if (title.value == null || title.value == "") {
		document.getElementById('title_error_message').textContent = 'タイトルを入力してください'
	} else if (title.value.length < 1 || title.value.length > 15) {
		document.getElementById('title_error_message').textContent = '1～15文字で入力してください'
	} else {
		document.getElementById('title_error_message').textContent = ''
	}
}

// バリデーションチェック
title.addEventListener('blur', userValidation)

// 送信時のバリデーションチェック
form.onsubmit = function(event) {
	// バリデーションチェックを実行
	userValidation()
	passwordValidation()
	if (document.getElementById('title_error_message').textContent.length === 0) {
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