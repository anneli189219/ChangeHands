<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/intex-denglv.css" />
<title>Insert title here</title>
</head>
<%
int UserID=0;
try{
	UserID = (int)session.getAttribute("UserID");
}catch(Exception e){
	response.getWriter().println("<script>window.location='index-nav_n.jsp'</script>");
	e.printStackTrace();
}
%>
<body>
	<div class="nav">
		<div class="nav_left">
			<ul class="left">
				<li style="width: 180px"><a href="UserManage.jsp" target="indexFrameName"><img class="img_tou"
						src="imgs/${sessionScope.User.headPath}" />${us:getUserName_(sessionScope.User.ID)}</a></li>
				<li style="width: 80px"><a href="SignOut" target="_top">退出</a></li>
				<li style="width: 80px"><a href="UserManage.jsp?numID=1" target="indexFrameName">留言信息</a></li>
				<li style="width: 80px"><a href="#">手机逛网站</a></li>
			</ul>
		</div>
		<div class="nav_right">
			<ul class="right">
				<li><a href="index-x.jsp" target="_top">网站首页</a></li>
				<li><a href="#">网站简介</a></li>
				<li><a href="ShoppingShowServlet.do" target="indexFrameName">购物车</a></li>
				<li><a href="#">联系方式</a></li>
			</ul>
		</div>
	</div>
</body>
</html>