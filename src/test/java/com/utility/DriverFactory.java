package com.utility;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	/*
	 * Singleton pattern- constructor has been declared "private", 
	 * so no other object can be create of this class.
	 */
	
	// DriverFactory df =new DriverFactory();
	private DriverFactory()
	{
		
	}
	
	/*
	 * Here we have created the instance of the class.
	 */
	private static DriverFactory instance = new DriverFactory();
	
	
	/*
	 * This method of "getInstance",can get the instance of this class in other classes.
	 */
	public static DriverFactory getInstance()
	{
		return instance;
	}
	
	
	/*
	 * Creating a thread safe driver, it is the provision for parallel testing.
	 */
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public void setDriver(WebDriver threadedDriver)
	{
		driver.set(threadedDriver);
	}
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public void closeBrowser()
	{
		driver.get().close();
		driver.remove();
		
		
	}
	
	
	


}
