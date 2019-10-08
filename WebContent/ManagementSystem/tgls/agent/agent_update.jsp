<%@page import="px_changehands.entity.Users"%>
<%@page import="px_changehands.Service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%AdminService adminService = new AdminService();
Users users =(Users)adminService.UsersSelectOne(Integer.valueOf(request.getParameter("id")));
pageContext.setAttribute("users", users);
request.setAttribute("id", request.getParameter("id"));
%>
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
		<div class="layui-form-item">修改用户信息</div>
			<form id="addForm" class="layui-form" action="../../../UsersUpdate?id=${requestScope.id}" method="post" enctype="multipart/form-data">
				<div class="layui-form-item">
					<label class="layui-form-label">真实姓名</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="RealName" required lay-verify="required|identity" autocomplete="off" class="layui-input" value="${users.realname}">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="UserName" required lay-verify="required|PriceCheck" autocomplete="off" class="layui-input" value="${users.username}">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">修改头像</label> 
					<div class="layui-upload-drag" id="goodsPic">
						<img id="avatar-img" style="width: 100px; height: 100px;" src="/ChangeHands/imgs/${users.headpath}"/>
						<p>点击上传</p>
					</div>
					<input class="layui-upload-file" type="file" id="file" name="file">
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
							$("#goodsPic").click(function(){
							$("#file").trigger("click");
						});
					});
					// 找到头像的input标签绑定change事件
					$("#file").change(function () {
						// 1. 创建一个读取文件的对象
						var fileReader = new FileReader();
						// 读取你选中的那个文件
						fileReader.readAsDataURL(this.files[0]); // 读取文件是需要时间的
						
						fileReader.onload = function () {
							
						// 2. 等上一步读完文件之后才 把图片加载到img标签中
						$("#avatar-img").attr("src", fileReader.result);
						//alert(document.getElementById("avatar-img").src);
					};
				});	
				</script>
				
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="Sex" required lay-verify="required|ZHCheck" placeholder="" autocomplete="off" class="layui-input" value="${users.sex}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">年龄</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="Age" required lay-verify="required|ZHCheck" placeholder="" autocomplete="off" class="layui-input" value="${users.age}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">电话</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="Mobile" required lay-verify="required|phone" placeholder="" autocomplete="off" class="layui-input" value="${users.mobile}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="Email" autocomplete="off" class="layui-input" value="${users.email}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
	                <div class="layui-input-inline">
						<input type="text" name="Address" autocomplete="off" class="layui-input" value="${users.address}">
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