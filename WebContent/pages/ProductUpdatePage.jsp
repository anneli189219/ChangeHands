<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="changehands.entity.UserBean" %>
<%@ page import="changehands.dao.impl.UserDaoImpl" %>
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



<body>
	<div
		style="float: right; width: 600px; height: 100%; background-color: cornsilk;">
		<div style="margin: 0 auto; width: 350px;">
			<p class="product_title">商品信息</p>
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />

			<form id="form" name="form" action="../UserInforReposit" method="post" style="text-align: center;" target="UserFrameName">
				<div class="product_form_div">
					<label class="product_form_div_left">展示图：</label><img
						alt="展示图" src="img/QQ截图20190612192403.png" width="100px">
						<div style="padding-top: 10px;padding-bottom: 20px;">
							<input type="file" id="image_file" name="image_file" accept="image/jpeg, image/png, image/jpg" style="width: 200px;float: left;"/>
							<a class="product_word" style="float: right;" onclick="doPost()" href="javascrip:void()">上传展示图</a>
						</div>
					<script type="text/javascript">
						function doPost() {
							if(document.getElementById("image_file").value == null || document.getElementById("image_file").value == ""){
								alert("请浏览展示图之后再试！");
							}else{
								var myForm = document.getElementById("form");
								myForm.action="../UserUploadPcture";
								myForm.enctype="multipart/form-data";
								
								alert("展示图上传成功！请单击保存按钮！");
							}
						}
					</script>
				</div>
				<div class="product_form_div">
					<label class="product_form_div_left">商品名称：</label><input
						class="product_form_div_right" type="text" name="ProductName" value="蔡徐坤">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">商品价格：</label><input
						class="product_form_div_right" type="text" name="Price" value="￥9999.00">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">库存数量：</label><input
						class="product_form_div_right" type="text"  name="Number" 
						value="999">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">商品分类：</label>
					<select name="product_list">
						<option value="0">新  鲜</option>
						<option value="1">书  籍</option>
						<option value="2">手  机</option>
						<option value="3">服  装</option>
						<option value="4">家  具</option>
						<option value="5">电  脑</option>
						<option value="6">运  动</option>
						<option value="7">美  妆</option>
					</select>
				</div>
				<div class="product_form_div">
					<label class="product_form_div_left">上架状态：</label><input
						class="product_form_div_right" type="text" name="State" value="未上架">
				</div>
				<br />
				<div class="product_form_div">
					<label class="product_form_div_left">商品描述：</label>
					<textarea class="product_form_div_right" name="Describe">我是练习时长2年半的蔡徐坤</textarea>
				</div>
				<br />
				<br />
				<div>
					<input class="product_sumbit" type="submit" name="submit"
						value="保存">
				</div>
			</form>

		</div>

	</div>
</body>
</html>