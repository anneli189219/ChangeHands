<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

.title {
	font-family: "微软雅黑";
	font-size: 20px;
	font-weight: 800;
	padding-left: 30px;
	padding-top: 10px;
}

.ul_left {
	list-style: none;
	padding-left: 30px;
	padding-top: 10px;
}

.ul_left>li {
	padding-top: 12px;
}

.ul_left>li a {
	text-decoration: none;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.ul_left>li a:hover {
	color: red;
}

.reply_title {
	font-family: "微软雅黑";
	font-size: 24px;
	font-weight: 800;
	padding-top: 100px;
	padding-left: 20px;
	padding-bottom: 20px;
}

.reply_form_div {
	margin: 0 auto;
	padding-top: 20px;
	width: 300px;
}

.reply_form_div_left {
	float: left;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.reply_form_div_right {
	float: right;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.reply_sumbit {
	margin-top: 30px;
	text-decoration: none;
	background: #2f435e;
	color: #f2f2f2;
	padding: 8px 24px 8px 24px;
	font-size: 16px;
	font-family: 微软雅黑, 宋体, Arial, Helvetica, Verdana, sans-serif;
	font-weight: bold;
	border-radius: 5px;
	-webkit-transition: all linear 0.30s;
	-moz-transition: all linear 0.30s;
	transition: all linear 0.30s;
}

</style>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

int UserID = (int)session.getAttribute("UserID");

int pID = Integer.valueOf(request.getParameter("pID"));
request.setAttribute("pID", pID);

int setID = Integer.valueOf(request.getParameter("setID"));
request.setAttribute("setID", setID);

int getID = Integer.valueOf(request.getParameter("getID"));
request.setAttribute("getID", getID);

if(UserID!=setID){
	request.setAttribute("putID", setID);
}else{
	request.setAttribute("putID", getID);
}
%>
<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 350px;">
			<p class="reply_title">留言回复</p>
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />

			<form action="../GuestAddServlet.do?putID=${putID}&pID=${pID}" method="post" style="text-align: center;" target="UserFrameName">
				<div class="reply_form_div">
					<label class="reply_form_div_left">接受用户：</label><label
						class="reply_form_div_right">${us:getUserName_(putID)}</label>
				</div>
				<br />
				<div class="reply_form_div">
					<label class="reply_form_div_left">留言内容：</label>
					<textarea class="reply_form_div_right" name="put_text" placeholder="请输入回复内容"></textarea>
				</div>
				<br />
				<div>
					<input class="reply_sumbit" type="submit" name="submit" value="发送">
				</div>
			</form>

		</div>

	</div>
</body>
</html>