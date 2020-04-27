package com.flipkartAutomationV2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWindow {
	
	WebDriver lDriver;
	
	public LoginWindow(WebDriver rDriver){
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	@CacheLookup
	WebElement loginName;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(className = "_1avdGP")
	@CacheLookup
	WebElement loginBtn;

	
	public void setLoginName(String usrid) {
		loginName.clear();
		loginName.sendKeys(usrid);
	}
	
	public void setPassword(String password) {
		pwd.clear();
		pwd.sendKeys(password);
	}
	
	public void loginBtnClick() {
		loginBtn.click();
	}
}
