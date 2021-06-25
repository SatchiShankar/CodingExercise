package com.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Test.BaseTest;

public class LoginPage extends BaseTest{

	public LoginPage(WebDriver selenium) {
		super();
		PageFactory.initElements(selenium, this);
	}

	@FindBy(id="ap_email")
	private WebElement txtboxEmail;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="ap_password")
	private WebElement txtboxPassword;
	
	@FindBy(id="signInSubmit")
	private WebElement btnSignIn;
	
	public void login() {
		txtboxEmail.sendKeys(properties.getProperty("email"));
		btnContinue.click();
		txtboxPassword.sendKeys(properties.getProperty("password"));
		btnSignIn.click();
	}
	
}
