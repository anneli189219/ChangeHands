<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.entity.UserBean" %>
<%@ page import="changehands.dao.impl.UserDaoImpl" %>
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

.safe_title {
	font-family: "微软雅黑";
	font-size: 24px;
	font-weight: 800;
	padding-top: 100px;
	padding-left: 20px;
	padding-bottom: 20px;
}

.safe_form_div {
	margin: 0 auto;
	padding-top: 20px;
	width: 300px;
}

.safe_form_div_left {
	float: left;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.safe_form_div_right {
	float: right;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.safe_sumbit {
	margin-left: -220px;
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
//JSP中默认创建了session，因此不需要再重新创建
int UserID=0;
try{
	UserID= (int)session.getAttribute("UserID");
}catch(Exception e){
	response.getWriter().println("<script> alert('您还未登录！请登录再试试！');top.location='../UserLogin.jsp'</script>");
	e.printStackTrace();
}


UserDaoImpl userDaoImpl = new UserDaoImpl();

UserBean User = new UserBean();
User = userDaoImpl.UserSelect(UserID);
//System.out.println(User.getRegTime());
request.setAttribute("User", User);
%>
<body onload=document.form_safe.OldPassword.focus()>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 350px;">
			<p class="safe_title">安全设置</p>
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />

			<form action="../UserSafeReposit" method="post" style="text-align: center;" name="form_safe" target="UserFrameName">
				<div class="safe_form_div">
					<label class="safe_form_div_left">用户编号：</label><label
						class="safe_form_div_right">${UserID}</label>
				</div>
				<br />
				<div class="safe_form_div">
					<label class="safe_form_div_left">旧密码：</label><input
						class="safe_form_div_right" name="OldPassword" type="password" placeholder="请输入旧密码">
				</div>
				<br />
				<div class="safe_form_div">
					<label class="safe_form_div_left">新密码：</label><input
						class="safe_form_div_right" name="NewPassword" type="password" placeholder="请输入新密码">
				</div>
				<br />
				<div class="safe_form_div">
					<label class="safe_form_div_left">确定密码：</label><input
						class="safe_form_div_right" name="NewPassword_" type="password" placeholder="请再次输入新密码">
				</div>
				<br />
				<div class="safe_form_div">
					<label class="safe_form_div_left">真实姓名：</label><input name="RealName"
						class="safe_form_div_right" type="text" value="${User.realName}">
				</div>
				<br />
				<div class="safe_form_div">
					<label class="safe_form_div_left">注册时间：</label><label
						class="safe_form_div_right">${User.regTime}</label>
				</div>
				<br />
				<div>
					<input class="safe_sumbit" type="submit" name="submit" value="保存">
				</div>
			</form>

		</div>

	</div>
</body>
</html>