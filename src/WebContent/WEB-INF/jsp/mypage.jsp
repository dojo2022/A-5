<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>マイページ | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/mypage.css">
</head>
<body>
	<%@ include file="sideMenu.jsp"%>
	<%@ include file="header.jsp"%>

	<main>
		<section id="calender">
			<div class="background_img">
				<form id="user-name-form" method="POST" action="/machico/MypageServlet">
					<div class="screen_contents">
						<div id="frame">
							<label class="name_area">ユーザーネーム</label>
							<div class="cp_iptxt">
								<input type="text" id="user_name" style="font-weight: bold;">
								<i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
							</div>
							<p id="user_name_error_message" class="error_message"
								align="left"></p>
						</div>
					</div>
					<div class="screen_contents">
						<div id="account_deletion">
							<input type="button" value="アカウント削除" style="font-weight: bold;"
								class="deletion_button_css">
						</div>
						<br> <input type="submit" value="ログアウト"
							style="font-weight: bold;" class="logout_button_css">
					</div>
					<br>
					<div class="inline_button">
						<input type="button" value="戻る" style="font-weight: bold;"
							class="back">
					</div>
					<div class="inline_button">
						<input type="button" value="保存" style="font-weight: bold;"
							class="save">
					</div>
					<input type="hidden" id="err_message" value="">
				</form>
			</div>
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/sideMenu.js"></script>
	<script type="text/javascript" src="/machico/js/mypage.js"></script>
</body>
</html>