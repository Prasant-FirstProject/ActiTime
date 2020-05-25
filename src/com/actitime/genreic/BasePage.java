package com.actitime.genreic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	public WebDriver driver;
	public BasePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//To Verify the Title
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try
		{
			//Simply
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching: "+eTitle, true);
		}
		catch(Exception e)
		{
			//Simply
			Reporter.log("Title is not matching: "+eTitle, true);
			Reporter.log("Actual title is: "+ driver.getTitle(), true);
			Assert.fail();
		}
	}
	
	//To verify the element
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present......", true);
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present.............", true);
			Assert.fail();
		}
	}
}
