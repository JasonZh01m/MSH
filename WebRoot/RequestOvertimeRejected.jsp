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
				  <h1>ReApplication<small> For Overtime Request</small></h1>
				</div>
				
				<div class="tab-pane active" id="panel-overtime">
							<!-- Page title -->
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title page-title">
										<span class="glyphicon glyphicon-time"></span>Overtime Request ReApply
									</h3>
								</div>
							</div>
							
							<form id="request_overtime_reapply_form" action="overtimeRequestRejectReapply" method="post">
								<!-- Overtime Request Info -->
								<div class="panel panel-default request_panel">
								  <div class="panel-heading">
								    <h3 class="panel-title">Overtime Request Info</h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table class="table table-bordered table-without-firstrow-border">
											<tbody>
												<tr>
													<td>
														Project Manager:
													</td>
													<td class="empselect_request" style="padding: 3px; width: 200px;">
														<select id="request_overtime_pm" name="overtimeReApplyEntity.pm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option <s:if test="#session.rejectovertimerecord.pm.equals(#lmItor)">selected="selected"</s:if> ><s:property value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
													<td>
														Function/Group Manager:
													</td>
													<td class="empselect_request" style="padding: 3px; width: 200px;">
														<select id="request_overtime_gm" name="overtimeReApplyEntity.gm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option <s:if test="#session.rejectovertimerecord.gm.equals(#lmItor)">selected="selected"</s:if> ><s:property	value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
												</tr>
												<tr>
													<td>
														Project Code:
													</td>
													<td style="padding: 3px 3px;">
														<input type="text" name="overtimeReApplyEntity.pcode" class="form-control input-sm" value="<s:property value='#session.rejectovertimerecord.projectcode'></s:property>">
													</td>
													<td>
														Project Name:
													</td>
													<td style="padding: 3px 3px;">
														<input type="text" name="overtimeReApplyEntity.pname" class="form-control input-sm" value="<s:property value='#session.rejectovertimerecord.projectname'></s:property>" >
													</td>
												</tr>
												<tr>
													<td>
														Note from PM
													</td>
													<td colspan="3">
														<s:property value="#session.rejectovertimerecord.pmnote"/>
													</td>
												</tr>
												<tr>
													<td>
														Note from GM
													</td>
													<td colspan="3">
														<s:property value="#session.rejectovertimerecord.gmnote"/>
													</td>
												</tr>
												<tr style="margin: 0px;">
													<td colspan="4">
													</td>
												</tr>
											</tbody>
										</table>
								  	</div>
								</div>
								<!-- Overtime Request Info End -->
								<p></p>
								<!-- Overtime Request Info Items -->
								<div class="panel panel-default request_panel">
								  <div class="panel-heading">
								    <h3 class="panel-title">Absence Info &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total: <span id="total_absence_hours">xx</span> hrs.
								    	<a style="cursor: pointer;" id="addovertimerequest_reject" class="tooltips" data-toggle="tooltip" data-placement="top" title="Add a New"><span class="glyphicon glyphicon-plus pull-right"></span></a>
								    </h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table id="request_overtime_table" class="table table-bordered">
								   			<thead>
								   				<th>
								   					EMPLOYEE :
								   				</th>
								   				<th style="width: 200px;">
								   					START :
								   				</th>
								   				<th style="width: 200px;">
								   					END :
								   				</th>
								   				<th>
								   					TOTAL :
								   				</th>
								   				<th style="width:45px;">
								   				</th>
								   			</thead>
											<tbody id="overtimerequesttbody_reject" class="table-without-firstrow-border">
												<td style="display: none">
													<select id="testinnerhtml" name="" class="selectpicker testinnerhtml" data-live-search="true">
													    <s:iterator var="lmItor" value="#session.login.allLoginIds">
													   		<option	value="<s:property	value='#lmItor'/>"><s:property	value="#lmItor"/></option>
													   	</s:iterator>
													 </select>
												</td>
												<s:iterator var="overtimeItem" value="#session.rejectovertimerecord.overtimerequestitems" status="overtimeItemSta">
													<tr>
														<td class="empselect_request" style="padding:3px; width: 200px;">
															<select name="" class="selectpicker overtimerequestemp" data-live-search="true">
															    <s:iterator var="lmItor" value="#session.login.allLoginIds">
															   		<option
															   		<s:if test="#overtimeItem.emploginid.equals(#lmItor)">selected="selected"</s:if>
															   		value="<s:property	value='#lmItor'/>"><s:property	value="#lmItor"/></option>
															   	</s:iterator>
															 </select>
														</td>
														<td style="padding: 3px;">
													        <input type="text" value="<s:date name='#overtimeItem.starttime' format='yyyy-MM-ss HH:mm:ss'/>" readonly class="form-control form_datetime_request input-sm startTime_request">
														</td>
														<td style="padding: 3px;">
															<input type="text" value="<s:date name='#overtimeItem.endtime' format='yyyy-MM-ss HH:mm:ss'/>" readonly class="form-control form_datetime_request input-sm endTime_request">
														</td>
														<td class="totaltime_request">
														 	<s:property value="#overtimeItem.hours"/>
														</td>
														<td>
															<s:if test="#overtimeItemSta.count>1"><a style='cursor: pointer; padding-left:7px;' class='deleteovertimerequest'><span class='glyphicon glyphicon-minus'></span></a></s:if>
														</td>
													</tr>
												</s:iterator>
											</tbody>
											<tbody>
											<tr>
												<td>
													<div style="margin: auto; padding: auto; text-align: center;"><strong>COMMENTS :</strong></div>
												</td>
												<td colspan="8">
													<textarea id="request_absence_reason" name="overtimeReApplyEntity.comments" type="text" class="form-control" style="resize: none;" id="" placeholder="null"><s:property value="#session.rejectovertimerecord.comments"/></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								  	</div>
								  	<div class="panel-footer" style="text-align:center;">
								  		<input id="" type="hidden" name="overtimeReApplyEntity.id" value="<s:property value='#session.rejectovertimerecord.id'/>">
								  		<input id="request_overtime_loginIds_reject" name="overtimeReApplyEntity.emps" type="hidden" value="">
								  		<input id="request_overtime_startTimes_reject" name="overtimeReApplyEntity.startTimes" type="hidden" value="">
								  		<input id="request_overtime_endTimes_reject" name="overtimeReApplyEntity.endTimes" type="hidden" value="">
								  		<input id="overtimerequest_submit_reject" type="submit" class="btn btn-primary" value="ReApply">
								  		<a href="cancelOvertimeRecord?overtimeReApplyEntity.id=<s:property value='#session.rejectovertimerecord.id'/>" type="button" class="btn btn-danger">Cancel Request</a>
								  	</div>
								</div>
								<!-- Overtime Request Info Items End -->
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
<script type="text/javascript" src="js/requestOvertimeReject.js"></script>
</html>