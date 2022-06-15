package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountCreate.jsp");
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

		//Beanseからとってきたidとnameを u に入れて持ってくる
		User u = uDao.isLoginOK(name, pw);

		// ログイン成功
		if (u != null) {
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", u);

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/servlet/GridCalendarServlet");

			// ログイン失敗
		} else {
			// リクエストスコープにエラーメッセージを格納する
			request.setAttribute("errMessage", "入力内容が間違っています");

			// 結果ページにリダイレクトする
			response.sendRedirect("/WEB-INF/jsp/login.jsp");

		}
	}
}
