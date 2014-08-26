<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
.cover {
position:fixed; top: 0px; right:0px; bottom:0px;filter: alpha(opacity=60); background-color: #777;
z-index: 1002; left: 0px; display:none;
opacity:0.5; -moz-opacity:0.5;
}
</style>

</head>
<body>
<div class="container" style="height:2000px;">
	<div style="height:1000px;">
	</div>
	<a href="javascript:;" onclick="showMask()" >点我显示遮罩层</a><br />
</div>
<div id="cover" class="cover">

</div>							

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
function showMask(){
$(body).css("overflow","hidden")
$("#cover").show();
}
</script>
</body>
</html>