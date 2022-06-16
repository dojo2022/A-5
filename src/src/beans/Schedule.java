package beans;

import java.util.Date;

public class Schedule {
	private int scheduleId;
	private String schedule;
	private String scheduleType;
	private Date date;
	private Date time;
	private String memo;
	private int calendarId;
	private Date lastDate;

	public Schedule() {
		super();
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {

		this.time = time;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {

		this.lastDate = lastDate;
	}

}
