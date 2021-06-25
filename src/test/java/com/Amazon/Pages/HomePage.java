package com.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Test.BaseTest;

public class HomePage extends BaseTest {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement txtSearchBox;

	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']")
	private WebElement btnSearch;
	
	
	
	public HomePage(WebDriver selenium) {
		super();
		PageFactory.initElements(selenium, this);
	}
	
	public void searchItem() {
		selenium.get(properties.getProperty("appURL"));
		txtSearchBox.sendKeys(properties.getProperty("searchContent"));
		btnSearch.click();		
	}

}
