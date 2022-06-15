package beans;

import java.io.Serializable;

public class OneMonthSchedule implements Serializable {
	private Schedule[] schedule;

	public OneMonthSchedule() {
		super();
		this.schedule = new Schedule[30];
	}

	public Schedule[] getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule[] schedule) {
		this.schedule = schedule;
	}
}
