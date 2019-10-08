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
		
		<style>
			.layui-table img {
			    max-width: none;
			}
		</style>

	</head>

	<body>
		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="/ChangeHands/goodsquery" method="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="name" placeholder="输入商品名称" class="layui-input">
						</div>
						<div class="layui-input-inline">
		                    <select name="provid" id="provid">
		                        <option value="10" selected>一级分类</option>  
		                        <option value="0">新鲜</option> 
		                        <option value="1">书籍</option>
		                        <option value="2">手机</option>
		                        <option value="3">服装</option>
		                        <option value="4">家电</option>
		                        <option value="5">电脑</option>
		                        <option value="6">运动</option>
		                        <option value="7">美妆</option>
		                    </select>
		                </div>
						<input class="layui-btn" type="submit" value="检索">
						<!-- <input class="layui-btn" type="button" onclick="window.location.href='/ChangeHands/goodslist'" value="检索全部"> -->
					</div>
				</form>
				
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名称</th>
						<th>发布人ID</th>
						<th>商品图片</th>
						<th>商品分类</th>
						<th>商品描述</th>
						<th>商品价格/元</th>
						<th>商品数量</th>
						<th>是否审核</th>
						<th>发布时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="i" begin="${sessionScope.nowpage*10-10}" end="${sessionScope.nowpage*10-1}" items="${sessionScope.arrayList}">
					<tr>
						<td>${i.pid}</td>
						<td>${i.tradename}</td>
						<td>${i.id}</td>
						<td><img src="/ChangeHands/ManagementSystem/images/goodsPIC1.png" width="20" height="20" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
						<td>${i.fidname}</td>
						<td>${i.describes}</td>
						<td>${i.price}</td>
						<td>${i.number}</td>
						<td>${i.flag}</td>
						<td>${i.addtime}</td>
						<td>
							<a href="/ChangeHands/ManagementSystem/tgls/goodsManage/goods_update.jsp?pid=${i.pid}"><button class="layui-btn layui-btn-xs" >修改</button></a>
							<a href="/ChangeHands/goodslower?pid=${i.pid}&flag=${i.flag}"><button class="layui-btn layui-btn-xs" >下架</button></a>
							<a href="/ChangeHands/GoodsDelete?pid=${i.pid}"><button class="layui-btn layui-btn-xs" >删除</button></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<!--分页模块 -->
			<div class="pages" style="margin-left:10px;">
				<button class="layui-btn layui-btn-xs" style="float: left;margin-left:5px;" onclick="window.location.href='/ChangeHands/Goodspaging?pages=upper'">上一页</button>
				<form class="layui-form" style="float: left;" action="/ChangeHands/Goodspaging" method="post">
					<font style="margin-left:5px;">当前页数</font>
					<input style="margin-left:0px;width:25px;" type="text" name="nowpage" value="${sessionScope.nowpage}"/>
					<font style="margin-left:5px;">总页数${requestScope.totalPages}</font>
					<input class="layui-btn layui-btn-xs" type="submit" value="跳转"/>
				</form>
				<button style="margin-left:5px;" class="layui-btn layui-btn-xs" onclick="window.location.href='/ChangeHands/Goodspaging?pages=lower'">下一页</button>
			</div>
		</div>
	</body>

</html>