package com.iotTesting.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy(xpath="//span[contains(text(),'Emergency button')]")
	
	@FindBy(xpath="//div[@id='Emergency_System_Alarm_cards']//md-card//button")
	WebElement emergencyBtn;
	
	@FindBy(xpath="//div[@id='nr-dashboard-toolbar']//button//ng-md-icon")
	WebElement menuIcon;
	
	@FindBy(xpath="//md-list-item[2]//div[1]//button[1]")
	WebElement fuelSystem;
	
	@FindBy(xpath="//input[@id='input_0']")
	WebElement txtEnterValue;
		
	
	public void clickEmrgBtn()
	{
		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		emergencyBtn.click();
	}
	
	public void clickMenu()
	{
		menuIcon.click();
	}
	
	public void clickFuelSystem()
	{
		Actions actions = new Actions(ldriver);
		actions.moveToElement(fuelSystem).click().perform();
		
	}
	
	
	public void setEnterValue(String evalue)
	{
		txtEnterValue.sendKeys(evalue);
	}
	
	public String getTxtValue(String txtval)
	{
		txtval = txtEnterValue.getAttribute("value");
		return txtval;
	}
}
