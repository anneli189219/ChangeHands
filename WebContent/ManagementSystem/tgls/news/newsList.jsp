<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>欢迎使用后台管理系统</title>
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/layui/css/px.css" media="all" />
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/css/news.css" media="all" />
</head>
<body class="childrenBody">
	<div class="console">
		<form class="layui-form" action="/ChangeHands/newsquery" method="post">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<input type="text" name="name" required lay-verify="required" placeholder="输入商品ID" class="layui-input">
				</div>
				<input class="layui-btn" type="submit" onclick="window.location.href='/ChangeHands/newsquery'" value="检索">
				<input class="layui-btn" type="button" onclick="window.location.href='/ChangeHands/newslist'" value="检索全部">
			</div>
		</form>
	</div>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col>
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="15%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th style="text-align:left;">留言信息</th>
					<th>留言用户ID</th>
					<th>留言ID</th>
					<th>留言商品ID</th>
					<th>修改时间</th>
					<th>发布时间</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    <c:forEach var="i" begin="${sessionScope.nowpage*10-10}" end="${sessionScope.nowpage*10-1}" items="${sessionScope.arrayList}">
		    	<tr>
		    		<td></td>
		    		<td>${i.message}</td>
		    		<td>${i.id}</td>
		    		<td>${i.gid}</td>
		    		<td>${i.pid}</td>
		    		<td>${i.releasetime}</td>
		    		<td>${i.modifytime}</td>
		    		<td>
		    			<a href="/ChangeHands/newsdel?gid=${i.gid}"><button class="layui-btn layui-btn-xs" >删除留言</button></a>
		    		</td>
		    	</tr>
		    	</c:forEach>
		    </tbody>
		</table>
	</div>
		<!--分页模块 -->
		<div class="pages" style="margin-left:10px;">
			<button class="layui-btn layui-btn-xs" style="float: left;margin-left:5px;" onclick="window.location.href='/ChangeHands/newspaging?pages=upper'">上一页</button>
			<form class="layui-form" style="float: left;" action="/ChangeHands/newspaging" method="post">
				<font style="margin-left:5px;">当前页数</font>
				<input style="margin-left:0px;width:25px;" type="text" name="nowpage" value="${sessionScope.nowpage}"/>
				<font style="margin-left:5px;">总页数${requestScope.totalPages}</font>
				<input class="layui-btn layui-btn-xs" type="submit" value="跳转"/>
			</form>
			<button style="margin-left:5px;" class="layui-btn layui-btn-xs" onclick="window.location.href='/ChangeHands/newspaging?pages=lower'">下一页</button>
		</div>
</body>
</html>