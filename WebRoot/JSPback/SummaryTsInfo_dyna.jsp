<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/dynatable/jquery.dynatable.css" rel="stylesheet"/>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"/> -->
<link href="css/dataTable/bootstrap2.3.2.min.css" rel="stylesheet"/>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/dynatable/jquery.dynatable.js"></script>
<!-- <script type="text/javascript" src="js/bootstrap.min.js"></script> -->
<script type="text/javascript">
	$(function () {
		$("#example_tab").dynatable();
	});

</script>

</head>
<body>
	<div class="container">
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="page-header">
					<h1>Example page header<small>sub title</small></h1>
				
				</div>
			
				<div class="span12">
					<!-- 
	<table cellpadding="0" cellspacing="0" border="0"
			class="table table-striped table-hover dataTable" id="example_tab"
			aria-describedby="example_info" style="overflow: auto;"> -->
			<table cellpadding="0" cellspacing="0" border="0"  class="table table-hover" id="example_tab">
			<thead>
				<tr role="row" class="panel-primary">
						<th aria-sort="ascending" >LoginName</th>
						<th>TimeSheet Hours</th>
						<th>Absence Hours</th>
						<th>Paid Hours</th>
						<th>Not Paid Hours</th>
						<th>Overtime</th>
				</tr>
			</thead>

			<!-- <tbody role="alert" aria-live="polite" aria-relevant="all"> -->
				<tbody>
					
					<s:iterator var="sti_tsItor" value="#session.sti_stiList">
						<tr >
						<!-- target="_blank" -->
							<td><a  href="salaryInfoAction?empLoginId=<s:property value="#sti_tsItor.loginId" />"><s:property value="#sti_tsItor.loginId" /></a></td>
							<td><s:property value="#sti_tsItor.tsHrs" default="0"/></td>
							<td><s:property value="#sti_tsItor.absenceHrs" default="0"/></td>
							<td><s:property value="#sti_tsItor.paidHrs" default="0"/></td>
							<td><s:property value="#sti_tsItor.notPaidHrs" default="0"/></td>
							<td <s:if test="#sti_tsItor.overTime < 0">style="background-color: #eed3d7;"</s:if>><s:property value="#sti_tsItor.overTime" default="0"/></td>
						</tr>
					</s:iterator>
					
					</tbody>
		</table>
				</div>
			</div>
		</div>
	</div>
</div>
	
		
		
	
	
			
				
		
	
	
	
</body>
</html>