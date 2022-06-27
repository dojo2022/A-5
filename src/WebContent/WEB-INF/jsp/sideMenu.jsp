<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="cp_cont">
	<div class="cp_offcm01">
		<input type="checkbox" id="cp_toggle01"> <label for="cp_toggle01"></label>
		<div class="cp_menu">
			<ul>
				<li class="mypage"><a href="/machico/MypageServlet">マイページ</a></li>
				<c:forEach var="calendar" items="${loginUser.calendarList}" varStatus="status">
				<li class="sidemenu_calendar_item">
					<a href="/machico/CalendarServlet/${status.index}-${loginUser.calendarType}/?date=${loginUser.year}-${loginUser.month + 1}">${calendar.calendarName}</a>
					<label>
			            <span><img src="/machico/img/context_icon.png" width="30px"></span>
			            <input type="checkbox" name="checkbox" class="context_button">
			            <div class="popup">
			                <ul class="context_menu">
			                    <li>削除</li>
			                </ul>
			            </div>
			        </label>
				</li>
				</c:forEach>
				<li><form action="/machico/CalendarServlet" method="post"><input type="submit" name="move_calendar_registration" value="カレンダーを追加"<%-- ←値が送られて来たかで判定するのでここの値は何でもよい --%>></form></li>
			</ul>
		</div>
	</div>
</div>