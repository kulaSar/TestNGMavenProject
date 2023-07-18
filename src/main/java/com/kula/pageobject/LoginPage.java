package com.kula.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kula.generic.WebdriverCommonLibrary;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id="login")
	private WebElement usernameTxtBx;
	@FindBy(id="password")
	private WebElement pwdTxtBx;
	@FindBy(css="button[type='submit']")
	private WebElement submitButton;
	WebdriverCommonLibrary wdcl = new WebdriverCommonLibrary(driver);
	public void setUserName(String userName){
		wdcl.enterData(usernameTxtBx, userName);
	}
	public void setPassword(String pwd){
		wdcl.enterData(pwdTxtBx, pwd);
	}
	public void clickSubmit(){
		submitButton.click();
	}
}
