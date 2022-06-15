package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.CalendarBeans;
import beans.User;

public class CalendarsDAO {
	// カレンダー追加
	public boolean insertCalendar(CalendarBeans param, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			//オートコミットを解除
			conn.setAutoCommit(false);
			// SQL文を準備する
			String sql = "SELECT COUNT(*) FROM calendars WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user.getId());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			rs.next();
			if (rs.getInt("count(*)") >= 3) {

				return false;
			}
			// SQL文を準備する
			String insertSql = "INSERT INTO calendars ( calendar_name, user_id, calendar_type) VALUES (?, ?, ?)";
			PreparedStatement insertPStmt = conn.prepareStatement(insertSql);

			// SQL文を完成させる
			insertPStmt.setString(1, param.getCalendarName());

			insertPStmt.setInt(2, user.getId());

			insertPStmt.setString(3, param.getCalendarType());

			// SQL文を実行し、結果表を取得する
			if (pStmt.executeUpdate() == 1) {
			conn.commit();
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

	//カレンダーロック

	//ロックしてるか確認
	public boolean isLockCalendar(CalendarBeans param, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			//オートコミットを解除

			// SELECT文を準備する
			String sql = "SELECT is_lock FROM calendars WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user.getId());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			rs.next();
			return rs.getBoolean("is_lock");


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

	//ロックする
	public boolean lockCalendar(CalendarBeans param, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			//オートコミットを解除
			conn.setAutoCommit(false);

			String lockNumberSql = "UPDATE calendars SET lock = ? WHERE calendar_id = ?";
			PreparedStatement lockNumberPStmt = conn.prepareStatement(lockNumberSql);

			lockNumberPStmt.setInt(1, param.getLock());

			lockNumberPStmt.setInt(2, param.getCalendarId());

			// SQL文を実行し、結果表を取得する
			if (lockNumberPStmt.executeUpdate() != 1) {
				return false;
			}
			String lockSql = "UPDATE calendars SET is_lock = TRUE WHERE calendar_id = ?";
			PreparedStatement lockPStmt = conn.prepareStatement(lockSql);

			lockPStmt.setInt(1, param.getCalendarId());

			// SQL文を実行し、結果表を取得する
			if (lockPStmt.executeUpdate() == 1) {
				conn.commit();
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

	//ロック解除

	public boolean unLockCalendar(CalendarBeans param, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String unLockSql = "UPDATE calendars SET is_lock = FALSE WHERE calendar_id = ?";
			PreparedStatement unLockPStmt = conn.prepareStatement(unLockSql);

			unLockPStmt.setInt(1, param.getCalendarId());

			// SQL文を実行し、結果表を取得する
			if (unLockPStmt.executeUpdate() != 1) {
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

	//カレンダー削除
	//引数なしでいい？？
	public boolean deleteAccount(CalendarBeans param) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE calendars SET is_delete = TRUE WHERE calendar_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, param.getCalendarId());
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
