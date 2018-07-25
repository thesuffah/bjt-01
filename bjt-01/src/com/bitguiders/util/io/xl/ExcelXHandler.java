package com.bitguiders.util.io.xl;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelXHandler extends ExcelHandler {
	
	public ExcelXHandler(String fileName) {
		super.fileName = fileName;
		workbook = new XSSFWorkbook();
		init();
	}
	@Override
	public Sheet createSheet(String sheetName) {
		 XSSFSheet  sheet=null;
	        if(null!=sheetName) {
	        sheet = (XSSFSheet) workbook.createSheet(sheetName);
	        }else {
	        	sheet = (XSSFSheet) workbook.createSheet();
	        }
	        return sheet;
	}
}
