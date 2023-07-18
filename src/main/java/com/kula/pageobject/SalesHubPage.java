package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SalesHubPage {
	WebDriver driver;
	public SalesHubPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void verifyPageTitle(String actualTitle) {
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Title Matched");
	}
}

