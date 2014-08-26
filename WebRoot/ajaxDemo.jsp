<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript">
 $(document).ready( function() {
	 $( "#btn").click( function(){
	              $.ajax({
	                   url: "getData",
	                   type: "post",
	                   data: null,
	                   dataType: "json",
	                   success: function(data) {
	                      $("#msg").html("");
	                      $("#msg").append( "姓名：" + data.name + "<br>" );
	                      $("#msg").append( "年龄：" + data.age + "<br>" );
	                   },
	                   error: function() {
	                         alert( "ajax请求失败");
	                   }
	             });
	       });
	       
	       $ ("#btn2" ).click(function(){
	              $.ajax({
	                   url: "getUser",
	                   type: "post",
	                   data: null,
	                   dataType: "json",
	                   success: function(data) {
	                          $("#msg2").html( "");
	                          $("#msg2").append( "用户名：" + data.user.username + "<br>" );
	                          $("#msg2").append( "密    码：" + data.user.password + "<br>" );
	                   },
	                   error: function() {
	                         alert( "ajax请求失败");
	                   }
	             });
	       });
	       
	       $ ("#btn3").click(function(){
	              $.ajax({
	                   url: "getUsers",
	                   type: "post",
	                   data: null,
	                   dataType: "json",
	                   success: function(data) {
	                         
	                          $("#msg3").append( "<table>");
	                          for( var i = 0; i < data.users.length; i++) {
	                                $("#msg3").append( "<tr>");
	                                $("#msg3").append( "<td>" + data.users[i].id + "</td>" );
	                                $("#msg3").append( "<td>" + data.users[i].username + "</td>" );
	                                $("#msg3").append( "<td>" + data.users[i].password + "</td>" );
	                                $("#msg3").append( "<td>" + data.users[i].age + "</td>" );
	                                $("#msg3").append( "</tr>");
	                         }
	                          $("#msg3").append( "</table>");
	                   },
	                   error: function() {
	                         alert( "ajax请求失败");
	                   }
	             });
	       });
	       
	      /*  $ ("#btn4").click(function(){
	              $.ajax({
	                   url: "getArs",
	                   type: "post",
	                   data: null,
	                   dataType: "json",
	                   success: function(data) {
	                	   		$("#msg3").append( "<table>");
		                          for( var i = 0; i < data.abrs.length; i++) {
		                                $("#msg3").append( "<tr>");
		                                $("#msg3").append( "<td>" + data.abrs[i].empLoginId + "</td>" );
		                                $("#msg3").append( "<td>" + data.abrs[i].absenceTotalHours + "</td>" );
		                                $("#msg3").append( "<td>" + data.abrs[i].absenceApproverLineManager + "</td>" );
		                                $("#msg3").append( "<td>" + data.abrs[i].absenceReason + "</td>" );
		                                $("#msg3").append( "</tr>");
		                         }
		                          $("#msg3").append( "</table>");
	                   },
	                   error: function() {
	                         alert( "ajax请求失败");
	                   }
	             });
	       }); */
	       
	       
	       $("#btn5").click(function(){
	              $.ajax({
	                   url: "requestInfo",
	                   type: "post",
	                   data: null,
	                   dataType: "json",
	                   success: function(data) {
	                	   $("#msg5").html("");
	                	   $("#msg5").append( "<table>");
	                          for( var i = 0; i < data.request_info_ars.length; i++) {
	                                $("#msg5").append( "<tr>");
	                                $("#msg5").append( "<td>" + data.request_info_ars[i].empLoginId + "</td>" );
	                                $("#msg5").append( "<td>" + data.request_info_ars[i].absenceTotalHours + "</td>" );
	                                $("#msg5").append( "<td>" + data.request_info_ars[i].absenceApproverLineManager + "</td>" );
	                                $("#msg5").append( "<td>" + data.request_info_ars[i].absenceReason + "</td>" );
	                                $("#msg5").append( "</tr>");
	                         }
	                          $("#msg5").append( "</table>");
	                   },
	                   error: function() {
	                         alert( "ajax请求失败");
	                   }
	             });
	       });
	 });
 
 </script>
</head>
<body>
	<input type ="button" value="使用ajax取得数据" id="btn" >
      <div id ="msg"></div>
      <input type ="button" value="使用ajax取得user对象" id="btn2" >
      <div id ="msg2"></div>
      <input type ="button" value="使用ajax取得users用户数组" id ="btn3">
      <div id ="msg3"></div>
      <!-- <input type ="button" value="使用ajax取得abrs信息" id ="btn4">
      <div id ="msg4"></div> -->
     <input type ="button" value="使用ajax取得absenceRecord" id ="btn5">
      <div id ="msg5"></div>
<s:debug/>
</body>
</html>