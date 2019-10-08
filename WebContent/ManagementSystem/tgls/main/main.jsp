<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>欢迎使用后台管理系统</title>
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/css/main.css" media="all" />
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/layui/css/px.css" media="all" />
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/css/font_eolqem241z66flxr.css" media="all" />
</head>
<body class="childrenBody">
	<div class="panel_box row">
		<div class="panel col">
			<a href="javascript:;" data-url="">
				<div class="panel_icon">
					<i class="layui-icon" data-icon="&#xe63a;">&#xe63a;</i>
				</div>
				<div class="panel_word newMessage">
					<span>维护中</span>
					<cite>今日访客</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" data-url="">
				<div class="panel_icon" style="background-color:#FF5722;">
					<i class="iconfont icon-dongtaifensishu" data-icon="icon-dongtaifensishu"></i>
				</div>
				<div class="panel_word userAll">
					<span>${requestScope.usersnumber}</span>
					<cite>新增人数</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" data-url="">
				<div class="panel_icon" style="background-color:#009688;">
					<i class="layui-icon" data-icon="&#xe613;">&#xe613;</i>
				</div>
				<div class="panel_word userAll">
					<span>${requestScope.usersnumber}</span>
					<cite>用户总数</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" data-url="">
				<div class="panel_icon" style="background-color:#5FB878;">
					<i class="layui-icon" data-icon="&#xe64a;">&#xe64a;</i>
				</div>
				<div class="panel_word imgAll">
					<span>${requestScope.goodsoknumber }</span>
					<cite>新增商品</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" data-url="">
				<div class="panel_icon" style="background-color:#F7B824;">
					<i class="iconfont icon-wenben" data-icon="icon-wenben"></i>
				</div>
				<div class="panel_word waitNews">
					<span>${requestScope.goodsnumber }</span>
					<cite>商品数量</cite>
				</div>
			</a>
		</div>
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="">
				<div class="panel_icon" style="background-color:#2F4056;">
					<i class="iconfont icon-text" data-icon="icon-text"></i>
				</div>
				<div class="panel_word allNews">
					<span>${requestScope.newsnumber}</span>
					<em>留言数量</em>
				</div>
			</a>
		</div>
	</div>
	<blockquote class="layui-elem-quote">
		<p>系统公告：<span>今日访客功能正在开发中,请耐心等待</span></p>
	
	</blockquote>
	<div class="row">
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">更新日志</blockquote>
			<div class="layui-elem-quote layui-quote-nm">
				Naive后台管理系统升级为2.0<br><br>
				新增了订单管理<br><br>
				优化了部分代码<br><br>
				修复了一些已知BUG
			</div>
		</div>
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">系统基本参数</blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<td>当前时间</td>
						<td class="version">${requestScope.istime}</td>
					</tr>
					<tr>
						<td>当前系统环境</td>
						<td class="author">${requestScope.systemname}</td>
					</tr>
					<tr>
						<td>当前系统版本</td>
						<td class="homePage">${requestScope.systeversion}</td>
					</tr>
					<tr>
						<td>当前系统架构</td>
						<td class="server">${requestScope.systearchitecture}</td>
					</tr>
					<tr>
						<td>当前管理员</td>
						<td class="dataBase">${sessionScope.admin.adminname}</td>
					</tr>
					<tr>
						<td>当前管理员权限</td>
						<td class="maxUpload">超级管理员</td>
					</tr>
					<tr>
						<td>当前用户IP</td>
						<td class="userRights">${requestScope.ip}</td>
					</tr>
				</tbody>
			</table>
			<table class="layui-table" lay-skin="line">
				<colgroup>
					<col>
					<col width="110">
				</colgroup>
				<tbody class="hot_news"></tbody>
			</table> 
		</div>
	</div>
</body>
</html>