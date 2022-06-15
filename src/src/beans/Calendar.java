package beans;

public class Calendar {
	private int calendar_id;
	private String calendar_name;
	private int user_id;
	private String calendar_type;
	private boolean is_lock;
	private int lock;



	public Calendar() {
		super();
	}
	public int getCalendar_id() {
		return calendar_id;
	}
	public void setCalendar_id(int calendar_id) {
		this.calendar_id = calendar_id;
	}
	public String getCalendar_name() {
		return calendar_name;
	}
	public void setCalendar_name(String calendar_name) {
		this.calendar_name = calendar_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCalendar_type() {
		return calendar_type;
	}
	public void setCalendar_type(String calendar_type) {
		this.calendar_type = calendar_type;
	}
	public boolean isIs_lock() {
		return is_lock;
	}
	public void setIs_lock(boolean is_lock) {
		this.is_lock = is_lock;
	}
	public int getLock() {
		return lock;
	}
	public void setLock(int lock) {
		this.lock = lock;
	}





}
