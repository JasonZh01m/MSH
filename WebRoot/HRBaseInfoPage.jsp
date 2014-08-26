<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HR Information</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="css/style2.css" rel="stylesheet">
<link href="css/bootstrap-select1.css" rel="stylesheet">
<style type="text/css">
.edit_hover :hover { color: #428BCA !important; }
.delete_hover :hover { color: #d9534f !important; }

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


.selectpicker_class3{
	height:30px;
	margin-bottom: 10px;
}

.selectpicker_class3 .bootstrap-select{
	width: 160px;
}

.selectpicker_class3 label{
	margin-right: 5px;
}

/* #A94442 */

.red-tooltip + .tooltip > .tooltip-inner{background-color: #FF6633;}
.red-tooltip + .tooltip > .tooltip-arrow{border-top-color: #FF6633;}

</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.editableonlynumber.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate/jquery-validate.bootstrap-tooltip.js"></script>
<script type="text/javascript" src="js/selectpicker.js"></script>
<script type="text/javascript">
	$(function() {
		$(".editPositionTitleBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editPt_titleId").val(td1.text().trim());
			$("#hrbip_editPt_titleName").val(td1.next().text().trim());
			$("#hrbip_editPt_desc").val(td1.next().next().text().trim());
		});
	
		$(".deletePositionTitleBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deletePositionTitleName").text(td1.next().text().trim());
			$("#hrbip_deletePt_titleId").val(td1.text().trim());
		});
		
		
		$(".editDepartBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editDepart_Id").val(td1.text().trim());
			$("#hrbip_editDepart_Name").val(td1.next().text().trim());
			$("#hrbip_editDepart_Desc").val(td1.next().next().text().trim());
			/* $("#hrbip_editDepart_Manager").val(td1.next().next().next().text().trim()); */
			var va = td1.next().next().next().text().trim();
			$("#hrbip_editDepart_Manager option[value='" + va +"']").attr("selected", true);
			$('.selectpicker').selectpicker('refresh');
		});	
		
		$(".deleteDepartBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deleteDepartName").text(td1.next().text().trim());
			$("#hrbip_deleteDepart_Id").val(td1.text().trim());
		});
		
		
		$(".editMBOBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editMBO_Id").val(td1.text().trim());
			$("#hrbip_editMBO_Rate").val(td1.next().text().trim());
			/* $("#hrbip_editMBO_PaidPeriod").val(td1.next().next().text().trim()); */
			
			var va = td1.next().next().text().trim();
			if(va =="季度") {
				$("#hrbip_editMBO_PaidPeriod option[value='1']").attr("selected", true);
			} else if(va=="年度") {
				$("#hrbip_editMBO_PaidPeriod option[value='2']").attr("selected", true);
			}
			$('.selectpicker').selectpicker('refresh');
			
			$("#hrbip_editMBO_Desc").val(td1.next().next().next().text().trim());
		
		});
		
		$(".deleteMBOBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deleteMBO").text(td1.next().text().trim());
			$("#hrbip_deleteMBO_Id").val(td1.text().trim());
		
		});
		
		$(".editCostCenterBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editCostCenter_Id").val(td1.text().trim());
			$("#hrbip_editCostCenter_Name").val(td1.next().text().trim());
			$("#hrbip_editCostCenter_Parent").val(td1.next().next().text().trim());
			$("#hrbip_editCostCenter_Owner").val(td1.next().next().next().text().trim());
			$("#hrbip_editCostCenter_Description").val(td1.next().next().next().next().text().trim());
		});
		
		$(".deleteCostCenterBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deleteCostCenter").text(td1.next().text().trim());
			$("#hrbip_deleteCostCenter_Id").val(td1.text().trim());
		});
		
		$(".editVacationBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editVacation_Id").val(td1.text().trim());
			$("#hrbip_editVacation_Name").val(td1.next().text().trim());
			$("#hrbip_editVacation_TsId").val(td1.next().next().text().trim());
			/* $("#hrbip_editVacation_PaidRate").val(td1.next().next().next().text().trim()); */
			var va = td1.next().next().next().text().trim();
			if(va=="Not Paid") {
				$("#hrbip_editVacation_PaidRate option[value='0']").attr("selected", true);
			} else if(va=="Paid") {
				$("#hrbip_editVacation_PaidRate option[value='1']").attr("selected", true);
			}
			$('.selectpicker').selectpicker('refresh');
			
			$("#hrbip_editVacation_Desc").val(td1.next().next().next().next().text().trim());
		
		});
		
		$(".deleteVacationBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deleteVacation").text(td1.next().text().trim());
			$("#hrbip_deleteVacation_Id").val(td1.text().trim());
		
		});
		
		$(".editContractBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editContractType_Id").val(td1.text().trim());
			$("#hrbip_editContractType_Name").val(td1.next().text().trim());
			$("#hrbip_editContractType_Desc").val(td1.next().next().text().trim());
		
		});
		
		$(".deleteContractBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deleteContractType").text(td1.next().text().trim());
			$("#hrbip_deleteContractType_Id").val(td1.text().trim());
		
		});
		
		$(".editEmpTypeBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#hrbip_editEmpType_Id").val(td1.text().trim());
			$("#hrbip_editEmpType_Name").val(td1.next().text().trim());
			$("#hrbip_editEmpType_Desc").val(td1.next().next().text().trim());
		});
		
		$(".deleteEmpTypeBtn").click(function() {
			var td1 = $(this).parent().parent().children().first();
			$("#deleteEmpType").text(td1.next().text().trim());
			$("#hrbip_deleteEmpType_Id").val(td1.text().trim());
		});
		
		
		
		
		$("#hrbip_form_EditPositionTitle").validate({
			rules: {
				hrbip_editPt_titleName: {
					required: true
				},
				hrbip_editPt_desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editPt_titleName: {
					trigger:'focus'
				},
				hrbip_editPt_desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddPositionTitle").validate({
			rules: {
				hrbip_savePt_titleName: {
					required: true
				},
				hrbip_savePt_desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_savePt_titleName: {
					trigger:'focus'
				},
				hrbip_savePt_desc: {
					trigger:'focus'
				}
			}
		});
		
		
		$("#hrbip_form_EditDepart").validate({
			rules: {
				hrbip_editDepart_Name: {
					required: true
				},
				hrbip_editDepart_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editDepart_Name: {
					trigger:'focus'
				},
				hrbip_editDepart_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddDepart").validate({
			rules: {
				hrbip_addDepart_Name: {
					required: true
				},
				hrbip_addDepart_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_addDepart_Name: {
					trigger:'focus'
				},
				hrbip_addDepart_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_EditMBO").validate({
			rules: {
				hrbip_editMBO_Rate: {
					required: true,
					number: true
				},
				hrbip_editMBO_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editMBO_Rate: {
					trigger:'focus'
				},
				hrbip_editMBO_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddMBO").validate({
			rules: {
				hrbip_addMBO_Rate: {
					required: true,
					number: true
				},
				hrbip_addMBO_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_addMBO_Rate: {
					trigger:'focus'
				},
				hrbip_addMBO_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_EditCostCenter").validate({
			rules: {
				hrbip_editCostCenter_Name: {
					required: true
				},
				hrbip_editCostCenter_Parent: {
					required: true
				},
				hrbip_editCostCenter_Owner: {
					required: true
				},
				hrbip_editCostCenter_Description: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editCostCenter_Name: {
					trigger:'focus'
				},
				hrbip_editCostCenter_Parent: {
					trigger:'focus'
				},
				hrbip_editCostCenter_Owner: {
					trigger:'focus'
				},
				hrbip_editCostCenter_Description: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddCostCenter").validate({
			rules: {
				hrbip_addCostCenter_Name: {
					required: true
				},
				hrbip_addCostCenter_Parent: {
					required: true
				},
				hrbip_addCostCenter_Owner: {
					required: true
				},
				hrbip_addCostCenter_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_addCostCenter_Name: {
					trigger:'focus'
				},
				hrbip_addCostCenter_Parent: {
					trigger:'focus'
				},
				hrbip_addCostCenter_Owner: {
					trigger:'focus'
				},
				hrbip_addCostCenter_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_EditVacationType").validate({
			rules: {
				hrbip_editVacation_Name: {
					required: true
				},
				hrbip_editVacation_TsId: {
					required: true,
					digits: true
				},
				hrbip_editVacation_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editVacation_Name: {
					trigger:'focus'
				},
				hrbip_editVacation_TsId: {
					trigger:'focus'
				},
				hrbip_editVacation_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddVacationType").validate({
			rules: {
				hrbip_addVacation_Name: {
					required: true
				},
				hrbip_addVacation_TsId: {
					required: true,
					digits: true
				},
				hrbip_addVacation_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_addVacation_Name: {
					trigger:'focus'
				},
				hrbip_addVacation_TsId: {
					trigger:'focus'
				},
				hrbip_addVacation_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_EditContractType").validate({
			rules: {
				hrbip_editContractType_Name: {
					required: true
				},
				hrbip_editContractType_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editContractType_Name: {
					trigger:'focus'
				},
				hrbip_editContractType_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddContractType").validate({
			rules: {
				hrbip_addContractType_Name: {
					required: true
				},
				hrbip_addContractType_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_addContractType_Name: {
					trigger:'focus'
				},
				hrbip_addContractType_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_EditEmpType").validate({
			rules: {
				hrbip_editEmpType_Name: {
					required: true
				},
				hrbip_editEmpType_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_editEmpType_Name: {
					trigger:'focus'
				},
				hrbip_editEmpType_Desc: {
					trigger:'focus'
				}
			}
		});
		
		$("#hrbip_form_AddEmpType").validate({
			rules: {
				hrbip_addEmpType_Name: {
					required: true
				},
				hrbip_addEmpType_Desc: {
					required: true
				}
			},
			
			tooltip_options: {
				hrbip_addEmpType_Name: {
					trigger:'focus'
				},
				hrbip_addEmpType_Desc: {
					trigger:'focus'
				}
			}
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
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					HR Base Info Page<small> HR Base Info</small>
				</h1>
				<!-- <s:set name="hrbip_depart_Manager_Option_Value" value=""></s:set> -->
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Position Title
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									Title Name
								</th>
								<th>
									Description
								</th>
								<th>
									Create Date
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator var="hrbip_ptItor" value="#session.hrbip_positiontitleList">
							<tr>
								<td style="display: none;"> 
									<s:property value="#hrbip_ptItor.positionTitleId"/>
								</td>
								<td>
									<s:property value="#hrbip_ptItor.positionTitleName"/>
								</td>
								<td>
									<s:property value="#hrbip_ptItor.positionTitleDesc"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#hrbip_ptItor.createDate})}"/>
								</td>
								<td>
									<a href="#modal-container-positionTitleEdit" role="button" class="btn editPositionTitleBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
								<td>
									<a  href="#modal-container-positionTitleDelete" role="button" class="btn deletePositionTitleBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
								</td>
							</tr>
						</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a id="modal-positionTitleAdd" href="#modal-container-positionTitleAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
					
				</div>
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Department
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<!-- <th>
									ID
								</th> -->
								<th>
									Depart Name
								</th>
								<th>
									Description
								</th>
								<th>
									Manager
								</th>
								<th>
									Create Date
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="hrbip_departItor" value="#session.hrbip_departmentList">
							<tr>
								<td style="display: none;">
									<s:property value="#hrbip_departItor.departId"/>
								</td>
								<td>
									<s:property value="#hrbip_departItor.departName"/>
								</td>
								<td>
									<s:property value="#hrbip_departItor.departDesc"/>
								</td>
								<td>
									<s:property value="#hrbip_departItor.emp.empLoginId"/>
								</td>
								<td>
									<s:property value="%{getText('format.date',{#hrbip_departItor.createDate})}"/>
								</td>
								<td>
									<a  href="#modal-container-DepartEdit" role="button" class="btn editDepartBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
								<td>
									<a  href="#modal-container-DepartDelete" role="button" class="btn deleteDepartBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
								</td>
							</tr>
						</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a  href="#modal-container-DepartAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								MBO
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									Rate
								</th>
								<th>
									Paid Period
								</th>
								<th>
									Description
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="hrbip_mboItor" value="#session.hrbip_mboList">
								<tr>
									<td style="display: none;">
										<s:property value="#hrbip_mboItor.mboId"/>
									</td>
									<td>
										<s:property value="#hrbip_mboItor.mboRate"/>
									</td>
									<td>
										<s:if test='#hrbip_mboItor.mboPaidPeriod == "1"'>季度</s:if><s:elseif test='#hrbip_mboItor.mboPaidPeriod == "2"'>年度</s:elseif>
									</td>
									<td>
										<s:property value="#hrbip_mboItor.mboDesc"/>
									</td>
									<td>
										<a  href="#modal-container-MBOEdit" role="button" class="btn editMBOBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a  href="#modal-container-MBODelete" role="button" class="btn deleteMBOBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a  href="#modal-container-MBOAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
					
				</div>
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Cost Center
							</h3>
						</div>
						<div class="panel-body">
						<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									Name
								</th>
								<th>
									Parent
								</th>
								<th>
									Owner
								</th>
								<th>
									Description
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="hrbip_ccItor" value="#session.hrbip_costcenterList">
								<tr>
									<td style="display: none;">
										<s:property value="#hrbip_ccItor.costCenterId"/>
									</td>
									<td>
										<s:property value="#hrbip_ccItor.costCenterName"/>
									</td>
									<td>
										<s:property value="#hrbip_ccItor.costCenterParent"/>
									</td>
									<td>
										<s:property value="#hrbip_ccItor.costCenterOwner"/>
									</td>
									<td>
										<s:property value="#hrbip_ccItor.costCenterDesc"/>
									</td>
									<td>
										<a  href="#modal-container-CostCenterEdit" role="button" class="btn editCostCenterBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a  href="#modal-container-CostCenterDelete" role="button" class="btn deleteCostCenterBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a  href="#modal-container-CostCenterAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Vacation Type
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									Name
								</th>
								<th>
									Time Sheet ID
								</th>
								<th>
									Paid or Not
								</th>
								<th>
									Description
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="hrbip_vtItor" value="#session.hrbip_vacationtypeList">
								<tr>
									<td style="display: none;">
										<s:property value="#hrbip_vtItor.vacationTypeId"/>
									</td>
									<td>
										<s:property value="#hrbip_vtItor.vacationTypeName"/>
									</td>
									<td>
										<s:property value="#hrbip_vtItor.timeSheetOrderId"/>
									</td>
									<td>
										<s:if test='#hrbip_vtItor.vacationPaidRate == "1"'>Paid</s:if><s:elseif test='#hrbip_vtItor.vacationPaidRate == "0"'>Not Paid</s:elseif>
									</td>
									<td>
										<s:property value="#hrbip_vtItor.vacationTypeDesc"/>
									</td>
									<td>
										<a href="#modal-container-VacationEdit" role="button" class="btn editVacationBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a href="#modal-container-VacationDelete" role="button" class="btn deleteVacationBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a  href="#modal-container-VacationAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
					
				</div>
				<div class="col-md-6 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Contract Type
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									Name
								</th>
								<th>
									Description
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="hrbip_ctItor" value="#session.hrbip_contracttypeList">
								<tr>
									<td style="display: none;">
										<s:property value="#hrbip_ctItor.contractTypeId"/>
									</td>
									<td>
										<s:property value="#hrbip_ctItor.contractTypeName"/>
									</td>
									<td>
										<s:property value="#hrbip_ctItor.contractTypeDesc"/>
									</td>
									<td>
										<a  href="#modal-container-ContractTypeEdit" role="button" class="btn editContractBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a  href="#modal-container-ContractTypeDelete" role="button" class="btn deleteContractBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a  href="#modal-container-ContractTypeAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Employee Type
							</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>
									Name
								</th>
								<th>
									Description
								</th>
								<th>
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator var="hrbip_etItor" value="#session.hrbip_emptypeList">
								<tr>
									<td style="display: none;">
										<s:property value="#hrbip_etItor.empTypeId"/>
									</td>
									<td>
										<s:property value="#hrbip_etItor.empTypeName"/>
									</td>
									<td>
										<s:property value="#hrbip_etItor.empTypeDesc"/>
									</td>
									<td>
										<a  href="#modal-container-EmpTypeEdit" role="button" class="btn editEmpTypeBtn edit_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a  href="#modal-container-EmpTypeDelete" role="button" class="btn deleteEmpTypeBtn delete_hover" data-toggle="modal" style="padding: 0px; font-size: 13px;"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
						</div>
						<div class="panel-footer" style="text-align: right;">
							<a  href="#modal-container-EmpTypeAdd"
							role="button" class="btn" data-toggle="modal"
							style="padding: 0px;" ><button
								type="button" class="btn btn-primary btn-sm">Add</button>
								</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- POSITION TITLE PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-positionTitleEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit Position Title
				</h4>
			</div>
		<form id="hrbip_form_EditPositionTitle" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editPositionTitle">
					<input type="hidden" name="hrbip_editPt_titleId" id="hrbip_editPt_titleId"/>
					<div class="form-group">
						 <label>Title Name:</label>
						 <input name="hrbip_editPt_titleName" id="hrbip_editPt_titleName" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editPt_desc" id="hrbip_editPt_desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-positionTitleDelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					<span style="color: #ed9c28; font-size: 20px;" class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;Delete
				</h4>
			</div>
			<form id="hrbip_form_DeletePositionTitle" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deletePositionTitle">
					<input type="hidden" name="hrbip_deletePt_titleId" id="hrbip_deletePt_titleId"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deletePositionTitleName"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-positionTitleAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Position Title
				</h4>
			</div>
		<form id="hrbip_form_AddPositionTitle" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="savePositionTitle">
					<div class="form-group">
						 <label>Title Name:</label>
						 <input name="hrbip_savePt_titleName" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_savePt_desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>


<!-- DEPART PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-DepartEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit Department
				</h4>
			</div>
		<form id="hrbip_form_EditDepart" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editDepart">
					<input type="hidden" name="hrbip_editDepart_Id" id="hrbip_editDepart_Id"/>
					<div class="form-group">
						 <label>Depart Name:</label>
						 <input name="hrbip_editDepart_Name" id="hrbip_editDepart_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editDepart_Desc" id="hrbip_editDepart_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
					
					<div class="selectpicker_class2" style="float: left;">
					<label>Manager:</label>
					<select id="hrbip_editDepart_Manager" name="hrbip_editDepart_Manager" class="selectpicker" data-live-search="true">
					    <s:iterator var="hrbip_loginIdItor" value="#session.hrbip_loginviewList" status="st">
					   		<option class="hrbip_depart_Manager_Option" value="<s:property value="#hrbip_loginIdItor" />"><s:property value="#hrbip_loginIdItor" /></option>
					   	</s:iterator>
					 </select>
					</div>
					
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-DepartDelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Delete
				</h4>
			</div>
			<form id="hrbip_form_DeleteDepart" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deleteDepart">
					<input type="hidden" name="hrbip_deleteDepart_Id" id="hrbip_deleteDepart_Id"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deleteDepartName"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-DepartAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Department
				</h4>
			</div>
		<form id="hrbip_form_AddDepart"  action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="addDepart">
					<div class="form-group">
						 <label>Depart Name:</label>
						 <input name="hrbip_addDepart_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_addDepart_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
					
					
					<div class="selectpicker_class2" style="float: left;">
					<label>Manager:</label>
					<select  name="hrbip_addDepart_Manager" class="selectpicker" data-live-search="true">
					    <s:iterator var="hrbip_loginIdItor" value="#session.hrbip_loginviewList" status="st">
					   		<option><s:property value="#hrbip_loginIdItor" /></option>
					   	</s:iterator>
					 </select>
					</div>
					
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>


<!-- MBO PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-MBOEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit MBO
				</h4>
			</div>
		<form id="hrbip_form_EditMBO" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editMBO">
					<input type="hidden" name="hrbip_editMBO_Id" id="hrbip_editMBO_Id"/>
					<div class="form-group">
						 <label>MBO Rate:</label>
						 <input name="hrbip_editMBO_Rate" id="hrbip_editMBO_Rate" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Paid Period:</label>
						 <!-- <input name="hrbip_editMBO_PaidPeriod" id="hrbip_editMBO_PaidPeriod" style="width: 200px;" type="text" class="form-control"  /> -->
						 <div class="selectpicker_class3" style="margin-top: 5px; margin-bottom: 15px;">
							 <select name="hrbip_editMBO_PaidPeriod" id="hrbip_editMBO_PaidPeriod" class="selectpicker">
							    <option value="1">季度</option>
							    <option value="2">年度</option>
							 </select>
						 </div>
						 
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editMBO_Desc" id="hrbip_editMBO_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-MBODelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Delete
				</h4>
			</div>
			<form  action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deleteMBO">
					<input type="hidden" name="hrbip_deleteMBO_Id" id="hrbip_deleteMBO_Id"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deleteMBO"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-MBOAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a MBO
				</h4>
			</div>
		<form id="hrbip_form_AddMBO" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="addMBO">
					<div class="form-group">
						 <label>MBO Rate:</label>
						 <input name="hrbip_addMBO_Rate" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Paid Period:</label>
						 <!-- <input name="hrbip_addMBO_PaidPeriod" style="width: 200px;" type="text" class="form-control"  /> -->
						 <div class="selectpicker_class3" style="margin-top: 5px; margin-bottom: 15px;">
							 <select name="hrbip_addMBO_PaidPeriod" id="hrbip_addMBO_PaidPeriod" class="selectpicker">
							    <option value="1">季度</option>
							    <option value="2">年度</option>
							 </select>
						 </div>
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_addMBO_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
					
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>

<!-- COST CENTER PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-CostCenterEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit Cost Center
				</h4>
			</div>
		<form id="hrbip_form_EditCostCenter" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editCostCenter">
					<input type="hidden" name="hrbip_editCostCenter_Id" id="hrbip_editCostCenter_Id"/>
					<div class="form-group">
						 <label>Cost Center Name:</label>
						 <input name="hrbip_editCostCenter_Name" id="hrbip_editCostCenter_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Parent:</label>
						 <input name="hrbip_editCostCenter_Parent" id="hrbip_editCostCenter_Parent" style="width: 200px;" type="text" class="form-control red-tooltip" />
					</div>
					<div class="form-group">
						 <label>Owner:</label>
						  <input name="hrbip_editCostCenter_Owner" id="hrbip_editCostCenter_Owner" style="width: 200px;" type="text" class="form-control red-tooltip"/>
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editCostCenter_Description" id="hrbip_editCostCenter_Description" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-CostCenterDelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Delete
				</h4>
			</div>
			<form  action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deleteCostCenter">
					<input type="hidden" name="hrbip_deleteCostCenter_Id" id="hrbip_deleteCostCenter_Id"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deleteCostCenter"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-CostCenterAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Cost Center
				</h4>
			</div>
		<form id="hrbip_form_AddCostCenter" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="addCostCenter">
					<div class="form-group">
						 <label>CostCenter Name:</label>
						 <input name="hrbip_addCostCenter_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Parent:</label>
						 <input name="hrbip_addCostCenter_Parent" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Owner:</label>
						 <input name="hrbip_addCostCenter_Owner" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_addCostCenter_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
					
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>

<!-- VACATION TYPE PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-VacationEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit Vacation Type
				</h4>
			</div>
		<form id="hrbip_form_EditVacationType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editVacation">
					<input type="hidden" name="hrbip_editVacation_Id" id="hrbip_editVacation_Id"/>
					<div class="form-group">
						 <label>Name:</label>
						 <input disabled="disabled" name="hrbip_editVacation_Name" id="hrbip_editVacation_Name" style="width: 200px;" type="text" class="form-control red-tooltip" />
					</div>
					<div class="form-group">
						 <label>Time Sheet ID:</label>
						 <input disabled="disabled" name="hrbip_editVacation_TsId" id="hrbip_editVacation_TsId" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Paid Rate:</label>
						  <!-- <input name="hrbip_editVacation_PaidRate" id="hrbip_editVacation_PaidRate" style="width: 200px;" type="text" class="form-control"/> -->
						  <div class="selectpicker_class3" style="margin-top: 5px; margin-bottom: 15px;">
							 <select name="hrbip_editVacation_PaidRate" id="hrbip_editVacation_PaidRate" class="selectpicker">
							    <option value="0">Not Paid</option>
							    <option value="1">Paid</option>
							 </select>
						 </div>
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editVacation_Desc" id="hrbip_editVacation_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-VacationDelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Delete
				</h4>
			</div>
			<form  action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deleteVacation">
					<input type="hidden" name="hrbip_deleteVacation_Id" id="hrbip_deleteVacation_Id"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deleteVacation"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-VacationAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Vacation Type
				</h4>
			</div>
		<form id="hrbip_form_AddVacationType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="addVacation">
					<div class="form-group">
						 <label>Name:</label>
						 <input name="hrbip_addVacation_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Time Sheet ID:</label>
						 <input name="hrbip_addVacation_TsId" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Paid Rate:</label>
						 <!-- <input name="hrbip_addVacation_PaidRate" style="width: 200px;" type="text" class="form-control"  /> -->
						 <div class="selectpicker_class3" style="margin-top: 5px; margin-bottom: 15px;">
							 <select name="hrbip_addVacation_PaidRate" id="hrbip_addVacation_PaidRate" class="selectpicker">
							    <option value="0">Not Paid</option>
							    <option value="1">Paid</option>
							 </select>
						 </div>
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_addVacation_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
					
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>

<!-- CONTRACT TYPE PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-ContractTypeEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit Contract Type
				</h4>
			</div>
		<form id="hrbip_form_EditContractType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editContractType">
					<input type="hidden" name="hrbip_editContractType_Id" id="hrbip_editContractType_Id"/>
					<div class="form-group">
						 <label>Name:</label>
						 <input name="hrbip_editContractType_Name" id="hrbip_editContractType_Name" style="width: 200px;" type="text" class="form-control red-tooltip" />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editContractType_Desc" id="hrbip_editContractType_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-ContractTypeDelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Delete
				</h4>
			</div>
			<form  action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deleteContractType">
					<input type="hidden" name="hrbip_deleteContractType_Id" id="hrbip_deleteContractType_Id"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deleteContractType"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-ContractTypeAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Contract Type
				</h4>
			</div>
		<form id="hrbip_form_AddContractType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="addContractType">
					<div class="form-group">
						 <label>Name:</label>
						 <input name="hrbip_addContractType_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_addContractType_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>

<!-- Emp TYPE PART -->
<!-- Edit -->
<div class="modal fade" id="modal-container-EmpTypeEdit" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Edit Emp Type
				</h4>
			</div>
		<form id="hrbip_form_EditEmpType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
				<input type="hidden" name="operationFlag_tohbip" value="editEmpType">
					<input type="hidden" name="hrbip_editEmpType_Id" id="hrbip_editEmpType_Id"/>
					<div class="form-group">
						 <label>Name:</label>
						 <input name="hrbip_editEmpType_Name" id="hrbip_editEmpType_Name" style="width: 200px;" type="text" class="form-control red-tooltip" />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_editEmpType_Desc" id="hrbip_editEmpType_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete -->
<div class="modal fade" id="modal-container-EmpTypeDelete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Delete
				</h4>
			</div>
			<form  action="hRBaseInfoAction" role="form" accept-charset="utf-8">
				<input type="hidden" name="operationFlag_tohbip" value="deleteEmpType">
					<input type="hidden" name="hrbip_deleteEmpType_Id" id="hrbip_deleteEmpType_Id"/>
			<div class="modal-body">
				Do you really want to delete "<span id="deleteEmpType"></span>"?
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button> 
				 <button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>&nbsp;Delete</button>
			</div>
			</form>
		</div>
		
	</div>
</div>
<!-- Add -->
<div class="modal fade" id="modal-container-EmpTypeAdd" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-top: 100px; width: 25%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					Add a Emp Type
				</h4>
			</div>
		<form id="hrbip_form_AddEmpType" action="hRBaseInfoAction" role="form" accept-charset="utf-8">
			<div class="modal-body">
					<input type="hidden" name="operationFlag_tohbip" value="addEmpType">
					<div class="form-group">
						 <label>Name:</label>
						 <input name="hrbip_addEmpType_Name" style="width: 200px;" type="text" class="form-control red-tooltip"  />
					</div>
					<div class="form-group">
						 <label>Description:</label>
						 <textarea name="hrbip_addEmpType_Desc" style="width: 320px; height: 70px;" class="form-control red-tooltip" resize: none;"></textarea>
					</div>
			</div>
			<div class="modal-footer">
				 <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button> 
				 <button type="submit" class="btn btn-primary btn-sm">Save</button>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>