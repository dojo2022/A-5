package dao_test;

import java.util.List;

import beans.CalendarBeans;
import beans.User;
import dao.CalendarsDAO;

public class CalendarsDAO_test {
	public static void main(String[] args) {

//		createCalendar();

//		select();

//		isLockCalendar();

//		lockCalendar();

//		unLockCalendar();

//		updateCalendarType();



			}
	/*
	public static void createCalendar() {

		CalendarsDAO cdao = new CalendarsDAO();
		CalendarBeans cb = new CalendarBeans();
		 User user = new User();
			cb.setCalendarName("テストカレンダ～");
			user.setId(1);
		cdao.insertCalendar(cb,user);
	}

	*/

	public static void select() {
		CalendarsDAO cdao = new CalendarsDAO();
		CalendarBeans cb = new CalendarBeans();
		 User user = new User();
		 user.setId(1);
		List<CalendarBeans>  b = cdao.select(cb, user);
		 for(int i = 0 ; i < b.size(); i++) {
			 System.out.println(b.get(i).getCalendarName());
			 System.out.println(b.get(i).getCalendarType());
			 System.out.println(b.get(i).getCalendarId());
		 }
	}
	/*
	public static void isLockCalendar() {
		CalendarsDAO cdao = new CalendarsDAO();
		CalendarBeans cb = new CalendarBeans();
		 User user = new User();
		 user.setId(1);
		 cb.setCalendarId(1);
		 boolean a = cdao.isLockCalendar(cb, user);
		if(a) {

			System.out.println("ロックされている");
		}else {
			System.out.println("ロックされていない");

		}

	}
	*/
	/*
	public static void lockCalendar() {
		CalendarsDAO cdao = new CalendarsDAO();
		CalendarBeans cb = new CalendarBeans();
		 User user = new User();
		 user.setId(1);
		 cb.setCalendarId(1);
		 cdao.lockCalendar(cb , user);


	}
	*/
/*
	public static void unLockCalendar() {
		CalendarsDAO cdao = new CalendarsDAO();
		CalendarBeans cb = new CalendarBeans();
		 User user = new User();
		 user.setId(1);
		 cb.setCalendarId(1);
		cdao.unLockCalendar(cb , user);
	}
	*/
	/*
	public static void updateCalendarType() {
		CalendarsDAO cdao = new CalendarsDAO();
		CalendarBeans cb = new CalendarBeans();
		 cb.setCalendarId(1);
		cb.setCalendarType("F");
		cdao.updateCalendarType(cb);
	}
	*/
}
