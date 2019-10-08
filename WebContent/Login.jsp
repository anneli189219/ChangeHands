<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="css/common.css" type="text/css" rel="stylesheet">
<link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript">
	function beforeSubmit(form) {
		if (form.username.value == '') {
			alert('用户名不能为空！');
			form.username.focus();
			return false;
		}
		if (form.password.value == '') {
			alert('密码不能为空！');
			form.password.focus();
			return false;
		}
		if (form.password.value.length < 6) {
			alert('密码至少为6位，请重新输入！');
			form.password.focus();
			return false;
		}
		return true;
	}
	function onCode() {
		document.getElementById("imgCode").src="VerifyCodeServlet?"+Math.random();
	}
</script>
<body onload=document.form_Login.username.focus()>
	<form action="LoginServlet" method="post"
		onSubmit="return beforeSubmit(this);" name="form_Login">
		<div class="user-wrap">
			<div class="user-con w">
				<div class="user-title">用户登录</div>
				<div class="user-box">
					<div class="user-item">
						<label class="user-label" for="username"><i
							class="fa fa-user"></i></label> <input type="text" class="user-content"
							id="username" name="username" placeholder="请输入用户名">
					</div>
					<div class="user-item">
						<label class="user-label" for="password"><i
							class="fa fa-lock"></i></label> <input type="password"
							class="user-content" id="password" name="password"
							placeholder="请输入密码">
					</div>
					<div class="user-item">
						<label class="user-label" for="question"><i
							class="fa fa-question"></i></label> <input type="text"
							class="user-content" id="code" name="code" placeholder="请输入验证码" autocomplete="off">
						<img id="imgCode" name="imgCode" style="float: right; margin-top: 10px;"
							src="VerifyCodeServlet" onclick="onCode()" />
					</div>
					<table style="margin-bottom: 10px;">
						<tr>
							<!--  colspan是合并列，rowspan是合并行 checked="checked"是默认打勾-->
							<td colspan="2"><input type="checkbox" name="checkbox"
								checked="checked">是否记住登陆</td>
						</tr>
					</table>
					<input type="submit" class="user-btn" id="submit" value="登录">
					<div class="link-item">
						<a style="float: left;" class="link left" href="ManagementSystem/login.jsp" target="_top">管理员登录</a> <a
							class="link pass-forget" href="gbPassword.jsp">忘记密码</a> <a
							class="link register" href="Register.jsp">免费注册</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>

</html>