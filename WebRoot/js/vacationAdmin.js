/**
 * 
 */
 $("#vaadmin_emploginid").change(function() {
 	var params = {
    	"vacationinfo_emploginid" : $(this).val()
    };
 	
     $.ajax({
	   url: "getVacationLeftInfo",
       type: "post",
       data: params,
       dataType: "json",
       success: function(vlidata) {
    	   // 更新显示数据
    	   $("#vaadmin_annualleft").text(vlidata.vLeftAdminEntity.annualTotalLeft);
    	   $("#vaadmin_compenleft").text(vlidata.vLeftAdminEntity.compenTotalLeft);
    	   
    	   // Compensatory Absence Details
    	   var content = "";
    	   $("#compenleftInfo_details").html("");
    	   if(vlidata.vLeftAdminEntity.compensatorys.length > 0) {
	    	   for( var j = 0; j < vlidata.vLeftAdminEntity.compensatorys.length; j++) {
	    		   content += "<tr><td>" + vlidata.vLeftAdminEntity.compensatorys[j][0] + 
	    		   "</td><td>" + vlidata.vLeftAdminEntity.compensatorys[j][1] + 
	    		   "</td><td class='" + vlidata.vLeftAdminEntity.compensatorys[j][5] + "'>" +
	    		   vlidata.vLeftAdminEntity.compensatorys[j][2] + "</td><td>" + 
	    		   vlidata.vLeftAdminEntity.compensatorys[j][3] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.compensatorys[j][4] + "</td></tr>";
	    	   }
    	   } else {
    	   		content += "<tr><td colspan='5' ><h4 style='padding:20px 20px; text-align: center;'>Oops, No result has been found!</h4></td></tr>";
    	   }
    	   $("#compenleftInfo_details").append(content);
			
    	   
    	   // Vacation Change History Details
    	   var history_content = "";
    	   $("#compenleftInfo_histories").html("");
    	   if(vlidata.vLeftAdminEntity.histories.length > 0) {
	    	   for( var k = 0; k < vlidata.vLeftAdminEntity.histories.length; k++) {
	    		   history_content += "<tr><td>" + vlidata.vLeftAdminEntity.histories[k][0] + 
	    		   "</td><td>" + vlidata.vLeftAdminEntity.histories[k][1] + 
	    		   "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][2] + "</td><td>" + 
	    		   vlidata.vLeftAdminEntity.histories[k][3] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][4] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][5] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][6] + "</td></tr>";
	    	   }
	    	   
	    	  paginationInit(vlidata.vLeftAdminEntity.totalpage);
	    	   
    	   } else {
    	   		history_content += "<tr><td colspan='7' ><h4 style='padding:20px 20px; text-align: center;'>Oops, No result has been found!</h4></td></tr>";
    	   		 paginationInit(1);
    	   }
    	   $("#compenleftInfo_histories").append(history_content);
    	   
    	   
       }, // success end
   	   error: function() {
   		 alert("获取getVacationLeftInfo信息失败");
   	   }
   }); // ajax end
 });
 
 
 $("#addCompensatoryBtn").click(function() {
 	$("#test_vacationmanage_operationFlag").val("AddCompensatory");
 	$("#vacationLeftAdminForm").submit();
 });
 
 $("#addAnnualBtn").click(function() {
 	$("#test_vacationmanage_operationFlag").val("AddAnnual");
 	$("#vacationLeftAdminForm").submit();
 });
 
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
            url: "getVacationLeftInfo",
            type: "post",
            data: params,
            dataType: "json",
            success: function(vlidata) {
            	// Vacation Change History Details
    	   var history_content = "";
    	   $("#compenleftInfo_histories").html("");
    	   if(vlidata.vLeftAdminEntity.histories.length > 0) {
	    	   for( var k = 0; k < vlidata.vLeftAdminEntity.histories.length; k++) {
	    		   history_content += "<tr><td>" + vlidata.vLeftAdminEntity.histories[k][0] + 
	    		   "</td><td>" + vlidata.vLeftAdminEntity.histories[k][1] + 
	    		   "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][2] + "</td><td>" + 
	    		   vlidata.vLeftAdminEntity.histories[k][3] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][4] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][5] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][6] + "</td></tr>";
	    	   }
	    	  /* 
	    	   paginationInit(vlidata.vLeftAdminEntity.totalpage);
	    	    */
	    	   
    	   } else {
    	   		history_content += "<tr><td colspan='7' ><h4 style='padding:20px 20px; text-align: center;'>Oops, No result has been found!</h4></td></tr>";
    	   		/* $("#pagination_totalpage").val(0);*/
    	   }
    	   $("#compenleftInfo_histories").append(history_content);
            },
            error: function() {
            	alert("ajax 请求失败： ");
            }
        });
    } 
            
});

function paginationInit(totalPage) {
	$("#pagination_totalpage").val(totalPage);
	$('.pagination_vacationchangeHistory').empty();
    $('.pagination_vacationchangeHistory').removeData("twbs-pagination");
    $('.pagination_vacationchangeHistory').unbind("page");
    
    
    $('#pagination_vacationchangeHistory').twbsPagination({
    totalPages: totalPage,
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
    	var params = {
    		"request_pageno" : page
    	};
        $.ajax({
            url: "getVacationLeftInfo",
            type: "post",
            data: params,
            dataType: "json",
            success: function(vlidata) {
            	// Vacation Change History Details
    	   var history_content = "";
    	   $("#compenleftInfo_histories").html("");
    	   if(vlidata.vLeftAdminEntity.histories.length > 0) {
	    	   for( var k = 0; k < vlidata.vLeftAdminEntity.histories.length; k++) {
	    		   history_content += "<tr><td>" + vlidata.vLeftAdminEntity.histories[k][0] + 
	    		   "</td><td>" + vlidata.vLeftAdminEntity.histories[k][1] + 
	    		   "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][2] + "</td><td>" + 
	    		   vlidata.vLeftAdminEntity.histories[k][3] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][4] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][5] + "</td><td>" +
	    		   vlidata.vLeftAdminEntity.histories[k][6] + "</td></tr>";
	    	   }
	    	  /* 
	    	   paginationInit(vlidata.vLeftAdminEntity.totalpage);
	    	    */
	    	   
    	   } else {
    	   		history_content += "<tr><td colspan='7' ><h4 style='padding:20px 20px; text-align: center;'>Oops, No result has been found!</h4></td></tr>";
    	   		/* $("#pagination_totalpage").val(0);*/
    	   }
    	   $("#compenleftInfo_histories").append(history_content);
            },
            error: function() {
            	alert("ajax 请求失败： ");
            }
        });
    } 
            
});
    
	
};
