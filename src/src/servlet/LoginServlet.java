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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user_name_textbox");
		String pw = request.getParameter("password_textbox");
		// ログイン処理を行う
		UserDAO uDao = new UserDAO();
		CalendarsDAO cDao = new CalendarsDAO();

		//Beansからとってきたidとnameを u に入れて持ってくる
		User u = uDao.isLoginOK(name, pw);

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

			// 暫定マス目カレンダーにリダイレクトする
			response.sendRedirect("/machico/CalendarServlet");

			// ログイン失敗
		} else {
			// リクエストスコープにエラーメッセージを格納する
			request.setAttribute("errMessage", "入力内容が間違っています");

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);

		}
	}
}
