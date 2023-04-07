package com.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.internal.TestNamesMatcher;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;





public class ThreadSafeExtentReport implements ITestListener{
	
	static ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getMethod().getMethodName());
		ThreadSafeExtentReportInstance.getExtentInstance().setExtent(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		ThreadSafeExtentReportInstance.getExtentInstance().getExtent().pass("Test case passed"+"==>"+result.getMethod().getMethodName(), 
				MediaEntityBuilder.createScreenCaptureFromBase64String(SeleniumUtils.getScreenshotAsBase64()).build());
		ThreadSafeExtentReportInstance.getExtentInstance().removeExtent();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ThreadSafeExtentReportInstance.getExtentInstance().getExtent().fail("Test case failed"+"==>"+result.getMethod().getMethodName(), 
				MediaEntityBuilder.createScreenCaptureFromBase64String(SeleniumUtils.getScreenshotAsBase64()).build());
		ThreadSafeExtentReportInstance.getExtentInstance().removeExtent();
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ThreadSafeExtentReportInstance.getExtentInstance().getExtent().skip("Test case skipped"+"==>"+result.getMethod().getMethodName(), 
				MediaEntityBuilder.createScreenCaptureFromBase64String(SeleniumUtils.getScreenshotAsBase64()).build());
		ThreadSafeExtentReportInstance.getExtentInstance().removeExtent();
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
		report = ExtentReportNG.setUpExtentReport();
		
		}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}
	
	

}
