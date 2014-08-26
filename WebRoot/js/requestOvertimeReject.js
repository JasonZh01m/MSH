/**
 * 
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
 * 添加行for Overtime Request
 */
var counter = 0;
var optionshtml = "";
$("#addovertimerequest_reject").click(function() {
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
		$("#overtimerequesttbody_reject").append(newRow);	// 添加新行
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
	$(".deleteovertimerequest").on('click', function() {
		$(this).parent().parent().remove();
	});
	
});

$(".deleteovertimerequest").each(function() {
	if(this != null) {
		$(this).on('click', function() {
			$(this).parent().parent().remove();
		});
	}
});

$("#overtimerequest_submit_reject").click(function() {
	var endTimeInputs = $("#overtimerequesttbody_reject").find("input.endTime_request");
	// 取得所有类型为endTime_request 的input元素
	var startTimeInputs = $("#overtimerequesttbody_reject").find("input.startTime_request");
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
	
	$("#request_overtime_loginIds_reject").val(loginIds);
	$("#request_overtime_startTimes_reject").val(startTimes);
	$("#request_overtime_endTimes_reject").val(endTimes);
	
//	return isabsenceLeaveOverUseCheck();	// 检查是否各项请假没有超过最大允许的选择数目
});





