<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testexport2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/bootstrap-select.css" rel="stylesheet">
	<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="css/select2.css" />
	<link href="css/style2.css" rel="stylesheet"/>
	<link href="css/style2.css" rel="stylesheet"/>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/flot/jquery.flot.min.js"></script>
	<script type="text/javascript" src="js/flot/jquery.flot.pie.min.js"></script>
	<script type="text/javascript" src="js/flot/jquery.flot.categories.min.js"></script>
	<script type="text/javascript" src="js/flot/jquery.flot.tooltip.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="js/select2.js"></script>
	<script type="text/javascript" src="js/selectpicker.js"></script>
	
	<script type="text/javascript">
	
	$(function() {
		$("#fsfilter_submitPayroll").click(function() {
		alert("click..." + $("#fsip_startDate").val().trim() + "\t" + $("#fsip_endDate").val().trim());
		var params = {
			"fsip_startDate" : $("#fsip_startDate").val().trim(),
			"fsip_endDate" : $ ("#fsip_endDate").val().trim()
		};
		
		$.ajax({
				url : "exportExcelAction_Payroll",
				type : "post",
				data : params,
				success : function() {
					 location.href = "testexport.jsp";
				}
			});
		});
	});
	
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <a href="<%=path%>/exportExcelAction_FinancialStatement!export.action">导出数据到excel</a>
    <a href="<%=path%>/exportExcelAction_Payroll?fsip_startDate=2013-03-01&fsip_endDate=2013-03-31!export.action">导出数据到excel2</a>
    
    <form action="exportExcelAction_Payroll!export">
    	<input id="fsip_startDate" name="fsip_startDate" value="2013-03-01" type="text"/>
    	<input id="fsip_endDate" name="fsip_endDate" value="2013-03-31" type="text"/>
    	<button type="submit">Submit</button>
    	<button id="fsfilter_submitPayroll" type="button" class="btn btn-primary">Default</button>
    </form>
    
    <div style="color:red;">
    	<s:fielderror/>
    </div>
   <form action="uploadExcelFileAction!doUpload" method ="post" enctype="multipart/form-data">
      <input class="btn btn-default btn-sm" type ="file" name="upload">
      <input class="btn btn-primary btn-sm" type ="submit" value="上传">
	</form>
    <s:debug/>
  </body>
</html>
