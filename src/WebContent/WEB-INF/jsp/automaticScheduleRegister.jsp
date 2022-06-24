<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>自動予定登録 | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/automaticScheduleRegister.css">
</head>
<body>
<%@ include file="header.jsp"%>
	<main>
		<section id="calender">
			<div class="background_img">
				<form id="automatic-schedule-form"method="POST"action="/machico/AutomaticScheduleRegisterServlet">
					<div class="screen_contents">
						<div id="frame">
							<table id="title_area">
								<tr>
									<td>
										<div class="cp_iptxt">
											<input type="text" id="calendar_new_title" name="autoschedule_new_title" placeholder="タイトル"
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
							<table id="date_table">
								<tr>
									<td><label><b>締切日</b></label></td>
								</tr>
								<tr>
									<td><input type="date"name="auto_last_date" style="font-weight: bold;">
									</td>
								</tr>
							</table>
							<br>
							<textarea id="memo" placeholder="MEMO"name="memo" style="font-weight: bold;"></textarea>
						</div>
					</div>
					<div class="screen_contents">
						<input type="button" value="戻る" style="font-weight: bold;" onclick="location.href='/machico/CalendarServlet'">
					</div>
					<div class="screen_contents">
						<input type="submit" value="保存" style="font-weight: bold;">
					</div>
					<input type="hidden" id="err_message" value="">
				</form>
			</div>
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript"
		src="/machico/js/automaticScheduleRegister.js"></script>
</body>
</html>