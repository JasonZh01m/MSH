<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<title>Salary Setting Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="css/style2.css" rel="stylesheet">
<style type="text/css">
.red-tooltip + .tooltip > .tooltip-inner{background-color: #FF6633;}
.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #FF6633;}

.edit_hover :hover { color: #428BCA !important; }
.delete_hover :hover { color: #d9534f !important; }

.dropdown-menu {
  min-width: 0px;
}


.tableCenter th {
	text-align: center;
	word-break: keep-all;
	white-space:nowrap;
}

</style>

<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.editableonlynumber.js"></script>
<!-- <script type="text/javascript" src="js/jquery-ui-1.10.0.custom.min.js"></script> -->
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
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
	
	
		$(".editIncomeTaxBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			/* alert(td1.text().trim()); */
			$("#ssp_editIncomTax_Id").val(td1.text().trim());
			$("#ssp_editIncomTaxMoney").val(td1.next().text().trim());
			$("#ssp_editIncomTaxRate").val(td1.next().next().text().trim());
			$("#ssp_editIncomTaxDesc").val(td1.next().next().next().text().trim());
		});
	
		$(".deleteIncomeTaxBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#ssp_deleteIncomTax_Id").val(td1.text().trim());
			$("#deleteIncomTax").text(td1.next().text().trim() + "￥--" + td1.next().next().text().trim() + "%");
		});
		
		
		$("#editIncomeTaxForm").validate({
			rules: {
				ssp_editIncomTaxMoney: {
					required: true,
					number: true
				},
				ssp_editIncomTaxRate: {
					required: true,
					number: true
				},
				ssp_editIncomTaxDesc: {
					required: true
				}
			},
			
			tooltip_options: {
				ssp_editIncomTaxMoney: {
					trigger:'focus'
				},
				ssp_editIncomTaxRate: {
					trigger:'focus'
				},
				ssp_editIncomTaxDesc: {
					trigger:'focus'
				}
			}
		});
		
		$("#addNewIncomeTaxForm").validate({
			rules: {
				ssp_monthlyPaidIncomeMoney: {
					required: true,
					number: true
				},
				ssp_monthlyPaidIncomeRate: {
					required: true,
					number: true
				},
				ssp_monthlyPaidIncomeDesc: {
					required: true
				}
			},
			
			tooltip_options: {
				ssp_monthlyPaidIncomeMoney: {
					trigger:'focus'
				},
				ssp_monthlyPaidIncomeRate: {
					trigger:'focus'
				},
				ssp_monthlyPaidIncomeDesc: {
					trigger:'focus'
				}
			}
		});
		
		
		/* Tool tip */
	    /*$("#ssp_socialInsuranceRate_tooltip").tooltip();
	    $("#ssp_socialInsuranceAdditional_tooltip").tooltip(); */
	    
	    $("#ssp_totalWorkHours2").editable("dblclick", function(e) {
		});
	    $("#ssp_totalWorkDays2").editable("dblclick", function(e) {
		});
	    $("#ssp_baseSalaryHrs2").editable("dblclick", function(e) {
		});
	    $("#ssp_dailyMealSubsidy2").editable("dblclick", function(e) {
		});
	    $("#ssp_monthlyTransAllowance2").editable("dblclick", function(e) {
		});
	    $("#ssp_probationBaseRate2").editable("dblclick", function(e) {
		});
	    $("#ssp_minimumWage2").editable("dblclick", function(e) {
		});
	    $("#ssp_incomtaxThreshold2").editable("dblclick", function(e) {
		});
	    $("#ssp_pensionPersonal_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_pensionPersonal_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_pensionCompany_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_pensionCompany_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_medicalPersonal_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_medicalPersonal_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_medicalCompany_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_medicalCompany_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_accumFundPersonal_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_accumFundPersonal_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_accumFundCompany_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_accumFundCompany_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_unempInsuPersonal_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_unempInsuPersonal_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_unempInsuCompany_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_unempInsuCompany_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_occupInjurePersonal_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_occupInjurePersonal_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_occupInjureCompany_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_occupInjureCompany_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_maternityPersonal_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_maternityPersonal_Additional2").editable("dblclick", function(e) {
		});
	    $("#ssp_maternityCompany_Rate2").editable("dblclick", function(e) {
		});
	    $("#ssp_maternityCompany_Additional2").editable("dblclick", function(e) {
		});
	    
	    
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
		}); */
	    
		
		/*  // Dialog Simple
		$('#emptyDate_dialog').dialog({
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
		}); */
	    
	    $("#ssp_submitBaseSalaryProperties").click(function() {
	    	if($("#ssp_startDate2").val() == "" || $("#ssp_endDate2").val() == "") {
	    		/* $('#emptyDate_dialog').dialog('open'); */
	    		alert("should not be empty.");
			    return false;
	    	}
	    	if($("#ssp_totalWorkHours2").text() == "" || $("#ssp_totalWorkHours2").text() == "." ||
	    	   $("#ssp_totalWorkDays2").text() == "" || $("#ssp_totalWorkDays2").text() == "." ||
	    	   $("#ssp_baseSalaryHrs2").text() == "" || $("#ssp_baseSalaryHrs2").text() == "." ||
	    	   $("#ssp_dailyMealSubsidy2").text() == "" || $("#ssp_dailyMealSubsidy2").text() == "." ||
	    	   $("#ssp_monthlyTransAllowance2").text() == "" || $("#ssp_monthlyTransAllowance2").text() == "." ||
	    	   $("#ssp_probationBaseRate2").text() == "" || $("#ssp_probationBaseRate2").text() == "." ||
	    	   $("#ssp_minimumWage2").text() == "" || $("#ssp_minimumWage2").text() == "." ||
	    	   $("#ssp_incomtaxThreshold2").text() == "" || $("#ssp_incomtaxThreshold2").text() == "."
	    	) {
	    		/* $('#empty_dialog').dialog('open'); */
	    		alert("should not be empty.");
			    return false;
	    	}
	    	var params = {
	    	"operationFlag_tossp" : "updateBaseSalaryProperties",
   			"ssp_startDate2" : $("#ssp_startDate2").val(),
   			"ssp_endDate2" : $("#ssp_endDate2").val(),
   			"ssp_totalWorkHours2" : $("#ssp_totalWorkHours2").text(),
   			"ssp_totalWorkDays2" : $("#ssp_totalWorkDays2").text(),
   			"ssp_baseSalaryHrs2" : $("#ssp_baseSalaryHrs2").text(),
   			"ssp_dailyMealSubsidy2" : $("#ssp_dailyMealSubsidy2").text(),
   			"ssp_monthlyTransAllowance2" : $("#ssp_monthlyTransAllowance2").text(),
   			"ssp_probationBaseRate2" : $("#ssp_probationBaseRate2").text(),
   			"ssp_minimumWage2" : $("#ssp_minimumWage2").text(),
   			"ssp_incomtaxThreshold2" : $("#ssp_incomtaxThreshold2").text()
	    	};
	    	$.ajax({
	    		url : "saveSalarySettingAction",
	    		type : "post",
	    		data : params,
	    		success : function() {
					location.href = "salarySettingAction";	    			
	    		}
	    	});
	    	
	    });
	    
	    
	    $("#ssp_submitSocialInsurInfo").click(function() {
	    	if(
	    			$("#ssp_pensionPersonal_Rate2").text() == "" || $("#ssp_pensionPersonal_Rate2").text() == "." ||
	    			$("#ssp_pensionPersonal_Additional2").text() == "" || $("#ssp_pensionPersonal_Additional2").text() == "." ||
	    			$("#ssp_pensionCompany_Rate2").text() == "" || $("#ssp_pensionCompany_Rate2").text() == "." ||
	    			$("#ssp_pensionCompany_Additional2").text() == "" || $("#ssp_pensionCompany_Additional2").text() == "." ||
	    			$("#ssp_medicalPersonal_Rate2").text() == "" || $("#ssp_medicalPersonal_Rate2").text() == "." ||
	    			$("#ssp_medicalPersonal_Additional2").text() == "" || $("#ssp_medicalPersonal_Additional2").text() == "." ||
	    			$("#ssp_medicalCompany_Rate2").text() == "" || $("#ssp_medicalCompany_Rate2").text() == "." ||
	    			$("#ssp_medicalCompany_Additional2").text() == "" || $("#ssp_medicalCompany_Additional2").text() == "." ||
	    			$("#ssp_accumFundPersonal_Rate2").text() == "" || $("#ssp_accumFundPersonal_Rate2").text() == "." ||
	    			$("#ssp_accumFundPersonal_Additional2").text() == "" || $("#ssp_accumFundPersonal_Additional2").text() == "." ||
	    			$("#ssp_accumFundCompany_Rate2").text() == "" || $("#ssp_accumFundCompany_Rate2").text() == "." ||
	    			$("#ssp_accumFundCompany_Additional2").text() == "" || $("#ssp_accumFundCompany_Additional2").text() == "." ||
	    			$("#ssp_unempInsuPersonal_Rate2").text() == "" || $("#ssp_unempInsuPersonal_Rate2").text() == "." ||
	    			$("#ssp_unempInsuPersonal_Additional2").text() == "" || $("#ssp_unempInsuPersonal_Additional2").text() == "." ||
	    			$("#ssp_unempInsuCompany_Rate2").text() == "" || $("#ssp_unempInsuCompany_Rate2").text() == "." ||
	    			$("#ssp_unempInsuCompany_Additional2").text() == "" || $("#ssp_unempInsuCompany_Additional2").text() == "." ||
	    			$("#ssp_occupInjurePersonal_Rate2").text() == "" || $("#ssp_occupInjurePersonal_Rate2").text() == "." ||
	    			$("#ssp_occupInjurePersonal_Additional2").text() == "" || $("#ssp_occupInjurePersonal_Additional2").text() == "." ||
	    			$("#ssp_occupInjureCompany_Rate2").text() == "" || $("#ssp_occupInjureCompany_Rate2").text() == "." ||
	    			$("#ssp_occupInjureCompany_Additional2").text() == "" || $("#ssp_occupInjureCompany_Additional2").text() == "." ||
	    			$("#ssp_maternityPersonal_Rate2").text() == "" || $("#ssp_maternityPersonal_Rate2").text() == "." ||
	    			$("#ssp_maternityPersonal_Additional2").text() == "" || $("#ssp_maternityPersonal_Additional2").text() == "." ||
	    			$("#ssp_maternityCompany_Rate2").text() == "" || $("#ssp_maternityCompany_Rate2").text() == "." ||
	    			$("#ssp_maternityCompany_Additional2").text() == "" || $("#ssp_maternityCompany_Additional2").text() == "."
	    	) {
	    		/* $('#emptyDate_dialog').dialog('open'); */
	    		alert("should not be empty.");
			    return false;
	    	}
	    	
	    var params = {
   		"ssp_pensionPersonal_Rate2" : $("#ssp_pensionPersonal_Rate2").text(),
   		"ssp_pensionPersonal_Additional2" : $("#ssp_pensionPersonal_Additional2").text(),
   		"ssp_pensionCompany_Rate2" : $("#ssp_pensionCompany_Rate2").text(),
   		"ssp_pensionCompany_Additional2" : $("#ssp_pensionCompany_Additional2").text(),
   		"ssp_medicalPersonal_Rate2" : $("#ssp_medicalPersonal_Rate2").text(),
   		"ssp_medicalPersonal_Additional2" : $("#ssp_medicalPersonal_Additional2").text(),
   		"ssp_medicalCompany_Rate2" : $("#ssp_medicalCompany_Rate2").text(),
   		"ssp_medicalCompany_Additional2" : $("#ssp_medicalCompany_Additional2").text(),
   		"ssp_accumFundPersonal_Rate2" : $("#ssp_accumFundPersonal_Rate2").text(),
   		"ssp_accumFundPersonal_Additional2" : $("#ssp_accumFundPersonal_Additional2").text(),
   		"ssp_accumFundCompany_Rate2" : $("#ssp_accumFundCompany_Rate2").text(),
   		"ssp_accumFundCompany_Additional2" : $("#ssp_accumFundCompany_Additional2").text(),
   		"ssp_unempInsuPersonal_Rate2" : $("#ssp_unempInsuPersonal_Rate2").text(),
   		"ssp_unempInsuPersonal_Additional2" : $("#ssp_unempInsuPersonal_Additional2").text(),
   		"ssp_unempInsuCompany_Rate2" : $("#ssp_unempInsuCompany_Rate2").text(),
   		"ssp_unempInsuCompany_Additional2" : $("#ssp_unempInsuCompany_Additional2").text(),
   		"ssp_occupInjurePersonal_Rate2" : $("#ssp_occupInjurePersonal_Rate2").text(),
   		"ssp_occupInjurePersonal_Additional2" : $("#ssp_occupInjurePersonal_Additional2").text(),
   		"ssp_occupInjureCompany_Rate2" : $("#ssp_occupInjureCompany_Rate2").text(),
   		"ssp_occupInjureCompany_Additional2" : $("#ssp_occupInjureCompany_Additional2").text(),
   		"ssp_maternityPersonal_Rate2" : $("#ssp_maternityPersonal_Rate2").text(),
   		"ssp_maternityPersonal_Additional2" : $("#ssp_maternityPersonal_Additional2").text(),
   		"ssp_maternityCompany_Rate2" : $("#ssp_maternityCompany_Rate2").text(),
   		"ssp_maternityCompany_Additional2" : $("#ssp_maternityCompany_Additional2").text()
	    };
	    $.ajax({
    		url : "saveSocialInsurInfoAction",
    		type : "post",
    		data : params,
    		success : function() {
				location.href = "salarySettingAction";	    			
    		}
    	});
	    	
	    });
	    
	    
	   /*  $("#addNewIncomeTax").click(function() {
	    	alert("clicking..");
	    	$("#addNewIncomeTaxForm").submit();
	    }); */
	    
	    
	  /*  $(".deleteIncomeTax").click(function() {
	    	var incomTaxId = $(this).parent().parent().parent().parent().parent().children().first().text();
	    	
	    	var params = {
	    	"operationFlag_tossp" : "deleteIncomeTax",
   			"ssp_incomTaxId" : incomTaxId
	    	};
	    	$.ajax({
	    		url : "saveSalarySettingAction",
	    		type : "post",
	    		data : params,
	    		success : function() {
					location.href = "salarySettingAction";	    			
	    		}
	    	});
	    	
	    }); */
	    
	    
	});
	
</script>
</head>
<%
  	if(session.getAttribute("login") == null)  
  		request.getRequestDispatcher("login.jsp");
		/* response.sendRedirect("login.jsp");	 */	
  %>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>
						Salary Setting Page
					</h1>
				</div>
				<div class="row clearfix">
					<div class="col-md-6 column" style="width: 55%">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<h3>Salary Base Info</h3>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">
											Salary Monthly Setting
										</h3>
									</div>
									<div class="panel-body" style="padding: 5px;">
										<table class="table table-strip table-hover"
											style="font-size: 14px; margin-bottom: 5px;">
											<tbody>
												<tr>
													<td style="width: 160px;">Start Date:</td>
													<td><s:property value="#session.ssp_startDate" default="null" />
													</td>
													<td style="width:170px;">End Date:</td>
													<td><s:property value="#session.ssp_endDate" default="null"/>
													</td>
												</tr>
												<tr>
													<td>当月正常工作时长：</td>
													<td id=""><s:property value="#session.ssp_bsp.totalWorkHours" default="0" />&nbsp;&nbsp;hrs.
													</td>
													<td>当月正常工作天数：</td>
													<td id=""><s:property value="#session.ssp_bsp.totalWorkDays" default="0" />&nbsp;&nbsp;days.
													</td>
												</tr>
												<tr>
													<td>工作时长基数：</td>
													<td id="sip_monthlyBaseSalary"><s:property value="#session.ssp_bsp.baseSalaryHrs" default="0" />&nbsp;&nbsp;hrs.
													</td>
													<td>餐补(天)：</td>
													<td id=""><s:property value="#session.ssp_bsp.dailyMealSubsidy" default="0" />&nbsp;&nbsp;￥
													</td>
												</tr>
												<tr>
													<td>交通补贴(月)：</td>
													<td id="sip_monthlyBaseSalary"><s:property value="#session.ssp_bsp.monthlyTransAllowance" default="0" />&nbsp;&nbsp;￥
													</td>
													<td>试用期/转正 工资比：</td>
													<td id=""><s:property value="#session.ssp_bsp.probationBaseRate" default="0" />&nbsp;&nbsp;%
													</td>
												</tr>
												<tr>
													<td>最低工资：</td>
													<td id="sip_monthlyBaseSalary"><s:property value="#session.ssp_bsp.minimumWage" default="0" />&nbsp;&nbsp;￥
													</td>
													<td>个税起征点：</td>
													<td id=""><s:property value="#session.ssp_bsp.incomtaxThreshold" default="0" />&nbsp;&nbsp;￥
													</td>
												</tr>
												<%-- <tr>
													<td></td>
													<td></td>
													<td>With MBO</td>
													<td id=" "><s:property value="#session.ssp_bsp.withMBO" default="0" />&nbsp;&nbsp;￥
													</td>
												</tr> --%>
											</tbody>
										</table>
									</div>
									<div class="panel-footer" style="text-align: right;">
										<a id="modal-857800" href="#modal-container-857801"
											role="button" class="btn" data-toggle="modal"
											style="padding: 0px;"><button
												type="button" class="btn btn-primary btn-sm">Update</button>
										</a>
								</div>
								
								<div class="modal fade" id="modal-container-857801" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content" style="margin-top: 200px;">
										<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												Update Salary Monthly Setting
											</h4>
										</div>
										<div class="modal-body ssp_modal-body">
											<table class="table table-strip table-hover"
											style="font-size: 14px; margin-bottom: 5px;">
											<tbody>
												<tr>
													<td style="width: 160px;">Start Date:</td>
													<td id="ssp_startDate_td" style="padding: 0px;">
													<%-- <input type="text" class="form-control sip_form-control" style="color: #393939;" id="ssp_startDate2" 
														value="<s:property value="#session.ssp_startDate" default="null"/>"/> --%>
														
													<input type="text" value="<s:property value="#session.ssp_startDate" default="null"/>" class="form-control sip_form-control form_date" style="color: #393939;" id="ssp_startDate2" data-date-format="yyyy-mm-dd">
													
													</td>
													<td style="width:170px;">End Date:</td>
													<td id="ssp_startDate_td" style="padding: 0px;">
													<%-- <input type="text" class="form-control sip_form-control" style="color: #393939;" id="ssp_endDate2" 
														value="<s:property value="#session.ssp_endDate" default="null"/>"/> --%>
														
													<input type="text" value="<s:property value="#session.ssp_endDate" default="null"/>" 
													class="form-control sip_form-control form_date" style="color: #393939;" id="ssp_endDate2" data-date-format="yyyy-mm-dd">
													</td>
												</tr>
												<tr>
													<td>当月正常工作时长：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_totalWorkHours2">
													<s:property value="#session.ssp_bsp.totalWorkHours" default="0" /></span>
													</td>
													<td>当月正常工作天数：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_totalWorkDays2">
													<s:property value="#session.ssp_bsp.totalWorkDays" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>工作时长基数：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_baseSalaryHrs2">
													<s:property value="#session.ssp_bsp.baseSalaryHrs" default="0" /></span>
													</td>
													<td>餐补(天)：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_dailyMealSubsidy2">
													<s:property value="#session.ssp_bsp.dailyMealSubsidy" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>交通补贴(月)：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_monthlyTransAllowance2">
													<s:property value="#session.ssp_bsp.monthlyTransAllowance" default="0" /></span>
													</td>
													<td>试用期/转正 工资比：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_probationBaseRate2">
													<s:property value="#session.ssp_bsp.probationBaseRate" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>最低工资：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_minimumWage2">
													<s:property value="#session.ssp_bsp.minimumWage" default="0" /></span>
													</td>
													<td>个税起征点：</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_incomtaxThreshold2">
													<s:property value="#session.ssp_bsp.incomtaxThreshold" default="0"/></span>
													</td>
												</tr>
											</tbody>
										</table>
										</div>
										<div class="modal-footer">
											 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
											 <button type="button" class="btn btn-primary btn-sm" id="ssp_submitBaseSalaryProperties">Save</button>
										</div>
									</div>
									
								</div>
							</div>
							
							</div>
							</div>
							
						<div class="col-md-12 column" style="margin-top: 30px;">
							<h3>Income tax Info</h3>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">
											Personal income tax rate
										</h3>
									</div>
									<div class="panel-body" style="padding: 5px;">
										<table class="table table-strip table-hover tableCenter"
											style="font-size: 14px; margin-bottom: 5px; text-align: center;">
											<thead >
												<tr>
													<th style="width:50px; text-align: center;">ID</th>
													<th style="width:145px; text-align: center;">月应纳税所得额：</th>
													<th style="text-align: center;">税率(%)</th>
													<th style="text-align: center;">描述：</th>
													
												</tr>
											</thead>
											<tbody>
											<s:iterator var="ssp_incomTax_Itor" value="#session.ssp_incomTaxList">
												<tr>
													<td><s:property value="#ssp_incomTax_Itor.incomtaxId"/></td>
													<td><s:property value="#ssp_incomTax_Itor.incomtaxValue"/></td>
													<td><s:property value="#ssp_incomTax_Itor.incomtaxRate"/></td>
													<td><s:property value="#ssp_incomTax_Itor.incomtaxDesc"/></td>
													<td>
													
													<td>
														<a href="#modal-container-editIncomTax"  class="btn editIncomeTaxBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
													</td>
													<td>
														<a href="#modal-container-deleteIncomTax" class="btn deleteIncomeTaxBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
													</td>
													<!-- 
													Single button
													<div class="btn-group">
													  <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
													    Action <span class="caret"></span>
													  </button>
													  <ul class="dropdown-menu" role="menu" style="width: 90px;">
													    <li><a href="#" style="width: 88px; padding-left: 5px; padding-right: 5px;">Edit</a></li>
													    <li><a style="width: 88px; padding-left: 5px; padding-right: 5px;" class="deleteIncomeTax">Delete</a></li>
													  </ul>
													</div>
													 -->
													<!-- </td> -->
												</tr>
											</s:iterator>
											</tbody>
										</table>
									</div>
									<div class="panel-footer" style="text-align: right;">
										<a id="modal-857802" href="#modal-container-addIncomTax"
											role="button" class="btn" data-toggle="modal"
											style="padding: 0px;" ><button
												type="button" class="btn btn-primary btn-sm">Add a New</button>
												</a>
							</div>
						</div>
						</div>
						
						</div>
					</div>
					<div class="col-md-6 column" style="width: 45%">
						<div class="row clearfix">
							<div class="col-md-12 column">
							<h3>Social Insurance Info</h3>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h3 class="panel-title">
											Social Insurance Rate
										</h3>
									</div>
									<div class="panel-body" style="padding: 5px;">
										<table class="table table-strip table-hover"
											style="font-size: 14px; margin-bottom: 5px; text-align: center;">
											<thead>
												<tr>
													<th style="text-align: center;">ID</th>
													<th style="text-align: center;">Item：</th>
													<th style="text-align: center;"><span id="ssp_socialInsuranceRate_tooltip" title="占个人社保基数百分比。">Rate(%)</th>
													<th style="text-align: center;"><span id="ssp_socialInsuranceAdditional_tooltip" title="正数为加，负数为减。如：10， 则 SocialInsuranceBase * SocialInsuranceRate + 10。">Additional:</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>养老保险(个人)</td>
													<td><s:property value="#session.ssp_pensionPersonal.bsiRate" default="0" /></td>
													<td><s:property value="#session.ssp_pensionPersonal.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>2</td>
													<td>养老保险(公司)</td>
													<td><s:property value="#session.ssp_pensionCompany.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_pensionCompany.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>3</td>
													<td>医疗保险(个人)</td>
													<td><s:property value="#session.ssp_medicalPersonal.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_medicalPersonal.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>4</td>
													<td>医疗保险(公司)</td>
													<td><s:property value="#session.ssp_medicalCompany.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_medicalCompany.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>5</td>
													<td>公积金(个人)</td>
													<td><s:property value="#session.ssp_accumFundPersonal.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_accumFundPersonal.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>6</td>
													<td>公积金(公司)</td>
													<td><s:property value="#session.ssp_accumFundCompany.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_accumFundCompany.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>7</td>
													<td>失业保险(个人)</td>
													<td><s:property value="#session.ssp_unempInsuPersonal.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_unempInsuPersonal.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>8</td>
													<td>失业保险(公司)</td>
													<td><s:property value="#session.ssp_unempInsuCompany.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_unempInsuCompany.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>9</td>
													<td>工伤保险(个人)</td>
													<td><s:property value="#session.ssp_occupInjurePersonal.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_occupInjurePersonal.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>10</td>
													<td>工伤保险(公司)</td>
													<td><s:property value="#session.ssp_occupInjureCompany.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_occupInjureCompany.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>11</td>
													<td>生育保险(人)</td>
													<td><s:property value="#session.ssp_maternityPersonal.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_maternityPersonal.bsiAdditional" default="0" /></td>
												</tr>
												<tr>
													<td>12</td>
													<td>生育保险(公司)</td>
													<td><s:property value="#session.ssp_maternityCompany.bsiRate" default="0"/></td>
													<td><s:property value="#session.ssp_maternityCompany.bsiAdditional" default="0" /></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="panel-footer" style="text-align: right;">
										<a id="modal-857803" href="#modal-container-857803"
											role="button" class="btn" data-toggle="modal"
											style="padding: 0px;"><button
												type="button" class="btn btn-primary btn-sm">Update</button>
										</a>
									</div>
							<div class="modal fade" id="modal-container-857803" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content" style="margin-top: 100px; margin-left: 40px; margin-right: 40px;">
										<div class="modal-header">
											 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">
												Update Social Insurance parameters
											</h4>
										</div>
										<div class="modal-body  ssp_modal-body">
											<table class="table table-strip table-hover"
											style="font-size: 14px; margin-bottom: 5px; text-align: center;">
											<thead>
												<tr>
													<th style="text-align: center; ">ID</th>
													<th style="text-align: center; width: 180px;">Item：</th>
													<th style="text-align: center; width: 100px;">Rate(%)</th>
													<th style="text-align: center; width: 100px;">Additional：</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>养老保险(个人)</td>
													<td style="padding: 0px;" >
													<span class="form-control sip_form-control"	id="ssp_pensionPersonal_Rate2">
													<s:property value="#session.ssp_pensionPersonal.bsiRate" default="0" /></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_pensionPersonal_Additional2">
													<s:property value="#session.ssp_pensionPersonal.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>2</td>
													<td>养老保险(公司)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_pensionCompany_Rate2">
													<s:property value="#session.ssp_pensionCompany.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_pensionCompany_Additional2">
													<s:property value="#session.ssp_pensionCompany.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>3</td>
													<td>医疗保险(个人)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_medicalPersonal_Rate2">
													<s:property value="#session.ssp_medicalPersonal.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_medicalPersonal_Additional2">
													<s:property value="#session.ssp_medicalPersonal.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>4</td>
													<td>医疗保险(公司)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_medicalCompany_Rate2">
													<s:property value="#session.ssp_medicalCompany.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_medicalCompany_Additional2">
													<s:property value="#session.ssp_medicalCompany.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>5</td>
													<td>公积金(个人)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_accumFundPersonal_Rate2">
													<s:property value="#session.ssp_accumFundPersonal.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_accumFundPersonal_Additional2">
													<s:property value="#session.ssp_accumFundPersonal.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>6</td>
													<td>公积金(公司)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_accumFundCompany_Rate2">
													<s:property value="#session.ssp_accumFundCompany.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_accumFundCompany_Additional2">
													<s:property value="#session.ssp_accumFundCompany.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>7</td>
													<td>失业保险(个人)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_unempInsuPersonal_Rate2">
													<s:property value="#session.ssp_unempInsuPersonal.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_unempInsuPersonal_Additional2">
													<s:property value="#session.ssp_unempInsuPersonal.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>8</td>
													<td>失业保险(公司)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_unempInsuCompany_Rate2">
													<s:property value="#session.ssp_unempInsuCompany.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_unempInsuCompany_Additional2">
													<s:property value="#session.ssp_unempInsuCompany.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>9</td>
													<td>工伤保险(个人)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_occupInjurePersonal_Rate2">
													<s:property value="#session.ssp_occupInjurePersonal.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_occupInjurePersonal_Additional2">
													<s:property value="#session.ssp_occupInjurePersonal.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>10</td>
													<td>工伤保险(公司)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_occupInjureCompany_Rate2">
													<s:property value="#session.ssp_occupInjureCompany.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_occupInjureCompany_Additional2">
													<s:property value="#session.ssp_occupInjureCompany.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>11</td>
													<td>生育保险(人)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_maternityPersonal_Rate2">
													<s:property value="#session.ssp_maternityPersonal.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_maternityPersonal_Additional2">
													<s:property value="#session.ssp_maternityPersonal.bsiAdditional" default="0" /></span>
													</td>
												</tr>
												<tr>
													<td>12</td>
													<td>生育保险(公司)</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_maternityCompany_Rate2">
													<s:property value="#session.ssp_maternityCompany.bsiRate" default="0"/></span>
													</td>
													<td style="padding: 0px;">
													<span class="form-control sip_form-control"	id="ssp_maternityCompany_Additional2">
													<s:property value="#session.ssp_maternityCompany.bsiAdditional" default="0" /></span>
													</td>
												</tr>
											</tbody>
										</table>
										</div>
										<div class="modal-footer">
											 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> <button type="button" class="btn btn-primary btn-sm" id="ssp_submitSocialInsurInfo">Save</button>
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
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column"></div>
		</div>
	
	<!-- INCOME PART -->
	<!-- Edit -->
	<div class="modal fade" id="modal-container-editIncomTax" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						Edit Income Tax
					</h4>
				</div>
				<form id="editIncomeTaxForm" action="saveSalarySettingAction" role="form">
				<div class="modal-body">
				<input type="hidden" name="operationFlag_tossp" value="editIncomTax">
				<input type="hidden" name="ssp_editIncomTax_Id" id="ssp_editIncomTax_Id"/>
					<div class="form-group">
						 <label>月应纳税所得额:</label>
						 <input name="ssp_editIncomTaxMoney" style="width: 200px;" type="text" class="form-control red-tooltip" id="ssp_editIncomTaxMoney" />
					</div>
					<div class="form-group">
						 <label>税率:</label>
						 <input name="ssp_editIncomTaxRate" style="width: 200px;" type="text" class="form-control red-tooltip" id="ssp_editIncomTaxRate" />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						<textarea name="ssp_editIncomTaxDesc" id="ssp_editIncomTaxDesc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
					 <button id="addNewIncomeTax" type="submit" class="btn btn-primary btn-sm">Save</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete -->
	<div class="modal fade" id="modal-container-deleteIncomTax" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						Delete
					</h4>
				</div>
				<form id="deleteIncomeTaxForm" action="saveSalarySettingAction" role="form" accept-charset="utf-8">
					<input type="hidden" name="operationFlag_tossp" value="deleteIncomTax">
					<input type="hidden" name="ssp_deleteIncomTax_Id" id="ssp_deleteIncomTax_Id"/>
				<div class="modal-body">
					Do you really want to delete "<span id="deleteIncomTax"></span>"?
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
					 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
				</div>
				</form>
			</div>
			
		</div>
	</div>
	
	<!-- Add -->
	<div class="modal fade" id="modal-container-addIncomTax" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 25%;">
		<div class="modal-content" >
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Update Income tax parameters
				</h4>
			</div>
			<form id="addNewIncomeTaxForm" action="saveSalarySettingAction" role="form">
			<div class="modal-body">
			<input type="hidden" name="operationFlag_tossp" value="addNewIncomTax">
				<div class="form-group">
					 <label>月应纳税所得额:</label>
					 <input name="ssp_monthlyPaidIncomeMoney" style="width: 200px;" type="text" class="form-control red-tooltip" id="" />
				</div>
				<div class="form-group">
					 <label>税率:</label>
					 <input name="ssp_monthlyPaidIncomeRate" style="width: 200px;" type="text" class="form-control red-tooltip" id="" />
				</div>
				<div class="form-group">
					 <label>Description:</label>
					<textarea name="ssp_monthlyPaidIncomeDesc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
				</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button id="addNewIncomeTax" type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
</body>
</html>
