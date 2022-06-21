<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="switchdsp">
	<label for="schedule_register_button"> <span class="clicktxt">予定</span>
	</label> <input type="checkbox" id="schedule_register_button">
	<div class="click_plus_screen">
		<div id="click_plus_button">
		<form method="POST" action="/machico/CalendarServlet">
			<input type="submit" id="fixed_scheduled_button" value="固定予定" name="move_fixed">
			<input type="submit" id="regular_scheduled_button" value="定期予定" name="move_regular">
			<input type="submit" id="automatic_scheduled_button" value="自動予定" name="move_automatic">
		</form>
		</div>
	</div>
</div>

