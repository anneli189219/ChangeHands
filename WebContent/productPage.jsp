<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
<%@ taglib uri="http:/www.tsh.com/tool" prefix="g"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.dao.ProductDao"%>
<%@ page import="changehands.entity.ProductBean"%>
<%@ page import="changehands.entity.pageBean"%>
<%@ page import="changehands.service.servlet.pageService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%
	int fID=-1;
	if(request.getParameter("fID")!=null){
		fID= Integer.parseInt(request.getParameter("fID"));
	}
	
	int currentpage = (int) Double.parseDouble(request.getParameter("currentpage") != null ? request.getParameter("currentpage") : "1");
	int recordpage = (int) Double.parseDouble(request.getParameter("recordpage") != null ? request.getParameter("recordpage") : "15");
	
	pageService pService = new pageService();
	
	String selectname="";

	//调用Service类
	pageBean pBean = pService.getPageBean(currentpage, recordpage, selectname, fID);
	request.setAttribute("fID", fID);
	request.setAttribute("pBean", pBean);
	request.setAttribute("productBeans", pBean.getProductlist());
	request.setAttribute("currentpage", pBean.getCurrentpage());
	request.setAttribute("recordpage", pBean.getNumberpage());
	%>
	
	<style>
	.active_{
		border-bottom: 2px solid black;
		padding-bottom: 4px;
	}
	</style>
<body>
	<div class="aside">
		<ul>
			<li><a href="productPage.jsp?fID=0" target="indexFrameName" class="<c:if test="${requestScope.fID==0}">active_</c:if>">新&nbsp;&nbsp;鲜</a></li>
			<li><a href="productPage.jsp?fID=1" target="indexFrameName" class="<c:if test="${requestScope.fID==1}">active_</c:if>">书&nbsp;&nbsp;籍</a></li>
			<li><a href="productPage.jsp?fID=2" target="indexFrameName" class="<c:if test="${requestScope.fID==2}">active_</c:if>">手&nbsp;&nbsp;机</a></li>
			<li><a href="productPage.jsp?fID=3" target="indexFrameName" class="<c:if test="${requestScope.fID==3}">active_</c:if>">服&nbsp;&nbsp;装</a></li>
			<li><a href="productPage.jsp?fID=4" target="indexFrameName" class="<c:if test="${requestScope.fID==4}">active_</c:if>">家&nbsp;&nbsp;具</a></li>
			<li><a href="productPage.jsp?fID=5" target="indexFrameName" class="<c:if test="${requestScope.fID==5}">active_</c:if>">电&nbsp;&nbsp;脑</a></li>
			<li><a href="productPage.jsp?fID=6" target="indexFrameName" class="<c:if test="${requestScope.fID==6}">active_</c:if>">运&nbsp;&nbsp;动</a></li>
			<li><a href="productPage.jsp?fID=7" target="indexFrameName" class="<c:if test="${requestScope.fID==7}">active_</c:if>">美&nbsp;&nbsp;妆</a></li>
			<li><a href="BabyPage.jsp?fID=8" target="indexFrameName">宝&nbsp;&nbsp;贝</a></li>
		</ul>
	</div>
	<div class="main">
		<ul>
			<c:forEach var="i" items="${requestScope.productBeans}">
				<li>
					<a href="productInfo?pID=${i.pID}" target="indexFrameName"><img src="imgs/${i.showPath}" width="200px"
							height="200px" alt="${i.tradeName}" />
							<p style="color: #333333;font-size: 18px;margin-top: -10px;overflow:hidden;white-space: nowrap;">${i.tradeName}</p>
							<p style="color: #555555;overflow:hidden;white-space: nowrap;">${i.describes}</p>
							<p style="float: left;color: #990000;">￥${i.price}</p>
							<p style="position: absollute;margin-left: 140px;color: #333333;">${us:getUserName_((i.ID)+0)}</p>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div class="fenye">
		<ul>			
			<c:choose>
				<c:when test="${requestScope.pBean.currentpage==1}">
					<li><a href="#">首&nbsp;页</a></li>
					<li><a href="#">上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="productPage.jsp?fID=${requestScope.fID}">首&nbsp;页</a></li>
					<li><a
						href="productPage.jsp?currentpage=${requestScope.pBean.pre}&recordpage=${requestScope.pBean.numberpage}&fID=${requestScope.fID}">上一页</a></li>
				</c:otherwise>
			</c:choose>
			<!-- 当前页 -->
			<li><a>${requestScope.pBean.currentpage}/${g:StringToInt(requestScope.pBean.totalpage)}</a></li>
			<!-- 下一页 -->
			<c:choose>
				<c:when
					test="${requestScope.pBean.currentpage==requestScope.pBean.totalpage}">
					<li><a href="#">下一页</a></li>
					<li><a href="#">尾&nbsp;页</a></li>
				</c:when>
				<c:otherwise>
					<li><a
						href="productPage.jsp?currentpage=${requestScope.pBean.next}&recordpage=${requestScope.pBean.numberpage}&fID=${requestScope.fID}">下一页</a></li>
					<li><a
						href="productPage.jsp?currentpage=${requestScope.pBean.totalpage}&recordpage=${requestScope.pBean.numberpage}&fID=${requestScope.fID}">尾&nbsp;页</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

</body>
</html>
