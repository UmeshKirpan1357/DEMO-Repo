package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestBase;

public class ContactsPage extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
	@CacheLookup
	private WebElement contactLink;
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	@CacheLookup
	private WebElement addContactBtn;
	
	//Initialization
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//action	
	public boolean validateAddNewContactBtnIsDisplayed() {
	return addContactBtn.isDisplayed();	
	}
	
	public CreateNewContactPage validateNewButtonIsClickable() {
		addContactBtn.click();
		return new  CreateNewContactPage();
	}
}
