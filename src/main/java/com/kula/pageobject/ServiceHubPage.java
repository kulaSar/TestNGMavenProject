package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ServiceHubPage {
	WebDriver driver;
	public ServiceHubPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//h3[text()='Free']/ancestor::div[@class='wf-all-hubs-pricing-card cl-card -border ']//a[contains(text(),'Learn more')]")              
	private WebElement SalesFreeLearnMoreButton;
	
	@FindBy(xpath="//div[@role='region']//button[contains(@class,'banner-close-btn')]")
	private WebElement bannerCloseButton;
	
	@FindBy(xpath="//span[text()='Resources']")
	private WebElement resourcesDropdown;
	
	@FindBy(xpath="//p[text()='Free Courses & Certifications']")
	private WebElement freCourcesbutton;
	
	
	public void clickOnfreCourcesbutton() {
		freCourcesbutton.click();
	}
	
	
	
	public void clickOnSalesFreeLearnMoreButton() {
		SalesFreeLearnMoreButton.click();
	}
	
	public void hoverresourcesDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(resourcesDropdown).perform();
	}
	
	public void verifyPageTitle(String actualTitle) {
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Title Matched");
	}
	public void closeBanner() {
		bannerCloseButton.click();
	}

}
