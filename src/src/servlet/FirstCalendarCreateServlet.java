package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CalendarBeans;
import beans.LoginUser;
import beans.User;
import dao.CalendarsDAO;
import dao.UserDAO;
import logic.ValidationLogic;

/**
 * Servlet implementation class FirstCalendarCreateServlet
 */
@WebServlet("/FirstCalendarCreateServlet")
public class FirstCalendarCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/firstCalendarCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String new_name = request.getParameter("new_user_name_textbox");
		String new_pw = request.getParameter("new_password_textbox");
		String new_title = request.getParameter("new_title_textbox");

		UserDAO uDao = new UserDAO();
		CalendarsDAO cDao = new CalendarsDAO();

		if (!ValidationLogic.checkCalendarName(new_title)) {
			request.setAttribute("errMessage", "入力内容が間違っています");
			//最初のカレンダー画面にもどるよ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/firstCalendarCreate.jsp");
			dispatcher.forward(request, response);
		} else {
			//Beansにタイトル入れる
			CalendarBeans cb = new CalendarBeans();
			cb.setCalendarName(new_title);

			if (uDao.createAccount(new_name, new_pw, cb)) {
				//Beansからとってきたidとnameを u に入れて持ってくる

				User u = uDao.isLoginOK(new_name, new_pw);

				// ログイン成功
				if (u != null) {

					LoginUser loginUser = new LoginUser();
					loginUser.setId(u.getId());
					loginUser.setName(u.getName());
					List<CalendarBeans> calendars = cDao.select(u);
					loginUser.setCalendarList((ArrayList<CalendarBeans>) calendars);

					// セッションスコープにIDを格納する
					HttpSession session = request.getSession();
					session.setAttribute("loginUser",loginUser);


					// マス目カレンダーにフォワードする
					// 暫定マス目カレンダーにリダイレクトする
					response.sendRedirect("/machico/CalendarServlet");
				} else {
					// リクエストスコープにエラーメッセージを格納する
					request.setAttribute("errMessage", "エラーが発生しました。アカウントは作成済です。");

					// ログイン画面にフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
				}

			} else {
				//アカウント登録失敗
				request.setAttribute("errMessage", "アカウント作成に失敗しました。");
				//カレンダー追加画面に戻る処理
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/firstCalendarCreate.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
