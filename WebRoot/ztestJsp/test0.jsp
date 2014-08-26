<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">

<style type="text/css">
	body{
		padding: 40px;
	}
	
	.row {
		padding-bottom: 20px;
	}

.red-tooltip + .tooltip > .tooltip-inner{background-color: #A94442;}
.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #A94442;}	
	
</style>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="../js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript">
$(function() {
		
		/*  $("#theform").validate({
        rules: {     
           thefield: { digits:true, required: true } 
        },
        tooltip_options: {
           thefield: { placement: 'left' }
        }
     });
 */
 
 $("#submit2").click(function() {
 		$("#theform").submit();
 
 })


        $("#theform").validate({
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
			});    
}); 


</script>

</head>
<body>
<form id = "theform" style="width: 400px;">
		<div class="row">
			<div class="span1">
				<label class="text-right padding-top5">Input</label>
			</div>
			<div class="span7">
				<input class="form-control" type="text" name="example1" required placeholder="Required">
			</div>
		</div>
		<div class="row">						
			<div class="span1">
				<label class="text-right">Tag</label>
			</div>
			<div class=span5">
				<code>&lt;input type="text" name="example1" required&gt;</code>
			</div>	
		</div>
		<div class="row">
			<div class="span1">
				<label class="text-right padding-top5">Input</label>
			</div>
			<div class="span7">
				<input class="form-control red-tooltip" type="number" data-placement="top" name="example2" required placeholder="Number required">
			</div>
		</div>
	<div class="row">
		<div class="span1">
			<label class="text-right padding-top5">Input</label>
		</div>
		<div class="span7">
			<input  class="form-control" type="text" class="required email" data-trigger="focus" name="example3" placeholder="Email required">
		</div>
	</div>
	
	<div class="row">
		<div class="span1">
			<label class="text-right padding-top5">Input</label>
		</div>
		<div class="span7">
			<input class="form-control" type="text" name="example4">
		</div>
	</div>
	
	<div class="row">
		<div class="span1">
			<label class="text-right padding-top5">Input</label>
		</div>
		<div class="span7">
			<input type="checkbox" name="example5">
		</div>
	</div>
	
	
	
	<input class="btn btn-primary" type="submit" value="submit">
	<h5 class="text-error">this is text error</h5>
  </form>
  
  <input class="btn btn-primary" type="submit2" value="submit2" id="submit2">


</body>
</html>