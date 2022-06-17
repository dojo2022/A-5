package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class OneMonthSchedule implements Serializable {
	private ArrayList<ArrayList<Schedule>> schedule;

	public OneMonthSchedule() {
		super();
		this.schedule = new ArrayList<ArrayList<Schedule>>(30);
	}

	public ArrayList<ArrayList<Schedule>> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<ArrayList<Schedule>> schedule) {
		this.schedule = schedule;
	}
}
