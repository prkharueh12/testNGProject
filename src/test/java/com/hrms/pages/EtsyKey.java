package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.Driver;

public class EtsyKey {
	
	@FindBy (xpath = "//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")
	public WebElement signInButt;
	
	@FindBy (id = "join_neu_email_field")
	public WebElement emailBox;
	
	@FindBy (id = "join_neu_password_field")
	public WebElement passBox;
	
	@FindBy (xpath = "//*[@id=\"join-neu-form\"]/div[1]/div/div[6]/div/button")
	public WebElement submitButt;
	
	@FindBy (id = "mail")
	public WebElement randomMailBox;
	
//	@FindBy (xpath = "//*[@id=\"resultTable\"]/tbody/tr[*]/td[2]/a")
//	public List <WebElement> nationList;


	public EtsyKey () {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
