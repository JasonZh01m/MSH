<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<%@page import="com.moravia.hs.base.entity.other.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script> -->
<%
  	if(session.getAttribute("login") == null)
  	 	response.sendRedirect("login.jsp");	
  %>
</head>
<body>
<nav class="navbar navbar-default navbar-inverse navbar-static-top" role="navigation">
				<div class="navbar-header">
					 <%-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
					 <span class="sr-only">Toggle navigation</span>
					 <span class="icon-bar"></span>
					 <span class="icon-bar"></span><span class="icon-bar"></span></button>  --%>
					 <a class="navbar-brand" href="index.jsp">Home</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
					<%-- <s:if test="#session.login.emp.role.sysRoleId > 3" >style="display:none;"</s:if> --%>
					<% if(session.getAttribute("login") != null) {
							Login login = (Login) session.getAttribute("login");
							/* System.out.print("abc login english name : + " + login.getEmp().getNameEnglish()); */
							if (login.getEmp().getRole().getSysRoleId() <= 3 ) {
								%>
								<li class="dropdown" >
									 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Finance<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="salarySettingAction">Salary Setting</a>
										</li>
										<li>
											<a target="_blank" href="summaryTsInfoAction">Salary Edit</a>
										</li>
										<li>
											<a href="toFinancialStatementInfoPageAction">Financial Report</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="payrollConfirmationAction">Payroll Confirmation</a>
										</li>
									</ul>
								</li>
								<li class="dropdown" <s:if test="#session.login.emp.role.sysRoleId > 3" >style="display:none;"</s:if>>
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">HR<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a target="_blank" href="toCreateEmpPageAction">Create Employee</a>
										</li>
										<li>
											<a target="_blank" href="hRBaseInfoAction?operationFlag_tohbip=tohrBaseInfoPage">HR Info</a>
										</li>
										<li>
											<a href="toEmpHistoryInfoPage">Employee History Track</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="timeSheetTrackAction?operationFlag_tstp=totimesheettrackpage">Time Sheet Track</a>
										</li>
										<li>
									 		<a href="loadVacationAdminPage">Vacation Manage</a>
										</li>
										<li>
											 <a href="loadAbsenceOvertimeTrack">AbsenceOvertimeTrack</a>
										</li>
									</ul>
								</li>
								<%
							}
						}
					%>
						
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Normal<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="MyEmpInfoPage.jsp">My HR Info</a>
								</li>
								<li>
									 <a href="toMyPayrollPage">My Payroll</a>
								</li>
								<li>
									 <a href="loadMyVacationInfoPage">My Vacation</a>
								</li>
								<li>
									 <a href="myEmpHistory">My Info History</a>
								</li>
								<li>
									 <a href="loadMyAbsenceOvertimeTrack">Absence & Overtime</a>
								</li>
								<li>
									 <a href="absenceRequestAction_loadRequestPage">Request</a>
								</li>
								<li class="divider">
								</li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<a class="navbar-brand" >Welcome <s:property value="#session.login.emp.nameEnglish"/> </a>
						<a href="logoffAction" class="navbar-brand"><strong><span class="glyphicon glyphicon-off"></span></strong></a>
						<%-- <li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span><strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Setting</a>
								</li>
								<li>
									<a href="logoffAction"><strong><span class="glyphicon glyphicon-off"></span>&emsp;LOG OFF</strong></a>
								</li>
							</ul>
						</li> --%>
					</ul>
				</div>
			</nav>
</body>
</html>