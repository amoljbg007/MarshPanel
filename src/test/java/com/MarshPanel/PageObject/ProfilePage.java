package com.MarshPanel.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

WebDriver ldriver;
public ProfilePage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(name="txtOpwd")
@CacheLookup
WebElement txtOpwd;

@FindBy(name="txtNpwd")
@CacheLookup
WebElement txtNpwd;

@FindBy(name="txtNCpwd")
@CacheLookup
WebElement txtNCpwd;


@FindBy(name="imgBtnSbmt")
@CacheLookup
WebElement imgBtnSbmt;

@FindBy(xpath="//div[@id='toast-container']/div/div/a/b")
@CacheLookup
WebElement click1;


@FindBy(name="txtEml")
@CacheLookup
WebElement txtEml;

@FindBy(name="txtMob1")
@CacheLookup
WebElement txtMob1;


@FindBy(id="txtCity")
@CacheLookup
WebElement txtCity;

@FindBy(name="txtPin")
@CacheLookup
WebElement txtPin;

@FindBy(xpath="//div[@id='updateprofile']/div[2]/div[10]/div/label")
@CacheLookup
WebElement terms_condtn;

@FindBy(xpath="//*[@id=\'imgBtnSbmt\']")
@CacheLookup
WebElement imgBtnSbmt1;

@FindBy(xpath="//div[@id='toast-container']/div/div/a/b")
@CacheLookup
WebElement click2;


@FindBy(xpath = "//*[@id='ctlUsrInfo_Logout']/img")
@CacheLookup
WebElement lnkLogout;


















public void setOldPassword(String Opwd)
{
	txtOpwd.sendKeys(Opwd);
}

public void setNewPassword(String Npwd)
{
	txtNpwd.sendKeys(Npwd);
}


public void setConfirmPassword(String NCpwd)
{
	txtNCpwd.sendKeys(NCpwd);
}


public void updatePassword()
{
	imgBtnSbmt.click();
}

public void redirectProfile()
{
	click1.click();
}



public void setPersonalEmail(String Eml)
{
	txtEml.sendKeys(Eml);
}

public void setMobNo(String Mob)
{
	txtMob1.sendKeys(Mob);
}

public void setCityy(String City)
{
	
	txtCity.sendKeys(City);
}

public void setPinn(String Pin)
{
	txtPin.sendKeys(Pin);
}

public void checkTerms()
{
	terms_condtn.click();
}

public void updateProfile()
{
imgBtnSbmt1.click();
}


public void redirectDashbaord()
{
	click2.click();
}

public void clickLogout()
{
lnkLogout.click();
}
}