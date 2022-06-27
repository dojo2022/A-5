<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>固定予定登録 | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/fixedScheduleRegister.css">
</head>
<body>
	<%@ include file="header.jsp"%><%--ヘッダー部分 --%>
	<main>
		<section id="calender">
			<div class="background_img">
				<form id="fixed-schedule-form"  method="POST" action="/machico/FixedScheduleRegisterServlet">
					<div class="screen_contents">
						<div id="frame">
							<table id="title_area">
								<tr>
									<td>
										<div class="cp_iptxt">
											<input type="text" id="calendar_new_title" placeholder="タイトル" name="schedule"
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
										<td><input type="date" style="font-weight: bold;" name="date" >
										</td>
									</tr>
									<tr>
										<td><input type="time" style="font-weight: bold;"
											id="time_entry" name="time" ></td>
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
										<td><input type="date" style="font-weight: bold;" name="lastDate">
										</td>
									</tr>
									<tr>
										<td><input type="time" style="font-weight: bold;"
											id="time_entry_end" name="lastTime"></td>
									</tr>
									<tr>
										<td>
											<p id="all_day_text">
												<input type="checkbox" id="all_day_check"
													onclick="connecttextA('time_entry',this.checked);connecttextB('time_entry_end',this.checked);"
													name="checkbox">
												終日チェック
											</p>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<textarea id="memo" placeholder="MEMO" style="font-weight: bold;"name="memo"></textarea>
						</div>
					</div>
					<div class="screen_contents">
						<input type="button" value="戻る" style="font-weight: bold;" onclick="location.href='/machico/CalendarServlet'">
					</div>
					<div class="screen_contents">
						<input type="submit" value="保存" style="font-weight: bold;">
					</div>
				</form>
			</div>
		</section>
	</main>
	<input type="hidden" id="err_message" value="${errMessage}">
	<%--textのJavascriptファイルであることを示す。スクリプトなどのリソースの URL を指定してる。--%>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript"
		src="/machico/js/fixedScheduleRegister.js"></script>
</body>
</html>