<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Employee</title>
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
  		request.getRequestDispatcher("login.jsp");
  %>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					My HR Info
				</h1>
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="row clearfix">
						<div class="col-md-6 column" style="width: 45%;">
							<img id="img2" alt="140x140" src="img/profile/eip_01.jpg" style="margin-bottom: 30px; padding-left: 40px; padding-top: 20px;">
							<h4><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Profile</h4>
							
							<div id="profile-form">
								<div class="input-group input-group-sm editemp_form editemp_form0">
								  <span class="input-group-addon">Chinese Name:</span>
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.nameChinese'/>">
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form0">
								  <span class="input-group-addon">English Name:</span>
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.nameEnglish'/>" >
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form2">
								  <span class="input-group-addon" >Login ID:</span>
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.empLoginId'/>">
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form2">
								  <span class="input-group-addon" >Gender:</span>
								  <input type="text" class="form-control" value="<s:property value='#session.login.emp.gender'/>">
								</div>
								
				                <div class="input-group input-group-sm editemp_form editemp_form2">
								  <span class="input-group-addon" >Birthday:</span>
								  <input type="text" class="form-control" value="<s:date name='#session.login.emp.birthday' format="yyyy-MM-dd"></s:date>">
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
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.mobile'/>"
								  	>
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span>&nbsp;Office:</span>
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.officePhone'/>">
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon" >
								  <img id="img1" alt="" src="img/icon/skype-24-black.png" width="20px;" height="20px;" style="margin-top: -3px; margin-left: -4px; margin-right: -6px;" >
								  Skype:</span>
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.skype'/>">
								</div>
								<div class="input-group input-group-sm editemp_form editemp_form1">
								  <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>&nbsp;Email:</span>
								  <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.email'/>">
								</div>
								
								<div class="form-group input-group-sm" style="margin-top: 20px;">
									 <label for="" style="margin-bottom: 0px;">Identity Card:</label>
									 <input type="text" class="form-control red-tooltip" value="<s:property value='#session.login.emp.identityCard'/>">
								</div>
								
								<div class="form-group input-group-sm">
									 <label for="exampleInputEmail1" style="margin-bottom: 0px;">Address:</label>
									 <textarea class="form-control" rows="2" cols="44" style="width: 291px; height: 60px; resize: none;" ><s:property value='#session.login.emp.address'/></textarea>
								</div>
								
								<h4 style="margin-top: 40px;"><span class="glyphicon glyphicon-briefcase"></span>&nbsp;&nbsp;Position</h4>
								
																
								<div class="input-group input-group-sm editemp_form editemp_form5" style="">
									<label>Position Title:</label>
				                    <input class="form-control red-tooltip" type="text" style="width: 180px;" 
				                    value="<s:property value='#session.login.emp.positiontitle.positionTitleName'/>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input type="text" class="form-control" style="width: 180px;"
				                    value="<s:date name='#session.login.emp.positionTitleValidate' format="yyyy-MM-dd"></s:date>">
				                </div>
				                
				                
				                
				                <div class="input-group input-group-sm editemp_form editemp_form5" style="">
									<label>Department:</label>
				                    <input class="form-control red-tooltip" type="text" style="width: 180px;" 
				                    value="<s:property value='#session.login.emp.department.departName'/>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input type="text" class="form-control" style="width: 180px;"
				                    value="<s:date name='#session.login.emp.departmentValidate' format="yyyy-MM-dd"></s:date>">
				                </div>
				                
								<div class="input-group input-group-sm editemp_form editemp_form5" style="">
									<label>Line Manager:</label>
				                    <input class="form-control red-tooltip" type="text" style="width: 180px;" 
				                    value="<s:property value='#session.login.emp.emp.empLoginId'/>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input type="text" class="form-control" style="width: 180px;"
				                    value="<s:date name='#session.login.emp.lineManagerValidate' format="yyyy-MM-dd"></s:date>">
				                </div>
								<div class="input-group input-group-sm editemp_form editemp_form5" style="">
									<label>System Role:</label>
				                    <input class="form-control" type="text" style="width: 180px;" 
				                    value="<s:property value='#session.login.emp.role.sysRoleName'/>">
				                </div>
								
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
								  <input type="text" class="form-control" value="<s:property value='#session.login.emp.baseSalary'/>">
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<span class="input-group-addon">Validate:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.baseSalaryValidate' format="yyyy-MM-dd"></s:date>"
				                    >
				                </div>
								
								
								<div class="input-group input-group-sm editemp_form">
								  <span class="input-group-addon">Social Ins. :</span>
								  <input type="text" class="form-control" value="<s:property value='#session.login.emp.socialInsurBase'/>">
								</div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<span class="input-group-addon">Validate:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.socialInsurBaseValidate' format="yyyy-MM-dd"></s:date>"
				                    >
				                </div>
								
								
								<div class="input-group input-group-sm editemp_form editemp_form5">
									<label>MBO:</label>
				                    <input class="form-control red-tooltip" type="text" style="width: 160px;" 
				                    value="<s:property value='#session.login.emp.mbo.mboRate'/> %">
				                </div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input type="text" class="form-control" style="width: 160px;"
				                    value="<s:date name='#session.login.emp.mboValidate' format="yyyy-MM-dd"></s:date>">
				                </div>
								
								
								<div class="input-group input-group-sm editemp_form editemp_form5">
									<label>Cost Center:</label>
				                    <input class="form-control red-tooltip" type="text" style="width: 160px;" 
				                    value="<s:property value='#session.login.emp.costcenter.costCenterName'/>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form editemp_form5" style="margin-bottom: 30px;">
									<label>Validate:</label>
				                    <input type="text" class="form-control" style="width: 160px;"
				                    value="<s:date name='#session.login.emp.costCenterValidate' format="yyyy-MM-dd"></s:date>">
				                </div>
								
								<div class="form-group input-group-sm" style="margin-top: 20px;">
									 <label for="exampleInputEmail1" style="margin-bottom: 0px;"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;Credit Card:</label>
									 <input type="text" class="form-control" value="<s:property value='#session.login.emp.creditCardNumber'/>"
									 >
								</div>
								
								<div style="margin-top: 40px;">
								<label>Work place:</label>
								<div class="input-group input-group-sm editemp_form">
								  <span class="input-group-addon">Workplace:</span>
								  <input type="text" class="form-control" value="<s:property value='#session.login.emp.workplace'/>"
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
								  <span class="input-group-addon" style="width: 110px;">Working Age:</span>
								  <input type="text" class="form-control" value="<s:property value='#session.login.emp.workingAge'/>"
								  >
								</div>
								
								
								<div id="probation_date">
								<div class="input-group input-group-sm editemp_form">
									<span class="input-group-addon" >Probation Start:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.porbationStartDate' format="yyyy-MM-dd"></s:date>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" style="width: 110px;" >Probation End:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.porbationEndDate' format="yyyy-MM-dd"></s:date>">
				                </div>
				                
				                <div class="input-group input-group-sm editemp_form">
									<span class="input-group-addon" style="width: 110px;">Contract Start:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.contractStartDate' format="yyyy-MM-dd"></s:date>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
									<span class="input-group-addon" style="width: 110px;" >Contract End:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.contractEndDate' format="yyyy-MM-dd"></s:date>">
				                </div>
								</div>
																
								</div>
								
								<div class="input-group input-group-sm editemp_form">
									<span class="input-group-addon" style="width: 110px;">Contract Type:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.contracttype.contractTypeName' format="yyyy-MM-dd"></s:date>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form">
									<span class="input-group-addon" style="width: 110px;" >Employee Type:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.emptype.empTypeName' format="yyyy-MM-dd"></s:date>">
				                </div>
								
								<div class="input-group input-group-sm editemp_form">
									<span class="input-group-addon" style="width: 110px;" >Entry Date:</span>
				                    <input class="form-control" type="text" value="<s:date name='#session.login.emp.entryDate' format="yyyy-MM-dd"></s:date>">
				                </div>
								
							</div>				
					</div>
				</div>
			</div>
			</div>
			
		</div>
	</div>
</div>

<%-- <script src="js/html5shiv.js"></script> --%>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>