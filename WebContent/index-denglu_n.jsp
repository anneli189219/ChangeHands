<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/search.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class="header_zhong">
			<h3>
				<img src="imgs/logo.png" width="300px" />
			</h3>
			<p>首&nbsp;页</p>
			<div class="erji">
				<ul>
					<li><a class="erji_a" href="BabyPage.jsp?fID=8" target="indexFrameName">我的宝贝</a></li>
				</ul>
			</div>
			<div class="denglu">
				<img src="imgs/DefaultHead.jpg" class="round_icon" /> <a
					href="Login.jsp" target="indexFrameName">请登录</a> <a href="Register.jsp" target="indexFrameName" id="bb">免费注册</a>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="footer_left">
			<ul>
				<li><a href="UserManage.jsp?numID=2" target="indexFrameName"><img src="imgs/fabu.png"
						width="45px" style="margin-right: 20px; margin-top: -5px;" /></a></li>
				<li><a href="UserManage.jsp?numID=2" target="indexFrameName"><h3>发布闲置</h3>
						<p>让你的闲置游起来 快速出手</p></a></li>
			</ul>
			<div
				style="float: left; margin-left: 200px; width: 1px; height: 100px; margin-top: 20px; background: darkgray;"></div>
		</div>
		<div class="footer_right">
			<div class="search d7">
				<form class="form_search" action="productSearch" method="post"
					target="indexFrameName">
					<input type="text" name="SelectName" placeholder="搜索从这里开始...">
					<button type="submit"></button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>