package com.orangehrm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutils {

	public static XSSFWorkbook book;
	public static XSSFSheet sheet;

	public static void main(String[] args) {
	getTestData("C:\\Users\\minal\\git\\repository2\\OrangeHRMtest\\TestData\\adduserdata.xlsx","addpagedetails");
		//getTestData();
		// System.out.println("data is:"+data);
	}
	public static void getTestData(String filePath, String sheetname) {
		//FileInputStream file = null;
		//String filePath ="C:\\Users\\minal\\OneDrive\\Desktop\\adduserdata.xlsx";
		/*try {
			file = new FileInputStream(filePath);x
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		try {
			book = new XSSFWorkbook(filePath);
			sheet = book.getSheet(sheetname);
			
			System.out.println(sheet.getLastRowNum() + "--------" +sheet.getRow(0).getLastCellNum());
			
			//Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			//System.out.println();
			/*for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					DataFormatter formatter = new DataFormatter();
					data[i][k]=  formatter.formatCellValue(sheet.getRow(i + 1).getCell(k));

				}
			}*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}


		

		//return data;
	}
}
