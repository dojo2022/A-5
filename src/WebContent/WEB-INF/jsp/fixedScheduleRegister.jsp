<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title hereタイトルが入る</title>
<link rel="stylesheet" href="/machico/css/base.css">
<link rel="stylesheet" href="/machico/css/fixedScheduleRegister.css">
</head>
<body>
	<%@ include file="header.jsp"%><%--ヘッダー部分 --%>
	<main>
		<section id="calender">

	<%@ include file="calendarHeader.jsp"%>
			<%--【入力する項目】固定予定登録サーブレットのpostを使う --%>
		<form method="POST" action="/machico/FixedScheduleRegisterServlet">
				<div id="frame">
					<table id="title_area">
						<tr>
							<td>
		                        <div class="cp_iptxt">
		                            <input type="text" placeholder="タイトル" style="font-weight : bold ;">
		                            <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
		                        </div>
                       		</td>
						</tr>
                        		<tr>
									<td>
										<p id="title_error_message" class="error_message" align="left"></p>
									</td>
								</tr>
						</table>
                        <div class="frame_contents">
                            　<table id="date_table">
                                <tr>
                                    <td>
                                        <label><b>開始</b></label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="date" style="font-weight : bold ;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="time" id="time_entry" style="font-weight : bold ;">
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="frame_contents">
                            <img src="img/予定のやじるし.png" class="arrow">
                        </div>
                        <div class="frame_contents">
                    <table id="date_table_end">
                                <tr>
                                    <td>
                                        <label><b>終了</b></label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="date" style="font-weight : bold ;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="time" id="time_entry_end" style="font-weight : bold ;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <p id="all_day_text"><input type="checkbox" id="all_day_check"
                                        onclick="connecttextA('time_entry',this.checked);connecttextB('time_entry_end',this.checked);">
                                            終日チェック</p>
                                    </td>
                                </tr>
                            </table>
                        </div><br>
                        <textarea id="memo" placeholder="MEMO" style="font-weight : bold ;"></textarea>
                    </div>
				<%--【保存・キャンセルボタン】ボタン行先合ってる？ --%>
				<div class="screen_contents">
					<input type="button" name="cancel" value="キャンセル" style="font-weight: bold;"
								onclick="location.href='/machico/CalendarServlet'">
				</div>
				<div class="screen_contents">
					<input type="submit" name="save" value="保存" style="font-weight: bold;">
							<input type="hidden" id="err_message" value="${errMessage}">
				</div>
			</form>
		</section>
	</main>
<%--textのJavascriptファイルであることを示す。スクリプトなどのリソースの URL を指定してる。--%>
<script type="text/javascript" src="/machico/js/base.js"></script>
<script type="text/javascript" src="/machico/js/fixedScheduleRegister.js"></script>
</body>
</html>