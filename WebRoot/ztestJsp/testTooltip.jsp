<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link type="text/css" href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-ui-1.10.0.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
 -->

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/bootstrap-select.min.css" rel="stylesheet">
<link href="css/bootstrap-select.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/select2.css" />

<!-- <link type="text/css" href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" /> -->
<link href="css/style2.css" rel="stylesheet">
<script src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.editableonlynumber.js"></script>
<!-- <script type="text/javascript" src="js/jquery-ui-1.10.0.custom.min.js"></script> -->
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="js/bootstrap-validate.js"></script> -->
<script type="text/javascript" src="js/validate/jquery-validation-bootstrap-tooltip.js"></script>

<script type="text/javascript" src="js/select2.js"></script>

<!-- <script type="text/javascript" src="js/scripts.js"></script> -->
<script type="text/javascript">
	$(function() {
		/* Tool tip */
	   /*  $("#abc123").tooltip(); */
	    
	   /* $('.selectpicker').selectpicker({
               /*  'selectedText': 'cat' */
            /* });
            
        $("#submitBtn").click(function() {
        	alert("click");
       		$('#inputEmail').validation(); 
        });  */
            
            
       /*  $("#theform").validate({
			rules: {
			example4: {email:true, required: true},
			example5: {required: true}
			},
			messages: {
			example5: "Just check the box<h5 class='text-error'>You aren't going to read the EULA</h5>"
			},
			tooltip_options: {
			example4: {trigger:'focus'},
			example5: {placement:'right',html:true}
			},
			});     */
            
        
            
	    
}); 

</script>

</head>
<body>
<br>
<br><br><br><br>
<div style="margin: 40px;"><span id="abc123" title="abc占个人社保基数百分比。">百分比(%)</span></div>
  <div>   
<p id="titles">You can add a search input by passing <code>data-live-search="true"</code> attribute:</p>
<div class="bs-docs-example">
  <select class="selectpicker" data-live-search="true">
    <option>Hot Dog, Fries and a Soda</option>
    <option>Burger, Shake and a Smile</option>
    <option>Sugar, Spice and all things nice</option>
  </select>
</div>  
      </div>   
      
      <div>
<!-- <div id="testForm" class="form-horizontal">
    <div class="control-group">
        <label class="control-label" for="inputEmail">邮箱</label>
        <div class="controls">
            <input type="text" id="inputEmail" check-type="mail" mail-message="邮箱格式不正确！" >
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPassword">密码</label>
        <div class="controls">
            <input type="password" id="inputPassword" check-type="required" required-message="密码不能为空！" >
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumber">数字</label>
        <div class="controls">
            <input type="text" id="inputNumber" check-type="number" required-message="Please input a number!" >
        </div>
    </div>
    
    <div class="control-group">
        <label class="control-label" for="inputNumberOr">小数或者整数</label>
        <div class="controls">
            <input type="text" id="inputNumberOr" check-type="double" required-message="Please input a double!" >
        </div>
    </div>
    
    <div class="control-group">
        <div class="controls">
            <button id="submitBtn" type="submit" class="btn">登录</button>
        </div>
    </div>
</div> -->

<form id = "theform">
	<input type="text" name="example1" required><br>
	<input type="number" data-placement="bottom" name="example2" required name="example2"><br>
	<input type="text" class="required email" data-trigger="focus" name="example3""><br>
	<input type="text" name="example4"><br>
	<input type="checkbox" name="example5"><br>
	<input type="submit" value="submit">
  </form>
      </div>
      
      <script type="text/javascript">
		$(document).ready(function() {
			$("#customChooseEmp").select2();
		/* 	$("#masterStatusLists").select2(); */
		});
		</script>
      
      
     <div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-6 column">
				<form id="form1" action="testAction2" method="post">
				<!-- <input type="hidden" value="forTest" name="forTest"> -->
				<input type="hidden" name="forTest" size="20" value="1">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Panel title
							</h3>
						</div>
						<div class="panel-body">
							<!-- <select id="filterOption" onchange="changetxt(this)" class="selectpicker" name="fsip_filter"></select> -->
							<select multiple name="fsip_customChooseEmp" id="customChooseEmp" class="selectpicker" style="width:300px" class="populate">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
								<option value="E">E</option>
								<option value="F">F</option>
								<option value="G">G</option>
								<option value="H">H</option>
								<option value="I">I</option>
								<option value="J">J</option>
								<option value="K">K</option>
							</select>
						</div>
						
						<div class="panel-footer">
							<input type="submit" value="Submit">
						</div>
					</div>
					</form>
				</div>
				<div class="col-md-6 column">
				</div>
			</div>
		</div> 

</body>
</html>