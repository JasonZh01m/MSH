$(".selectpicker").selectpicker();

var affarisNum = 0;
var absenceAffarisNum = 0;
var overtimeAffairsNum = 0;

function affarisNum() {
	alert("进入 affairsNum 方法》》。");
	var sumAffaris = absenceAffarisNum + overtimeAffairsNum;
	alert(sumAffaris);
	if(sumAffaris > 0) {
		alert("sumAffaris > 0");
		$("#request_totalaffaris").text(sumAffairs);
	} else {
		alert("sumAffaris <= 0");
		$("#request_totalaffaris").hide();
	}
}

/**
 * 两个时间之间的差值
 */
function GetDateDiff(startTime, endTime, diffType) { 
	//将xxxx-xx-xx的时间格式，转换为 xxxx/xx/xx的格式 
	startTime = startTime.replace(/\-/g, "/");
	endTime = endTime.replace(/\-/g, "/");
	//将计算间隔类性字符转换为小写 
	diffType = diffType.toLowerCase();
	var sTime = new Date(startTime); //开始时间
	var eTime = new Date(endTime); //结束时间 
	//作为除数的数字 
	var divNum = 1; 
	switch (diffType) {
	case "second": 
	divNum = 1000; 
	break;
	case "minute":
	divNum = 1000 * 60;
	break;
	case "hour": 
	divNum = 1000 * 3600;
	break;
	case "day": 
	divNum = 1000 * 3600 * 24;
	break; 
	default: 
	break; 
	} 
	return parseInt((eTime.getTime() - sTime.getTime()) / parseInt(divNum)); 
}

/*
 * Show tooltips
 */
/*$(".tooltips").tooltip();
*/

/**
 * DateTimePicker format
 */
$(".form_datetime_request").datetimepicker({
	format: 'yyyy-mm-dd hh:ii',
	minuteStep: 30,
	autoclose: true,
	pickerPosition: "bottom-left",
	todayBtn: true,
	todayHighlight: 1
}).on('hide', function() {
	// 面板隐藏之后出发动作
	var trParent = $(this).parent().parent();
	var startTime = trParent.find("input.startTime_request").val();
	var endTime = trParent.find("input.endTime_request").val();
	var totalTd = trParent.find("td.totaltime_request");
	var minutes = GetDateDiff(startTime.trim(), endTime.trim(), "minute");
	var hrs = minutes / 60;
	totalTd.html(parseFloat(hrs).toFixed(1));
	
	// 计算 Total Absence hours
	
});

/**
 * 添加行for Absence Request
 */
$("#addleaverequest").click(function() {
	event.preventDefault();
	// 插入新行
	var newRow = jQuery("<tr><td>Leave Type:</td><td class='empselect_request' style='padding: 2px; width: 115px;'>" +
			"<select class='leavetype_request selectpicker' data-live-search='true'>" +
				"<option value='1'>(70) - 事假</option>" + 
				"<option value='3'>(57) - 长病假/婚假/丧假</option>" + 
				"<option value='4'>(58) - 病/产/哺乳/男方护理假</option>" + 
				"<option value='5'>(61) - 调休</option>" + 
				"<option value='6'>(61) - 年假</option>" + 
			"</select></td>" +
			"<td>Start Time:</td><td style='padding: 3px;'>	<input size='16' type='text' readonly class='form-control form_datetime_request input-sm startTime_request'></td>" +
			"<td>End Time:</td><td style='padding: 3px;'><input size='16' type='text' readonly class='form-control form_datetime_request input-sm endTime_request'></td>" +
			"<td>Total:</td><td class='totaltime_request'></td><td>" +
			"<a style='cursor: pointer; padding-left:7px;' class='deleteleaverequest'><span class='glyphicon glyphicon-minus'></span></a></td></tr>");
	
	$("#leaverequesttbody").append(newRow);
	$(".selectpicker").selectpicker();
	
	$(".form_datetime_request").datetimepicker({
		format: 'yyyy-mm-dd hh:ii',
		minuteStep: 30,
		autoclose: true,
		pickerPosition: "bottom-left",
		todayBtn: true,
		todayHighlight: 1
	}).on('hide', function() {
		var trParent = $(this).parent().parent();
		var startTime = trParent.find("input.startTime_request").val();
		var endTime = trParent.find("input.endTime_request").val();
		var totalTd = trParent.find("td.totaltime_request");
		var minutes = GetDateDiff(startTime.trim(), endTime.trim(), "minute");
		var hrs = minutes / 60;
		totalTd.html(parseFloat(hrs).toFixed(1));
	});
	
	/**
	 * 删除行
	 */
	$(".deleteleaverequest").click(function() {
		$(this).parent().parent().remove();
	});
});


/**
 * 添加行for Overtime Request
 */
var counter = 0;
var optionshtml = "";
$("#addovertimerequest").click(function() {
	event.preventDefault();
	counter++;
	if(optionshtml == "") {
		optionshtml = $("#testinnerhtml").html(); // 取得所有员工的LoingId, 即：option value
	}
	// 插入新行
	var newRow = 
			"<tr>\n" +
			"		<td class='empselect_request' style='padding:3px; width: 200px;'>\n" +
			"			<select id='testselectoption" + counter + "' name='' class='selectpicker overtimerequestemp' data-live-search='true'>\n" +
			"			</select></td>\n" +
			"		<td style='padding: 3px;'>\n" +
			"				<input type='text' value='' readonly class='form-control form_datetime_request input-sm startTime_request'>\n" +
			"		</td>\n" +
			"		<td style='padding: 3px;'>\n" +
			"			<input type='text' value='' readonly class='form-control form_datetime_request input-sm endTime_request'>\n" +
			"		</td>\n" +
			"		<td class='totaltime_request'>\n" +
			"<s:property value='#session.login.emp.empLoginId'/>" + 
			"		</td>\n" +
			"		<td>\n" +
			"			<a style='cursor: pointer; padding-left:7px;' class='deleteovertimerequest'><span class='glyphicon glyphicon-minus'></span></a>\n" +
			"		</td>\n" +
			"</tr>";
		
		$("#overtimerequesttbody").append(newRow);	// 添加新行
		var selector =  "#testselectoption" + counter;  
		$(selector).append(optionshtml);// 在添加的行内找到select元素并添加options
		
		$(".selectpicker").selectpicker();
	
	$(".form_datetime_request").datetimepicker({
		format: 'yyyy-mm-dd hh:ii',
		minuteStep: 30,
		autoclose: true,
		pickerPosition: "bottom-left",
		todayBtn: true,
		todayHighlight: 1
	}).on('hide', function() {
		var trParent = $(this).parent().parent();
		var startTime = trParent.find("input.startTime_request").val();
		var endTime = trParent.find("input.endTime_request").val();
		var totalTd = trParent.find("td.totaltime_request");
		var minutes = GetDateDiff(startTime.trim(), endTime.trim(), "minute");
		var hrs = minutes / 60;
		totalTd.text(parseFloat(hrs).toFixed(1));
	});
	
	/**
	 * 删除行
	 */
	$(".deleteovertimerequest").click(function() {
		$(this).parent().parent().remove();
	});
});


/**
 * leaverequest_submit 测试
 */
$("#leaverequest_submit").click(function() {
	var endTimeInputs = $("#leaverequesttbody").find("input.endTime_request");
	// 取得所有类型为endTime_request 的input元素
	var startTimeInputs = $("#leaverequesttbody").find("input.startTime_request");
	// 取得所有类型为startTime_request 的input元素
	var leaveTypes = $(".leavetype_request option:selected");
	
	var startTimes = "";
	var endTimes = "";
	var types = "";
	endTimeInputs.each(function(index){
		endTimes += this.value + ";";
	});
	startTimeInputs.each(function(index){ 
		startTimes += this.value + ";"; 
	});
	leaveTypes.each(function(index){
		types += this.value + ";";
	});
	
	$("#request_absence_types").val(types);
	$("#request_absence_startTimes").val(startTimes);
	$("#request_absence_endTimes").val(endTimes);
	
	return isabsenceLeaveOverUseCheck();	// 检查是否各项请假没有超过最大允许的选择数目
});



/**
 * leaverequest_submit 测试
 */
$("#overtimerequest_submit").click(function() {
	var endTimeInputs = $("#overtimerequesttbody").find("input.endTime_request");
	// 取得所有类型为endTime_request 的input元素
	var startTimeInputs = $("#overtimerequesttbody").find("input.startTime_request");
	// 取得所有类型为startTime_request 的input元素
	var selectemps = $(".overtimerequestemp option:selected");
	
	var startTimes = "";
	var endTimes = "";
	var loginIds = "";
	endTimeInputs.each(function(index){
		endTimes += this.value + ";";
	});
	startTimeInputs.each(function(index){ 
		startTimes += this.value + ";"; 
	});
	
	selectemps.each(function(index){
		loginIds += this.value + ";";
	});
	
	$("#request_overtime_loginIds").val(loginIds);
	$("#request_overtime_startTimes").val(startTimes);
	$("#request_overtime_endTimes").val(endTimes);
	
//	return isabsenceLeaveOverUseCheck();	// 检查是否各项请假没有超过最大允许的选择数目
});


/**
 * DataTable
 */
$("#request_affairs_table").dataTable({
	"bFilter": false,
	"bSort": false,
    "bStateSave": true
});

// pagination for absence Requests
$('#pagination-demo').twbsPagination({
    totalPages: $("#pagination-demo_totalpage").val().trim(),
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
    	var params = {
    			"request_info_page" : page
    	};
    	
        $.ajax({
            url: "requestInfo",
            type: "post",
            data: params,
            dataType: "json",
            success: function(data) {
            	
            	$('#spinnerroot').html("");
            	
         	   $("#request_affair_requestinfo").html("");
         	   // 设置Affaris 提示数目
         	   
         	   if(data.affairsNum > 0) {
        		   absenceAffarisNum = data.affairsNum;
        	   }
        	   
				if((absenceAffarisNum + overtimeAffairsNum) > 0) {
					$("#request_totalaffaris").text(absenceAffarisNum + overtimeAffairsNum);
					$("#request_totalaffaris").show();
				} else {
					$("#request_totalaffaris").hide();
				}
        	   
        	   
         	  var content = "";
         	  if(data.affairAbsences.length > 0) {
	         	  for( var i = 0; i < data.affairAbsences.length; i++) {
	           	   content += "<tr><td>" + data.affairAbsences[i].id + "</td><td>" + data.affairAbsences[i].empLoginId + "</td><td>" + 
	           	   data.affairAbsences[i].lineManager + "</td><td>" + data.affairAbsences[i].pm + "</td><td>" + 
	           	   data.affairAbsences[i].hrs +  "</td><td>" + data.affairAbsences[i].stateName + "</td><td>" + data.affairAbsences[i].createDate + "</td>";
	           	   if(data.affairAbsences[i].stateName == "Rejected") {
	           		   content += "<td><a href='loadAbsenceRequestReject?absenceRequestEntity.id=" + data.affairAbsences[i].id + "' target='_blank' class='request_handle_queryabsencerecord_rejected' role='button' data-toggle='modal'>Rejected</a></td></tr>";
	           	   } else {
	           		   content += "<td><a href='#' class='request_handle_queryabsencerecord' role='button' data-toggle='modal'>Edit</a></td></tr>";
	           	   }
	             }
         	  } else {
         		  content += "<tr><td colspan='8' ><h3 style='padding:50px 50px; text-align: center;'>Oops, No result has been found!</h3></td></tr>";
         	  }
               
               $("#request_affair_requestinfo").append(content);
               
               // 点击Edit并根据id筛选出Request详细信息，然后放在modal对话框当中显示
               $(".request_handle_queryabsencerecord").on("click", function() {
            	   var params2 = {
            			// 获取AbsenceRecord 的 id 号
            			"request_handle_absenceid" : $(this).parent().parent().children().first().text().trim()
            	   };
            	   // Ajax方式获取Absencerecord信息
            	   $.ajax({
            		   url: "testrequestinfoabsencerecord",
                       type: "post",
                       data: params2,
                       dataType: "json",
                       success: function(dataEdit) {
                    	   // 更新显示数据
                    	   $("#requestinfo_absencerecordid").val(dataEdit.absenceInfo.requestId);
                    	   $("#requestinfo_emplogid").text(dataEdit.absenceInfo.empLoginId);
                    	   $("#requestinfo_depart").text("待定");
                    	   $("#requestinfo_linemanager").text(dataEdit.absenceInfo.lineManager);
                    	   $("#requestinfo_pm").text(dataEdit.absenceInfo.pm);
                    	   $("#requestinfo_reason").text(dataEdit.absenceInfo.reason);
                    	   
                    	   var details_content = "";
                    	   $("#leaverequestinfo").html("");
                    	   for( var j = 0; j < dataEdit.absenceitems.length; j++) {
                    		   details_content += "<tr><td>" + dataEdit.absenceitems[j].vacationtype.timeSheetOrderId + 
                    		   "</td><td>Start:</td><td>" + dataEdit.absenceitems[j].absenceStartTime + 
                    		   "</td><td>End:</td><td>" + dataEdit.absenceitems[j].absenceEndTime + "</td><td>" + 
                    		   dataEdit.absenceitems[j].absenceHours + "</td></tr>";
                    	   }
//                    	   alert(details_content);
                    	   $("#leaverequestinfo").append(details_content);
                    	   // 调用模态对话框
                    	   $("#modal-container-requestInfo").modal();
                       }, // success end
            	   	   error: function() {
            	   		 alert("获取AbsenceRequest信息失败");
            	   	   }
            	   }); // ajax end
               });
               
              /* $('.request_handle_queryabsencerecord_rejected').on("click", function() {
               		$('#linkto_panel-affairs').parent().removeClass('active'); 
               		$('#panel-affairs').removeClass('active');
               		$('#linkto_panel-absence').closest('li').attr('class', 'active');
               		$('#panel-absence').addClass('active');
               		
               		alert($(this).closest('tr').children().first().text());
               		
               		=17
               		
//               	alert(data.absenceInfo.lineManager);
//               	$("#request_absence_lineManager").val(data.absenceInfo.lineManager);
               });*/
               
            }, // success end
            error: function() {
                  alert("ajax请求失败 requestInfo");
            }
      });
    }
});

// pagination for overtime Requests
$('#pagination_overtimeRequest').twbsPagination({
	totalPages: $('#overtimeRequest_totalpage').val().trim(),
//	totalPages: 1,
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
    	var params = {
    			"overtimeRequestEntity.page" : page
    	};
        $.ajax({
            url: "overtimeAffaris",
            type: "post",
            data: params,
            dataType: "json",
            success: function(data) {
            	
            	$('#spinnerroot').hide();
            	
            	/**
            	 * AbsenceAffarisNum
            	 */
	            if(data.affairsNum > 0) {
	        	   overtimeAffairsNum = data.affairsNum;
	        	 }
            	
	        	 if((absenceAffarisNum + overtimeAffairsNum) > 0) {
	        	 	$("#request_totalaffaris").show();
					$("#request_totalaffaris").text(absenceAffarisNum + overtimeAffairsNum);
				} else {
					$("#request_totalaffaris").hide();
				}
	        	 
            	 $("#request_affair_overtime").html("");
            	  var content = "";
            	  
            	  if(data.overtimeEntities.length > 0) {
	            	  for(var i = 0; i < data.overtimeEntities.length; i++) {
		            	  content += "<tr><td>" + data.overtimeEntities[i].id + "</td><td>" + data.overtimeEntities[i].applicant + 
		            		   "</td><td>" + data.overtimeEntities[i].pm + 
		            	   "</td><td>" + data.overtimeEntities[i].gm + "</td><td>" + 
		            	   data.overtimeEntities[i].pname + "</td><td>" + data.overtimeEntities[i].pcode + "</td><td>" + 
		            	   data.overtimeEntities[i].hrs +  "</td><td>" + data.overtimeEntities[i].stateName + "</td><td>" + data.overtimeEntities[i].createDate + "</td>";
		            	  if(data.overtimeEntities[i].stateName == "Rejected") {
		            	  		content += "<td><a target='_blank' href='loadOvertimeRequestReject?overtimeReApplyEntity.id=" + data.overtimeEntities[i].id +
				            	  "' class='request_handle_queryovertime' role='button' data-toggle='modal'>Rejected</a></td></tr>";
		            	  } else {
				            	content += "<td><a target='_blank' href='getOvertimeRequestRecord?overtimeRequestRecordId=" + data.overtimeEntities[i].id +
				            	  "' class='request_handle_queryovertime' role='button' data-toggle='modal'>Edit</a></td></tr>";
		            	  }
		            	  
	            	  }
            	  } else {
             		  content += "<tr><td colspan='10' ><h3 style='padding:50px 50px; text-align: center;'>Oops, No result has been found!</h3></td></tr>";
             	  }
            	  $("#request_affair_overtime").append(content);
            	  
            	   /*$(".request_handle_queryovertime").on("click", function() {
            		   var overtimeRequestID = $(this).parent().parent().children().first().text().trim();
            		   
            		   if(overtimeRequestID == "" || overtimeRequestID == null) {
							alert("overtimeRequestID 为空");            		   	
            		   		return false;
            		   }
            		   
            		   var actionurl = "getOvertimeRequestRecord?overtimeRequestRecordId=" + overtimeRequestID;
            		   $.ajax({
				            url: actionurl,
				            type: "post",
				            data: params,
				            dataType: "json",
				            success: function(data) {
				            	location.href = "salarySettingAction";
				            },
				           error: function() {
				            	 alert("ajax请求失败  pagination_overtimeRequest");
				            }
            		   });
            	   });*/
            	  
            },
            error: function() {
            	 alert("ajax请求失败  pagination_overtimeRequest");
            }
        });
    }
});


//pagination for AbsenceHistory
$('#pagination_absenceHistory').twbsPagination({
    totalPages: $("#pagination_absenceHistory_totalpage").val().trim(),
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
    	var params = {
    			"request_info_page" : page
    	};
        $.ajax({
            url: "requestInfoAbsenceHistory",
            type: "post",
            data: params,
            dataType: "json",
            success: function(data) {
         	   $("#request_history_absence").html("");
         	   var content = "";
         	   if(data.historyAbsences.length > 0) {
	         	  for( var i = 0; i < data.historyAbsences.length; i++) {
	           	   content += "<tr><td>" + data.historyAbsences[i].id + "</td><td style='display: none;'>" + data.historyAbsences[i].reason + 
					   "</td><td style='display: none;'>" + data.historyAbsences[i].lineManagerNote + 
	           	   "</td><td>" + data.historyAbsences[i].empLoginId + "</td><td>" + 
	           	   data.historyAbsences[i].lineManager + "</td><td>" + data.historyAbsences[i].pm + "</td><td>" + 
	           	   data.historyAbsences[i].hrs +  "</td><td>" + data.historyAbsences[i].stateName + "</td><td>" + data.historyAbsences[i].createDate + "</td>";
	           	   
	          		   content += "<td><a href='#' class='request_absenceHistory_details' role='button' data-toggle='modal'>Details</a></td>";
	           	   
	          		   content += "<td><a href='#' class='request_absenceHistory_track' role='button' data-toggle='modal'>Track</a></td></tr>";
	             }
         	   } else {
          		  content += "<tr><td colspan='9' ><h3 style='padding:50px 50px; text-align: center;'>Oops, No result has been found!</h3></td></tr>";
          	  }
               
              $("#request_history_absence").append(content);
              
               /**
                绑定Details按钮的动作
               */
              $(".request_absenceHistory_details").on("click", function() {
            	   var params2 = {
            			// 获取AbsenceRecord 的 id 号
            			"request_handle_absenceid" : $(this).parent().parent().children().first().text().trim()
            	   };
            	   var reason = "<tr><td>Reason:</td><td colspan='5'>" + $(this).parent().parent().children().first().next().text().trim() + "</td></tr>"; 
            	   // Ajax方式获取Absencerecord信息
            	  $.ajax({
            		   url: "testrequestinfoabsencerecord",
                       type: "post",
                       data: params2,
                       dataType: "json",
                       success: function(data) {
                    	   // 更新显示数据
                      	   var details_content = "";
                      	   $("#absenceHistoryDetails").html("");
                      	   for( var j = 0; j < data.absenceitems.length; j++) {
                      		   details_content += "<tr><td>" + data.absenceitems[j].vacationtype.timeSheetOrderId + 
                      		   "</td><td>Start:</td><td>" + data.absenceitems[j].absenceStartTime + 
                      		   "</td><td>End:</td><td>" + data.absenceitems[j].absenceEndTime + "</td><td>" + 
                      		   data.absenceitems[j].absenceHours + "</td></tr>";
                      	   }
//                      	   alert(details_content);
                      	   $("#absenceHistoryDetails").append(details_content);
                      	   $("#absenceHistoryDetails").append(reason);
                      	   // 调用模态对话框
                      	   $("#modal-container_absenceHistory_details").modal();
                       }, // success end
            	   	   error: function() {
            	   		 alert("ajax请求失败 absenceHistoryDetails");
            	   	   }
            	   }); // ajax end
               });
              
              /**
               绑定Track按钮的动作
              */
              $(".request_absenceHistory_track").on("click", function() {
            	  var params3 = {
              			// 获取AbsenceRecord 的 id 号
              			"request_handle_absenceid" : $(this).parent().parent().children().first().text().trim()
              	   };
//            	  alert($(this).parent().parent().children().first().text().trim());
              	   // Ajax方式获取Absencerecord信息
            	  $.ajax({
              		 url: "getAbsencerequestLog",
                     type: "post",
                     data: params3,
                     dataType: "json",
                     success: function(data) {
                  	   // 更新显示数据
                  	   var details_content = "";
                  	   $("#absenceHistoryTrack").html("");
                  	   for( var j = 0; j < data.absencerequestlogs.length; j++) {
                  		   details_content += "<tr><td>" + data.absencerequestlogs[j].logId + 
                  		   "</td><td>" + data.absencerequestlogs[j].changePeople +
                  		   "</td><td>" + data.absencerequestlogs[j].requeststate.stateName + 
                  		   "</td><td>" + data.absencerequestlogs[j].logDesc + "</td><td>" + 
                  		 data.absencerequestlogs[j].changeDate + "</td></tr>";
                  	   }
//                     alert(details_content);
                  	   $("#absenceHistoryTrack").append(details_content);
                  	   // 调用模态对话框
                  	   $("#modal-container_absenceHistory_track").modal();
                     }, // success end
	          	   	  error: function() {
	          	   		alert("Ajax 失败 request_absenceHistory_track");
	          	   	  }
              	   }); // ajax end
              });
            }, // success end
            error: function() {
                  alert("ajax请求失败  requestInfoAbsenceHistory");
            }
      });
    }
});



$('#pagination_overtimeHistory').twbsPagination({
    totalPages: $("#overtimeHistory_totalpage").val().trim(),
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
    	var params = {
    		"overtimeHistoryPage" : page
    	};
        $.ajax({
            url: "getOvertimeHistoryInfo",
            type: "post",
            data: params,
            dataType: "json",
            success: function(data) {
            	
            	$("#request_history_overtime").html("");
	           	var content = "";
	           	 if(data.overtimeHistories.length > 0) {
		           	 for(var i = 0; i < data.overtimeHistories.length; i++) {
			           	  content += "<tr><td>" + data.overtimeHistories[i].id + 
			           	  "</td><td>" + data.overtimeHistories[i].applicant + 
			           		   "</td><td>" + data.overtimeHistories[i].pm + 
			           	   "</td><td>" + data.overtimeHistories[i].gm + "</td><td>" + 
			           	   data.overtimeHistories[i].pname + "</td><td>" + 
			           	   data.overtimeHistories[i].hrs +  "</td><td>" + data.overtimeHistories[i].stateName + "</td><td>" + data.overtimeHistories[i].createDate + "</td>" +
			           	   "<td><a href='#' class='request_overtimeHistory_details' role='button' data-toggle='modal'>Details</a></td>" +
			           	   "<td><a href='#' class='request_overtimeHistory_track' role='button' data-toggle='modal'>Track</a></td></tr>";
		           	 }
		           	} else {
	          		  content += "<tr><td colspan='10' ><h3 style='padding:50px 50px; text-align: center;'>Oops, No result has been found!</h3></td></tr>";
	          	  }
	           	  
	           	  $("#request_history_overtime").append(content);
	           	  
	           	  /**
	           	   * Overtime History Details
	           	   */
	           	   $(".request_overtimeHistory_details").on("click", function() {
	            	   var params2 = {
	            			// 获取AbsenceRecord 的 id 号
	            			"historyOvertimeRecordId" : $(this).parent().parent().children().first().text().trim()
	            	   };
	            	   // Ajax方式获取Absencerecord信息
	            	  $.ajax({
	            		   url: "getOvertimeHistoryDetails",
	                       type: "post",
	                       data: params2,
	                       dataType: "json",
	                       success: function(detailsData) {
	                    	   // 更新显示数据
	                      	   var details_content = "";
	                      	   $("#overtimeHistoryDetails").html("");
	                      	   for( var j = 0; j < detailsData.historyOvertimeDetails.list.length; j++) {
	                      		   details_content += "<tr>" +
	                      		   		"<td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][0] + 
	                      		   "</td><td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][1] + 
	                      		   "</td><td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][2] + 
	                      		   "</td><td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][3] + 
	                      		   "</td><td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][4] + 
	                      		   "</td><td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][5] + 
	                      		   "</td><td style='text-align: center;'>" + detailsData.historyOvertimeDetails.list[j][6] + 
	                      		   "</td></tr>";
	                      	   };
	                      	   var other_content = 
	                      	   "<tr><td></td><td>Project Code:</td><td>" + detailsData.historyOvertimeDetails.pcode + "</td>" + 
	                      	   "<td>PM Note:</td><td>" + detailsData.historyOvertimeDetails.pmnote + "</td>" + 
	                      	   "<td>GM Note:</td><td>" + detailsData.historyOvertimeDetails.gmnote + "</td></tr>";
	                      	   
	                      	   $("#overtimeHistoryDetails").append(details_content).append(other_content);
	                      	   
	                      	   // 调用模态对话框
	                      	   $("#modal_overtimeHistory_details").modal();
	                       }, // success end
	            	   	   error: function() {
	            	   		 alert("ajax请求失败 request_overtimeHistory_details");
	            	   	   }
	            	   }); // ajax end
               });
               
               
                /**
	           	   * Overtime History Details
	           	   */
	           	   $(".request_overtimeHistory_track").on("click", function() {
	            	  	var params2 = {
	            			// 获取AbsenceRecord 的 id 号
	            			"historyOvertimeRecordId" : $(this).closest("tr").children("td:eq(0)").text().trim()
	            	   };
	            	   
	            	   
	            	  // Ajax方式获取Absencerecord信息
	            	  $.ajax({
	            		   url: "getOvertimeHistoryTrack",
	                       type: "post",
	                       data: params2,
	                       dataType: "json",
	                       success: function(trackData) {
	                    	   // 更新显示数据
	                      	   var details_content = "";
	                      	   $("#overtimeHistoryTrack").html("");
	                      	   for( var j = 0; j < trackData.requestHistoryTracks.length; j++) {
	                      		   details_content += "<tr>" +
	                      		   		"<td style='text-align: center;'>" + trackData.requestHistoryTracks[j].id + 
	                      		   "</td><td style='text-align: center;'>" + trackData.requestHistoryTracks[j].state + 
	                      		   "</td><td style='text-align: center;'>" + trackData.requestHistoryTracks[j].person + 
	                      		   "</td><td style='text-align: left;'>" + trackData.requestHistoryTracks[j].desc + 
	                      		   "</td><td style='text-align: center;'>" + trackData.requestHistoryTracks[j].date + 
	                      		   "</td></tr>";
	                      	   };
	                      	   $("#overtimeHistoryTrack").append(details_content);
	                      	   // 调用模态对话框
	                      	   $("#modal_overtimeHistory_track").modal();
	                       }, // success end
	            	   	   error: function() {
	            	   		 alert("ajax请求失败 getOvertimeHistoryTrack");
	            	   	   }
	            	   }); // ajax end
              });
               
	           	  
            	
            },
            error: function() {
            	alert("ajax 错误, pagination_overtimeHistory");
            }
        });
    }
});

// Affaris request handle - agree 
$("#request_affairs_handle_agree").click(function() {
	$("#requestaffairs_handleFlag").val("Agree");
	$("#requestaffairs_handle_form").submit();
});

$("#request_affairs_handle_reject").click(function () {
	$("#requestaffairs_handleFlag").val("Reject");
	$("#requestaffairs_handle_form").submit();
});


/**
 * 计算调休假跟年假总的请假小时数
 */
function isabsenceLeaveOverUseCheck() {
	var compensatoryLeft = parseFloat($('#request_compensatoryLeft').text().trim());
	var annualLeft = parseFloat($('#request_annualLeft').text().trim());
	
	var total5 = 0.0;	// 调休假
	var total6 = 0.0;	// 年假
	
	$('.leavetype_request').each(function () {
		var value = this.value;
		switch (value) {
		case "5":
			var txt = $(this).parent().parent().find("td.totaltime_request").text();
			if(txt != "NaN") {
				total5 += parseFloat(txt);
			}
			break;
		case "6":
			var txt = $(this).parent().parent().find("td.totaltime_request").text();
			if(txt != "NaN") {
				total6 += parseFloat(txt);
			}
			break;
		default:
			break;
		}
	});
	
	if(total5 > compensatoryLeft) {
		alert("申请调休假超过剩余调休假小时数, 请修改！");
		return false;
	} else if(total6 > annualLeft) {
		alert("申请年假超过剩余年假小时数, 请修改！");
		return false;
	} else {
		return true;
	} 
	
}


