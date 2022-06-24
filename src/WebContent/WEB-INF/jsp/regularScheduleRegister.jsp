<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>定期予定登録 | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/regularScheduleRegister.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<main>
		<section id="calender">
			<div class="background_img">
				<form id="regular-schedule-form">
					<div class="screen_contents">
						<div id="frame">
							<table id="title_area">
								<tr>
									<td>
										<div class="cp_iptxt">
											<input type="text" id="calendar_new_title" placeholder="タイトル"
												style="font-weight: bold;"> <i
												class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<p id="title_error_message" class="error_message" align="left"></p>
									</td>
								</tr>
							</table>
							<div class="frame_contents">
								<table id="date_table">
									<tr>
										<td><label><b>開始</b></label></td>
									</tr>
									<tr>
										<td><input type="date" style="font-weight: bold;">
										</td>
									</tr>
									<tr>
										<td><input type="time" id="time_entry"
											style="font-weight: bold;"></td>
									</tr>
									<tr>
										<td><select name="date_selection" id="date_selection"
											onchange="change();" required>
												<option value="">繰り返し指定</option>
												<option value="year">年</option>
												<option value="month">月</option>
												<option value="week">週</option>
										</select></td>
									</tr>
								</table>
							</div>
							<div class="frame_contents">
								<img src="/machico/img/aqua_arrow.png" class="arrow">
							</div>
							<div class="frame_contents">
								<table id="date_table_end">
									<tr>
										<td><label><b>終了</b></label></td>
									</tr>
									<tr>
										<td><input type="date" style="font-weight: bold;">
										</td>
									</tr>
									<tr>
										<td><input type="time" id="time_entry_end"
											style="font-weight: bold;"></td>
									</tr>
									<tr>
										<td>
											<p id="all_day_text">
												<input type="checkbox" id="all_day_check"
													onclick="connecttextA('time_entry',this.checked);connecttextB('time_entry_end',this.checked);">
												終日チェック
											</p>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<div id="weekday_display" style="display: none">
								<div id="week_block">
									<table id="week_checkbox_table">
										<tr>
											<td>月</td>
											<td>火</td>
											<td>水</td>
											<td>木</td>
											<td>金</td>
											<td>土</td>
											<td>日</td>
										</tr>
										<tr>
											<td><input type="checkbox" id="monday"></td>
											<td><input type="checkbox" id="tuesday"></td>
											<td><input type="checkbox" id="wednesday"></td>
											<td><input type="checkbox" id="thursday"></td>
											<td><input type="checkbox" id="friday"></td>
											<td><input type="checkbox" id="saturday"></td>
											<td><input type="checkbox" id="sunday"></td>
										</tr>
									</table>
								</div>
							</div>
							<textarea id="memo" placeholder="MEMO" style="font-weight: bold;"></textarea>
						</div>
					</div>
					<div class="screen_contents">
						<input type="button" class="button" value="戻る" style="font-weight: bold;" onclick="location.href='/machico/CalendarServlet'">
					</div>
					<div class="screen_contents">
						<input type="button" class="submit" value="保存" style="font-weight: bold;" onclick="location.href='/machico/CalendarServlet'">
					</div>
					<input type="hidden" id="err_message" value="">
				</form>
			</div>
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript"
		src="/machico/js/regularScheduleRegister.js"></script>
</body>
</html>