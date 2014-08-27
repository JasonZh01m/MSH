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
						<form action="getMyAbsenceOvertimeInfoByTime" method="post">
						<input type="hidden" name="operationFlag_tstp" value="tstp_filterOperate">

							<div class="col-md-3 column">
								<div class="input-group input-group-sm date form_date"
									data-date="" data-date-format="yyyy-mm-dd"
									data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">Start Date:</span> <input id=""
										class="form-control red-tooltip" name="myaotentity.startDate"
										data-date-format="yyyy-mm-dd" type="text"
										value="<s:property value='#session.myaotentity.startDate' default=''/>"
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
										name="myaotentity.endDate" data-date-format="yyyy-mm-dd" type="text"
										value="<s:property value='#session.myaotentity.endDate' default=''/>"
										placeholder="End Date"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span> </span>
								</div>
							</div>
							
							<div class="selectpicker_aot_class"
								style="float: left; margin-right: 20px; margin-left: 10px;">
								<label>State:</label> <select id=""
									name="myaotentity.state" class="selectpicker"
									data-live-search="true">
									<s:iterator var="StateItor" value="#session.myaotentity.states">
								   		<option
								   		<s:if test="#session.myaotentity.state.equals(#StateItor)">selected="selected"</s:if>
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
								<s:iterator var="myabsenceInfoItor" value="#session.myabsenceInfos"
									status="myabsenceInfoStat">
									<tr style="height: 35px;" >
										<td>
											<s:property value="#myabsenceInfoStat.index + 1"/>
										</td>
										<td>
											<s:property value="#myabsenceInfoItor.empLoginId"/>
										</td>
										<td 
										<s:if test='#myabsenceInfoItor.stateName.equals(\"Cancelled\")'>class="danger"</s:if>
										<s:if test='#myabsenceInfoItor.stateName.equals(\"Rejected\")'>class="danger"</s:if>
										<s:if test='#myabsenceInfoItor.stateName.equals(\"Disapproval\")'>class="danger"</s:if>
										<s:if test='#myabsenceInfoItor.stateName.equals(\"InProg\")'>class="warning"</s:if>
										<s:if test='#myabsenceInfoItor.stateName.equals(\"Done\")'>class="success"</s:if>
										 >
											<s:property value="#myabsenceInfoItor.stateName"/>
										</td>
										<td>
											<s:property value="#myabsenceInfoItor.absenceApproverLineManager"/>
										</td>
										<td>
											<s:property value="#myabsenceInfoItor.absenceApproverPm"/>
										</td>
										<td>
											<s:date name="#myabsenceInfoItor.absenceStartTime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:date name="#myabsenceInfoItor.absenceEndTime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:property value="#myabsenceInfoItor.absenceHours"/>
										</td>
										<td>
											<s:property value="#myabsenceInfoItor.timeSheetOrderId"/>
										</td>
										<td>
											<s:property value="#myabsenceInfoItor.vacationTypeName"/>
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
							<s:iterator var="myovertimeInfoItor" value="#session.myovertimeInfos"
									status="myovertimeInfoStat">
									<tr style="height: 35px;">
										<td>
											<s:property value="#myovertimeInfoStat.index + 1"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.emploginid"/>
										</td>
										<td
											<s:if test='#myovertimeInfoItor.stateName.equals(\"Cancelled\")'>class="danger"</s:if>
											<s:if test='#myovertimeInfoItor.stateName.equals(\"Rejected\")'>class="danger"</s:if>
											<s:if test='#myovertimeInfoItor.stateName.equals(\"Disapproval\")'>class="danger"</s:if>
											<s:if test='#myovertimeInfoItor.stateName.equals(\"InProg\")'>class="warning"</s:if>
											<s:if test='#myovertimeInfoItor.stateName.equals(\"Done\")'>class="success"</s:if>
										>
											<s:property value="#myovertimeInfoItor.stateName"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.gm"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.pm"/>
										</td>
										<td>
											<s:date name="#myovertimeInfoItor.starttime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:date name="#myovertimeInfoItor.endtime" format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.hours"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.projectcode"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.projectname"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.compensatoryHours" default="0"/>
										</td>
										<td>
											<s:property value="#myovertimeInfoItor.paidRate"/>
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
				
				<p></p></br></br>
			</div>
		</div>
	</div>

</body>
</html>