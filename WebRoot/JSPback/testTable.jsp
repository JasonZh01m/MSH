<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/demo_page.css">
<link rel="stylesheet" type="text/css" href="css/demo_table.css">
<link rel="stylesheet" type="text/css" href="css/demo_table_jui.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/prettify.css">

<!-- <link href="css/jquery.wijmo-open.1.5.0.css" rel="stylesheet"
	type="text/css" />
 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"> -->
<link type="text/css"
	href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
<link href="css/style2.css" rel="stylesheet">

<!-- <script src="js/jquery-1.10.2min.js" type="text/javascript"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>

<script src="js/jquery.wijmo-open.1.5.0.min.js" type="text/javascript"></script>
<script src="js/jquery.mousewheel.min.js" type="text/javascript"></script>
<script src="js/docs.js" type="text/javascript"></script>
<script src="js/enhance.min.js" type="text/javascript"></script> -->

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script> -->
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	


	$(document).ready(function() {
		var oTable;
		$('#example').dataTable({
			"iDisplayLength" : 25
		});

		$("#example tbody tr").click(function(e) {
			if ($(this).hasClass('row_selected')) {
				$(this).removeClass('row_selected');
			} else {
				oTable.$('tr.row_selected').removeClass('row_selected');
				$(this).addClass('row_selected');
			}
		});

		/* Add a click handler for the delete row */
		$('#delete').click(function() {
			var anSelected = fnGetSelected(oTable);
			if (anSelected.length !== 0) {
				oTable.fnDeleteRow(anSelected[0]);
			}
		});

		/* Init the table */
		oTable = $('#example').dataTable();
		
		
		/* $("#form_date").datetimepicker({
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    }); */
   /*  $("#datepicker1").wrap('<div style="position: relative; height:100%;"></div>').after('<span class="ui-icon ui-icon-calendar" style="position: absolute; right:2px; top:1px;"></span>'); */
		$("#datepicker1").datepicker({
			  dateFormat:'yy-mm-dd'
		});
		$("#datepicker2").datepicker({
			  dateFormat:'yy-mm-dd'
		});
		
		
		$("#monthPicker").datepicker({
	        dateFormat: 'yy-mm',
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	
	        onClose: function(dateText, inst) {
	            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
	            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
	            $(this).val($.datepicker.formatDate('yy-mm', new Date(year, month, 1)));
	        }
	    });

		    $("#monthPicker").focus(function () {
		        $(".ui-datepicker-calendar").hide();
		        $("#ui-datepicker-div").position({
		            my: "center top",
		            at: "center bottom",
		            of: $(this)
		        });
		    });
		    
		   /* $("#monthPicker").datepicker( {
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            dateFormat: 'MM yy',
            onClose: function(dateText, inst) { 
                var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                $(this).datepicker('setDate', new Date(year, month, 1));
            },
            beforeShow : function(input, inst) {
                if ((datestr = $(this).val()).length > 0) {
                    year = datestr.substring(datestr.length-4, datestr.length);
                    month = jQuery.inArray(datestr.substring(0, datestr.length-5), $(this).datepicker('option', 'monthNames'));
                    $(this).datepicker('option', 'defaultDate', new Date(year, month, 1));
                    $(this).datepicker('setDate', new Date(year, month, 1));
                }
            }
        }); */
        
				       /*  $("#monthPicker").datepicker({
				        changeMonth: true,
				        changeYear: true,
				        showButtonPanel: true,
				        dateFormat: 'MM',
				        onClose: function(dateText, inst) { 
				            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
				            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
				            $(this).datepicker('setDate', new Date(year, month, 1));
				        }
				    });
						 $("#monthPicker").focus(function () {
						        $(".ui-datepicker-day").hide();
						    }); */
        
        
        
      /*   $("#monthPicker").datepicker( {
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        dateFormat: 'MM yy',
        onClose: function(dateText, inst) {
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }
    }); */
		    
		
		
	$("#Search-Btn").click( function(){
      /* var params = {"startDate" : $("#datepicker1").val(),
      "endDate" : $("#datepicker2").val()
      };
            */ 
        var startDate = $("#datepicker1").val();
        var endDate = $("#datepicker2").val();
        $("#Search-Btn").attr("href", "timesheetAction1?startDate=" + startDate + "&endDate=" + endDate);  
           /*  alert(startDate + "...." + endDate); */
             /* $.ajax({
                  url: "timesheetAction1",
                  type: "post",
                  data:params,
                  dataType: "json",
                  success: function() {
                          alert( "ajax请求成功");
                         $("#table-container").load("timesheetAction1");
                  },
                  error: function() {
                        alert( "ajax请求失败");
                  }
            }); */
           /* $("#Search-Btn") */
         /* $("#main-content").load("timesheetAction1&startDate=" + startDate + "&endDate=" + endDate);  */
            
      });
	});
	
	/* Get the rows which are currently selected */
	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.row_selected');
	}
	
	
</script>
</head>
<body>
	<div>
		<div class="date-choose">
			<label>StartDate:&nbsp;</label><input type="text" class="form-control" style="width: 100px; height: 30px;" id="datepicker1" />&nbsp;&nbsp; 
			<label>EndDate:&nbsp;</label><input	type="text" style="width: 100px;" id="datepicker2" />&nbsp;&nbsp; 
			<a class="btn btn-primary" type="Button" id="Search-Btn" style="padding-top: 3px; padding-bottom: 3px; margin-top:-2px;">Filter</a>
		</div>
	
	<div><label>testDate:&nbsp;</label><input type="text" style="width: 100px;" id="monthPicker" />&nbsp;&nbsp;</div>
	
		<div id="table-container">
		<div class="dataTables_container">
			<table cellpadding="0" cellspacing="0" border="0" class="display"
				id="example">
				<thead>
					<tr>
						<th>LoginName</th>
						<th>Total Hours</th>
						<th>Paid Hours</th>
						<th>Not Paid Hours</th>
						<th>Over Time</th>
						<th>Details</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator var="var" value="#session.vars">
						<tr class="gradeX">
							<td><s:property value="#var.loginName" /></td>
							<td><s:property value="#var.sumTime" /></td>
							<td><s:property value="#var.platform" /></td>
							</td>
							<td class="center"><s:property value="#var.engine" /></td>
							<td class="center"><s:property value="#var.css" /></td>
							<td class="center"><a href="">详细</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		</div>
	</div>


</body>
</html>