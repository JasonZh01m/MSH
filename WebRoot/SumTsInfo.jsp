<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Summary TimeSheet Information</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="css/dataTable/dataTables.bootstrap.css">

<script type="text/javascript" charset="utf-8" language="javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" language="javascript"
	src="js/dataTable/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" language="javascript"
	src="js/dataTable/dataTables.bootstrap.js"></script>
<!-- test if conflict -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#example_tab').dataTable({
			"iDisplayLength" : 25,
		/* "aLengthMenu": [[10, 25, 50, 100, -1], [25, 50, 100, "All"]] */
		});

	});


</script>

</head>
<%
  	if(session.getAttribute("login") == null)  
  		request.getRequestDispatcher("login.jsp");
		/* response.sendRedirect("login.jsp");	 */	
  %>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="row clearfix">
			<div class="page-header">
				<h1>
					Summary Timesheet Info Page <small><s:property value="#session.sti_month"/> 月</small>
				</h1>
			</div>

			<div class="col-md-12 column">
				<div class="panel panel-primary" style="width: 80%; margin: auto;">
					<div class="panel-heading">
							<h3 class="panel-title">
								Time Sheet Summary Info
							</h3>
						</div>
					<div class="panel-body" style="padding: 30px;">

						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-hover dataTable"
							id="example_tab" aria-describedby="example_info"
							style="overflow: auto;">
							<thead>
								<tr role="row">
									<th aria-sort="ascending">LoginName</th>
									<th>TimeSheet Hours</th>
									<th>Absence Hours</th>
									<th>Paid Hours</th>
									<th>Not Paid Hours</th>
									<th><span title="Difference between timesheet hours and monthly normal hours" data-placement="top">Diff</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">
								<s:iterator var="sti_tsItor" value="#session.sti_stiList">
									<tr>
										<td><a target="_blank" class="sti_details"
											href="salaryInfoAction?empLoginId=<s:property value="#sti_tsItor.loginId" />"><s:property
													value="#sti_tsItor.loginId" /> </a></td>
										<td><s:property value="#sti_tsItor.tsHrs" /></td>
										<td><s:property value="#sti_tsItor.absenceHrs" /></td>
										<td><s:property value="#sti_tsItor.paidHrs" /></td>
										<td><s:property value="#sti_tsItor.notPaidHrs" /></td>
										<td
											<s:if test="#sti_tsItor.overTime < 0">style="background-color: #eed3d7;"</s:if>><s:property
												value="#sti_tsItor.overTime" /></td>
									</tr>
								</s:iterator>

							</tbody>
						</table>


					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>