package logic_test;

import java.util.ArrayList;

import beans.CalendarBeans;
import beans.Schedule;
import dao.SchedulesDAO;
import logic.ScheduleLogic;

public class ScheduleLogicTest {

	public static void main(String[] args) {
		SchedulesDAO sdao = new SchedulesDAO();
		Schedule s = new Schedule();
		CalendarBeans cb = new CalendarBeans();
		cb.setCalendarId(1);
		var scheduleList = ScheduleLogic.ScheduleCompile(sdao.select(s, cb));
		for (ArrayList<Schedule> schedules : scheduleList) {
			for (Schedule schedule : schedules) {
				System.out.println(schedule.getSchedule());
			}
		}
	}

}
