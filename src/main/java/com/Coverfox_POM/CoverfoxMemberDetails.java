package com.Coverfox_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverfoxMemberDetails {
	
	

	@FindBy(id = "Age-You") private WebElement sonDropdown;
	@FindBy(id="Age-Father") private WebElement fatherDropdown;
	@FindBy(className="next-btn") private WebElement nextButton;
	
	public CoverfoxMemberDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectMyAge() {
		Reporter.log("Selecting my age",true);
		Select sel = new Select(sonDropdown);
		sel.selectByValue("24y");

	}
	
	public void selectFatherAge() {
		Reporter.log("Selecting father age",true);
		Select sel = new Select(fatherDropdown);
		sel.selectByValue("45y");
	}
	public void clickNext() {
		Reporter.log("Clicking on next button",true);
		nextButton.click();
	}
}
