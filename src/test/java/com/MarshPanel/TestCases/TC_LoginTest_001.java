package com.MarshPanel.TestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MarshPanel.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{

@Test
public void logintest() throws IOException
{
	
	Logger.info("URL is Opened");
	
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(username);
	Logger.info("Entered Username");

	lp.setPassword(password);
	Logger.info("Entered Password");

	lp.clickSubmit();

if(driver.getTitle().equals("Employee Ensurer : HereBenefits Center"))
{
	Assert.assertTrue(true);
	Logger.info("Login Test Passed");
	lp.clickLogout();
}
else
{	
	captureScreen(driver,"logintest");
	Assert.assertTrue(false);
	Logger.info("Login Test Failed");
}
}
}