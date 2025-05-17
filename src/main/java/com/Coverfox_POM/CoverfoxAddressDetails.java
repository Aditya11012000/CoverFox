package com.Coverfox_POM;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxAddressDetails {
@FindBy(xpath = "(//input[@class='mp-input-text'])[1]") private WebElement myPincode;
@FindBy(xpath = "(//input[@class='mp-input-text'])[2]") private WebElement parentsPin;
@FindBy(id="want-expert") private WebElement mobile;
@FindBy(className = "next-btn") private WebElement nextButton;

@FindBy(xpath = "(//div[contains(text(),'valid pincode')])[1]") private WebElement myPinError;
@FindBy(xpath = "(//div[contains(text(),'valid pincode')])[2]") private WebElement fatherPinError;
@FindBy(xpath = "//div[contains(text(),' valid mobile no.')]") private WebElement MoNoError;



public CoverfoxAddressDetails(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void enterPincode(String pin) {
	myPincode.sendKeys(pin);
	Reporter.log("PinCode entered",true);
}
public void enterFatherPincode(String pin) {
	parentsPin.sendKeys(pin);
	Reporter.log("Fathers PinCode entered",true);
}
public void enterMobileNumber(String moNo) {
	mobile.sendKeys(moNo);
	Reporter.log("Mobile number has been entered",true);
}
public void clickContinue() {
	Reporter.log("Clicking on continue button",true);
	nextButton.click();
}

public String validateMyPinMsg() {
	 String myPinErrorMsg=myPinError.getText();
	 return myPinErrorMsg;
}

public String validateFatherPinMsg() {
	 
	 String fatherPinErrorMsg=myPinError.getText();
	 return fatherPinErrorMsg;
}

public String validateMoNoMsg() {
	
	String MobileNoErrorMsg=MoNoError.getText();
	return MobileNoErrorMsg;
}
}
