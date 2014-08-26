<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Update Time Sheet Table successfully!</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-select1.css" rel="stylesheet">
	<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div class="container">
	<!-- <div class="row clearfix">
		<div class="col-md-12 column"> -->
			<div class="alert alert-success alert-dismissable navbar-fixed-top">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					Success!!
				</h4><strong>Congratulations!</strong> Update Time Sheet Table successfully! Totally time consumed: <strong><s:property value="#session.uts_consumetime"/></strong>&nbsp;seconds. Totally update <strong><s:property value="#session.uts_sumrecords"/></strong>&nbsp;records. <p><a href="index.jsp" class="alert-link">Black to Home Page.</a></p>
				
			</div>
		<!-- </div>
	</div> -->
</div>
  </body>
</html>
