<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="cp_cont">
	<div class="cp_offcm01">
		<input type="checkbox" id="cp_toggle01"> <label for="cp_toggle01"></label>
		<div class="cp_menu">
			<ul>
				<li class="mypage"><a href="#mypage">マイページ</a></li>
				<c:forEach var="calendar" items="${loginUser.calendarList}" varStatus="status">
				<li>
					<a href="/machico/CalendarServlet/${status.index}-${loginUser.calendarType}/?date=${loginUser.year}-${loginUser.month + 1}">${calendar.calendarName}</a>
				</li>
				</c:forEach>
				<li><form action="/machico/CalendarServlet" method="post"><input type="submit" name="move_calendar_registration" value="カレンダーを追加"<%-- ←値が送られて来たかで判定するのでここの値は何でもよい --%>></form></li>
			</ul>
		</div>
	</div>
</div>