package com.MarshPanel.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MarshPanel.PageObject.LoginPage;
import com.MarshPanel.Utilities.XLUtils;

public class TC_Dashboard_001 extends BaseClass {

	@Test(dataProvider = "LoginData")//Login Logout check
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		Logger.info("user name provided");

		lp.setPassword(pwd);
		Logger.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);
		lp.clickLogout();
driver.get(baseURL);
	}

	@Test(dataProvider = "LoginData")//check message button
	public void loginTest1(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		Logger.info("user name provided");

		lp.setPassword(pwd);
		Logger.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='form1']/header[2]/div/div/div[1]/div[2]/div[3]/ul/li[2]/a/img")).click();

	driver.findElement(By.xpath("//*[@id=\'form1\']/header[2]/div/div/div[1]/div[2]/div[3]/ul/li[1]/a/img")).click();

	lp.clickLogout();
	}	

	@Test(dataProvider = "LoginData")//check message button
	public void loginTest2(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		Logger.info("user name provided");

		lp.setPassword(pwd);
		Logger.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\'mySidenav\']/ul/li[4]/ul/li[1]/a")).click();

	driver.findElement(By.xpath("//*[@id=\'form1\']/header[2]/div/div/div[1]/div[2]/div[3]/ul/li[1]/a/img")).click();
	
	lp.clickLogout();
	}	

		
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/MarshPanel/TestData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}