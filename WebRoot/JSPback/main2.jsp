<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.9.2.custom.css">
<style type="text/css">

/* #demo{width:184px; margin:60px auto;}
.menu_head{border:1px solid #998675; background:#f30}
/* .menu{display:none; width:184px; border:1px solid #998675; border-top:none} */
/* .menu li{list-style:none; background:#493e3b}
.menu li a{padding:10px; display:block;color:#fff; text-decoration:none;}
.menu li a:hover{font-weight:bold;}
.menu li.alt{background:#362f2d;} */
*
/
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<script type="text/javascript">
	/*function reloadpage(page) {
		$.ajax({
			url : 'abc.action',
			type : "POST",
			dataType : 'html',
			success : function(date) {
				$("#page-content").html(date);
			}
		});
	}*/

	/*$("#itest").click(function() {
		alert("itest start");
		$.ajax({
			url : "timesheetAction1",
			type : "POST",
			dataType : 'json',
			success : function(data) {
				alert("successed!");
				 $("#right_content").load("timesheetAction1"); 
			}
			
		})
       
	});*/

	/*$("#itest").click(function(){     
   		$("#page-content").load("order1.jsp");
  	}); */
  	 
  	$(document).ready(function(id, url) { 
            $("#itest").click(function() { 
                $("#right_content").load("timesheetAction1"); 
            }); 
            $("#CategoryManage").click(function() { 
                $("#right_content").load("CategoryManage.aspx"); 
            }); 
        });  
	
	
		



	$(function() {
		var icons = {
			header : "ui-icon-circle-arrow-e",
			activeHeader : "ui-icon-circle-arrow-s"
		};
		$("#accordion").accordion({
			icons : icons,
			collapsible : true
		});
	});

	$(function() {
		$("accordion2").accordion({
			collapsible : true
		});
	});

	//test
	$(function() {
		/* $(".dropdown-menu li:even").addClass(""); */
		$("img.dropdown-menu-icon").click(function() {
			$(".dropdown-menu").slideToggle("fast");
		});
	});
	/* $("#itest").load(function() {
	$("#page-content").Attr("src") = "test.jsp";  	
	}); */

	/*  $("#toggle").button().click(function() {
	   if ( $( "#accordion" ).accordion( "option", "icons" ) ) {
	     $( "#accordion" ).accordion( "option", "icons", null );
	   } else {
	     $( "#accordion" ).accordion( "option", "icons", icons );
	   }
	 });
	}); */
</script>
</head>

<body>
	<div class="navbar" id="navbar">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-left" id="navbar-left">
				<a href="#" class="brand"> <img alt="" src="img/brand01.jpg" />
					<span>Welcome!</span> </a>
			</div>

			<div class="navbar-right" id="navbar-right">
				<!-- <ul class="navbar-right-ul" id="navbar-right-ul">
					<li id="accordion2" class="">
					<span>
							<img class="inner-icon" alt="" src="img/sidebar_arrow_down.png" />
					</span>
					<div>Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet.
							Lorem ipsum dolor sit amet.</div></li>
					<li class=""><a href="#" class="alert"> <img alt=""
							src="img/alert01.jpg"> </a></li>
					<li class="" id=""><a href="#" class="alert"> <img alt=""
							src="img/alert01.jpg">
					</a></li>


				</ul> -->
				<a href="#" class="dropdown-menu-a"><img
					class="dropdown-menu-icon" alt="" src="img/sidebar_arrow_down.png" />
				</a>
				<div class="dropdown-menu">
					<ul class="side-list" id="dropdown-menu-ul">
						<li class="side-list-li" id="dropdown-menu-li"><a href="#">设置</a>
						</li>
						<li class="side-list-li" id="dropdown-menu-li"><a href="#">服务</a>
						</li>
						<li class="side-list-li" id="dropdown-menu-li"><a href="#">注销</a>
						</li>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<div class="main-container" id="main-container">
		<div class="sidebar" id="sidebar">
			<!-- <div class="sidebar-container" id="sidebar-container">
				<ul class="side-list">
					<li class="side-list-li"><a href="#"> <img alt=""
							src="img/console_person.png" /> <span class="inner-a">Console</span>
							<img class="inner-icon" alt="" src="img/sidebar_arrow_down.png" />
					</a>
						<ul class="side-inner-list">
							<li>A</li>
							<li>B</li>
							<li>C</li>
							<li>D</li>
						</ul>
					</li>
					<li class="side-list-li"><a href="#"> <img alt=""
							src="img/i_22_charts.png" /> <span class="inner-a">Salary</span>
							<img class="inner-icon" alt="" src="img/sidebar_arrow_down.png" />
					</a>
					</li>
					<li class="side-list-li"><a href="#">
							<div>
								<img alt="" src="img/i_22_forms.png" /> <span class="inner-a">Form</span>
								<img class="inner-icon" alt="" src="img/sidebar_arrow_down.png" />
							</div> </a>
					</li>
				</ul>
			</div> -->
			<div class="side-list" id="accordion">
				<span class="side-list-li"><img alt=""
					src="img/console_person.png" /> <span class="inner-a">Console</span>
					<img class="inner-icon" alt="" src="img/sidebar_arrow_down.png" />
				</span>
				<div>
					<ul>
						<li><a id="itest" style="cursor: pointer;">A link</a></li>
						<li><a href="#">B</a></li>
						<li><a href="#">C</a></li>
					</ul>
				</div>
				<span class="side-list-li"><img alt=""
					src="img/i_22_charts.png" /> <span class="inner-a">Salary</span> <img
					class="inner-icon" alt="" src="img/sidebar_arrow_down.png" /> </span>
				<div>Phasellus mattis tincidunt nibh.</div>
				<span class="side-list-li">
					<div>
						<img alt="" src="img/i_22_forms.png" /> <span class="inner-a">Form</span>
						<img class="inner-icon" alt="" src="img/sidebar_arrow_down.png" />
					</div> </span>
				<div>
					<ul>
						<li>A</li>
						<li>B</li>
						<li>C</li>
						<li>D</li>
					</ul>

				</div>
			</div>
		</div>
		<div class="main-content" id="main-content">
			<div class="breadcrumbs" id="breadcrumbs"></div>
			<div class="page-content" id="page-content">
				<%--<div class="left_content"></div>
				--%><div class="right_content" id="right_content" style="background-color:#93cbf9">
            	</div>
			</div>



		</div>

	</div>
WELCOME:<s:property value="#session.Emp_ID"/>,&nbsp;Your English name is:&nbsp;<s:property value="#session.Name_English"/>, SystemRoleID is: <s:property value="#session.systemRole"/>, role name is: <s:property value="#session.sysRoleName"/></p>, size is: <s:property value="session.Authoritys"/>
<p><a href="timesheetAction1">timesheetAction1</a></p>
</body>
</html>
