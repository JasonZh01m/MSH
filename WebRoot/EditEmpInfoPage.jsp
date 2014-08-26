<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Employee Info</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="css/style2.css" rel="stylesheet"/>

<style type="text/css">
#img1{filter:alpha(opacity=0.7);opacity:0.7;}

.selectpicker_class2{
	height:30px;
	margin-bottom: 10px;
	float: right;
}

.selectpicker_class2 .bootstrap-select{
	width: 160px;
}

.selectpicker_class2 label{
	margin-right: 5px;
}

/* sm */
.selectpicker_class3{
	height:30px;
	margin-bottom: 10px;
	float: right;
}

.selectpicker_class3 .bootstrap-select{
	width: 136px;
}

.selectpicker_class3 label{
	margin-right: 5px;
}

.editemp_form0 span{
	width: 106px;
} 


.editemp_form1 span{
	width: 76px;
}

.editemp_form1 .form-control{
	width: 215px;
}


.editemp_form2 span{
	width: 71px;
}

.editemp_form2 .form-control{
	width: 162px;
}

.editemp_form3 span{
	width: 110px;
}

.editemp_form2 .form-control{
	/* width: 162px; */
}

.editemp_form5 {
	 float: right; 
	 text-align: right;
}
.editemp_form5 label {
	text-align: right;
	margin-right: 8px;
}

/* #A94442 */

.red-tooltip + .tooltip > .tooltip-inner{background-color: #FF6633;}
.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #FF6633;}

</style>

</head>
<%
  	if(session.getAttribute("login") == null)  
  	 	response.sendRedirect("login.jsp");	
  %>
<body>

<jsp:include page="nav.jsp"></jsp:include>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					Edit Employee Info Page
				</h1>
			</div>
			<form id="testForm" action="saveOrUpdateEmpInfoAction" method="post">
			<input value="UpdateEmpInfo" name="operationFlag" type="hidden">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="row clearfix">
						<div class="col-md-6 column" style="width: 45%;">
							<img id="img2" alt="140x140" src="img/profile/eip_01.jpg" style="margin-bottom: 30px; padding-left: 40px; padding-top: 20px;">
							<h4><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Profile</h4>
							
							<div id="profile-form">
								<div class="input-group input-group-sm editemp_form editemp_form0">
								  <span class="input-group-addon">Chinese Name:</span>
								  
								  <input value="<s:property	value='#session.eip_emp.nameChinese' default='#Chinese Name'/>" id="eeip_chinesename" type="text" class="form-control red-tooltip" name="eeip_chinesename" required placeholder="Chinese Name">
								  
								  <!-- <input value="abc" id="eeip_chinesename" type="text" class="form-control" placeholder="Chinese Name"> -->
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form0">
								  <span class="input-group-addon">English Name:</span>
								  <input disabled="disabled" value="<s:property value="#session.eip_emp.nameEnglish" default="#English Name"/>" id="eeip_englishname" type="text" class="form-control red-tooltip" name="eeip_englishname" placeholder="English Name" >
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form2">
								  <span class="input-group-addon" >Login ID:</span>
								  <input disabled="disabled" value="<s:property	value="#session.eip_emp.empLoginId" default="#LoginID"/>" id="eeip_loginid" type="text" class="form-control red-tooltip" name="eeip_loginid" placeholder="Login ID">
								</div>
								<!-- <div class="input-group input-group-sm editemp_form editemp_form2">
								  <span class="input-group-addon">Gender:</span>
								  <input  id="eeip_gender" type="text" class="form-control" placeholder="Gender">
								</div> -->
								
								<div class="selectpicker_class2" style="margin-top: 5px; margin-bottom: 15px;">
								<label>Gender:</label>
								<select id="eeip_gender" class="selectpicker" name="eeip_gender">
								    <option  <s:if test='#session.eip_emp.gender == "男"'>selected="selected"</s:if>>男</option>
								    <option <s:if test='#session.eip_emp.gender == "女"'>selected="selected"</s:if>>女</option>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form2 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon">Birthday:</span>
				                    <input id="eeip_birthday" class="form-control red-tooltip" name="eeip_birthday" data-date-format="yyyy-mm-dd" type="text" placeholder="Birthday" style="width: 127px;"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.birthday})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
							</div>
							
							
						</div>
						<div class="col-md-6 column" style="width: 55%;">
							<h4>
								<span class="glyphicon glyphicon-earphone"></span>&nbsp;&nbsp;Contact
							</h4>
							<div id="profile-form">
							
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span>&nbsp;Mobile:</span>
								  <input id="eeip_mobile" type="text" class="form-control red-tooltip" name="eeip_mobile" placeholder="Mobile"
								  	value="<s:property value="#session.eip_emp.mobile" default="123456789"/>"
								  >
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span>&nbsp;Office:</span>
								  <input id="eeip_officephone" type="text" class="form-control red-tooltip" name="eeip_officephone" placeholder="Office Phone" value="<s:property value="#session.eip_emp.officePhone" default="123456789"/>">
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon" >
								  <img id="img1" alt="" src="img/icon/skype-24-black.png" width="20px;" height="20px;" style="margin-top: -3px; margin-left: -4px; margin-right: -6px;" >
								  Skype:</span>
								  <input id="eeip_skype" type="text" class="form-control red-tooltip" name="eeip_skype" placeholder="Skype" value="<s:property value="#session.eip_emp.skype" default="#abc123@skype.com"/>">
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>&nbsp;Email:</span>
								  <input id="eeip_email" type="text" class="form-control red-tooltip" name="eeip_email" placeholder="Email" value="<s:property value="#session.eip_emp.email" default="jennifers@moravia.com"/>">
								</div>
								
								<div class="form-group input-group-sm" style="margin-top: 20px;">
									 <label for="" style="margin-bottom: 0px;">Identity Card:</label>
									 <input id="eeip_identitycard" name="eeip_identitycard" type="text" class="form-control red-tooltip" placeholder="Input Identity Card number"
									 	value="<s:property value="#session.eip_emp.identityCard"/>"
									 >
								</div>
								
								<div class="form-group input-group-sm">
									 <label for="exampleInputEmail1" style="margin-bottom: 0px;">Address:</label>
									 <textarea id="eeip_address" name="eeip_address" class="form-control" rows="2" cols="44" style="width: 291px; height: 60px; resize: none;"  placeholder="Input Address"><s:property value="#session.eip_emp.address" default=""/></textarea>
								</div>
								
								<h4 style="margin-top: 40px;"><span class="glyphicon glyphicon-briefcase"></span>&nbsp;&nbsp;Position</h4>
								
								
								<div class="selectpicker_class" >
								<label>Position Title:</label>
								<select id="eeip_positiontitle" name="eeip_positiontitle" class="selectpicker" data-live-search="true">
								   <s:iterator var="positiontitleItor" value="#session.positiontitleList">
								   		<option value="<s:property value="#positiontitleItor.positionTitleId" />" 
								   		<s:if test="#session.eip_emp.positiontitle.positionTitleId.equals(#positiontitleItor.positionTitleId)">
								   		selected="selected"</s:if>><s:property value="#positiontitleItor.positionTitleName" />  (<s:property value="#positiontitleItor.positionTitleDesc"/>)</option>
								   </s:iterator>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input id="eeip_positiontitle_validate" name="eeip_positiontitle_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Position Valid Date" style="width: 145px;"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.positionTitleValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="selectpicker_class">
								<label>Department:</label>
								<select id="eeip_department" name="eeip_department" class="selectpicker" data-live-search="true">
								   <s:iterator var="departmentItor" value="#session.departmentList">
								   		<option value="<s:property value="#departmentItor.departId" />" <s:if test="#session.eip_emp.department.departId.equals(#departmentItor.departId)">
								   		selected="selected"</s:if>><s:property value="#departmentItor.departName" />  (<s:property value="#departmentItor.departDesc" />)
								   		</option>
								   </s:iterator>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input id="eeip_depart_validate" name="eeip_depart_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Department Valid Date" style="width: 145px;"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.departmentValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="selectpicker_class">
								<label>Line Manager:</label>
								<select id="eeip_linemanager" name="eeip_linemanager" class="selectpicker" data-live-search="true">
								    <s:iterator var="lmItor" value="#session.login.allLoginIds" status="st">
								   		<option 
								   		<%-- value="<s:property value="#st.count"/>" --%>
								   		<s:if test="#session.eip_emp.emp.empLoginId.equals(#lmItor)">
								   		selected="selected"</s:if>><s:property value="#lmItor" /></option>
								   	</s:iterator>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input id="eeip_linemanager_validate" name="eeip_linemanager_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Line Manager Valid Date" style="width: 145px;"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.lineManagerValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="selectpicker_class">
								<label>System Role:</label>
								<select id="eeip_systemrole" name="eeip_systemrole" class="selectpicker" data-live-search="true">
								   <s:iterator var="roleItor" value="#session.roleList">
								   		<option value="<s:property value="#roleItor.sysRoleId" />"
								   		<s:if test="#session.eip_emp.role.sysRoleId.equals(#roleItor.sysRoleId)">
								   		selected="selected"</s:if>><s:property value="#roleItor.sysRoleName" />  (<s:property value="#roleItor.sysRoleDesc" />)
								   		</option>
								   </s:iterator>
								 </select>
								</div>
								
								<!-- <div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input id="eeip_systemrole_validate" name="eeip_systemrole_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Role Valid Date" style="width: 145px;"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div> -->
								
								
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 column">
					<div class="col-md-6 column">
							<h4>
								<span class="glyphicon glyphicon-usd"></span>&nbsp;&nbsp;Salary
							</h4>
						<div id="profile-form">
								<div class="input-group input-group-sm editemp_form">
								  <span class="input-group-addon">Base Wage:</span>
								  <input id="eeip_basesalary" name="eeip_basesalary" type="text" class="form-control red-tooltip" placeholder="Base Salary" value="<s:property value="#session.eip_emp.baseSalary"/>">
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<span class="input-group-addon">Validate:</span>
				                    <input id="eeip_basesalary_validate" name="eeip_basesalary_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Salary Valid Date"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.baseSalaryValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="input-group input-group-sm editemp_form">
								  <span class="input-group-addon">Social Ins. :</span>
								  <input id="eeip_socialinsurance" name="eeip_socialinsurance" type="text" class="form-control red-tooltip" placeholder="Social Insurance Base" value="<s:property value="#session.eip_emp.socialInsurBase"/>">
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<span class="input-group-addon">Validate:</span>
									<!-- <label>Valid Date:</label> -->
				                    <input id="eeip_socialinsurance_validate" name="eeip_socialinsurance_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Social Insurance Valid Date"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.socialInsurBaseValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="selectpicker_class2" style="margin-top: 10px;">
								<label>MBO:</label>
								<select id="eeip_mbo" name="eeip_mbo" class="selectpicker" data-live-search="true">
								    <s:iterator var="mboItor" value="#session.mboList">
								   		<option value="<s:property value="#mboItor.mboId" />" 
								   		<s:if test="#session.eip_emp.mbo.mboId.equals(#mboItor.mboId)">
								   		selected="selected"</s:if>><s:property value="#mboItor.mboRate" />%  (<s:property value="#mboItor.mboDesc" />)</option>
								   </s:iterator>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input id="eeip_mbo_validate" name="eeip_mbo_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="MBO Valid Date" style="width: 125px;"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.mboValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="selectpicker_class2">
								<label>Cost Center:</label>
								<select id="eeip_costcenter" name="eeip_costcenter" class="selectpicker" data-live-search="true">
								    <s:iterator var="costcItor" value="#session.costcenterList">
								   		<option value="<s:property value="#costcItor.costCenterId"/>" 
								   		<s:if test="#session.eip_emp.costcenter.costCenterId.equals(#costcItor.costCenterId)">
								   		selected="selected"</s:if>><s:property value="#costcItor.costCenterName" />  (<s:property value="#costcItor.costCenterDesc" />)</option>
								   </s:iterator>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5 date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input id="eeip_costcenter_validate" name="eeip_costcenter_validate" class="form-control red-tooltip" name="" data-date-format="yyyy-mm-dd" type="text" placeholder="Cost Center Valid Date" style="width: 125px;"
				                    value="<s:property value="%{getText('format.date',{#session.eip_emp.costCenterValidate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="form-group input-group-sm" style="margin-top: 20px;">
									 <label for="exampleInputEmail1" style="margin-bottom: 0px;"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;Credit Card:</label>
									 <input id="eeip_creditcard" name="eeip_creditcard" type="text" class="form-control red-tooltip" placeholder="Input Credit Card number"
									 	value="<s:property value="#session.eip_emp.creditCardNumber"/>"
									 >
								</div>
								
								<div style="margin-top: 90px;">
									<label>Holiday Left:</label>
									<div class="input-group input-group-sm editemp_form">
									  <span class="input-group-addon">Annual holiday:</span>
									  <input id="eeip_annualleaveleft" name="eeip_annualleaveleft" type="text" class="form-control red-tooltip" placeholder="Annual holiday left"
									  	value="<s:property value="#session.eip_emp.annualLeaveLeft" default="0"/>"
									  >
									</div>
								</div>
								<div style="margin-top: 40px;">
								<label>Work place:</label>
								<div class="input-group input-group-sm editemp_form">
								  <span class="input-group-addon">Workplace:</span>
								  <input id="eeip_workplace" name="eeip_workplace" type="text" class="form-control red-tooltip" placeholder="Workplace"
								  	value="<s:property value="#session.eip_emp.workplace" default="0"/>"
								  >
								</div>
								</div>
							</div>				
					</div>
					
					<div class="col-md-6 column">
						<div id="profile-form">
							<h4>
								<span class="glyphicon glyphicon-paperclip"></span>&nbsp;&nbsp;Contract
							</h4>
							<div  style="margin-bottom: 30px;">
							
								<div id="probationstart_part" class="input-group input-group-sm editemp_form" >
								  <span class="input-group-addon">Working Age:</span>
								  <input id="eeip_workingage" type="text" class="form-control red-tooltip" placeholder="Working Age" data-placement="top" name="eeip_workingage"
								  	value="<s:property value="#session.eip_emp.workingAge" default="0"/>"
								  >
								</div>
								
								<div class="input-group input-group-sm editemp_form">
								<div class="col-md-6 column" style="padding: 0px;">
							      <span class="input-group-addon" style="font-size: 12px; padding-left: 10px;">
							        With Probation?
							      </span>
							      <span class="input-group-addon" style=" background-color: white;">
							        <input id="eeip_withprobation" name="eeip_withprobation" type="checkbox" 
							        <s:if test="#session.eip_emp.withProbation == 1">checked="checked"</s:if>  >
							      </span>
							      <input type="text" class="form-control" style="display: none;">
							     </div>
							    </div>
								
								
								
								
								<div id="probation_date" <s:if test="#session.eip_emp.withProbation == 0">style="display: none"</s:if>>
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" >Probation Start:</span>
				                    <input id="eeip_probationstartdate" name="eeip_probationstartdate" class="form-control red-tooltip" data-date-format="yyyy-mm-dd" type="text" placeholder="Probation Start Date"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.porbationStartDate})}"/>">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" style="width: 110px;" >Probation End:</span>
				                    <input id="eeip_probationenddate" name="eeip_probationenddate" class="form-control red-tooltip" data-date-format="yyyy-mm-dd" type="text" placeholder="Probation End Date"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.porbationEndDate})}"/>"
				                    >
				                    <!-- <input type="text" placeholder="2014-01-01" class="form-control form_date" data-date-format="yyyy-mm-dd"> -->
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								</div>
								
								<div id="probation_alert_info" class="alert alert-info alert-dismissable" <s:if test="#session.eip_emp.withProbation == 1">style="display: none"</s:if>>
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									<h4>Alert!</h4>
									<strong>Warning!</strong>  If the employee has probation during this employment period, please check the checkbox above and input <em>'Probation Start'</em> and <em>'Probation End'</em> date!
								</div>
								
								</div>
								
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" >Contract Start:</span>
				                    <input id="eeip_contractstartdate" name="eeip_contractstartdate" class="form-control red-tooltip" data-date-format="yyyy-mm-dd" type="text" placeholder="Contract Start Date"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.contractStartDate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
				                
				                <div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" style="width: 104px;">Contract End:</span>
				                    <input id="eeip_contractenddate" name="eeip_contractenddate" class="form-control red-tooltip" data-date-format="yyyy-mm-dd" type="text" placeholder="Contract End Date"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.contractEndDate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="selectpicker_class3" style="margin-top: 10px;">
								<label>Contract Type:</label>
								<select id="eeip_contracttype" name="eeip_contracttype" class="selectpicker" data-live-search="true">
								    <s:iterator var="contractItor" value="#session.contracttypeList">
								   		<option value="<s:property value="#contractItor.contractTypeId" />" 
								   		<s:if test="#session.eip_emp.contracttype.contractTypeId.equals(#contractItor.contractTypeId)">
								   		selected="selected"</s:if>><s:property value="#contractItor.contractTypeName" />
								   </s:iterator>
								 </select>
								</div>
								
								<div class="selectpicker_class3" style="margin-bottom: 30px;">
								<label>Employee Type:</label>
								<select id="eeip_emptype" name="eeip_emptype" class="selectpicker" data-live-search="true">
								    <s:iterator var="emptypeItor" value="#session.emptypeList">
								   		<option value="<s:property value="#emptypeItor.empTypeId" />"  
								   		<s:if test="#session.eip_emp.emptype.empTypeId.equals(#emptypeItor.empTypeId)">
								   		selected="selected"</s:if>><s:property value="#emptypeItor.empTypeName" />  (<s:property value="#emptypeItor.empTypeDesc" />)</option>
								   	</s:iterator>
								 </select>
								</div>
								
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" style="width: 87px;">Entry Date:</span>
				                    <input id="eeip_entrydate" name="eeip_entrydate" class="form-control red-tooltip" data-date-format="yyyy-mm-dd" type="text" placeholder="Entry Date"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.entryDate})}"/>"
				                    >
				                    
				                    <!-- <input type="text" placeholder="2014-01-01" class="form-control form_date" data-date-format="yyyy-mm-dd"> -->
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
								
								<div class="input-group input-group-sm editemp_form">
								<div class="col-md-6 column" style="padding: 0px;">
							      <span class="input-group-addon" style="font-size: 12px; padding-left: 10px;">
							        On Job?
							      </span>
							      <span class="input-group-addon" style=" background-color: white;">
							        <input id="eeip_onjob" name="eeip_onjob" type="checkbox" <s:if test="#session.eip_emp.onJob == 1">checked="checked"</s:if>  >
							      </span>
							      <input type="text" class="form-control" style="display: none;">
							     </div>
							    </div>
								
								<div id="leave_date" <s:if test="#session.eip_emp.onJob == 1">style="display: none"</s:if>>
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" style="width: 87px;">Leave Date:</span>
				                    <input id="eeip_leavedate" name="eeip_leavedate" class="form-control red-tooltip" data-date-format="yyyy-mm-dd" type="text" placeholder="Leave Date"
				                    	value="<s:property value="%{getText('format.date',{#session.eip_emp.leaveDate})}"/>"
				                    >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
				                
				                <div id="onjob_alert_info" class="alert alert-info alert-dismissable" <s:if test="#session.eip_emp.onJob == 0">style="display: none"</s:if>>
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									<h4>Alert!</h4>
									<strong>Warning!</strong>  If the employee is not on job, please select a <em>'Leave Date'</em> !
								</div>
								
							</div>				
					</div>
				</div>
			</div>
			</div>
			</form>
			
			<div class="page-footer" style="height: 80px;">
				<p style="float: right; margin-right: 100px; margin-top: 40px;">
				<a id="cancelBtn" href="javascript:history.back()" type="button" class="btn btn-primary btn-sm" role="button" style="margin-right: 10px;">Cancel</a>
				<input id="completeBtn" type="button" class="btn btn-primary btn-sm" value="Save" role="button"/></p>
			</div>
		</div>
	</div>
</div>

<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript">
$(function() {
	
	$('.form_date').datetimepicker({
        language:  'en',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    	});
    	
    	
	$("#eeip_withprobation").change(function() {
            if (!$("#eeip_withprobation").attr("checked")) {
             	
             	$("#eeip_withprobation").attr("checked", "checked"); 
            	/* alert("checked;"); */
         		/* $("#probation_date").css("display","block"); */
         		$("#probation_date").show(300);
         		$("#probation_alert_info").hide(300);
            }else if($("#eeip_withprobation").attr("checked")){
            	$("#eeip_withprobation").removeAttr("checked");
            	
            	/* alert("not checked;"); */
            	/* $("#probation_date").css("display","none"); */
            	$("#probation_date").hide(300);
            	$("#probation_alert_info").show(300);
            }
        });
        
        $("#eeip_onjob").change(function() {
            if (!$("#eeip_onjob").attr("checked")) {
             	
             	$("#eeip_onjob").attr("checked", "checked"); 
            	/* alert("checked;"); */
         		/* $("#probation_date").css("display","block"); */
         		$("#leave_date").hide(300);
         		$("#onjob_alert_info").hide(300);
            }else if($("#eeip_onjob").attr("checked")){
            	$("#eeip_onjob").removeAttr("checked");
            	
            	/* alert("not checked;"); */
            	/* $("#probation_date").css("display","none"); */
            	$("#leave_date").show(300);
            	$("#onjob_alert_info").show(300);
            }
        });
       
	 
	
	$("#completeBtn").click(function() {
		/* alert($("#eeip_chinesename").val()); */
		/* alert($("#eeip_gender").attr("id")); */
		/* alert("before submitted."); */
		 $("#testForm").submit();
		 /* alert("submitted."); */
		/* alert($("#eeip_linemanager").val());
		alert($("#eeip_department").val()); */
		/* alert($("#eeip_department option:selected").attr("id"));
		
		alert($("#eeip_linemanager option:selected").attr("id")); */
		
	});
	
	//Form validate
	 $("#testForm").validate({
			rules: {
				eeip_chinesename: {
					required: true
				},
				eeip_englishname: {
					required: true
				},
				eeip_loginid: {
					required: true
				},
				eeip_birthday: {
					required: true,
					dateISO: true 
				},
				eeip_contractstartdate: {
					required: true,
					dateISO: true 
				},
				eeip_contractenddate: {
					required: true,
					dateISO: true 
				},
				eeip_probationstartdate: {
					/* required: true, */
					dateISO: true 
				},
				eeip_probationenddate: {
					/* required: true, */
					dateISO: true 
				},
				eeip_entrydate: {
					required: true,
					dateISO: true 
				},
				eeip_leavedate: {
					/* required: true, */
					dateISO: true 
				},
				eeip_email: {
					required: true,
					email: true
				},
				eeip_basesalary: {
					required: true,
					number: true
				},
				eeip_socialinsurance: {
					required: true,
					number: true
				},
				/* eeip_creditcard: {
					creditcard: true
				}, */
				
				eeip_annualleaveleft: {
					required: true,
					number: true,
					min: 0
				},
				eeip_identitycard: {
					maxlength: 25					
				},
				eeip_workingage: {
					required: true,
					digits: true
				}
			},
			
			tooltip_options: {
				eeip_chinesename: {
					trigger:'focus'
				},
				eeip_englishname: {
					trigger:'focus'
				},
				eeip_loginid: {
					trigger:'focus'
				},
				eeip_birthday: {
					trigger:'focus'
				},
				eeip_contractstartdate: {
					trigger:'focus'
				},
				eeip_contractenddate: {
					trigger:'focus'
				},
				eeip_probationstartdate: {
					trigger:'focus'
				},
				eeip_probationenddate: {
					trigger:'focus'
				},
				eeip_entrydate: {
					trigger:'focus'
				},
				eeip_leavedate: {
					trigger:'focus'
				},
				
				eeip_email: {
					trigger:'focus'
				},
				
				eeip_basesalary: {
					trigger:'focus'
				},
				eeip_socialinsurance: {
					trigger:'focus'
				},
				/* eeip_creditcard: {
					trigger:'focus'
				}, */
				eeip_annualleaveleft: {
					trigger:'focus'
				},
				
				eeip_identitycard: {
					trigger:'focus'
				},
				eeip_workingage: {
					trigger:'focus'
				}
			},
			
			messages: {
				/* eeip_workingage: {
					required: "请输入一个整数",
					dateISO: "您输入的不是整数，请重新输入"
				}, */
				eeip_birthday: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)" 
				},
				eeip_contractstartdate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				},
				eeip_contractenddate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				},
				eeip_probationstartdate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				},
				eeip_probationenddate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				},
				eeip_entrydate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				},
				eeip_leavedate: {
					dateISO: "Please enter a valid date! (e.g 2014-02-14)"
				}
			}		
	});
	
});

</script>

</body>
</html>