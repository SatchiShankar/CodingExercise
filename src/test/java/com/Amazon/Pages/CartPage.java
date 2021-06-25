package com.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage{

	public CartPage(WebDriver selenium) {
		super();
		PageFactory.initElements(selenium, this);
	}

	@FindBy(xpath="//div[@id='hlb-subcart']/*//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	private WebElement lblCartTotalPrice;
	
	@FindBy(id="hlb-ptc-btn")
	private WebElement btnProceedToCheckout;
	
	public void validateCartPrice() {
		String cartPrice=lblCartTotalPrice.getText().trim();
		Assert.assertEquals(cartPrice, SearchResultsPage.price);		
		btnProceedToCheckout.click();
	}

}
