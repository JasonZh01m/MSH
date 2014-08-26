<%@page import="com.moravia.hs.base.entity.other.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="css/dataTable/dataTables.bootstrap.css" rel="stylesheet">
<link href="css/style_new.css" rel="stylesheet" />

</head>
<%
  	if(session.getAttribute("login") == null) {  
  		response.sendRedirect("login.jsp");
  	} 
  %>
<body id="main-body">
<%-- <jsp:include page="nav.jsp"></jsp:include> --%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-1 column">
		
		</div>
		<div class="col-md-10 column">
			<div class="row clearfix">
				<div class="page-header">
				  <h1>ReApplication<small> For Absence Request</small></h1>
				</div>
				
				<!-- Panel-Absence -->	
						<div class="tab-pane" id="panel-absence">
							<!-- Page title -->
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title page-title">
										<span class="glyphicon glyphicon-tasks"></span>ReApplication
									</h3>
								</div>
							</div>
							<form id="" action="absenceRequestRejectReapply" method="post">
								<!-- Personal Info -->
								<div class="panel panel-default request_panel">
								  <div class="panel-heading">
								    <h3 class="panel-title">Personal Info</h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table class="table table-bordered table-without-firstrow-border">
											<tbody>
												<tr>
													<td>
														Employee
													</td>
													<td>
														<input name="request_absence_empLoginId" class="noborderinupt" readonly="readonly" value="<s:property value='#session.login.emp.empLoginId'/>" />
													</td>
													<td>
														Department
													</td>
													<td>
														MD
													</td>
												</tr>
											</tbody>
											<tbody>
												<tr>
													<td>
														Line Manager
													</td>
													
													<td class="empselect_request" style="padding: 2px; width: 200px;">
													 <!-- id="request_absence_lineManager"  -->
														<select name="absenceRequestEntity.lm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option <s:if test="#session.rejectabsencerecord.absenceApproverLineManager.equals(#lmItor)">selected="selected"</s:if>><s:property 
														   		value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
													<td>
														PM
													</td>
													<td class="empselect_request" style="padding: 2px; width: 200px;">
													<!-- id="request_absence_pm"  -->
														<select name="absenceRequestEntity.pm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option <s:if test="#session.rejectabsencerecord.absenceApproverPm.equals(#lmItor)">selected="selected"</s:if> ><s:property	value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
												</tr>
												<tr>
													<td>Note for Line Manager:</td>
													<td colspan="3">
														<s:property value="#session.rejectabsencerecord.absenceNoteLineManager"/>
													</td>
												</tr>
											</tbody>
										</table>
								  	</div>
								</div>
								<!-- Personal Info End -->
								<!-- Vacation Used -->
								<div class="panel panel-default request_panel">
								  <div class="panel-heading">
								    <h3 class="panel-title">Vacation Used</h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table class="table table-bordered table-without-firstrow-border">
								   			<thead>
												<tr>
													<Td>
														剩余年假
													</td>
													<td>
														已休年假
													</td>
													<td>
														剩余调休假
													</td>
													<td>
														已用调休假
													</td>
													<td>
														事假
													</td>
													<td>
														病假
													</td>
													<td>
														其他
													</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td id="request_annualLeft_reject">
														<s:property value="#session.login.emp.annualLeaveLeft"/>
													</td>
													<td>
														<s:property value="#session.login.vacationUsedInfo.annualLeave" default="0.0"/>
													</td>
													<td id="request_compensatoryLeft_reject">
														<s:property value="#session.login.compensatoryLeft" default="0.0"/>
													</td>
													<td>
														<s:property value="#session.login.vacationUsedInfo.compensatory" default="0.0"/>
													</td>
													<td>
														<s:property value="#session.login.vacationUsedInfo.personalLeave" default="0.0"/>
													</td>
													<td>
														<s:property value="#session.login.vacationUsedInfo.sickMateryBreaveLeave" default="0.0"/>
													</td>
													<td>
														<s:property value="#session.login.vacationUsedInfo.longSickMarriageLeave" default="0.0"/>
													</td>
												</tr>
											</tbody>
										</table>
								  	</div>
								</div>
								<!-- Vacation Used End -->
								<!-- Absence Info -->
								<div class="panel panel-default request_panel">
								  <div class="panel-heading">
								    <h3 class="panel-title">Absence Info &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total: <span id="total_absence_hours">xx</span> hrs.
								    	<a style="cursor: pointer;" id="addleaverequest_reject" class="tooltips" data-toggle="tooltip" data-placement="top" title="Add a New"><span class="glyphicon glyphicon-plus pull-right"></span></a>
								    </h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table class="table table-bordered">
											<tbody id="leaverequesttbody_reject" class="table-without-firstrow-border">
											<s:iterator var="absenceItem" value="#session.rejectabsencerecord.absencerequestitems" status="absenceItemSta">
													<tr>
														<td>
															Leave Type:
														</td>
														<td class="empselect_request" style="padding: 2px; width: 115px;">
														 <select id="" class="leavetype_request selectpicker" data-live-search="true">
															<option <s:if test="#absenceItem.vacationtype.vacationTypeId==1">selected="selected"</s:if> value="1">(70) - 事假</option>
															<option <s:if test="#absenceItem.vacationtype.vacationTypeId==3">selected="selected"</s:if> value="3">(57) - 长病假/婚假/丧假</option>
															<option <s:if test="#absenceItem.vacationtype.vacationTypeId==4">selected="selected"</s:if> value="4">(58) - 病/产/哺乳/男方护理假</option>
															<option <s:if test="#absenceItem.vacationtype.vacationTypeId==5">selected="selected"</s:if> value="5">(61) - 调休</option>
															<option <s:if test="#absenceItem.vacationtype.vacationTypeId==6">selected="selected"</s:if> value="6">(61) - 年假</option>
														 </select>
														</td>
														<td>
															Start Time:
														</td>
														<td style="padding: 3px;" >
													        <input size="16" type="text" value="<s:date name="#absenceItem.absenceStartTime" format="yyyy-MM-dd HH:mm:ss" ></s:date>" readonly class="form-control form_datetime_request input-sm startTime_request">
														</td>
														<td>
															End Time:
														</td>
														<td style="padding: 3px;" >
															<input size="16" type="text" value="<s:date name="#absenceItem.absenceEndTime" format="yyyy-MM-dd HH:mm:ss" ></s:date>" readonly class="form-control form_datetime_request input-sm endTime_request">
														</td>
														<td>
															Total:
														</td>
														<td class="totaltime_request">
															<s:property value="#absenceItem.absenceHours"/>
														</td>
														<td id="deleteleaverequesttd" style="width:45px;" >
															<s:if test="#absenceItemSta.count>1"><a style='cursor: pointer; padding-left:7px;' class='deleteleaverequest'><span class='glyphicon glyphicon-minus'></span></a></s:if>
														</td>
													</tr>
												</s:iterator>
											</tbody>
											<tbody>
											<tr>
												<td>
													请假事由
												</td>
												<td colspan="8">
													<textarea id="" name="absenceRequestEntity.reason" type="text" class="form-control" style="resize: none;" id="" placeholder="null"><s:property value="#session.rejectabsencerecord.absenceReason"/></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								  	</div>
								  	<div class="panel-footer" style="text-align:center;">
								  		<input name="absenceRequestEntity.id" value="<s:property value='#session.rejectabsencerecord.absenceRecordId'/>" type="hidden">
								  		<input id="request_absence_types_reject" name="absenceRequestEntity.types" type="hidden" value="">
								  		<input id="request_absence_startTimes_reject" name="absenceRequestEntity.starts" type="hidden" value="">
								  		<input id="request_absence_endTimes_reject" name="absenceRequestEntity.ends" type="hidden" value="">
								  		<input id="leaverequest_submit_reject" type="submit" class="btn btn-primary" value="ReApply">
								  		<a href="cancelAbsenceRecord?absenceRequestEntity.id=<s:property value='#session.rejectabsencerecord.absenceRecordId'/>" type="button" class="btn btn-danger">Cancel Request</a>
								  		<!-- <input id="" type="button" class="btn btn-default" value="Cancel"> -->
								  	</div>
								</div>
								<!-- Absence Info End -->
							</form>
						</div>
				
			</div>	
		</div>
		
		<div class="col-md-1 column">
		</div>
		
	</div>
</div>

<s:debug/>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/requestAbsenceReject.js"></script>
</html>