package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElement;
import com.hrms.pages.LoginPageElements;
import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

public class LoginTest {

	LoginPageElements loginPageObj = new LoginPageElements ();
	DashboardPageElement dashboadPage = new DashboardPageElement();
	
	@BeforeMethod (alwaysRun = true)
	public void beforeMyMethod () throws InterruptedException {
		
		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
	}
	
	@Test (description = "Login Successfully")
	public  void loginFun ()  { 
		loginPageObj.username.sendKeys(ConfigsReader.getProperty("validUser"));
		loginPageObj.password.sendKeys(ConfigsReader.getProperty("validPass"));
		loginPageObj.loginBtn.click();
		
		String expectText = dashboadPage.subtxt.getAttribute("value");
		String actualText = "Subscribe";
		System.out.println(expectText);
		
		Assert.assertEquals(expectText, actualText);
		
		
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void closeMethod () {
		Driver.getDriver().close();
	}
	
	
} //end class
