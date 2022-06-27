package logic_test;

import java.util.ArrayList;

import beans.CalendarBeans;
import beans.Schedule;
import dao.SchedulesDAO;
import logic.ScheduleLogic;

public class ScheduleLogicTest {

	public static void main(String[] args) {
		SchedulesDAO sdao = new SchedulesDAO();
		CalendarBeans cb = new CalendarBeans();
		cb.setCalendarId(1);
		var scheduleList = ScheduleLogic.ScheduleCompile(sdao.select(cb, 2022, 2),2022, 1);
		for (ArrayList<Schedule> schedules : scheduleList) {
			for (Schedule schedule : schedules) {
				System.out.println(schedule.getSchedule());
			}
		}
	}

}
