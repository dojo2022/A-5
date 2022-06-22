'use strict';
// アラートを表示
const errMessage = document.getElementById("err_message").value
if (errMessage !== "") {
	alert(errMessage)
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