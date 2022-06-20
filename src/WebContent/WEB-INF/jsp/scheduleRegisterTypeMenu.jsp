<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/machico/css/scheduleRegisterTypeMenu.css">

<div class="switchdsp">
	<label for="schedule_register_button"> <span class="clicktxt">予定</span>
	</label> <input type="checkbox" id="schedule_register_button">
	<div class="click_plus_screen">
		<div id="click_plus_button">
			<input type="button" id="fixed_scheduled_button" value="固定予定"
				onclick="location.href='/machico/FixedScheduleRegisterServlet'">
			<input type="button" id="regular_scheduled_button" value="定期予定"
				onclick="location.href='/machico/RegularScheduleRegisterServlet'">
			<input type="button" id="automatic_scheduled_button" value="自動予定"
				onclick="location.href='/machico/AutomaticScheduleRegisterServlet'">
		</div>
	</div>
</div>

