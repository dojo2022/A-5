package beans;

import java.util.Date;

public class RegularSchedule {
	private int scheduleId;
	private String schedule;
	private Date firstDate;
	private Date lastDate;
	private String memo;
	private int calendarId;
	private String regularScheduleType;
	private String regularScheduleValue;


	public RegularSchedule() {
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
	public Date getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
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
	public String getRegularScheduleType() {
		return regularScheduleType;
	}
	public void setRegularScheduleType(String regularScheduleType) {
		this.regularScheduleType = regularScheduleType;
	}
	public String getRegularScheduleValue() {
		return regularScheduleValue;
	}
	public void setRegularScheduleValue(String regularScheduleValue) {
		this.regularScheduleValue = regularScheduleValue;
	}



}
