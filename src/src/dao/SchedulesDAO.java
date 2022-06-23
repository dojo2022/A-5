package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CalendarBeans;
import beans.Schedule;

public class SchedulesDAO {

	//スケジュール取得
	public List<Schedule> select(CalendarBeans cb , int year , int month) {
		Connection conn = null;
		 List<Schedule> scheduleList = new ArrayList<Schedule>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * from schedules WHERE calendar_id = ? AND date BETWEEN ?  AND ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			String firstDate = String.format("%04d-%02d-%02d",year,month ,1);
			String lastdDate = String.format("%04d-%02d-%02d",year,month ,31);


				pStmt.setInt(1, cb.getCalendarId());
				Date sqlFirstDate= Date.valueOf(firstDate);
				pStmt.setDate(2,sqlFirstDate);
				Date sqlLastDate = Date.valueOf(lastdDate);
				pStmt.setDate(3,sqlLastDate);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Schedule sch = new Schedule();
				sch.setScheduleId(rs.getInt("schedule_id"));
				sch.setSchedule( rs.getString("schedule"));
				sch.setScheduleType( rs.getString("schedule_type"));
				sch.setDate(rs.getDate("date"));
				sch.setTime( rs.getDate("time"));
				sch.setLastTime(rs.getDate("last_time"));
				sch.setMemo(rs.getString("memo"));
				sch.setCalendarId(rs.getInt("calendar_id"));
				sch.setLastDate(rs.getDate("last_date"));
				sch.setAutoLastDate(rs.getDate("auto_last_date"));

				scheduleList.add(sch);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			scheduleList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			scheduleList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					scheduleList = null;
				}
			}
		}

		// 結果を返す
		return scheduleList;
	}

	//スケジュールをスケジュールIDで一件取得
		public Schedule select(Schedule schedule) {
			Connection conn = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * from schedules WHERE schedule_id = ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

					pStmt.setInt(1, schedule.getScheduleId());

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				if(rs.next()) {

					Schedule sch = new Schedule();
					sch.setScheduleId(rs.getInt("schedule_id"));
					sch.setSchedule( rs.getString("schedule"));
					sch.setScheduleType( rs.getString("schedule_type"));
					sch.setDate(rs.getDate("date"));
					sch.setTime( rs.getDate("time"));
					sch.setLastTime(rs.getDate("last_time"));
					sch.setMemo(rs.getString("memo"));
					sch.setCalendarId(rs.getInt("calendar_id"));
					sch.setLastDate(rs.getDate("last_date"));
					sch.setAutoLastDate(rs.getDate("auto_last_date"));

					return sch;
				}else {

					return null;
				}
			}
			catch (SQLException e) {
				 return null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				 return null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						 return null;
					}
				}
			}

		}

	//予定追加
	public boolean insertSchedule(Schedule schedule, CalendarBeans cb) {
		Connection conn = null;
		//固定、自動予定追加
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO schedules ( schedule, schedule_type, date, time ,last_time, memo , calendar_id,last_date,auto_last_date) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setString(1, schedule.getSchedule());

			pStmt.setString(2, schedule.getScheduleType());

			java.sql.Date sqlDate = new java.sql.Date(schedule.getDate().getTime());
			pStmt.setDate(3, sqlDate);

			java.sql.Date sqlTime = new java.sql.Date(schedule.getTime().getTime());
			pStmt.setDate(4, sqlTime);

			java.sql.Date sqlLastTime = new java.sql.Date(schedule.getLastTime().getTime());
			pStmt.setDate(5, sqlLastTime);

			pStmt.setString(6, schedule.getMemo());

			pStmt.setInt(7, cb.getCalendarId());

			java.sql.Date sqlLastDate = new java.sql.Date(schedule.getLastDate().getTime());
			pStmt.setDate(8, sqlLastDate);

			java.sql.Date sqlAutoLastDate = new java.sql.Date(schedule.getAutoLastDate().getTime());
			pStmt.setDate(9, sqlAutoLastDate);
			if (pStmt.executeUpdate() == 1) {

				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

	}

	//予定変更
	public boolean updateSchedule(Schedule schedule, CalendarBeans cb) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE schedules SET  schedule =?, date =?, time =?,last_time=?, memo =?,last_date =? ,auto_last_date=? WHERE calendar_id=? AND schedule_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<ここも>

			pStmt.setString(1, schedule.getSchedule());

			java.sql.Date sqlDate = new java.sql.Date(schedule.getDate().getTime());
			pStmt.setDate(2, sqlDate);

			java.sql.Date sqlTime = new java.sql.Date(schedule.getTime().getTime());
			pStmt.setDate(3, sqlTime);

			pStmt.setString(4, schedule.getMemo());

			java.sql.Date sqlLastTime = new java.sql.Date(schedule.getLastTime().getTime());
			pStmt.setDate(5, sqlLastTime);

			java.sql.Date sqlLastDate = new java.sql.Date(schedule.getLastDate().getTime());
			pStmt.setDate(6, sqlLastDate);

			java.sql.Date sqlAutoLastDate = new java.sql.Date(schedule.getAutoLastDate().getTime());
			pStmt.setDate(7, sqlAutoLastDate);

			pStmt.setInt(8, cb.getCalendarId());

			pStmt.setInt(9, schedule.getScheduleId());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}

	//予定削除
	public boolean deleteSchedule(Schedule schedule) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE schedules SET is_delete = TRUE WHERE schedule_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, schedule.getScheduleId());
			// SQL文を実行する
			if (pStmt.executeUpdate() != 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

	}

}
