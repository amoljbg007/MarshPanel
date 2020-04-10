package com.MarshPanel.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MarshPanel.PageObject.LoginPage;
import com.MarshPanel.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
	lp.setUserName(user);
	Logger.info("user name provided");

	lp.setPassword(pwd);
	Logger.info("password provided");

	lp.clickSubmit();
	Thread.sleep(3000);
	

if(driver.getTitle().equals("Employee Ensurer : HereBenefits Center"))
{
	Assert.assertTrue(true);
	Logger.info("Login Test Passed");
	lp.clickLogout();
}
else
{	
	captureScreen(driver,"loginDDT");
	Assert.assertTrue(false);
	Logger.info("Login Test Failed");
}
}
	
	
	
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/MarshPanel/testData/LoginData.xlsx";
int rownum = XLUtils.getRowCount(path, "Sheet1");
int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

String logindata[][]=new String[rownum][colcount];
for (int i=1;i<=rownum;i++)
		
{
	for(int j=0;j<colcount;j++)
	{
		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);
		
	}
}
		return logindata;		
	}
}
