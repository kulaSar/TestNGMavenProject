package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public abstract class BaseClass {
	public BaseClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[contains(text(),'Sales')][contains(@role,'button')]")
	private WebElement salesBttn;
	@FindBy(xpath="//span[text()='Customers']")
	private WebElement customers;
	@FindBy(xpath="//img[@alt='Avatar'][@class='rounded-circle oe_topbar_avatar']")
	private WebElement userDropdwn;
	@FindBy(linkText="Log out")
	private WebElement logOut;
	
	public void clickSaleBttn(){
		salesBttn.click();
	}
	public void clickOnCustomer(){
		customers.click();
	}
	public void clickOnUserDropdwn(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userDropdwn.isDisplayed())
		userDropdwn.click();
		else
			Reporter.log("Dropdown not displayed",true);
	}
	public void clickOnLogout() {
		logOut.click();
	}

}
