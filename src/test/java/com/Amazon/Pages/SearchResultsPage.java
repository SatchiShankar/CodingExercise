package com.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Test.BaseTest;

public class SearchResultsPage extends BaseTest {
	public static String price;
	public SearchResultsPage(WebDriver selenium) {
		super();
		PageFactory.initElements(selenium, this);
	}

	@FindBy(xpath="//div[@data-index='1']/*//h2")
	private static WebElement lnkFirstResult;
	
	@FindBy(xpath="//span[@cel_widget_id='MAIN-SEARCH_RESULTS-1']/*//span[@class='a-price']")
	private static WebElement lblFirstPrice;
	
	
	public void selectFirstSearchResult() {
		String amount=lblFirstPrice.getText();
		String splitAmount[]=amount.split("\\n");
		price=splitAmount[0].trim()+"."+splitAmount[1].trim();
		lnkFirstResult.click();
	}
}
