package com.hrms.hwtasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.utils.ConfigsReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class verifyItemEtsy {
	WebDriver driver;
	Actions act ;
	@BeforeMethod
	public  void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url2"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test (priority = 1, description = "Add an item to card then verify")
	public  void verifyItemCart () throws InterruptedException { 
		
		driver.findElement(By.id("global-enhancements-search-query")).sendKeys(ConfigsReader.getProperty("searchKey"));
		driver.findElement(By.xpath("//div [@class= 'wt-menu wt-menu--full-width wt-menu--offset-below-trigger' ] //button [@value = 'Search']")).click();
		
		//contain all items.
		List <WebElement> searchList = new ArrayList <WebElement> (driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[3]/div[2]/div[3]/div/div[1]/div/li[*]/div/div/a")));
		
		
		
	for (WebElement list : searchList) {
		
		if (list.getAttribute("data-position-num").equals("1")) {
			
			//System.out.println(list.getAttribute("title"));
			list.click();
			//act.moveToElement(list).click().perform();
		}
	}
		
	String parentWin = driver.getWindowHandle();	
	Set<String> handles = driver.getWindowHandles();
	
	// switch to new window
	Iterator<String>  ite = handles.iterator();
	while (ite.hasNext()) {
		String allWindow = ite.next();
		driver.switchTo().window(allWindow);
		
		if (driver.getTitle().equalsIgnoreCase("Linux Quick Reference Poster Computer Programming Cheat Sheet | Etsy")) {
             driver.switchTo().window(allWindow);
		}
		
		

	}

	WebElement submitButt =	driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div/div[6]/div/form/button"));	
	submitButt.click();
	
	Thread.sleep(3000);
	String verifyItem = driver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div/div[1]/h1")).getText();
	String proceedChk = driver.findElement(By.xpath("//*[@id=\"multi-shop-cart-list\"]/div[1]/div/div/div[1]/div/div[1]/form/div[2]/div/button/span")).getText();
	String count = driver.findElement(By.xpath("//*[@id=\"multi-shop-cart-list\"]/div[1]/div/div/ul/li/ul/li/div/div[2]/div/div[2]/div/div[1]/div/div/div/select/option[1]")).getAttribute("value");
	String price = driver.findElement(By.xpath("//*[@id=\"multi-shop-cart-list\"]/div[1]/div/div/div[1]/div/div[1]/form/div[1]/table/tbody/tr/td/span/span[2]")).getText();
	String cart = driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[2]/span/a/span[2]")).getText();
	
	String actual1 = "1 item in your cart";
	String actual2 = "Proceed to checkout";
	String actual3 = "1";
	String actual4 = "6.99";
	String actual5 = "1";
	
//	System.out.println(verifyItem);
//	System.out.println(proceedChk);
//	System.out.println(count);
//	System.out.println(price);
//	System.out.println(cart);
	
	Assert.assertEquals(verifyItem, actual1);
	Assert.assertEquals(proceedChk, actual2);
	Assert.assertEquals(count, actual3);
	Assert.assertEquals(price, actual4);
	Assert.assertEquals(cart, actual5);
	} //end test
	
	@AfterTest (alwaysRun = true)
	public  void closeIt () throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
} //end class
