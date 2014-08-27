<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/style_new.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					My Vacation Left/Used Info
				</h1>
			</div>
			<div class="col-md-1 column">
			</div>
			<div class="col-md-10">
			<div class="tabbable" id="">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-vacationInfoPanel" data-toggle="tab">Vacation Left Info</a>
					</li>
					<li>
						<a href="#panel-vacationHistoryPanel" data-toggle="tab">Vacation History</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-vacationInfoPanel">
						<div class="panel panel-primary" style="margin-top: 30px;">
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
								          <th class="col-md-6" id="vaadmin_annualleft"><s:property value="#session.myvacationinfo.annualTotalLeft"/> hrs.</th>
								        </tr>
							      </tbody>
								</table>
								
								<table class="table" style="margin-bottom: 0px;">
								   <th class="col-md-6">Compensatory Left:</th>
								   <th class="col-md-6" id="vaadmin_compenleft">
								   	<s:property value="#session.myvacationinfo.compenTotalLeft"/> hrs. <small>(Excluding expired, marked as red.)</small>
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
							      	<s:iterator value="#session.myvacationinfo.compensatorys" var="compenItor">
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
					<div class="tab-pane" id="panel-vacationHistoryPanel">
						<p></p>
						<div class="panel panel-primary" style="margin-top: 30px;">
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
							      	<s:iterator value="#session.myvacationinfo.histories" var="myvahistoryItor">
							      		<tr>
							      			<td><s:property value="#myvahistoryItor[0]"/></td>
							      			<td><s:property value="#myvahistoryItor[1]"/></td>
							      			<td><s:property value="#myvahistoryItor[2]"/></td>
							      			<td><s:property value="#myvahistoryItor[3]"/></td>
							      			<td><s:property value="#myvahistoryItor[4]"/></td>
							      			<td><s:property value="#myvahistoryItor[5]"/></td>
							      			<td><s:property value="#myvahistoryItor[6]"/></td>
							      		</tr>
							      	</s:iterator>
							      </tbody>
							    </table>
							    <ul id="pagination_vacationchangeHistory" class="pagination pagination-sm pull-right pagination_vacationchangeHistory"></ul>
							    <input id="pagination_totalpage" type="hidden" value="<s:property value='#session.myvacationinfo.totalpage'/>"/>
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
<script type="text/javascript" src="js/jqueryPagination/jquery.twbsPagination.js"></script>
<script type="text/javascript">
$(function() {
	 // pagination for absence Requests
	$('#pagination_vacationchangeHistory').twbsPagination({
	    totalPages: $("#pagination_totalpage").val().trim(),
	    visiblePages: 5,
	    startPage: 1,
	    onPageClick: function (event, page) {
	    	var params = {
	    		"request_pageno" : page
	    	};
	        $.ajax({
	            url: "getMyVacationInfoPagination",
	            type: "post",
	            data: params,
	            dataType: "json",
	            success: function(vlidata) {
	            	// Vacation Change History Details
	    	   var history_content = "";
	    	   $("#compenleftInfo_histories").html("");
	    	   if(vlidata.myvacationEntity.histories.length > 0) {
		    	   for( var k = 0; k < vlidata.myvacationEntity.histories.length; k++) {
		    		   history_content += "<tr><td>" + vlidata.myvacationEntity.histories[k][0] + 
		    		   "</td><td>" + vlidata.myvacationEntity.histories[k][1] + 
		    		   "</td><td>" +
		    		   vlidata.myvacationEntity.histories[k][2] + "</td><td>" + 
		    		   vlidata.myvacationEntity.histories[k][3] + "</td><td>" +
		    		   vlidata.myvacationEntity.histories[k][4] + "</td><td>" +
		    		   vlidata.myvacationEntity.histories[k][5] + "</td><td>" +
		    		   vlidata.myvacationEntity.histories[k][6] + "</td></tr>";
		    	   }
		    	   
	    	   } else {
	    	   		history_content += "<tr><td colspan='7' ><h4 style='padding:20px 20px; text-align: center;'>Oops, No result has been found!</h4></td></tr>";
	    	   }
	    	   $("#compenleftInfo_histories").append(history_content);
	            },
	            error: function() {
	            	alert("ajax 请求失败： ");
	            }
	        });
	    } 
	            
	});
});
</script>

</html>