<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログイン | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/login.css">
</head>
<body>
    <p id="title_logo">machico</p>
    <div id="exsample-page">
        <form id="exsample-form">
	        <div id="login">
	            <table>
	                <tr>
	                    <td align="left" style="font-size : 20px;">
	                        <label><b>ユーザネーム</b></label>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <input type="text" name="user_name" id="user_name">
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <p id="user_name_error_message" class="error_message" align="left"></p>
	                    </td>
	                </tr>
	                <tr>
	                    <td align="left" style="font-size : 20px;">
	                        <label><b>パスワード</b></label>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <input type="text" name="password" id="password">
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <p id="password_error_message" class="error_message" align="left"></p>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <input type="submit" name="login" value="ログイン" style="font-weight : bold ;">
	                    </td>
	                </tr>
	            </table>
	        </div>
	        <div class="button_area">
	            <button type="button" onclick="location.href='/machico/AccountCreateServlet'"><img src="img/yellow_button.png" id="yellow_button_img"></button>
	            <div class="new_member_text">
	                新規会員作成
	            </div>
	        </div>
        </form>
    </div>
<script type="text/javascript" src="/machico/js/base.js"></script>
<script type="text/javascript" src="/machico/js/login.js"></script>
</body>
</html>