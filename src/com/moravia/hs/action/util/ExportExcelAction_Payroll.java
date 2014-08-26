package com.moravia.hs.action.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidationConstraint.OperatorType;
import org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.BaseAction;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Payrollrecord;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;

@Controller("exportExcelAction_Payroll")
public class ExportExcelAction_Payroll extends BaseAction {
	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;

	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;

	private String fsip_startDate2;
	private String fsip_endDate2;

	public String getFsip_startDate2() {
		return fsip_startDate2;
	}

	public void setFsip_startDate2(String fsip_startDate2) {
		this.fsip_startDate2 = fsip_startDate2;
	}

	public String getFsip_endDate2() {
		return fsip_endDate2;
	}

	public void setFsip_endDate2(String fsip_endDate2) {
		this.fsip_endDate2 = fsip_endDate2;
	}

	public String export() throws Exception {

		Map<String, Object> session = getSession();
		// List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list =null;
		List<String> fsip_loginviewList = loginviewDAO.findAllLoginId(); 
		System.out.println("fsip_startDate2: " + fsip_startDate2);
		System.out.println("fsip_endDate2: " + fsip_endDate2);
		
		session.put("fsip_loginviewList", fsip_loginviewList);
		
		session.put("fsip_startDate", fsip_startDate2.trim());
		session.put("fsip_endDate", fsip_endDate2.trim());
		
		List<Payrollrecord> pList = payrollrecordDAO.findAllByDate(fsip_startDate2.trim(), fsip_endDate2.trim());
		if(pList == null || pList.size() == 0) {
			session.put("globalError", "No records has been found");
			return ERROR;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/*
		 * 设置表头：对Excel每列取名(必须根据你取的数据编写)
		 */
		String[] tableHeader = {
				"PID", 
				"Emp_empLoginID",
				"Month",
				"StartDate",
				"EndDate",
				"Base_Salary",
				"Quart_Bonus",
				"Post_Allowance",
				"Transport_Allowance",
				"Bonus",
				"Meal_Subsidy",
				"TotalTimeSheetHrs",
				"TotalWorkHrs",
				"Overtime",
				"Overtime_Pay",
				"Pension_Personal",
				"Pension_Company",
				"Medical_Personal",
				"Medical_Company",
				"Accum_Fund_Personal",
				"Accum_Fund_Company",
				"Unemp_Insu_Personal",
				"Unemp_Insu_Company",
				"Income_Tax",
				"OccupInjure_Maternity",
				"MBO_MonthlyPortion",
				"AnnualBonus_MonthlyPortion",
				"Other_Pay",
				"Department_Name",
				"CostCenter_Name",
				"Pay_Date",
				"PayrollNote",
				"Create_Date"};
		/*
		 * 下面的都可以拷贝不用编写
		 */
		short cellNumber = (short) tableHeader.length;// 表的列数
		XSSFWorkbook workbook = new XSSFWorkbook(); // 创建一个excel
		XSSFCell cell = null; // Excel的列
		XSSFRow row = null; // Excel的行
		
		XSSFCellStyle style = workbook.createCellStyle(); // 设置表头的类型
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
		
		XSSFCellStyle style1 = workbook.createCellStyle(); // 设置数据类型
		style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		
		XSSFCellStyle lockStyle = workbook.createCellStyle();
		lockStyle.setLocked(true);
		
		XSSFCellStyle unlockStyle = workbook.createCellStyle();
		unlockStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		unlockStyle.setLocked(false);
		
		XSSFFont font = workbook.createFont(); // 设置字体
		XSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
		Header header = sheet.getHeader();// 设置sheet的头
		try {
			/**
			 * 根据是否取出数据，设置header信息
			 * 
			 */
			if (pList.size() < 1) {
				header.setCenter("NO DATA!");
			} else {
				header.setCenter("Payroll");
				row = sheet.createRow(0);
				row.setHeight((short) 400);
				for (int k = 0; k < cellNumber; k++) {
					cell = row.createCell(k);// 创建第0行第k列
					cell.setCellValue(tableHeader[k]);// 设置第0行第k列的值
					sheet.setColumnWidth(k, 6000);// 设置列的宽度
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.
					font.setFontHeight((short) 300); // 设置单元字体高度
					style1.setFont(font);// 设置字体风格
					style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(style1);
				}

				for (int i = 0; i <= 21; i++) {
					sheet.autoSizeColumn(i);
				}

				for (int i = 0; i < pList.size(); i++) {
					Payrollrecord pr = pList.get(i);
					row = sheet.createRow((short) (i + 1));// 创建第i+1行
					row.setHeight((short) 400);// 设置行高

//					cell = row.createCell(0);// 创建第i+1行第0列
//					cell.setCellValue(i + 1);// 设置第i+1行第0列的值
//					cell.setCellStyle(style);// 设置风格
					
					if (pr.getPayrollId() != null) {
						cell = row.createCell(0);
						cell.setCellValue(pr.getPayrollId());
						cell.setCellStyle(style);
					}
					if (pr.getEmpEmpLoginId() != null) {
						cell = row.createCell(1);
						cell.setCellValue(pr.getEmpEmpLoginId());
						cell.setCellStyle(style);
					}
					if (pr.getMonth() != null) {
						cell = row.createCell(2);
						cell.setCellValue(pr.getMonth());
						cell.setCellStyle(style);
					}
					if (pr.getStartDate() != null) {
						cell = row.createCell(3);
						cell.setCellValue(sdf.format(pr.getStartDate()));
						cell.setCellStyle(style);
					}
					if (pr.getEndDate() != null) {
						cell = row.createCell(4);
						cell.setCellValue(sdf.format(pr.getEndDate()));
						cell.setCellStyle(style);
					}
					//Base Salary, Unlock
					if (pr.getBaseSalary() != null) {
						cell = row.createCell(5);
						cell.setCellValue(pr.getBaseSalary());
						cell.setCellStyle(unlockStyle);
					}
					//Quart Bonus, Unlock
					if (pr.getQuartBonus() != null) {
						cell = row.createCell(6);
						cell.setCellValue(pr.getQuartBonus());
						cell.setCellStyle(unlockStyle);
					}
					//Post Allowance, Unlock
					if (pr.getPostAllowance() != null) {
						cell = row.createCell(7);
						cell.setCellValue(pr.getPostAllowance());
						cell.setCellStyle(unlockStyle);
					}
					//Transport Allowance, Unlock
					if (pr.getTransportAllowance() != null) {
						cell = row.createCell(8);
						cell.setCellValue(pr.getTransportAllowance());
						cell.setCellStyle(unlockStyle);
					}
					//Bonus, Unlock
					if (pr.getBonus() != null) {
						cell = row.createCell(9);
						cell.setCellValue(pr.getBonus());
						cell.setCellStyle(unlockStyle);
					}
					//Meal Subsidy, Unlock
					if (pr.getMealSubsidy() != null) {
						cell = row.createCell(10);
						cell.setCellValue(pr.getMealSubsidy());
						cell.setCellStyle(unlockStyle);
					}
					//Total Time sheet Hrs, Unlock
					if (pr.getTotalTimeSheetHrs() != null) {
						cell = row.createCell(11);
						cell.setCellValue(pr.getTotalTimeSheetHrs());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getTotalWorkHrs() != null) {
						cell = row.createCell(12);
						cell.setCellValue(pr.getTotalWorkHrs());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getOvertime() != null) {
						cell = row.createCell(13);
						cell.setCellValue(pr.getOvertime());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getOvertimePay() != null) {
						cell = row.createCell(14);
						cell.setCellValue(pr.getOvertimePay());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getPensionPersonal() != null) {
						cell = row.createCell(15);
						cell.setCellValue(pr.getPensionPersonal());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getPensionCompany() != null) {
						cell = row.createCell(16);
						cell.setCellValue(pr.getPensionCompany());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getMedicalPersonal() != null) {
						cell = row.createCell(17);
						cell.setCellValue(pr.getMedicalPersonal());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getMedicalCompany() != null) {
						cell = row.createCell(18);
						cell.setCellValue(pr.getMedicalCompany());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getAccumFundPersonal() != null) {
						cell = row.createCell(19);
						cell.setCellValue(pr.getAccumFundPersonal());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getAccumFundCompany() != null) {
						cell = row.createCell(20);
						cell.setCellValue(pr.getAccumFundCompany());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getUnempInsuPersonal() != null) {
						cell = row.createCell(21);
						cell.setCellValue(pr.getUnempInsuPersonal());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getUnempInsuCompany() != null) {
						cell = row.createCell(22);
						cell.setCellValue(pr.getUnempInsuCompany());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getIncomeTax() != null) {
						cell = row.createCell(23);
						cell.setCellValue(pr.getIncomeTax());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getOccupInjureMaternity() != null) {
						cell = row.createCell(24);
						cell.setCellValue(pr.getOccupInjureMaternity());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getMboMonthlyPortion() != null) {
						cell = row.createCell(25);
						cell.setCellValue(pr.getMboMonthlyPortion());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getAnnualBonusMonthlyPortion() != null) {
						cell = row.createCell(26);
						cell.setCellValue(pr.getAnnualBonusMonthlyPortion());
						cell.setCellStyle(unlockStyle);
					}
					
					if (pr.getOtherPay() != null) {
						cell = row.createCell(27);
						cell.setCellValue(pr.getOtherPay());
						cell.setCellStyle(unlockStyle);
					}
					
					if (pr.getDepartmentName() != null) {
						cell = row.createCell(28);
						cell.setCellValue(pr.getDepartmentName());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getCostCenterName() != null) {
						cell = row.createCell(29);
						cell.setCellValue(pr.getCostCenterName());
						cell.setCellStyle(unlockStyle);
					}
					if (pr.getPayDate() != null) {
						cell = row.createCell(30);
						cell.setCellValue(sdf.format(pr.getPayDate()));
						cell.setCellStyle(style);
					} else if (pr.getPayDate() == null) {
						cell = row.createCell(30);
						cell.setCellValue("");
						cell.setCellStyle(style);
					}
					
					if (pr.getPayrollNote() != null) {
						cell = row.createCell(31);
						cell.setCellValue(pr.getPayrollNote());
						cell.setCellStyle(unlockStyle);
					} else if (pr.getPayrollNote() == null) {
						cell = row.createCell(31);
						cell.setCellValue("");
						cell.setCellStyle(unlockStyle);
					}
					
					if (pr.getCreateDate() != null) {
						cell = row.createCell(32);
						cell.setCellValue(sdftime.format(pr.getCreateDate()));
						cell.setCellStyle(style);
					}
				}
				
				XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
//				XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(new String[]{"Kept consistent", "Inconsistent by design"});
				XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper.createNumericConstraint(ValidationType.DECIMAL, DVConstraint.OperatorType.BETWEEN, "0.0", "1000000000000.0");
				XSSFDataValidationConstraint dvConstraintInteger = (XSSFDataValidationConstraint) dvHelper.createIntegerConstraint(OperatorType.GREATER_THAN, "0", null);
				// Need change after modify
				CellRangeAddressList addressList = new org.apache.poi.hssf.util.CellRangeAddressList(1, pList.size() + 1, 5, 27);
				CellRangeAddressList addressList1 = new org.apache.poi.hssf.util.CellRangeAddressList(1, pList.size() + 1, 0, 0);
				CellRangeAddressList addressList2 = new org.apache.poi.hssf.util.CellRangeAddressList(1, pList.size() + 1, 2, 2);
				XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
				XSSFDataValidation validation1 = (XSSFDataValidation) dvHelper.createValidation(dvConstraintInteger, addressList1);
				XSSFDataValidation validation2 = (XSSFDataValidation) dvHelper.createValidation(dvConstraintInteger, addressList2);
				validation.setShowErrorBox(true);
				validation1.setShowErrorBox(true);
				validation2.setShowErrorBox(true);
				sheet.addValidationData(validation);
				sheet.addValidationData(validation1);
				sheet.addValidationData(validation2);
				
				sheet.protectSheet("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * 下面的可以不用编写，直接拷贝
		 */
		HttpServletResponse response = null;// 创建一个HttpServletResponse对象
		OutputStream out = null;// 创建一个输出流对象
		try {
			response = ServletActionContext.getResponse();// 初始化HttpServletResponse对象
			out = response.getOutputStream();//

			Date date = new Date();
			
			response.setHeader(
					"Content-disposition",
					"attachment; filename=Payroll"
							+ sdf.format(date) + ".xlsx");// filename是下载的xls的名，建议最好用英文
			response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
			response.setHeader("Pragma", "No-cache");// 设置头
			response.setHeader("Cache-Control", "no-cache");// 设置头
			response.setDateHeader("Expires", 0);// 设置日期头
			workbook.write(out);
			out.flush();
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (out != null) {
					out.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
