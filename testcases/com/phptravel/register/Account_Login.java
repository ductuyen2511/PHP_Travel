package com.phptravel.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import commons.PageManagementObjects;
import commons.abtractTest;

public class Account_Login extends abtractTest{
  WebDriver driver;
  HomePageObject homePage;
  LoginPageObject loginPage;
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = runMultiBrowser(browserName);
	  homePage = PageManagementObjects.getHomePageObject(driver);
  }
  
  @Test
  public void TC_01_LoginToSystem() {
	  homePage.clickToMyAccountLink();
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputIntoEmailTextbox(Account_SignUp.EMAIL);
	  loginPage.inputIntoPasswordTextbox(Account_SignUp.PASSWORD);
	  loginPage.clickToLoginButton();
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
