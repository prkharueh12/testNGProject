package com.hrms.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {
	
	public WebDriver driver;
	 @Test
	  public void edgeDriver() { 
	//Initializing the edge driver (Gecko)
		 WebDriverManager.edgedriver().setup();
	   driver = new EdgeDriver();   
	   driver.get("https://www.demoqa.com"); 
	   driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
	   driver.quit();
	 
	  }
	 
	        @Test
	 public void ChromeTest()
	 { 
	 
	   //Initialize the chrome driver
	    WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.get("https://www.demoqa.com"); 
	   driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
	   driver.quit();
	 
	 }
	       

	        @Test
	        public void ChromeTestHeadless(){ 
	   	    WebDriverManager.chromedriver().setup();
	   	   driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
	   	   driver.get("https://www.demoqa.com"); 
	   	 
	   	 }
	        
	       /*
	        * @Test
		public void fireFoxHeadlressDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
		driver.get("https://www.demoqa.com");
	}
	        
	        * */

}
