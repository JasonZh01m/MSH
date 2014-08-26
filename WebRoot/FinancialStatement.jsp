<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Financial Statement</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="css/select2.css" />
<link href="css/style2.css" rel="stylesheet"/>
<style type="text/css">
		#flotTip 
		{
			padding: 3px 5px;
			background-color: #000;
			z-index: 100;
			color: #fff;
			box-shadow: 0 0 10px #555;
			opacity: 0.65;
			filter: alpha(opacity=70);
			border: 0px solid #fff;
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
		}
		.bootstrap-select {
			width: 180px;
		}
		
		.tableA td {
		text-align: center;
		word-break: keep-all;
		white-space:nowrap;
		}
		.tableA th {
			text-align: center;
			word-break: keep-all;
			white-space:nowrap;
		}
		
		.red-tooltip + .tooltip > .tooltip-inner{background-color: #FF6633;}
		.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #FF6633;}
		
	</style>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.categories.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.tooltip.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript" src="js/select2.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript">
	$(function () {
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
		
		$("#fsfilter_submitPayroll").click(function() {
		alert("click..." + $("#fsip_startDate").val().trim() + "\t" + $("#fsip_endDate").val().trim());
		var params = {
			"fsip_startDate" : $("#fsip_startDate").val().trim(),
			"fsip_endDate" : $ ("#fsip_endDate").val().trim()
		};
		
		$.ajax({
				url : "exportExcelAction_Payroll",
				type : "post",
				data : params,
				success : function() {
					 /* location.href = "salaryInfoAction"; */
				}
			});
		});
		
		/* var piedata = $("#fsip_piedata").val(); */
		/* var bardata = $("#fsip_bardata").val();
		var ticks = $("#fsip_ticks").val(); */
		/* alert(piedata);
		alert(bardata);
		alert(ticks); */
		
		/* $("#tooltipshow1").tooltip(); */
		/* $('#tooltipshow1').tooltip(); */
	
		<%-- <%
	      String fsip_piedata = "";
	      String fsip_bardata = "";
	      String fsip_ticks = "";
	      
	      if(session.getAttribute("piedata") != null && session.getAttribute("bardata") != null &&  session.getAttribute("ticks") != null ) {
	      		fsip_piedata = (String) session.getAttribute("fsip_piedata");
	      		fsip_bardata = (String) session.getAttribute("fsip_bardata");
	      		fsip_ticks = (String) session.getAttribute("fsip_ticks");
	      };
		%> --%>
	
		<%-- var piedata = <%=fsip_piedata%> --%>
		/* var piedata = $("#fsip_piedata").val(); */
		var piedata = <s:property value="#session.fsip_piedata" default="[{ label: 'Series 0', data: 1 }];"/>
		/* [
			{ label: "Series 0", data: 1 },
			{ label: "Series 1", data: 3 },
			{ label: "Series 2", data: 9 },
			{ label: "Series 3", data: 10 },
			{ label: "Series 4", data: 10 },
			{ label: "Series 5", data: 10 },
			{ label: "Series 10", data: 10 }
		]; */

		$.plot($("#pie_placeholder"), piedata, {
			series: {
				pie: {
					show: true
				}
			},
			grid: {
				hoverable: true 
			},
			tooltip: true,
			tooltipOpts: {
				content: "%p.2%, %s", // show percentages, rounding to 2 decimal places
				shifts: {
					x: 20,
					y: 0
				},
				defaultTheme: false
			}
		});
		

	/* var data = [
		{data: [[0, 1]]},
        {data: [[1, 1]]},
        {data: [[2, 2],[3, 2]]},
        {data: [[4, 2]]},
        {data: [[5, 4],[6, 7]]},
        {data: [[7, 1]]}
    ]; */
    	
    	
  	 var bardata = <s:property value="#session.fsip_bardata" default="[{data: [[0, 1]]}]"/>
    /*  [
		{data: [[0, 1]]},
        {data: [[1, 1]]},
        {data: [[2, 2]]},
        {data: [[3, 2]]},
        {data: [[4, 2]]},
        {data: [[5, 4],[6, 7]]},
        {data: [[7, 1]]}
    ]; */ 

	$.plot($("#bargraph_placeholder2"), bardata, {
		series: {
			lines: {
				fill: true,
			},
			bars: {
				show: true,
				align:'center',
				barWidth: 0.6,
			}	
		},
		xaxis: {
			<%-- ticks: <%=fsip_ticks%> --%>
			/* ticks: ticks */
           	ticks: <s:property value="#session.fsip_ticks" default="[[0, 'A']]"/>
            //ticks: [[0, "A"],[1, "B"],[2, "C"],[3, "D"],[4, "E"],[5, "F"],[6, "G"],[7, "H"]]
		},
		yaxis: {
			min: 0
		},
		grid: {
				hoverable: true 
		},
		tooltip: true,
			tooltipOpts: {
				content: "%y.2", 
				shifts: {
					x: 20,
					y: 0
				},
				defaultTheme: false
			}
		});
		
		/* $("#customizedDiv").hide(); */
		 /* $("#filterOption").change(function() {
			alert("click...");		 	
		 }); */
		$("#filterOption").on("change", function() {
		  	if(this.value == "3") {
		  		$("#customizedDiv").show();
		  	} else {
				$("#customizedDiv").hide();	  		
		  	}
		 });
		 
		 //Bonus check
		 $("#fsip_bonus").change(function() {
            if (!$("#fsip_bonus").attr("checked")) {
             	$("#fsip_bonus").attr("checked", "checked"); 
         		$(".fsip_bonus_table").show();
            }else if($("#fsip_bonus").attr("checked")){
            	$("#fsip_bonus").removeAttr("checked");
            	$(".fsip_bonus_table").hide();
            }
        });
		 
		 //month base salary
		 $("#fsip_monthBaseSalary").change(function() {
            if (!$("#fsip_monthBaseSalary").attr("checked")) {
             	$("#fsip_monthBaseSalary").attr("checked", "checked"); 
         		$(".fsip_monthBaseSalary_table").show();
            }else if($("#fsip_monthBaseSalary").attr("checked")){
            	$("#fsip_monthBaseSalary").removeAttr("checked");
            	$(".fsip_monthBaseSalary_table").hide();
            }
        });
		 
		 //adjustment
		 $("#fsip_adjustment").change(function() {
            if (!$("#fsip_adjustment").attr("checked")) {
             	$("#fsip_adjustment").attr("checked", "checked"); 
         		$(".fsip_adjustment_table").show();
            }else if($("#fsip_adjustment").attr("checked")){
            	$("#fsip_adjustment").removeAttr("checked");
            	$(".fsip_adjustment_table").hide();
            }
        });
		
		// quar bonus
		$("#fsip_quarBonus").change(function() {
            if (!$("#fsip_quarBonus").attr("checked")) {
             	$("#fsip_quarBonus").attr("checked", "checked"); 
         		$(".fsip_quarBonus_table").show();
            }else if($("#fsip_quarBonus").attr("checked")){
            	$("#fsip_quarBonus").removeAttr("checked");
            	$(".fsip_quarBonus_table").hide();
            }
        });

		//Overtime pay
		$("#fsip_overtimePay").change(function() {
            if (!$("#fsip_overtimePay").attr("checked")) {
             	$("#fsip_overtimePay").attr("checked", "checked"); 
         		$(".fsip_overtimePay_table").show();
            }else if($("#fsip_overtimePay").attr("checked")){
            	$("#fsip_overtimePay").removeAttr("checked");
            	$(".fsip_overtimePay_table").hide();
            }
        });
		
		// Meal subsidy
		$("#fsip_mealSubsidy").change(function() {
            if (!$("#fsip_mealSubsidy").attr("checked")) {
             	$("#fsip_mealSubsidy").attr("checked", "checked"); 
         		$(".fsip_mealSubsidy_table").show();
            }else if($("#fsip_mealSubsidy").attr("checked")){
            	$("#fsip_mealSubsidy").removeAttr("checked");
            	$(".fsip_mealSubsidy_table").hide();
            }
        });

		//commuting allowance
		$("#fsip_cummutingAllowance").change(function() {
            if (!$("#fsip_cummutingAllowance").attr("checked")) {
             	$("#fsip_cummutingAllowance").attr("checked", "checked"); 
         		$(".fsip_cummutingAllowance_table").show();
            }else if($("#fsip_cummutingAllowance").attr("checked")){
            	$("#fsip_cummutingAllowance").removeAttr("checked");
            	$(".fsip_cummutingAllowance_table").hide();
            }
        });

		
		//salary in payroll
		$("#fsip_salaryInPayroll").change(function() {
            if (!$("#fsip_salaryInPayroll").attr("checked")) {
             	$("#fsip_salaryInPayroll").attr("checked", "checked"); 
         		$(".fsip_salaryInPayroll_table").show();
            }else if($("#fsip_salaryInPayroll").attr("checked")){
            	$("#fsip_salaryInPayroll").removeAttr("checked");
            	$(".fsip_salaryInPayroll_table").hide();
            }
        });

		//net salary
		$("#fsip_netSalary").change(function() {
            if (!$("#fsip_netSalary").attr("checked")) {
             	$("#fsip_netSalary").attr("checked", "checked"); 
         		$(".fsip_netSalary_table").show();
            }else if($("#fsip_netSalary").attr("checked")){
            	$("#fsip_netSalary").removeAttr("checked");
            	$(".fsip_netSalary_table").hide();
            }
        });

		//medical Ins personal
		$("#fsip_medicalInsPerson").change(function() {
            if (!$("#fsip_medicalInsPerson").attr("checked")) {
             	$("#fsip_medicalInsPerson").attr("checked", "checked"); 
         		$(".fsip_medicalInsPerson_table").show();
            }else if($("#fsip_medicalInsPerson").attr("checked")){
            	$("#fsip_medicalInsPerson").removeAttr("checked");
            	$(".fsip_medicalInsPerson_table").hide();
            }
        });
		
		//medical Ins Company
		$("#fsip_medicalInsCom").change(function() {
            if (!$("#fsip_medicalInsCom").attr("checked")) {
             	$("#fsip_medicalInsCom").attr("checked", "checked"); 
         		$(".fsip_medicalInsCom_table").show();
            }else if($("#fsip_medicalInsCom").attr("checked")){
            	$("#fsip_medicalInsCom").removeAttr("checked");
            	$(".fsip_medicalInsCom_table").hide();
            }
        });

		//social Ins Personal
		$("#fsip_socialInsPerson").change(function() {
            if (!$("#fsip_socialInsPerson").attr("checked")) {
             	$("#fsip_socialInsPerson").attr("checked", "checked"); 
         		$(".fsip_socialInsPerson_table").show();
            }else if($("#fsip_socialInsPerson").attr("checked")){
            	$("#fsip_socialInsPerson").removeAttr("checked");
            	$(".fsip_socialInsPerson_table").hide();
            }
        });

		//social Ins Company
		$("#fsip_socialInsCom").change(function() {
            if (!$("#fsip_socialInsCom").attr("checked")) {
             	$("#fsip_socialInsCom").attr("checked", "checked"); 
         		$(".fsip_socialInsCom_table").show();
            }else if($("#fsip_socialInsCom").attr("checked")){
            	$("#fsip_socialInsCom").removeAttr("checked");
            	$(".fsip_socialInsCom_table").hide();
            }
        });

		//tax
		$("#fsip_tax").change(function() {
            if (!$("#fsip_tax").attr("checked")) {
             	$("#fsip_tax").attr("checked", "checked"); 
         		$(".fsip_tax_table").show();
            }else if($("#fsip_tax").attr("checked")){
            	$("#fsip_tax").removeAttr("checked");
            	$(".fsip_tax_table").hide();
            }
        });

		//hous Fund Person
		$("#fsip_housFundPerson").change(function() {
            if (!$("#fsip_housFundPerson").attr("checked")) {
             	$("#fsip_housFundPerson").attr("checked", "checked"); 
         		$(".fsip_housFundPerson_table").show();
            }else if($("#fsip_housFundPerson").attr("checked")){
            	$("#fsip_housFundPerson").removeAttr("checked");
            	$(".fsip_housFundPerson_table").hide();
            }
        });

		// house fund Company
		$("#fsip_housFundCom").change(function() {
            if (!$("#fsip_housFundCom").attr("checked")) {
             	$("#fsip_housFundCom").attr("checked", "checked"); 
         		$(".fsip_housFundCom_table").show();
            }else if($("#fsip_housFundCom").attr("checked")){
            	$("#fsip_housFundCom").removeAttr("checked");
            	$(".fsip_housFundCom_table").hide();
            }
        });

		// payroll total
		$("#fsip_payrollTotal").change(function() {
            if (!$("#fsip_payrollTotal").attr("checked")) {
             	$("#fsip_payrollTotal").attr("checked", "checked"); 
         		$(".fsip_payrollTotal_table").show();
            }else if($("#fsip_payrollTotal").attr("checked")){
            	$("#fsip_payrollTotal").removeAttr("checked");
            	$(".fsip_payrollTotal_table").hide();
            }
        });
		
		// MBO monthly portion
		$("#fsip_MBOMonPor").change(function() {
            if (!$("#fsip_MBOMonPor").attr("checked")) {
             	$("#fsip_MBOMonPor").attr("checked", "checked"); 
         		$(".fsip_MBOMonPor_table").show();
            }else if($("#fsip_MBOMonPor").attr("checked")){
            	$("#fsip_MBOMonPor").removeAttr("checked");
            	$(".fsip_MBOMonPor_table").hide();
            }
        });
		
		//annual Bonus monthly portion
		$("#fsip_annuBonusMonPor").change(function() {
            if (!$("#fsip_annuBonusMonPor").attr("checked")) {
             	$("#fsip_annuBonusMonPor").attr("checked", "checked"); 
         		$(".fsip_annuBonusMonPor_table").show();
            }else if($("#fsip_annuBonusMonPor").attr("checked")){
            	$("#fsip_annuBonusMonPor").removeAttr("checked");
            	$(".fsip_annuBonusMonPor_table").hide();
            }
        });

		 // Total check
		 $("#fsip_total").change(function() {
            if (!$("#fsip_total").attr("checked")) {
             	$("#fsip_total").attr("checked", "checked"); 
         		$(".fsip_total_table").show();
            }else if($("#fsip_total").attr("checked")){
            	$("#fsip_total").removeAttr("checked");
            	$(".fsip_total_table").hide();
            }
        });
		 
		 $("#financialStatementFilterForm").validate({
	        	rules: {
	        		fsip_startDate: {
	        			required: true,
						dateISO: true
	        		},
	        		fsip_endDate: {
	        			required: true,
	        			dateISO: true
	        		}
	        	},
	        	tooltip_options: {
	        		fsip_startDate: {
	        			trigger: 'focus'
	        		},
	        		fsip_endDate: {
	        			trigger: 'focus'
	        		}
	        	},
	        	message: {
	        		fsip_startDate: {
						dateISO: "Please enter a valid date! (e.g 2014-02-14)"
					},
					fsip_endDate: {
						dateISO: "Please enter a valid date! (e.g 2014-02-14)" 
					},
	        	}
	        });	 
	
	
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
					Financial Statement Info Page
				</h1>
				<%-- <input type="hidden" id="fsip_piedata" value='<s:property value="#session.fsip_piedata"/>'>
				<input type="hidden" id="fsip_bardata" value='<s:property value="#session.fsip_bardata"/>'>
				<input type="hidden" id="fsip_ticks" value='<s:property value="#session.fsip_ticks"/>'> --%>
			</div>
			<form id="financialStatementFilterForm" action="financialStatementAction" method="post">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-3 column">
							 <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">Start Date:</span>
				                    <input id="fsip_startDate" class="form-control red-tooltip" name="fsip_startDate" data-date-format="yyyy-mm-dd" type="text" value="<s:property value="#session.fsip_startDate" default=""/>" placeholder="Start Date">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
						</div>
						<div class="col-md-3 column">
							 <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">End Date:</span>
				                    <input id="fsip_endDate" class="form-control red-tooltip" name="fsip_endDate" data-date-format="yyyy-mm-dd" type="text" value="<s:property value="#session.fsip_endDate" default=""/>" placeholder="End Date">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
						</div>
						<div class="col-md-3 column">
							<div class="selectpicker_class2" style="margin-bottom: 15px;">
								<label style="margin-bottom: 10px;">Filter By:</label>
								<!--  -->
								<select id="filterOption" class="selectpicker" name="fsip_filter">
								    <option <s:if test='#session.fsip_filter == "1"'>selected="selected"</s:if> value="1">Department</option> 
								    <option <s:if test='#session.fsip_filter == "2"'>selected="selected"</s:if> value="2">Cost Center</option>
								    <option <s:if test='#session.fsip_filter == "3"'>selected="selected"</s:if> value="3">Customized</option>
								 </select>
							</div>
						</div>
					<div class="col-md-2 column" style="padding: 0px;">
						<button id="fsfilter_submit" type="submit" style="height: 30px;" class="btn btn-sm btn-primary">Filter</button>
					</div>
				</div>
			</div>
			</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#customChooseEmp").select2();
			/* $("#masterStatusLists").select2(); */
		});
		</script>
			
		<div id="customizedDiv" class="col-md-12 column" <s:if test='#session.fsip_filter == "3"'>style="display: true;"</s:if><s:else>style="display: none;"</s:else> >
			<div class="row clearfix">
				<div class="col-md-6 column">
					<input type="hidden" name="forTest" size="20" value="1">
					Choose Employee Here:
					<div class="panel panel-primary">
						<!-- <div class="panel-heading">
							<h3 class="panel-title">
								Panel title
							</h3>
						</div> -->
						<div class="panel-body">
							<select multiple name="fsip_customChooseEmp" id="customChooseEmp" style="width:500px" class="populate" value="jasonzh">
								<s:iterator var="fsip_Itor" value="#session.fsip_loginviewList">
									<option value="<s:property value="#fsip_Itor" />"><s:property value="#fsip_Itor"/></option>
									<!-- <s:if test='#session.fsip_filter == "3"'>selected="selected"</s:if> -->
								</s:iterator>
							</select>
						</div>
						<%-- <div class="panel-footer">
							<s:select label="Select Status" name="masterStatusLists" id="masterStatusLists" 
						      list="#{'1':'status1','2':'status2','3':'status3','4':'status4'}" multiple="true" required="true"  style="width:300px"/>
						</div> --%>
					</div>
				</div>
				<div class="col-md-6 column">
				</div>
			</div>
		</div>
		</form>
			
			<div id="showDetailsDiv" class="col-md-12 column" style="background-color:#D9EDF7; border-color: #BCE8F1; border-width: 1px; border-style: solid;">
					<div class="row clearfix" style="padding: 20px;">
					<table>
						<tr>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_bonus"> Bonus</td>
							<td style="width: 200px;"><input type="checkbox"  checked="checked" id="fsip_monthBaseSalary"> Month Base Salary</td>
							<td style="width: 200px;"><input type="checkbox"  checked="checked" id="fsip_adjustment"> Adjustment</td>
							<td style="width: 200px;"> <input type="checkbox" checked="checked" id="fsip_quarBonus"> Quar Bonus</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_overtimePay"> Overtime Pay</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_mealSubsidy"> Meal Subsidy</td>
						</tr>
						<tr>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_cummutingAllowance">  Commuting Allowance</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_salaryInPayroll"> 
							<span id="tooltipshow1" title="= Bonus + Month Base Salary + Adjustment + Quar Bonus + Overtime Pay + Meal Subsidy + Commuting Allowance">
							Salary in Payroll</span></td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_netSalary">
							<span id="tooltipshow2" title="= Salary in Payroll - Medical Insurance(Personal) - Social Insurance(Personal) - Tax">
							 Net Salary</span></td>
							<td style="width: 200px;"> <input type="checkbox" checked="checked" id="fsip_medicalInsPerson"> Medical Insurance(Personal)</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_medicalInsCom"> Medical Insurance(Company)</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_socialInsPerson">
							<span id="tooltipshow2" title="= Pension(Personal) + House Fund(Personal) + Unemploymen Ins.(Personal)">
							 Social Insurance(Personal)</span></td>
						</tr>
						
						<tr>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_socialInsCom"> 
							<span id="tooltipshow2" title="= Pension(Company) + House Fund(Company) + Unemploymen Ins.(Company) + Occupy Injure And Maternity Ins.">
							Social Insurance(Company)</span></td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_tax"> Tax</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_housFundPerson"> Housing Fund(Personal)</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_housFundCom"> Housing Fund(Company)</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_payrollTotal"> Payroll Total</td>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_MBOMonPor"> MBO Monthly Portion</td>
						</tr>
						<tr>
							<td style="width: 200px;"><input type="checkbox" checked="checked" id="fsip_annuBonusMonPor"> Annual Bonus Monthly Portion</td>
							<td style="width: 200px;"><input type="checkbox" id="fsip_total" checked="checked"> Total</td>
						</tr>
					
					</table>
				</div>
			</div>
		<div class="row clearfix" style="margin-top: 30px;">
		
			<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Panel title
							</h3>
						</div>
						<div class="panel-body" style="padding: 0px;">
						<div class="col-md-12 column" style="overflow:scroll; max-height: 800px;">
						<table class="table table-hover table-striped tableA">
							<thead>
								<tr>
									<th>
										ID
									</th>
									<th>
										Name
									</th>
									<th class="fsip_bonus_table">
										Bonus
									</th>
									<th class="fsip_monthBaseSalary_table">
										Month Base Salary
									</th>
									<th class="fsip_adjustment_table">
										Adjustment
									</th>
									<th class="fsip_quarBonus_table">
										Quar Bonus
									</th>
									<th class="fsip_overtimePay_table">
										Overtime Pay
									</th>
									<th class="fsip_mealSubsidy_table">
										Meal Subsidy
									</th>
									<th class="fsip_cummutingAllowance_table">
										Commuting Allowance
									</th>
									<th class="fsip_salaryInPayroll_table">
										Salary in Payroll
									</th>
									<th class="fsip_netSalary_table">
										Net Salary
									</th>
									<th class="fsip_medicalInsPerson_table">
										Medical Insurance(Personal)
									</th>
									<th class="fsip_medicalInsCom_table">
										Medical Insurance(Company)
									</th>
									<th class="fsip_socialInsPerson_table">
										Social Insurance(Personal)
									</th>
									<th class="fsip_socialInsCom_table">
										Social Insurance(Company)
									</th>
									<th class="fsip_tax_table">
										Tax
									</th>
									<th class="fsip_housFundPerson_table">
										Housing Fund(Personal)
									</th>
									<th class="fsip_housFundCom_table">
										Housing Fund(Company)
									</th>
									<th class="fsip_payrollTotal_table">
										Payroll Total
									</th>
									<th class="fsip_MBOMonPor_table">
										MBO Monthly Portion
									</th>
									<th class="fsip_annuBonusMonPor_table">
										Annual Bonus Monthly Portion
									</th>
									<th class="fsip_total_table">
										Total
									</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator var="fsdocItor" value="#session.fsdoc_list" status="fsdoc_stat">
									<tr>
										<td>
											<s:property value="#fsdoc_stat.index + 1"/>
										</td>
										<td>
											<s:property value="#fsdocItor.section_name"/>
										</td>
										<td class="fsip_bonus_table">
											<s:property value="#fsdocItor.bonus"/>
										</td>
										<td class="fsip_monthBaseSalary_table">
											<s:property value="#fsdocItor.monthlyBaseSalary"/>
										</td>
										<td class="fsip_adjustment_table">
											<s:property value="#fsdocItor.adjustment"/>
										</td>
										<td class="fsip_quarBonus_table">
											<s:property value="#fsdocItor.quartBonus"/>
										</td>
										<td class="fsip_overtimePay_table">
											<s:property value="#fsdocItor.OvertimePay"/>
										</td>
										<td class="fsip_mealSubsidy_table">
											<s:property value="#fsdocItor.MealSubsidy"/>
										</td>
										<td class="fsip_cummutingAllowance_table">
											<s:property value="#fsdocItor.TransAllowance"/>
										</td>
										<td class="fsip_salaryInPayroll_table">
											<s:property value="#fsdocItor.SalaryInPayroll"/>
										</td>
										<td class="fsip_netSalary_table">
											<s:property value="#fsdocItor.netSalary"/>
										</td>
										<td class="fsip_medicalInsPerson_table">
											<s:property value="#fsdocItor.medicalPersonal"/>
										</td>
										<td class="fsip_medicalInsCom_table">
											<s:property value="#fsdocItor.medicalCompany"/>
										</td>
										<td class="fsip_socialInsPerson_table">
											<s:property value="#fsdocItor.socialInsPersonal"/>
										</td>
										<td class="fsip_socialInsCom_table">
											<s:property value="#fsdocItor.socialInsCompany"/>
										</td>
										<td class="fsip_tax_table">
											<s:property value="#fsdocItor.tax"/>
										</td>
										<td class="fsip_housFundPerson_table">
											<s:property value="#fsdocItor.housingFundPersonal"/>
										</td>
										<td class="fsip_housFundCom_table">
											<s:property value="#fsdocItor.housingFundCompany"/>
										</td>
										<td class="fsip_payrollTotal_table">
											<s:property value="#fsdocItor.payrollTotal"/>
										</td>
										<td class="fsip_MBOMonPor_table">
											<s:property value="#fsdocItor.mboMonthlyPortion"/>
										</td>
										<td class="fsip_annuBonusMonPor_table">
											<s:property value="#fsdocItor.annualBonusMonthlyPortion"/>
										</td>
										<td class="fsip_total_table">
											<s:property value="#fsdocItor.total"/>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						</div>
					</div>
				<div class="panel-footer" style="text-align: right;">
					<!-- <p id="testTooltip">Panel footer</p> -->
					<%-- <a class="btn btn-sm btn-primary" href="<%=path%>/exportExcelAction_FinancialStatement!export.action">Export as Excel</a> --%>
					<!-- <a id="" href="#modal-container-exportPayroll"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button type="button" class="btn btn-primary btn-sm">Export Payroll</button></a> -->
					<a class="btn btn-sm btn-primary" href="<%=path%>/exportExcelAction_FinancialStatement!export.action">Export as Excel</a>
				</div>
			</div>
	</div>
			
			   
		<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Pie Chart
							</h3>
						</div>
						<div class="panel-body">
							<div>
								<div id="pie_placeholder" style="width:480px;height:250px; margin: auto;"></div>
							</div>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
					
				</div>
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Bar Chart
							</h3>
						</div>
						<div class="panel-body">
							<div>
								<div id="bargraph_placeholder2" style="width:510px;height:250px; margin: auto;"></div>
							</div>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="modal-container-exportPayroll" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Export Payroll
				</h4>
			</div>
		<form id="" action="exportExcelAction_Payroll!export" role="form" accept-charset="utf-8">
			<div class="modal-body" style="padding-left: 40px; padding-right: 80px;">
					 <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
							<span class="input-group-addon">Start Date:</span>
		                    <input id="fsip_startDate2" class="form-control red-tooltip" name="fsip_startDate2" data-date-format="yyyy-mm-dd" type="text" value="<s:property value="#session.fsip_startDate" default=""/>" placeholder="Start Date">
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
		                </div>
					 <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-top: 30px;">
							<span class="input-group-addon">End Date:</span>
		                    <input id="fsip_endDate2" class="form-control red-tooltip" name="fsip_endDate2" data-date-format="yyyy-mm-dd" type="text" value="<s:property value="#session.fsip_endDate" default=""/>" placeholder="End Date">
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
		                </div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Export</button>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>