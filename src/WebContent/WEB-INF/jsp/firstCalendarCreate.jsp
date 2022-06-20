<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新規アカウント作成 | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/firstCalendarCreate.css">
</head>
<body>
	<div class="login_background_img">
		<div id="title_logo">
			<img src="img/logo_machico.png" width="600px">
		</div>
		<p>カレンダータイトルを入力してください</p>
		<div id="first-clendar-create-page">
			<form id="first-clendar-create-form" method="POST" action="/machico/FirstCalendarCreateServlet">
				<div id="first_clendar_create">
					<table>
						<tr>
							<td align="left" style="font-size: 20px;"><label><b>タイトル</b></label>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="new_title_textbox"
								id="new_title"></td>
						</tr>
						<tr>
							<td>
								<p id="title_error_message" class="error_message"
									align="left"></p>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="new_user_name_textbox"
								id="new_user_name" value="${requestScope.new_name}">
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="new_password_textbox"
								id="new_password" value="${requestScope.new_pw}">
							</td>
						</tr>
					</table>
				</div>
				<input type="button" class="back" name="bt" value="戻る" style="font-weight: bold;" onclick="history.back();">
				<input type="submit" class="submit" name="bt" value="作成" style="font-weight: bold;">
				<input type="hidden" id="err_message" value="${errMessage}">
			</form>
		</div>
	</div>
<script type="text/javascript" src="/machico/js/base.js"></script>
<script type="text/javascript" src="/machico/js/firstCalendarCreate.js"></script>
</body>
</html>