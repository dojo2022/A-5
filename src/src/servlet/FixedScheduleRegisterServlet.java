package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;//DateをStringにする
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

/**
 * Servlet implementation class FixedScheduleRegisterServlet
 */
@WebServlet("/FixedScheduleRegisterServlet") //@WebServletアノテーションを使ってサーブレットのためのURLパターンを宣言する。
public class FixedScheduleRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //シリアライズなクラスのバージョンを管理するためにある

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	//Date型をString型にするもの
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
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}

		//Date型をString型にするものを入れる（上にある）

		// リクエストパラメータを取得する 項目を全部入れる
		request.setCharacterEncoding("UTF-8");
		//	int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
		String schedule = request.getParameter("schedule");//予定タイトル
		Date date = this.getDate(request.getParameter("date"));//開始
		Date time=this.getTime("00:00"); //開始時間
		if(request.getParameter("time")!=null) {
			time = this.getTime(request.getParameter("time"));
		}

		String memo = request.getParameter("memo");
		//	int calendarId = Integer.parseInt(request.getParameter("calendarId"));		//int型もString型にするものが必要？→Integer.parseInt()で解決
		Date lastDate = this.getDate(request.getParameter("lastDate"));//終了日
		Date lastTime = this.getTime(request.getParameter("lastTime"));//終了時間

		String[] isDayCheckBox = request.getParameterValues("checkbox");//チェックボックス
//
		String d = "00:00";//開始
		if (isDayCheckBox != null) {//取得した場合
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			try {
				time = sdf.parse(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String dend = "23:59";//終了
		if (isDayCheckBox  != null) {//取得した場合
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			try {
				lastTime = sdf.parse(dend);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		LoginUser lg = (LoginUser) session.getAttribute("loginUser");
		CalendarBeans cb = lg.getCalendarList().get(lg.getCalendarIndex());

		Schedule sc = new Schedule();
		sc.setCalendarId(cb.getCalendarId());
		sc.setSchedule(schedule);
		sc.setScheduleType("F");
		sc.setDate(date);
		sc.setTime(time);
		sc.setMemo(memo);
		sc.setLastDate(lastDate);
		sc.setLastTime(lastTime);

		//固定予定登録処理
		SchedulesDAO sDao = new SchedulesDAO();//DAOをインスタンスする

		if (sDao.insertSchedule(sc, cb)) { //↑の項目が入ってる
			response.sendRedirect("/machico/CalendarServlet");
		} else { // 登録失敗
			request.setAttribute("errMessage", "登録が失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/fixedScheduleRegister.jsp");
			dispatcher.forward(request, response);

		}

	}

}
