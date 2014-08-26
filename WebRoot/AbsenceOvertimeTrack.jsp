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
<title>Absence & Overtime Track</title>
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
						Absence & Overtime Info <small> Track page</small>
					</h1>
				</div>

				<div class="row clearfix">
					<div class="col-md-12 column" style="margin-bottom: 40px;">
						<form action="getAbsenceOvertimeInfoByTime" method="post">
						<input type="hidden" name="operationFlag_tstp" value="tstp_filterOperate">

							<div class="col-md-3 column">
								<div class="input-group input-group-sm date form_date"
									data-date="" data-date-format="yyyy-mm-dd"
									data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">Start Date:</span> <input id=""
										class="form-control red-tooltip" name="aotentity.startDate"
										data-date-format="yyyy-mm-dd" type="text"
										value="<s:property value='#session.aotentity.startDate' default=''/>"
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
										name="aotentity.endDate" data-date-format="yyyy-mm-dd" type="text"
										value="<s:property value='#session.aotentity.endDate' default=''/>"
										placeholder="End Date"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span> </span>
								</div>
							</div>

							<div class="selectpicker_aot_class"
								style="float: left; margin-right: 10px; margin-left: 15px;">
								<label>Employee:</label> <select id=""
									name="aotentity.loginId" class="selectpicker"
									data-live-search="true">
									<s:iterator var="lmItor" value="#session.login.allLoginIds">
								   		<option <s:if test="#session.aotentity.loginId.equals(#lmItor)">selected="selected"</s:if>><s:property 
								   		value="#lmItor"/></option>
								   	</s:iterator>
								</select>
							</div>
							
							<div class="selectpicker_aot_class"
								style="float: left; margin-right: 20px; margin-left: 10px;">
								<label>State:</label> <select id=""
									name="aotentity.state" class="selectpicker"
									data-live-search="true">
									<s:iterator var="StateItor" value="#session.aotentity.states">
								   		<option
								   		<s:if test="#session.aotentity.state.equals(#StateItor)">selected="selected"</s:if>
								   		value="<s:property value='#StateItor'/>" ><s:property 
								   		value="#StateItor"/></option>
								   	</s:iterator>
								</select>
							</div>
							
							
							<button id="tstp_submit" type="submit" style="height: 30px; padding: 4px 12px;"
								class="btn btn-primary">
								Search&nbsp;<span class="glyphicon glyphicon-search"></span>
							</button>
						</form>
					</div>
				</div>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Absence Info</h3>
					</div>
					<div class="panel-body" style="padding: 10px; max-height: 800px; overflow: scroll;">
						<table class="table table-hover table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>LoginName</th>
									<th>State</th>
									<th>LineManager</th>
									<th>PM</th>
									<th>Start</th>
									<th>End</th>
									<th>Hours</th>
									<th>OrderId</th>
									<th>Type</th>
									<th>Others</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator var="absenceInfoItor" value="#session.absenceInfos"
									status="absenceInfoStat">
									<tr style="height: 35px;" >
										<td>
											<s:property value="#absenceInfoStat.index + 1"/>
										</td>
										<td>
											<s:property value="#absenceInfoItor.empLoginId"/>
										</td>
										<td 
										<s:if test='#absenceInfoItor.stateName.equals(\"Cancelled\")'>class="danger"</s:if>
										<s:if test='#absenceInfoItor.stateName.equals(\"Rejected\")'>class="danger"</s:if>
										<s:if test='#absenceInfoItor.stateName.equals(\"Disapproval\")'>class="danger"</s:if>
										<s:if test='#absenceInfoItor.stateName.equals(\"InProg\")'>class="warning"</s:if>
										<s:if test='#absenceInfoItor.stateName.equals(\"Done\")'>class="success"</s:if>
										 >
											<s:property value="#absenceInfoItor.stateName"/>
										</td>
										<td>
											<s:property value="#absenceInfoItor.absenceApproverLineManager"/>
										</td>
										<td>
											<s:property value="#absenceInfoItor.absenceApproverPm"/>
										</td>
										<td>
											<s:date name="#absenceInfoItor.absenceStartTime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:date name="#absenceInfoItor.absenceEndTime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:property value="#absenceInfoItor.absenceHours"/>
										</td>
										<td>
											<s:property value="#absenceInfoItor.timeSheetOrderId"/>
										</td>
										<td>
											<s:property value="#absenceInfoItor.vacationTypeName"/>
										</td>
										<td>
											Others
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="text-align: right;">
						
					</div>
				</div>
				
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Overtime Info</h3>
					</div>
					<div class="panel-body" style="padding: 10px; max-height: 800px; overflow: scroll;">
						<table class="table table-hover table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>LoginName</th>
									<th>State</th>
									<th>GM</th>
									<th>PM</th>
									<th>Start</th>
									<th>End</th>
									<th>Hours</th>
									<th>ProjectCode</th>
									<th>ProjectName</th>
									<th>CompensatoryHours</th>
									<th>PaidRate</th>
									<th>Others</th>
								</tr>
							</thead>
							<tbody>
							<s:iterator var="overtimeInfoItor" value="#session.overtimeInfos"
									status="overtimeInfoStat">
									<tr style="height: 35px;">
										<td>
											<s:property value="#overtimeInfoStat.index + 1"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.emploginid"/>
										</td>
										<td
											<s:if test='#overtimeInfoItor.stateName.equals(\"Cancelled\")'>class="danger"</s:if>
											<s:if test='#overtimeInfoItor.stateName.equals(\"Rejected\")'>class="danger"</s:if>
											<s:if test='#overtimeInfoItor.stateName.equals(\"Disapproval\")'>class="danger"</s:if>
											<s:if test='#overtimeInfoItor.stateName.equals(\"InProg\")'>class="warning"</s:if>
											<s:if test='#overtimeInfoItor.stateName.equals(\"Done\")'>class="success"</s:if>
										>
											<s:property value="#overtimeInfoItor.stateName"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.gm"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.pm"/>
										</td>
										<td>
											<s:date name="#overtimeInfoItor.starttime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:date name="#overtimeInfoItor.endtime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.hours"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.projectcode"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.projectname"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.compensatoryHours" default="0"/>
										</td>
										<td>
											<s:property value="#overtimeInfoItor.paidRate"/>
										</td>
										<td>
											Other
										</td>
										
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="text-align: right;">
						
					</div>
				</div>

				<a disabled="disabled" class="btn btn-sm btn-primary pull-right" href="<%=path%>/exportExcelAction_TimeSheetTrack!export.action">Export as Excel</a>
				<p></p></br></br>
			</div>
		</div>
	</div>

</body>
</html>