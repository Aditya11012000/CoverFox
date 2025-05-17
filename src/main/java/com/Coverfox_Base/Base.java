package com.Coverfox_Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
protected WebDriver dr;

public void openBrowser() {
	dr= new ChromeDriver();
	dr.get("https://www.coverfox.com/");
//	dr.manage().window().maximize();
	dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
}
	
}
