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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.MarshPanel.Utilities.ReadConfig;

public class TC_ForgotPassword_001 {
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
		driver.findElement(By.xpath("//*[@id=\'tabs-3\']/div[4]/div[3]/div[2]/a")).click();
		Logger.info("Forgot Password Option selected");
		Thread.sleep(2000);
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with email id blank");

			if (driver.getPageSource().contains("Please enter valid Email ID.")) {
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

	@Test(description = "Click PROCEED button with employee id blank")
	public void forgotpassword2() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("Test@test.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with employee id blank");
			if (driver.getPageSource().contains("Please a valid Employee ID.")) {
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

	@Test(description = "Click PROCEED button with DOB blank")
	public void forgotpassword3() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("Test@test.com");
			driver.findElement(By.xpath("//*[@id=\'TextBoxLoginId\']")).sendKeys("test");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with DOB blank");
			if (driver.getPageSource().contains("Please enter a valid Date of Birth.")) {
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

	@Test(description = "Click PROCEED button with incorrect Email format")
	public void forgotpassword4() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("Testfvavasvavs");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with email id format invalid");
			if (driver.getPageSource().contains("Please valid Email ID")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);

			} else {
				Logger.info("Invalid error message display - Test Failed");

				captureScreen(driver, "forgotpassword4");

				Assert.assertTrue(false);

			}

		} else {
			Logger.info("Invalid error message display - Test Failed");

			captureScreen(driver, "forgotpassword4");

			Assert.assertTrue(false);
		}
	}

	@Test(description = "Click PROCEED button with incorrect DOB format")
	public void forgotpassword5() throws InterruptedException, IOException {
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("test@123.com");
			driver.findElement(By.xpath("//*[@id='TextBoxDOB']")).sendKeys("0101");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with DOB invalid format");
			if (driver.getPageSource().contains("Please enter a valid Date of Birth.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword5");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword5");
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Click PROCEED button with wrong email id")
	public void forgotpassword6() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"ButtonBack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\'tabs-3\']/div[4]/div[3]/div[2]/a")).click();
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("test@123.com");
			driver.findElement(By.xpath("//*[@id=\'TextBoxLoginId\']")).sendKeys("TeDe1");
			driver.findElement(By.xpath("//*[@id='TextBoxDOB']")).sendKeys("01011991");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with email ID");
			if (driver.getPageSource()
					.contains("Email ID mentioned has not been registered. Please enter valid Email ID.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword6");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword6");
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Click PROCEED button with wrong employee id")
	public void forgotpassword7() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"ButtonBack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\'tabs-3\']/div[4]/div[3]/div[2]/a")).click();
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("TeDe1@gm.com");
			driver.findElement(By.xpath("//*[@id=\'TextBoxLoginId\']")).sendKeys("demoTeDe1");
			driver.findElement(By.xpath("//*[@id='TextBoxDOB']")).sendKeys("01011991");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with wrong employee ID");
			if (driver.getPageSource().contains("Please enter valid Employee No.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword7");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword7");
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Click PROCEED button with wrong DOB")
	public void forgotpassword8() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"ButtonBack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\'tabs-3\']/div[4]/div[3]/div[2]/a")).click();
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("TeDe1@gm.com");
			driver.findElement(By.xpath("//*[@id=\'TextBoxLoginId\']")).sendKeys("TeDe1");
			driver.findElement(By.xpath("//*[@id='TextBoxDOB']")).sendKeys("01011991");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with wrong DOB");
			if (driver.getPageSource().contains("Please enter valid Date of Birth.")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword8");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword8");
			Assert.assertTrue(false);
		}
	}


	@Test(description = "Click PROCEED button with Valid Employee Details")
	public void forgotpassword9() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"ButtonBack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\'tabs-3\']/div[4]/div[3]/div[2]/a")).click();
		if (driver.getTitle().equals("Employee Ensurer : Forgot Password")) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).clear();
			driver.findElement(By.xpath("//*[@id='TextBoxEmailId']")).sendKeys("TeDe1@gm.com");
			driver.findElement(By.xpath("//*[@id=\'TextBoxLoginId\']")).sendKeys("TeDe1");
			driver.findElement(By.xpath("//*[@id='TextBoxDOB']")).sendKeys("24111981");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'ButtonProcess\']")).click();
			Logger.info("Proceed button click with valid Details");
			if (driver.getPageSource().contains("Email triggered successfully")) {
				Logger.info("Valid error message display - Test Passed");
				Assert.assertTrue(true);
			} else {
				Logger.info("Invalid error message display - Test Failed");
				captureScreen(driver, "forgotpassword9");
				Assert.assertTrue(false);
			}

		} else {
			Logger.info("Invalid error message display - Test Failed");
			captureScreen(driver, "forgotpassword9");
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