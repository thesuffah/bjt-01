package com.bitguiders.util.io.xl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.bankofamerica.risk.fc.coverage.util.ApplicationUtil;

/**
 * @author Abdul Kareem
 */
public abstract class ExcelHandler {
		protected String fileName = "defaultExcelName.xlsx";

		protected Workbook workbook= null;
		private CellStyle evenCellStyle = null;
		private CellStyle oddCellStyle = null;
		private CellStyle titleCellStyle = null;
		private CellStyle headerCellStyle = null;
		
		private Font font = null;
		private Font titleFont = null;
		private Font headerFont = null;
		
		private int totalColumns=0;
         
		public abstract Sheet createSheet(String sheetName);
		
		public void createSheet(String sheetName,Object[] metaData,List<Object[]> data) {
			createSheet(sheetName,null,metaData,data);
		}
		public void createSheet(Object[] metaData,List<Object[]> data) {
			createSheet(null,null,metaData,data);
		}
		public void createSheet(List<Object[]> data) {
			createSheet(null,null,null,data);
		}
		public void createSheet(String sheetName,String sheetTitle,Object[] metaData,List<Object[]> data) {
	        int rowNumber=0;
	        totalColumns = metaData.length-1;
	 		
			//Step 1: create sheet
	        Sheet  sheet= createSheet(sheetName);
	       
	        //Step 2: create sheet title
			if(null!=sheetTitle)
			createSheetTitle(sheet,sheetTitle,rowNumber++);
	        
	        //Step 3: create sheet meta data
			if(null!=metaData)
	        createRow(sheet,rowNumber++,metaData,true);
	        
	        //Step 4: create data rows
	        for(Object[] row:data) {
	        	 createRow(sheet,rowNumber++,row,false);
	        }
	        
	        //Setp 4: resize columns 
	        for(int i=0;i<metaData.length;i++) {
	      	  sheet.autoSizeColumn(i);
	        }
		}
		private void createSheetTitle(Sheet sheet,String sheetTitle,int rowNumber) {
			
	        Row row = sheet.createRow(rowNumber);
	        row.setHeightInPoints(30);
	        int colNum = 0;
	        Cell cell = row.createCell(colNum++);
	        cell.setCellValue(sheetTitle);
	        cell.setCellStyle(titleCellStyle);
	        sheet.addMergedRegion(new CellRangeAddress(rowNumber,rowNumber,0,totalColumns));
		}
		private void createRow(Sheet sheet,int rowNumber,Object[] rowValues,boolean isHeader) {
			
	            Row row = sheet.createRow(rowNumber);
	            if(isHeader){ 
	             row.setHeightInPoints(25);
	              for(int i=0;i<rowValues.length;i++) {
	            	  rowValues[i] = " "+((String)rowValues[i])+" ";
	            	  sheet.autoSizeColumn(i);
	              }
	            }
	            
	            int colNum = 0;
	            for (Object columnValue : rowValues) {
	                Cell cell = row.createCell(colNum++);
	                
	                if (columnValue instanceof String) {
	                    cell.setCellValue((String) columnValue);
	                } else if (columnValue instanceof Integer) {
	                    cell.setCellValue((Integer) columnValue);
	                } else if (columnValue instanceof Long) {
	                    cell.setCellValue((Long) columnValue);
	                }else if (columnValue instanceof Double) {
	                    cell.setCellValue((Double) columnValue);
	                }
	                 setStyle(rowNumber,cell,isHeader);  
	              }
		}
		private void setStyle(int rowNumber,Cell cell, boolean isHeader) {
			if(isHeader) {
				cell.setCellStyle(headerCellStyle);
			}else {
			 if((rowNumber%2)==0) {
	         	cell.setCellStyle(evenCellStyle);
	         }else {
	         	cell.setCellStyle(oddCellStyle);
	         }
			}
		}
		protected void init() {
			short border =1;
			short normalFontSize = 10;
			short headerFontSize = 11;
			short titleFontSize  = 18;

			evenCellStyle = workbook.createCellStyle();
			oddCellStyle = workbook.createCellStyle();
			titleCellStyle = workbook.createCellStyle();
			headerCellStyle = workbook.createCellStyle();
			
			font = workbook.createFont();
			titleFont = workbook.createFont();
			headerFont = workbook.createFont();

			if(workbook.getClass()==HSSFWorkbook.class) {
			HSSFPalette palette = ((HSSFWorkbook) workbook).getCustomPalette();
			
			
			//CCM Current Gray export Color scheme 
			setGrayLaout(palette);
			
	        //CCM Original Red Color scheme for future use
	        //setRedLayout(palette,border)

			}
			
			setBorder(border,evenCellStyle);
			setBorder(border,oddCellStyle);
			
			font.setFontHeightInPoints(normalFontSize);
			font.setFontName("Arial");
			
			headerFont.setFontHeightInPoints(headerFontSize);
			headerFont.setFontName("Arial");
			//headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			
			
			titleFont.setFontHeightInPoints(titleFontSize);
			titleFont.setFontName("Arial");
			titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		    

			evenCellStyle.setFont(font);

			oddCellStyle.setFont(font);
			
			titleCellStyle.setFont(titleFont);
			titleCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			titleCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

			headerCellStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			headerCellStyle.setFont(headerFont);
			headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			headerCellStyle.setBorderTop(border);
			headerCellStyle.setBorderBottom(border);
			headerCellStyle.setBorderLeft(border);
			headerCellStyle.setBorderRight(border);

		}
		
		private void setBorder(short borderSize,CellStyle cellStyle) {
			cellStyle.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);
			cellStyle.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);
			cellStyle.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);
			cellStyle.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);
			cellStyle.setBorderTop(borderSize);
			cellStyle.setBorderBottom(borderSize);
			cellStyle.setBorderLeft(borderSize);
			cellStyle.setBorderRight(borderSize);

		}
		
		private void setGrayLaout(HSSFPalette palette) {
	        palette.setColorAtIndex(HSSFColor.GREY_25_PERCENT.index, (byte)255, (byte)255, (byte)255);
	        palette.setColorAtIndex(HSSFColor.GREY_40_PERCENT.index, (byte)128, (byte)128, (byte)128);
	        palette.setColorAtIndex(HSSFColor.GREY_50_PERCENT.index, (byte)0, (byte)0, (byte)0);
	        
	        //palette.setColorAtIndex(HSSFColor.RED.index, (byte)143, (byte)8, (byte)0);
	        headerFont.setColor(IndexedColors.WHITE.getIndex());

		}
		//CCM Original Red Color scheme for future use
		private void setRedLayout(HSSFPalette palette,short border) {
			palette.setColorAtIndex(HSSFColor.GREY_25_PERCENT.index, (byte)249, (byte)248, (byte)243);
	        palette.setColorAtIndex(HSSFColor.GREY_40_PERCENT.index, (byte)224, (byte)223, (byte)220);
	        palette.setColorAtIndex(HSSFColor.GREY_50_PERCENT.index, (byte)180, (byte)177, (byte)169);
	        palette.setColorAtIndex(HSSFColor.RED.index, (byte)143, (byte)8, (byte)0);
	        titleFont.setColor(IndexedColors.WHITE.getIndex());
			titleCellStyle.setFillForegroundColor(HSSFColor.RED.index);
			titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			headerFont.setColor(IndexedColors.BLACK.getIndex());
			evenCellStyle.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);
			evenCellStyle.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);
			evenCellStyle.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);
			evenCellStyle.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);
			evenCellStyle.setBorderTop(border);
			evenCellStyle.setBorderBottom(border);
			evenCellStyle.setBorderLeft(border);
			evenCellStyle.setBorderRight(border);
			evenCellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			evenCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			oddCellStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		}
		public void export() {
			 
		            FileOutputStream outputStream;
					try {
						outputStream = new FileOutputStream(ApplicationUtil.getTempFilePath(fileName));
						workbook.write(outputStream);
						outputStream.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
		}

}
