package com.iotTesting.testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iotTesting.pageObjects.HomePage;

public class TC_EnterValue_001 extends BaseClass
{

	@Test
	public void dashboardTest() throws IOException
	{
		driver.get(BaseURL);
		logger.info("URL is opened");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		logger.info("Wait Time");
		HomePage lp=new HomePage(driver);
		lp.clickEmrgBtn();
		logger.info("Emergency Button - Clicked");
		lp.clickMenu();
		logger.info("Menu - Clicked");
		lp.clickFuelSystem();
		logger.info("System - Selected");
		lp.setEnterValue(evalue);
		logger.info("Value - entered");
		/*String actualTitle=driver.getTitle();
		System.out.println("Actual title" + actualTitle); */
		
		 if(driver.getTitle().equals("Node-RED Dashboard"))
				
			{
				Assert.assertTrue(true);
				logger.info("Dashboard test passed");
			}
			else
			{
				captureScreen(driver,"dashboardTest");
				Assert.assertTrue(false);
				logger.info("Dashboard test failed");
			}
		
			
	 
	}	
}
