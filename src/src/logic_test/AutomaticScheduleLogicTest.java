package logic_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import logic.AutomaticScheduleLogic;

public class AutomaticScheduleLogicTest {
	public static void main(String[] args) throws ParseException {
		for(int i = 0 ; i < 50 ; i++) {
			/*
		SchedulesDAO sdao = new SchedulesDAO();
		Schedule s = new Schedule();
		CalendarBeans cb = new CalendarBeans();
		List<ArrayList<Schedule>> p = ScheduleLogic.ScheduleCompile(sdao.select(cb, 2022, 6));
*/
		  String strDate = "2022-12-25";
		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   Date firstDate = dateFormat.parse(strDate);

		   String stDate = "2023-1-3";
		   SimpleDateFormat lastDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   Date lastDate = lastDateFormat.parse(stDate);

		Date k = AutomaticScheduleLogic.autoSet(firstDate ,lastDate);

		 String str = new SimpleDateFormat("yyyy-MM-dd").format(k);
         System.out.println(str);



	}
	}
}
