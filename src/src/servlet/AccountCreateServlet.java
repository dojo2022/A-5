package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import logic.ValidationLogic;

/**
 * Servlet implementation class AccountCreateServlet
 */
@WebServlet("/AccountCreateServlet")
public class AccountCreateServlet extends HttpServlet {
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
			String new_name = request.getParameter("new_user_name_textbox");
			String new_pw = request.getParameter("new_password_textbox");

			UserDAO uDao = new UserDAO();

			if (!ValidationLogic.checkUserName(new_name)) {
				request.setAttribute("errMessage", "半角英数字と_のみで入力してください");
				//アカウント作成画面にもどるよ
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountCreate.jsp");
				dispatcher.forward(request, response);
			} else if (!uDao.isExistUser(new_name)) {
				request.setAttribute("errMessage", "このアカウントは使用されています");
				//アカウント作成画面にもどるよ
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountCreate.jsp");
				dispatcher.forward(request, response);
			} else {
				// リクエスト領域（Attribute）に保存する
				request.setAttribute("new_name", new_name);
				request.setAttribute("new_pw", new_pw);

				// 最初のカレンダー作成画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/firstCalendarCreate.jsp");
				dispatcher.forward(request, response);
			}


	}

}
