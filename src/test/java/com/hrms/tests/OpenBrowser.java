package com.hrms.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.testBase.Driver;
import com.hrms.utils.ConfigsReader;

public class OpenBrowser {

	@BeforeMethod
	public void beforeClass() {
		Driver.getDriver().get(ConfigsReader.getProperty("url"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test1() {
	}
	@AfterMethod
	public void afterClass() {
	}
	
}
