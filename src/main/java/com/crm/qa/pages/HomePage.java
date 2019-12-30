package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestBase;

public class HomePage extends TestBase {

	//Page Factory or OR
	@FindBy(xpath="//*[@id='top-header-menu']/div[3]/span[1]")
	private WebElement UserName;
	
	@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
	private WebElement contactLink;
	
	//Initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validateUserIsOnHomePage() {
		return UserName.isDisplayed();
	}
	
	public ContactsPage validateContacts() {
		contactLink.click();
		return new ContactsPage();
	}
}
