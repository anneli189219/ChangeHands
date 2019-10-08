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

.information_word {
	font-family: "微软雅黑";
	font-size: 16px;
	font-weight: 600;
}

.information_title {
	font-family: "微软雅黑";
	font-size: 24px;
	font-weight: 800;
	padding-top: 30px;
	padding-left: 20px;
	padding-bottom: 20px;
}

.information_form_div {
	font-family: "微软雅黑";
	font-size: 16px;
	font-weight: 600;
	margin: 0 auto;
	padding-top: 20px;
	width: 300px;
}

.information_form_div_left {
	float: left;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.information_form_div_right {
	float: right;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.information_sumbit {
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
int UserID = (int)session.getAttribute("UserID");

UserDaoImpl userDaoImpl = new UserDaoImpl();

UserBean User = new UserBean();
User = userDaoImpl.UserSelect(UserID);

request.setAttribute("User", User);

//为radio控件识别性别
String checked_man="";
String checked_woman="";
if(User.getSex().equals("男")){
	checked_man="checked";
}else{
	checked_woman="checked";
}
request.setAttribute("checked_man", checked_man);
request.setAttribute("checked_woman", checked_woman);
%>


<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 350px;">
			<p class="information_title">个人信息</p>
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />

			<form id="form" name="form" action="../UserInforReposit" method="post" style="text-align: center;" target="UserFrameName">
				<div class="information_form_div">
					<label class="information_form_div_left">当前头像：</label><img id="user_img"
						alt="当前头像" src="../imgs/${User.headPath}" width="100px">
						<div style="padding-top: 10px;padding-bottom: 20px;">
							<input type="file" id="image_file" name="image_file" accept="image/jpeg, image/png, image/jpg" style="width: 200px;float: left;"/>
							<a class="information_word" style="float: right;" onclick="doPost()" href="javascrip:void()">上传头像</a>
						</div>
					<script type="text/javascript">
						function doPost() {
							if(document.getElementById("image_file").value == null || document.getElementById("image_file").value == ""){
								alert("请浏览头像之后再试！");
							}else{
								var myForm = document.getElementById("form");
								myForm.action="../UserUploadPcture";
								myForm.enctype="multipart/form-data";
								
								var user_img = document.getElementById("user_img");
								user_img.src = document.getElementById("image_file").value;
								
								alert("头像上传成功！请单击保存按钮！");
							}
						}
					</script>
				</div>
				<div class="information_form_div">
					<label class="information_form_div_left">用户名：</label><input
						class="information_form_div_right" type="text" name="UserName" value="${User.userName}">
				</div>
				<br />
				<div class="information_form_div">
					<label class="information_form_div_left">性别：</label><input
						type="radio" ${checked_man} value="男" name="Sex">男&emsp;&emsp;&emsp;<input
						type="radio" ${checked_woman} value="女" name="Sex">女
				</div>
				<div class="information_form_div">
					<label class="information_form_div_left">年龄：</label><input
						class="information_form_div_right" type="text" name="Age" value=${User.age}>
				</div>
				<br />
				<div class="information_form_div">
					<label class="information_form_div_left">邮箱：</label><input
						class="information_form_div_right" type="text"  name="Email" 
						value="${User.email}">
				</div>
				<br />
				<div class="information_form_div">
					<label class="information_form_div_left">手机号：</label><input
						class="information_form_div_right" type="text" name="Mobile" value="${User.mobile}">
				</div>
				<br />
				<div class="information_form_div">
					<label class="information_form_div_left">宿舍/地址：</label>
					<textarea class="information_form_div_right" name="Address">${User.address}</textarea>
				</div>
				<br />
				<br />
				<div>
					<input class="information_sumbit" type="submit" name="submit"
						value="保存">
				</div>
			</form>

		</div>

	</div>
</body>
</html>