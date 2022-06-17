package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class OneMonthSchedule implements Serializable {
	private ArrayList<Schedule> schedule;

	public OneMonthSchedule() {
		super();
		this.schedule = new  ArrayList<Schedule>();
	}

	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Schedule> schedule) {
		this.schedule = schedule;
	}
}
