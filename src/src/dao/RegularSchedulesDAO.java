package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CalendarBeans;
import beans.RegularSchedule;


public class RegularSchedulesDAO {

	//スケジュール取得
		public List<RegularSchedule> select(RegularSchedule regS , CalendarBeans cb , int year , int month) {
			Connection conn = null;
			List<RegularSchedule> regularScheduleList = new ArrayList<RegularSchedule>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "SELECT *from regular_schedules WHERE calendar_id = ? AND date BETWEEN ?  AND ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

					pStmt.setInt(1, cb.getCalendarId());
					pStmt.setString(2, year + "-" + month + "-" + 1 );
					pStmt.setString(3,year + "-" + month + "-" + 31 );


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					RegularSchedule regSch = new RegularSchedule();
					rs.getInt("schedule_id");
					rs.getString("schedule");
					rs.getDate("first_date");
					rs.getDate("last_date");
					rs.getString("memo");
					rs.getInt("calender_id");
					rs.getString("regular_schedule_type");
					rs.getString("regularScheduleValue");

					regularScheduleList.add(regSch);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				regularScheduleList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				regularScheduleList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						regularScheduleList = null;
					}
				}
			}

			// 結果を返す
			return regularScheduleList;
		}

	//定期予定追加
		public boolean insertRegularSchedule(RegularSchedule regS, CalendarBeans cb) {
			Connection conn = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "INSERT INTO regular_schedules ( schedule,first_date, last_date, memo ,"
						+ " calendar_id,regular_schedule_type,regular_schedule_value) VALUES (?,?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				pStmt.setString(1, regS.getSchedule());
				java.sql.Date sqlFirstDate = new java.sql.Date(regS.getFirstDate().getTime());
				pStmt.setDate(2, sqlFirstDate);

				java.sql.Date sqlLastDate = new java.sql.Date(regS.getLastDate().getTime());
				pStmt.setDate(3, sqlLastDate);

				pStmt.setString(4,regS.getMemo());

				pStmt.setInt(5, cb.getCalendarId());

				pStmt.setString(6, regS.getRegularScheduleType());

				pStmt.setString(7,regS.getRegularScheduleValue());

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
		//定期予定変更
		public boolean updateRegularSchedule(RegularSchedule regS, CalendarBeans cb) {
			Connection conn = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "UPDATE regular_schedules SET  schedule =?, first_date =?, last_date=?,"
						+ " memo =?,regular_schedule_type =?, regular_schedule_value=? WHERE calendar_id=? AND schedule_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる<ここも>

				pStmt.setString(1,regS.getSchedule());
				java.sql.Date sqlFirstDate = new java.sql.Date(regS.getFirstDate().getTime());
				pStmt.setDate(2, sqlFirstDate);

				java.sql.Date sqlLastDate = new java.sql.Date(regS.getLastDate().getTime());
				pStmt.setDate(3, sqlLastDate);

				pStmt.setString(4, regS.getMemo());

				pStmt.setString(5, regS.getRegularScheduleType());

				pStmt.setString(6, regS.getRegularScheduleValue());

				pStmt.setInt(7, cb.getCalendarId());

				pStmt.setInt(8, regS.getScheduleId());

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
		public boolean deleteRegularSchedule(RegularSchedule regS) {
			Connection conn = null;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "UPDATE regular_schedules SET is_delete = TRUE WHERE schedule_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setInt(1, regS.getScheduleId());
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
