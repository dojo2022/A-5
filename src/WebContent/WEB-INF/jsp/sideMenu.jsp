<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="cp_cont">
	<div class="cp_offcm01">
		<input type="checkbox" id="cp_toggle01"> <label for="cp_toggle01"></label>
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