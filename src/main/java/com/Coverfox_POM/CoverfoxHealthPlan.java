package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHealthPlan {
@FindBy(xpath = "(//div[@class='ms-img-bx'])[5]") private WebElement father;

@FindBy(className = "next-btn") private WebElement nextButton;

public CoverfoxHealthPlan(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickFather() {
	father.click();
}
public void clickNext() {
	Reporter.log("Clicking next button",true);
	nextButton.click();
}
}
