package dao_test;

import java.util.Date;

import beans.CalendarBeans;
import beans.RegularSchedule;
import dao.RegularSchedulesDAO;

public class RegularSchedulesDAO_test {

	public static void main(String[] args) {
	//	insertRegularSchedule();
		updateRegularSchedule();





	}

	public static void insertRegularSchedule() {
		RegularSchedulesDAO rsdao = new RegularSchedulesDAO();
		RegularSchedule rs = new RegularSchedule();
		CalendarBeans cb = new CalendarBeans();
		Date d = new Date();
		cb.setCalendarId(1);
		rs.setSchedule("テスト");
		rs.setFirstDate(d);
		rs.setLastDate(d);
		rs.setMemo("aaaaaaaaaaa");
		rs.setRegularScheduleType("Y");
		rs.setRegularScheduleValue("1 , 2");
		rsdao.insertRegularSchedule(rs, cb);
			}

	public static void updateRegularSchedule(){
		RegularSchedulesDAO rsdao = new RegularSchedulesDAO();
		RegularSchedule rs = new RegularSchedule();
		CalendarBeans cb = new CalendarBeans();
		Date d = new Date();
		cb.setCalendarId(1);
		rs.setScheduleId(1);
		rs.setSchedule("テストだと");
		rs.setFirstDate(d);
		rs.setLastDate(d);
		rs.setMemo("bbbbb");
		rs.setRegularScheduleType("M");
		rs.setRegularScheduleValue("4 , 6");
		rsdao.updateRegularSchedule(rs, cb);

	}
}
