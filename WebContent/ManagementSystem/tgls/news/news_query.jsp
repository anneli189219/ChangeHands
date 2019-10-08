<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>欢迎使用后台管理系统</title>
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/layui/css/px.css" media="all" />
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="/ChangeHands/ManagementSystem/css/news.css" media="all" />
</head>
<body>
<div class="layui-form news_list">
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
		  	<div class="pages">
				检索到${requestScope.number}条数据
			</div>
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
		    <c:forEach var="i" begin="0" end="${requestScope.number+1}" items="${requestScope.arrayList}">
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
</body>
</html>