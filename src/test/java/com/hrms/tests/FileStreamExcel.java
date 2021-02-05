package com.hrms.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileStreamExcel {

	public static void main(String[] args) throws IOException {
		 DataFormatter objDefaultFormat = new DataFormatter();
		 
		//Path of the excel file // connection to excel
		FileInputStream fs = new FileInputStream("Book1.xlsx");
		//Creating a workbook
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		//name of the sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		
//		Row row3 = sheet.getRow(1);
//		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		
//		String cellval = cell.getStringCellValue();
//		System.out.println(cellval);
		
		 for (Row row: sheet) {
	            for(Cell cell: row) {
	                String cellValue = objDefaultFormat.formatCellValue(cell);
	                System.out.print(cellValue + "\t");
	            }
	            System.out.println();
	        }

	}

}
