<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<style type="text/css">
#searchDiv {margin-left:300px;margin-top:200px;width:250px;}
#content {width:150px;}
#suggest {display:none; font-size:12px; width:150px; border: black 1px solid;}
</style>
</head>
<body>
	<div>说明：由于提供的关键字有限，请输入"北"字查看效果</div>
	<div id="searchDiv">
		<form action="">
			<input id="content" type="text">
			<input id="search-btn" type="button" value="查询"><br>
			<div id="suggest"></div>
		</form>
	</div>
</body>
</html>