package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;



public class BrowserFactory {
	
	
	public static WebDriver createBrowserInstance(String browser)
	{
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
			
			driver=new ChromeDriver(options);
		}
		
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			
			 driver=new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			
			 driver=new FirefoxDriver();
		}
		
		return driver;
	}

}
