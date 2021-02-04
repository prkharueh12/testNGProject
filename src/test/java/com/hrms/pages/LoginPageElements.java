package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class LoginPageElements {

	
	@FindBy (id = "txtUsername")
	public WebElement username;
	
	@FindBy (id = "txtPassword")
	public WebElement password;
	
	@FindBy (id = "btnLogin")
	public WebElement loginBtn;
	
	@FindBy (xpath = "")
	public WebElement logo;
	
	@FindBy (id = "")
	public WebElement errorMsg;
	
	public LoginPageElements () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}
