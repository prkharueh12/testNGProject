package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class DashboardPageElement {
	
	@FindBy (id = "Subscriber_link")
	public WebElement subtxt;
	
	
	
	public DashboardPageElement () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
}
