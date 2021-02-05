package com.hrms.hwtasks;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.EtsyKey;
import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

public class RegisterEmailEtsy {
	EtsyKey etsyInfo = new EtsyKey();
	
	@BeforeMethod (alwaysRun = true)
	public void beforeMyMethod () throws InterruptedException {
		
		Driver.getDriver().get(ConfigsReader.getProperty("url3"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
	}
	
	@Test (description = "Login Email")
	public  void verifyEmail () throws InterruptedException  {
		
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
		}
		
		Thread.sleep(9000);
		Driver.getDriver().switchTo().window(parentWin);
		//myEle=(WebDriverWait(Driver.getDriver(), 20).until(EC.visibility_of_element_located((By.XPATH, "//input[@id='active-mail']"))).get_attribute("data-clipboard-text"));
		
		String myMail = etsyInfo.randomMailBox.getText();
				//getAttribute("readonly aria-describedby");
		System.out.println(myMail);
		
//		etsyInfo.signInButt.click();
//		etsyInfo.emailBox.sendKeys("email");
//		etsyInfo.passBox.sendKeys("passW");
//		etsyInfo.submitButt.click();
		
		
	}
}//end class
