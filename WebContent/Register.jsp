<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户注册</title>
		<link href="css/common.css" rel="stylesheet">
		<link href="css/register.css" rel="stylesheet">
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
		if (form.password.value != form.password2.value) {
			alert('你两次输入的密码不一致，请重新输入！');
			form.password2.focus();
			return false;
		}
		if (form.mobile.value == '') {
			alert('作为寄货/收货的手机！不能为空！');
			form.mobile.focus();
			return false;
		}
		if (form.email.value == '') {
			alert('作为找回密码的邮箱！不能为空！');
			form.email.focus();
			return false;
		}
		if (form.address.value == '') {
			alert('作为寄货/收货的地址！不能为空！');
			form.address.focus();
			return false;
		}
		return true;
	}
</script>
	<body onload=document.form_Register.username.focus()>
		<form action="RegisterServlet" method="post" onSubmit="return beforeSubmit(this);" name="form_Register">
			<div class="user-wrap">
				<div class="user-con w">
					<div class="user-title">新用户注册</div>
					<div class="user-box">
						<div class="user-item">
							<label class="user-label" for="username"><i class="fa fa-user"></i></label>
							<input type="text" class="user-content" id="username" name="username" placeholder="输入用户名" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label" for="password"><i class="fa fa-lock"></i></label>
							<input type="password" class="user-content" id="password" name="password" placeholder="输入密码">
						</div>
						<div class="user-item">
							<label class="user-label" for="password-confirm"><i class="fa fa-lock"></i></label>
							<input type="password" class="user-content" id="password2" name="password2" placeholder="再次输入密码">
						</div>
						<div class="user-item">
							<label class="user-label" for="phone"><i class="fa fa-phone"></i></label>
							<input type="text" class="user-content" id="mobile" name="mobile" placeholder="输入电话" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label" for="email"><i class="fa fa-envelope"></i></label>
							<input type="email" class="user-content" id="email" name="email" placeholder="输入邮箱" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label" for="question"><i class="fa fa-question"></i></label>
							<input type="text" class="user-content" id="address" name="address" placeholder="输入宿舍/地址" autocomplete="off">
						</div>
						<input type="submit" class="user-btn" id="submit" value="立即注册">
						<div class="link-item">
							<a class="link pass-forget" href="Login.jsp">已有帐号，去登录&gt;&gt;</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>

</html>