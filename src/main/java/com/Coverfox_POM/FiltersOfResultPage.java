package com.Coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FiltersOfResultPage {
	
@FindBy(xpath = "//div[text()='Sum Assured']") private WebElement sumAssured;
//@FindBy(xpath = "//span[text()='15L to 24L']") private WebElement firstFilter;
@FindBy(xpath = "//div[@class='radio-options filter-options vb-item-flex']/div/span") private List<WebElement> listOfSumAssured;
//@FindBy(xpath = "/html/body/div[3]/section/main/section[2]/section/div[1]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/div[2]") private List<WebElement> priceList;

@FindBy(xpath = "//div[@id='plans-list']/descendant::div[@class='rupee-val'][1]") private List<WebElement> priceList;

public FiltersOfResultPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	

public void selectSumAssuredFilter(String range) throws InterruptedException {
	Thread.sleep(3000);
	sumAssured.click();
	Reporter.log("Clicked on filter.",true);
	Thread.sleep(3000);
	
	for(WebElement el:listOfSumAssured) {
		String text=el.getText();
		if(text.contains(range)) {
			el.click();
			Reporter.log("Filter applied",true);
			break;
		}
	}
	
}

public int validatePrice() {
	int count =0;
	for(WebElement el:priceList) {
		String text = el.getText();
		String[] splitText= text.split(" ");
		float price = Float.parseFloat(splitText[0]);
//		System.out.println(price);
		
		if(price>=15 && price <=24) {
			count++;
		}
}
return count;	
}


}
