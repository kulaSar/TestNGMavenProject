package com.kula.generic;


import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

//import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;

public class WebdriverCommonLibrary {
	WebDriver driver;
	public WebdriverCommonLibrary(WebDriver driver) {
		this.driver=driver;
	}
	/*******************to enetr data***********************/
	public void enterData(WebElement txtbx, String value) {
		txtbx.clear();
		txtbx.sendKeys(value);
	}
	/*******************to click check box***********************/
	public void clickChkBx(WebElement chckBx) {
		if (chckBx.isSelected()) {
			Reporter.log("Checkbox is already selected", true);
			// reporter.log("Checkbox is already selected", true);
		} else {
			chckBx.click();
		}
	}
	/*******************to select by visible text***********************/
	public void selectOptionText(WebElement drpDwn, String optionText) {
		Select sel = new Select(drpDwn);
		sel.selectByVisibleText(optionText);
	}
//	public void getAllOptions(WebElement drpdwn){
//		org.openqa.selenium.support.ui.Select sel = new org.openqa.selenium.support.ui.Select(drpdwn);
//		List<WebElement> allOptions = sel.getOptions();
//		
//	}
	/*******************to handle mouse hover***********************/
	public void mouseOver(WebElement ele){
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/*******************to explicit Wait***********************/
	public void eWaitForVisible(int secs,WebElement ele){
		WebDriverWait wait= new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/*******************to scroll by view***********************/
	public void scrollView(WebElement ele){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
	}
	/*******************to scroll down***********************/
	public void scrollDown(int scrollHeight){
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+scrollHeight+")");
	}
	/*******************to hardcode wait***********************/
	public void hardCodeWait(int secs){
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void switchToJSPopUpNAccept(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public void implicitWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	//explicit wait
//	public void explicitWait(WebElement wb){
//		WebDriverWait wait= new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(wb));
//	}

}
