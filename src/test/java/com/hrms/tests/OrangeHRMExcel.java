package com.hrms.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.ExcelKey;
import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

import junit.framework.Assert;

public class OrangeHRMExcel {
	ExcelKey Ohrm = new ExcelKey() ;
	
	@BeforeMethod (alwaysRun = true)
	public void beforeMyMethod () throws InterruptedException {
		
		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
	}
	
	@Test (description = "Import for excel")
	public  void getNameExcel () throws InterruptedException, IOException  {
		FileInputStream fs = new FileInputStream("Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		Cell admin =sheet.getRow(1).getCell(0);
		String orderID1=admin.toString();
		
		Cell pass =sheet.getRow(1).getCell(1);
		String orderID2=pass.toString();
		
		Cell fName =sheet.getRow(1).getCell(2);
		String orderID3=fName.toString();
		
		Cell lName =sheet.getRow(1).getCell(3);
		String orderID4=lName.toString();
		
		Ohrm.userButt.sendKeys(orderID1);
		Ohrm.passButt.sendKeys(orderID2);
		Ohrm.loginButt.click();
		Ohrm.pimButt.click();
		Thread.sleep(2000);
		Ohrm.addButt.click();
		
		Ohrm.inputF.sendKeys(orderID3);
		Ohrm.inputL.sendKeys(orderID4);
		Thread.sleep(2000);
		
		Ohrm.saveButt.click();
		
		String actual= "John Nelson";
		Assert.assertEquals(Ohrm.verify.getText(), actual);
		System.out.println(Ohrm.verify.getText());
	}
	
	@AfterTest 
	public  void closeIt () throws InterruptedException {
		Thread.sleep(2000);
		Driver.getDriver().close();
	}
}
