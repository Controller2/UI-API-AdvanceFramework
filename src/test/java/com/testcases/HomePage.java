package com.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.DataProviderExcel;
import com.utility.DriverFactory;
import com.utility.SeleniumUtils;
import com.utility.TestBase;

import enumFactory.EnumXpathFactory;
import freemarker.core._MessageUtil;

//@Listeners(com.utility.ThreadSafeExtentReport.class) This can be  used when you do not add listener tag in your suiteXML file
public class HomePage extends TestBase {

	//This is the way to add dataProvider in any class dataProviderClass = DataProviderExcel.class,dataProvider = "testData"
	
	@Test(testName = "HomePage", description = "validating home page element", groups = {"Regression","Phase1","validateSearchBox"})
	public void validateHomePage()
	{
		try {
			
			SeleniumUtils.sendKeys(EnumXpathFactory.AMAZON_SEARCH_BOX.getValue(), "Iphone14 pro",Keys.ENTER);
			
		}


		catch(Exception e)
		{
              
		}


	}
	
	@Test(testName = "HomePage", description = "validating home page element", groups = {"Regression","Phase1","validate search box"})
	public void validateHomePage2()
	{
		try {
			
			SeleniumUtils.sendKeys(EnumXpathFactory.AMAZON_SEARCH_BOX.getValue(), "Office chairs",Keys.ENTER);
		}


		catch(Exception e)
		{
              
		}


	}

}
