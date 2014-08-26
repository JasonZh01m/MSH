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
import com.moravia.hs.base.entity.Timesheet;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;

@Controller("exportExcelAction_TimeSheetTrack")
public class ExportExcelAction_TimeSheetTrack extends BaseAction {
	
	
	public String export() throws Exception {
		
		Map<String, Object> session = getSession();
//		List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list =null;
		
		List<Timesheet> tsList = (List<Timesheet>) session.get("tstp_tsList");
		String empLoginId = "";
		
		if(tsList != null) {
			System.out.println("tsList.size() : " + tsList.size());
		} else {
			System.out.println("tsList is null");
			return null;
		}
		
		if(session.get("tstp_empLoginId") == null) {
			return null;
		} else {
			empLoginId = (String) session.get("tstp_empLoginId");
		}
		
		/*设置表头：对Excel每列取名
          *(必须根据你取的数据编写)
          */
		String[] tableHeader={"ID", "LoginName", "Date", "Start", "Stop", "DiffTime", "OrderID", "Project_Name", "PM_Name", "Language", "Type", "Activity_Group", "Invoicing_Indicator", "Role", "Position", "Tool", "Task", "Custom", "Note"};
		/*
         *下面的都可以拷贝不用编写
         */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		
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
			if(tsList.size() < 1 ){
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
                
				for(int i = 0; i < tsList.size(); i++) {
					Timesheet ts = tsList.get(i);
					row = sheet.createRow((short) (i + 1));//创建第i+1行
				    row.setHeight((short)400);//设置行高
				
		    		cell = row.createCell(0);//创建第i+1行第0列
		    		cell.setCellValue(i + 1);//设置第i+1行第0列的值
		    		cell.setCellStyle(style);//设置风格
		    		
		    		if(ts.getLoginName() != null){
			    		cell = row.createCell(1);
			    		cell.setCellValue(ts.getLoginName());
			    		cell.setCellStyle(style);
		    		}
		    		if(ts.getDate() != null){
		    			cell = row.createCell(2);
		    			cell.setCellValue(sdf.format(ts.getDate()));
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getStart() != null){
		    			cell = row.createCell(3);
		    			cell.setCellValue(sdf2.format(ts.getStart()));
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getStop() != null){
		    			cell = row.createCell(4);
		    			cell.setCellValue(sdf2.format(ts.getStop()));
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getDiffTime() != null){
		    			cell = row.createCell(5);
		    			cell.setCellValue(ts.getDiffTime());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getOrderId() != null){
		    			cell = row.createCell(6);
		    			cell.setCellValue(ts.getOrderId());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getProjectName() != null){
		    			cell = row.createCell(7);
		    			cell.setCellValue(ts.getProjectName());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getPmName() != null){
		    			cell = row.createCell(8);
		    			cell.setCellValue(ts.getPmName());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getLanguage() != null){
		    			cell = row.createCell(9);
		    			cell.setCellValue(ts.getLanguage());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getType() != null){
		    			cell = row.createCell(10);
		    			cell.setCellValue(ts.getType());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getActivityGroup() != null){
		    			cell = row.createCell(11);
		    			cell.setCellValue(ts.getActivityGroup());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getInvoicingIndicator() != null){
		    			cell = row.createCell(12);
		    			cell.setCellValue(ts.getInvoicingIndicator());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getRole() != null){
		    			cell = row.createCell(13);
		    			cell.setCellValue(ts.getRole());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getPosition() != null){
		    			cell = row.createCell(14);
		    			cell.setCellValue(ts.getPosition());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getTool() != null){
		    			cell = row.createCell(15);
		    			cell.setCellValue(ts.getTool());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getTask() != null){
		    			cell = row.createCell(16);
		    			cell.setCellValue(ts.getTask());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getCustom() != null){
		    			cell = row.createCell(17);
		    			cell.setCellValue(ts.getCustom());
		    			cell.setCellStyle(style);
		    		}
		    		if(ts.getNote() != null){
		    			cell = row.createCell(18);
		    			cell.setCellValue(ts.getNote());
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
			out = response.getOutputStream();//
			
			Date date = new Date();
			
	        response.setHeader("Content-disposition","attachment; filename=TimeSheetTrack" + sdf.format(date) + "_" + empLoginId + ".xlsx");//filename是下载的xls的名，建议最好用英文
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
