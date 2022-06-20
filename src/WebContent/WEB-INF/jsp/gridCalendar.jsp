<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="beans.OneMonthSchedule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${currentCalendar.calendarName} | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/gridCalendar.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<main>
		<section id="calender">
			<%@ include file="calendarHeader.jsp"%>
			<section id= "calendar_day_of_week_container">
				<section class="day_of_week_item sunday">日</section>
				<section class="day_of_week_item">月</section>
				<section class="day_of_week_item">火</section>
				<section class="day_of_week_item">水</section>
				<section class="day_of_week_item">木</section>
				<section class="day_of_week_item">金</section>
				<section class="day_of_week_item saturday">土</section>
			</section>
			<section id="calendar_body">
				<c:forEach var="index" begin="0" end="41">
				<c:if test="${(index + 1) % 7 == 1}">
				<div class="calendar_row">
				</c:if>
				<c:if test="${gridOneMouthSchedule.isCurrentDays[index]}">
					<a href="/machico/CalendarServlet/T/?data${year}-${month + 1}#day${gridOneMouthSchedule.days[index]}">
				</c:if>
						<section class="calendar_item <c:if test="${gridOneMouthSchedule.isCurrentDays[index]}">is_current_day</c:if>" >
						<section>${gridOneMouthSchedule.days[index]}</section>
						<c:choose>
    					<c:when test="${gridOneMouthSchedule.schedule[index].size() == 1 }">
						<section class="calendar_schedule schedule_type_${gridOneMouthSchedule.schedule[index][0].scheduleType}" >${gridOneMouthSchedule.schedule[index][0].schedule}</section>
    					</c:when>
    					<c:when test="${gridOneMouthSchedule.schedule[index].size() == 2 }">
						<section class="calendar_schedule schedule_type_${gridOneMouthSchedule.schedule[index][0].scheduleType}" >${gridOneMouthSchedule.schedule[index][0].schedule}</section>
						<section class="calendar_schedule schedule_type_${gridOneMouthSchedule.schedule[index][1].scheduleType}" >${gridOneMouthSchedule.schedule[index][1].schedule}</section>
						</c:when>
						<c:when test="${gridOneMouthSchedule.schedule[index].size() >= 3 }">
						<section class="calendar_schedule schedule_type_${gridOneMouthSchedule.schedule[index][0].scheduleType}">${gridOneMouthSchedule.schedule[index][0].schedule}</section>
						<section class="calendar_schedule schedule_type_${gridOneMouthSchedule.schedule[index][1].scheduleType}" >${gridOneMouthSchedule.schedule[index][1].schedule}</section>
						<section class="leftover_count">+${gridOneMouthSchedule.schedule[index].size() - 2}</section>
						</c:when>
						</c:choose>
						</section>
				<c:if test="${gridOneMouthSchedule.isCurrentDays[index]}">
					</a>
				</c:if>
				<c:if test="${(index + 1) % 7 == 0}">
				</div>
				</c:if>

				</c:forEach>
			</section>
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/calendarHeader.js"></script>
	<script type="text/javascript" src="/machico/js/gridCalendar.js"></script>
</body>
</html>