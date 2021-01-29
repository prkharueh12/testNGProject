package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHRM_LoginTests {

	WebDriver driver;
	@BeforeTest
	public void beforeMyMethod () {
		
		//Driver.getDriver().get(ConfigsReader.getProperty("url"));
		WebDriverManager.chromedriver().setup();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.get(ConfigsReader.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		
		
	}
//	
//	@Test (priority = 0, groups = {"loginTest"}, description = "Log in with both valid username/password") 
//	public void validLogin () throws InterruptedException {
//		
//		
//		
//		  driver.findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("validUser"));
//		  driver.findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("validPass"));
//		  driver.findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		  Thread.sleep(3000);
//		  
//		  String landingPage = Driver.getDriver().findElement(By.xpath(ConfigsReader.getProperty("dashPage"))).getText();
//		  String expected = "Dashboard";
//		  Assert.assertEquals(expected, landingPage);
//	}
//	
//	
//	
//	@Test (priority = 1, groups = {"loginTest"})
//	public void validUserinvalidPass () throws InterruptedException {
//		 driver.findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("validUser"));
//		 driver.findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("invalidPass"));
//		 driver.findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		  Thread.sleep(3000);
//		  
//		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
//		  String expectedErr = "Invalid credentials";
//		  Assert.assertEquals(expectedErr, invalidErr);
//	}
//	
//	@Test (priority = 2, groups = {"loginTest"})
//	public void invalidUservalidPass () throws InterruptedException {
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("userBoxID"))).sendKeys(ConfigsReader.getProperty("invalidUser"));
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("passBoxID"))).sendKeys(ConfigsReader.getProperty("validPass"));
//		 Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("loginButt"))).click();
//		  Thread.sleep(3000);
//		  
//		  String invalidErr = Driver.getDriver().findElement(By.id(ConfigsReader.getProperty("invalidMSGID"))).getText();
//		  String expectedErr = "Invalid credentials";
//		  Assert.assertEquals(expectedErr, invalidErr);
//	}
//	
//	@Test (priority = 3, groups = {"loginTest"})
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
//	@Test (priority = 4, groups = {"loginTest"})
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
//	@Test (priority = 5, groups = {"loginTest"})
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
	
	
	@AfterMethod
	public void closeMethod () {
		driver.close();
	}
} //end class
