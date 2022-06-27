package logic;

import java.util.Calendar;
import java.util.Date;


public class AutomaticScheduleLogic {

	public static Date autoSet(Date date, Date lastDate) {


		Calendar fCal = Calendar.getInstance();
		fCal.setTime(date);
		int firstYear = fCal.get(Calendar.YEAR);

		Calendar fCale = Calendar.getInstance();
		fCale.setTime(date);
		int firstMonth = fCale.get(Calendar.MONTH);

		Calendar calen = Calendar.getInstance();
		calen.setTime(lastDate);
		int lastYear = calen.get(Calendar.YEAR);

		Calendar calend = Calendar.getInstance();
		calend.setTime(lastDate);
		int lastMonth = calend.get(Calendar.MONTH);

		Calendar firstDay = Calendar.getInstance();
		firstDay.setTime(date);

		Calendar lastDay = Calendar.getInstance();
		lastDay.setTime(lastDate);


		Calendar calende = Calendar.getInstance();
		int years = firstYear;
		int months = firstMonth;
		calende.set(years, months, 1);
/*
		int dayMax = calende.getActualMaximum(Calendar.DAY_OF_MONTH);

		int minVal = firstDay;
		int maxVal = lastDay;
*/
	int passMonth =((lastYear - firstYear) * 12) + (lastMonth - firstMonth);
	int randomMonth = (int)(Math.random()* passMonth);

	long diffTime = lastDay.getTimeInMillis() - firstDay.getTimeInMillis();

	//==== 日単位に変換 ====//
	int MILLIS_OF_DAY = 1000 * 60 * 60 * 24;
	int diffDays = (int)(diffTime / MILLIS_OF_DAY);
	int randomDay = (int)(Math.random()* (diffDays + 1));

	fCale.add(Calendar.MONTH, randomMonth);
	fCale.add(Calendar.DAY_OF_MONTH,randomDay);


	Date AutomaticDate = fCale.getTime();

	return AutomaticDate;
	}
	public static boolean valitation(Date date, Date lastDate) {

		  Date date1 = date;
	      Date date2 = lastDate;


	      Calendar c = Calendar.getInstance();
	      c.setTime(date1);
	      c.set(Calendar.HOUR_OF_DAY, 0);
	      c.set(Calendar.MINUTE, 0);
	      c.set(Calendar.SECOND, 0);
	      c.set(Calendar.MILLISECOND, 0);
	      Date d1 = c.getTime();

	      boolean a = d1.equals(date2);
	      if(a) {

	    	  return a;
	      }else {

	    boolean b =  date1.before(date2);

		return b;
	      }
	}

}
