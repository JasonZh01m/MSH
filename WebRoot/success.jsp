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
  <%
  	if(session.getAttribute("login") == null)  
  		request.getRequestDispatcher("login.jsp");
		/* response.sendRedirect("login.jsp");	 */	
  %>
  <body>
    <h5>欢迎登陆！</h5>
    <!-- <form action="testAction1">
    	<input type="text" name="insertNum" value="104"/>
    	<button type="submit">Submmit1</button>
    </form>
    <form action="testAction2">
    	<button type="submit">Submmit2</button>
    </form> -->
  <p>WELCOME:<s:property value="#session.login.emp.empLoginId"/>,&nbsp;Your English name is:&nbsp;<s:property value="#session.login.emp.nameEnglish"/>, SystemRoleID is: <s:property value="#session.login.emp.role.sysRoleId"/>, role name is: <s:property value="#session.login.emp.role.sysRoleName"/></p>
  
  </body>
</html>
