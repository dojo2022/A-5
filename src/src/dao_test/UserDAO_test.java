package dao_test;

public class UserDAO_test {

		public static void main(String[] args) {

//	 		testIsLoginOK1();	// ユーザーが見つかる場合のテスト

//	 		testIsLoginOK2();	// ユーザーが見つからない場合のテスト

//			testIsCreateAccountOK1();//ユーザー登録できた

//		testIsCreateAccountOK2();//ユーザー登録できない

//		updateNameOK1();//ユーザーアップデートできたテスト

// 		updateNameOK2();//ユーザーアップデートできないテスト

//			deleteAccountOK1();//ユーザー削除できたテスト

//			deleteAccountOK2();//ユーザー削除できないテスト


		}
/*
		// ユーザーが見つかる場合のテスト
		public static void testIsLoginOK1() {
			UserDAO dao = new UserDAO();
			User u = dao.isLoginOK("kageyamatest" , "kageyama0211");
			if (u != null) {
				System.out.println("testIsLoginOK1：テストが成功しました");
			}
			else {
				System.out.println("testIsLoginOK1：テストが失敗しました");
			}
		}
		//ユーザーが見つからない場合
		public static void testIsLoginOK2() {
			UserDAO dao = new UserDAO();
			User u = dao.isLoginOK("かげやま" , "こうたろう");
			if (u != null) {
				System.out.println("testIsLoginOK2：テストが成功しました");
			}
			else {
				System.out.println("testIsLoginOK2：テストが失敗しました");
			}
		}

		//アカウント作成成功
		public static void testIsCreateAccountOK1() {
			UserDAO dao = new UserDAO();
			boolean u = dao.createAccount("kageyamatest" , "kageyama0211");
			if (u == true) {
				System.out.println(" testIsCreateAccountOK1：テストが成功しました");
			}
			else {
				System.out.println(" testIsCreateAccountOK1：テストが失敗しました");
			}
		}

		//アカウント作成失敗
		public static void testIsCreateAccountOK2() {
			UserDAO dao = new UserDAO();
			boolean u = dao.createAccount("" , "");
			if (u == false) {
				System.out.println("testIsCreateAccountOK2：テストが成功しました");
			}
			else {
				System.out.println("testIsCreateAccountOK2：テストが失敗しました");
			}
		}
*/
		/*
		//名前アップデート成功
		public static void updateNameOK1() {
			UserDAO dao = new UserDAO();
			User user = new User();
			user.setId(1);
			boolean u = dao.updateName("たなか" , user );
			if (u == true) {
				System.out.println("updateNameOK1：テストが成功しました");
			}
			else {
				System.out.println("updateNameOK1：テストが失敗しました");
			}
		}
		*/
/*
		//名前アップデート失敗
		public static void updateNameOK2() {
			UserDAO dao = new UserDAO();
			User user = new User();
			boolean u = dao.updateName("" , user);
			if (u == false) {
				System.out.println("updateNameOK2：テストが成功しました");
			}
			else {
				System.out.println("updateNameOK2：テストが失敗しました");
			}
		}

		//アカウント削除
		public static void deleteAccountOK1() {
			UserDAO dao = new UserDAO();
			boolean u = dao.deleteAccount("かま" ,"abcd1234" );
			if (u == true) {
				System.out.println("testIsCreateAccountOK2：テストが成功しました");
			}
			else {
				System.out.println("testIsCreateAccountOK2：テストが失敗しました");
			}
		}

		//アカウント削除失敗
		public static void deleteAccountOK2() {
			UserDAO dao = new UserDAO();
			boolean u = dao.deleteAccount("かげやま" ,"a" );
			if (u == false) {
				System.out.println("testIsCreateAccountOK2：テストが成功しました");
			}
			else {
				System.out.println("testIsCreateAccountOK2：テストが失敗しました");
			}
		}
*/
	}



