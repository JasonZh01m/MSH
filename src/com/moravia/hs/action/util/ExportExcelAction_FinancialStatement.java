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

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.BaseAction;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;

@Controller("exportExcelAction_FinancialStatement")
public class ExportExcelAction_FinancialStatement extends BaseAction {
	
	
	public String export() throws Exception {
		
		Map<String, Object> session = getSession();
//		List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list =null;
		
		List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list = (List<FinancialStatement_ByDepartOrCostCenter>) session.get("fsdoc_list");

		if(fsdoc_list != null) {
			System.out.println("fsdoc_list.size() : " + fsdoc_list.size());
		} else {
			System.out.println("fsdoc_list is null");
			return null;
		}
		
		/*设置表头：对Excel每列取名
          *(必须根据你取的数据编写)
          */
		String[] tableHeader={"ID", "Name", "Bonus","Month Base Salary","Adjustment","Quar Bonus","Overtime Pay","Meal Subsidy","Commuting Allowance","Salary in Payroll","Net Salary","Medical Insurance(Personal)","Medical Insurance(Company)","Social Insurance(Personal)","Social Insurance(Company)","Tax","Housing Fund(Personal)","Housing Fund(Company)","Payroll Total","MBO Monthly Portion","Annual Bonus Monthly Portion","Total"};
		/*
         *下面的都可以拷贝不用编写
         */
		short cellNumber=(short)tableHeader.length;//表的列数
		XSSFWorkbook workbook = new XSSFWorkbook();	//创建一个excel
		XSSFCell cell = null;									//Excel的列
		XSSFRow row = null;										//Excel的行
		XSSFCellStyle style = workbook.createCellStyle();		//设置表头的类型
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		XSSFCellStyle style1 = workbook.createCellStyle();		//设置数据类型
		style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		XSSFFont font = workbook.createFont();					//设置字体
		XSSFSheet sheet = workbook.createSheet("sheet1");		//创建一个sheet
		Header header = sheet.getHeader();//设置sheet的头
		try {             
			/**
             *根据是否取出数据，设置header信息
             *
             */
			if(fsdoc_list.size() < 1 ){
				header.setCenter("NO DATA!");
			}else{
				header.setCenter("Financial Statement");
				row = sheet.createRow(0);
				row.setHeight((short)400);
				for(int k = 0;k < cellNumber;k++){	
					cell = row.createCell(k);//创建第0行第k列
					cell.setCellValue(tableHeader[k]);//设置第0行第k列的值
					sheet.setColumnWidth(k,6000);//设置列的宽度
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色. 
					font.setFontHeight((short)300); //设置单元字体高度
					style1.setFont(font);//设置字体风格
					style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(style1);
				}
				
				for(int i = 0; i <= 21; i ++) {
					sheet.autoSizeColumn(i);
				}
                
				for(int i = 0; i < fsdoc_list.size(); i++) {
					FinancialStatement_ByDepartOrCostCenter fsdoc = fsdoc_list.get(i);
					row = sheet.createRow((short) (i + 1));//创建第i+1行
				    row.setHeight((short)400);//设置行高
				
		    		cell = row.createCell(0);//创建第i+1行第0列
		    		cell.setCellValue(i + 1);//设置第i+1行第0列的值
		    		cell.setCellStyle(style);//设置风格
		    		
		    		if(fsdoc.getSection_name() != null){
			    		cell = row.createCell(1);
			    		cell.setCellValue(fsdoc.getSection_name());
			    		cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getBonus() != null){
		    			cell = row.createCell(2);
		    			cell.setCellValue(fsdoc.getBonus());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getMonthlyBaseSalary() != null){
		    			cell = row.createCell(3);
		    			cell.setCellValue(fsdoc.getMonthlyBaseSalary());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getAdjustment() != null){
		    			cell = row.createCell(4);
		    			cell.setCellValue(fsdoc.getAdjustment());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getQuartBonus() != null){
		    			cell = row.createCell(5);
		    			cell.setCellValue(fsdoc.getQuartBonus());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getOvertimePay() != null){
		    			cell = row.createCell(6);
		    			cell.setCellValue(fsdoc.getOvertimePay());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getMealSubsidy() != null){
		    			cell = row.createCell(7);
		    			cell.setCellValue(fsdoc.getMealSubsidy());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getTransAllowance() != null){
		    			cell = row.createCell(8);
		    			cell.setCellValue(fsdoc.getTransAllowance());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getSalaryInPayroll() != null){
		    			cell = row.createCell(9);
		    			cell.setCellValue(fsdoc.getSalaryInPayroll());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getNetSalary() != null){
		    			cell = row.createCell(10);
		    			cell.setCellValue(fsdoc.getNetSalary());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getMedicalPersonal() != null){
		    			cell = row.createCell(11);
		    			cell.setCellValue(fsdoc.getMedicalPersonal());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getMedicalCompany() != null){
		    			cell = row.createCell(12);
		    			cell.setCellValue(fsdoc.getMedicalCompany());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getSocialInsPersonal() != null){
		    			cell = row.createCell(13);
		    			cell.setCellValue(fsdoc.getSocialInsPersonal());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getSocialInsCompany() != null){
		    			cell = row.createCell(14);
		    			cell.setCellValue(fsdoc.getSocialInsCompany());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getTax() != null){
		    			cell = row.createCell(15);
		    			cell.setCellValue(fsdoc.getTax());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getHousingFundPersonal() != null){
		    			cell = row.createCell(16);
		    			cell.setCellValue(fsdoc.getHousingFundPersonal());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getHousingFundCompany() != null){
		    			cell = row.createCell(17);
		    			cell.setCellValue(fsdoc.getHousingFundCompany());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getPayrollTotal() != null){
		    			cell = row.createCell(18);
		    			cell.setCellValue(fsdoc.getPayrollTotal());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getMboMonthlyPortion() != null){
		    			cell = row.createCell(19);
		    			cell.setCellValue(fsdoc.getMboMonthlyPortion());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getAnnualBonusMonthlyPortion() != null){
		    			cell = row.createCell(20);
		    			cell.setCellValue(fsdoc.getAnnualBonusMonthlyPortion());
		    			cell.setCellStyle(style);
		    		}
		    		if(fsdoc.getTotal() != null){
		    			cell = row.createCell(21);
		    			cell.setCellValue(fsdoc.getTotal());
		    			cell.setCellStyle(style);
		    		}
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
  /*
   *下面的可以不用编写，直接拷贝
   *
   */
		HttpServletResponse response = null;//创建一个HttpServletResponse对象
		OutputStream out = null;//创建一个输出流对象
		try {
			response = ServletActionContext.getResponse();//初始化HttpServletResponse对象
			out = response.getOutputStream();
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
	        response.setHeader("Content-disposition","attachment; filename=FinancialStatement" + sdf.format(date) + ".xlsx");//filename是下载的xls的名，建议最好用英文
	        response.setContentType("application/msexcel;charset=UTF-8");//设置类型
	        response.setHeader("Pragma","No-cache");//设置头
	        response.setHeader("Cache-Control","no-cache");//设置头
	        response.setDateHeader("Expires", 0);//设置日期头
	        workbook.write(out);
	        out.flush();
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				
				if(out!=null){
					out.close();
				}
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
