package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;


public class OrangeHRM_LoginTests {

	//WebDriver driver;
	@BeforeMethod (alwaysRun = true)
	
	public void beforeMyMethod () throws InterruptedException {
		
		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		
	}
	
//	@Test (priority = 8, groups = {"loginTest"} ,description = "Log in with both valid username/password", enabled =false)
//	//(priority = 0, groups = {"loginTest"}, description = "Log in with both valid username/password") 
//	public void validLogin () throws InterruptedException {
//		
//		  Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("validUser"));
//		  Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("validPass"));
//		  Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		  Thread.sleep(3000);
//		  
//		  String landingPage = Driver.getDriver().findElement(By.xpath(ConfigsReader.getProperty("dashPage"))).getText();
//		  String expected = "Dashboard";
//		  Thread.sleep(2000);
//		  Assert.assertEquals(expected, landingPage);
//
//	}	
	
	@Test (priority = 3)//, groups = {"loginTest"},description = "#3 Log in with a valid username, but invalid password")
	public void validUserinvalidPass () throws InterruptedException {
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("validUser"));
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("invalidPass"));
		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
		  Thread.sleep(3000);
		  
		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
		  String expectedErr = "Invalid credentials";
		  Assert.assertEquals(expectedErr, invalidErr);
	}
	
	@Test (priority = 4)// groups = {"loginTest"},description = "#4 Log in with an invalid username, but valid password")
	public void invalidUservalidPass () throws InterruptedException {
		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("invalidUser"));
		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("validPass"));
		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
		  Thread.sleep(3000);
		  
		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
		  String expectedErr = "Invalid credentials";
		  Assert.assertEquals(expectedErr, invalidErr);
	}
//	
//	@Test (priority = 5, groups = {"loginTest"}, description = "#5 Log in with both invalid username/password")
//	//(priority = 3, groups = {"loginTest"})
//	public void invalidUserInvalidPass () throws InterruptedException {
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("invalidUser"));
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("invalidPass"));
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		  Thread.sleep(3000);
//		  
//		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
//		  String expectedErr = "Invalid credentials";
//		  Assert.assertEquals(expectedErr, invalidErr);
//	}
//	
//	@Test (priority = 6, groups = {"loginTest"}, description = "#6 Log in with a blank  username but valid password")
//	public void blankUserValidPass () throws InterruptedException {
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("blankUser"));
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("validPass"));
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		  Thread.sleep(3000);
//		  
//		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
//		  String expectedErr = "Username cannot be empty";
//		  Assert.assertEquals(expectedErr, invalidErr);
//	}
//	
//	@Test (priority = 0, groups = {"loginTest"}, description = "#7 Log in with a valid username, but blank password")
//	public void validUserBlankPass () throws InterruptedException {
//		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("validUser"));
//		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("blankPass"));
//		Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		Thread.sleep(3000);
//		  
//		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
//		  String expectedErr = "Password cannot be empty";
//		  Assert.assertEquals(expectedErr, invalidErr);
//	}
	
//	@Test 
//	public void OpenBrowser() {
//		 Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
//		         Reporter.log("Testing the report log");
//		         Reporter.log("You will get a 100K job!!! bro");
//		  }
	
	
	@AfterMethod (alwaysRun = true)
	public void closeMethod () {
		Driver.getDriver().close();
	}
} //end class
