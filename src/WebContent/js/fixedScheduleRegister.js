'use strict';
// アラートを表示
const errMessage = document.getElementById("err_message").value
if (errMessage !== "") {
	alert(errMessage)
}
//タイトルエラー
function userValidation() {
	if (title.value == null || title.value == "") {
		document.getElementById('title_error_message').textContent = 'タイトルを入力してください'
	} else if (title.value.length < 1 || title.value.length > 15) {
		document.getElementById('title_error_message').textContent = '1～15文字で入力してください'
	} else {
		document.getElementById('title_error_message').textContent = ''
	}
}
// 終日にチェックが入っていたら、日付を非表示にする
function connecttextA( textid, ischecked ) {
   if( ischecked == true ) {
    // チェックが入っていなかったら有効化
      document.getElementById(textid).disabled = true;
   }
   else {
      // チェックが入っていたら無効化
      document.getElementById(textid).disabled = false;
   }
}
function connecttextB( textid, ischecked ) {
   if( ischecked == true ) {
    // チェックが入っていなかったら有効化
      document.getElementById(textid).disabled = true;
   }
   else {
      // チェックが入っていたら無効化
      document.getElementById(textid).disabled = false;
   }
}