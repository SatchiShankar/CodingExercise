package com.Amazon.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dr = DesiredCapabilities.chrome();
		//specify the browser 
		//specify the environment                
		        dr.setCapability("platform", "WINDOWS");  
		        dr.setJavascriptEnabled(true);
		     
		  //specify the hub URL           
		        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.20:4444/wd/hub"), dr);
		        driver.navigate().to("https://www.google.com/");
		        Thread.sleep(15000);
		       // driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		        //driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		        driver.close();
	}

}
