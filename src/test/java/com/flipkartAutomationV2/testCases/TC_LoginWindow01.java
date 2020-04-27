package com.flipkartAutomationV2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkartAutomationV2.pageObjects.LoginWindow;

public class TC_LoginWindow01 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("Url is opened");
		
		LoginWindow lw = new LoginWindow(driver);
		lw.setLoginName(userName);
		lw.setPassword(password);
		lw.loginBtnClick();
		
		if(driver.getTitle().equalsIgnoreCase("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) {
			Assert.assertTrue(true);
			logger.info("Login Passed");
		}
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
			
			
	}
	

}
