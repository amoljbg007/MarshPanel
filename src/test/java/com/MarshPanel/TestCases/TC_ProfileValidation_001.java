package com.MarshPanel.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MarshPanel.PageObject.LoginPage;
import com.MarshPanel.PageObject.ProfilePage;
import com.MarshPanel.Utilities.XLUtils;

public class TC_ProfileValidation_001 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void ProVal(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
	lp.setUserName(user);
	Logger.info("username provided");
	
	lp.setPassword(pwd);
	Logger.info("password provided");
	lp.clickSubmit();
	Thread.sleep(3000);
	
	}
	
	@Test
	public void chapwd()
	{
	ProfilePage pp=new ProfilePage(driver);
	pp.setOldPassword("test");
	Logger.info("Old Password provided");
	pp.setNewPassword("Test@123");
	Logger.info("New Password provided");
	pp.setConfirmPassword("Test@123");
	Logger.info("Confirm Password provided");
	pp.updatePassword();

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