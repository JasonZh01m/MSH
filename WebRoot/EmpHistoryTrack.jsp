<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		
	</style>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.categories.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.time.min.js"></script>
<script type="text/javascript" src="js/flot/jquery.flot.tooltip.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/select2.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee History Track</title>
<script type="text/javascript">

$(function() {


	var ehisip_salary_data = ${ehisip_salary_data};
	var ehisip_socialIns_data = ${ehisip_socialIns_data};
/* 	var ehisip_mbo_data = ${ehisip_mbo_data}; */
	//<s:property value="#session.ehisip_salary_data"/>
	//default="[[new Date('2013/03/01'), 2000.0],[new Date('2013/05/01'), 2200.0]]"
	
	//var ehisip_salary_data = [[new Date("2013/03/01"), 2000.0],[new Date("2013/05/01"), 2200.0],[new Date("2013/06/01"), 2300.0],[new Date("2013/07/01"), 2700.0],[new Date("2013/07/01"), 2400.0],[new Date("2013/08/01"), 2800.0],[new Date("2013/08/01"), 2500.0],[new Date("2013/10/01"), 2600.0],[new Date("2013/12/01"), 3000.0],[new Date("2014/03/01"), 3500.0]];
	
	//default="[[new Date('2009/08/26'), 0]];"
	//default="[{ label: 'Series 0', data: 1 }];"
	//default="[new Date('2009/08/26'), 0]"
	
	var options = {
		lines: {
			show: true
		},
		points: {show: true },
		xaxis: {
			mode: "time",
			minTickSize: [1, "day"],
			timeformat: "%y/%m/%d",
			timezone: "browser"
		},
		grid: {
			hoverable: true
		},
		tooltip: true,
			tooltipOpts: {
				content: "%y.2  %x", 
				shifts: {
					x: 20,
					y: 0
				},
				defaultTheme: false
			}
			/* ,
		colors: [ "rgb(182, 90, 24)" ] */
	};
	
	$.plot($("#line_placeholder"), [{data: ehisip_salary_data, label: "Salary Change"}, {data: ehisip_socialIns_data, label: "Social Ins. Change"}], options);
	//, { data: data2, label: "United States2",}

	// Add the Flot version string to the footer

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
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
					Employee History Info Page <small>Employee: <s:property value="#session.ehisip_empLoginId"/> </small>
				</h1>
			</div>
			<div class="row clearfix">
			<div class="col-md-12 column" style="margin-bottom: 40px;">
			<form action="toEmpHistoryInfoPage" method="post">
				<div class="selectpicker_class"  style="float: left; margin-right: 30px;">
					<label>Employee:</label>
					<select id="ehisip_empLoginId" name="ehisip_empLoginId" class="selectpicker" data-live-search="true">
					    <s:iterator var="ehisip_empItor" value="#session.ehisip_loginviewList">
					   		<option <s:if test='#session.ehisip_empLoginId == #ehisip_empItor'>selected="selected"</s:if>
					   		><s:property value="#ehisip_empItor" /></option>
					   	</s:iterator>
					 </select>
					</div>
					<button id="ehisip_submit" type="submit" style="height: 30px;" class="btn btn-sm btn-primary">Search&nbsp;<span class="glyphicon glyphicon-search"></span></button>
				</form>	
				</div>
			</div>				
								
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Salary Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Salary
								</th>
								<th>
									Valid Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_salary_Itor" value="#session.ehisip_salaryHistoryList" status="ehisip_salary_stat">
							<tr>
								<td>
									<s:property value="#ehisip_salary_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_salary_Itor.value"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_salary_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
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
								Social Ins. Base Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Social Ins. Base
								</th>
								<th>
									Valid Date
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="ehisip_socialIns_Itor" value="#session.ehisip_socialInsList" status="ehisip_socialIns_stat">
							<tr>
								<td>
									<s:property value="#ehisip_socialIns_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_socialIns_Itor.value"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_socialIns_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
						</tbody>
					</table>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								MBO Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									MBO Rate
								</th>
								<th>
									Validate Date
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="ehisip_mbo_Itor" value="#session.ehisip_mboList" status="ehisip_mboIns_stat">
							<tr>
								<td>
									<s:property value="#ehisip_mboIns_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_mbo_Itor.value"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_mbo_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Line Chart
							</h3>
						</div>
						<div class="panel-body" style="padding-right: 25px; padding-left: 25px;">
							<div>
								<div id="line_placeholder" style="height:400px; margin: auto;"></div>
							</div>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
				</div>
				<div class="col-md-6 column">
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Position Title Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Position Title
								</th>
								<th>
									Valid Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_positionTitle_Itor" value="#session.ehisip_positionTitleList" status="ehisip_positionTitle_stat">
							<tr>
								<td>
									<s:property value="#ehisip_positionTitle_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_positionTitle_Itor.section_Name"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_positionTitle_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Cost Center Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Cost Center
								</th>
								<th>
									Valid Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_costCenter_Itor" value="#session.ehisip_costCenterList" status="ehisip_costCenter_stat">
							<tr>
								<td>
									<s:property value="#ehisip_costCenter_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_costCenter_Itor.section_Name"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_costCenter_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
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
								Department Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Department Title
								</th>
								<th>
									Valid Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_depart_Itor" value="#session.ehisip_departList" status="ehisip_depart_stat">
							<tr>
								<td>
									<s:property value="#ehisip_depart_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_depart_Itor.section_Name"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_depart_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Line Manager Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Line Manager
								</th>
								<th>
									Valid Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_lineManager_Itor" value="#session.ehisip_lineManagerList" status="ehisip_lineManager_stat">
							<tr>
								<td>
									<s:property value="#ehisip_lineManager_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_lineManager_Itor.section_Name"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_lineManager_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer">
							Panel footer
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Contract Type Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Contract Type
								</th>
								<th>
									Modify Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_contractType_Itor" value="#session.ehisip_contractTypeList" status="ehisip_contractType_stat">
							<tr>
								<td>
									<s:property value="#ehisip_contractType_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_contractType_Itor.section_Name"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_contractType_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
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
								Employee Type Change History
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									Employee Type Title
								</th>
								<th>
									Modify Date
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="ehisip_empType_Itor" value="#session.ehisip_empTypeList" status="ehisip_empType_stat">
							<tr>
								<td>
									<s:property value="#ehisip_empType_stat.index + 1"/>
								</td>
								<td>
									<s:property value="#ehisip_empType_Itor.section_Name"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#ehisip_empType_Itor.validateDate})}"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
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
</body>

</html>