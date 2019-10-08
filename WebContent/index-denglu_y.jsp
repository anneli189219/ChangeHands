<%@page import="changehands.dao.impl.BabyDaoImpl"%>
<%@page import="changehands.dao.impl.ProductDaoImpl"%>
<%@page import="changehands.dao.impl.ShoppedDaoImpl"%>
<%@page import="changehands.dao.impl.ShoppingDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http:/www.tsh.com/userDaoImpl" prefix="us"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/intex-tou.css" />
<link rel="stylesheet" type="text/css" href="css/search.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<title></title>
</head>
<%
	int UserID=0;
	try{
		UserID = (int)session.getAttribute("UserID");
		
		ShoppingDaoImpl shoppingDaoImpl = new ShoppingDaoImpl();
		int shoppingCount = shoppingDaoImpl.getShoppingCount(UserID);
		
		ShoppedDaoImpl shoppedDaoImpl = new ShoppedDaoImpl();
		int shoppedCount = shoppedDaoImpl.getShoppedCount(UserID);
		
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		int productCount = productDaoImpl.getProductCount(UserID);
		
		BabyDaoImpl babyDaoImpl = new BabyDaoImpl();
		int babyCount = babyDaoImpl.BabyCount(UserID);
		
		request.setAttribute("babyCount", babyCount);
		request.setAttribute("productCount", productCount);
		request.setAttribute("shoppedCount", shoppedCount);
		request.setAttribute("shoppingCount", shoppingCount);
	}catch(Exception e){
		response.getWriter().println("<script>window.location='index-denglu_n.jsp'</script>");
		e.printStackTrace();
	}
%>
<body>
	<div class="header">
		<div class="header_zhong">
			<h3>
				<img src="imgs/logo.png" width="300px" />
			</h3>
			<p>首页</p>
			<div class="erji">
				<ul>
					<li><a href="BabyPage.jsp?fID=8" target="indexFrameName">我的宝贝</a></li>
				</ul>
			</div>
			<div class="denglu">
				<div class="denglu_up">
					<ul>
						<li><a href="UserManage.jsp" target="indexFrameName"><img class="img_denglv" src="imgs/${sessionScope.User.headPath}" /></a></li>
						<li>
							<h2>${us:getUserName_(sessionScope.User.ID)}</h2> <span>虽然没挣到钱，但是开心就好</span>
						</li>
					</ul>
				</div>
				<div class="denglu_down">
					<ul>
						<li><a><img src="imgs/chushozhong.jpg"
								width="25px" height="25px" />
								<h5>出售中</h5>
								<h4>${productCount}</h4> </a></li>
						<li><a><img src="imgs/yishouchu.jpg"
								width="25px" height="25px" />
								<h5>已买入</h5>
								<h4>${shoppedCount}</h4> </a></li>
						<li><a><img src="imgs/wodeshouchang.jpg"
								width="25px" height="25px" />
								<h5>购物车</h5>
								<h4>${shoppingCount}</h4> </a></li>
						<li><a><img src="imgs/wodeguanzhu.jpg"
								width="25px" height="25px" />
								<h5>我的宝贝</h5>
								<h4>${babyCount}</h4> </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<div class="footer">
		<div class="footer_left">
			<ul>
				<li><a href="UserManage.jsp?numID=2" target="indexFrameName"><img src="imgs/fabu.png"
						width="45px" style="margin-right: 20px; margin-top: -5px;" /></a></li>
				<li><a href="UserManage.jsp?numID=2" target="indexFrameName"><h3>发布闲置</h3>
						<p>让你的闲置游起来 快速出手</p></a></li>
			</ul>
			<div
				style="float: left; margin-left: 200px; width: 1px; height: 100px; margin-top: 20px; background: darkgray;"></div>
		</div>
		<div class="footer_right">
			<div class="search d7">
				<form class="form_search" action="productSearch" method="post"
					target="indexFrameName">
					<input type="text" name="SelectName" placeholder="搜索从这里开始...">
					<button type="submit"></button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>