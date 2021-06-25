package com.Amazon.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Amazon.Test.BaseTest;

public class ShippingPage extends BaseTest{

	public ShippingPage(WebDriver selenium) {
		super();
		PageFactory.initElements(selenium, this);
	}
	
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	private WebElement txtPhone;
	
	@FindBy(id="address-ui-widgets-enterAddressLine1")
	private WebElement txtAddress1;
	
	@FindBy(id="address-ui-widgets-enterAddressLine2")
	private WebElement txtAddress2;
	
	@FindBy(id="address-ui-widgets-enterAddressCity")
	private WebElement txtCity;
	
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")
	private WebElement txtZipCode;
	
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion")
	private WebElement txtState;
	
	@FindBy(className="a-button-input")
	private WebElement btnUserThisAddress;
	
	@FindBy(css="span.a-color-price")
	private WebElement lblCheckoutPrice;
	
	

	public void validateCheckoutPrice() {
		txtPhone.sendKeys(properties.getProperty("phoneNumber"));
		txtAddress1.sendKeys(properties.getProperty("addressLine1"));
		txtAddress2.sendKeys(properties.getProperty("addressLine2"));
		txtCity.sendKeys(properties.getProperty("city"));
		txtState.click();
		String state=properties.getProperty("state") ;
		selenium.findElement(By.xpath("//li/a[@data-value='"+state+"']")).click();
		txtZipCode.sendKeys(properties.getProperty("zipCode"));
		btnUserThisAddress.click();
		
		Assert.assertEquals(lblCheckoutPrice.getText().trim(), SearchResultsPage.price);		
	}
}
