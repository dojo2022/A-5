<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/sideMenu.css">
<body>
	<div class="cp_cont">
		<div class="cp_offcm01">
			<input type="checkbox" id="cp_toggle01"> <label
				for="cp_toggle01"><span></span></label>
			<div class="cp_menu">
				<ul>
					<li class="mypage"><a href="#mypage">マイページ</a></li>
					<li>
						<form method="post">
							<input type="hidden" name="change_calendar" value="1">
							<button type="submit" id="change_calendar_button">
								<!--カレンダー名をとってくる-->
							</button>
						</form>
					</li>
					<li>
						<form method="post">
							<input type="hidden" name="change_calendar" value="2">
							<button type="submit" id="change_calendar_button">
								<!--カレンダー名をとってくる-->
							</button>
						</form>
					</li>
					<li>
						<form method="post">
							<input type="hidden" name="change_calendar" value="3">
							<button type="submit" id="change_calendar_button">
								<!--カレンダー名をとってくる-->
							</button>
						</form>
					</li>
					<li><a href="#clendar">カレンダーを追加</a></li>
				</ul>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/sideMenu.js"></script>