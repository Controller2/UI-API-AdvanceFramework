package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ThreadSafeExtentReportInstance {
	
	private ThreadSafeExtentReportInstance()
	{
		
	}
	
	private static ThreadSafeExtentReportInstance instance= new ThreadSafeExtentReportInstance();
	
	public static ThreadSafeExtentReportInstance getExtentInstance()
	{
		return instance;
	}
	
	private static ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getExtent()
	{
		return extent.get();
	}
	
	public void setExtent(ExtentTest extentTestObj)
	{
		extent.set(extentTestObj);
	}
	
	public void removeExtent()
	{
		extent.remove();
	}

}
