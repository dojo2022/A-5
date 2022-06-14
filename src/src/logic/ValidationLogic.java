package logic;

public class ValidationLogic {

	//ユーザーネーム

	public static boolean checkUserName(String value) {
		if (value == null || value.isBlank() || value.length() == 0 || value.length() > 15) {
			return false;
		} else {
			return true;
		}
	}

	//パスワード
	public static boolean checkUserPw(String value) {
		if (value == null || value.isBlank() || value.length() == 0
				|| value.length() < 8 || value.length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	//カレンダー名
	public static boolean checkCalendarName(String value) {
		if (value == null || value.isBlank() || value.length() == 0 || value.length() > 15) {
			return false;
		} else {
			return true;
		}

	}
}
