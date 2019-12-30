package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginWindowPage;
import com.crm.qa.util.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPageTest() {
		super();
	}
	LoginPage loginPage;
	LoginWindowPage loginWindowPage;

	

	@BeforeMethod
	public void setUp() {
		Initialized();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void validateLoginPageTitleTest() {

		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}

	@Test(priority = 2)
	public void validateCRMLogoImageTest() {
		boolean flag = loginPage.validateCRMLogoNameIsDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void validateLoginButtonTest() {
		boolean Btnflag = loginPage.validateLoginButtonIsDisplayed();
		Assert.assertTrue(Btnflag);
	}

	@Test(priority = 4)
	public void validateLoginButtonisClickableTest() {
		loginWindowPage=new LoginWindowPage();
		loginWindowPage = loginPage.validateLoginButtonIsClickable();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
