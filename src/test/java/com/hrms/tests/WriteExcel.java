package com.hrms.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		
		String path = "DemoFile.xlsx";
		FileInputStream fs = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sheet1 = wb.getSheetAt(0);
		int lastRow = sheet1.getLastRowNum();
		System.out.println(lastRow);
		for (int i = 0; i <= lastRow; i++) {
			Row row = sheet1.getRow(i);
			Cell cell = row.createCell(1);
			cell.setCellValue("Hi Kanin");
		}
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();

	}

}
