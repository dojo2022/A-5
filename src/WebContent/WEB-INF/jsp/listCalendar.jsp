<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${loginUser.calendarList.get(loginUser.calendarIndex).calendarName} | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/listCalendar.css">
</head>
<body>
	<%@ include file="sideMenu.jsp" %>
	<%@ include file="calendarHeader.jsp"%>

	<main>
		<section id="calender">
			このなかに要素を書いてね(List)
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/sideMenu.js"></script>
	<script type="text/javascript" src="/machico/js/calendarHeader.js"></script>
	<script type="text/javascript" src="/machico/js/listCalendar.js"></script>
</body>
</html>