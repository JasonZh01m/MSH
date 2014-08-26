<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/demo_page.css">
<link rel="stylesheet" type="text/css" href="css/demo_table.css">
<link rel="stylesheet" type="text/css" href="css/demo_table_jui.css">
<link href="css/style2.css" rel="stylesheet">

<link href="css/jquery.wijmo-open.1.5.0.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">


<script src="js/jquery-1.10.2min.js" type="text/javascript"></script>
<!-- <script src="js/jquery.min.js" type="text/javascript"></script> -->
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>
<script src="js/jquery.wijmo-open.1.5.0.min.js" type="text/javascript"></script>
<script src="js/jquery.mousewheel.min.js" type="text/javascript"></script>
<script src="js/docs.js" type="text/javascript"></script>
<script src="js/enhance.min.js" type="text/javascript"></script>


<!-- <script type="text/javascript" src="js/jquery-1.8.3.js"></script> -->
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>

<!-- <script src="js/fileinput.jquery.js" type="text/javascript"></script> -->

<script type="text/javascript">
	$(document).ready(function() {
		$("#rangeBa").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#rangeBb").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#rangeBb").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#rangeBa").datepicker("option", "maxDate", selectedDate);
			}
		});
		
		
		$("#datepicker").datepicker();
		
   $("#Search-Btn").click( function(){
      var params = {"startDate" : $("#rangeBa").val(),
      "endDate" : $("#rangeBb").val()
      };
             $.ajax({
                  url: "timesheetAction1",
                  type: "post",
                  data:params,
                  dataType: "json",
                  success: function(data) {
                        
                  },
                  error: function() {
                        alert( "ajax请求失败");
                  }
            });
      });
		
	});

		  
    
</script>
</head>
<body>
	<div>
		<form action="">
			<input type="text" value="" id="rangeBa" /> 
			<input type="text" value="" id="rangeBb" /> 
			<input type="submit" class="ui-button-primary" value="Search" style="height: 28px; cursor: pointer;" /> 
			<a href="#" class="btn btn-primary" type="Button" id="Search-Btn">Search</a>
			<button>Default</button>
		</form>
	</div>
	
	
	
	
	<!-- <div class="dataTables_container">
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
							<td><s:property value="#var.loginName" />
							</td>
							<td><s:property value="#var.sumTime" />
							</td>
							<td><s:property value="#var.platform" />
							</td>
							</td>
							<td class="center"><s:property value="#var.engine" />
							</td>
							<td class="center"><s:property value="#var.css" />
							</td>
							<td class="center"><a href="">详细</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div> -->
	<p>Date: <input type="text" id="datepicker" /></p>
</body>
</html>