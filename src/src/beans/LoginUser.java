package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class LoginUser implements Serializable {
	private int id;
	private String name;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
