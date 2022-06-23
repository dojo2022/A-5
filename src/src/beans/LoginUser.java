package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class LoginUser extends User implements  Serializable {
	private ArrayList<CalendarBeans> calendarList;
	private int calendarIndex;
	private String calendarType;

    private int year;
    private int month;

    public LoginUser() {
		super();
		calendarType = "G";
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getCalendarIndex() {
		return calendarIndex;
	}

	public void setCalendarIndex(int calendarIndex) {
		this.calendarIndex = calendarIndex;
	}

	public ArrayList<CalendarBeans> getCalendarList() {
		return calendarList;
	}

	public void setCalendarList(ArrayList<CalendarBeans> calendarList) {
		this.calendarList = calendarList;
	}

	public String getCalendarType() {
		return calendarType;
	}

	public void setCalendarType(String calendarType) {
		this.calendarType = calendarType;
	}




}
