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


function change() {
	const selectionValue = document.getElementById('date_selection').value;
	if (selectionValue == "week") {
		//週のチェックボックスを表示
		document.getElementById('weekday_display').style.display = "";
	} else {
		//週のチェックボックスを非表示
		document.getElementById('weekday_display').style.display = "none";
	}
}


// タイトルのバリデーションチェック
const title = document.getElementById('calendar_new_title')

const form = document.getElementById('regular-schedule-form')

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