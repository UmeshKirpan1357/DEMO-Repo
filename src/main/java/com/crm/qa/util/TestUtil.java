package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT_TIMEOUT = 20;

	public static String testDataFilePath = "E:\\Work\\SeleniumWorkspace\\PageObjectModelWithTestNG\\src\\FreeCRMDataProvider.xlsx";
	static Workbook workbook;
	static Sheet sheet;
	
	

	public static Object[][] getTestdata(String sheetName) {

		File file = new File(testDataFilePath); // creating a new file instance
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);

		Object[][] testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

				testData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return testData;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/Screenshot/" +System.currentTimeMillis()+".png"));
		
	}
}
