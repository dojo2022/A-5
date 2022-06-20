<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新規アカウント作成 | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/accountCreate.css">
</head>
<body>
	<div class="login_background_img">
		<div id="title_logo">
			<img src="img/logo_machico.png" width="600px">
		</div>
		<p>新規アカウント作成</p>
		<div id="account-create-page">
			<form id="account-create-form" method="POST" action="/machico/AccountCreateServlet">
				<div id="account_create">
					<table>
						<tr>
							<td align="left" style="font-size: 20px;"><label><b>ユーザネーム</b></label>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="new_user_name_textbox"
								id="new_user_name" value="${requestScope.new_name}"></td>
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
							<td><input type="password" name="new_password_textbox"
								id="new_password" value="${requestScope.new_pw}"></td>
						</tr>
						<tr>
							<td>
								<p id="password_error_message" class="error_message"
									align="left"></p>
							</td>
						</tr>
					</table>
				</div>
				<input type="button" value="戻る" style="font-weight: bold;" onclick="location.href='/machico/LoginServlet'">
				<input type="submit" value="次へ" style="font-weight: bold;">
				<input type="hidden" id="err_message" value="${errMessage}">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/accountCreate.js"></script>
</body>
</html>