package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CalendarBeans;
import beans.LoginUser;
import beans.Schedule;
import dao.SchedulesDAO;
import logic.AutomaticScheduleLogic;

/**
 * Servlet implementation class AutomaticScheduleRegisterServlet
 */
@WebServlet("/AutomaticScheduleRegisterServlet")
public class AutomaticScheduleRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	//Date型をString型にするものを入れる（上にある）
	public Date getDate(String d) { //中身をどうすればいいかわからない
		// SimpleDateFormat をオブジェクト化			// TODO 自動生成された catch ブロック
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
/*
	public Date getDate(String d) { //中身をどうすればいいかわからない
		// SimpleDateFormat をオブジェクト化			// TODO 自動生成された catch ブロック
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	public Date getTime(String d) { //中身をどうすればいいかわからない
		// SimpleDateFormat をオブジェクト化
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return date;
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//もしログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}




		// リクエストパラメータを取得する 項目を全部入れる
		request.setCharacterEncoding("UTF-8");
	//	int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
		String schedule = request.getParameter("autoschedule_new_title");//予定タイトル
		String memo = request.getParameter("memo");
		Date date = new Date();
		Date autoLastDate = this.getDate(request.getParameter("auto_last_date"));//終了日
		boolean aslv = AutomaticScheduleLogic.valitation(date, autoLastDate);

		if(autoLastDate == null) {
			request.setAttribute("errMessage", "登録が失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleRegister.jsp");
			dispatcher.forward(request, response);
			return;

		}
		if(aslv == false) {
			request.setAttribute("errMessage", "登録が失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleRegister.jsp");
			dispatcher.forward(request, response);
			return;

		}

		//終了時間  lastTimeも作る
		//終日チェックも作る
		LoginUser lg = (LoginUser) session.getAttribute("loginUser");
		CalendarBeans cb = lg.getCalendarList().get(lg.getCalendarIndex());
		Schedule sc = new Schedule();
		sc.setCalendarId(cb.getCalendarId());
		sc.setSchedule(schedule);
		sc.setScheduleType("A");
		Date randomDate = AutomaticScheduleLogic.autoSet(date, autoLastDate);
		sc.setDate(randomDate);
//		sc.setTime(null);
		sc.setLastDate(autoLastDate);
		sc.setMemo(memo);
		sc.setAutoLastDate(autoLastDate);;

		//自動予定登録処理
		SchedulesDAO sDao = new SchedulesDAO();//DAOをインスタンスする
		if (sDao.insertSchedule(sc,cb)) {	//項目を合わせる
			response.sendRedirect("/machico/CalendarServlet");

		}
		else {	// 登録失敗
			request.setAttribute("errMessage", "登録が失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleRegister.jsp");
			dispatcher.forward(request, response);
		}

	}

}


