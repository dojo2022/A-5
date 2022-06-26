'use strict';

// 終日にチェックが入っていたら、日付を非表示にする
function connecttextA(textid, ischecked) {
	if (ischecked == true) {
		// チェックが入っていなかったら無効化
		document.getElementById(textid).disabled = true;
	}
	else {
		// チェックが入っていたら有効化
		document.getElementById(textid).disabled = false;
	}
}

function connecttextB(textid, ischecked) {
	if (ischecked == true) {
		// チェックが入っていなかったら無効化
		document.getElementById(textid).disabled = true;
	}
	else {
		// チェックが入っていたら有効化
		document.getElementById(textid).disabled = false;
	}
}


const title = document.getElementById('calendar_new_title')

const form = document.getElementById('fixed-schedule-form')

function titleValidation() {
	if (title.value == null || title.value == "") {
		document.getElementById('title_error_message').textContent = 'タイトルを入力してください'
	} else if (title.value.length < 1 || title.value.length > 15) {
		document.getElementById('title_error_message').textContent = '1～15文字で入力してください'
	} else {
		document.getElementById('title_error_message').textContent = ''
	}
}

// バリデーションチェック
title.addEventListener('blur', titleValidation)

// 送信時のバリデーションチェック
form.onsubmit = function(event) {
	// バリデーションチェックを実行
	titleValidation()
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