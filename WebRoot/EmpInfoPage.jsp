<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Information</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
<link type="text/css" href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
<link href="css/style2.css" rel="stylesheet"/>

<style type="text/css">
	.alert-success dt {
		margin-bottom: 6px;
	}
	
</style>

<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.editableonlynumber.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.0.custom.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
	/* href="toEditEmpInfoPageAction?operationFlag_toeeip='editEmpInfo'" */
		/* $("#eip_emp_costcenter_tooltip").tooltip();	 */
	/*" */
	/* $("#editEmpInfo").click(function() {
		 
		$.get("toEditEmpInfoPageAction?operationFlag_toeeip='editEmpInfo'", function(data){
        	$("#main-container").html(data);
          })
	}); */
});
</script>


</head>
<body>
<%
  	if(session.getAttribute("login") == null)  
  		request.getRequestDispatcher("login.jsp");
 	/* response.sendRedirect("login.jsp");	 */
  %>
<jsp:include page="nav.jsp"></jsp:include>

<div class="container" id="main-container">
		<div class="page-header">
			<h1> 
				Employee Info Page
			</h1>
		</div>
	<div class="row clearfix">
		<div class="col-md-6 column"  style="width: 60%;">
			<div class="row clearfix" style="color: purple;">
				<div class="col-md-4 column" style="width: 27%;">
					<!-- <img style="float: left; alt="140x140" src="http://lorempixel.com/140/140/"> --> 
					<a><img style="float: left; alt="140x140" src="img/profile/eip_01.jpg"></a>
				</div>
				<div class="col-md-4 column" style="padding-left: 0px;">
					<h4 class="media-heading" style="margin-bottom: 20px;">
					<s:property value="#session.eip_emp.nameEnglish" default="#English Name"/>
				</h4>
				<strong><s:property
						value="#session.eip_emp.empLoginId" default="#LoginID"/> </strong>
				<address style="margin-bottom: 10px;">
					<br> <strong><abbr title="Mobile Phone"><span style="color: purple;" class="glyphicon glyphicon-phone"></span></abbr></strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.mobile" default=""/>
					<br> <strong><abbr title="Office Phone"><span style="color: purple;" class="glyphicon glyphicon-phone-alt"></span></abbr></strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.officePhone" default=""/>
					<br> <strong><abbr style="color: purple;" title="Skype">Skype:</abbr></strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.skype" default=""/>
					<br> <strong><abbr title="Email"><span style="color: purple;" class="glyphicon glyphicon-envelope"></span></abbr></strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.email" default=""/>
				</address>
				<p>
				</div>
				<div class="col-md-4 column" style="padding-left: 0px;">
				<strong><s:property
						value="#session.eip_emp.nameChinese" default="#Chinese Name"/> </strong>
				<address style="margin-bottom: 10px;">
					<br> <strong style="color: purple">Gender:</strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.gender" default=""/>
					<br> <strong style="color: purple">Age:</strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp_age" default="0"/>
					<br> <strong style="color: purple">Birthday:</strong>&nbsp;&nbsp;&nbsp;
					<s:property value="%{getText('format.date',{#session.eip_emp.birthday})}"/>
					<br> <strong style="color: purple">Address:</strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.address" default="无"/>
					<br> <strong style="color: purple">Identity Card:</strong>&nbsp;&nbsp;&nbsp;
					<s:property value="#session.eip_emp.identityCard" default="无"/>
				</address>
				<p>
				</div>
			</div>
			
			<div class="row clearfix" style="color: purple;">
			<div class="col-md-6 column" style="font-size: 14px;">
				<dl class="dl-horizontal">
				<dt style="width: 100px; color: purple;">
					Position title:
				</dt>
				<dd style="margin-left: 120px;">
				<span id="eip_emp_positiontitle_tooltip" title="<s:property value="#session.eip_emp.positiontitle.positionTitleDesc" default="无"/>"
					 data-placement="top">
					<s:property value="#session.eip_emp.positiontitle.positionTitleName" default="无"/></span>
				</dd>
				<dt style="width: 100px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 120px;">
				<span id="eip_emp_positiontitle_tooltip" title="<s:property value="#session.eip_emp.positiontitle.positionTitleDesc" default="无"/>"
					 data-placement="top">
					<s:property value="%{getText('format.date',{#session.eip_emp.positionTitleValidate})}"/></span>
				</dd>
				<dt style="width: 100px; color: purple;">
					Department:
				</dt>
				<dd style="margin-left: 120px;">
				<span id="" title="<s:property value="#session.eip_emp.department.departDesc" default="无"/>"
					 data-placement="top">
					<s:property value="#session.eip_emp.department.departName" default="无"/></span>
				</dd>
				<dt style="width: 100px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 120px;">
				<span id="" data-placement="top">
					<s:property value="%{getText('format.date',{#session.eip_emp.departmentValidate})}"/></span>
				</dd>
			</dl>
			</div>
			<div class="col-md-6 column">
				<dl class="dl-horizontal">
				<dt style="width: 130px; color: purple;">
					Line Manager:
				</dt>
				<dd style="margin-left: 150px;">
				<span id="" title="<s:property value="#session.eip_emp.emp.empLoginId" default="无"/>"
					 data-placement="top">
					<s:property value="#session.eip_emp.emp.nameEnglish" default="无"/></span>
				</dd>
				<dt style="width: 130px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 150px;">
				<span id="" data-placement="top">
					<s:property value="%{getText('format.date',{#session.eip_emp.lineManagerValidate})}"/></span>
				</dd>
				<dt style="width: 130px; color: purple;">
					System Role:
				</dt>
				<dd style="margin-left: 150px;">
				<span id="" title="<s:property value="#session.eip_emp.role.sysRoleDesc" default="无"/>"
					 data-placement="top">
					<s:property value="#session.eip_emp.role.sysRoleName" default="无"/></span>
				</dd>
			</dl>
			</div>
			</div>
			<!-- <div class="media" style="background-color: #c8e5bc; border-color:#428bca; border-width: 1px; border-style: solid; padding: 15px;"> -->
			<div class="media well" style="color: purple;">
				<div class="media-body">
					<h4 class="media-heading">
						Salary Info
					</h4>
					<div class="media" style="margin-top: 0px; font-size: 14px;">
			<div class="row clearfix">
			<div class="col-md-6 column" style="width: 45%;">
				<dl class="dl-horizontal">
				<dt style="width: 130px;">
					Base Salary:
				</dt>
				<dd style="margin-left: 150px;">
					<s:property value="%{getText('format.money',{#session.eip_emp.baseSalary})}"/>
				</dd>
				<dt style="width: 130px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 150px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.baseSalaryValidate})}"/></span>
				</dd>
				<dt style="width: 130px;">
					Social Insurance:
				</dt>
				<dd style="margin-left: 150px;">
					<s:property value="%{getText('format.money',{#session.eip_emp.socialInsurBase})}"/>
				</dd>
				<dt style="width: 130px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 150px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.socialInsurBaseValidate})}"/>
				</dd>
				<dt style="width: 130px;">
					MBO:
				</dt>
				<dd style="margin-left: 150px;">
				<span id="" title="<s:property value="#session.eip_emp.mbo.mboDesc" default="无"/>"
					 data-placement="bottom">
					<s:property value="%{getText('format.percent',{#session.eip_emp.mbo.mboRate})}"/></span>
				</dd>
				<dt style="width: 130px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 150px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.mboValidate})}"/>
				</dd>
			</dl>
			</div>
			<div class="col-md-6 column" style="width: 55%;">
				<dl class="dl-horizontal">
				<dt style="width: 120px;">
					Cost Center:
				</dt>
				<dd style="margin-left: 140px;">
					<span id="eip_emp_costcenter_tooltip" title="<s:property value="#session.eip_emp.costcenter.costCenterDesc" default="无"/>"
					 data-placement="bottom">
					 <s:property value="#session.eip_emp.costcenter.costCenterName" default="无"/></span>
				</dd>
				<dt style="width: 120px; color: purple; margin-bottom: 20px;">
					Valid Date:
				</dt>
				<dd style="margin-left: 140px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.costCenterValidate})}"/>
				</dd>
				<dt style="width: 120px;">
					<abbr title="Credit Card"><span class="glyphicon glyphicon-credit-card"></span></abbr>&nbsp;Credit Card:
				</dt>
				<dd style="margin-left: 140px;">
					<s:property value="#session.eip_emp.creditCardNumber" default="无"/>
				</dd>
			</dl>
			</div>
			</div>
					</div>
				</div>
			</div>
			
			<br>
			<p style="float: right;">
			<a id="" href="salaryInfoAction?empLoginId=<s:property value="#session.eip_emp.empLoginId"/>" class="btn btn-primary btn-sm" role="">View Salary Info</a>
			<a id="editEmpInfo" href="toEditEmpInfoPageAction?operationFlag_toeeip=editEmpInfo" class="btn btn-primary btn-sm" role="button"><span class="glyphicon glyphicon-pencil"></span>&nbsp;Edit</a></p>
		</div>
		<div class="col-md-6 column" style="width: 40%;">
			<div class="media alert-success" style="padding: 15px; color: #2d6987; border-style: solid; border-width: 1px;">
				<div class="media-body" style="font-size: 13px;">
					<h4 class="media-heading">
						Contract Info
					</h4>
				
				<dl class="dl-horizontal">
				<dt style="width: 130px;">
					Working Age:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="#session.eip_emp.workingAge" default="无"/>
				</dd>
				<dt style="width: 130px;">
					Probation Start:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.porbationStartDate})}"/>
				</dd>
				<dt style="width: 130px;">
					Probation End:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.porbationEndDate})}"/>
				</dd>
				<dt style="width: 130px;">
					Workplace:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="#session.eip_emp.workplace" default="无"/>
				</dd>
				</dl>	
				
					<dl class="dl-horizontal">		
				<dt style="width: 130px;">
					Contract Start Date:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.contractStartDate})}"/>
				</dd>
				<dt style="width: 130px;">
					Contract End Date:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.contractEndDate})}"/>
				</dd>
				<dt style="width: 130px;">
					Employee Type:
				</dt>
				<dd style="margin-left: 160px;">
				<span id="" title="<s:property value="#session.eip_emp.emptype.empTypeDesc" default="无"/>"
					 data-placement="top">
					<s:property value="#session.eip_emp.emptype.empTypeName" default="无"/></span>
				</dd>
				<dt style="width: 130px;">
					Contract Type:
				</dt>
				<dd style="margin-left: 160px;">
				<span id="" title="<s:property value="#session.eip_emp.contracttype.contractTypeDesc" default="无"/>"
					 data-placement="top">
					<s:property value="#session.eip_emp.contracttype.contractTypeName" default="无"/></span>
				</dd>
				<dt style="width: 130px;">
					On Job?
				</dt>
				<dd style="margin-left: 160px;">
					Yes
				</dd>
				<dt style="width: 130px;">
					Entry Date:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.entryDate})}"/>
				</dd>
				<dt style="width: 130px;">
					Leave Date:
				</dt>
				<dd style="margin-left: 160px;">
					<s:property value="%{getText('format.date',{#session.eip_emp.leaveDate})}" default="无"/>
				</dd>
				</dl>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>