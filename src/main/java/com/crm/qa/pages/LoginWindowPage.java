package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.util.TestBase;

public class LoginWindowPage extends TestBase {

	//PageFactory 
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	private WebElement loginBtn;
	
	//Initialization
	public LoginWindowPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public HomePage validateLoginFunctionality(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
