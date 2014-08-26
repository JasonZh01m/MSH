package com.moravia.hs.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Payrollrecord;

@Controller("readExcelAndUpdatePayrollAction")
public class ReadExcelAndUpdatePayrollAction extends BaseAction {

	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		 String path = ServletActionContext.getServletContext().getRealPath("/upload/");
		
		 File pFile = new File(path);
		 File[] files = pFile.listFiles();
		 if(files.length == 0) {
			 // System.out.println("Uploaded directory is empty...");
			 return INPUT;
		 }
		 
		 XSSFWorkbook wb = null;
		 XSSFSheet sheet = null;
		 FileInputStream is = null;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		 for (File file : files) {
			if(file.getName().endsWith(".xlsx")) {
				// System.out.println("reading..." + file.getName());
				is = new FileInputStream(file);
		          
				wb = new XSSFWorkbook(is);
				sheet = wb.getSheetAt(0);
				XSSFRow row0 = sheet.getRow(0);
				
				Payrollrecord pr = null;
				
				if (getCellValue(row0.getCell(0)).equals("PID")
						&& getCellValue(row0.getCell(1)).equals(
								"Emp_empLoginID")
						&& getCellValue(row0.getCell(2)).equals("Month")
						&& getCellValue(row0.getCell(31)).equals("PayrollNote")
						&& getCellValue(row0.getCell(32)).equals("Create_Date")) {
					// System.out.println("That's the file");

					int i = 1;
					XSSFCell cell = null; 
					String value = "";
					while (true) {
						XSSFRow row = sheet.getRow(i);
						if(row == null ) {
							// System.out.println("row == null, break;");
							break;
						}
						if((cell = row.getCell(0)) != null) {
							cell = row.getCell(0);
							value = getCellValue(cell);
							if(value.endsWith(".0")) {
								// System.out.println("End with .0");
								value = value.substring(0, value.length() - 2);
								pr = payrollrecordDAO.findById(Integer.parseInt(value));
							} else {
								// System.out.println("Not end with .0");
								pr = payrollrecordDAO.findById(Integer.parseInt(value));
							}
							
						} else if((cell = row.getCell(0)) == null) {
							return INPUT;
						}
						
						if((cell = row.getCell(1)) != null) {
							value = getCellValue(cell);
							pr.setEmpEmpLoginId(value);
						}
						if((cell = row.getCell(2)) != null) {
							value = getCellValue(cell);
							if(value.endsWith(".0")) {
								// System.out.println("End with .0");
								value = value.substring(0, value.length() - 2);
								pr.setMonth(Integer.parseInt(value));
							} else {
								// System.out.println("Not end with .0");
								pr.setMonth(Integer.parseInt(value));
							}
						}
						if((cell = row.getCell(3)) != null) {
							value = getCellValue(cell);
							pr.setStartDate(sdf.parse(value));
						}
						if((cell = row.getCell(4)) != null) {
							value = getCellValue(cell);
							pr.setEndDate(sdf.parse(value));
						}
						//base salary
						if((cell = row.getCell(5)) != null) {
							value = getCellValue(cell);
							pr.setBaseSalary(Double.parseDouble(value));
						}
						//Quart Bonus
						if((cell = row.getCell(6)) != null) {
							value = getCellValue(cell);
							pr.setQuartBonus(Double.parseDouble(value));
						}
						//Post Allowance
						if((cell = row.getCell(7)) != null) {
							value = getCellValue(cell);
							pr.setPostAllowance(Double.parseDouble(value));
						}
						//Transport Allowance
						if((cell = row.getCell(8)) != null) {
							value = getCellValue(cell);
							pr.setTransportAllowance(Double.parseDouble(value));
						}
						//Bonus
						if((cell = row.getCell(9)) != null) {
							value = getCellValue(cell);
							pr.setBonus(Double.parseDouble(value));
						}
						//Meal Subsidy
						if((cell = row.getCell(10)) != null) {
							value = getCellValue(cell);
							pr.setMealSubsidy(Double.parseDouble(value));
						}
						//Meal Subsidy
						if((cell = row.getCell(10)) != null) {
							value = getCellValue(cell);
							pr.setMealSubsidy(Double.parseDouble(value));
						}
						//Total Time Sheet Hrs
						if((cell = row.getCell(11)) != null) {
							value = getCellValue(cell);
							pr.setTotalTimeSheetHrs(Double.parseDouble(value));
						}
						//Total Work Hrs
						if((cell = row.getCell(12)) != null) {
							value = getCellValue(cell);
							pr.setTotalWorkHrs(Double.parseDouble(value));
						}
						//Overtime
						if((cell = row.getCell(13)) != null) {
							value = getCellValue(cell);
							pr.setOvertime(Double.parseDouble(value));
						}
						//OvertimePay
						if((cell = row.getCell(14)) != null) {
							value = getCellValue(cell);
							pr.setOvertimePay(Double.parseDouble(value));
						}
						//Pension Personal
						if((cell = row.getCell(15)) != null) {
							value = getCellValue(cell);
							pr.setPensionPersonal(Double.parseDouble(value));
						}
						//Pension Company
						if((cell = row.getCell(16)) != null) {
							value = getCellValue(cell);
							pr.setPensionCompany(Double.parseDouble(value));
						}
						//Medical Personal
						if((cell = row.getCell(17)) != null) {
							value = getCellValue(cell);
							pr.setMedicalPersonal(Double.parseDouble(value));
						}
						//Medical Company
						if((cell = row.getCell(18)) != null) {
							value = getCellValue(cell);
							pr.setMedicalCompany(Double.parseDouble(value));
						}
						//AccumFundPersonal
						if((cell = row.getCell(19)) != null) {
							value = getCellValue(cell);
							pr.setAccumFundPersonal(Double.parseDouble(value));
						}
						//AccumFund Company
						if((cell = row.getCell(20)) != null) {
							value = getCellValue(cell);
							pr.setAccumFundCompany(Double.parseDouble(value));
						}
						//UnempInsu Personal
						if((cell = row.getCell(21)) != null) {
							value = getCellValue(cell);
							pr.setUnempInsuPersonal(Double.parseDouble(value));
						}
						//UnempInsu Company
						if((cell = row.getCell(22)) != null) {
							value = getCellValue(cell);
							pr.setUnempInsuCompany(Double.parseDouble(value));
						}
						//Income Tax
						if((cell = row.getCell(23)) != null) {
							value = getCellValue(cell);
							pr.setIncomeTax(Double.parseDouble(value));
						}
						//Occup Injure Maternity
						if((cell = row.getCell(24)) != null) {
							value = getCellValue(cell);
							pr.setOccupInjureMaternity(Double.parseDouble(value));
						}
						//MBO monthly portion
						if((cell = row.getCell(25)) != null) {
							value = getCellValue(cell);
							pr.setMboMonthlyPortion(Double.parseDouble(value));
						}
						//Annual bonus monthly portion
						if((cell = row.getCell(26)) != null) {
							value = getCellValue(cell);
							pr.setAnnualBonusMonthlyPortion(Double.parseDouble(value));
						}
						//Other Pay
						if((cell = row.getCell(27)) != null) {
							value = getCellValue(cell);
							pr.setOtherPay(Double.parseDouble(value));
						}
						//Department Name
						if((cell = row.getCell(28)) != null) {
							value = getCellValue(cell);
							pr.setDepartmentName(value);
						}
						//Cost Center Name
						if((cell = row.getCell(29)) != null) {
							value = getCellValue(cell);
							pr.setCostCenterName(value);
						}
						//Pay date
						if((cell = row.getCell(30)) != null) {
							value = getCellValue(cell);
							if(value.trim().length() > 0) {
								pr.setPayDate(sdf.parse(value));
							} else {
								// System.out.println("Pay date is null...");
								pr.setPayDate(null);
							}
						}
						//Payroll Note
						if((cell = row.getCell(31)) != null) {
							value = getCellValue(cell);
							pr.setPayrollNote(value);
						}
						//Create Date
						if((cell = row.getCell(32)) != null) {
							value = getCellValue(cell);
							pr.setCreateDate(new Timestamp(sdftime.parse(value).getTime()));
						}
						
						payrollrecordDAO.saveOrUpdate(pr);
						
						i++;
						// System.out.println("This is row : " + (i - 1));
					}

					// FileOutputStream os = new
					// FileOutputStream("d:\\test.xlsx");
					// cell.setCellValue("OK");
					// wb.write( os);
					break;
				}
			}
		}
		
		 is.close();
		 
		 for (File f : files) {
			f.delete();
		 }
		 System.gc();
		
		return SUCCESS;
	}
	
	public String getCellValue(XSSFCell cell) {
        if (cell != null) {
              switch (cell.getCellType()) {
              case XSSFCell.CELL_TYPE_STRING: // 字符串
                    return (cell.getStringCellValue()).trim();
              case XSSFCell.CELL_TYPE_NUMERIC: // 字符串
                  return cell.getNumericCellValue() + "";
              case XSSFCell.CELL_TYPE_BLANK:
                    return "";
             }
       }
        return "";
	}

	

}
