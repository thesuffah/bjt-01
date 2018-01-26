package com.bitguiders.util.io.xl;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
/**
 * @author Abdul Kareem
 */
public class ExcelSHandler extends ExcelHandler {
	
	public ExcelSHandler(String fileName) {
		super.fileName = fileName;
		workbook = new HSSFWorkbook();
		init();
	}
	@Override
	public Sheet createSheet(String sheetName) {
		 HSSFSheet  sheet=null;
	        if(null!=sheetName) {
	        sheet = (HSSFSheet) workbook.createSheet(sheetName);
	        }else {
	        	sheet = (HSSFSheet) workbook.createSheet();
	        }
	        return sheet;
	}

}
