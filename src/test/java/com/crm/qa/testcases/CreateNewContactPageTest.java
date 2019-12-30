package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LoginWindowPage;
import com.crm.qa.util.TestBase;
import com.crm.qa.util.TestUtil;

public class CreateNewContactPageTest extends TestBase{
	
	CreateNewContactPageTest(){
		super();
	}
	LoginPage loginPage;
	LoginWindowPage loginWindowPage;
	HomePage homePage;
	ContactsPage contactPage;
	CreateNewContactPage createNewContactPage;
	
	String sheetName="Contacts";
	
	@BeforeMethod()
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
		contactPage.validateNewButtonIsClickable();
	}
	
//	@Test(priority=1)
//	public void validateCreateNewContactPageTitleTest() {
//		String contactTitle=createNewContactPage.validateCreateNewContactPageTitle();
//		Assert.assertEquals(contactTitle, "Cogmento CRM");
//	}
//	
//	@Test(priority=2)
//	public void validateCreateNewContactLableTest() {
//		boolean contactLabel=createNewContactPage.validateCreateNewContactLable();
//		Assert.assertTrue(contactLabel);
//	}
	
	@DataProvider()
	public Object[][] getCRMTestData() {
		Object[][] data=TestUtil.getTestdata(sheetName);
		return data;
	}
	@Test(priority=1, dataProvider="getCRMTestData")
	public void createNewContactTest(String firstname, String middlename, String lastname, String email) {
		//createNewContactPage.createNewContact("Umesh", "QA", "User", "qauser@test.com");
		createNewContactPage.createNewContact(firstname, middlename, lastname, email);
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
