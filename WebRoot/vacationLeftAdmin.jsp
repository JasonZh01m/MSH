<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="css/style_new.css" rel="stylesheet" />
<style type="text/css">
.bootstrap-select.btn-group button {
	height: 34px;
	width: 223px;
}

</style>

</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					Employee Vacation Manage <small>vacation</small>
				</h1>
			</div>
			<!-- <div class="row clearfix">
				<div class="col-md-6 column">
				</div>
				<div class="col-md-6 column">
				</div>
			</div> -->
			<div class="col-md-4" style="padding-top: 40px;">
					<form id="vacationLeftAdminForm" class="form-horizontal" role="form" action="addVacation" method="post">
						<input id="test_vacationmanage_operationFlag" name="vacationLeftAdminEntity.operationFlag" value="" type="hidden">
						<div class="form-group">
							<label for="tvaadmin.emploginid" class="col-sm-4 control-label">Employee:</label>
							<div class="col-sm-8">
								<select id="vaadmin_emploginid" name="vacationLeftAdminEntity.emploginid" class="selectpicker" data-live-search="true">
								    <s:iterator var="lmItor" value="#session.login.allLoginIds">
								   		<option 
								   		<s:if test="#session.vacationAdminObject.emploginid.equals(#lmItor)">selected="selected"</s:if>
								   		 ><s:property value="#lmItor" /></option>
								   	</s:iterator>
								 </select>
							</div>
						</div>
						<p>
							添加调休
						</p>
						
						<div class="form-group">
							<label for="test_vacationmanage_edate" class="col-sm-4 control-label">Expired Date:</label>
							<div class="col-sm-8">
								<input type="text" data-date-format="yyyy-mm-dd" class="form-control form_date" id="test_vacationmanage_edate" name="vacationLeftAdminEntity.compenExpireDate" readonly />
							</div>
						</div>
						<div class="form-group">
							<label for="test_vacationmanage_hours" class="col-sm-4 control-label">Hours:</label>
							<div class="col-sm-8"> 
								<input type="text" class="form-control" id="test_vacationmanage_hours" name="vacationLeftAdminEntity.compenAdd" placeholder="Add Compensatory Hours"/>
							</div>
						</div>
						<div class="form-group">
							<label for="test_vacationmanage_desc" class="col-sm-4 control-label">Description:</label>
							<div class="col-sm-8">
								<textarea style="resize: none;" rows="4" type="text" class="form-control" id="test_vacationmanage_desc" name="vacationLeftAdminEntity.compenDesc"  placeholder="Compensatory Vacation Description"></textarea>
							</div>
						</div>
						<!-- style="display: block;" -->
						<div class="row">
							<div class="column col-md-12">
								<input id="addCompensatoryBtn" class="btn btn-primary pull-right" type="button" value="Add Compensatory">
							</div>
						</div>
						
						<p>添加年假</p>
						<div class="form-group">
							<label for="test_vacationmanage_hours" class="col-sm-4 control-label">Hours:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="test_vacationmanage_hours" name="vacationLeftAdminEntity.annualAdd" placeholder="Add Annual Hours" />
							</div>
						</div>
						<div class="form-group">
							<label for="test_vacationmanage_desc" class="col-sm-4 control-label">Description:</label>
							<div class="col-sm-8">
								<textarea style="resize: none;" rows="4" type="text" class="form-control" id="test_vacationmanage_desc" name="vacationLeftAdminEntity.annualDesc"
								placeholder="Annual Vacation Description"
								></textarea>
							</div>
						</div>
						<div class="pull-right">
							<input id="addAnnualBtn" class="btn btn-primary" type="button" value="Add Annual">
						</div>
					</form>
				</div>
					
			<div class="col-md-8">
			<div class="tabbable" id="">
				<ul class="nav nav-tabs">
					<li>
						<a href="#panel-vacationInfoPanel" data-toggle="tab">Vacation Left Info</a>
					</li>
					<li class="active">
						<a href="#panel-vacationHistoryPanel" data-toggle="tab">Vacation History</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="panel-vacationInfoPanel">
						<p>This is content in vacationInfoPanel</p>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									Vacation Left Info:
								</h3>
							</div>
							<div class="panel-body">
								<table class="table">
									<tbody>
								        <tr>
								          <th class="col-md-6">Annual Left:</th>
								          <th class="col-md-6" id="vaadmin_annualleft"><s:property value="#session.vacationAdminObject.annualTotalLeft"/> hrs.</th>
								        </tr>
							      </tbody>
								</table>
								
								<table class="table" style="margin-bottom: 0px;">
								   <th class="col-md-6">Compensatory Left:</th>
								   <th class="col-md-6" id="vaadmin_compenleft">
								   	<s:property value="#session.vacationAdminObject.compenTotalLeft"/> hrs. <small>(Excluding expired, marked as red.)</small>
								   </th>
								</table>
								
								 <table class="table table-bordered table-hover table-striped">
							      <thead>
							        <tr>
							          <th>ID</th>
							          <th>Left</th>
							          <th class="col-md-2">Expired Date</th>
							          <th class="col-md-2">Create Date</th>
							          <th class="col-md-6">Description
							          </th>
							        </tr>
							      </thead>
							      <tbody id="compenleftInfo_details">
							      	<s:iterator value="#session.vacationAdminObject.compensatorys" var="compenItor">
							      		<tr>
							      			<td><s:property value="#compenItor[0]"/></td>
							      			<td><s:property value="#compenItor[1]"/></td>
							      			<td class="<s:property value='#compenItor[5]'/>" >
							      				<s:property value="#compenItor[2]"/>
							      			</td>
							      			<td><s:property value="#compenItor[3]"/></td>
							      			<td><s:property value="#compenItor[4]"/></td>
							      		</tr>
							      	</s:iterator>
							      </tbody>
							    </table>
							</div>
							<div class="panel-footer" style="text-align: right;">
							</div>
						</div>
					</div>
					<div class="tab-pane active" id="panel-vacationHistoryPanel">
						<p>This is content in vacationHistoryPanel</p>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									Vacation Change History
								</h3>
							</div>
							<div class="panel-body" style="overflow-x: scroll;">
								 <table class="table table-bordered table-hover table-striped">
							      <thead style="white-space:nowrap;">
							        <tr>
							          <th> ID </th>
							          <th>+ / -</th>
							          <th>Hours</th>
							          <th> Type </th>
							          <th> By </th>
							          <th> Date </th>
							          <th> Desc </th>
							        </tr>
							      </thead>
							      <tbody id="compenleftInfo_histories" style="white-space:nowrap;">
							      	<s:iterator value="#session.vacationAdminObject.histories" var="vahistoryItor">
							      		<tr>
							      			<td><s:property value="#vahistoryItor[0]"/></td>
							      			<td><s:property value="#vahistoryItor[1]"/></td>
							      			<td><s:property value="#vahistoryItor[2]"/></td>
							      			<td><s:property value="#vahistoryItor[3]"/></td>
							      			<td><s:property value="#vahistoryItor[4]"/></td>
							      			<td><s:property value="#vahistoryItor[5]"/></td>
							      			<td><s:property value="#vahistoryItor[6]"/></td>
							      		</tr>
							      	</s:iterator>
							      </tbody>
							    </table>
							    
							    <ul id="pagination_vacationchangeHistory" class="pagination pagination-sm pull-right pagination_vacationchangeHistory"></ul>
							    <input id="pagination_totalpage" type="hidden" value="<s:property value='#session.vacationAdminObject.totalpage'/>"/>
							</div>
							<div class="panel-footer" style="text-align: right;">
							</div>
						</div>
						
					</div>
				</div>
			</div>
			
				</div>
		</div>
	</div>
</div>
<s:debug></s:debug>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/jqueryPagination/jquery.twbsPagination.js"></script>
<script type="text/javascript" src="js/vacationAdmin.js"></script>
<script type="text/javascript">
$(".form_date").datetimepicker({
	format: 'yyyy-mm-dd',
	minView: 2,
	autoclose: true,
	pickerPosition: "bottom-left",
	todayBtn: true,
	todayHighlight: 1
});
</script>
</html>