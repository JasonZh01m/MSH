<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.Cookie, java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>Login</title>
<html lang="en-US">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" charset="utf-8" language="javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
	html {
		background-color: #E9EEF0
	}
	.wrapper {
		margin: 140px auto;
		width: 884px;
	}
	.loginBox {
		background-color: #FEFEFE;
		border: 1px solid #BfD6E1;
		border-radius: 5px;
		color: #444;
		font: 14px 'Microsoft YaHei','微软雅黑';
		margin: 0 auto;
		width: 388px
	}
	.loginBox .loginBoxCenter {
		border-bottom: 1px solid #DDE0E8;
		padding: 24px;
	}
	.loginBox .loginBoxCenter th {
		margin-bottom: 10px
	}
	.loginBox .loginBoxButtons {
		background-color: #F0F4F6;
		border-top: 1px solid #FFF;
		border-bottom-left-radius: 5px;
		border-bottom-right-radius: 5px;
		line-height: 28px;
		overflow: hidden;
		padding: 20px 24px;
		vertical-align: center;
	}
	.loginBox .loginBoxButtons span p {
		color: red;
		font: 11px 'Microsoft YaHei','微软雅黑';
		line-height: 10px;
	}
	
	.loginBox .loginInput {
		border: 1px solid #D2D9dC;
		border-radius: 2px;
		color: #444;
		font: 13px 'Microsoft YaHei','微软雅黑';
		padding: 8px 14px;
		margin-bottom: 8px;
		margin-top: 10px;
		width: 220px;
		
	}
	.loginBox .loginInput:FOCUS {
		border: 1px solid #B7D4EA;
		box-shadow: 0 0 8px #B7D4EA;
	}
	.loginBox .loginBtn {
		background-image: -moz-linear-gradient(to bottom, #B5DEF2, #85CFEE);
		border: 1px solid #98CCE7;
		border-radius: 20px;
		box-shadow:inset rgba(255,255,255,0.6) 0 1px 1px, rgba(0,0,0,0.1) 0 1px 1px;
		/* color: #FFF */
		cursor: pointer;
		float: right;
		font: bold 13px Arial;
		padding: 5px 14px;
	}
	.loginBox .loginBtn:HOVER {
		background-image: -moz-linear-gradient(to top, #B5DEF2, #85CFEE);
	}
	.loginBox a.forgetLink {
		color: #ABABAB;
		cursor: pointer;
		float: right;
		font: 11px/20px Arial;
		text-decoration: none;
		vertical-align: middle;
	}
	.loginBox a.forgetLink:HOVER {
		text-decoration: underline;
	}
	.loginBox input#remember {
		vertical-align: middle;
	}
	.loginBox label[for="remember"] {
		font: 11px Arial;
	}
	</style>
	<script type="text/javascript">
	$(function() {
		$("#login_submit").click(function() {
			var c = $("#remember").is(":checked");
			if(c) {
				$('#login_remember').val("on");
			}
			else {
				$('#login_remember').val("off");
			}
			/* $("#loginForm").submit(); */
		});
			
	});
	
	
	function check() {
		var login_errorMsgE = document.getElementById("login_errorMsg");
		login_errorMsgE.innerHTML = "";
		var userName = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(userName == "" || password == "") {
			document.getElementById("errMsg").style.visibility = "visible";
			return false;
		} 
		return true;
	}
	</script>
</head>
<body>
	<%
		
	 	Cookie[] cs = request.getCookies();
		if(cs != null && cs.length != 0) {
	 	String user = "";
	 	String pwd = "";
	 	for (int i = 0; i < cs.length; i++) {
	 		if(cs[i].getName().equals("MSH_login_username")) {
	 			user = cs[i].getValue();
	 			request.setAttribute("user", user);
	 		}
	 		if(cs[i].getName().equals("MSH_login_password")) {
	 			pwd = cs[i].getValue();
	 			request.setAttribute("pwd", pwd);
	 		}
	 	}
		}
	 
	  %>
	<div class="container">
		<div class="row clearfix" style="margin-top: 200px; height: 800px;">
		
		<form id="loginForm"
		<%
			String rl = (String) request.getParameter("redirectlink");
			if(rl != null && rl.equals("redirectaction")) {
				%>
					action="redirectLink"
				<%
			} else {
				%>
					action="login"
				<%
			}
		%>
		onsubmit="check();">
		<input type="hidden" id="login_remember" name="login_remember" value="">
		<div class="loginBox">
			<div class="loginBoxCenter">
				<table style="padding: 0;">
				<tr>
					<th style="text-align: left"><s:text name="login_userName"/></th>
					<th><input id="username" type="text" name="username"  class="loginInput form-control" value="${user}"/></th>
				</tr>
				<tr>
				<th><s:text name="login_password"/>&nbsp;</th>
				<th><input id="password" type="password" name="password"  class="loginInput form-control" value="${pwd}"/></th>
				</tr>
				</table>
			</div>
			<div class="loginBoxButtons">
				<s:property value="#request.login_errorMsg"/>
				<span><p id="login_errorMsg" style="margin-top: -10px"><s:property value="#session.login_errorMsg"/></p><p id="errMsg" style="text-align: right; margin-top: -10px; visibility: hidden;"><s:text name="login_loginerror"/></p></span>
				<p><input style="margin-bottom: 4px;" id="remember" type="checkbox" name="remember" checked="checked"/>
				<label for="remember"><s:text name="login_rememberme"/></label>
				<input type="submit" id="login_submit" class="btn btn-primary btn-sm pull-right" value="<s:text name="login_login"/>"/></p>
			</div>
		</div>
		</form>
		</div>
	</div>
	<s:debug/>
</body>
</html>