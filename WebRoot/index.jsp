<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>

<style type="text/css">
.selectpicker_class2{
	height:34px;
	margin-bottom: 10px;
}

.selectpicker_class2 .bootstrap-select{
	width: 300px;
}

.selectpicker_class2 input{
	/* margin-right: 5px; */
	height: 34px;
}

.red-tooltip + .tooltip > .tooltip-inner{background-color: #FF6633;}
.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #FF6633;}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript">
$(function() {
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
	
	$("#confirmupdateTS").removeAttr('disabled');
	
	$("#updateTSform").validate({
		rules: {
			uts_startDate: {
				required: true, 
				dateISO: true
			}
		},
		
		tooltip_options: {
			eeip_chinesename: {
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
			}
		}
	});
	
	$("#confirmupdateTS").click(function() {
		$("#confirmupdateTS").attr('disabled', 'disabled');
		$("#updateTSform").submit();
	});
	
});

</script>
</head>
<%
  	if(session.getAttribute("login") == null) {
  		/* request.getRequestDispatcher("login.jsp"); */
		response.sendRedirect("login.jsp");	
  	}
  %>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="carousel slide" id="carousel-156293">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-156293">
					</li>
					<li data-slide-to="1" data-target="#carousel-156293">
					</li>
					<li data-slide-to="2" data-target="#carousel-156293">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/temp/bus01.jpg" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/temp/bus02.jpg" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/temp/tec02.jpg"/>
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-156293" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-156293" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
	<div class="row clearfix" style="margin-top: 50px;">
		<div class="col-md-7 column">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<form action="empInfoAction" class="navbar-form navbar-right" role="search" method="post">
					<div class="form-group selectpicker_class2" style="margin-left: 15px;">
						<select id="" name="empLoginId" class="selectpicker" data-live-search="true">
						    <s:iterator var="lmItor" value="#session.login.allLoginIds" status="st">
						   		<option
						   		><s:property value="#lmItor"/></option>
						   	</s:iterator>
						 </select>
					</div>
					<button style="margin-left: 20px;" type="submit" class="btn btn-default"><span style="color: #3276B1;" class="glyphicon glyphicon-search"></span>&nbsp;Search</button>
				</form>
			</div>
		</div>
		<form id="updateTSform" action="updateTSTableAction" method="post">
		<div class="col-md-3 column">
			<div class="input-group input-group-sm date form_date selectpicker_class2" style="margin-top: 8px;" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<span class="input-group-addon">Start Date:</span>
		             <input style="height: 34px;" id="uts_startDate" class="form-control red-tooltip" name="uts_startDate" data-date-format="yyyy-mm-dd" type="text" value='<s:property value="#session.index_startDate"/>' placeholder="2014-05-01">
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>
		<div class="col-md-1 column" >
			<a id="uts_submit" href="#modal-container-confirmupdateTS" style="margin-top: 8px;" class="btn btn-primary" data-toggle="modal">Update Time Sheet</a>
			<!-- <a id="testsendMail" href="#modal-container-sendPayrollMail" role="button" class="btn btn-primary btn-sm" data-toggle="modal">Send Mail</a> -->
		</div>
		</form>
	</div>
</div>

<!-- Delete -->
<div class="modal fade" id="modal-container-confirmupdateTS" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 200px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
				<h4 class="modal-title" id="myModalLabel">
					Update Time Sheet Table?
				</h4>
			</div>
			<div class="modal-body">
				Do you really want to update Time Sheet Table?
			</div>
			<div class="modal-footer">
				 <button id="confirmupdateTS" type="button" class="btn btn-primary btn-sm">Yes</button>
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" style="margin-left: 15px;">No</button> 
			</div>
		</div>
	</div>
</div>

</body>
</html>