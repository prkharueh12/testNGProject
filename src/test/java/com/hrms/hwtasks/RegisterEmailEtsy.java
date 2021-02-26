package com.hrms.hwtasks;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.EtsyKey;
import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

public class RegisterEmailEtsy {
	EtsyKey etsyInfo = new EtsyKey();
	Actions act ;
	@BeforeMethod (alwaysRun = true)
	public void beforeMyMethod () throws InterruptedException {
		
		Driver.getDriver().get(ConfigsReader.getProperty("url3"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
	}
	
	@Test (description = "Login Email")
	public  void verifyEmail () throws InterruptedException  {
		/*Testing using the method in PageFactory class
		etsyInfo.signInButt.click();
		etsyInfo.enterEmail(ConfigsReader.getProperty("validUser"));
		etsyInfo.enterPass(ConfigsReader.getProperty("validPass")); */
		
	/*	
		String parentWin = Driver.getDriver().getWindowHandle();
		Driver.getDriver().get(ConfigsReader.getProperty("url4"));
		
		Set<String> handles = Driver.getDriver().getWindowHandles();
		Iterator<String>  ite = handles.iterator();
		while (ite.hasNext()) {
			String allWindow = ite.next();
			Driver.getDriver().switchTo().window(allWindow);
			//System.out.println(Driver.getDriver().getTitle());
			if (Driver.getDriver().getTitle().equals("Temp Mail - Disposable Temporary Email")) {
			}
	
		
		Driver.getDriver().switchTo().window(parentWin);
	*/	
		
		
		act = new Actions(Driver.getDriver());
		act.moveToElement(etsyInfo.randomMailBox);
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
		
		String myMail = ele.getAttribute("readonly aria-describedby");
		
		//getAttribute("readonly aria-describedby");
		System.out.println(myMail);
		Thread.sleep(9000);
		Driver.getDriver().navigate().back();
		
		
		
//		etsyInfo.signInButt.click();
//		etsyInfo.emailBox.sendKeys("email");
//		etsyInfo.passBox.sendKeys("passW");
//		etsyInfo.submitButt.click();
		
		
	}
}//end class
