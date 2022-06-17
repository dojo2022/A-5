<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>カレンダー追加 | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/calendarCreate.css">
</head>
<body>
<%@ include file="header.jsp"%>
<main>
	<section id="calendar">
			<form id="calendarCreate-form" method="POST" action="/machico/CalendarCreateServlet">
				<div id="frame">
					<div class="cp_iptxt">
					  <input type="text" placeholder="TITLE(カレンダー)" style="font-weight : bold ;">
					  <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
					</div>
				</div>
				<input type="button" name="cancel" value="キャンセル" style="font-weight: bold;"
					onclick="location.href='/machico/CalendarServlet'">
				<input type="submit" name="save" value="保存" style="font-weight: bold;">
				<input type="hidden" id="err_message" value="${errMessage}">
			</form>
		<script type="text/javascript" src="/machico/js/base.js"></script>
		<script type="text/javascript" src="/machico/js/calendarCreate.js"></script>
	</section>
</main>
</body>
</html>