package com.Coverfox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class Utility {

	public static void saveScreenshot(WebDriver dr, String ssName) throws IOException {
		File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\ADITYA_SOFTWARE_TESTING\\JAVA\\Selenium\\src\\Screenshots\\"+ssName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("Screenshot has been saved.",true);
	} 
	
	public static String takeDataFromexcel(String sheet, int row, int cell ) throws EncryptedDocumentException, IOException {
	 FileInputStream file = new FileInputStream("C:\\ADITYA_SOFTWARE_TESTING\\JAVA\\Selenium\\src\\TestData\\Excel1.xlsx");
	  Workbook wb = WorkbookFactory.create(file);
	   Sheet mySheet = wb.getSheet(sheet);
	     String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
	     Reporter.log("Data read from excel.",true);
	     return data;
	}
	
	public static void scrollPage(WebDriver dr, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)dr);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Page scrolled",true);
	}
}
