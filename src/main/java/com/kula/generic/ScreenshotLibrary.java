package com.kula.generic;

import java.io.*;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotLibrary {
	
WebDriver driver;
	
	public ScreenshotLibrary(WebDriver driver){
		this.driver=driver;
	}
		public void takeScreenShot(String methodName){
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src =ts.getScreenshotAs(OutputType.FILE);
			//File src= ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("./screenshots/"+methodName+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

}
