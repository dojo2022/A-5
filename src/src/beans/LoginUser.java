package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class LoginUser implements Serializable {
	private int id;
	private String name;
	private ArrayList<CalendarBeans> calendarList;
	private int calendarId;
    private String calendarType;
    private Date date;

    public LoginUser() {
		super();
		calendarId = 0;
		calendarType = "G";
		date = new Date();
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

	public ArrayList<CalendarBeans> getCalendarList() {
		return calendarList;
	}

	public void setCalendarList(ArrayList<CalendarBeans> calendarList) {
		this.calendarList = calendarList;
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public String getCalendarType() {
		return calendarType;
	}

	public void setCalendarType(String calendarType) {
		this.calendarType = calendarType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



}
