package com.iotTesting.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iotTesting.pageObjects.HomePage;
import com.iotTesting.utilities.XLUtils;

public class TC_DD_EnterValue_001 extends BaseClass
{
	
	@Test(dataProvider="FuelValue_data")
	public void dashboardDDT(String val) throws InterruptedException
	{
		logger.info("Welcome Dashboard");
		Thread.sleep(5000);
		//logger.info("Wait Time");
		HomePage hp=new HomePage(driver);
//		hp.clickEmrgBtn();
//		logger.info("Emergency Button - Clicked");
		hp.clickMenu();
		logger.info("Menu - Clicked");
		hp.clickFuelSystem();
		Thread.sleep(1000);
		logger.info("System - Selected");
		Thread.sleep(1000);
		hp.setEnterValue(val);
		logger.info("Fuel value entered: " +val+" units");
		Thread.sleep(5000);
		
		
	}
		
	@DataProvider(name="FuelValue_data")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/iotTesting/testData/FuelValue_data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		
		String evaluedata[][]=new String[rownum][1];
		
		for(int i=1;i<=rownum;i++)
		{
			{
				evaluedata[i-1][0]=XLUtils.getCellData(path,"Sheet1", i,0);//1 0
			}
				
		}
	return evaluedata;
	}
	
}