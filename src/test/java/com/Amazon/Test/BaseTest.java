package com.Amazon.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
	public static WebDriver selenium;
	public static Properties properties;

	

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		try {
			properties = loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod()
	public void afterMethod() {
		if(selenium!=null)
		selenium.quit();
	}
	
	protected Properties loadProperties() throws IOException {
		properties = new Properties();
		String fileName = System.getProperty("user.dir")+"\\base.properties";
		FileInputStream fis = new FileInputStream(fileName);
		properties.load(fis);
		return properties;
	}
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriverPath"));
		selenium= new ChromeDriver();
		selenium.manage().deleteAllCookies();
		selenium.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		selenium.manage().window().maximize();
		return selenium;
	}
}
