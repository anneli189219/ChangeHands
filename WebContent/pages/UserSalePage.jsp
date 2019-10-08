<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
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
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

int UserID= (int)session.getAttribute("UserID");

ShoppedDaoImpl ShoppedDaoImpl = new ShoppedDaoImpl();

List<Map<String, Object>> SaleList = ShoppedDaoImpl.getSaleSet(UserID);
request.setAttribute("SaleList", SaleList);

int intPage = (int)Math.ceil(SaleList.size()/5.0);
request.setAttribute("intPage", intPage);

int sizePage = SaleList.size();
request.setAttribute("sizePage", sizePage);

int aPage = (int)session.getAttribute("aPage");
request.setAttribute("aPage", aPage);
%>
<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 580px; height: 600px;">
			<div
				style="width: 450px; margin: 0 auto; padding-top: 50px; padding-bottom: 32px;">
				<p class="list_title">销 售 记 录</p>
				<form action="UserSaleSearch.jsp" method="post" style="text-align: right;" target="UserFrameName">
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
					<th style="width: 80px;">购买用户</th>
					<th style="width: 40px;">封&emsp;面</th>
					<th style="width: 80px;">名&emsp;称</th>
					<th style="width: 200px;">描&emsp;述</th>
					<th style="width: 80px;">价&emsp;格</th>
					<th style="width: 80px;">数&emsp;量</th>
					<th style="width: 110px;">购买时间</th>
				</tr>
				<c:forEach var="i" begin="${aPage*5-5}" end="${aPage*5-1}" items="${SaleList}">
					<tr>
						<td>${us:getUserName_(i.ID)}</td>
						<td><img alt="头像图片" src="../imgs/${i.ShowPath}" width="40px"></td>
						<td>${i.TradeName}</td>
						<td>${i.Describes}</td>
						<td>${i.Price}</td>
						<td>${i.Number}</td>
						<td>${g:gainString(i.ShopTime)}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="list_page">
				<a href="../SalePagingServlet?aPage=${aPage}&sFlag=0">首页</a> <a href="../SalePagingServlet?aPage=${aPage}&sFlag=1">上一页</a><a href="#">${aPage}/${intPage}</a><a href="../SalePagingServlet?aPage=${aPage}&sFlag=2">下一页</a>
				<a href="../SalePagingServlet?aPage=${aPage}&sFlag=3">尾页</a>
			</div>

		</div>

	</div>
</body>
</html>