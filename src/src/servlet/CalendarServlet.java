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

		// HttpSession session = request.getSession();
		// セッションから持ってくる予定のカレンダー
		CalendarBeans calendar = new CalendarBeans();
		calendar.setCalendarType("G");
		calendar.setIsLock(false);
		calendar.setCalendarName("テストカレンダ");

		request.setAttribute("currentCalendar", calendar);

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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gridCalendar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
