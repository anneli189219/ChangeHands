<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="px_changehands.entity.Product"%>
<%@page import="px_changehands.Service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%AdminService adminService = new AdminService();
Product product =(Product)adminService.GoodsSelectOne(Integer.valueOf(request.getParameter("pid")));
pageContext.setAttribute("product", product);
pageContext.setAttribute("pid", request.getParameter("pid"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		<link rel="stylesheet" type="text/css" href="../../css/base.css">
		<link rel="stylesheet" type="text/css" href="../../css/iconfont.css">
		<script type="text/javascript" src="../../framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
		<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
		<script src="../../framework/jquery.mousewheel.min.js"></script>
		<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
		</style>

	</head>

	<body>
		<div class="cBody">
		<div class="layui-form-item">修改商品信息</div>
			<form id="addForm" class="layui-form" action="../../../goodsupdate?pid=${pid}" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="tradename" required lay-verify="required|identity" autocomplete="off" class="layui-input" value="${product.tradename}">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品描述</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="describes" required lay-verify="required|PriceCheck" autocomplete="off" class="layui-input" value="${product.describes}">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				<div class="layui-form-item">
				<label class="layui-form-label">选择分类</label>
					<div class="layui-input-inline">
	                    <select name="provid" id="provid">
	                        <option value="0" <c:if test="${product.fid==0}">selected="selected"</c:if>>新鲜</option>   
	                        <option value="1" <c:if test="${product.fid==1}">selected="selected"</c:if>>书籍</option>
	                        <option value="2" <c:if test="${product.fid==2}">selected="selected"</c:if>>手机</option>
	                        <option value="3" <c:if test="${product.fid==3}">selected="selected"</c:if>>服装</option>
	                        <option value="4" <c:if test="${product.fid==4}">selected="selected"</c:if>>家电</option>
	                        <option value="5" <c:if test="${product.fid==5}">selected="selected"</c:if>>电脑</option>
	                        <option value="6" <c:if test="${product.fid==6}">selected="selected"</c:if>>运动</option>
	                        <option value="7" <c:if test="${product.fid==7}">selected="selected"</c:if>>美妆</option>
	                    </select>
			        </div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品价格/元</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="price" required lay-verify="required|ZHCheck" placeholder="" autocomplete="off" class="layui-input" value="${product.price}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品数量</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="number" required lay-verify="required|ZHCheck" placeholder="" autocomplete="off" class="layui-input" value="${product.number}">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input class="layui-btn" type="submit" value="立即提交">
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>