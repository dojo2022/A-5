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
<div class="login_background_img">
	<div id="title_logo">
		<img src="img/logo_machico.png" width="600px">
	</div>
	<div id="login-page">
		<form id="login-form" method="POST" action="/machico/LoginServlet">
			<div id="login">
				<table>
					<tr>
						<td align="left" style="font-size: 20px;"><label><b>ユーザネーム</b></label>
						</td>
					</tr>
					<tr>
						<td><input type="text" name="user_name_textbox" id="user_name">
						</td>
					</tr>
					<tr>
						<td>
							<p id="user_name_error_message" class="error_message"
								align="left"></p>
						</td>
					</tr>
					<tr>
						<td align="left" style="font-size: 20px;"><label><b>パスワード</b></label>
						</td>
					</tr>
					<tr>
						<td><input type="password" name="password_textbox" id="password">
						</td>
					</tr>
					<tr>
						<td>
							<p id="password_error_message" class="error_message" align="left"></p>
						</td>
					</tr>
					<tr>
						<td><input type="submit" name="login" value="ログイン"
							style="font-weight: bold;"></td>
					</tr>
				</table>
			</div>
			<div class="button_area">
				<a href="/machico/AccountCreateServlet">
					<img src="img/yellow_button.png" id="yellow_button_img">
				</a>
				<div class="new_member_text">新規会員作成</div>
			</div>
			<input type="hidden" id="err_message" value="${errMessage}">
		</form>
	</div>
</div>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/login.js"></script>
</body>
</html>