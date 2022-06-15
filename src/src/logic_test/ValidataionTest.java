package logic_test;

import logic.ValidationLogic;

public class ValidataionTest {

	public static void main(String[] args) {


		System.out.println("trueで成功");

		System.out.println("==ユーザ名==");
		System.out.println("入力なし" + (ValidationLogic.checkUserName("") == false));
		System.out.println("1文字" + (ValidationLogic.checkUserName("a") == true));
		System.out.println("null" + (ValidationLogic.checkUserName(null) == false));
		System.out.println("空白文字" + (ValidationLogic.checkUserName("  	") == false));
		System.out.println("15文字" + (ValidationLogic.checkUserName("abcdefghigklmno") == true));
		System.out.println("16文字" + (ValidationLogic.checkUserName("abcdefghigklmnop") == false));
		System.out.println("_付き" + (ValidationLogic.checkUserName("ab_efgh") == true));
		System.out.println("英数字以外" + (ValidationLogic.checkUserName("あいうえお") == false));


		System.out.println("==パスワード==");
		System.out.println("入力なし" + (ValidationLogic.checkUserPw("") == false));
		System.out.println("null" + (ValidationLogic.checkUserPw(null) == false));
		System.out.println("空白文字" + (ValidationLogic.checkUserPw("  	") == false));
		System.out.println("7文字" + (ValidationLogic.checkUserPw("1234567") == false));
		System.out.println("8文字" + (ValidationLogic.checkUserPw("12345678") == true));
		System.out.println("32文字" + (ValidationLogic.checkUserPw("12345678901234567890123456789012") == true));
		System.out.println("33文字" + (ValidationLogic.checkUserPw("123456789012345678901234567890123") == false));
		System.out.println("英数字以外" + (ValidationLogic.checkUserPw("あいうえお") == false));


		System.out.println("== カレンダー名 ==");
		System.out.println("入力なし" + (ValidationLogic.checkCalendarName("") == false));
		System.out.println("1文字" + (ValidationLogic.checkCalendarName("a") == true));
		System.out.println("null" + (ValidationLogic.checkCalendarName(null) == false));
		System.out.println("空白文字" + (ValidationLogic.checkCalendarName("  	") == false));
		System.out.println("15文字" + (ValidationLogic.checkCalendarName("abcdefghigklmno") == true));
		System.out.println("16文字" + (ValidationLogic.checkCalendarName("abcdefghigklmnop") == false));
		System.out.println("英数字以外" + (ValidationLogic.checkCalendarName("ab_efgh") == true));
	}

}
