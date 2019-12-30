package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestBase;

public class LoginPage extends TestBase {

	// PageFactory or OR Object Repository

	@FindBy(xpath = "//div[@class='rd-navbar-panel']//span[contains(text(),'free')]")
	private WebElement crmLogoName;

	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	private WebElement loginBtnActionLink;

	// Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogoNameIsDisplayed() {
		return crmLogoName.isDisplayed();
	}

	public boolean validateLoginButtonIsDisplayed() {
		return loginBtnActionLink.isDisplayed();
	}

	public LoginWindowPage validateLoginButtonIsClickable() {
		loginBtnActionLink.click();
		return new LoginWindowPage();
	}

}
