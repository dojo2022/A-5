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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}

		//foward先のjsp書き換え servletに行く？
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sevlet/CarendarServlet.java");
		dispatcher.forward(request, response);




	}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("/machico/LoginServlet");
			return;
		}


		//Date型をString型にするものを入れる（上にある）

		// リクエストパラメータを取得する 項目を全部入れる
		request.setCharacterEncoding("UTF-8");
	//	int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
		String schedule = request.getParameter("schedule");//予定タイトル
		String scheduleType = request.getParameter("scheduleType");
		Date date = this.getDate(request.getParameter("date"));//開始
		Date time = this.getTime(request.getParameter("time"));//開始時間
		String memo = request.getParameter("memo");
	//	int calendarId = Integer.parseInt(request.getParameter("calendarId"));		//int型もString型にするものが必要？→Integer.parseInt()で解決
		Date lastDate = this.getDate(request.getParameter("lastDate"));//終了日
		Date lastTime = this.getDate(request.getParameter("lastTime"));//終了時間
		String isDayCheckBox = request.getParameter("checkbox");//チェックボックス
//ここで値を治す
//終日チェックがtrueだったら文字列を置き換える→get.timeを書く
		//変数の中身を変える＝時間を書き換える

		//終日チェックも作る
		//終日チェック　終了チェックを取ってくる。終了時間が23時59分になるようにする。
		//チェックの戻り値は・・・バリュー値が設定できる。（複数チェックはカンマ区切り）
		//１が入ってくるか入ってこないか？空文字？
		//値取ったらbooleanに変換する＝ONOFF判定
		//Offだったらtimeをそのまま渡す　
		//Onはカレンダークラスを使う必要がある
		//開始時刻と終日チェックがTRUEだったら、開始時刻と終了時刻に入れる値を用意される

		CalendarBeans cb = (CalendarBeans)session.getAttribute("currentCalendar");

		Schedule sc = new Schedule();
		sc.setCalendarId(cb.getCalendarId());
		sc.setSchedule(schedule);
		sc.setScheduleType(scheduleType);
		sc.setDate(date);
		sc.setTime(time);
		sc.setMemo(memo);
		sc.setLastDate(lastDate);
		sc.setLastTime(lastTime);
		sc.setCheckbox(isDayCheckBox);

		//固定予定登録処理
		SchedulesDAO sDao = new SchedulesDAO();//DAOをインスタンスする

		if (sDao.insertSchedule(sc,cb )) {	//↑の項目が入ってる
			request.setAttribute("msg","登録が完了しました");
		}
		else {	// 登録失敗
			request.setAttribute("msg","登録が失敗しました");//エラー表示hiddenのやつ掲示板に乗ってるよ
		}


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sevlet/CarendarServlet");
		dispatcher.forward(request, response);

//ついてたら時間をそのままいれる
		//無かったら開始を00時00分終わりを23-59
		//タイムを00-00に書き換える
		//終わりを23-59で文字列にする


	}

}
