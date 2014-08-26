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

<title>My Payroll Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet"/>
<link href="css/style_new.css" rel="stylesheet" />
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
				<div class="row clearfix">
					<div class="column col-md-3">
					</div>
					<div class="col-md-6 column">
						<h3 style="margin-top: 0px;">My Payroll</h3>
						<div class="panel panel-primary">
							<div class="panel-heading" >
								<h3 class="panel-title" >
									Payroll
								</h3>
							</div>
							<div class="panel-body" style="padding-top: 5px; padding-top: 20px;">
								<table class="table table-without-firstrow-border">
									<tr>
										<td class="col-md-2" style="border: none;">
										
										</td>
										<td class="col-md-4" style="text-align: right; border: none;">
											Month : &nbsp;&nbsp;&nbsp;&nbsp;
										</td>
										<td class="empselect_request col-md-4" style="padding: 2px; border: none;" >
											<select id="mypayroll_month" class="selectpicker" data-live-search="true" >
											    <s:iterator var="monthItor" value="#session.mypayroll_months">
											   		<option 
											   			<s:if test="#session.mypayroll_pr.month==#monthItor">selected="selected"</s:if>
											   		value="<s:property value='#monthItor'/>"><s:property value="#monthItor"/></option>
											   	</s:iterator>
											 </select>
										</td>
										<td class="col-md-1" style="border: none;">
										</td>
									</tr>
								</table>
							
								<table class="table  table-strip table-hover table-without-firstrow-border"
									style="font-size: 14px;">
									<tbody>
										<tr>
											<td style="width: 120px;">工作时间：</td>
											<td id="sip_monthlyworkhours" style="width: 141px;" ><s:property
													value="#session.mypayroll_pr.totalWorkHrs" default="0" />&nbsp;&nbsp;hrs.</td>
											<td style="width: 120px;">加班时间：</td>
											<td id="sip_monthlyovertimehours" style="width: 142px;" >
											<s:property	value="#session.mypayroll_pr.overtime" default="0" />&nbsp;&nbsp;hrs.
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
											<td id="sip_monthlyBaseSalary"><s:property value="#session.mypayroll_pr.baseSalary" default="0" />
											</td>
											<td>季度奖金：</td>
											<td id="sip_quarterlyBonus"><s:property value="#session.mypayroll_pr.quartBonus" default="0" />
											</td>
										</tr>
										<tr>
											<td>岗位津贴：</td>
											<td id="sip_postAllowance"><s:property value="#session.mypayroll_pr.postAllowance" default="0"/></td>
											<td>交通津贴：</td>
											<td id="sip_transAllowance"><s:property value="#session.mypayroll_pr.transportAllowance" default="0"/>
											</td>
										</tr>
										<tr>
											<td>奖励：</td>
											<td id="sip_Bonus"><s:property value="#session.mypayroll_pr.bonus" default="0"/></td>
											<td>餐补：</td>
											<td id="sip_mealSubsidy"><s:property value="#session.mypayroll_pr.mealSubsidy" default="0"/></td>
										</tr>
										<tr>
											<td>加班费：</td>
											<td id="sip_overTimePay"><s:property value="#session.mypayroll_pr.overtimePay" default="0"/></td>
											<td>Adjustment:</td>
											<td id="sip_otherPay"><s:property value="#session.mypayroll_pr.otherPay" default="0"/></td>
										</tr>
										<tr>
											<td>Note：</td>
											<td id="sip_otherPayNote" colspan="3"><s:property value="#session.mypayroll_pr.payrollNote" default=""/></td>
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
											<td id="pension_Personal"><s:property value="#session.mypayroll_pr.pensionPersonal" default="0"/>
											</td>
											<td>养老保险：</td>
											<td id="pension_Company"><s:property value="#session.mypayroll_pr.pensionCompany" default="0"/></td>
										</tr>
										<tr>
											<td>医疗保险：</td>
											<td id="medical_Personal"><s:property value="#session.mypayroll_pr.medicalPersonal" default="0"/>
											</td>
											<td>医疗保险：</td>
											<td id="medical_Company"><s:property value="#session.mypayroll_pr.medicalCompany" default="0"/></td>
										</tr>
										<tr>
											<td>公积金：</td>
											<td id="accum_Fund_Personal"><s:property value="#session.mypayroll_pr.accumFundPersonal" default="0"/>
											</td>
											<td>公积金：</td>
											<td id="accum_Fund_Company"><s:property value="#session.mypayroll_pr.accumFundCompany" default="0"/>
											</td>
										</tr>
										<tr>
											<td>失业保险：</td>
											<td id="unemp_Insu_Personal"><s:property value="#session.mypayroll_pr.unempInsuPersonal" default="0"/>
											</td>
											<td>失业保险：</td>
											<td id="unemp_Insu_Company"><s:property value="#session.mypayroll_pr.unempInsuCompany" default="0"/>
											</td>
										</tr>
										<tr>
											<td>本月扣税：</td>
											<td id="sip_incomtax"><s:property value="#session.mypayroll_pr.incomeTax" default="0"/>
											</td>
											<td>工伤生育保险：</td>
											<td id="occupInjure_maternity_Company"><s:property
													value="#session.mypayroll_pr.occupInjureMaternity" default="0"/></td>
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
							<div class="panel-footer">
							</div>
						</div>
					</div>
					
					<div class="column col-md-3">
					</div>
				</div>
			</div>
		</div>
	</div>
	
<s:debug/>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/script_new.js"></script>
<script type="text/javascript">
$(function(){
	$(".selectpicker").selectpicker();

	calculate();
	
	$("#mypayroll_month").change(function() {
		var month = {
			"mypayroll_month" : $(this).val()
		};
		
		$.ajax({
			url: "getMyPayrollByMonth",
			type: "post",
			data: month,
			dataType: "json",
			success: function(payroll) {
				init(payroll);
			},
			error: function() {
				alert("获取getMyPayrollByMonth信息失败！");
			}
			
		})
		
	});
	
	function calculate() {
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
	};
	
	function init(data) {
		// 基础工资部分
		$("#sip_monthlyworkhours").text(data.payrollrecord.totalWorkHrs + " hrs.");
		$("#sip_monthlyovertimehours").text(data.payrollrecord.overtime + " hrs.");
		$("#sip_monthlyBaseSalary").text(data.payrollrecord.baseSalary);
		$("#sip_quarterlyBonus").text(data.payrollrecord.quartBonus);
		$("#sip_transAllowance").text(data.payrollrecord.transportAllowance);
		$("#sip_Bonus").text(data.payrollrecord.bonus);
		$("#sip_mealSubsidy").text(data.payrollrecord.mealSubsidy);
		$("#sip_overTimePay").text(data.payrollrecord.overtimePay);
		$("#sip_otherPay").text(data.payrollrecord.otherPay);
		$("#sip_otherPayNote").text(data.payrollrecord.payrollNote);
		
		
		// 个人部分
		$("#pension_Personal").text(data.payrollrecord.pensionPersonal);
		$("#medical_Personal").text(data.payrollrecord.medicalPersonal);
		$("#accum_Fund_Personal").text(data.payrollrecord.accumFundPersonal);
		$("#unemp_Insu_Personal").text(data.payrollrecord.unempInsuPersonal);
		$("#sip_incomtax").text(data.payrollrecord.incomeTax);
		
		
		// 公司部分
		$("#pension_Company").text(data.payrollrecord.pensionCompany);
		$("#medical_Company").text(data.payrollrecord.medicalCompany);
		$("#accum_Fund_Company").text(data.payrollrecord.accumFundCompany);
		$("#unemp_Insu_Company").text(data.payrollrecord.unempInsuCompany);
		$("#occupInjure_maternity_Company").text(data.payrollrecord.occupInjureMaternity);
		
		calculate();	// 计算总计部分
	};
	
});
</script>
</html>
