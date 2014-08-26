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
  		System.out.print("login is null, please log on");
  		response.sendRedirect("login.jsp");
  	} 
  	/* else {
  		Login login = (Login)session.getAttribute("login");
  	} */
  %>
<body id="main-body">
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-1 column">
		
		</div>
		<div class="col-md-10 column">
			<div class="row clearfix">
				<div class="page-header">
				  <h1>Request Processing<small> For overtime request.</small></h1>
				</div>
				
				<div class="tab-pane active" id="panel-overtime">
							<!-- Page title -->
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title page-title">
										<span class="glyphicon glyphicon-time"></span>Overtime Request
									</h3>
								</div>
							</div>
							
							<form id="request_overtime_handle_form" action="overtimeRequestHandle" method="post">
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
														Applicant:
													</td>
													<td>
														<s:property value="#session.request_overtimerecord.applicant"/>
													</td>
													<td>
														Request Time:
													</td>
													<td>
														<s:date name="#session.request_overtimerecord.createdate" format="yyyy/MM/dd HH:mm:ss"/>
													</td>
													<td>
														Peoject Code:
													</td>
													<td>
														<s:property value="#session.request_overtimerecord.projectcode"/>
													</td>
												</tr>
												<tr>
													<td>
														Project Manager:
													</td>
													<td>
														<s:property value="#session.request_overtimerecord.pm"/>
													</td>
													<td>
														Function/Group Manager:
													</td>
													<td>
														<s:property value="#session.request_overtimerecord.gm"/>
													</td>
													<td>
														Project Name:
													</td>
													<td>
														<s:property value="#session.request_overtimerecord.projectname"/>
													</td>
												</tr>
												<tr>
													<td>
														COMMENTS:
													</td>
													<td colspan="5">
														<s:property value="#session.request_overtimerecord.comments"/>
													</td>
												</tr>
												<s:if test="#session.login.emp.empLoginId==#session.request_overtimerecord.gm">
													<tr>
														<td>
															PM NOTE:
														</td>
														<td colspan="5">
															<s:property value="#session.request_overtimerecord.pmnote"/>
														</td>
													</tr>
												</s:if>
												<tr style="margin: 0px;">
													<td colspan="6">
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
								    <h3 class="panel-title">Overtime Request Details 
								    <%-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total: <span id="total_absence_hours">xx</span> hrs. --%>
								    </h3>
								  </div>
								  <div class="panel-body request_panel_body">
								   		<table id="request_overtime_handle_table" class="table table-bordered">
								   			<thead>
								   				<th style="text-align: center;">
								   					EMPLOYEE:
								   				</th>
								   				<th style="text-align: center;">
								   					START:
								   				</th>
								   				<th style="text-align: center;">
								   					END:
								   				</th>
								   				<th style="text-align: center;">
								   					TOTAL:
								   				</th>
								   				<th style="text-align: center;">
								   					COST CENTER:
								   				</th>
								   				<th style="text-align: center;">
								   					PAID RATE:
								   				</th>
								   			</thead>
											<tbody id="request_overtime_handletbody" class="table-without-firstrow-border">
											<s:iterator var="overtimeItemItor" value="#session.request_overtimerecord.overtimerequestitems">
												<tr>
													<td style="display: none;">
														<input class="overtimeRecordItemId" type="hidden" value="<s:property value='#overtimeItemItor.id'/>">
													</td>
													<td>
														<s:property value="#overtimeItemItor.emploginid"/>
													</td>
													<td>
												        <s:date name="#overtimeItemItor.starttime" format="yyyy/MM/dd HH:mm:ss"/>
													</td>
													<td>
														<s:date name="#overtimeItemItor.endtime" format="yyyy/MM/dd HH:mm:ss"/>
													</td>
													<td>
													 	<s:property value="#overtimeItemItor.hours"/>
													</td>
													<td class="empselect_request" style="padding: 2px; width: 180px;">
														<select id="" name="" class="selectpicker overtimeItem_costcenter" data-live-search="true">
														    <s:iterator var="costcItor" value="#session.costcenterList">
														   		<option value="<s:property	value='#costcItor.costCenterName'/>" 
														   		<s:if test="#overtimeItemItor.costcenter==#costcItor.costCenterName">selected="selected"</s:if>>
														   			<s:property	value="#costcItor.costCenterName"/>
														   		</option>
														   	</s:iterator>
														 </select>
													</td>
													<td class="empselect_request" style="padding: 2px; width: 180px;">
														<select  class="selectpicker overtimeItemPaidRate" data-live-search="true">
															<option <s:if test="#overtimeItemItor.paidRate==0">selected="selected"</s:if> value="0">
																0%
															</option>
															<option <s:if test="#overtimeItemItor.paidRate==100">selected="selected"</s:if> value="100">
																100%
															</option>
															<option <s:if test="#overtimeItemItor.otherPaidRate!=1">selected="selected"</s:if>  value="150">
																150%
															</option>
															<option <s:if test="#overtimeItemItor.paidRate==200">selected="selected"</s:if> value="200">
																200%
															</option>
															<option <s:if test="#overtimeItemItor.paidRate==300">selected="selected"</s:if> value="300">
																300%
															</option>
															<option <s:if test="#overtimeItemItor.otherPaidRate==1">selected="selected"</s:if> value="others">
																others
															</option>
														</select>
													</td>
												</tr>
												<tr class="othersTrHidden info">
													<td>
														Paid Rate: <span style="color:red;">(%)</span>
													</td>
													<td style="padding: 3px; width: 180px;">
														<input type="text" class="form-control input-sm otherPaidRate" value="<s:property value='#overtimeItemItor.paidRate'/>" placeholder="Other Paid Rate (%)"  >
													</td>
													<td>
														<input type="checkbox" class="withcompensatory" <s:if test="#overtimeItemItor.withCompensatory==1">checked="checked"</s:if> /> Compensatory?
													</td>
													<td class="withcompensatoryHours">
														Hours:
													</td>
													<td style="padding: 3px; width: 170px;" class="withcompensatoryHours" >
														<input id="" type="text" class="form-control input-sm withcompensatoryHoursInput" value="<s:property value='#overtimeItemItor.compensatoryHours'/>" placeholder="Compensatory hours." >
													</td>
												</tr>
											</s:iterator>
											</tbody>
											<tbody>
											<tr>
												<td>
													<div style="margin: auto; padding: auto;"><strong>NOTE:</strong></div>
												</td>
												<td colspan="8">
													<textarea id="" name="overtimeRequestEntity.note" type="text" class="form-control" style="resize: none;" id="" placeholder="null"></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								  	</div>
								  	<div class="panel-footer" style="text-align:center;">
								  		<input name="overtimeRequestEntity.id" type="hidden" value="<s:property value='#session.request_overtimerecord.id'/>">
								  		<input id="requestovertimeitem_handleflag" name="overtimeRequestEntity.handleflag" type="hidden" value="">
										<input id="requestovertimeitem_itemids" name="overtimeRequestEntity.itemids" type="hidden" value="">
										<input id="requestovertimeitem_costcenter" name="overtimeRequestEntity.costcenter" type="hidden" value="">
										<input id="requestovertimeitem_paidrates" name="overtimeRequestEntity.paidrates" type="hidden" value="">
										<input id="requestovertimeitem_otherrates" name="overtimeRequestEntity.otherrates" type="hidden" value="">
										<input id="requestovertimeitem_withcompensatorys" name="overtimeRequestEntity.withcompensatorys" type="hidden" value="">
										<input id="requestovertimeitem_compensatoryhours" name="overtimeRequestEntity.compensatoryhours" type="hidden" value="">
								  		
								  		<input id="requestovertimeitemagreebutton" type="button" class="btn btn-primary" value="Agree" style="margin-right: 15px;">
								  		<input id="requestovertimeitemRejectbutton" type="button" class="btn btn-primary" value="Reject" style="margin-right: 15px;">
								  		<input id="" type="button" class="btn btn-default" value="Cancel" style="margin-right: 15px;">
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

<button class="btn btn-default testbtnforxxx" id="testbtnforRequestOvertime">Test button in RequestOvertime</button>
<!-- <a id="testbtnforRequestOvertime" href="#">Test button in RequestOvertime</a> -->
<s:debug/>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<%-- <script type="text/javascript" src="js/script_new.js"></script> --%>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/requestOvertime.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
</html>