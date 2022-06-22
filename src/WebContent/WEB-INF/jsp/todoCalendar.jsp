<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${loginUser.calendarList.get(loginUser.calendarId).calendarName} | machico</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/todoCalendar.css">
</head>
<body>
	<%@ include file="calendarHeader.jsp"%>
	<main>
		<section id="calender">
			<!-- 日付の取得 -->
			<div id= "calendar_body">
				<c:forEach var="index" begin="0" end="${lastDay - 1}">
					<c:if test="${oneMonthSchedule.schedule[index].size() !=0}">
			<!--  日付の表示とスケジュールの取得 -->
					<div id="day${index + 1}">
						<div class="calendar">
							<div id="schedule">
								<div class="date">${index + 1}日</div>
							</div>
							<div id="schedule">
								<section class= "calendar_item">
									<c:forEach var="event" items="${oneMonthSchedule.schedule[index]}">
										<form onclick="this.submit()" action="/machico/CalendarServlet/" method="POST" class="calendar_schedule schedule_type_${event.scheduleType}" >
										${event.schedule}
										     <input type="hidden" name="schedule_id" value="${event.scheduleId}">
     										 <input type="hidden" name="schedule_Type" value="${event.scheduleType}">
										</form>
				 					</c:forEach>
			 					</section>
		 					</div>
			 			</div>
			 		</div>
			 		</c:if>
			 		<c:if test="${oneMonthSchedule.schedule[index].size() ==0}">
			 			<div id="day${index + 1}" class="empty_schedule">
			 			</div>
			 		</c:if>
				</c:forEach>
			</div>
		</section>
	</main>
	<script type="text/javascript" src="/machico/js/base.js"></script>
	<script type="text/javascript" src="/machico/js/calendarHeader.js"></script>
	<script type="text/javascript" src="/machico/js/todoCalendar.js"></script>
</body>
</html>