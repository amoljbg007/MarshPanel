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
	public static WebDriver driver;
	
	public static Logger Logger;

	@Test(description = "Click PROCEED button with email id blank")

	public void forgotpassword1() throws InterruptedException, IOException {

		Logger = Logger.getLogger("MarshPanel");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\Ashwini\\eclipse-workspace\\MarshPanel_V1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://202.46.202.33:100/TestDemo-insurance-partners/Forms/login.aspx");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"divOffEmail\"]/div[4]/a")).click();
		Logger.info("Forgot Password Option selected");
		Thread.sleep(2000);
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

	@Test(description = "Click PROCEED button with incorrect Email format")
	public void forgotpassword2() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).sendKeys("Testfvavasvavs");
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

	@Test(description = "Click PROCEED button with wrong email id")
	public void forgotpassword3() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).sendKeys("test@123.com");
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

	@Test(description = "Click PROCEED button with Valid Employee Details")
	public void forgotpassword4() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"txtOffEmailId\"]")).sendKeys("TeDe58@gm.com");
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

	
	
	@Test(description = "Verify User information")
    public void forgotpassword5() {
		String OE = driver.findElement(By.xpath("//*[@id=\"divUserInfo\"]/div/div[1]/span")).getText();
		
		String PE = driver.findElement(By.xpath("//*[@id=\"lblPerEmailId\"]")).getText();
		
		String MOB = driver.findElement(By.xpath("//*[@id=\"lblMobNo\"]")).getText();
		
		Logger.info("Official Email ID is - "+OE);
		Logger.info("Personal Email id is - "+PE);
		Logger.info("Mobile number is - "+MOB);
    }


	@Test(description = "Click Generate OTP button without click checkbox")
	public void forgotpassword6() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
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
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
}