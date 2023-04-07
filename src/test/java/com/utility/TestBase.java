package com.utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	
	BrowserFactory browser = new BrowserFactory();
	
	
	@BeforeMethod
	@Parameters({"Browser","Environment"})
	
	public void launchApplication(@Optional String name, String environment) throws IOException, InterruptedException
	{
		DriverFactory.getInstance().setDriver(browser.createBrowserInstance(name));
		
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.get(ConfigReader.propertiesObject().getProperty(environment));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
		driver.manage().deleteAllCookies();
		
		Thread.sleep(5000);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		DriverFactory.getInstance().closeBrowser();
	}

}
