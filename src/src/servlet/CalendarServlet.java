package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CalendarBeans;

/**
 * Servlet implementation class GridCalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("loginUser") == null) {
//			response.sendRedirect("/machico/LoginServlet");
//			return;
//		}

		CalendarBeans calendar = (CalendarBeans) session.getAttribute("currentCalendar");

		// カレンダーが無ければDAOから持ってくる
		if (calendar == null) {
			// セッションから持ってくる予定のカレンダー
			// TODO 後でDAOに置き換える
			calendar = new CalendarBeans();
			calendar.setCalendarType("G");
			calendar.setIsLock(false);
			calendar.setCalendarName("テストカレンダ");
			session.setAttribute("currentCalendar", calendar);
		}

		// URLから日付を設定
		String urlDate = request.getParameter("date");
		Date date = null;
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
		try {
			date = dateFormater.parse(urlDate);
		} catch (ParseException e) {
			// 読み取れない値が入れられたら無視
			e.printStackTrace();
		} catch (NullPointerException e) {
			// 読み取れない値が入れられたら無視
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		log(cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH));

		if (date != null) {
			cal.setTime(date);
		} else {
			// urlから値を取得できなければそのまま(現在の日付)で
		}
		log(cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH));
		// 現在の月
		request.setAttribute("month", cal.get(Calendar.MONTH));
		// 次の月の年と月
		cal.add(Calendar.MONTH, 1);
		request.setAttribute("nextYearMouth", cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1));
		// 前の月の年と月
		cal.add(Calendar.MONTH, -2);
		request.setAttribute("prevYearMouth", cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1));

		// calendarTypeに合わせてjspを変更
		String calendarName;
		switch (calendar.getCalendarType()) {
		case "L":
			calendarName ="listCalendar";
			break;
		case "T":
			calendarName ="todoCalendar";
			break;
		case "G":
		default:
			calendarName ="gridCalendar";
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
//		if (session.getAttribute("loginUser") == null) {
//			response.sendRedirect("/machico/LoginServlet");
//			return;
//		}

		request.setCharacterEncoding("UTF-8");
		// calendarTypeが変わっていたら、カレンダーの種類を変更
		String calendarType = request.getParameter("calendar_type");
		if (calendarType != null){
			CalendarBeans calendar = (CalendarBeans) session.getAttribute("currentCalendar");
			calendar.setCalendarType(calendarType);
		}

		doGet(request, response);
	}

}
