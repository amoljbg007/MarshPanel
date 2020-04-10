package com.MarshPanel.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.MarshPanel.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig ReadConfig = new ReadConfig();
	public String baseURL = ReadConfig.getApplication();
	public String username = ReadConfig.getUsername();
	public String password = ReadConfig.getPassword();
	public static WebDriver driver;

	public static Logger Logger;

	@Parameters("browser")

	@BeforeClass
	public void setup(String br) {
		Logger = Logger.getLogger("MarshPanel");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ReadConfig.getChromePath());
			driver = new ChromeDriver();
			  driver.manage().window().maximize();
				
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ReadConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			  driver.manage().window().maximize();
				
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", ReadConfig.getIEPath());
			driver = new InternetExplorerDriver();
			  driver.manage().window().maximize();
				
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
}
