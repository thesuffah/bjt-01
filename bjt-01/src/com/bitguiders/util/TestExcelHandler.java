package com.bitguiders.util.io.xl;

import java.util.ArrayList;
import java.util.List;

public class TestExcelHandler {
public static void main(String arg[]) {
		
		Object[] metaData = {"Datatype", "Type", "Size(in bytes)"};
		List<Object[]> data = new ArrayList<Object[]>();
		    Object row1[] = {"int", "Primitive", 2};
		    Object row2[] = {"double", "Primitive", 8};
		    Object row3[] = {"char", "Primitive", 1};
		    Object row4[] = {"String", "Non-Primitive", "No fixed size"};
			data.add(row1);
			data.add(row2);
			data.add(row3);
			data.add(row4);
			
			//ExcelXHandler handler = new ExcelXHandler("defaultExcelName.xlsx");
			ExcelSHandler handler = new ExcelSHandler("defaultExcelName.xls");
			
			handler.createSheet("testSheet1","Sheet Ttile", metaData, data);
			handler.createSheet("testSheet2","Sheet Title 2", metaData, data);
			handler.export();
	}
}
