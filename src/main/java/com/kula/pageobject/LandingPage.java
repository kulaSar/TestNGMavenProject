package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath="//a[text()='Sign in']")
	private WebElement signInBttn;
	@FindBy(xpath="//a[@class='dropdown-toggle nav-link']")
	private WebElement userDropDown;
	@FindBy(xpath="//div[@role='menu'and @class!='dropdown-menu ']//a[contains(@href,'database')]")
	private WebElement myDatabaseLink;
	
	public void clickOnSignIn(){
		signInBttn.click();
	}
	
	public void clickOnUserNameDrpDwn() throws InterruptedException {
		System.out.println("inside clickOnUserNameDrpDwn");
		Thread.sleep(3000);
		userDropDown.click();
		Thread.sleep(3000);
		System.out.println("inside clickOnUserNameDrpDwn22222");
	}

	public void verifyLandingPage() {
		String expTitle="Databases | Odoo";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expTitle, actualTitle);
		Reporter.log("Login successfull", true);
	}
	public void clickOnMyDataBase(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(myDatabaseLink));
		myDatabaseLink.click();
	}

	public void verifyTitle(){
		String actualTitle= driver.getTitle();
		String expectedTitle="Databases | Odoo";
		Assert.assertEquals(actualTitle,expectedTitle);
		Reporter.log("Same title---:)");
	}
}
