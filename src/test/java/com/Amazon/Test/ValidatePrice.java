package com.Amazon.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Amazon.Pages.CartPage;
import com.Amazon.Pages.HomePage;
import com.Amazon.Pages.LoginPage;
import com.Amazon.Pages.SearchResultsPage;
import com.Amazon.Pages.SelectedItemPage;
import com.Amazon.Pages.ShippingPage;

public class ValidatePrice extends BaseTest
{
	
	@Test
    public void validateItemPrice()
    {
    	WebDriver selenium=getDriver();
    	HomePage hp=new HomePage(selenium);
    	hp.searchItem();
    	
    	SearchResultsPage srp=new SearchResultsPage(selenium);
    	srp.selectFirstSearchResult();

    	SelectedItemPage sip=new SelectedItemPage(selenium);
    	sip.validateItemPrice();

    	CartPage cp=new CartPage(selenium);
    	cp.validateCartPrice();

    	LoginPage lp=new LoginPage(selenium);
    	lp.login();

    	ShippingPage sp=new ShippingPage(selenium);
    	sp.validateCheckoutPrice();
    }
    
}
