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
 * 
 */
 
$("#addleaverequest_reject").click(function() {
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
	
	$("#leaverequesttbody_reject").append(newRow);
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

$(".deleteleaverequest").each(function() {
	if(this != null) {
		$(this).on('click', function(){
			$(this).parent().parent().remove();
		});
	}
});

/*$("#deleteleaverequesttd").find("a").each(function () {
	if(this != null) {
		$(this).on("click", function(){
			$(this).closest("tr").remove();
		});
	}
});*/

/**
 * leaverequest_submit_reject 测试
 */
$("#leaverequest_submit_reject").click(function() {
	var endTimeInputs = $("#leaverequesttbody_reject").find("input.endTime_request");
	// 取得所有类型为endTime_request 的input元素
	var startTimeInputs = $("#leaverequesttbody_reject").find("input.startTime_request");
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
	
	$("#request_absence_types_reject").val(types);
	$("#request_absence_startTimes_reject").val(startTimes);
	$("#request_absence_endTimes_reject").val(endTimes);
	
	return isabsenceLeaveOverUseCheck();	// 检查是否各项请假没有超过最大允许的选择数目
});



/**
 * 计算调休假跟年假总的请假小时数
 */
function isabsenceLeaveOverUseCheck() {
	var compensatoryLeft = parseFloat($('#request_compensatoryLeft_reject').text().trim());
	var annualLeft = parseFloat($('#request_annualLeft_reject').text().trim());
	
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

/*$("#cancelOvertimeRequest").on('click', function(){
	
	
	
});*/
