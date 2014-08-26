<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">
<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script type="text/javascript">
		$(function() {
            $("#Link1").click(function() { 
               /* $("#main-content-container").load("empInfoAction?empLoginId=jennifers"); */
               $.get("empInfoAction?empLoginId=jennifers", function(data){
                	$("#main-content-container").html(data);
                })
            }); 
             $("#Link2").click(function() { 
               $("#main-content-container").load("summaryTsInfoAction");
               /* $("#main-content-container").load("testdynaTable.jsp"); */
               
               /* $.get("summaryTsInfoAction", function(data){
                	$("#main-content-container").html(data);
                }) */
            }); 
            
            $("#Link3").click(function() { 
               /* $("#main-content-container").load("empInfoAction?empLoginId=jennifers"); */
               $.get("salarySettingAction", function(data){
                	$("#main-content-container").html(data);
                })
            }); 
            
         });

</script>
</head>

<body>
	<div class="container main_jsp_container">
		<div class="row clearfix main_jsp_row main_jsp_clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-inverse main_jsp_navbar" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<!-- <li class="active"><a href="#">Link</a></li>
						<li><a href="#">Link</a></li> -->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul>
				</div>

				</nav>
				<div class="sub-container main_jsp_sub-container">
					<div class="col-md-2 column main_jsp_col-md-6">
						<div class="panel-group" id="panel-310080">
							<div class="panel panel-default">
								<div class="panel-heading main_jsp_panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse"
										data-parent="#panel-310080" href="#panel-element-334905">Collapsible
										Group Item</a>
								</div>
								<div id="panel-element-334905" class="panel-collapse collapse">
									<div class="panel-body main_jsp_panel-body">
									<!-- <div class="panel-body-list"> -->
										<ul class=main_jsp_panel_ul id="panel-body-ul">
											<li class="main_jsp_panel_li" ><a id="Link1" style="cursor: pointer;">Link1</a></li>
											<!-- target="_blank;" href="testdynaTable.jsp" -->
											<li class="main_jsp_panel_li" id="panel-body-li"><a id="Link2" style="cursor: pointer;">Link2</a></li>
											<li class="main_jsp_panel_li" id="panel-body-li"><a id="Link3" style="cursor: pointer;">Link3</a></li>
										</ul>
									<!-- </div> -->
									</div>
								</div>
							</div>
						</div>
						<div class="panel-group" id="panel-89462">
							<div class="panel panel-default">
								<div class="panel-heading main_jsp_panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse"
										data-parent="#panel-89462" href="#panel-element-791786">Collapsible
										Group Item</a>
								</div>
								<div id="panel-element-791786" class="panel-collapse collapse">
									<div class="panel-body main_jsp_panel-body">Anim pariatur cliche...</div>
								</div>
							</div>
						</div>
						<div class="panel-group" id="panel-177043">
							<div class="panel panel-default">
								<div class="panel-heading main_jsp_panel-heading">
									<a class="panel-title" data-toggle="collapse"
										data-parent="#panel-177043" href="#panel-element-899784">Collapsible
										Group Item</a>
								</div>
								<div id="panel-element-899784"
									class="panel-collapse collapse">
									<div class="panel-body main_jsp_panel-body">Anim pariatur cliche...</div>
								</div>
							</div>
							
						</div>
					</div>
					
					<div class="col-md-10" id="main-content-container">
						<input class="form-control" value="input" type="text">
					</div>
					<!-- <div class="main-content-container col-md-12">
						<div class="col-md-7 column main_jsp_col-md-7">
						<ul class="breadcrumb">
							<li><a href="#">Home</a> <span class="divider">/</span></li>
							<li><a href="#">Library</a> <span class="divider">/</span></li>
							<li class="active">Data</li>
						</ul>
						</div>
						<div class="main-content col-md-12" id="main-content">
							
							
							
						</div>
					</div> -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
