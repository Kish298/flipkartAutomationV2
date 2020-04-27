package com.flipkartAutomationV2.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkartAutomationV2.pageObjects.LoginHomePage;
import com.flipkartAutomationV2.pageObjects.LoginWindow;
import com.flipkartAutomationV2.utilities.XLUtils;


public class TC_LoginDDT02 extends BaseClass{

	@Test(dataProvider = "loginData")
	public void loginDDT(String userName, String password) throws IOException, InterruptedException {
		
		LoginWindow lw = new LoginWindow(driver);
		LoginHomePage lhp = new LoginHomePage(driver);
		lw.setLoginName(userName);
		lw.setPassword(password);
		lw.loginBtnClick();
		Thread.sleep(5000);
		
		boolean res=driver.getPageSource().contains("Please enter valid Email ID/Mobile number");
		
		if(res == false) {
			logger.info("Login Passed");
			Assert.assertTrue(true);
			lhp.homeUserName();
			Thread.sleep(3000);
		}
		else{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			captureScreenshot(driver,timeStamp);
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
	}
	
	@DataProvider(name = "loginData")
	String [][] getData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/flipkartAutomationV2/testData/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path,"Sheet1");
		int colCount = XLUtils.getCellCount(path,"Sheet1", 1);
		
		String loginData[][] = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
