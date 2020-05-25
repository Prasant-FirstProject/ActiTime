package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.genreic.BaseTest;
import com.actitime.genreic.ExcelData;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void testValidLoginLogout()
	{
		String username = ExcelData.getData(file_path, "TC01", 1, 0);
		String password = ExcelData.getData(file_path, "TC01", 1, 1);
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String enterTimeTrack = ExcelData.getData(file_path, "TC01", 1, 3);
		
		LoginPage loginPage = new LoginPage(driver);
		
		//To verify the user name
		loginPage.verifyPage(loginTitle);
		
		//Enter valid user name
		Reporter.log("valid username: "+username, true);
		loginPage.enterUserName(username);
		
		//Enter valid password
		Reporter.log("valid password: "+password, true);
		loginPage.enterPassword(password);
		
		//Click on login button
		Reporter.log("Click on Login button");
		loginPage.clickOnLoginButton();
		
		//To verify the enter time Track page
		loginPage.verifyPage(enterTimeTrack);
	}
}
