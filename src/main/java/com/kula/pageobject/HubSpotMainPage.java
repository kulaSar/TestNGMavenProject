package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HubSpotMainPage {
	WebDriver driver;
	public HubSpotMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath="//h3[contains(.,'Marketing Hub')]/ancestor::div[@class='home-products-feature__card']//a[text()='Learn more']")
	private WebElement MarketingHubLearnMoreButton;
	@FindBy(xpath="//h3[contains(.,'Sales Hub')]/ancestor::div[@class='home-products-feature__card']//a[text()='Learn more']")
	private WebElement SalesHubLearnMoreButton;
	@FindBy(xpath="//h3[contains(.,'Sales Hub')]/ancestor::div[@class='home-products-feature__card']//a[text()='Learn more']")
	private WebElement ServiceHubLearnMoreButton;
	
	public void clickOnMarketingHubLearnMoreButton() {
		MarketingHubLearnMoreButton.click();
	}
	public void clickOnSalesHubLearnMoreButton() {
		SalesHubLearnMoreButton.click();
	}
	public void clickOnServiceHubLearnMoreButton() {
		ServiceHubLearnMoreButton.click();
	}
	

}
