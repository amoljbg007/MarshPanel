package com.MarshPanel.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.MarshPanel.Utilities.ReadConfig;
import com.google.inject.spi.Elements;

public class TC_ForgotPassword_002_OTP {
	ReadConfig ReadConfig = new ReadConfig();
	public String chromepath = ReadConfig.getChromePath();
	public String baseURL = ReadConfig.getApplication();
	public String OTP = ReadConfig.getOTP();
	public static WebDriver driver;

	public static Logger Logger;

	@Test(priority =1,description = "Click forgot password link")

	public void forgotpassword0() throws InterruptedException, IOException {

		Logger = Logger.getLogger("MarshPanel");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		Logger.info("URL open");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"divOffEmail\"]/div[4]/a")).click();
		Logger.info("Forgot Password Option selected");
		Thread.sleep(2000);
	}

	@Test(priority =2,description = "Click PROCEED button with email id blank")

	public void forgotpassword1() throws InterruptedException, IOException {

		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"ButtonProcessOTP\"]")).click();
			Logger.info("Proceed button click with email id blank");

			if (driver.getPageSource().contains("Please enter a valid Official Email ID.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);

			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword1");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");

			captureScreen(driver, "forgotpassword1");
			Assert.assertTrue(false);

		}
	}

	@Test(priority =3,description = "Click PROCEED button with incorrect Email format")
	public void forgotpassword2() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).sendKeys("Testfvavasvavs");
			Logger.info("Official email ID entered with incorrect format");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ButtonProcessOTP\"]")).click();
			Logger.info("Proceed button click with email id format invalid");
			if (driver.getPageSource().contains("Please enter a valid Official Email ID.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);

			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword2");
				Assert.assertTrue(false);

			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword2");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =4,description = "Click PROCEED button with wrong email id")
	public void forgotpassword3() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).sendKeys("test@123.com");
			Logger.info("Worng Official Email ID entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ButtonProcessOTP\"]")).click();
			Logger.info("Proceed button click with wrong email ID");
			if (driver.getPageSource()
					.contains("Email ID mentioned has not been registered. Please enter valid Email ID.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword3");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword3");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =5,description = "Click PROCEED button with Valid Employee Details")
	public void forgotpassword4() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).sendKeys("TeDe58@gm.com");
			Logger.info("Official Email ID entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ButtonProcessOTP\"]")).click();
			Logger.info("Proceed button click with valid Details");
			if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
				Logger.info("User Information page display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword4");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword4");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =6,description = "Verify User information")
	public void forgotpassword5() {
		String OE = driver.findElement(By.xpath("//*[@id=\"divUserInfo\"]/div/div[1]/span")).getText();
		String PE = driver.findElement(By.xpath("//*[@id=\"lblPerEmailId\"]")).getText();
		String MOB = driver.findElement(By.xpath("//*[@id=\"lblMobNo\"]")).getText();
		Logger.info("Official Email ID is - " + OE);
		Logger.info("Personal Email id is - " + PE);
		Logger.info("Mobile number is - " + MOB);
	}

	@Test(priority =7,description = "Click Generate OTP button without click checkbox")
	public void forgotpassword6() throws InterruptedException, IOException {
Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"btnGenOTP\"]")).click();
			Logger.info("Generate OTP button click");
			if (driver.getPageSource().contains("OTP sent successfully.")) {
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword6");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword6");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =8,description = "Click Submit button option without entered OTP")
	public void forgotpassword7() throws InterruptedException, IOException {
		Thread.sleep(2000);		
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"btnOtpVerify\"]")).click();
			Logger.info("Submit button click with all the fields blank");
			if (driver.getPageSource().contains("Please enter the OTP.")) {
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword7");
				Assert.assertTrue(false);
			}

		} else

		{
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword7");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =9,description = "Click Submit button option without entered new password")
	public void forgotpassword8() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id='txtEnterOTP']")).sendKeys(OTP);
			Logger.info("Invalid OTP entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnOtpVerify\"]")).click();
			Logger.info("Submit button click without new password");
			if (driver.getPageSource().contains("Please enter the New Password.")) {
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword8");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword8");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =10,description = "Click Submit button option without entered Confirm Password")
	public void forgotpassword9() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"txtNpwd\"]")).sendKeys("Test@1234");
			Logger.info("New password entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnOtpVerify\"]")).click();
			Logger.info("Submit button click without confirm password");
			if (driver.getPageSource().contains("Please confirm the New Password."))

			{
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword9");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword9");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =11, description = "Click Submit button option with diff new and confirm password")
	public void forgotpassword10() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"txtNpwd\"]")).sendKeys("Test@1234");
			Logger.info("New password entered");
			driver.findElement(By.xpath("//*[@id=\"txtNCpwd\"]")).sendKeys("Test@12345");
			Logger.info("Diff confirm password entered");
				Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnOtpVerify\"]")).click();
			Logger.info("Submit button click with diff new and confirm password");
			if (driver.getPageSource().contains("New Password and Confirm Password fields should be identical."))
			{
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword10");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword10");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =12,description = "Click Submit button option with invalid OTP")
	public void forgotpassword11() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id='txtEnterOTP']")).clear();
			driver.findElement(By.xpath("//*[@id='txtEnterOTP']")).sendKeys(OTP);
			Logger.info("OTP entered");
			driver.findElement(By.xpath("//*[@id=\"txtNpwd\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtNpwd\"]")).sendKeys("Test@1234");
			Logger.info("New Password entered");
			driver.findElement(By.xpath("//*[@id=\"txtNCpwd\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtNCpwd\"]")).sendKeys("Test@1234");
			Logger.info("Confirm Password entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnOtpVerify\"]")).click();
			Logger.info("Submit button click");
			if (driver.getPageSource().contains("Please enter valid OTP.")) {
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword11");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword11");
			Assert.assertTrue(false);
		}
	}

	@Test(priority =13,description = "Click Submit button option With valid OTP and password Details")
	public void forgotpassword12() throws InterruptedException, IOException {
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id='txtEnterOTP']")).clear();
			driver.findElement(By.xpath("//*[@id='txtEnterOTP']")).sendKeys(OTP);
			Logger.info("OTP entered");
			driver.findElement(By.xpath("//*[@id=\"txtNpwd\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtNpwd\"]")).sendKeys("Test@1234");
			Logger.info("New Password entered");
			driver.findElement(By.xpath("//*[@id=\"txtNCpwd\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtNCpwd\"]")).sendKeys("Test@1234");
			Logger.info("Confirm Password entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnOtpVerify\"]")).click();
			Logger.info("Submit button click");
			if (driver.getPageSource().contains("Password Reset Successfully.")) {
				Logger.info("Valid message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message/Page display - Test Failed");
				captureScreen(driver, "forgotpassword12");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message/Page display - Test Failed");
			captureScreen(driver, "forgotpassword12");
			Assert.assertTrue(false);
		}
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

}
