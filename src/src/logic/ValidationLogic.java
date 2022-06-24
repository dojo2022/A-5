package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class ValidationLogic {

	// ^ 行の先頭
	// $ 行の終わり
	// [] or 例: [abc] = a or b or c
	// {n,m} n文字以上、m文字以下
	// n-m nからmの間の文字 0-9なら、0,1,2,3,4,5,6,7,8,9

	// 行の始まりから、終わりまでが、半角数字or半角小文字or半角大文字or_(アンダーバー)の組み合わせ
	// かつ1文字以上15文字以下
	private static Pattern userNameValidator = Pattern.compile("^[0-9a-zA-Z_]{1,15}$");
	// 行の始まりから、終わりまでが、半角数字or半角小文字or半角大文字の組み合わせ
	// かつ8文字以上32文字以下
	private static Pattern pwValidator = Pattern.compile("^[0-9a-zA-Z]{8,32}$");

	//ユーザーネーム

	public static boolean checkUserName(String value) {
		return value != null && userNameValidator.matcher(value).find();
	}

	//パスワード
	public static boolean checkUserPw(String value) {
		return value != null && pwValidator.matcher(value).find();
	}

	//カレンダー名
	public static boolean checkCalendarName(String value) {
		if (value == null || value.isBlank() || value.length() == 0 || value.length() > 15) {
			return false;
		} else {
			return true;
		}

	}

	//スケジュール名
	public static boolean checkScheduleName(String value) {
		if (value == null || value.isBlank() || value.length() == 0 || value.length() > 15) {
			return false;
		} else {
			return true;
		}

	}

	//カレンダーロック
	private static Pattern LockValidator = Pattern.compile("^[0-9]{1,4}$");

	public static boolean checkLock(String value) {
		return value != null && LockValidator.matcher(value).find();
	}

	//カレンダータイプ
	public static boolean checkCalendarType(String value) {
		if (value != null && value.equals("G") || value.equals("L") || value.equals("T")) {
			return true;
		} else {
			return false;
		}
	}

	// 予定タイプ
	public static boolean checkScheduleType(String value) {
		if (value != null && value.equals("F") || value.equals("R") || value.equals("A")) {
			return true;
		} else {
			return false;
		}
	}

	private static Pattern regularScheduleWeekTypeValdator = Pattern.compile("^([1-7],)+[1-7]$");

	public static boolean checkRegularScheduleType(String type, String value) {
		if (type == null || value == null || type.length() != 1 || value.isEmpty() || value.isBlank()) {
			return false;
		}
		// 年単位は(月/日)が入力される
		if (type.equals("Y")) {
			SimpleDateFormat formater = new SimpleDateFormat("MM/dd");
			try {
				formater.parse(value);
				return true;
			} catch (ParseException e) {
				return false;
			}
		}
		// 月単位は(日）
		if (type.equals("M")) {
			try {
				int day = Integer.parseInt(value);
				return 1 <= day && day <= 12;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		// 曜日単位は(1 or 1,2,3）
		// 空白は無し
		if (type.equals("W")) {
			String[] weeks = value.split(",");
			// 値が１桁の場合
			if (weeks.length == 1) {
				try {
					int week = Integer.parseInt(value);
					if (1 <= week && week <= 7) {
						// valueが数字に変更可能かつ、有効な曜日ならtrue
						return true;
					}
				} catch (NumberFormatException e) {
					return false;
				}
			}
			// 数字が複数個ある場合
			return (regularScheduleWeekTypeValdator.matcher(value).find());
		} else {
			return false;
		}
	}
}
