package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SalesHubPage {
	WebDriver driver;
	public SalesHubPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath="//h3[text()='Free']/ancestor::div[@class='wf-all-hubs-pricing-card cl-card -border ']//a[contains(text(),'Learn more')]")
	private WebElement SalesFreeLearnMoreButton;
	
	public void clickOnSalesFreeLearnMoreButton() {
		SalesFreeLearnMoreButton.click();
	}
	
	public void verifyPageTitle(String actualTitle) {
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Title Matched");
	}
}

