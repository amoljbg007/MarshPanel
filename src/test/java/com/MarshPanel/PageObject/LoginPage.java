package com.MarshPanel.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="txtLogin")
	@CacheLookup
	WebElement txtLogin;
	
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="ibtnLogin")
	@CacheLookup
	WebElement ibtnLogin;
	
	@FindBy(xpath = "//*[@id='ctlUsrInfo_Logout']/img")
	@CacheLookup
	WebElement lnkLogout; //dashboard page logout
	
	@FindBy(xpath = "//*[@id=\"ctl27_Logout\"]/img")
	@CacheLookup
	WebElement lnkLogout1; //profile page logout
	
	@FindBy(xpath = "//*[@id=\'ctl12_Logout\']/img")
	@CacheLookup
	WebElement lnkLogout2;  ///change password page logout
	
	
	
	public void setUserName(String uname)
	{
		txtLogin.clear();
		txtLogin.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		ibtnLogin.click();
	}

	public void clickLogout()
{
	lnkLogout.click();
	
}
	public void clickLogout1()
	{
		lnkLogout1.click();
	}
	public void clickLogout2()
	{
		lnkLogout2.click();
	}
}


