<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http:/www.tsh.com/tool" prefix="g"%>
<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.entity.GuestBookBean" %>
<%@ page import="changehands.dao.impl.GuestDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
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
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String text=request.getParameter("text");

if(text!=null){
	session.setAttribute("text",text);
	session.setAttribute("nPage",1);
}else{
	text=(String)session.getAttribute("text");
}

int UserID = (int)session.getAttribute("UserID");

ArrayList<GuestBookBean> GuestBookList = new ArrayList<GuestBookBean>();

GuestDaoImpl guestDaoImpl = new GuestDaoImpl();

GuestBookList = guestDaoImpl.getGuestSet(UserID,text);
request.setAttribute("GuestBookList", GuestBookList);

int intPage = (int)Math.ceil(GuestBookList.size()/5.0);
request.setAttribute("intPage", intPage);

int sizePage = GuestBookList.size();
request.setAttribute("sizePage", sizePage);

int nPage = (int)session.getAttribute("nPage");
request.setAttribute("nPage", nPage);
%>
<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 580px; height: 600px;">
			<div
				style="width: 450px; margin: 0 auto; padding-top: 50px; padding-bottom: 32px;">
				<p class="list_title">留 言 信 息</p>
				<form action="UserGuestSearch.jsp" method="post" style="text-align: right;" target="UserFrameName">
					<input name="text" class="list_text" type="text" value="${text}"
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
					<th style="width: 80px;">发布用户</th>
					<th style="width: 80px;">接受用户</th>
					<th style="width: 200px;">留言内容</th>
					<th style="width: 110px;">留言时间</th>
					<th style="width: 110px;">修改时间</th>
					<th style="width: 75px;">操&emsp;作</th>
				</tr>
				<c:forEach var="i" begin="${nPage*5-5}" end="${nPage*5-1}" items="${GuestBookList}">
					<tr>
						<td>${us:getUserName_(i.setID)}</td>
						<td>${us:getUserName_(i.getID)}</td>
						<td>${i.message}</td>
						<td>${g:gainString(i.releaseTime)}</td>
						<td>${g:gainString(i.modifyTime)}</td>
						<td><a href="UserGuestReply.jsp?setID=${i.setID}&getID=${i.getID}">回复</a> <a href="#">修改</a> 
						<a href="../GuestPagingDel?gID=${i.gID}">删除</a></td>
					</tr>
				</c:forEach>

			</table>
			<div class="list_page">
				<a href="../GuestPagingSearch?nPage=${nPage}&sFlag=0">首页</a> <a href="../GuestPagingSearch?nPage=${nPage}&sFlag=1">上一页</a><a href="#">${nPage}/${intPage}</a><a href="../GuestPagingSearch?nPage=${nPage}&sFlag=2">下一页</a>
				<a href="../GuestPagingSearch?nPage=${nPage}&sFlag=3">尾页</a>
			</div>

		</div>

	</div>
</body>
</html>