<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<!-- <link href="css/bootstrap3-datetimepicker.min.css" rel="stylesheet"/> -->
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="css/bootstrap-select1.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet"/>
<style type="text/css">
#preview {
position: relative;
background: black;
color: #fff;
float: left;
width: 268px;
height: 268px;
margin: 0 20px 20px 0;
-webkit-border-radius: 10px;
-moz-border-radius: 10px;
border-radius: 10px;
}

#foo {
	/* position: relative;
    width: 50px;
    height: 50px; */
}
</style>

<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.editableonlynumber.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="js/bootstrap3-datetimepicker.min.js"></script> -->
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/spin.min.js"></script>
<script type="text/javascript" src="js/jquery.spin.js"></script>

</head>
<body id="foo">
<p><a href="index.jsp">index page</a><br></p>
<p><a href="toFinancialStatementInfoPageAction">FinancialStatement</a><br></p>
<a href="salaryInfoAction?empLoginId=jennifers">SalaryInfoPage_jennifers</a><br>
<a href="salaryInfoAction?empLoginId=jasonzh">SalaryInfoPage_jasonzh</a><br>
<a href="salarySettingAction">SalarySettingPage</a><br>
<a href="empInfoAction?empLoginId=jennifers">EmployeeInfoPage</a><br><br>
<a href="toCreateEmpPageAction">CreateEmpPage</a><br><br>
<a href="summaryTsInfoAction">SummaryTsInfoPage</a><br><br>

<a href="hRBaseInfoAction?operationFlag_tohbip=tohrBaseInfoPage">HRBaseInfoPage</a><br><br>

<a href="toEmpHistoryInfoPage?ehisip_empLoginId=abbys">Employee History Info Page</a><br><br>

<a href="timeSheetTrackAction?operationFlag_tstp=totimesheettrackpage">Time Sheet Track Page</a><br><br>

<a href="payrollConfirmationAction">PayrollConfirmationPage</a><br><br>
<a href="logoffAction">testlogoff</a><br><br>
<!--  -->
<a href="absenceRequestAction_loadRequestPage" id="testLinktoRequest">Link to Request.jsp</a><br><br>

<a href="loadVCAdmin">Load Compensatory Admin Page</a><br><br>

<a href="getOvertimeRequestRecord?overtimeRequestRecordId=6">overtimeRequestRecord</a><br><br>

<a href="loadAbsenceRequestReject?absenceRequestEntity.id=17">RequestAbsenceRejected.jsp</a><br><br>

<a href="loadOvertimeRequestReject?overtimeReApplyEntity.id=17">RequestOvertimeRejected.jsp</a><br><br>

<a href="loadAbsenceOvertimeTrack">AbsenceOvertimeTrack</a><br><br>

<a href="loadVacationAdminPage">vacationLeftAdmin.jsp</a><br><br>

<a href="login.jsp?redirectlink=redirectaction">TestRedirectLink</a><br><br>


<a href="#" id="test001" >下一步</a> 

<!-- <a href="sendPayrollMailAction">Send a email</a> -->
<p><span class="glyphicon glyphicon-asterisk"></span></p>
<h3><span style="color: green;" class="glyphicon glyphicon-envelope"></span></h3>


<form action="testAction1" method="post">
	<input type="text" name="testGetLoginID">
	<input type="submit" value="Submit">
</form>

<div class="container">
    <div class="col-sm-6" style="height:75px;">
       <!-- <div class='col-md-5'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker8'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <div class='col-md-5'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker9'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div> -->
        
        <div class="input-group input-group-sm date form_date" data-date="" data-date-format="yyyy-mm-dd hh:mm:ss" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
			<span class="input-group-addon">Birthday:</span>
               <!-- <input id="eeip_birthday" class="form-control red-tooltip" name="eeip_birthday" data-date-format="yyyy-mm-dd hh:mm:ss" type="text" placeholder="Birthday" style="width: 127px;"
               > -->
               <input size="16" type="text" value="2012-06-15 14:45" readonly class="form-control form_datetime">
			<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        </div>
        
        <!-- <input size="16" type="text" value="2012-06-15 14:45" readonly class="form_datetime"> -->
		<script type="text/javascript">
		    /* $(".form_datetime").datetimepicker({
		    	format: 'yyyy-mm-dd hh:ii'
		    	
		    }); */
		</script>  
    </div>
    <script type="text/javascript">
        $(function () {
            /* $('#datetimepicker8').datetimepicker();
            $('#datetimepicker9').datetimepicker();
            $("#datetimepicker8").on("dp.change",function (e) {
               $('#datetimepicker9').data("DateTimePicker").setMinDate(e.date);
            });
            $("#datetimepicker9").on("dp.change",function (e) {
               $('#datetimepicker8').data("DateTimePicker").setMaxDate(e.date);
            }); */
        	/* $('.form_datetime').datetimepicker({
        		format: 'yyyy-mm-dd hh:ii',
                language:  'en',
                weekStart: 1,
                todayBtn:  1,
        		autoclose: 1,
        		todayHighlight: 1,
        		startView: 2,
        		minView: 2,
        		forceParse: 0
            	}); */
            	
        	var oldContent = ""; //文本变化前的内容，使用它和新内容对比，发生了变化才发送ajax请求
            $ ("#content" ).keyup(function(){
                   var content = $.trim($ ("#content" ).val());
                   if(content == "" || content == oldContent){
                         return; //没有输入内容或者文本内容没有发生变化时就返回
                  }
                  oldContent = content;
                   var params = { "input": $.trim($ ("#content" ).val())};
                   $.ajax({
                        url: "getKeyword",
                        type: "post",
                        data:params,
                        dataType: "json",
                        success: function(data){
                               //alert(JSON.stringify(data));
                               if(data.keywords.length == 0){
                                     //没有关键字就隐藏提示框，并返回
                                     $("#suggest").hide();
                                     return;
                              }
                               $("#suggest").show().html( ""); //显示提示框并清空提示框
                               //添加关键字列表
                               for( var i=0;i<data.keywords.length;i++){
                                     $("#suggest").append( "<div class='keyword'>"+data.keywords[i]+"</div>");
                              }
                               //为新添加的关键字列表添加事件
                               $(".keyword").live( "mousemove", function(event){
                                     //鼠标移入背景变成灰色
                                     $(event.target).css("background-color", "silver");
                              });
                               $(".keyword").live( "mouseout", function(event){
                                     //鼠标移出背景变成白色
                                     $(event.target).css("background-color", "white");            
                              });
                               $(".keyword").live( "dblclick", function(event){
                                     //双击时把内容加入到输入框
                                     $("#content").val($ (event.target).html());
                                     $("#suggest").hide();
                                    oldContent = "";
                              });
                        },
                        error: function(){
                              alert( "Ajax请求出错");
                        }
                  });
            });
        	
        	
            
        	/* $("#test001").on("click", function () {
        		alert("start");
        		$("#testLinktoRequest").attr('href','absenceRequestAction_loadRequestPage');
        		alert("end");
        		/* var params = {
            			"request_info_executor" : "JasonL",
            			"request_info_pageSize" : 5,
            			"request_info_page" : 1
            	};
        		alert("ajax");
                $.ajax({
                    url: "requestInfo",
                    type: "post",
                    data: params,
                    dataType: "json",
                    success: function(data) {
                    	alert($("#testLinktoRequest").attr("href"));
                    },
                    error: function() {
                          alert("ajax请求失败");
                    }
              }); 
        	});*/
        	
        	$("#testmodal").click(function() {
        		$("#modal-container-requestInfo").modal();
        	});
        	
        	
        	/* var opts = {
        			  lines: 7, // The number of lines to draw
        			  length: 31, // The length of each line
        			  width: 16, // The line thickness
        			  radius: 34, // The radius of the inner circle
        			  corners: 1, // Corner roundness (0..1)
        			  rotate: 0, // The rotation offset
        			  direction: 1, // 1: clockwise, -1: counterclockwise
        			  color: '#000', // #rgb or #rrggbb or array of colors
        			  speed: 0.5, // Rounds per second
        			  trail: 48, // Afterglow percentage
        			  shadow: false, // Whether to render a shadow
        			  hwaccel: false, // Whether to use hardware acceleration
        			  className: 'spinner', // The CSS class to assign to the spinner
        			  zIndex: 2e9, // The z-index (defaults to 2000000000)
        			  top: '50%', // Top position relative to parent
        			  left: '50%' // Left position relative to parent
        			};
      			var target = $("#preview");
      			var spinner = new Spinner(opts).spin(target); */
      			/* var spinner = new Spinner().spin();
      			target.appendChild(spinner.el); */
   			$.fn.spin.presets.bodyspin = ({
   				  lines: 12, // The number of lines to draw
	   			  length: 20, // The length of each line
	   			  width: 6, // The line thickness
	   			  radius: 20, // The radius of the inner circle
	   			  color: 'silver', // #rgb or #rrggbb or array of colors
	   			  trail: 40, // Afterglow percentage
   			});

        	 $('body').spin('bodyspin');
        	
        });
        
    </script>
</div>

<div id="preview">


</div>

<div>说明：由于提供的关键字有限，请输入"北"字查看效果 </div >
      <div id ="searchDiv">
           <form action ="">
                 <input id ="content" type="text">
                 <input id ="search-btn" type="button" value= "查询"><br >
                 <div id ="suggest"></div>
           </form >
      </div >
      
 <div>
 <a href="testAction3">testAction3</a>
 	<p>
 		<s:property value="#session.test_info_ar.empLoginId"/>
 	</p>
 	<p>
 		<s:property value="#session.test_info_ar.absenceReason"/>
 	</p>
 	<p>
 		<s:property value="#session.test_info_ar.requeststate.stateName"/>
 	</p>
 	<p>
 		size():<s:property value="#session.test_info_ar.absencerequestitems.size()"/>
 	</p>
 	<h5>
	 	<s:iterator var="absenceItem" value="#session.test_info_ar.absencerequestitems">
	 		<p><s:property value="#absenceItem.itemId"/></p>
	 		<p><s:property value="#absenceItem.vacationtype.timeSheetOrderId"/></p>
	 		<p><s:property value="#absenceItem.absenceHours"/></p>
	 		<p><s:property value="#absenceItem.absenceStartTime"/></p>
	 		<p><s:property value="#absenceItem.absenceEndTime"/></p>
	 		<p><s:date name="#absenceItem.absenceEndTime" format= "yyyy-MM-dd HH:mm:ss"/></p>
	 		<br><br>
	 	</s:iterator>
 	</h5>
 </div>


<a id="testmodal" href="#" class="btn btn-primary" data-toggle="modal">testModal</a>
<!-- Add -->
<div class="modal fade" id="modal-container-requestInfo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 800px;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Emp Type
				</h4>
			</div>
		<form id="hrbip_form_AddEmpType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<div class="panel panel-default request_panel">
				  <div class="panel-heading">
				    <h3 class="panel-title">Personal Info</h3>
				  </div>
				  <div class="panel-body request_panel_body">
				   		<table class="table table-bordered table-condensed">
							<tbody>
								<tr>
									<td>
										Employee
									</td>
									<td>
										<input name="request_absence_empLoginId" class="noborderinupt" readonly="readonly" value="jasonzh">
									</td>
									<td>
										Department
									</td>
									<td>
										MD
									</td>
								</tr>
							</tbody>
							<tbody>
								<tr>
									<td>
										Line Manager
									</td>
									
									<td class="empselect_request" style="padding: 0px; width: 200px;">
										<select id="request_absence_lineManager" name="request_absence_lineManager" class="selectpicker" data-live-search="true">
										    <s:iterator var="lmItor" value="#session.loginviewList">
										   		<option><s:property value="#lmItor" /></option>
										   	</s:iterator>
										 </select>
									</td>
									<td>
										PM
									</td>
									<td class="empselect_request" style="padding: 0px; width: 200px;">
										<select id="request_absence_pm" name="request_absence_pm" class="selectpicker" data-live-search="true">
										    <s:iterator var="lmItor" value="#session.loginviewList">
										   		<option><s:property value="#lmItor" /></option>
										   	</s:iterator>
										 </select>
									</td>
								</tr>
							</tbody>
							<tbody>
							<tr>
								<td>
									Leave Reason:
								</td>
								<td colspan="8">
									<!-- <textarea id="request_absence_reason" name="request_absence_reason" type="text" class="form-control" style="resize: none;" id="" placeholder="null"></textarea> -->
									<p>This is the reason.</p>
								</td>
							</tr>
						</tbody>
						</table>
				  	</div>
				</div>
				<div class="panel panel-default request_panel">
				  <div class="panel-heading">
				    <h3 class="panel-title">Absence Info
				    	<a style="cursor: pointer;" id="addleaverequest" class="tooltips" data-toggle="tooltip" data-placement="top" title="Add a New"></a>
				    </h3>
				  </div>
					<div class="panel-body request_panel_body" style="max-height: 300px; overflow: auto;">
				   		<table class="table table-bordered ">
							<tbody id="leaverequesttbody">
								<tr>
									<td>
										Leave Type:
									</td>
									<td>
										(70) - 事假
									</td>
									<td>
										Start Time:
									</td>
									<td>
								        2014-07-11 11:30
									</td>
									<td>
										End Time:
									</td>
									<td>
										2014-07-11 15:30
									</td>
									<td>
										4.0 hrs
									</td>
								</tr>
							</tbody>
					</table>
				  	</div>
				</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>
<%-- <script type="text/javascript">
$(function() {
	$('#preview').spin('large', 'red');
})
</script> --%>

<p>asdgasdghasdg</p>
<!-- <div id="foo"></div> -->
<button id="spin"> Spin! </button>

<%-- <script type="text/javascript">
$(function() {
	var opts = {
			  lines: 13, // The number of lines to draw
			  length: 17, // The length of each line
			  width: 8, // The line thickness
			  radius: 21, // The radius of the inner circle
			  corners: 1, // Corner roundness (0..1)
			  rotate: 58, // The rotation offset
			  direction: 1, // 1: clockwise, -1: counterclockwise
			  color: 'red', // #rgb or #rrggbb or array of colors
			  speed: 0.9, // Rounds per second
			  trail: 100, // Afterglow percentage
			  shadow: false, // Whether to render a shadow
			  hwaccel: false, // Whether to use hardware acceleration
			  className: 'spinner', // The CSS class to assign to the spinner
			  zIndex: 2e9, // The z-index (defaults to 2000000000)
			  top: '50%', // Top position relative to parent
			  left: '50%' // Left position relative to parent
			};

			$("#spin").click(function(){
			  var target = document.getElementById('foo');
			  target.dispatchEvent(event);
			  var spinner = new Spinner(opts).spin(target);
			});
				
})
</script> --%>


</body>
</html>