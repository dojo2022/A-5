package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class GridOneMonthSchedule implements Serializable {
	public final int length = 42;

	private ArrayList<ArrayList<Schedule>> schedule;
	private int[] days;
	private boolean[] isCurrentDays;

	public GridOneMonthSchedule() {
		super();
		this.days = new int[length];
		this.isCurrentDays = new boolean[length];
		this.schedule = new ArrayList<ArrayList<Schedule>>(length);
	}

	public void set(int index, int day, boolean isCurrentDay, ArrayList<Schedule> schedule) {
		this.days[index] = day;
		this.isCurrentDays[index] = isCurrentDay;
		this.schedule.add(schedule);
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	public boolean[] getIsCurrentDays() {
		return isCurrentDays;
	}

	public void setIsCurrentDays(boolean[] isCurrentDays) {
		this.isCurrentDays = isCurrentDays;
	}

	public ArrayList<ArrayList<Schedule>> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<ArrayList<Schedule>> schedule) {
		this.schedule = schedule;
	}

}
