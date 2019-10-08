<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
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
		if (form.email.value == '') {
			alert('邮箱不能为空！');
			form.email.focus();
			return false;
		}
		return true;
	}

</script>
<body>
	<form action="gbPasswordServlet" method="post" onSubmit="return beforeSubmit(this);" target="indexFrameName">
		<div class="user-wrap">
			<div class="user-con w">
				<div class="user-title">找回密码</div>
				<div class="user-box">
					<div class="user-item">
						<label class="user-label" for="username"><i class="fa fa-user"></i></label>
						<input type="text" class="user-content" id="username" name="username" placeholder="请输入用户名" autocomplete="off">
					</div>
					<div class="user-item">
						<label class="user-label" for="email"><i class="fa fa-envelope"></i></label>
						<input type="email" class="user-content" id="email" name="email" placeholder="请输入邮箱" autocomplete="off">
					</div>
					<input type="submit" class="user-btn" id="submit" value="发送邮件">
				</div>
			</div>
		</div>
	</form>
</body>

</html>