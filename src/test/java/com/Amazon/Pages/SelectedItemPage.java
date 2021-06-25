package com.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Amazon.Test.BaseTest;

public class SelectedItemPage extends BaseTest {

	public SelectedItemPage(WebDriver selenium) {
		super();
		PageFactory.initElements(selenium, this);
	}

	@FindBy(id="newBuyBoxPrice")
	private WebElement lblItemPrice;
	
	@FindBy(id="add-to-cart-button")
	private WebElement btnAddToCart;
	
	public void validateItemPrice() {
		String itemPrice=lblItemPrice.getText().trim();
		Assert.assertEquals(itemPrice, SearchResultsPage.price);	
		btnAddToCart.click();
	}
	

}
