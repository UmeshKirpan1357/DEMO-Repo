package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestBase;

public class CreateNewContactPage extends TestBase{

	//Page Factory
	@FindBy(name="first_name")
	@CacheLookup
	private WebElement firstName;
	
	@FindBy(name="last_name")
	@CacheLookup
	private WebElement lastName;
	
	@FindBy(name="middle_name")
	@CacheLookup
	private WebElement middleName;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")
	@CacheLookup
	private WebElement emailID;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	@CacheLookup
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	private WebElement createNewContactLabel;
	
	//Initialization
	public CreateNewContactPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public String validateCreateNewContactPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCreateNewContactLable() {
		return createNewContactLabel.isDisplayed();
	}
	
	public void createNewContact(String firstname, String middlename, String lastname, String email)  {
		firstName.sendKeys(firstname);
		middleName.sendKeys(middlename);
		lastName.sendKeys(lastname);
		emailID.sendKeys(email);
		Actions action=new Actions(driver);
		action.moveToElement(saveButton).build();
		saveButton.click();
	}
	
}