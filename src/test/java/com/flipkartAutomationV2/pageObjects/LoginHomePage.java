package com.flipkartAutomationV2.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHomePage {
	
   WebDriver lDriver;
   public static Logger logger;
	
	public LoginHomePage(WebDriver rDriver){
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
		logger = Logger.getLogger("FlipkatAutomation");
	}
	
	@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath= "//div[contains(@class, '_1Q5BxB') and contains(., 'Logout')]")
	@CacheLookup
	WebElement logout;
	
	@FindBy(className = "_3Ep39l")
	@CacheLookup
	WebElement homeLoginBtn;
	
	@FindBy(className = "LM6RPg")
	@CacheLookup
	WebElement search;
	
	public void homeUserName() throws InterruptedException {
		Actions act = new Actions(lDriver);
		act.moveToElement(userName).build().perform();//taking mouse
		Thread.sleep(5000);
		logout.click();
	}
	
	public WebElement getUserName() {
		return userName;
	}
	
	public void homeloginBtnClick() {
		homeLoginBtn.click();
	}
	
	public void search() {
		search.sendKeys("redmiNote");
	}
}
