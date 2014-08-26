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
<script type="text/javascript">
function loadspin() {
	 var opts = {
		 lines: 12, // The number of lines to draw
		  length: 20, // The length of each line
		  width: 6, // The line thickness
		  radius: 20, // The radius of the inner circle
		  color: 'silver', // #rgb or #rrggbb or array of colors
		  className: 'spinner',
		  trail: 40 // Afterglow percentage	
	};
	var target = document.getElementById('spinnerdiv');
	var spinner = new Spinner(opts).spin(target);
}
</script>
</head>
<%
  	if(session.getAttribute("login") == null) {  
  		response.sendRedirect("login.jsp");
  	}
%>

<body id="main-body" onload="javascript:loadspin()">

<div id="spinnerroot">
	<div id="spinnerdiv"></div>
</div>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="page-header">
				  <h1>Example page header <small>Subtext for header</small></h1>
				</div>
				<div class="col-md-3 column">
					<div class="tabbable" id="tabs-395177">
						<ul class="nav nav-pills nav-stacked">
							<li class="active">
								<a id="linkto_panel-affairs" href="#panel-affairs" data-toggle="tab">Affairs<span id="request_totalaffaris" class="badge"></span></a>
							</li>
							<li class="">
								<a id="linkto_panel-absence" href="#panel-absence" data-toggle="tab">Absence Request</a>
							</li>
							<li>
								<a href="#panel-overtime" data-toggle="tab">Overtime Request</a>
							</li>
							<li>
								<a href="#panel-history" data-toggle="tab">History</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-9 column">
					<div class="tab-content">
						<!-- Panel-Affairs -->
						<div class="tab-pane active" id="panel-affairs">
							<!-- Page title -->
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title page-title">
										<span class="glyphicon glyphicon-tasks"></span>Affairs
									</h3>
								</div>
							</div>
							<div class="tabbable" id="request_affairs_tab">
								<ul class="nav nav-tabs">
									<li class="active">
										<a href="#panel-absencerequest" data-toggle="tab">Absence Requests</a>
									</li>
									<li>
										<a href="#panel-overtimerequest" data-toggle="tab">Overtime Requests</a>
									</li>
								</ul>
								<div class="tab-content" style="padding-top: 20px; ">
									<!-- Panel AbsenceRequests -->
									<div class="tab-pane active" id="panel-absencerequest">
										<div class="panel panel-default">
										  <div class="panel-heading">
										    <h3 class="panel-title">Request Info</h3>
										  </div>
										  <div class="panel-body">
											<table id="request_info_table" class="table table-hover table-condensed">
												<thead>
													<tr>
														<th>ID</th>
														<th>Applicant</th>
														<th>LineManager</th>
														<th>PM</th>
														<th>Hours</th>
														<th>Status</th>
														<th>Date</th>
														<th>More</th>
													</tr>
												</thead>
												<tbody id="request_affair_requestinfo">
													
												</tbody>
											</table>
											<ul id="pagination-demo" class="pagination pagination-sm pull-right"></ul>
											<input id="pagination-demo_totalpage" type="hidden" value="<s:property value='#session.login.pageBean.totalPage'/>"/>
										  </div>
										 </div>
									</div><!--End Panel AbsenceRequests -->
									<!-- Panel overtimeRequest -->
									<div class="tab-pane" id="panel-overtimerequest">
										<div class="panel panel-default">
										  <div class="panel-heading">
										    <h3 class="panel-title">Overtime Request Info</h3>
										  </div>
										  <div class="panel-body">
											<table id="" class="table table-hover table-condensed">
												<thead>
													<tr>
														<th>ID</th>
														<th>Applicant</th>
														<th>PM</th>
														<th>GM</th>
														<th>Project:</th>
														<th>Code:</th>
														<th>Hours</th>
														<th>Status</th>
														<th>Date</th>
														<th>More</th>
													</tr>
												</thead>
												<tbody id="request_affair_overtime">
													
												</tbody>
											</table>
											<ul id="pagination_overtimeRequest" class="pagination pagination-sm pull-right"></ul>
											<input id="overtimeRequest_totalpage" type="hidden" value="<s:property value='#session.login.pageBeanOvertimeRequests.totalPage'/>"/>
										  </div>
										 </div>
									</div><!--End of Panel overtimeRequests -->
								</div>
							</div> <!-- End of  -->
							</div>
						<!-- Panel-Absence -->	
						<div class="tab-pane" id="panel-absence">
							<!-- Page title -->
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title page-title">
										<span class="glyphicon glyphicon-tasks"></span>Absence Request
									</h3>
								</div>
							</div>
							<form id="request_absence_form" action="absenceRequestAction_requestApply" method="post">
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
														<select id="request_absence_lineManager" name="request_absence_lineManager" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option <s:if test="#session.login.emp.emp.empLoginId.equals(#lmItor)">selected="selected"</s:if>><s:property 
														   		value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
													<td>
														PM
													</td>
													<td class="empselect_request" style="padding: 2px; width: 200px;">
														<select id="request_absence_pm" name="request_absence_pm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option><s:property	value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
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
														已用年假
													</td>
													<td>
														剩余调休假
													</td>
													<td>
														已用调休假
													</td>
													<td>
														已用 事假
													</td>
													<td>
														已用 病假
													</td>
													<td>
														已用 其他
													</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td id="request_annualLeft">
														<s:property value="#session.login.usableAnnualLeave"/>
													</td>
													<td>
														<s:property value="#session.login.vacationUsedInfo.annualLeave" default="0.0"/>
													</td>
													<td id="request_compensatoryLeft">
														<s:property value="#session.login.usableCompensatoryLeave" default="0.0"/>
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
								    	<a style="cursor: pointer;" id="addleaverequest" class="tooltips" data-toggle="tooltip" data-placement="top" title="Add a New"><span class="glyphicon glyphicon-plus pull-right"></span></a>
								    </h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table class="table table-bordered">
											<tbody id="leaverequesttbody" class="table-without-firstrow-border">
												<tr>
													<td>
														Leave Type:
													</td>
													<td class="empselect_request" style="padding: 2px; width: 115px;">
													 <select id="" class="leavetype_request selectpicker" data-live-search="true">
														<option value="1">(70) - 事假</option>
														<option value="3">(57) - 长病假/婚假/丧假</option>
														<option value="4">(58) - 病/产/哺乳/男方护理假</option>
														<option value="5">(61) - 调休</option>
														<option value="6">(61) - 年假</option>
													 </select>
													</td>
													<td>
														Start Time:
													</td>
													<td style="padding: 3px;" >
												        <input size="16" type="text" value="" readonly class="form-control form_datetime_request input-sm startTime_request">
													</td>
													<td>
														End Time:
													</td>
													<td style="padding: 3px;" >
														<input size="16" type="text" value="" readonly class="form-control form_datetime_request input-sm endTime_request">
													</td>
													<td>
														Total:
													</td>
													<td class="totaltime_request">
													</td>
													<td style="width:45px;">
													</td>
												</tr>
											</tbody>
											<tbody>
											<tr>
												<td>
													请假事由
												</td>
												<td colspan="8">
													<textarea id="request_absence_reason" name="request_absence_reason" type="text" class="form-control" style="resize: none;" id="" placeholder="null"></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								  	</div>
								  	<div class="panel-footer" style="text-align:center;">
								  		<input id="request_absence_types" name="request_absence_types" type="hidden" value="">
								  		<input id="request_absence_startTimes" name="request_absence_startTimes" type="hidden" value="">
								  		<input id="request_absence_endTimes" name="request_absence_endTimes" type="hidden" value="">
								  		<input id="leaverequest_submit" type="submit" class="btn btn-primary" value="Submit">
								  	</div>
								</div>
								<!-- Absence Info End -->
							</form>
						</div>

						<div class="tab-pane" id="panel-overtime">
							<!-- Page title -->
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title page-title">
										<span class="glyphicon glyphicon-time"></span>Overtime Request
									</h3>
								</div>
							</div>
							
							<form id="request_overtime_form" action="overtimeRequest_Apply" method="post">
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
														<select id="request_overtime_pm" name="overtimeRequestEntity.pm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option><s:property value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
													<td>
														Function/Group Manager:
													</td>
													<td class="empselect_request" style="padding: 3px; width: 200px;">
														<select id="request_overtime_gm" name="overtimeRequestEntity.gm" class="selectpicker" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option><s:property	value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
												</tr>
												<tr>
													<td>
														Project Code:
													</td>
													<td style="padding: 3px 3px;">
														<input type="text" name="overtimeRequestEntity.pcode" class="form-control input-sm">
													</td>
													<td>
														Project Name:
													</td>
													<td style="padding: 3px 3px;">
														<input type="text" name="overtimeRequestEntity.pname" class="form-control input-sm">
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
								    	<a style="cursor: pointer;" id="addovertimerequest" class="tooltips" data-toggle="tooltip" data-placement="top" title="Add a New"><span class="glyphicon glyphicon-plus pull-right"></span></a>
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
											<tbody id="overtimerequesttbody" class="table-without-firstrow-border">
												<tr>
													<td class="empselect_request" style="padding:3px; width: 200px;">
														<select id="testinnerhtml" name="" class="selectpicker overtimerequestemp" data-live-search="true">
														    <s:iterator var="lmItor" value="#session.login.allLoginIds">
														   		<option value="<s:property	value='#lmItor'/>"><s:property	value="#lmItor"/></option>
														   	</s:iterator>
														 </select>
													</td>
													<td style="padding: 3px;">
												        <input type="text" value="" readonly class="form-control form_datetime_request input-sm startTime_request">
													</td>
													<td style="padding: 3px;">
														<input type="text" value="" readonly class="form-control form_datetime_request input-sm endTime_request">
													</td>
													<td class="totaltime_request">
													 	
													</td>
													<td>
														
													</td>
												</tr>
												
											</tbody>
											<tbody>
											<tr>
												<td>
													<div style="margin: auto; padding: auto; text-align: center;"><strong>COMMENTS :</strong></div>
												</td>
												<td colspan="8">
													<textarea id="request_absence_reason" name="overtimeRequestEntity.comments" type="text" class="form-control" style="resize: none;" id="" placeholder="null"></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								  	</div>
								  	<div class="panel-footer" style="text-align:center;">
								  		<input id="request_overtime_loginIds" name="overtimeRequestEntity.emps" type="hidden" value="">
								  		<input id="request_overtime_startTimes" name="overtimeRequestEntity.startTimes" type="hidden" value="">
								  		<input id="request_overtime_endTimes" name="overtimeRequestEntity.endTimes" type="hidden" value="">
								  		<input id="overtimerequest_submit" type="submit" class="btn btn-primary" value="Submit">
								  	</div>
								</div>
								<!-- Overtime Request Info Items End -->
							</form>
						</div>
							
						<div class="tab-pane" id="panel-history">
						<!-- Page title -->
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title page-title">
									<span class="glyphicon glyphicon-tasks"></span>History
								</h3>
							</div>
						</div>
							<div class="row clearfix">
								<div class="col-md-12 column">
									<div class="tabbable" id="request_history_tab">
										<ul class="nav nav-tabs">
											<li class="active">
												<a href="#panel-absencehistory" data-toggle="tab">Absence History</a>
											</li>
											<li>
												<a href="#panel-overtimehistory" data-toggle="tab">Overtime History</a>
											</li>
										</ul>
										<div class="tab-content">
											<!-- Panel AbsenceHistory -->
											<div class="tab-pane active" id="panel-absencehistory">
												<div class="panel panel-default">
												  <div class="panel-body">
													<table id="" class="table table-hover table-condensed">
													<!-- request_info_table -->
														<thead>
															<tr>
																<th>ID</th>
																<th>Applicant</th>
																<th>LineManager</th>
																<th>PM</th>
																<th>Hours</th>
																<th>Status</th>
																<th>Date</th>
																<th>Details</th>
																<th>Log</th>
															</tr>
														</thead>
														<tbody id="request_history_absence">
															
														</tbody>
													</table>
													<ul id="pagination_absenceHistory" class="pagination pagination-sm pull-right"></ul>
													<input id="pagination_absenceHistory_totalpage" type="hidden" value="<s:property value='#session.login.absenceHistoryPageBean.totalPage'/>"/>
												  </div>
												 </div>
											</div><!--End Panel AbsenceHistory -->
											
											<!-- Panel overtimeHistory -->
											<div class="tab-pane" id="panel-overtimehistory" style="padding-top: 20px;">
												<div class="panel panel-default">
												  <div class="panel-body">
													<table id="" class="table table-hover table-condensed">
														<thead>
															<tr>
																<th>ID</th>
																<th>Applicant</th>
																<th>PM</th>
																<th>GM</th>
																<th>Project</th>
																<th>Hours</th>
																<th>Status</th>
																<th>Date</th>
																<th>Details</th>
																<th>Log</th>
															</tr>
														</thead>
														<tbody id="request_history_overtime">
															
														</tbody>
													</table>
													<ul id="pagination_overtimeHistory" class="pagination pagination-sm pull-right"></ul>
													<input id="overtimeHistory_totalpage" type="hidden" value="<s:property value='#session.login.overtimeHistoryPageBean.totalPage'/>"/>
												  </div>
												 </div>
											</div><!--End of Panel overtimeHistory -->
										</div>
									</div> <!-- End of request_history_tab -->
								</div>
							</div>
						</div>	<!--End of panel-history -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Operation Leave Request -->
<div class="modal fade" id="modal-container-requestInfo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 800px;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Request Info
				</h4>
			</div>
		<form id="requestaffairs_handle_form" action="requestAffarisHandle" method="post">
			<div class="modal-body">
				<div class="panel panel-default request_panel">
				  <!-- <div class="panel-heading">
				    <h3 class="panel-title">Request Info</h3>
				  </div> -->
				  <div class="panel-body">
			   		<table class="table" style="margin: 0px;">
						<tbody class="table-without-firstrow-border">
							<tr>
								<td>
									Employee
								</td>
								<td id="requestinfo_emplogid">
									
								</td>
								<td>
									Department
								</td>
								<td id="requestinfo_depart">
									MD
								</td>
							</tr>
							<tr>
								<td>
									Line Manager
								</td>
								
								<td id="requestinfo_linemanager" style="width: 200px;">
									
								</td>
								<td>
									PM
								</td>
								<td id="requestinfo_pm" style="width: 200px;">
									
								</td>
							</tr>
							<tr>
								<td>
									Leave Reason:
								</td>
								<td id="requestinfo_reason" colspan="8">
									
								</td>
							</tr>
						</tbody>
					</table>
				  	</div>
				</div>
				<div class="panel panel-default request_panel">
				  <div class="panel-heading">
				    <h3 class="panel-title">Details
				    	<a style="cursor: pointer;" id="addleaverequest" class="tooltips" data-toggle="tooltip" data-placement="top" title="Add a New"></a>
				    </h3>
				  </div>
					<div class="panel-body" style="max-height: 300px; overflow: auto;">
				   		<table class="table table-hover table-condensed">
							<tbody id="leaverequestinfo" class="table-without-firstrow-border">
								<!-- Absence record items info -->
							</tbody>
							<tbody>
								<tr>
									<td>Note:</td>
									<td colspan="5">
										<textarea id="request_info_lineManagerNote" name="request_info_lineManagerNote" type="text" class="form-control" style="resize: none;" id="" placeholder="null"></textarea>
									</td>
								</tr>
							</tbody>
						</table>
				  	</div>
				</div>
			</div>
			<div class="modal-footer">
					 <input id="requestinfo_absencerecordid" name="requestaffairs_absencerecordid" type="hidden" value=""></input>
					 <input id="requestaffairs_handleFlag" name="requestaffairs_handleFlag" type="hidden" value=""></input>
					 <button id="request_affairs_handle_agree"  type="button" class="btn btn-primary btn-sm">Agree</button>
					 <button id="request_affairs_handle_reject" type="button" class="btn btn-primary btn-sm">Reject</button>
					 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
			</div>
		 </form> 
		<!-- </form> -->
		</div>
	</div>
</div>


<!-- Affairs Overtime Request -->

<!-- History Absence Details -->
<div class="modal fade" id="modal-container_absenceHistory_details" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 700px;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Details
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel panel-default request_panel">
					<div class="panel-body" style="max-height: 300px; overflow: auto;">
				   		<table class="table table-hover table-condensed">
							<tbody id="absenceHistoryDetails" class="table-without-firstrow-border">
								<!-- Absence record items info -->
							</tbody>
						</table>
				  	</div>
				</div>
			</div>
			<div class="modal-footer" style="text-align: center;">
				 <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
			</div>
		</div>
	</div>
</div>

<!-- History Absence Track -->
<div class="modal fade" id="modal-container_absenceHistory_track" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 700px;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Details
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel panel-default request_panel">
					<div class="panel-body" style="max-height: 300px; overflow: auto;">
				   		<table class="table table-hover table-condensed">
							<tbody id="absenceHistoryTrack" class="table-without-firstrow-border">
								<!-- Absence record items info -->
							</tbody>
						</table>
				  	</div>
				</div>
			</div>
			<div class="modal-footer" style="text-align: center;">
				 <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
			</div>
		</div>
	</div>
</div>


<!-- History Overtime Details -->
<div class="modal fade" id="modal_overtimeHistory_details" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 800px;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Overtime Request History Details
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel panel-default request_panel">
					<div class="panel-body" style="max-height: 300px; overflow: auto;">
				   		<table class="table table-hover table-condensed">
				   			<thead>
				   				<th>
				   					ID	
				   				</th>
				   				<th>
				   					Emp				
				   				</th>
				   				<th>
				   					hours				
				   				</th>
				   				<th>
				   					Start Time:				
				   				</th>
				   				<th>
				   					End Time:					
				   				</th>
				   				<th>
				   					Paid Rate(%)		
				   				</th>
				   				<th>
				   					Compensatory hrs			
				   				</th>
				   			</thead>
							<tbody id="overtimeHistoryDetails" class="table-without-firstrow-border">
								<!-- overtime record items info -->
							</tbody>
						</table>
				  	</div>
				</div>
			</div>
			<div class="modal-footer" style="text-align: center;">
				 <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
			</div>
		</div>
	</div>
</div>

<!-- History Overtime Track -->
<div class="modal fade" id="modal_overtimeHistory_track" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 700px;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Track
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel panel-default request_panel">
					<div class="panel-body" style="max-height: 300px; overflow: auto;">
				   		<table class="table table-hover table-condensed">
				   			<thead>
				   				<th>
				   					ID
				   				</th>
				   				<th>
				   					State
				   				</th>
				   				<th>
				   					Person
				   				</th>
				   				<th>
				   					Desc
				   				</th>
				   				<th>
				   					Date
				   				</th>
				   			</thead>
							<tbody id="overtimeHistoryTrack" class="table-without-firstrow-border">
								<!-- overtime record logs info -->
							</tbody>
						</table>
				  	</div>
				</div>
			</div>
			<div class="modal-footer" style="text-align: center;">
				 <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
			</div>
		</div>
	</div>
</div>

<a id="testbtnforRequest" href="#" data-toggle="modal">Test button in Request</a>
<s:debug/>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/jqueryPagination/jquery.twbsPagination.js"></script>
<%-- <script type="text/javascript" src="js/selectpicker.js"></script> --%>
<script type="text/javascript" src="js/spin.min.js"></script>
<script type="text/javascript" src="js/jquery.spin.js"></script>
<script type="text/javascript" src="js/script_new.js"></script>
</html>