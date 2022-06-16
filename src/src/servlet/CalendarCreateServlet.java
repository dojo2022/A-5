package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CalendarBeans;
import beans.User;
import dao.CalendarsDAO;
import logic.ValidationLogic;

/**
 * Servlet implementation class CalendarCreateServlet
 */
@WebServlet("/CalendarCreateServlet")
public class CalendarCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}

		//フォワード先のjsp書き換え
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendarCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}

		//calendarCreate.jspから入力されたカレンダータイトルを取得
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title-textbox");

		//バリデーションをインポート(要確認！！)
		//Boolean vl = ValidationLogic.checkCalendarName(title);

		if(ValidationLogic.checkCalendarName(title) ==false) {
			request.setAttribute("errMessage", "カレンダー追加できませんでした");
			//カレンダー追加画面に戻る処理かく？
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendarCreate.jsp");
			dispatcher.forward(request, response);
		}

		//カレンダー登録処理↓↓

		//DAO呼ぶ
		CalendarsDAO cDao = new CalendarsDAO();

		//ログインしているユーザーを呼ぶ
		User user =(User) session.getAttribute("loginUser");

		//Beansにタイトル入れる
		CalendarBeans cb = new CalendarBeans();
		cb.setCalendarName(title);

		if(cDao.insertCalendar(cb, user) == true) {
			//カレンダーにリダイレクトする
			response.sendRedirect("/machico/CalendarServlet");
		}else {
			//DAOではじかれたときのメッセージ表示
			request.setAttribute("errMessage", "カレンダー追加できませんでした");
			//カレンダー追加画面に戻る処理
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendarCreate.jsp");
			dispatcher.forward(request, response);
		}

	}

}
