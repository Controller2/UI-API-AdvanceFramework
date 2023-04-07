package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports setUpExtentReport()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport"+actualDate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("com.amazon.testcase.execution.report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("com.testcase.execution.report");
		
		return extent;
	}

}
