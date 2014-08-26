<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Time Sheet Track</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/select2.css" />
<link href="css/style2.css" rel="stylesheet" />
<style type="text/css">
	table td {
		text-align: center;
		word-break: keep-all;
		white-space:nowrap;
	}
	table th {
		text-align: center;
		word-break: keep-all;
		white-space:nowrap;
	}

</style>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/select2.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript">
	$(function() {
		$(".form_date").datetimepicker({
			language : 'en',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});

	});
</script>
</head>
<%
  	if(session.getAttribute("login") == null)  
  		request.getRequestDispatcher("login.jsp");
		/* response.sendRedirect("login.jsp");*/	
  %>
<body>

<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>
						Time Sheet Track Page <small>Time sheet track</small>
					</h1>
				</div>

				<div class="row clearfix">
					<div class="col-md-12 column" style="margin-bottom: 40px;">
						<form action="timeSheetTrackAction" method="post">
						<input type="hidden" name="operationFlag_tstp" value="tstp_filterOperate">
							<div class="col-md-3 column">
								<div class="input-group input-group-sm date form_date"
									data-date="" data-date-format="yyyy-mm-dd"
									data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">Start Date:</span> <input id=""
										class="form-control red-tooltip" name="tstp_startDate"
										data-date-format="yyyy-mm-dd" type="text"
										value="<s:property value="#session.tstp_startDate" default=""/>"
										placeholder="Start Date"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span> </span>
								</div>
							</div>
							<div class="col-md-3 column">
								<div class="input-group input-group-sm date form_date"
									data-date="" data-date-format="yyyy-mm-dd"
									data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">End Date:</span> <input
										id="tstp_endDate" class="form-control red-tooltip"
										name="tstp_endDate" data-date-format="yyyy-mm-dd" type="text"
										value="<s:property value="#session.tstp_endDate" default=""/>"
										placeholder="End Date"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span> </span>
								</div>
							</div>

							<div class="selectpicker_class"
								style="float: left; margin-right: 30px; margin-left: 15px;">
								<label>Employee:</label> <select id="tstp_empLoginId"
									name="tstp_empLoginId" class="selectpicker"
									data-live-search="true">
									<s:iterator var="lmItor" value="#session.login.allLoginIds">
								   		<option <s:if test="#session.tstp_empLoginId.equals(#lmItor)">selected="selected"</s:if>><s:property 
								   		value="#lmItor"/></option>
								   	</s:iterator>
								</select>
							</div>
							<button id="tstp_submit" type="submit" style="height: 30px; padding: 4px 12px;"
								class="btn btn btn-primary">
								Search&nbsp;<span class="glyphicon glyphicon-search"></span>
							</button>
						</form>
					</div>
				</div>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Time Sheet Track</h3>
					</div>
					<div class="panel-body" style="padding: 10px; max-height: 800px; overflow: scroll;">
						<table class="table table-hover table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>LoginName</th>
									<th>Date</th>
									<th>Start</th>
									<th>Stop</th>
									<th>DiffTime</th>
									<th>OrderID</th>
									<th>Project_Name</th>
									<th>PM_Name</th>
									<th>Language</th>
									<th>Type</th>
									<th>Activity_Group</th>
									<th>Invoicing_Indicator</th>
									<th>Role</th>
									<th>Position</th>
									<th>Tool</th>
									<th>Task</th>
									<th>Custom</th>
									<th style="width: 400px;">Note</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator var="tstp_ts_Itor" value="#session.tstp_tsList"
									status="tstp_ts_stat">
									<tr style="height: 35px;">
										<td><s:property value="#tstp_ts_stat.index + 1" />
										</td>
										<td><s:property value="#tstp_ts_Itor.loginName" /></td>
										<td><s:property value="#tstp_ts_Itor.date" /></td>
										<td><s:property value="#tstp_ts_Itor.start" /></td>
										<td><s:property value="#tstp_ts_Itor.stop" /></td>
										<td><s:property value="#tstp_ts_Itor.diffTime" /></td>
										<td><s:property value="#tstp_ts_Itor.orderId" /></td>
										<td><s:property value="#tstp_ts_Itor.projectName" /></td>
										<td><s:property value="#tstp_ts_Itor.pmName" /></td>
										<td><s:property value="#tstp_ts_Itor.language" /></td>
										<td><s:property value="#tstp_ts_Itor.type" /></td>
										<td><s:property value="#tstp_ts_Itor.activityGroup" /></td>
										<td><s:property value="#tstp_ts_Itor.invoicingIndicator" /></td>
										<td><s:property value="#tstp_ts_Itor.role" /></td>
										<td><s:property value="#tstp_ts_Itor.position" /></td>
										<td><s:property value="#tstp_ts_Itor.tool" /></td>
										<td><s:property value="#tstp_ts_Itor.task" /></td>
										<td><s:property value="#tstp_ts_Itor.custom" /></td>
										<td><s:property value="#tstp_ts_Itor.note" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="text-align: right;">
						<a class="btn btn-sm btn-primary" href="<%=path%>/exportExcelAction_TimeSheetTrack!export.action">Export as Excel</a>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>