<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="cp_cont">
	<div class="cp_offcm01">
		<input type="checkbox" id="cp_toggle01"> <label for="cp_toggle01"></label>
		<div class="cp_menu">
			<ul>
				<li class="mypage"><a href="#mypage">マイページ</a></li>
				<c:forEach var="calendar" items="${loginUser.calendarList}" varStatus="status">
				<li>
					<a href="/machico/CalendarServlet/${status.index}-${loginUser.calendarType}/?date=${loginUser.year}-${loginUser.month}">${calendar.calendarName}</a>
				</li>
				</c:forEach>
				<li><a href="#clendar">カレンダーを追加</a></li>
			</ul>
		</div>
	</div>
</div>