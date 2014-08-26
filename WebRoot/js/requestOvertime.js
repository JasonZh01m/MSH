/**
 * 
 */
$(".othersTrHidden").hide();
$(".withcompensatoryHours").hide();

$(".withcompensatory").click(function() {
	$(this).parent().next().toggle();
	$(this).parent().siblings(":eq(3)").toggle();
});

$(".overtimeItemPaidRate").change(function() {
	var value = $(this).find("option:selected").val().trim();
	if(value == "others") {
		$(this).closest("tr").next().show();
		$(this).closest("tr").next().find("input.otherPaidRate").val("");
		$(this).closest("tr").next().find("input.withcompensatoryHoursInput").val("");
	} else {
		$(this).closest("tr").next().hide();
	}
});


/**
 * GM Related
 */
$(".overtimeItemPaidRate").each(function() {
	var value = $(this).find("option:selected").val().trim();
	if(value == "others") {
		$(this).closest("tr").next().show();
	} else {
		$(this).closest("tr").next().hide();
	}
});

/**
 * GM Related
 */
$(".withcompensatory").each(function() {
	var c = this.checked;
	if(c) {
		$(this).parent().next().show();
		$(this).parent().next().next().show();
	} else {
		$(this).parent().next().hide();
		$(this).parent().next().next().hide();
	}
	
});


$("#requestovertimeitemagreebutton").click(function () {
	var costcenterSelects = $("#request_overtime_handletbody").find("select.overtimeItem_costcenter"); // select
	var paidRates = $("#request_overtime_handletbody").find("select.overtimeItemPaidRate");	// select
	var otherPaidRates = $("#request_overtime_handletbody").find("input.otherPaidRate");	// input
	var withcompensatorys = $("#request_overtime_handletbody").find("input.withcompensatory");	// checkbox
	var hours = $("#request_overtime_handletbody").find("input.withcompensatoryHoursInput");	// input
	var idInputs = $("#request_overtime_handletbody").find("input.overtimeRecordItemId");	// input
	
	var costcenters = "";
	var rates = "";
	var otherrates = "";
	var withcompen = "";
	var hrs = "";
	var itemids = "";
	
	costcenterSelects.each(function() {
		costcenters += this.value + ";";
	});
	
	paidRates.each(function() {
		rates += this.value + ";";
	});
	
	otherPaidRates.each(function() {
		if(this.value.trim() == "") {
			otherrates += "null;";
		} else {
			otherrates += this.value.trim() + ";";
		}
	});
	
	withcompensatorys.each(function() {
		withcompen += this.checked + ";";	
	});
	
	hours.each(function() {
		if(this.value.trim() == "") {
			hrs += "null;";
		} else {
			hrs += this.value.trim() + ";";
		}
	});
	
	idInputs.each(function() {
		itemids += this.value + ";";
	});
	
	
	$("#requestovertimeitem_handleflag").val("Agree");
	$("#requestovertimeitem_itemids").val(itemids);
	$("#requestovertimeitem_costcenter").val(costcenters);
	$("#requestovertimeitem_paidrates").val(rates);
	$("#requestovertimeitem_otherrates").val(otherrates);
	$("#requestovertimeitem_withcompensatorys").val(withcompen);
	$("#requestovertimeitem_compensatoryhours").val(hrs);
	
	$("#request_overtime_handle_form").submit();
	
});

$("#requestovertimeitemRejectbutton").click(function () {
/*//	var costcenterSelects = $("#request_overtime_handletbody").find("select.overtimeItem_costcenter"); // select
//	var paidRates = $("#request_overtime_handletbody").find("select.overtimeItemPaidRate");	// select
//	var otherPaidRates = $("#request_overtime_handletbody").find("input.otherPaidRate");	// input
//	var withcompensatorys = $("#request_overtime_handletbody").find("input.withcompensatory");	// checkbox
//	var hours = $("#request_overtime_handletbody").find("input.withcompensatoryHoursInput");	// input
//	var idInputs = $("#request_overtime_handletbody").find("input.overtimeRecordItemId");	// input
//	
//	var costcenters = "";
//	var rates = "";
//	var otherrates = "";
//	var withcompen = "";
//	var hrs = "";
//	var itemids = "";
//	
//	costcenterSelects.each(function() {
//		costcenters += this.value + ";";
//	});
//	
//	paidRates.each(function() {
//		rates += this.value + ";";
//	});
//	
//	otherPaidRates.each(function() {
//		if(this.value.trim() == "") {
//			otherrates += "null;";
//		} else {
//			otherrates += this.value.trim() + ";";
//		}
//	});
//	
//	withcompensatorys.each(function() {
//		withcompen += this.checked + ";";	
//	});
//	
//	hours.each(function() {
//		if(this.value.trim() == "") {
//			hrs += "null;";
//		} else {
//			hrs += this.value.trim() + ";";
//		}
//	});
//	
//	idInputs.each(function() {
//		itemids += this.value + ";";
//	});
*/	
	
	$("#requestovertimeitem_handleflag").val("Reject");
//	$("#requestovertimeitem_itemids").val(itemids);
//	$("#requestovertimeitem_costcenter").val(costcenters);
//	$("#requestovertimeitem_paidrates").val(rates);
//	$("#requestovertimeitem_otherrates").val(otherrates);
//	$("#requestovertimeitem_withcompensatorys").val(withcompen);
//	$("#requestovertimeitem_compensatoryhours").val(hrs);
	
	$("#request_overtime_handle_form").submit();
	
});