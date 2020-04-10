package com.MarshPanel.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MarshPanel.PageObject.LoginPage;
import com.MarshPanel.PageObject.ProfilePage;
import com.MarshPanel.Utilities.XLUtils;

public class TC_ProfileTest_001 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		ProfilePage pp = new ProfilePage(driver);

		lp.setUserName(user);
		Logger.info("user name provided");

		lp.setPassword(pwd);
		Logger.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Employee Ensurer : Change Password")) {
			Assert.assertTrue(true);
			Logger.info("Login Test Passed - Change Password");
			pp.setOldPassword("test");
			Logger.info("Old Password provided");
			pp.setNewPassword("Test@123");
			Logger.info("New Password provided");
			pp.setConfirmPassword("Test@123");
			Logger.info("Confirm Password provided");
			pp.updatePassword();
			pp.redirectProfile();
			Thread.sleep(10000);

			if (driver.getTitle().equals("Employee Ensurer : Employee Profile")) {

				Logger.info("Login Test Passed - Profile Page");
				Assert.assertTrue(true);
				pp.setPersonalEmail(user + "m");
				Logger.info("Personal Email Provided");
				pp.setMobNo("0000000000");
				Logger.info("Mobile Number Provided");
				pp.setCityy("Mumbai");
				Logger.info("City Provided");
				Thread.sleep(4000);
				pp.setPinn("410206");
				Logger.info("Pin Code Provided");
				Thread.sleep(3000);
				pp.checkTerms();
				Logger.info("Terms & Condition checked");
				Thread.sleep(3000);
				pp.updateProfile();
				pp.redirectDashbaord();
				Thread.sleep(10000);
				if (driver.getTitle().equals("Employee Ensurer : TestDemoBenefits Center")) {
					Assert.assertTrue(true);
					Logger.info("Login Test Passed - Dashboard");
					lp.clickLogout();
				} else {
					Logger.info("Login Test Failed");
					captureScreen(driver, "loginTest");
					Assert.assertTrue(false);
					lp.clickLogout1();
				}
			} else if (driver.getTitle().equals("Employee Ensurer : TestDemoBenefits Center")) {
				Assert.assertTrue(true);
				Logger.info("Login Test Passed - Dashboard");
				lp.clickLogout();
			} else {
				Logger.info("Login Test Failed");
				captureScreen(driver, "loginTest");
				Assert.assertTrue(false);
			lp.clickLogout2();
			}
		} else if (driver.getTitle().equals("Employee Ensurer : Employee Profile")) {
			Logger.info("Login Test Passed - Profile Page");
			Assert.assertTrue(true);
			pp.setPersonalEmail(user + "m");
			Logger.info("Personal Email Provided");
			pp.setMobNo("0000000000");
			Logger.info("Mobile Number Provided");
			pp.setCityy("Mumbai");
			Logger.info("City Provided");
			Thread.sleep(5000);
			pp.setPinn("410206");
			Logger.info("Pin Code Provided");
			Thread.sleep(3000);
			pp.checkTerms();
			Logger.info("Terms & Condition checked");
			Thread.sleep(3000);
			pp.updateProfile();
			pp.redirectDashbaord();
			Thread.sleep(10000);
			if (driver.getTitle().equals("Employee Ensurer : TestDemoBenefits Center")) {
				Assert.assertTrue(true);
				Logger.info("Login Test Passed - Dashboard");
				lp.clickLogout();

			} else {
				Logger.info("Login Test Failed");
				captureScreen(driver, "loginTest");
				Assert.assertTrue(false);
				lp.clickLogout1();
			}
		} else if (driver.getTitle().equals("Employee Ensurer : TestDemoBenefits Center")) {
			Assert.assertTrue(true);
			Logger.info("Login Test Passed");
			lp.clickLogout();
		} else {
			Logger.info("Login Test Failed");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
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