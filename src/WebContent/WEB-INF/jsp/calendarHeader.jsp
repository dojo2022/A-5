<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Calendar"%>
<section id="calendar_header">
<img id="calendar_header_title_logo" alt="タイトルロゴ" src="/machico/img/machico_logo.png">
<section id="calendar_header_controller_area">
<div id="arrow-month">
<a id="left_arrow_month" href="/machico/CalendarServlet/${loginUser.calendarIndex}-${loginUser.calendarType}/?date=${prevYearMonth}"><img alt="前の月へ" src="/machico/img/aqua_triangle.png"></a>
<span id="month_text">${loginUser.year}/${loginUser.month + 1}</span>
<a id="right_arrow_month" href="/machico/CalendarServlet/${loginUser.calendarIndex}-${loginUser.calendarType}/?date=${nextYearMonth}" ><img alt="次の月へ" src="/machico/img/aqua_triangle.png"></a>
</div>
<h1 id="calendar_title">${loginUser.calendarList.get(loginUser.calendarIndex).calendarName}</h1>
<div id="calendar_header_button_area">
<button id="current_month_button">今日</button>
<div id="change_calendar_menu">
<select name="calendar_type">
<option value="G" <c:if test="${loginUser.calendarType.equals('G')}">selected</c:if>>マス目</option>
<option value="L" <c:if test="${loginUser.calendarType.equals('L')}">selected</c:if>>リスト</option>
<option value="T" <c:if test="${loginUser.calendarType.equals('T')}">selected</c:if>>Todo</option>
</select>
<img alt="カレンダの見た目を選ぶ" src="/machico/img/yellow_triangle.png">
</div>
<%@ include file="scheduleRegisterTypeMenu.jsp"%>
<input type="hidden" id="calendar_index" value="${loginUser.calendarIndex}">
</div>
</section>

</section>