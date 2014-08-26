<%@page import="com.moravia.hs.base.entity.Baseincomtax"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Salary Info Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<!-- <link href="css/bootstrap-theme.min.css" rel="stylesheet"/> -->
<!-- <link type="text/css" href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" /> -->
<link href="css/style2.css" rel="stylesheet"/>
<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.editableonlynumber.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#sip_monthlyBaseSalary2").editable("dblclick", function(e) {
		});
		$("#sip_quarterlyBonus2").editable("dblclick", function(e) {
		});
		$("#sip_postAllowance2").editable("dblclick", function(e) {
		});
		$("#sip_transAllowance2").editable("dblclick", function(e) {
		});
		$("#sip_Bonus2").editable("dblclick", function(e) {
		});
		$("#sip_mealSubsidy2").editable("dblclick", function(e) {
		});
		$("#sip_overTimePay2").editable("dblclick", function(e) {
		});
		$("#sip_otherPay2").editable("dblclick", function(e) {
		});
		/* $("#sip_monthlyTotalBaseSalary2").editable("dblclick", function(e) {
		}); */

		$("#pension_Personal2").editable("dblclick", function(e) {
		});
		$("#pension_Company2").editable("dblclick", function(e) {
		});
		$("#medical_Personal2").editable("dblclick", function(e) {
		});
		$("#medical_Company2").editable("dblclick", function(e) {
		});
		$("#accum_Fund_Personal2").editable("dblclick", function(e) {
		});
		$("#accum_Fund_Company2").editable("dblclick", function(e) {
		});
		$("#unemp_Insu_Personal2").editable("dblclick", function(e) {
		});
		$("#unemp_Insu_Company2").editable("dblclick", function(e) {
		});
		/* $("#sip_incomtax2").editable("dblclick", function(e) {
		}); */
		$("#occupInjure_maternity_Company2").editable("dblclick", function(e) {
		});
		/* $("#sip_monthlySocialCost_Personal2").editable("dblclick", function(e) {
		}); */
		/* $("#sip_monthlySocialCost_Company2").editable("dblclick", function(e) {
		}); */
		$("#sip_monthlyPaidHrs2").editable("dblclick", function(e) {
		});
		$("#sip_monthlyOverTimeHrs2").editable("dblclick", function(e) {
		});
		
		
		/* Tool tip */
	    $("#sip_totalSalary_toolTip").tooltip();
	    
	    
		var v1 = $("#sip_monthlyBaseSalary").text();
		var v2 = $("#sip_quarterlyBonus").text();
		var v3 = $("#sip_postAllowance").text();
		var v4 = $("#sip_transAllowance").text();
		var v5 = $("#sip_Bonus").text();
		var v6 = $("#sip_mealSubsidy").text();
		var v7 = $("#sip_overTimePay").text();
		var v8 = $("#sip_otherPay").text();
		var sip_monthlyTotalBaseSalary = (parseFloat(v1) + parseFloat(v2) + parseFloat(v3) + parseFloat(v4) + parseFloat(v5) + parseFloat(v6) + parseFloat(v7) + parseFloat(v8)).toFixed(2);
		
		$("#sip_monthlyTotalBaseSalary").text(sip_monthlyTotalBaseSalary);
		
		
		var vsc1 = $("#pension_Personal").text();
		var vsc2 = $("#medical_Personal").text();
		var vsc3 = $("#accum_Fund_Personal").text();
		var vsc4 = $("#unemp_Insu_Personal").text();
		var vsc5 = $("#sip_incomtax").text();
		var sip_monthlySocialCost_Personal = (parseFloat(vsc1) + parseFloat(vsc2) + parseFloat(vsc3) + parseFloat(vsc4) + parseFloat(vsc5)).toFixed(2);
		
		$("#sip_monthlySocialCost_Personal").text(sip_monthlySocialCost_Personal);
		
		var vsc6 = $("#pension_Company").text();
		var vsc7 = $("#medical_Company").text();
		var vsc8 = $("#accum_Fund_Company").text();
		var vsc9 = $("#unemp_Insu_Company").text();
		var vsc10 = $("#occupInjure_maternity_Company").text();
		var sip_monthlySocialCost_Company = (parseFloat(vsc6) + parseFloat(vsc7) + parseFloat(vsc8) + parseFloat(vsc9) + parseFloat(vsc10)).toFixed(2);
		$("#sip_monthlySocialCost_Company").text(sip_monthlySocialCost_Company);
		
		var sip_totalSalary = (parseFloat(sip_monthlySocialCost_Company) + parseFloat(sip_monthlyTotalBaseSalary)).toFixed(2);
		var sip_takeHomePay = (parseFloat(sip_monthlyTotalBaseSalary) - parseFloat(sip_monthlySocialCost_Personal)).toFixed(2);
		
		$("#sip_totalSalary").text(sip_totalSalary);
		$("#sip_takeHomePay").text(sip_takeHomePay);
		
		modalInit();
		
		/* $("#sip_monthlyTotalBaseSalary2").text(parseFloat(vt1).toFixed(2)); */
		
		// Dialog Simple
		/* $('#empty_dialog').dialog({
		    autoOpen: false,
		    width: 300,
		    show: {
		    	effect: "blind",
		    	duration: 150
		    },
		    hide: {
		    	effect: "blind",
		    	duration: 150
		    },
		    buttons: {
		        "Ok": function () {
		            $(this).dialog("close");
		        }
		    }
		});
		
		$("#testPrint").click(function() {
			$('#empty_dialog').dialog('open');
		    return false;
		}); */
		
		$("#sip_submit").click(function() {
			//no empty check
			if($("#sip_monthlyPaidHrs2").text() == "" || $("#sip_monthlyPaidHrs2").text() == "." ||
				$ ("#sip_monthlyOverTimeHrs2").text() == "" || $ ("#sip_monthlyOverTimeHrs2").text() == "." ||
				$("#sip_monthlyBaseSalary2").text() == "" || $("#sip_monthlyBaseSalary2").text() == "." ||
				$("#sip_quarterlyBonus2").text() == "" || $("#sip_quarterlyBonus2").text() == "." ||
				$("#sip_postAllowance2").text() == "" || $("#sip_postAllowance2").text() == "." ||
				$("#sip_transAllowance2").text() == "" || $("#sip_transAllowance2").text() == "." ||
				$("#sip_Bonus2").text() == "" || $("#sip_Bonus2").text() == "." ||
				$("#sip_mealSubsidy2").text() == "" || $("#sip_mealSubsidy2").text() == "." ||
				$("#sip_overTimePay2").text() == "" || $("#sip_overTimePay2").text() == "." ||
				$("#sip_otherPay2").text() == "" || $("#sip_otherPay2").text() == "." ||
				$("#pension_Personal2").text() == "" || $("#pension_Personal2").text() == "." ||
				$("#pension_Company2").text() == "" ||  $("#pension_Company2").text() == "." ||
				$("#medical_Personal2").text() == "" || $("#medical_Personal2").text() == "." ||
				$("#medical_Company2").text() == "" || $("#medical_Company2").text() == "." ||
				$("#accum_Fund_Personal2").text() == "" || $("#accum_Fund_Personal2").text() == "." ||
				$("#accum_Fund_Company2").text() == "" || $("#accum_Fund_Company2").text() == "." ||
				$("#unemp_Insu_Personal2").text() == "" || $("#unemp_Insu_Personal2").text() == "." ||
				$("#unemp_Insu_Company2").text() == "" || $("#unemp_Insu_Company2").text() == "." ||
				$("#sip_incomtax2").val() == "" || $("#sip_incomtax2").val() == "." ||
				$("#occupInjure_maternity_Company2").text() == "" || $("#occupInjure_maternity_Company2").text() == "." ) 
			{
				/* $('#empty_dialog').dialog('open'); */
				alert("Field can not be empty.");
			    return false;
			}
			
			var params = {
			"sip_monthlyPaidHrs2" : $("#sip_monthlyPaidHrs2").text(),
			"sip_monthlyOverTimeHrs2" : $ ("#sip_monthlyOverTimeHrs2").text(),
			"sip_monthlyBaseSalary2" : $("#sip_monthlyBaseSalary2").text(),
			"sip_quarterlyBonus2" : $("#sip_quarterlyBonus2").text(),
			"sip_postAllowance2" : $("#sip_postAllowance2").text(),
			"sip_transAllowance2" : $("#sip_transAllowance2").text(),
			"sip_Bonus2" : $("#sip_Bonus2").text(),
			"sip_mealSubsidy2" : $("#sip_mealSubsidy2").text(),
			"sip_overTimePay2" : $("#sip_overTimePay2").text(),
			"sip_otherPayNote2" : $("#sip_otherPayNote2").val().trim(),
			"sip_otherPay2" : $("#sip_otherPay2").text(),
			"sip_mboPortion" : $("#sip_mboPortion").val().trim(),
			"sip_annuBonusPortion" : $("#sip_annuBonusPortion").val().trim(),
			"pension_Personal2" : $("#pension_Personal2").text(),
			"pension_Company2" : $("#pension_Company2").text(),
			"medical_Personal2" : $("#medical_Personal2").text(),
			"medical_Company2" : $("#medical_Company2").text(),
			"accum_Fund_Personal2" : $("#accum_Fund_Personal2").text(),
			"accum_Fund_Company2" : $("#accum_Fund_Company2").text(),
			"unemp_Insu_Personal2" : $("#unemp_Insu_Personal2").text(),
			"unemp_Insu_Company2" : $("#unemp_Insu_Company2").text(),
			"sip_incomtax2" : $("#sip_incomtax2").val().trim(),
			"occupInjure_maternity_Company2" : $("#occupInjure_maternity_Company2").text()
			};
			$.ajax({
				url : "savePayrollAction",
				type : "post",
				data : params,
				success : function() {
					 location.href = "salaryInfoAction";
				},
				error: function() {
					alert("ajax 请求失败");
				}
			});
		});
		
		$("#sip_form_updatePortion").validate({
			rules: {
				sip_mboPortion: {
					required: true,
					number: true
				},
				sip_annuBonusPortion: {
					required: true,
					number: true
				}
			},
			
			tooltip_options: {
				sip_mboPortion: {
					trigger:'focus'
				},
				sip_annuBonusPortion: {
					trigger:'focus'
				}
			}
		});
		
	});
	
	function modalInit() {
		var vt1 = $("#sip_monthlyBaseSalary2").text();
		var vt2 = $("#sip_quarterlyBonus2").text();
		var vt3 = $("#sip_postAllowance2").text();
		var vt4 = $("#sip_transAllowance2").text();
		var vt5 = $("#sip_Bonus2").text();
		var vt6 = $("#sip_mealSubsidy2").text();
		var vt7 = $("#sip_overTimePay2").text();
		var vt8 = $("#sip_otherPay2").text();
		var sip_monthlyTotalBaseSalary2 = (parseFloat(vt1) + parseFloat(vt2) + parseFloat(vt3) + parseFloat(vt4) + parseFloat(vt5) + parseFloat(vt6) + parseFloat(vt7) + parseFloat(vt8)).toFixed(2);
		$("#sip_monthlyTotalBaseSalary2").text(sip_monthlyTotalBaseSalary2);
		
		var vsc1 = $("#pension_Personal2").text();
		var vsc2 = $("#medical_Personal2").text();
		var vsc3 = $("#accum_Fund_Personal2").text();
		var vsc4 = $("#unemp_Insu_Personal2").text();
		
		var duoyu = sip_monthlyTotalBaseSalary2 - parseFloat(vsc1) - parseFloat(vsc2) - parseFloat(vsc3) - parseFloat(vsc4) - 3500;
		
		var tax;
			if(duoyu<=0)
			tax=0;
			 if (duoyu>0&&duoyu<=1500){tax=duoyu*0.03;}
			 if (duoyu>1500&&duoyu<=4500){tax=duoyu*0.1-105;}
			 if (duoyu>4500&&duoyu<=9000){tax=duoyu*0.2-555;}
			 if (duoyu>9000&&duoyu<=35000){tax=duoyu*0.25-1005;}
			 if (duoyu>35500&&duoyu<=55000){tax=duoyu*0.3-2755;}
			 if (duoyu>55000&&duoyu<=80000){tax=duoyu*0.35-5505;}
			 if (duoyu>80000){tax=duoyu*0.45-13505;}
			 
		$("#sip_incomtax2").val(tax.toFixed(2));
		
		var vsc5 = $("#sip_incomtax2").val().trim();
		var sip_monthlySocialCost_Personal2 = (parseFloat(vsc1) + parseFloat(vsc2) + parseFloat(vsc3) + parseFloat(vsc4) + parseFloat(vsc5)).toFixed(2);
		
		$("#sip_monthlySocialCost_Personal2").text(sip_monthlySocialCost_Personal2);
		
		var vsc6 = $("#pension_Company2").text();
		var vsc7 = $("#medical_Company2").text();
		var vsc8 = $("#accum_Fund_Company2").text();
		var vsc9 = $("#unemp_Insu_Company2").text();
		var vsc10 = $("#occupInjure_maternity_Company2").text();
		var sip_monthlySocialCost_Company2 = (parseFloat(vsc6) + parseFloat(vsc7) + parseFloat(vsc8) + parseFloat(vsc9) + parseFloat(vsc10)).toFixed(2);
		$("#sip_monthlySocialCost_Company2").text(sip_monthlySocialCost_Company2);
		
		$("#sip_totalSalary2").text((parseFloat(sip_monthlyTotalBaseSalary2) + parseFloat(sip_monthlySocialCost_Company2)).toFixed(2));
		$("#sip_takeHomePay2").text((parseFloat(sip_monthlyTotalBaseSalary2) - parseFloat(sip_monthlySocialCost_Personal2)).toFixed(2));
		
}
	
</script>
</head>
<%
  	if(session.getAttribute("login") == null) {
  		request.getRequestDispatcher("login.jsp").forward(request, response);
  	}
		/*response.sendRedirect("login.jsp");*/	
  %>
<body>
	
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>
						Salary Info <small><s:property value="#session.sip_Month" />月</small>
					</h1>
				</div>
				<div class="row clearfix">
					<div class="col-md-6 column">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<div class="row clearfix">
									<div class="col-md-6 column" style="padding-right: 0px;">
										<div class="media">
											<a class="pull-left">
											<!-- <img src="http://lorempixel.com/64/64/" class="media-object" alt=""> --> 
											<img src="img/profile/sip_01.jpg" class="media-object">
											</a>
											<div class="media-body" style="padding-left: 15px;">
												<h4 class="media-heading" style="margin-bottom: 20px;">
													<s:property value="#session.Emp.nameEnglish" />
												</h4>
												<strong><s:property
														value="#session.Emp.nameChinese" /> </strong>
												<address style="margin-bottom: 10px;">
													<br> <strong>Mobile:</strong>&nbsp;
													<s:property value="#session.Emp.mobile" />
													<br> <strong>Phone:</strong>&nbsp;&nbsp;
													<s:property value="#session.Emp.officePhone" />
													<br> <strong>Skype:</strong><br>
													<s:property value="#session.Emp.skype" />
													<br> <strong>Email:</strong><br>
													<s:property value="#session.Emp.email" />
												</address>
												<p>
													<a href="empInfoAction?empLoginId=<s:property value="#session.Emp.empLoginId"/>" style="padding: 0px; ">View
														details »</a>
												</p>
											</div>
										</div>
									</div>
									<div class="col-md-6 column" style="padding-left: 0px;">
										<dl style="margin-top: 0px;">
											<strong>Title:</strong>&emsp;
											<s:property value="#session.sip_positiontitle" />
											<br>
											<strong>Department:</strong>&emsp;
											<s:property value="#session.sip_department" />
											<br>
											<br>
											<strong>基本工资:</strong>&emsp;&nbsp;￥
											<s:property value="#session.sip_emp_baseSalary" default="0" />
											<br>
											<strong>社保基数:</strong>&emsp;&nbsp;￥
											<s:property value="#session.sip_emp_socialInsBase" default="0" />
											<br>
											<strong>MBO:</strong>&emsp;
											<s:property value="#session.sip_mbo" default="0" />
											%
											<br>
											<br>
											<strong>银行卡:</strong>&emsp;
											<s:property value="#session.Emp.creditCardNumber" />
										</dl>

									</div>
								</div>
							</div>
						</div>
						
						<div class="row clearfix">
						<div class="col-md-12 column" style="margin-top: 30px;">
								<h3>MBO/Annual Bonus 分级统计信息</h3>
							<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">
											MBO/Annual Bonus Monthly Portion
										</h3>
									</div>
									<div class="panel-body" style="padding: 5px; padding-top: 20px;">
										<table class="table table-strip table-hover"
											style="font-size: 14px; margin-bottom: 5px;">
												<thead>
													<tr>
													<td>MBO Portion：</td>
													<td><s:property value="#session.sip_mboPortion" default="0" />
													</td>
													<td>AnnuBonus Portion：</td>
													<td><s:property value="#session.sip_annuBonusPortion" default="0"/>
													</td>
												</tr>
												</thead>
										</table>
									</div>
									<div class="panel-footer" style="text-align: right;">
										<a id="" href="<s:if test="#session.sip_payrollId > 0">#modal-container-monthlyDiv</s:if><s:else>#modal-container-confirmFirstAlert</s:else>"
											role="button" class="btn" data-toggle="modal"
											style="padding: 0px;"><button
												type="button" class="btn btn-primary btn-sm">Update</button>
										</a>
								</div>
								<div class="modal fade" id="modal-container-monthlyDiv" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
										<div class="modal-content">
											<div class="modal-header">
												 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
												<h4 class="modal-title" id="myModalLabel">
													Update MBO/Annual Monthly Portion
												</h4>
											</div>
										<form id="sip_form_updatePortion" action="savePayrollAction!savePortion" role="form" accept-charset="utf-8">
											<div class="modal-body">
													<!-- <input type="hidden" name="operationFlag_tohbip" value="addEmpType"> -->
													<div class="form-group">
														 <label>MBO Portion:</label>
														 <input id="sip_mboPortion" name="sip_mboPortion" style="width: 200px;" type="text" class="form-control red-tooltip"  value="<s:property value="#session.sip_mboPortion" default="0"/>" />
													</div>
													<div class="form-group">
														 <label>Annual Bonus Portion:</label>
														 <input id="sip_annuBonusPortion" name="sip_annuBonusPortion" style="width: 200px;" type="text" class="form-control red-tooltip" value="<s:property value="#session.sip_annuBonusPortion" default="0"/>"/>
													</div>
											</div>
											<div class="modal-footer">
												 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
												 <button type="submit" class="btn btn-primary btn-sm">Save</button>
											</div>
										</form>
										</div>
									</div>
								</div>
							</div>
							</div>
						</div>
						
						<div class="row clearfix">
							<div class="col-md-12 column" style="margin-top: 30px;">
								<h3>Timesheet 统计信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small><em><a href="getAbsenceOvertimeInfoByTime?aotentity.loginId=<s:property value='#session.Emp.empLoginId'/>
									&aotentity.startDate=<s:property value='#session.startDate'/>&aotentity.endDate=<s:property value='#session.endDate'/>
									" style="padding: 0px; ">View Absence&Overtime Info »</a></em></small>
								</h3>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">
											Timesheet Info&nbsp;&nbsp;&nbsp;&nbsp;Total Hours:&nbsp;
											<s:property value="#session.sip_monthlyTotalHrs"  default="0"/>
										</h3>
									</div>
									<div class="panel-body" style="padding: 5px;">
										<table class="table table-strip table-hover"
											style="font-size: 14px; margin-bottom: 5px;">
											<thead>
												<tr>
													<th style="width: 90px;">Order ID</th>
													<th style="width: 200px;">Project Name</th>
													<th>PM</th>
													<th>Hours</th>
												</tr>
											</thead>

											<tbody>
												<s:iterator var="var" value="#session.tsInfoList">
													<tr>
														<td><s:property value="#var.orderId" /></td>
														<td><s:property value="#var.projectName" />
														</td>
														<td><s:property value="#var.pmName" />
														</td>
														<td><s:property value="#var.sumDiff" default="0"/>
														</td>
													</tr>
												</s:iterator>
											</tbody>
										</table>
									</div>
									<div class="panel-footer" style="text-align: right;">
									<!-- startDate -->
										<a href="timeSheetTrackAction?tstp_empLoginId=<s:property value="#session.Emp.empLoginId"/>&tstp_startDate=<s:property value="#session.startDate"/>&tstp_endDate=<s:property value="#session.endDate"/>&operationFlag_tstp=tstp_filterOperate">Details »</a>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					<div class="col-md-6 column">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<h3 style="margin-top: 0px;">工资单</h3>
								<div <s:if test="#session.sip_payrollId > 0">class="panel panel-primary"</s:if><s:else>class="panel panel-danger"</s:else> >
									<div class="panel-heading" >
										<h3 class="panel-title" >
											Payroll&nbsp;&nbsp;&nbsp;&nbsp;
											<s:property value="#session.sip_Year" />
											年&nbsp;&nbsp;
											<s:property value="#session.sip_Month" />
											月</span>
											<s:if test="#session.sip_payrollId > 0"><span style="float:right; font-size: 13px;">Last edited: <s:property value="#session.payrollCreateDate"/></span></s:if>
											<s:else><span style="float:right; font-size: 13px;">You have not confirmed this payroll! </s:else>
										
									</div>
									<div class="panel-body" style="padding-top: 5px; padding-top: 20px;">
										<table class="table  table-strip table-hover danger"
											style="font-size: 14px;">
											<tbody>
												<tr>
													<td style="width: 120px;">工作时间：</td>
													<td style="width: 141px;" ><s:property
															value="#session.sip_monthlyPaidHrs" default="0" />&nbsp;&nbsp;hrs.</td>
													<td style="width: 120px;">加班时间：</td>
													<td style="width: 142px;" >
													<s:property	value="#session.sip_monthlyOverTimeHrs" default="0" />&nbsp;&nbsp;hrs.
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
													<td id="sip_monthlyBaseSalary"><s:property value="#session.sip_monthlyBaseSalary" default="0" />
													</td>
													<td>季度奖金：</td>
													<td id="sip_quarterlyBonus"><s:property value="#session.sip_quarterlyBonus" default="0" />
													</td>
												</tr>
												<tr>
													<td>岗位津贴：</td>
													<td id="sip_postAllowance"><s:property value="#session.sip_postAllowance" default="0"/></td>
													<td>交通津贴：</td>
													<td id="sip_transAllowance"><s:property value="#session.sip_transAllowance" default="0"/>
													</td>
												</tr>
												<tr>
													<td>奖励：</td>
													<td id="sip_Bonus"><s:property value="#session.sip_Bonus" default="0"/></td>
													<td>餐补：</td>
													<td id="sip_mealSubsidy"><s:property value="#session.sip_mealSubsidy" default="0"/></td>
												</tr>
												<tr>
													<td>加班费：</td>
													<td id="sip_overTimePay"><s:property value="#session.sip_overTimePay" default="0"/></td>
													<td>Adjustment:</td>
													<td id="sip_otherPay"><s:property value="#session.sip_otherPay" default="0"/></td>
												</tr>
												<tr>
													<td>Note：</td>
													<td id="sip_otherPayNote" colspan="3"><s:property value="#session.sip_otherPayNote" default=""/></td>
												</tr>
												<tr>
													<td>总计：</td>
													<td id="sip_monthlyTotalBaseSalary">0</td>
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
													<td id="pension_Personal"><s:property value="#session.pension_Personal" default="0"/>
													</td>
													<td>养老保险：</td>
													<td id="pension_Company"><s:property value="#session.pension_Company" default="0"/></td>
												</tr>
												<tr>
													<td>医疗保险：</td>
													<td id="medical_Personal"><s:property value="#session.medical_Personal" default="0"/>
													</td>
													<td>医疗保险：</td>
													<td id="medical_Company"><s:property value="#session.medical_Company" default="0"/></td>
												</tr>
												<tr>
													<td>公积金：</td>
													<td id="accum_Fund_Personal"><s:property value="#session.accum_Fund_Personal" default="0"/>
													</td>
													<td>公积金：</td>
													<td id="accum_Fund_Company"><s:property value="#session.accum_Fund_Company" default="0"/>
													</td>
												</tr>
												<tr>
													<td>失业保险：</td>
													<td id="unemp_Insu_Personal"><s:property value="#session.unemp_Insu_Personal" default="0"/>
													</td>
													<td>失业保险：</td>
													<td id="unemp_Insu_Company"><s:property value="#session.unemp_Insu_Company" default="0"/>
													</td>
												</tr>
												<tr>
													<td>本月扣税：</td>
													<td id="sip_incomtax"><s:property value="#session.sip_incomtax" default="0"/>
													</td>
													<td>工伤生育保险：</td>
													<td id="occupInjure_maternity_Company"><s:property
															value="#session.occupInjure_maternity_Company" default="0"/></td>
												</tr>
												<tr>
													<td>总计：</td>
													<td id="sip_monthlySocialCost_Personal">0</td>
													<td>总计：</td>
													<td id="sip_monthlySocialCost_Company">0</td>
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
													<td><span id="sip_totalSalary_toolTip" title="show tool tip.">工资总计：</span></td>
													<td id="sip_totalSalary">0</td>
													<td>实发工资：</td>
													<td id="sip_takeHomePay">0</td>
												</tr>
											</tbody>
										</table>


									</div>
									<div class="panel-footer" style="text-align: right;">
										<a id="modal-857800" href="#modal-container-857800"
											role="button" class="btn" data-toggle="modal"
											style="padding: 0px;"><button
												type="button" class="btn btn-primary btn-sm">Update And Confirm</button>
										</a>
									</div>
									<div class="modal fade" id="modal-container-857800"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog" >
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="myModalLabel">Update payroll<span style="font-size: 10px; float: right; margin-right: 50px; margin-top: 15px;" >Double click to edit.</span>
														</h4>
													</div>
													<div class="modal-body">
														<form role="form" action="savePayrollAction" method="post" id="sip_form">
														<table class="table  table-strip table-hover danger"
															style="font-size: 14px;">
															<tbody>
																<tr>
																	<td style="width: 120px;">工作时间：</td>
																	
																	<td class="sip_form-td" style="padding: 0px; width: 141px;">
																	<span class="form-control sip_form-control"
																			id="sip_monthlyPaidHrs2"><s:property
																					value="#session.sip_monthlyPaidHrs" default="0"/>
																		</span></td>
																	
																	<td style="width: 120px;">加班时间：</td>
																	<td class="sip_form-td" style="padding: 0px; width: 142px;">
																	<span class="form-control sip_form-control"
																			id="sip_monthlyOverTimeHrs2"><s:property
																			value="#session.sip_monthlyOverTimeHrs" default="0" /></span></td>
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
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_monthlyBaseSalary2"><s:property
																					value="#session.sip_monthlyBaseSalary" default="0"/>
																		</span></td>
																		<td>季度奖金：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_quarterlyBonus2"><s:property
																					value="#session.sip_quarterlyBonus" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>岗位津贴：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_postAllowance2"><s:property value="#session.sip_postAllowance" default="0"/></span></td>
																		<td>交通津贴：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_transAllowance2"><s:property
																					value="#session.sip_transAllowance" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>奖励：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control" id="sip_Bonus2"><s:property value="#session.sip_Bonus" default="0"/></span>
																		</td>
																		<td>餐补：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_mealSubsidy2"><s:property
																					value="#session.sip_mealSubsidy" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>加班费：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_overTimePay2"><s:property
																					value="#session.sip_overTimePay" default="0"/>
																		</span></td>
																		<td>Adjustment:</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="sip_otherPay2"><s:property
																					value="#session.sip_otherPay" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>Note：</td>
																		<td id="" colspan="3" style="padding: 0px;"><input id="sip_otherPayNote2" class="form-control" style="height: 30px; width: 380px; margin-top: 3px; resize: none;" value="<s:property value="#session.sip_otherPayNote" default=""/>"/></td>
																	</tr>
																	<tr>
																		<td>总计：</td>
																		<td class="sip_form-td" style="padding-left: 0px;" id="sip_monthlyTotalBaseSalary2">
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
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="pension_Personal2"><s:property
																					value="#session.pension_Personal" default="0"/>
																		</span></td>
																		<td>养老保险：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="pension_Company2"><s:property
																					value="#session.pension_Company" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>医疗保险：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="medical_Personal2"><s:property
																					value="#session.medical_Personal" default="0"/>
																		</span></td>
																		<td>医疗保险：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="medical_Company2"><s:property
																					value="#session.medical_Company" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>公积金：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="accum_Fund_Personal2"><s:property
																					value="#session.accum_Fund_Personal" default="0"/>
																		</span></td>
																		<td>公积金：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="accum_Fund_Company2"><s:property
																					value="#session.accum_Fund_Company" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>失业保险：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="unemp_Insu_Personal2"><s:property
																					value="#session.unemp_Insu_Personal" default="0"/>
																		</span></td>
																		<td>失业保险：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="unemp_Insu_Company2"><s:property
																					value="#session.unemp_Insu_Company" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>本月扣税：</td>
																		<td class="sip_form-td" style="padding: 0px;">
																		<!-- <span class="form-control sip_form-control" id="sip_incomtax2"><s:property
																				value="#session.sip_incomtax" default="0"/>
																		</span> -->
																		<input id="sip_incomtax2" class="form-control" style="height: 30px; width: 120px; margin-top: 3px;" value="<s:property value="#session.sip_incomtax" default="0"/>"/>
																		</td>
																		<td>工伤生育保险：</td>
																		<td class="sip_form-td" style="padding: 0px;"><span
																			class="form-control sip_form-control"
																			id="occupInjure_maternity_Company2"><s:property
																					value="#session.occupInjure_maternity_Company" default="0"/>
																		</span></td>
																	</tr>
																	<tr>
																		<td>总计：</td>
																		<td class="sip_form-td" style="padding-left: 0px;" id="sip_monthlySocialCost_Personal2">0
																		</td>
																		<td>总计：</td>
																		<td class="sip_form-td" style="padding-left: 0px;" id="sip_monthlySocialCost_Company2">0</td>
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
																			<td id="sip_totalSalary2" style="padding-left: 0px;">0</td>
																			<td>实发工资：</td>
																			<td id="sip_takeHomePay2" style="padding-left: 0px;">0</td>
																		</tr>
																	</tbody>
																</table>
														</form>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default btn-sm"
															data-dismiss="modal">Close</button>
														<button type="button" class="btn btn-primary btn-sm" id="sip_submit">Save</button>
													</div>
												</div>

											</div>

										</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column"></div>
		</div>
	</div>
	
	<div class="modal fade" id="modal-container-confirmFirstAlert" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					Warning
				</h4>
			</div>
			<div class="modal-body">
				Please confirm the payroll first.
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm pull-center" data-dismiss="modal">OK</button> 
			</div>
		</div>
		
	</div>
	</div>
	
<p style="color: red"><s:property value="#session.sip_overtimeNotMatchError"/></p>
</body>
</html>
