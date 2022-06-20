package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.CalendarBeans;
import beans.User;

public class UserDAO {


//ログイン
	public User isLoginOK(String name, String pw) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT user_id , user_name FROM users WHERE user_name = ? AND user_password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする

			//IDとname取得、Userを返す
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("user_name"));

				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	//ユーザーネームが被ってないか
	public boolean isExistUser(String name) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			//オートコミットを解除
			conn.setAutoCommit(false);

			//ユーザーネーム被っているかのSQL
			String nameCountSql = "SELECT COUNT(*) FROM users WHERE user_name = ?";
			PreparedStatement nameCountPStmt = conn.prepareStatement(nameCountSql);
			nameCountPStmt.setString(1, name);

			// SQL文を実行し、結果表を取得する
			ResultSet nameCountRs = nameCountPStmt.executeQuery();

			nameCountRs.next();
			if (nameCountRs.getInt("count(*)")  == 0) {

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

//アカウント作成
	public boolean createAccount(String name, String pw ,CalendarBeans cb) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			//オートコミットを解除
			conn.setAutoCommit(false);

			//ユーザーネーム被っているかのSQL
			String nameCountSql = "SELECT COUNT(*) FROM users WHERE user_name = ?";
			PreparedStatement nameCountPStmt = conn.prepareStatement(nameCountSql);
			nameCountPStmt.setString(1, name);

			// SQL文を実行し、結果表を取得する
			ResultSet nameCountRs = nameCountPStmt.executeQuery();

			nameCountRs.next();
			if (nameCountRs.getInt("count(*)")  != 0) {

				return false;
			}

			// アカウント作るSQL文を準備する
			String sql = "INSERT INTO users (user_name,user_password) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, name);

			pStmt.setString(2, pw);



			// SQL文を実行する
			if (pStmt.executeUpdate() != 1) {
				return false;
			} // SQL文を準備する

			String idSql = "SELECT user_id FROM users WHERE user_name = ?";
			PreparedStatement idPStmt = conn.prepareStatement(idSql);

			idPStmt.setString(1, name);


			// SQL文を実行し、結果表を取得する
			ResultSet idRs = idPStmt.executeQuery();


			//カレンダーID
			String insertSql = "INSERT INTO calendars ( calendar_name, user_id) VALUES (?, ?)";
			PreparedStatement insertPStmt = conn.prepareStatement(insertSql);

			// SQL文を完成させる
			insertPStmt.setString(1, cb.getCalendarName());
			idRs.next();
			insertPStmt.setInt(2, idRs.getInt("user_id"));
/*
			insertPStmt.setString(3, param.getCalendarType());
*/
			// SQL文を実行し、結果表を取得する
			if (insertPStmt.executeUpdate() == 1) {
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

	// 名前変更
	public boolean updateName(String name, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE users SET user_name=? WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<ここも>

			pStmt.setString(1, name);

			pStmt.setInt(2, user.getId());

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

	//パスワード変更
	public boolean updatePw(String pw, User user) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE users SET user_password=? WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<ここも>

			pStmt.setString(1, pw);

			pStmt.setInt(2, user.getId());

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

	// アカウント削除
	public boolean deleteAccount(String name, String pw,User user) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE users SET is_delete = TRUE WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, user.getId());

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
