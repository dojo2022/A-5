package dao_test;

import java.util.Date;
import java.util.List;

import beans.CalendarBeans;
import beans.Schedule;
import dao.SchedulesDAO;

public class SchedulesDAO_test {

	public static void main(String[] args) {
//		insertSchedule();

		select();

//		updateSchedule();

//		deleteSchedule();
	}

	public static void insertSchedule() {

		SchedulesDAO sdao = new SchedulesDAO();
		Schedule s = new Schedule();
		CalendarBeans cb = new CalendarBeans();
		Date d = new Date();
		cb.setCalendarId(1);
		s.setSchedule("テスト");
		s.setDate(d);
		s.setLastDate(d);
		s.setMemo("aaaaaaaaaaa");
		s.setScheduleType("F");
		s.setTime(d);
		sdao.insertSchedule(s, cb);
	}

	public static void select() {

		SchedulesDAO sdao = new SchedulesDAO();
		CalendarBeans cb = new CalendarBeans();
		cb.setCalendarId(1);
		List<Schedule> list = sdao.select(cb, 2022, 6);
		System.out.println(list.size());


	}

	public static void updateSchedule() {
		SchedulesDAO sdao = new SchedulesDAO();
		Schedule s = new Schedule();
		CalendarBeans cb = new CalendarBeans();
		Date d = new Date();
		cb.setCalendarId(1);
		s.setScheduleId(1);
		s.setSchedule("テストだな");
		s.setDate(d);
		s.setLastDate(d);
		s.setMemo("更新");
		s.setTime(d);
		sdao.updateSchedule(s, cb);
	}

	public static void deleteSchedule() {
		SchedulesDAO sdao = new SchedulesDAO();
		Schedule s = new Schedule();
		s.setScheduleId(1);
		sdao.deleteSchedule(s);

	}


}
