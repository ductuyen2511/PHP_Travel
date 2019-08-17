package com.phptravel.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.AccountPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.SignUpPageObject;
import commons.PageManagementObjects;
import commons.abtractTest;

public class Account_LoginToSystem extends abtractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	SignUpPageObject signupPage;
	AccountPageObject accountPage;

	String firstName = "Le Duc";
	String lastName = "Tuyen";
	String email = "ductuyen" + RandomEmail() + "@gmail.com";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = runMultiBrowser(browserName);
		homePage = PageManagementObjects.getHomePageObject(driver);
	}

	@Test
	public void TC_01_InputEmptyAllFields() {
		homePage.clickToMyAccountLink();
		signupPage = homePage.clickToSignUpLink();
		Assert.assertTrue(signupPage.isSignUpFormDisPlay());

		signupPage.clickToSubmitButtonSignUp();
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The Email field is required."), "The Email field is required.");
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The Password field is required."), "The Password field is required.");
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The Password field is required."), "The Password field is required.");
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The First name field is required."), "The First name field is required.");
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The Last Name field is required."), "The Last Name field is required.");
	}
	
	@Test
	public void TC_06_InputEmiWithinAt() {
		signupPage.sendkeyToSignUpTextbox(firstName, "firstname");
		signupPage.sendkeyToSignUpTextbox(lastName, "lastname");
		signupPage.sendkeyToSignUpTextbox("0909181818", "phone");
		signupPage.sendkeyToSignUpTextbox("abcabc", "email");
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("123456789", "confirmpassword");
		
		signupPage.clickToSubmitButtonSignUp();
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The Email field must contain a valid email address."), "The Email field must contain a valid email address.");
	}

	@Test
	public void TC_09_InputPasswordLessThanSixDigits() {
		signupPage.ClearToDynamicTextboxSignUpPage("email");
		signupPage.ClearToDynamicTextboxSignUpPage("password");
		signupPage.ClearToDynamicTextboxSignUpPage("confirmpassword");
		
		signupPage.sendkeyToSignUpTextbox(email, "email");
		signupPage.sendkeyToSignUpTextbox("123", "password");
		signupPage.sendkeyToSignUpTextbox("123", "confirmpassword");
		
		signupPage.clickToSubmitButtonSignUp();
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("The Password field must be at least 6 characters in length."), "The Password field must be at least 6 characters in length.");
	}
	
	@Test
	public void TC_10_InputPasswordNotSame() {
		signupPage.ClearToDynamicTextboxSignUpPage("password");
		signupPage.ClearToDynamicTextboxSignUpPage("confirmpassword");
		
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("12345", "confirmpassword");
		
		signupPage.clickToSubmitButtonSignUp();
		
		Assert.assertEquals(signupPage.GetErrorMessageSignUpPage("Password not matching with confirm password."), "Password not matching with confirm password.");
	}
	
	@Test
	public void TC_11_RegisterAccountSuccess() {
		signupPage.ClearToDynamicTextboxSignUpPage("password");
		signupPage.ClearToDynamicTextboxSignUpPage("confirmpassword");
		
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("123456789", "confirmpassword");
		accountPage = signupPage.clickToSubmitButtonSignUp();

		Assert.assertEquals(accountPage.isNameCustomerDisplay(), "Hi, " + firstName + " " + lastName);
		Assert.assertTrue(accountPage.isBookingStatusDisplay("Nothing Booked Yet"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
