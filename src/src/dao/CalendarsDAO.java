package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.CalendarBeans;
import beans.User;

public class CalendarsDAO {
	//アレイリストを追加する？？

	//カレンダー取得
	public List<CalendarBeans> select(User user) {
		Connection conn = null;
		List<CalendarBeans> cbList = new ArrayList<CalendarBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * from calendars WHERE user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setInt(1,user.getId());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CalendarBeans cal = new CalendarBeans();
			cal.setCalendarId(rs.getInt("calendar_id"));
			cal.setCalendarName(rs.getString("calendar_name"));
			cal.setUserId(rs.getInt("user_id"));
			cal.setCalendarType(rs.getString("calendar_type"));
			cal.setLock(rs.getInt("lock"));
			cal.setIsLock(rs.getBoolean("is_lock"));

				cbList.add(cal);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cbList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cbList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cbList = null;
				}
			}
		}

		// 結果を返す
		return cbList;
	}


	//カレンダータイトル
	public String[] selectCalendarTitle(User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT calendar_name from calendars WHERE user_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setInt(1,user.getId());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			int i = 0;
			String calendarName[] = new String[3];
			// 結果表をコレクションにコピーする
			while (rs.next()) {

				 calendarName[i] = rs.getString("calendar_name") ;
				 i++;
			}
			return calendarName;
		}
		catch (SQLException e) {
			e.printStackTrace();
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

	// カレンダー追加
	public boolean insertCalendar(CalendarBeans cb, User user) {
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
			String insertSql = "INSERT INTO calendars ( calendar_name, user_id) VALUES (?, ?)";
			PreparedStatement insertPStmt = conn.prepareStatement(insertSql);

			// SQL文を完成させる
			insertPStmt.setString(1, cb.getCalendarName());

			insertPStmt.setInt(2, user.getId());
/*
			insertPStmt.setString(3, param.getCalendarType());
*/
			// SQL文を実行し、結果表を取得する
			if (insertPStmt.executeUpdate() == 1) {
			conn.commit();

			//List.add()でアレイリストに1行追加する。？？
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
	public boolean isLockCalendar(CalendarBeans cb, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			//オートコミットを解除

			// SELECT文を準備する
			String sql = "SELECT is_lock FROM calendars WHERE user_id = ? AND calendar_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user.getId());
			pStmt.setInt(2, cb.getCalendarId());

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
	public boolean lockCalendar(CalendarBeans cb) {
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

			lockNumberPStmt.setInt(1, cb.getLock());

			lockNumberPStmt.setInt(2, cb.getCalendarId());

			// SQL文を実行し、結果表を取得する
			if (lockNumberPStmt.executeUpdate() != 1) {
				return false;
			}
			String lockSql = "UPDATE calendars SET is_lock = TRUE WHERE calendar_id = ?";
			PreparedStatement lockPStmt = conn.prepareStatement(lockSql);

			lockPStmt.setInt(1, cb.getCalendarId());

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

	public boolean unLockCalendar(CalendarBeans cb) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String unLockSql = "UPDATE calendars SET is_lock = FALSE WHERE calendar_id = ?";
			PreparedStatement unLockPStmt = conn.prepareStatement(unLockSql);

			unLockPStmt.setInt(1, cb.getCalendarId());

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
	public boolean deleteAccount(CalendarBeans cb) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE calendars SET is_delete = TRUE WHERE calendar_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, cb.getCalendarId());
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

	//カレンダータイプ変更
	public boolean updateCalendarType( CalendarBeans cb) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE calendars SET  calendar_type = ? WHERE calendar_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<ここも>

			pStmt.setString(1, cb.getCalendarType());

			pStmt.setInt(2, cb.getCalendarId());



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

}
