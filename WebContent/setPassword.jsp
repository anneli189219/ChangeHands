<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link href="css/common.css" type="text/css" rel="stylesheet">
<link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript">
	function beforeSubmit(form) {
		if (form.Code.value == '') {
			alert('验证码不能为空！');
			form.Code.focus();
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
		return true;
	}

</script>
<body>
	<form action="UserUpdatePassword" method="post" onSubmit="return beforeSubmit(this);">
		<div class="user-wrap">
			<div class="user-con w">
				<div class="user-title">修改密码</div>
				<div class="user-box">
					<div class="user-item">
						<label class="user-label" for="username"><i class="fa fa-user"></i></label>
						<input type="text" class="user-content" id="username" name="username" readonly="readonly" value="${requestScope.username}">
					</div>
					<div class="user-item">
						<label class="user-label" for="Code"><i class="fa fa-envelope"></i></label>
						<input type="text" class="user-content" id="Code" name="Code" placeholder="请验证码" autocomplete="off">
					</div>
					<div class="user-item">
							<label class="user-label" for="password"><i class="fa fa-lock"></i></label>
							<input type="password" class="user-content" id="password" name="password" placeholder="请输入密码">
						</div>
					<div class="user-item">
							<label class="user-label" for="password-confirm"><i class="fa fa-lock"></i></label>
							<input type="password" class="user-content" id="password2" name="password2" placeholder="请再次输入密码">
						</div>
					<input type="submit" class="user-btn" id="submit" value="确定更改">
				</div>
			</div>
		</div>
	</form>
</body>

</html>