package com.flipkartAutomationV2.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.flipkartAutomationV2.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getBaseUrl();
	public String userName = readconfig.getuserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger("FlipkatAutomation");
		
		if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}
}
