<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/index.css" />

<title>ChangeHands</title>
</head>
<body>
	<iframe width="100%" scrolling="no" id="navFrameId"
		name="navFrameId" frameborder="0" src="index-nav_n.jsp"
		onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>10?fdh:10)"></iframe>

	<iframe width="100%" scrolling="no" id="dengluFrameId"
		name="dengluFrameName" frameborder="0" src="index-denglu_n.jsp"
		onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>10?fdh:10)"></iframe>
	
	<iframe width="100%" scrolling="no" id="indexFrameId"
		name="indexFrameName" frameborder="0" src="productPage.jsp"
		onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>10?fdh+20:10)"></iframe>

	<iframe width="100%" scrolling="no" id="endFrameId"
		name="endFrameId" frameborder="0" src="index-end.jsp"
		onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>10?fdh:10)"></iframe>
</body>
</html>
