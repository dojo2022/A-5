package beans;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {
	private int scheduleId;
	private String schedule;
	private String scheduleType;
	private Date date;
	private Date time;
	private String memo;
	private int calendarId;
	private Date lastDate;
	private Date lastTime;
	private Date autoLastDate;

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

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getAutoLastDate() {
		return autoLastDate;
	}

	public void setAutoLastDate(Date autoLastDate) {
		this.autoLastDate = autoLastDate;
	}



}
