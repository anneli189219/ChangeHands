<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http:/www.tsh.com/tool" prefix="g"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.entity.ShoppedBean" %>
<%@ page import="changehands.entity.ProductBean" %>
<%@ page import="changehands.dao.impl.ShoppedDaoImpl" %>
<%@ page import="changehands.dao.impl.ProductDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
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

.list_sumbit {
	margin-left: -5px;
	text-decoration: none;
	background: #2f435e;
	color: #f2f2f2;
	padding: 5px 10px 5px 10px;
	font-size: 16px;
	font-family: 微软雅黑, 宋体, Arial, Helvetica, Verdana, sans-serif;
	font-weight: bold;
	border-radius: 5px;
	-webkit-transition: all linear 0.30s;
	-moz-transition: all linear 0.30s;
	transition: all linear 0.30s;
}

.list_text {
	height: 28px;
}

.list_word {
	font-family: "微软雅黑";
	font-size: 16px;
	font-weight: 600;
}

.list_title {
	font-family: "微软雅黑";
	font-size: 30px;
	font-weight: 800;
	margin-top: -5px;
	float: left;
}

.list_table_gridtable {
	margin: 0 auto;
	table-layout: fixed;
	word-break:break-all;
	font-family: verdana, arial, sans-serif;
	font-size: 12px;
	font-weight: 600;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

.list_table_gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

.list_table_gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}

.list_page {
	padding-top: 20px;
	text-align: center;
	margin: 0 auto;
	width: 500px;
}

.list_page a {
	margin: 10px;
	font-family: "微软雅黑";
	font-size: 16px;
	font-weight: 600;
}
</style>
<%
int UserID = (int)session.getAttribute("UserID");

ShoppedDaoImpl ShoppedDaoImpl = new ShoppedDaoImpl();

List<Map<String, Object>> ShoppedList_ = ShoppedDaoImpl.getShoppedSet_(UserID);
request.setAttribute("ShoppedList_", ShoppedList_);

int intPage = (int)Math.ceil(ShoppedList_.size()/5.0);
request.setAttribute("intPage", intPage);

int sizePage = ShoppedList_.size();
request.setAttribute("sizePage", sizePage);

int sPage = (int)session.getAttribute("sPage");
request.setAttribute("sPage", sPage);
%>
<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 580px; height: 600px;">
			<div
				style="width: 450px; margin: 0 auto; padding-top: 50px; padding-bottom: 32px;">
				<p class="list_title">已购买的商品</p>
				<form action="UserShoppedSearch.jsp" method="post" style="text-align: right;" target="UserFrameName">
					<input name="text" class="list_text" type="text" value=""
						placeholder="请输入要搜索的内容" /> <input class="list_sumbit"
						type="submit" value="搜    索" />
				</form>
				<br />
				<br />
				<hr
					style="height: 1px; border: none; border-top: 1px solid #555555;" />
			</div>
			<table class="list_table_gridtable">
				<tr>
					<th style="width: 40px;">封&emsp;面</th>
					<th style="width: 80px;">名&emsp;称</th>
					<th style="width: 200px;">描&emsp;述</th>
					<th style="width: 85px;">价&emsp;格</th>
					<th style="width: 60px;">数&emsp;量</th>
					<th style="width: 120px;">购买时间</th>
					<th style="width: 75px;">操&emsp;作</th>
				</tr>
				
				<c:forEach var="i" begin="${sPage*5-5}" end="${sPage*5-1}" items="${ShoppedList_}">
					<tr>
						<td><img alt="封面图片" src="../imgs/${i.ShowPath}"
							width="40px"></td>
						<td>${i.TradeName}</td>
						<td>${i.Describes}</td>
						<td>${i.Price}</td>
						<td>${i.Number}</td>
						<td>${g:gainString(i.ShopTime)}</td>
						<td><a href="UserShoppedInfo.jsp?sID=${i.sID}">查看详情</a></td>
					</tr>
				</c:forEach>

			</table>
			<div class="list_page">
				<a href="../ShoppedPagingServlet?sPage=${sPage}&sFlag=0">首页</a> <a href="../ShoppedPagingServlet?sPage=${sPage}&sFlag=1">上一页</a><a href="#">${sPage}/${intPage}</a><a href="../ShoppedPagingServlet?sPage=${sPage}&sFlag=2">下一页</a>
				<a href="../ShoppedPagingServlet?sPage=${sPage}&sFlag=3">尾页</a>
			</div>

		</div>

	</div>
</body>
</html>