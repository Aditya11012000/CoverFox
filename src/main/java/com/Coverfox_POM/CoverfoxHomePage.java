package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHomePage {
@FindBy(xpath = "//div[text()='Male']") private WebElement gender;

public CoverfoxHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void selectGender() {
	Reporter.log("Selecting gender", true);
	gender.click();
}
}
