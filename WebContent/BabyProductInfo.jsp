<%@page import="changehands.dao.impl.ProductDaoImpl"%>
<%@page import="changehands.dao.ProductDao"%>
<%@page import="changehands.entity.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
<%@ taglib uri="http:/www.tsh.com/tool" prefix="g"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link href="css/common.css" rel="stylesheet" />
<link href="css/detail.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.9.1.js"></script>
</head>
<script type="text/javascript">
	function increase() {
		if (parseInt(document.getElementById("value").innerText) != document
				.getElementById("num").value) {
			var num = document.getElementById("num");

			num.value = ++num.value;
		}
	}

	function decrease() {
		if (document.getElementById("num").value != 0) {
			var num = document.getElementById("num");

			num.value = --num.value;
		}
	}

</script>
<%
	//获得宝贝的ID
	int bID = Integer.valueOf(request.getParameter("bID"));
	//获得商品的ID
	int pID = Integer.valueOf(request.getParameter("pID"));
	
	//调用ProductDaoImpl的Dao层类
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	
	//得到指定商品ID的商品内容
	ProductBean productBean = productDaoImpl.getProductSelect(pID);
	
	//写入请求流
	request.setAttribute("bID", bID);
	request.setAttribute("productBean", productBean);
%>
<body>
	<div class="crumb">
		<div class="w">
			<div class="crumb-list">
				<img src="imgs/${us:getUserPath(requestScope.productBean.ID) }"
					width="30px" style="float: left; margin-top: 10px;" /> <a href="#"
					class="crumb-item" style="margin-left: 10px;">商家</a> <span>&gt;</span>
				<span class="crumb-item">${us:getUserName_(requestScope.productBean.ID) }</span>
				<a href="#" class="crumb-item" style="margin-left: 10px;">添加时间</a> <span>&gt;</span>
				<span class="crumb-item">${g:gainString(requestScope.productBean.addTime) }</span>
			</div>
		</div>
	</div>
	<div class="page-container w">
		<div class="intro-wrap clear">
			<div class="p-img-wrap">
				<div class="main-img-con">
					<img class="main-img"
						src="imgs/${requestScope.productBean.showPath }">
				</div>
				<ul class="p-img-list">
					<li class="p-img-item"><img class="p-img"
						src="imgs/${requestScope.productBean.showPath }"></li>
				</ul>
				<form name="form_guest" action="GuestAddServlet?putID=${requestScope.productBean.ID}&pID=${requestScope.productBean.pID}&num=1" method="post" target="indexFrameName">
					<table align="center" width="422px" border="1" style="margin-top: 10px;">
						<tr bgcolor="#999999">
							<td height="60px" colspan="3">
								<div align="center">
									<span>留言板</span>
								</div>
							</td>
						</tr>
						<tr>
							<td width="60px" height="40px">商家：</td>
							<td colspan="3"><input type="text" id="name" name="name" value="${us:getUserName_(requestScope.productBean.ID) }"/></td>
						</tr>
						<tr>
							<td width="60px" height="60px">内容：</td>
							<td colspan="3"><textarea name="put_text" id="put_text" cols="40" style="resize:none;"></textarea></td>
						</tr>
						<tr bgcolor="#999999">
							<td height="60px" colspan="3"><label> <span>
										<input type="submit" value="提交留言" /> <input type="reset"
										value="重新编写" />
								</span>

							</label></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="p-info-wrap">
				<p class="p-name">${requestScope.productBean.tradeName }</p>
				<p class="p-subtitle">${requestScope.productBean.describes }</p>
				<div class="info-item p-price-con">
					<span class="label">价格:</span> <span class="p-price">&yen;${requestScope.productBean.price }</span>
				</div>
				<div class="info-item p-quantity-con">
					<span class="label">库存:</span> <span class="p-price" id="value">${requestScope.productBean.number }</span>
				</div>
				<div class="info-item">
					<span class="label">数量:</span>
					<form id="formId"
						action="ShoppingAddServlet.do?pID=${requestScope.productBean.pID}"
						method="post" target="indexFrameName">
						<input class="p-count" name="num" id="num" value="1"
							readonly="readonly">
					</form>
					<span class="p-count-btn plus" data-opera-type="plus"
						onclick="increase()">+</span> <span class="p-count-btn minus"
						data-opera-type="minus" onclick="decrease()">-</span>
				</div>
				<div class="info-item">
					<a href="#" class="btn cart-add" onclick="document:formId.submit()">加入购物车</a>
					<a href="BabyDelServlet.do?bID=${requestScope.bID}" target="indexFrameName" class="btn cart-add">删除宝贝</a>
				</div>
			</div>
			<div class="p-info-wrap">
				<div class="info-item p-price-con">
					<p class="p-name">留言给商家<a href="#" style="float: right;" onclick="document.form_guest.put_text.focus()">回复</a></p>
				</div>
				<div class="guest_div">
					<ul>
						<c:forEach var="guest" items="${requestScope.guestBookList}">
							<li><img src="imgs/${us:getUserPath(guest.setID)}"
								width="40px" style="float: left;" /> <a href="#">${us:getUserName_(guest.setID)}:</a><a>回复</a><a
								href="#">${us:getUserName_(guest.getID)}:</a> <a>${guest.message}</a>
								<p>${g:gainString(guest.releaseTime)}<a href="#" onclick="document.form_guest.put_text.focus()">回复</a></p>
								<hr style="width: 100%; height: 1px; border: none; border-top: 1px solid #555555;" />
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>