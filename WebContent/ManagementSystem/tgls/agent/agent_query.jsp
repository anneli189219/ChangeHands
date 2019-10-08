<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>欢迎使用后台管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="/ChangeHands/ManagementSystem/css/base.css">
		<link rel="stylesheet" type="text/css" href="/ChangeHands/ManagementSystem/css/iconfont.css">
		<script type="text/javascript" src="/ChangeHands/ManagementSystem/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/ChangeHands/ManagementSystem/layui/css/layui.css">
		<script type="text/javascript" src="/ChangeHands/ManagementSystem/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="/ChangeHands/ManagementSystem/css/jquery.mCustomScrollbar.css">
		<script src="/ChangeHands/ManagementSystem/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="/ChangeHands/ManagementSystem/framework/jquery.mousewheel.min.js"></script>
		<script src="/ChangeHands/ManagementSystem/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="/ChangeHands/ManagementSystem/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

	</head>

	<body>
		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="/ChangeHands/agentquery" method="post">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="name" required lay-verify="required" placeholder="输入会员名称" autocomplete="off" class="layui-input">
						</div>
						<input class="layui-btn" type="submit" onclick="window.location.href='/ChangeHands/agentquery'" value="检索">
						<input class="layui-btn" type="submit" onclick="window.location.href='/ChangeHands/agentlist'" value="检索全部">
					</div>
				</form>
			</div>
			<div class="pages">
				检索到${requestScope.number}条数据
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>用户ID</th>
						<th>用户名</th>
						<th>真实姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>联系方式</th>
						<th>邮箱</th>
						<th>地址</th>
						<th>注册时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="i" begin="0" end="${requestScope.number+1}" items="${requestScope.arrayList}">
					<tr>
						<td>${i.id}</td>
						<td>${i.username}</td>
						<td>${i.realname}</td>
						<td>${i.sex}</td>
						<td>${i.age}</td>
						<td>${i.mobile}</td>
						<td>${i.email}</td>
						<td>${i.address}</td>
						<td>${i.regtime}</td>
						<td>
							<button class="layui-btn layui-btn-xs" onclick="window.location.href='/ChangeHands/ManagementSystem/tgls/agent/agent_update.jsp?id=${i.id}'">修改信息</button>
							<a href="/ChangeHands/UsersDelete?id=${i.id}"><button class="layui-btn layui-btn-xs" >删除用户</button></a>
							<button class="layui-btn layui-btn-xs" onclick="window.location.href='/ChangeHands/ManagementSystem/tgls/users_password.jsp?id=${i.id}'">修改密码</button>
						</td>
					</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</body>

</html>