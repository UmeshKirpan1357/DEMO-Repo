package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginWindowPage;
import com.crm.qa.util.TestBase;

public class LoginWindowPageTest extends TestBase{
	LoginWindowPageTest(){
		super();
	}
	LoginWindowPage loginWindowPage;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		Initialized();
		loginPage = new LoginPage();
		loginWindowPage=new LoginWindowPage();
		homePage=new HomePage();
		loginPage.validateLoginButtonIsClickable();
	}
	
	@Test(priority=1)
	public void validateLoginFunctionalityTest() {
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		homePage=loginWindowPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
