<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 
  <body>
    <h5>欢迎登陆！</h5>
    <!-- <form action="testAction1">
    	<input type="text" name="insertNum" value="104"/>
    	<button type="submit">Submmit1</button>
    </form>
    <form action="testAction2">
    	<button type="submit">Submmit2</button>
    </form> -->
    <p style="color: red;">${testGetLoginID}</p>
  	<p style="color: blue;"><s:property value="#session.test_empEnglishName"/> </p>
  	<%-- <p><s:property value="#session.${testGetLoginID}test_empEnglishName"/> </p> --%>
  </body>
</html>
