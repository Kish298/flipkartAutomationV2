package com.flipkartAutomationV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig() {
		File src =  new File("/home/oncall/eclipse-workspace/flipkartAutomationV1/configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
		
	public String getBaseUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getuserName() {
		String username = pro.getProperty("userName");
		return username;
	}
	
	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getFirefoxDriverPath() {
		String firepath = pro.getProperty("firefoxpath");
		return firepath;
	}
	
	public String getChromeDriverPath() {
		String ChromeDriverPath = pro.getProperty("chromepath");
		return ChromeDriverPath;
	}
}
