package com.Coverfox_TestNG;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Coverfox_Base.Base;
import com.Coverfox_POM.CoverfoxAddressDetails;
import com.Coverfox_POM.CoverfoxHealthPlan;
import com.Coverfox_POM.CoverfoxHomePage;
import com.Coverfox_POM.CoverfoxMemberDetails;
import com.Coverfox_POM.CoverfoxResultPage;
import com.Coverfox_Utility.Utility;

public class CoverFoxTestByTestNG extends Base{
	
	CoverfoxHomePage homePage;
	CoverfoxAddressDetails address;
	CoverfoxHealthPlan healthPlan;
	CoverfoxMemberDetails memberDetails;
	CoverfoxResultPage result;
	Logger logger;
	
//	@BeforeClass
//	public void toLaunchBrowser()
//	{
//		
//	}
	
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
//		  address.enterPincode(Utility.takeDataFromexcel("Sheet6", 0, 0));
//		  address.enterFatherPincode(Utility.takeDataFromexcel("Sheet6", 0, 1));
//		  address.enterMobileNumber(Utility.takeDataFromexcel("Sheet6", 0, 2));
//		  address.clickContinue();		
//		 Thread.sleep(3000);
//		 Utility.saveScreenshot(dr, "Adress01");
	}
	
	@Test(priority = 1)
	public void validateErrorMsg() throws EncryptedDocumentException, IOException, InterruptedException {
		address.clickContinue();
		String expPinErrormsg= "Please enter a valid pincode";
		String expMoNoErrorMsg = "Please enter a valid mobile no.";
		
		String actMyPinMsg= address.validateMyPinMsg(); 
		String actFatherPinMsg= address.validateFatherPinMsg();
		String actMoNoMsg= address.validateMoNoMsg();
		Assert.assertEquals(actMyPinMsg, expPinErrormsg, "Test case failed");
		Reporter.log("TC1 -Pin error msg is visible correctly",true);
		
		Assert.assertEquals(actFatherPinMsg, expPinErrormsg, "Test case failed");
		Reporter.log("TC1 -Pin error msg is visible correctly",true);
		
		Assert.assertEquals(actMoNoMsg, expMoNoErrorMsg, "Test case failed");
		Reporter.log("TC1 -Mobile Number error msg is visible correctly",true);
		
		 address.enterPincode(Utility.takeDataFromexcel("Sheet6", 0, 0));
		  address.enterFatherPincode(Utility.takeDataFromexcel("Sheet6", 0, 1));
		  address.enterMobileNumber(Utility.takeDataFromexcel("Sheet6", 0, 2));
		  address.clickContinue();		
		 Thread.sleep(3000);
		 Utility.saveScreenshot(dr, "Adress01");
		
	}
	
  @Test(priority = 2)
  public void validateNoOfPlans() throws IOException, InterruptedException 
  {
	  
	  logger= Logger.getLogger("My_New_log");
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Validation of plans");
	  logger.warn("This is warning");
	  result = new CoverfoxResultPage(dr);
//	  int noOfPlansFromText= result.getActualPlansFromText();
//	  int noOfPlansFromCards= result.getVisiblePlansFromPlanCards();
	  
	  result.checkResult();
	   Assert.assertEquals(result.actualComponants, result.visibleComponants, "Test case has been failed. Number of plans are not matching.");
	   Reporter.log("Test case validateNoOfPlans has passed.",true);
	   Utility.saveScreenshot(dr, "Result01");
  }
  
//  @AfterClass
//  public void closeBrowser() throws InterruptedException {
//	  Thread.sleep(2000);
//	  dr.close();
//  }
}
