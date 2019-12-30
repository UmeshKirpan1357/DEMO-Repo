package com.crm.qa.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
	public static String PropertyFilePath="E:\\Work\\SeleniumWorkspace\\PageObjectModelWithTestNG\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
	
	public static  WebDriver driver;	
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	public static WebDriverListener eventListener;
	
	public TestBase() {
		BufferedReader reader;
		prop=new Properties();
		try {
			 reader=new BufferedReader((new FileReader(PropertyFilePath)));
			try {
				prop.load(reader);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void Initialized() {
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver=new ChromeDriver();
			}
			else if (browserName.equals("FireFox")) {			
				System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
				driver=new FirefoxDriver();
			}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebDriverListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
			
		
	}
	
