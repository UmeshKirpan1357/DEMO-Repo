package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginWindowPage;
import com.crm.qa.util.TestBase;

public class ContactsPageTest extends TestBase {
	ContactsPageTest() {
		super();
	}

	LoginPage loginPage;
	LoginWindowPage loginWindowPage;
	HomePage homePage;
	ContactsPage contactPage;
	CreateNewContactPage createNewContactPage;
	
	
	@BeforeMethod
	public void setUp() {
		Initialized();
		loginPage = new LoginPage();
		loginWindowPage = new LoginWindowPage();
		homePage = new HomePage();
		contactPage = new ContactsPage();
		createNewContactPage = new CreateNewContactPage();

		loginPage.validateLoginButtonIsClickable();
		loginWindowPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validateContacts();
	}

	@Test(priority = 1)
	public void validateAddNewContactBtnIsDisplayedTest() {
		boolean btnflag = contactPage.validateAddNewContactBtnIsDisplayed();
		Assert.assertTrue(btnflag);
	}

	@Test(priority = 2)
	public void validateNewButtonIsClickableTest() {
		createNewContactPage = contactPage.validateNewButtonIsClickable();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
