package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class ExcelKey {
	
	@FindBy (id = "txtUsername")
	public WebElement userButt;
	
	@FindBy (id = "txtPassword")
	public WebElement passButt;
	
	@FindBy (id = "btnLogin")
	public WebElement loginButt;
	
	@FindBy (id = "menu_pim_viewPimModule")
	public WebElement pimButt;
	
	@FindBy (id = "btnAdd")
	public WebElement addButt;
	
	@FindBy (id = "firstName")
	public WebElement inputF;
	
	@FindBy (id = "lastName")
	public WebElement inputL;
	
	@FindBy (id = "btnSave")
	public WebElement saveButt;
	
	@FindBy (id = "profile-pic")
	public WebElement verify;

//
	public ExcelKey () {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
