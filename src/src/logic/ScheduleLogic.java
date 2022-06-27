package logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import beans.Schedule;

public class ScheduleLogic {

	//メインをただのメソッドにしたとき引数でデータをもらう
	public static List<ArrayList<Schedule>> ScheduleCompile(List<Schedule> ScheduleList, int whatYear, int whatMonth) {
		new SimpleDateFormat();
		List<ArrayList<Schedule>> scheduleData = new ArrayList<ArrayList<Schedule>>();

		//最初に件数が0件のArrayList配列をつくるを31件作ってそこに入れる
		for (int i = 0; i <= 31; i++) {

			scheduleData.add(i, new ArrayList<Schedule>());

		}
		// 予定の開始日
		Calendar whatFirstCalendar = Calendar.getInstance();

		// 予定の終了日
		Calendar whatLastCalendar = Calendar.getInstance();

		//スケジュールリストから日付取得、ArrayListの番号に対応させていれる
		for (int i = 0; i < ScheduleList.size(); i++) {
			// 月の開始日で初期化
			whatFirstCalendar.set(whatYear, whatMonth, 1);
			//月の終了日で初期化
			whatLastCalendar.set(whatYear, whatMonth, whatFirstCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Calendar firstDay = Calendar.getInstance();
			firstDay.setTime(ScheduleList.get(i).getDate());

			// 開始日を調査
			if (whatFirstCalendar.before(firstDay)) {
				whatFirstCalendar = firstDay;
			}
			whatFirstCalendar.set(Calendar.HOUR_OF_DAY, 0);
			whatFirstCalendar.set(Calendar.MINUTE, 0);
			whatFirstCalendar.set(Calendar.SECOND, 0);
			whatFirstCalendar.set(Calendar.MILLISECOND, 0);

			Calendar lastDay = Calendar.getInstance();
			lastDay.setTime(ScheduleList.get(i).getLastDate());
			// 終了日を調査
			if (whatLastCalendar.after(lastDay)) {
				whatLastCalendar = lastDay;
			}
			whatLastCalendar.set(Calendar.HOUR_OF_DAY, 0);
			whatLastCalendar.set(Calendar.MINUTE, 0);
			whatLastCalendar.set(Calendar.SECOND, 0);
			whatLastCalendar.set(Calendar.MILLISECOND, 0);
			for (Calendar day = whatFirstCalendar; day.before(whatLastCalendar) || day.equals(whatLastCalendar); day
					.add(Calendar.DAY_OF_MONTH, 1)) {
				scheduleData.get(day.get(Calendar.DAY_OF_MONTH) - 1).add(ScheduleList.get(i));
			}
		}
		return scheduleData;

	}

}
