package com.kula.testscripts;

import org.testng.annotations.Test;

import com.kula.generic.BaseLibrary;
import com.kula.generic.ExcelUtilities;
import com.kula.generic.WebdriverCommonLibrary;
import com.kula.pageobject.HubSpotMainPage;
import com.kula.pageobject.LandingPage;
import com.kula.pageobject.LoginPage;
import com.kula.pageobject.MarketingHubPage;
import com.kula.pageobject.SalesHubPage;
import com.kula.pageobject.ServiceHubPage;
public class TestHarness extends BaseLibrary{
	WebdriverCommonLibrary wcl=new WebdriverCommonLibrary(driver);
//	@Test
//	public void validLogin(){
//		LandingPage lanPage= new LandingPage(driver);
//		lanPage.clickOnSignIn();
//		LoginPage lp=new LoginPage(driver);
//		String filepath="./testData/testdata.xlsx";
//		String username= ExcelUtilities.readData(filepath, "Sheet1", 1, 1);
//		String pwd= ExcelUtilities.readData(filepath, "Sheet1", 1, 2);
//		lp.setUserName(username);
//		lp.setPassword(pwd);
//		lp.clickSubmit();
//		lanPage.verifyLandingPage();
//	}
	@Test
	public void goToMarketingHub() {
		HubSpotMainPage hubSpot= new HubSpotMainPage(driver);
		hubSpot.clickOnMarketingHubLearnMoreButton();
		MarketingHubPage markethub= new MarketingHubPage(driver);
		markethub.verifyPageTitle(driver.getTitle());
		
	}

	@Test
	public void goToSalesHub() {
		HubSpotMainPage hubSpot= new HubSpotMainPage(driver);
		hubSpot.clickOnSalesHubLearnMoreButton();
		SalesHubPage shp = new SalesHubPage(driver);
		shp.verifyPageTitle(driver.getTitle());
		
	}
	
	@Test
	public void goToServiceHub() {
		HubSpotMainPage hubSpot= new HubSpotMainPage(driver);
		hubSpot.clickOnServiceHubLearnMoreButton();
		ServiceHubPage service = new ServiceHubPage(driver);
		service.verifyPageTitle(driver.getTitle()); 
		
	}

	

}
