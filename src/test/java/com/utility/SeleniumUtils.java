package com.utility;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumUtils {


	public static void screenShot(String name) throws Throwable

	{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		String path= System.getProperty("user.dir")+"/ScreenShots/"+System.currentTimeMillis()+name+".jpg";
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);


	}

	public static String getScreenshotAsBase64()

	{   WebDriver driver = DriverFactory.getInstance().getDriver();
	return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

	}

	public static void shiftingToWindows(int id)
	{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> itr = allids.iterator();
		ArrayList<String> ids =new ArrayList<String>();
		while(itr.hasNext())
		{
			ids.add(itr.next());


		}
		driver.switchTo().window(ids.get(id));
	}

	public static void wait(int time)
	{
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public static void click(String element)
	{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		driver.findElement(By.xpath(element)).click();
	}

	public static void sendKeys(String element, String sendValue, Keys keys) {

		WebDriver driver=DriverFactory.getInstance().getDriver();
		driver.findElement(By.xpath(element)).sendKeys(sendValue,keys );
	}

	public static void scrollToSpecoficelement(WebElement element)
	{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		scroll.executeScript("arguments[0].scrollIntoView(true)", element);


	}

	public static void moveToElement(WebElement element)
	{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}

	public static void dragAndDrop(WebElement element, WebElement element2)
	{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element2).build().perform();
	}
	
	public static void isDisplayed(String element)
	{
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.findElement(By.xpath(element)).isDisplayed();
		
	}




}
