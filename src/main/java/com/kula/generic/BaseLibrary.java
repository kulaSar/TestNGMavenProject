package com.kula.generic;

import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class BaseLibrary {
	public static WebDriver driver;
	@BeforeMethod
	@Parameters({"browser","url"})
	public void setUp(String browser, String baseUrl){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver= new ChromeDriver();
			Reporter.log("chrome launched", true);
			
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("firefox launched", true);
		}
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@AfterClass
	public void tearDown(){
		
	}
	@AfterMethod
	public void afterCondition(ITestResult result){
		if(result.isSuccess()){
			Reporter.log("-----Script is passed-----", true);
		}
		else{
			Reporter.log("----Script is failed-----", true);
			String methodName=result.getMethod().getMethodName();
			ScreenshotLibrary sl= new ScreenshotLibrary(driver);
			//com.cins.generic.ScreenshotLibrary sl= new  com.cins.generic.ScreenshotLibrary(driver);
			sl.takeScreenShot(methodName);
			Reporter.log("Screen shot has been taken", true);
		}
//		driver.close();
//		Reporter.log("browser close", true);
	}

}
