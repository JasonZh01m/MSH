<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dataTable/dataTables.bootstrap.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/dataTable/DT_notrefresh.js"></script>
<script type="text/javascript" src="js/dataTable/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript" charset="utf-8">
			$(function () {
				/* $("#example_tab").dataTable({
				 "iDisplayLength": 25,
				}); */
				
			/* var oTable = $("#example_tab").dataTable(); */
			 /*  oTable.fnUpdate(0, 0, 0, false); */ // Single cell
			 /* oTable.fnStandingRedraw(); */
			  /* oTable.fnUpdate( ['a', 'b', 'c', 'd', 'e'], 1 ); // Row */
			  
			   var table1 = $('#example_tab').dataTable({"iDisplayLength": 25});
         
				setInterval(function() {
				            table1.fnReloadAjax(null,null,true);
				        }, 10000);
			  
			  
			  
			} );
		</script>

</head>
<body>
<div class="container">
<table cellpadding="0" cellspacing="0"
			class="table table-striped table-hover dataTable" id="example_tab"
			aria-describedby="example_info" style="overflow: auto;">
			<thead>
				<tr role="row">
					<!-- <th class="sorting_asc" role="columnheader" tabindex="0"
						aria-controls="example" rowspan="1" colspan="1"
						aria-sort="ascending"
						aria-label="Rendering engine: activate to sort column descending"
						style="width: 167px;">Rendering engine</th>
					<th class="sorting" role="columnheader" tabindex="0"
						aria-controls="example" rowspan="1" colspan="1"
						aria-label="Browser: activate to sort column ascending"
						style="width: 232px;">Browser</th>
					<th class="sorting" role="columnheader" tabindex="0"
						aria-controls="example" rowspan="1" colspan="1"
						aria-label="Platform(s): activate to sort column ascending"
						style="width: 214px;">Platform(s)</th>
					<th class="sorting" role="columnheader" tabindex="0"
						aria-controls="example" rowspan="1" colspan="1"
						aria-label="Engine version: activate to sort column ascending"
						style="width: 142px;">Engine version</th>
					<th class="sorting" role="columnheader" tabindex="0"
						aria-controls="example" rowspan="1" colspan="1"
						aria-label="CSS grade: activate to sort column ascending"
						style="width: 99px;">CSS grade</th> -->
						<th aria-sort="ascending">LoginName</th>
						<th>TimeSheet Hours</th>
						<th>Absence Hours</th>
						<th>Paid Hours</th>
						<th>Not Paid Hours</th>
						<th>Overtime</th>
				</tr>
			</thead>

			<tbody role="alert" aria-live="polite" aria-relevant="all">
				<s:iterator var="sti_tsItor" value="#session.sti_stiList">
						<tr  >
							<td><a target="" class="sti_details" href="salaryInfoAction?empLoginId=<s:property value="#sti_tsItor.loginId" />"><s:property value="#sti_tsItor.loginId" /></a></td>
							<td><s:property value="#sti_tsItor.tsHrs" /></td>
							<td><s:property value="#sti_tsItor.absenceHrs" /></td>
							<td><s:property value="#sti_tsItor.paidHrs" /></td>
							<td><s:property value="#sti_tsItor.notPaidHrs" /></td>
							<td <s:if test="#sti_tsItor.overTime < 0">style="background-color: #eed3d7;"</s:if>><s:property value="#sti_tsItor.overTime" /></td>
						</tr>
				</s:iterator>
				
			</tbody>
		</table>

		</div>
</body>
</html>