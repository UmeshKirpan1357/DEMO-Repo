package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginWindowPage;
import com.crm.qa.util.TestBase;

public class HomePageTest extends TestBase {

	public HomePageTest() {
		super();
	}
	
	LoginPage loginPage;
	LoginWindowPage loginWindowPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	@BeforeMethod
	public void setUp() {
		Initialized();
		loginPage = new LoginPage();
		loginWindowPage=new LoginWindowPage();
		homePage=new HomePage();
		contactPage=new ContactsPage();
		loginPage.validateLoginButtonIsClickable();
		loginWindowPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void validateUserIsOnHomePageTest() {
		boolean flag=homePage.validateUserIsOnHomePage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void validateContactsTest() {
		contactPage=homePage.validateContacts();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
