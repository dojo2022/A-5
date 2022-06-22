package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GridOneMonthSchedule;
import beans.LoginUser;
import beans.OneMonthSchedule;
import beans.Schedule;

/**
 * Servlet implementation class GridCalendarServlet
 */
@WebServlet({ "/CalendarServlet", "/CalendarServlet/*" })
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}

		// URLからCalendarTypeと日付を判定
		Pattern validator = Pattern.compile("^[0-2]-[GLT]$");
		String uri = request.getRequestURI();
		if (uri.substring(uri.length() - 1).equals("/")) {
			uri = uri.substring(0, uri.length() - 1);
		}
		String[] paths = uri.split("/");
		String urlPathParamatar = paths[paths.length - 1];

		if (validator.matcher(urlPathParamatar).find()) {
			String[] calendarAndCalendarTypePair = urlPathParamatar.split("-");
			int calendarIndex = Integer.parseInt(calendarAndCalendarTypePair[0]);
			String calendarType = calendarAndCalendarTypePair[1];

			if (loginUser.getCalendarList().size() > calendarIndex) {
				loginUser.setCalendarId(calendarIndex);
			} else {
				loginUser.setCalendarId(0);
			}
			loginUser.setCalendarType(calendarType);
		} else {
			// urlから値を取得できなければそのまま(現在のCalendarType)で
		}

		// URLから日付を設定
		String urlDate = request.getParameter("date");
		Date date = null;
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
		try {
			date = dateFormater.parse(urlDate);
		} catch (ParseException e) {
			// 読み取れない値が入れられたら無視
		} catch (NullPointerException e) {
			// 読み取れない値が入れられたら無視
		}
		Calendar cal = Calendar.getInstance();

		log(cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH));

		if (date != null) {
			cal.setTime(date);
		} else {
			// urlから値を取得できなければそのまま(現在の日付)で
		}

		loginUser.setYear(cal.get(Calendar.YEAR));
		loginUser.setMonth(cal.get(Calendar.MONTH));

		// 現在の月

		// 現在の月の最終日
		request.setAttribute("lastDay", cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		// 次の月の年と月
		cal.add(Calendar.MONTH, 1);
		request.setAttribute("nextYearMonth", cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1));
		// 前の月の年と月
		cal.add(Calendar.MONTH, -2);
		request.setAttribute("prevYearMonth", cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1));

		// 計算で変化した値を元の日付に戻す
		cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		} else {
			// urlから値を取得できなければそのまま(現在の日付)で
		}

		// 予定をjspに渡す
		OneMonthSchedule oneMonthSchedule = new OneMonthSchedule();
		Schedule s1 = new Schedule();
		s1.setSchedule("今日の天気");
		s1.setScheduleType("F");
		Schedule s2 = new Schedule();
		s2.setSchedule("明日の天気aaaaaaaaaaaaaaaaa");
		s2.setScheduleType("R");
		Schedule s3 = new Schedule();
		s3.setSchedule("昨日の天気");
		s3.setScheduleType("A");
		Schedule s4 = new Schedule();
		s4.setSchedule("明後日の天気");
		s4.setScheduleType("A");
		Schedule s5 = new Schedule();
		s5.setSchedule("しあさっての天気");
		s5.setScheduleType("F");

		ArrayList<Schedule> oneSchedule = new ArrayList<Schedule>();
		oneSchedule.add(s1);
		ArrayList<Schedule> twoSchedule = new ArrayList<Schedule>();
		twoSchedule.add(s1);
		twoSchedule.add(s2);
		ArrayList<Schedule> threeSchedule = new ArrayList<Schedule>();
		threeSchedule.add(s1);
		threeSchedule.add(s3);
		threeSchedule.add(s2);
		ArrayList<Schedule> fourSchedule = new ArrayList<Schedule>();
		fourSchedule.add(s1);
		fourSchedule.add(s3);
		fourSchedule.add(s2);
		fourSchedule.add(s4);
		ArrayList<Schedule> fiveSchedule = new ArrayList<Schedule>();
		fiveSchedule.add(s1);
		fiveSchedule.add(s3);
		fiveSchedule.add(s2);
		fiveSchedule.add(s4);
		fiveSchedule.add(s5);
		oneMonthSchedule.getSchedule().add(oneSchedule);
		oneMonthSchedule.getSchedule().add(twoSchedule);
		oneMonthSchedule.getSchedule().add(threeSchedule);
		oneMonthSchedule.getSchedule().add(fourSchedule);
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		oneMonthSchedule.getSchedule().add(fiveSchedule);

		while (oneMonthSchedule.getSchedule().size() <= 30) {
			oneMonthSchedule.getSchedule().add(new ArrayList<Schedule>());
		}
		request.setAttribute("oneMonthSchedule", oneMonthSchedule);

		// calendarTypeに合わせてjspを変更
		String calendarName;
		switch (loginUser.getCalendarType()) {
		case "L":
			calendarName = "listCalendar";
			break;
		case "T":
			calendarName = "todoCalendar";
			break;
		case "G":
		default:
			calendarName = "gridCalendar";

			request.setAttribute("gridOneMonthSchedule", packToGridOneMonthScedule(
					oneMonthSchedule,
					cal.get(Calendar.YEAR),
					cal.get(Calendar.MONTH)));
			break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/" + calendarName + ".jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String moveRegistration = request.getParameter("move_registration");

		if (moveRegistration != null) {
			switch (moveRegistration) {
			case "固定予定": {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fixedScheduleRegister.jsp");
				dispatcher.forward(request, response);
				return;
			}
			case "定期予定": {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regularScheduleRegister.jsp");
				dispatcher.forward(request, response);
				return;
			}
			case "自動予定": {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleRegister.jsp");
				dispatcher.forward(request, response);
				return;
			}
			default:
				// これ以外の場合は何もしない
			}
		}
		doGet(request, response);
	}

	private GridOneMonthSchedule packToGridOneMonthScedule(OneMonthSchedule schedule, int year, int month) {

		// TODO 後で当日の曜日に直す
		Calendar current = Calendar.getInstance();
		current.set(year, month, 1);
		// 前の月の最後の日
		Calendar prevMonthLastDay = Calendar.getInstance();
		prevMonthLastDay.set(year, month, 1);
		prevMonthLastDay.add(Calendar.MONTH, -1);
		prevMonthLastDay.set(Calendar.DAY_OF_MONTH, prevMonthLastDay.getActualMaximum(Calendar.DAY_OF_MONTH));

		GridOneMonthSchedule gridSchedule = new GridOneMonthSchedule();
		int gridScheduleIndex = 0;
		// カレンダに乗る先月の日付の開始日
		int prevMonthLeftoversStartDay = prevMonthLastDay.getActualMaximum(Calendar.DAY_OF_MONTH)
				- prevMonthLastDay.get(Calendar.DAY_OF_WEEK) + 1;
		// 先月の日付をgridCalDaysに乗せる
		for (int index = 0; index < prevMonthLastDay.get(Calendar.DAY_OF_WEEK); index++) {
			int day = prevMonthLeftoversStartDay + index;
			gridSchedule.set(gridScheduleIndex, day, false, null);
			gridScheduleIndex++;
		}
		// 今月の日付をgridCalDaysに乗せる
		for (int day = 1; day <= current.getActualMaximum(Calendar.DAY_OF_MONTH); day++) {
			if (schedule.getSchedule().size() > day - 1) {
				gridSchedule.set(gridScheduleIndex, day, true, schedule.getSchedule().get(day - 1));
			} else {
				gridSchedule.set(gridScheduleIndex, day, true, null);
			}
			gridScheduleIndex++;
		}
		// 残った範囲に来月の日付をgridCalDaysに乗せる
		int nextMonthLeftoversEndDay = gridSchedule.length - gridScheduleIndex;
		for (int day = 1; day <= nextMonthLeftoversEndDay; day++) {
			gridSchedule.set(gridScheduleIndex, day, false, null);
			gridScheduleIndex++;
		}

		return gridSchedule;
	}
}
