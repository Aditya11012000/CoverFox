package com.Coverfox_TestNG;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Coverfox_Base.Base;
import com.Coverfox_POM.CoverfoxAddressDetails;
import com.Coverfox_POM.CoverfoxHealthPlan;
import com.Coverfox_POM.CoverfoxHomePage;
import com.Coverfox_POM.CoverfoxMemberDetails;
import com.Coverfox_POM.CoverfoxResultPage;
import com.Coverfox_POM.FiltersOfResultPage;
import com.Coverfox_Utility.Utility;

public class CoverfoxPriceFilterTestNG extends Base {
	
	CoverfoxHomePage homePage;
	CoverfoxAddressDetails address;
	CoverfoxHealthPlan healthPlan;
	CoverfoxMemberDetails memberDetails;
	CoverfoxResultPage result;
	FiltersOfResultPage filter;
	Logger logger;
	
	@BeforeClass
	public void  coverFoxPreconditions() throws EncryptedDocumentException, IOException, InterruptedException
	{
		openBrowser();
		
		homePage = new CoverfoxHomePage(dr);
		homePage.selectGender();
		Thread.sleep(2000);
		healthPlan=new CoverfoxHealthPlan(dr);
		healthPlan.clickFather();
		healthPlan.clickNext();
		Thread.sleep(2000);
		memberDetails= new CoverfoxMemberDetails(dr);
		memberDetails.selectMyAge();
		memberDetails.selectFatherAge();
		memberDetails.clickNext();
		Thread.sleep(2000);
		  
		  address = new CoverfoxAddressDetails(dr);
		  address.enterPincode(Utility.takeDataFromexcel("Sheet6", 0, 0));
		  address.enterFatherPincode(Utility.takeDataFromexcel("Sheet6", 0, 1));
		  address.enterMobileNumber(Utility.takeDataFromexcel("Sheet6", 0, 2));
		  address.clickContinue();		
//		 Thread.sleep(3000);
//		 Utility.saveScreenshot(dr, "Adress01");
		  
		  
	}
	
  @Test
  public void validateRangeFilter() throws InterruptedException {
	  filter = new FiltersOfResultPage(dr);
	  filter.selectSumAssuredFilter("15L to 24L");
	  Thread.sleep(3000);
	  
	 int visibleComponants= filter.validatePrice();
	 System.out.println(visibleComponants);
	 
	  result= new CoverfoxResultPage(dr);
	  result.checkResult();
	  System.out.println("Actual componants = "+result.actualComponants);
	  
	  Assert.assertEquals(result.actualComponants, visibleComponants, "Test case has been failed.");
	  Reporter.log("Test case has been passed...",true);
	  
  }
}
