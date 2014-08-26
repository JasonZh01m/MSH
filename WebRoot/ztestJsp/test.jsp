<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%-- <%@ taglib uri="/struts-tags" prefix="s"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/bootstrap-select.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="css/select2.css" />
<link href="css/style2.css" rel="stylesheet"/>
<link href="css/style2.css" rel="stylesheet"/>

<style type="text/css">
.selectpicker_class2{
	height:30px;
	margin-bottom: 10px;
	float: right;
}

.selectpicker_class2 .bootstrap-select{
	width: 160px;
}

.selectpicker_class2 label{
	margin-right: 5px;
}
</style>

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
		/*  $("#filterOption").on('change', function() {
		  	alert(this.value ); // or $(this).val()
		 }); */
		/* $("#filterOption option[value='3']").attr("selected", true); */
		 
		/* $("#filterOption").find("option[value='3']").attr("selected","selected"); */
		
		var op = $("#filterOption").find("option[value='3']");
		alert(op.val());
		op.attr("selected", true);
		$('.selectpicker').selectpicker('refresh');
		/* alert(($("#filterOption").option[value='2']).text()); */
		 /* $("#filterOption option").filter("[value='3']").attr("selected", true);//有效！ */
		 
	});
	


</script>

<script type="text/javascript">
		$(document).ready(function() {
			$("#customChooseEmp").select2();
			/* $("#masterStatusLists").select2(); */
		});
		</script> 

<script type="text/javascript">
function gettax(){
	 var salary = document.form1.textfield.value;
	 var duoyu=salary-3500;
	 var tax;
	if(duoyu<=0)
	tax=0;
	 if (duoyu>0&&duoyu<=1500){tax=duoyu*0.03;}
	 if (duoyu>1500&&duoyu<=4500){tax=duoyu*0.1-105;}
	 if (duoyu>4500&&duoyu<=9000){tax=duoyu*0.2-555;}
	 if (duoyu>9000&&duoyu<=35000){tax=duoyu*0.25-1005;}
	 if (duoyu>35500&&duoyu<=55000){tax=duoyu*0.3-2755;}
	 if (duoyu>55000&&duoyu<=80000){tax=duoyu*0.35-5505;}
	 if (duoyu>80000){tax=duoyu*0.45-13505;}
	document.form2.textfield2.value=tax;
}
</script>


 </head>

 <body>
 <div class="container">
    <form action="" class="form-horizontal"  role="form">
        <fieldset>
            <legend>Test</legend>
            
			<div class="form-group">
                <!-- <label for="dtp_input2" class="col-md-2 control-label">Date Picking</label> -->
                <div class="input-group input-group-sm editemp_form1 date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <!-- <div class="input-group input-group-sm editemp_form1"> -->
					<span class="input-group-addon">Birthday:</span>
                    <input class="form-control" size="16" type="text" value="" readonly>
                   <!--  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span> -->
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
				<!-- <input type="hidden" id="dtp_input2" value="" /><br/> -->
            </div>
            
            
            <div class="form-group">
                <input it="testfield" size="16" type="text" value="<s:property value="%{getText('format.date',{#session.eip_emp.contractEndDate})}"/>" class="form_date" data-date-format="yyyy-mm-dd">
            </div>
			
        </fieldset>
    </form>
</div>
	<form id="hrbip_form_positionTitle" action="hRBaseInfoAction">
		<input type="hidden" name="operationFlag_tohbip" value="savePositionTitle">
		<input type="text" class="form-control" name="hrbip_savePt_titleName">
		<input type="submit" class="btn btn-primary btn-sm" value="Submit" id="testBtn">
	</form>
	<div class="col-md-12">
					<div class="panel-body">
							<!-- <select id="filterOption" onchange="changetxt(this)" class="selectpicker" name="fsip_filter"></select> -->
							<select multiple name="fsip_customChooseEmp" id="customChooseEmp" style="width:500px" class="populate">
								<option value="A">Asssssssssssssssssssss</option>
								<option value="B">Bsssssssssssssssssssss</option>
								<option value="C">Csssssssssssssssssssss</option>
								<option value="D">Dsssssssssssssssssssss</option>
								<option value="E">Esssssssssssssssssssss</option>
								<option value="F">Fsssssssssssssssssssss</option>
								<option value="G">Gsssssssssssssssssssss</option>
								<option value="H">Hsssssssssssssssssssss</option>
								<option value="I">Isssssssssssssssssssss</option>
								<option value="J">Jsssssssssssssssssssss</option>
								<option value="K">Ksssssssssssssssssssss</option>
							</select>
						</div>
	
	</div>
	
<div class="col-md-3 column">
	<div class="selectpicker_class2" style="margin-bottom: 15px;">
		<label style="margin-bottom: 10px;">Filter By:</label>
		<select id="filterOption" class="selectpicker" name="fsip_filter" style="width: 200px;">
		    <option value="1">Department</option>
		    <option value="2">Cost Center</option>
		    <option value="3">自定义</option>
		 </select>
</div>
</div>


<form name="form1" method="post" action="">
个人所得税计算器（当地个人所得税起征额3500元）<hr align="center" size="3"><hr size="3">
<label>请输入你的个人收入:         
  <input name="textfield" type="text">
<input type="button" name="acount" value="计算" onClick="gettax()">
</label>

</form>

<form name="form2" method="post" action="">
<label>你的个人所得税为：     
  <input name="textfield2" type="text">
</label>
</form>


 </BODY>
</HTML>