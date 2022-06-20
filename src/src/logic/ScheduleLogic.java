package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import beans.Schedule;

public class ScheduleLogic {

	//メインをただのメソッドにしたとき引数でデータをもらう
	public static List<ArrayList<Schedule>> ScheduleCompile(List<Schedule> ScheduleList) {

		List<ArrayList<Schedule>> scheduleData = new ArrayList<ArrayList<Schedule>>();

		//最初に件数が0件のArrayList配列をつくるを30件作ってそこに入れる
		for (int i = 0; i < 30; i++) {

			scheduleData.add(i, new ArrayList<Schedule>());

		}
		//スケジュールリストから日付取得、ArrayListの番号に対応させていれる
		for (int i = 0; i < ScheduleList.size(); i++) {

			Date day = ScheduleList.get(i).getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			int schDay = cal.get(Calendar.DAY_OF_MONTH) - 1;
			scheduleData.get(schDay).add(ScheduleList.get(i));

		}
		return scheduleData;

	}

}
