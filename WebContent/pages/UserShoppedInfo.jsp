<%@page import="changehands.dao.impl.ShoppedDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.dao.impl.ShoppedDaoImpl" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

.title {
	font-family: "微软雅黑";
	font-size: 20px;
	font-weight: 800;
	padding-left: 30px;
	padding-top: 10px;
}

.ul_left {
	list-style: none;
	padding-left: 30px;
	padding-top: 10px;
}

.ul_left>li {
	padding-top: 12px;
}

.ul_left>li a {
	text-decoration: none;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.ul_left>li a:hover {
	color: red;
}

.product_word {
	font-family: "微软雅黑";
	font-size: 16px;
	font-weight: 600;
}

.product_title {
	font-family: "微软雅黑";
	font-size: 24px;
	font-weight: 800;
	padding-top: 30px;
	padding-left: 20px;
	padding-bottom: 20px;
}

.product_form_div {
	font-family: "微软雅黑";
	font-size: 16px;
	font-weight: 600;
	margin: 0 auto;
	padding-top: 20px;
	width: 300px;
}

.product_form_div select{
	width: 140px;
	height: 25px;
	font-family: "微软雅黑";
	font-size: 14px;
	font-weight: 700;
}

.product_form_div_left {
	float: left;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.product_form_div_right {
	float: right;
	font-family: "微软雅黑";
	color: black;
	font-size: 16px;
	font-weight: 700;
}

.product_sumbit {
	margin-top: 30px;
	text-decoration: none;
	background: #2f435e;
	color: #f2f2f2;
	padding: 8px 24px 8px 24px;
	font-size: 16px;
	font-family: 微软雅黑, 宋体, Arial, Helvetica, Verdana, sans-serif;
	font-weight: bold;
	border-radius: 5px;
	-webkit-transition: all linear 0.30s;
	-moz-transition: all linear 0.30s;
	transition: all linear 0.30s;
}
</style>
<%
int sID = Integer.valueOf(request.getParameter("sID"));

request.setAttribute("sID", sID);

ShoppedDaoImpl shoppedDaoImpl = new ShoppedDaoImpl();

List<Map<String, Object>> shoppedlist = shoppedDaoImpl.getSaleSelect(sID);

request.setAttribute("shopped", shoppedlist);
%>
<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 350px;">
			<p class="product_title">商品信息</p>
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />

			<form id="form" name="form" action="#" method="post" style="text-align: center;" target="UserFrameName">
				<div class="product_form_div">
					<label class="product_form_div_left">展示图：</label><img id="product_img"
						alt="展示图" src="../imgs/${shopped[0].ShowPath}" width="100px">
				</div>
				<div class="product_form_div">
					<label class="product_form_div_left">商品名称：</label><input
						class="product_form_div_right" type="text" name="ProductName" value="${shopped[0].TradeName}" readonly="readonly">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">商品价格：</label><input
						class="product_form_div_right" type="text" name="Price" value="${shopped[0].Price}" readonly="readonly">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">购买数量：</label><input
						class="product_form_div_right" type="text"  name="Number" 
						value="${shopped[0].Number}" readonly="readonly">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">商品分类：</label>
					<select name="product_list" disabled="disabled">
						<option value="0" <c:if test="${shopped[0].fID==0}">selected="selected"</c:if>>新  鲜</option>
						<option value="1" <c:if test="${shopped[0].fID==1}">selected="selected"</c:if>>书  籍</option>
						<option value="2" <c:if test="${shopped[0].fID==2}">selected="selected"</c:if>>手  机</option>
						<option value="3" <c:if test="${shopped[0].fID==3}">selected="selected"</c:if>>服  装</option>
						<option value="4" <c:if test="${shopped[0].fID==4}">selected="selected"</c:if>>家  具</option>
						<option value="5" <c:if test="${shopped[0].fID==5}">selected="selected"</c:if>>电  脑</option>
						<option value="6" <c:if test="${shopped[0].fID==6}">selected="selected"</c:if>>运  动</option>
						<option value="7" <c:if test="${shopped[0].fID==7}">selected="selected"</c:if>>美  妆</option>
					</select>
				</div>
				<div class="product_form_div">
					<label class="product_form_div_left">商品描述：</label>
					<textarea class="product_form_div_right" name="Describe" readonly="readonly">${shopped[0].Describes}</textarea>
				</div>
			</form>

		</div>

	</div>
</body>
</html>