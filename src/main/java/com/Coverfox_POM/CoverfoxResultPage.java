package com.Coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxResultPage {
@FindBy(xpath = "//div[contains(text(),'matching')]") private WebElement text;
@FindBy(id="plans-list") private List<WebElement> componant;

public CoverfoxResultPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public int actualComponants;
public int visibleComponants;

public void checkResult() throws InterruptedException {
	Thread.sleep(5000);
	String matchingText = text.getText();
	String[] array = matchingText.split(" ");
	String noOfComponants = array[0];
	 actualComponants = Integer.parseInt(noOfComponants);
	Thread.sleep(8000);
	 visibleComponants= componant.size();
	
//	System.out.println(actualComponants);
//	System.out.println(visibleComponants);
	
//	if(actualComponants==visibleComponants) {
//		System.out.println("Test case has passed.");
//	}
//	else {
//		System.out.println("Test case has failed.");
//	}	
}

//public int getActualPlansFromText() {
//	Reporter.log("Getting plans from text",true);
//	String actualPlans= text.getText();
//	String[] arr= actualPlans.split(" ");
//	int actualNoOfPlans= Integer.parseInt(arr[0]);
//	return actualNoOfPlans;
//}

//public int getVisiblePlansFromPlanCards() {
//	Reporter.log("Getting plans from plan cards",true);
//	int visibleNoOfPlans= componant.size();
//	return visibleNoOfPlans;
//}


}
