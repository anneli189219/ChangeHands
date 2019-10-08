<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.entity.UserBean"%>
<%@ page import="changehands.dao.impl.UserDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//找到JAVAEE路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	session.setAttribute("nPage",1);//留言内容页的page值
	session.setAttribute("pPage",1);//发布商品页的page值
	session.setAttribute("sPage",1);//已购买商品页的page值
	session.setAttribute("aPage",1);//销售记录页的page值
	int UserID=0;
	try{
		UserID = (int)session.getAttribute("UserID");
	}catch(Exception e){
		response.getWriter().println("<script> alert('您还未登录！请登录再试试！');window.location='Login.jsp'</script>");
		e.printStackTrace();
	}

	UserDaoImpl userDaoImpl = new UserDaoImpl();

	UserBean User = new UserBean();
	User = userDaoImpl.UserSelect(UserID);
	//System.out.println(User.getRegTime());
	request.setAttribute("User", User);
	
	if(request.getParameter("numID")!=null){
		request.setAttribute("numID", Integer.valueOf(request.getParameter("numID")));
	}
	else{
		request.setAttribute("numID",0);
	}
%>
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

.a_active {
	color: red;
}
</style>

<body>
<div style="width: 1300px; background-color: #fef7dc; margin: 0 auto; border-radius:5px 5px 5px 5px;">
	<div style="width: 800px; height: 600px; margin: 0 auto; margin-top: 10px;">
		<div
			style="float: left; width: 200px; height: 100%; margin-top: 20px;">
			<img alt="头像图片" src="${path}imgs/${User.headPath}" width="150px"
				style="padding-top: 25px; padding-left: 25px;">
			<p class="title">个人中心</p>
			<ul class="ul_left">
				<li><a href="pages/UserSafePage.jsp" target="UserFrameName">安全设置</a></li>
				<li><a href="pages/UserInforPage.jsp" target="UserFrameName">个人信息</a></li>
				<li><a href="pages/UserShoppedPage.jsp" target="UserFrameName">已购买的商品</a></li>
				<li><a href="pages/UserProductPage.jsp" target="UserFrameName">已发布的商品</a></li>
				<li><a href="pages/UserGuestPage.jsp" target="UserFrameName">留言信息</a></li>
				<li><a href="pages/ProductRepositPage.jsp"
					target="UserFrameName">发布商品</a></li>
			</ul>
		</div>
		
		<div
			style="float: right; width: 600px; height: 100%;">
				<c:choose>
				    <c:when test="${numID==1}">
				        <iframe src="pages/UserGuestPage.jsp" id="UserFrameId"
						name="UserFrameName" scrolling="no" frameborder="0" width="100%"
						height="100%"></iframe>
				    </c:when>
				    <c:when test="${numID==2}">
				        <iframe src="pages/ProductRepositPage.jsp" id="UserFrameId"
						name="UserFrameName" scrolling="no" frameborder="0" width="100%"
						height="100%"></iframe>
				    </c:when>
				    <c:otherwise>
				        <iframe src="pages/UserSafePage.jsp" id="UserFrameId"
						name="UserFrameName" scrolling="no" frameborder="0" width="100%"
						height="100%"></iframe>
				    </c:otherwise>
				</c:choose>
		</div>
	</div>
</div>
</body>
</html>