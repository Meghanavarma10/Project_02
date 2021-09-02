package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fileLOc;
	public static XSSFWorkbook wBook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xFile , String XSheet) throws IOException{
		fileLOc = new FileInputStream(xFile);
		wBook = new XSSFWorkbook(fileLOc);
		wSheet = wBook.getSheet(XSheet);
	
		int rowCount = wSheet.getLastRowNum();
		 wBook.close();
		 fileLOc.close();
		 
		 return rowCount;
	}
	
	public static int getCellCount(String xFile,String xSheet, int rowNum) throws IOException{
		fileLOc = new FileInputStream(xFile);
		wBook = new XSSFWorkbook(fileLOc);
		wSheet = wBook.getSheet(xSheet);
		
		row = wSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		
		wBook.close();
		fileLOc.close();
		
		return cellCount;
		
	}
	public static String getCellData(String xFile,String xSheet, int rowNum,int colnum) throws IOException{
		fileLOc = new FileInputStream(xFile);
		wBook = new XSSFWorkbook(fileLOc);
		wSheet = wBook.getSheet(xSheet);
		
		row = wSheet.getRow(rowNum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		
		wBook.close();
		fileLOc.close();
		
		return cellData;
}

}
