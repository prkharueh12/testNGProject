package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class NationalKey {

	@FindBy (xpath = "//*[@id=\"menu_admin_nationality\"]")
	public WebElement nationButt;
	////*[@id="menu_admin_viewAdminModule"]/b
	////div [@id='mainMenu']/ul/li/a/b)[1]
	@FindBy (id = "menu_admin_viewAdminModule")
	public WebElement adminButt;
	
	@FindBy (id = "btnAdd")
	public WebElement addButt;
	
	@FindBy (id = "btnSave")
	public WebElement saveButt;
	
	@FindBy (id = "nationality_name")
	public WebElement boxName;
	
	@FindBy (xpath = "//*[@id=\"resultTable\"]/tbody/tr[*]/td[2]/a")
	public List <WebElement> nationList;


	public NationalKey () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
}
//btnSave