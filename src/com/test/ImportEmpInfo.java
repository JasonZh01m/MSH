package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ImportEmpInfo {

	public static void main(String[] args) throws IOException {
		
		String path = "D:\\Finance&HRSystem\\List_v2.xlsx";
		File file = new File(path);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		XSSFRow row = null;
		XSSFCell cell = null;
		
		System.out.println(getCellValue(cell));
		
		for(int i = 1; i <= 129; i++) {
			
			
			
			
		}
		
		
	}
	
	
	public static String getCellValue(XSSFCell cell) {
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
