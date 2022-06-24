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
import logic.ValidationLogic;

/**
 * Servlet implementation class AutomaticScheduleEditServlet
 */
@WebServlet("/AutomaticScheduleEditServlet")
public class AutomaticScheduleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Date型をString型にするもの
	public Date getDate(String d) {

		// SimpleDateFormat をオブジェクト化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean before(Date lastDate) {
		Date date = new Date();

		return date.before(lastDate);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String schedule = request.getParameter("autoschedule_edit_title"); //予定タイトル
		Date lastDate = this.getDate(request.getParameter("auto_last_date")); //締切日
		String memo = request.getParameter("memo"); //メモ
		int scheduleId = Integer.parseInt(request.getParameter("schedule_id"));

		//登録できなかった時情報を保持する
		//日付が保持されていないので修正必要!!!!!
		Schedule editedSchedule = new Schedule();
		editedSchedule.setLastDate(lastDate);
		editedSchedule.setSchedule(schedule);
		editedSchedule.setMemo(memo);
		editedSchedule.setScheduleId(scheduleId);
		request.setAttribute("editedSchedule", editedSchedule);

		//タイトルが入っていない場合をはじく
		if (ValidationLogic.checkScheduleName(schedule) == false) {
			request.setAttribute("errMessage", "タイトルを入力してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleEdit.jsp");
			dispatcher.forward(request, response);

			return;
		}

		//締切日が入っていない場合をはじく
		if (lastDate == null) {
			request.setAttribute("errMessage", "締切日を入力してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleEdit.jsp");
			dispatcher.forward(request, response);

			return;
		}

		//日付が前後していないかバリテーションチェック入れる
		boolean checkDate = before(lastDate);
		if (!checkDate) {
			return;
		}

		//ログインユーザーが持つカレンダーIdを持ってくる
		LoginUser lg = (LoginUser) session.getAttribute("loginUser");
		CalendarBeans cal = lg.getCalendarList().get(lg.getCalendarIndex());

		//スケジュールBeansインスタンス化
		Schedule sc = new Schedule();
		sc.setScheduleId(scheduleId);
		SchedulesDAO scheduleDAO = new SchedulesDAO();
		sc = scheduleDAO.select(sc);
		sc.setSchedule(schedule);
		sc.setMemo(memo);
		sc.setLastDate(lastDate);
		sc.setDate(lastDate);

		//PASSの時は日付を変える
		if (request.getParameter("SUBMIT").equals("PASS")) {
			Date dateN = new Date();
			Date randomDate = AutomaticScheduleLogic.autoSet(dateN, lastDate);
			sc.setDate(randomDate);
			sc.setLastDate(lastDate);
			sc.setAutoLastDate(lastDate);
		}
		//スケジュールDAO呼ぶ
		SchedulesDAO sDao = new SchedulesDAO();

		//登録処理
		if (sDao.updateSchedule(sc, cal)) {
			//カレンダーにフォワードする
			response.sendRedirect("/machico/CalendarServlet");
		} else {
			//登録できなかった時の処理
			request.setAttribute("errMessage", "変更ができませんでした");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/automaticScheduleEdit.jsp");
			dispatcher.forward(request, response);
		}

	}
}
