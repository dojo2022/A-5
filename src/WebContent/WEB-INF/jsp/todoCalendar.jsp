<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${currentCalendar.calendarName}| machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/todoCalendar.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<main>
		<section id="calender">
			<%@ include file="calendarHeader.jsp"%>
			このなかに要素を書いてね(Todo)
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/calendarHeader.js"></script>
	<script type="text/javascript" src="/machico/js/todoCalendar.js"></script>
</body>
</html>