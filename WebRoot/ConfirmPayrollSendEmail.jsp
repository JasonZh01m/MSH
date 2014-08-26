<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conrim and Send Payroll Mail</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="css/dataTable/dataTables.bootstrap.css">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<script type="text/javascript" charset="utf-8" language="javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" language="javascript"
	src="js/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" language="javascript"
	src="js/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<!-- test if conflict -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<style type="text/css">
.tableA th {
		text-align: center;
		word-break: keep-all;
		white-space:nowrap;
	}
		
.red-tooltip + .tooltip > .tooltip-inner{background-color: #FF6633;}
.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #FF6633;}
</style>

<%
 	if(session.getAttribute("login") == null) {
 		System.out.println("this is page confimPayrollSendEmail page");
 	 	response.sendRedirect("login.jsp");
 	}
 %> 

<script type="text/javascript">
	$(function() {
		$(".form_date").datetimepicker({
	        language:  'en',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
		
		$('#example_tab').dataTable({
			"iDisplayLength" : 25,
			"aoColumnDefs": [
			  { 'bSortable': false, 'aTargets': [7 , 8] }
			 ]
		});

		 /* dataTable实现checkbox 全选功能 */
        $('#pcp_selectAll').click( function() {
            var oTable = $('#example_tab').dataTable();
            var c = this.checked;
            $('.select_all', oTable.fnGetNodes()).prop('checked',c);
        });
		
		 
        $("#sendmail").click(function() {
            var oTable = $('#example_tab').dataTable();
            var str = "";
            $('.select_all:checkbox:checked', oTable.fnGetNodes()).each(function () {
          		str += $(this).val().trim() + ",";
            });
           
            if($("#pcp_endDate").val().trim().length == 0 || $("#pcp_startDate").val().trim().length == 0) {
            	$("#modal-container-sendPayrollMail").modal('toggle');
            	alert("Please choose a date");
            	return false;
            }
            
            var params = {
            	"pcp_loginids" : str,
            	"pcp_endDate" : $("#pcp_endDate").val().trim(),
            	"pcp_startDate" : $("#pcp_startDate").val().trim()
            };
            
            $.ajax({
				url : "sendPayrollMailAction",
				type : "post",
				data : params,
				complete : function () {
					$("#modal-container-sendPayrollMail").modal('toggle');
					$("#modal-container-complete").modal('toggle');
				}
			});
        });
        
        $("#testsendMail").click(function () {
        	if ($(".select_all:checked").length <= 0) {
        		alert("No checkbox checked");
        		return false;
        	}
        });
        
        $("#uploadfileSubmit").click(function() {
		 	if($("#uploadfile").val() == "") {
		 		alert("Nothing selected, please select a .xlsx file.");
			 	return false;
		 	}
		 });
        
        $("#payrollConfirmationForm1").validate({
        	rules: {
        		pcp_startDate: {
        			required: true,
					dateISO: true
        		},
        		pcp_endDate: {
        			required: true,
        			dateISO: true
        		}
        	},
        	tooltip_options: {
        		pcp_startDate: {
        			trigger: 'focus'
        		},
        		pcp_endDate: {
        			trigger: 'focus'
        		}
        	},
        	message: {
        		pcp_startDate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)" 
				},
				pcp_endDate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)" 
				},
        	}
        });
        
        $("#payrollConfirmationForm2").validate({
        	rules: {
        		fsip_startDate2: {
        			required: true,
					dateISO: true
        		},
        		fsip_endDate2: {
        			required: true,
        			dateISO: true
        		}
        	},
        	tooltip_options: {
        		fsip_startDate2: {
        			trigger: 'focus'
        		},
        		fsip_endDate2: {
        			trigger: 'focus'
        		}
        	},
        	message: {
        		fsip_startDate2: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				},
				fsip_endDate2: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)" 
				},
        	}
        });
        
		 
	});


</script>

</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="row clearfix">
			<div class="page-header">
				<h1>
					Payroll Confirmation Page <small><s:property value="#session.pcp_month"/>月</small>
				</h1>
			</div>
			<form id="payrollConfirmationForm1" action="payrollConfirmationAction" method="post">
			<div class="row clearfix" style="margin-bottom: 20px; margin-left: 20px;">
				<div class="col-md-12 column" style="width: 85%; margin: auto;">
					<div class="row clearfix">
						<div class="col-md-3 column">
							 <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
								<span class="input-group-addon">Start Date:</span>
			                    <input id="pcp_startDate" class="form-control red-tooltip" name="pcp_startDate" data-date-format="yyyy-mm-dd" type="text" value="<s:property value="#session.pcp_startDate" default=""/>" placeholder="Start Date">
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
						<div class="col-md-3 column">
							 <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
								<span class="input-group-addon">End Date:</span>
			                    <input id="pcp_endDate" class="form-control red-tooltip" name="pcp_endDate" data-date-format="yyyy-mm-dd" type="text" value="<s:property value="#session.pcp_endDate" default=""/>" placeholder="End Date">
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
					<div class="col-md-1 column" style="padding: 0px;">
						<button id="fsfilter_submit" type="submit" style="height: 30px;" class="btn btn-sm btn-primary">Filter</button>
					</div>
					<div class="col-md-1 column" style="padding-left: 0px;">
						<a id="testsendMail" href="#modal-container-sendPayrollMail" role="button" class="btn btn-primary btn-sm" data-toggle="modal">Send Mail&nbsp;<span class="glyphicon glyphicon-envelope"></span></a> 
					</div>
					<div class="col-md-2 column">
						<a id="exportPayroll" href="#modal-container-exportPayroll" role="button" class="btn btn-primary btn-sm pull-right" data-toggle="modal">Export Payroll&nbsp;<span class="glyphicon glyphicon-download-alt"></span></a> 
					</div>
					<div class="col-md-1 column" style="margin-left: 20px;">
						<a id="" href="#modal-container-uploadPayroll" role="button" class="btn btn-primary btn-sm pull-right" data-toggle="modal">Upload&nbsp;<span class="glyphicon glyphicon-open"></span></a> 
					</div>
					<!-- Confirm -->
					<div class="modal fade" id="modal-container-sendPayrollMail" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="margin-top: 200px; width: 25%;">
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										<span style="font-size: 20px;" class="glyphicon glyphicon-envelope"></span>&nbsp;Send Mail
									</h4>
								</div>
								<div class="modal-body">
									Do you really want to send mail?
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
									 <button id="sendmail" type="button" class="btn btn-primary btn-sm">Send</button>
								</div>
							</div>
						</div>
					</div>
					
					<!-- Complete -->
					<div class="modal fade" id="modal-container-complete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="margin-top: 200px; width: 18%;">
							<div class="modal-content">
								<div class="modal-header">
								</div>
								<div class="modal-body">
									Complete!
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">OK</button> 
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			</div>
			</form>
			
			<div class="col-md-12 column">
				<div class="panel panel-primary" style="width: 85%; margin: auto;">
					<div class="panel-heading">
							<h3 class="panel-title">
								Payroll Info
							</h3>
						</div>
					<div class="panel-body" style="padding: 15px;">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-hover dataTable tableA"
							id="example_tab" aria-describedby="example_info"
							style="overflow: auto; text-align: center;">
							<thead>
								<tr role="row">
									<th aria-sort="ascending">LoginId</th>
									<th>TS hrs</th>
									<th>工资总计</th>
									<th>个税</th>
									<th>社保(个人)</th>
									<th>社保(公司)</th>
									<th>实发工资</th>
									<th>Pay Date</th>
									<th>Send Mail?&nbsp;&nbsp;<input id="pcp_selectAll" type="checkbox"></th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">
								<s:iterator var="pcp_prItor" value="#session.pcp_pList" status="pcp_prStat">
									<tr>
										<td><a target="_blank" class=""
											href="salaryInfoAction?empLoginId=<s:property value="#pcp_prItor.empEmpLoginId"/>"><s:property value="#pcp_prItor.empEmpLoginId" /></a></td>
										<td><s:property value="#pcp_prItor.totalTimeSheetHrs" /></td>
										<td><s:property value="%{getText('format.number', {#pcp_prItor.baseSalary + #pcp_prItor.quartBonus + #pcp_prItor.postAllowance + #pcp_prItor.transportAllowance
										+ #pcp_prItor.bonus + #pcp_prItor.mealSubsidy + #pcp_prItor.overtimePay + #pcp_prItor.otherPay})}" /></td> <!-- 月工资总计 -->
										<td><s:property value="#pcp_prItor.incomeTax" /></td> <!-- 个税 -->
										<td><s:property value="%{getText('format.number', {#pcp_prItor.pensionPersonal + #pcp_prItor.medicalPersonal + #pcp_prItor.accumFundPersonal + #pcp_prItor.unempInsuPersonal})}" /></td> <!-- 社保个人 -->
										<td><s:property value="%{getText('format.number', {#pcp_prItor.pensionCompany + #pcp_prItor.pensionCompany + #pcp_prItor.medicalCompany + #pcp_prItor.accumFundCompany + #pcp_prItor.unempInsuCompany + #pcp_prItor.occupInjureMaternity})}"/></td> <!-- 社保公司 -->
										<td><s:property value="%{getText('format.number', {#pcp_prItor.baseSalary + #pcp_prItor.quartBonus + #pcp_prItor.postAllowance + #pcp_prItor.transportAllowance
										+ #pcp_prItor.bonus + #pcp_prItor.mealSubsidy + #pcp_prItor.overtimePay + #pcp_prItor.otherPay - #pcp_prItor.incomeTax - (#pcp_prItor.pensionPersonal + #pcp_prItor.medicalPersonal + #pcp_prItor.accumFundPersonal + #pcp_prItor.unempInsuPersonal)})}" /></td> <!-- 实发工资 -->
										<td><s:date name="#pcp_prItor.payDate" format="yyyy-MM-dd"/></td>
										<td><input type="checkbox" id="testCheckbox1" value="<s:property value='#pcp_prItor.empEmpLoginId'/>" class="select_all"></td>
									</tr>
									
								</s:iterator>
							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-container-editPayroll" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						Modal title
					</h4>
				</div>
				<div class="modal-body">
					<form role="form" action="savePayrollAction_XXXXX" method="post" id="pcp_form">
					<table class="table table-strip table-hover danger"
						style="font-size: 14px;">
						<tbody>
							<tr>
								<td style="width: 120px;">工作时间：</td>
								
								<td class="pcp_form-td" style="padding: 3px; width: 141px;">
								<input id="pcp_monthlyPaidHrs" name="pcp_monthlyPaidHrs" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
								</td>
								
								<td style="width: 120px;">加班时间：</td>
								<td class="pcp_form-td" style="padding: 0px; width: 142px;">
								<input id="pcp_monthlyOverTimeHrs" name="pcp_monthlyOverTimeHrs" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
								</td>
							</tr>
						</tbody>
					</table>
						<table class="table  table-strip table-hover danger"
							style="font-size: 14px;">
							<thead>
								<tr>
									<th style="width: 120px;">工资部分:</th>
									<th style="width: 141px;"></th>
									<th style="width: 120px;"></th>
									<th style="width: 142px;"></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>基本工资：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									
									<input id="pcp_monthlyBaseSalary" name="pcp_monthlyBaseSalary" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>季度奖金：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_quarterlyBonus" name="pcp_quarterlyBonus" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>岗位津贴：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_postAllowance" name="pcp_postAllowance" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>交通津贴：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_transAllowance" name="pcp_transAllowance" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>奖励：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_Bonus" name="pcp_Bonus" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>餐补：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_mealSubsidy" name="pcp_mealSubsidy" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>加班费：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_overTimePay" name="pcp_overTimePay" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>Adjustment:</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_otherPay" name="pcp_otherPay" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>Note：</td>
									<td id="" colspan="3" style="padding: 0px;"><input id="pcp_otherPayNote" class="form-control" style="height: 30px; width: 380px; margin-top: 3px; resize: none;" value="<s:property value="#session.pcp_otherPayNote" default=""/>"/></td>
								</tr>
								<tr>
									<td>总计：</td>
									<td class="pcp_form-td" style="padding-left: 0px;" id="pcp_monthlyTotalBaseSalary">
									</td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>

						<table class="table  table-strip table-hover"
							style="font-size: 14px;">
							<thead>
								<tr>
									<th style="width: 120px;">代扣代缴:</th>
									<th style="width: 141px;"></th>
									<th style="width: 120px;">公司缴付:</th>
									<th style="width: 142px;"></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>养老保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_pension_Personal" name="pcp_pension_Personal" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>养老保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_pension_Company" name="pcp_pension_Company" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>医疗保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_medical_Personal" name="pcp_medical_Personal" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>医疗保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_medical_Company" name="pcp_medical_Company" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>公积金：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_accum_Fund_Personal" name="pcp_accum_Fund_Personal" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>公积金：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_accum_Fund_Company" name="pcp_accum_Fund_Company" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>失业保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_unemp_Insu_Personal" name="pcp_unemp_Insu_Personal" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
									<td>失业保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_unemp_Insu_Company" name="pcp_unemp_Insu_Company" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>本月扣税：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_incomtax" class="form-control" style="height: 30px; width: 120px; margin-top: 3px;" value="<s:property value="#session.pcp_incomtax" default="0"/>"/>
									</td>
									<td>工伤生育保险：</td>
									<td class="pcp_form-td" style="padding: 0px;">
									<input id="pcp_occupInjure_maternity_Company" name="pcp_occupInjure_maternity_Company" style="height: 30px; width: 120px; margin-top: 3px;" class="form-control" value="0"/>
									</td>
								</tr>
								<tr>
									<td>总计：</td>
									<td class="pcp_form-td" style="padding-left: 0px;" id="pcp_monthlySocialCost_Personal2">0
									</td>
									<td>总计：</td>
									<td class="pcp_form-td" style="padding-left: 0px;" id="pcp_monthlySocialCost_Company2">0</td>
								</tr>
							</tbody>
						</table>
						<table class="table  table-strip table-hover"
							style="font-size: 14px;">
								<thead>
									<tr>
										<th style="width: 120px;">总计:</th>
										<th style="width: 141px;"></th>
										<th style="width: 120px;"></th>
										<th style="width: 142px;"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>工资总计：</td>
										<td id="pcp_totalSalary2" style="padding-left: 0px;">0</td>
										<td>实发工资：</td>
										<td id="pcp_takeHomePay2" style="padding-left: 0px;">0</td>
									</tr>
								</tbody>
							</table>
					</form>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> <button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modal-container-exportPayroll"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Export Payroll</h4>
				</div>
				<form id="payrollConfirmationForm2" action="exportExcelAction_Payroll!export" role="form"
					accept-charset="utf-8">
					<div class="modal-body"
						style="padding-left: 40px; padding-right: 80px;">
						<div class="input-group input-group-sm date form_date"
							data-date="" data-date-format="yyyy-mm-dd"
							data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
							<span class="input-group-addon">Start Date:</span> <input
								id="fsip_startDate2" class="form-control red-tooltip"
								name="fsip_startDate2" data-date-format="yyyy-mm-dd" type="text"
								value="<s:property value="#session.pcp_startDate" default=""/>"
								placeholder="Start Date"> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
						<div class="input-group input-group-sm date form_date"
							data-date="" data-date-format="yyyy-mm-dd"
							data-link-field="dtp_input2" data-link-format="yyyy-mm-dd"
							style="margin-top: 30px;">
							<span class="input-group-addon">End Date:</span> <input
								id="fsip_endDate2" class="form-control red-tooltip"
								name="fsip_endDate2" data-date-format="yyyy-mm-dd" type="text"
								value="<s:property value="#session.pcp_endDate" default=""/>"
								placeholder="End Date"> <span class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-sm"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary btn-sm">Export</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-container-uploadPayroll"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 100px; width: 20%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Upload Payroll</h4>
				</div>
			<form action="uploadExcelFileAction!doUpload" method="post"
				enctype="multipart/form-data">
				<div class="modal-body">
					<div class="" style="">
						<input id="uploadfile" class="btn btn-default btn-sm" type="file"
							name="upload">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">Cancel</button>
					<button id="uploadfileSubmit" type="submit" class="btn btn-primary btn-sm">Upload</button>
				</div>
			</form>
				</div>
			</div>
		</div>
</body>
</html>