package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.NationalKey;
import com.hrms.pages.LoginPageElements;
import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

public class AddedNationality {

	public class LoginTest {

		NationalKey nationInfo = new NationalKey();
		LoginPageElements loginPageObj = new LoginPageElements();

		@BeforeMethod(alwaysRun = true)
		public void beforeMyMethod() throws InterruptedException {

			Driver.getDriver().get(ConfigsReader.getProperty("url"));
			Driver.getDriver().manage().window().maximize();
			Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);

		}

		@Test(description = "Nationality added.")
		public void addCountry() throws InterruptedException {

			loginPageObj.username.sendKeys(ConfigsReader.getProperty("validUser"));
			loginPageObj.password.sendKeys(ConfigsReader.getProperty("validPass"));
			loginPageObj.loginBtn.click();
			Thread.sleep(3000);

			nationInfo.adminButt.click();

			nationInfo.nationButt.click();

			for (WebElement nList : nationInfo.nationList) {
				System.out.println(nList.getText());
				

//				if (nList.getText().equalsIgnoreCase(ConfigsReader.getProperty("nation"))) {
//					System.out.println("It is already exist.");
//					
//					Driver.getDriver().close();
//				} else {
//					nationInfo.addButt.click();
//					Thread.sleep(3000);
//					nationInfo.boxName.sendKeys(ConfigsReader.getProperty("nation"));
//					nationInfo.saveButt.click();
//				}

			}

		}
	}

	@AfterMethod (alwaysRun = true)
	public void closeMethod () {
		Driver.getDriver().close();
	}
	
} // end class
