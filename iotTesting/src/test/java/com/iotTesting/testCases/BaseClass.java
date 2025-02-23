package com.iotTesting.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iotTesting.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String BaseURL=readconfig.getApplicationURL();
	public String evalue=readconfig.getValue();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger=Logger.getLogger("iotTesting");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();	
		}
		else if(br.equals("ie"))
		{
			logger=Logger.getLogger("IE pass");
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			
//			 DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//			 caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
//			  driver = new InternetExplorerDriver(caps);
		}
		
		Thread.sleep(5000);
		driver.get(BaseURL);
		driver.manage().window().maximize();//Maximizes the browser window
	
		
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("System Close ");
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
