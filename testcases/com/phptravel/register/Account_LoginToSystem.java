package com.phptravel.register;

import org.openqa.selenium.WebDriver;
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
		System.out.println("driver testcase layer :" + driver.toString());
	}

	@Test
	public void TC_01_InputEmptyAllFields() {
		log.info("SIGN UP - STEP 01 : Click To My Account Link");
		homePage.clickToMyAccountLink();
		
		log.info("SIGN UP - STEP 02 : Click To Sign Up Link");
		signupPage = homePage.clickToSignUpLink();
		
		log.info("SIGN UP - STEP 03 : Verify Sign up form is displayed");
		verifyTrue(signupPage.isSignUpFormDisPlay());

		log.info("SIGN UP - STEP 04 : Click To Sign Up button");
		signupPage.clickToSubmitButtonSignUp();
		
		log.info("SIGN UP - STEP 05 : Verify empty allfield");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Email field is required."), "The Email field is required.");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Password field is required."), "The Password field is required.");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Password field is required."), "The Password field is required.");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The First name field is required."), "The First name field is required.");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Last Name field is required."), "The Last Name field is required.");
	}
	
	@Test
	public void TC_02_InputEmailWithinAt() {
		log.info("SIGN UP - STEP 01 : Input invalid email");
		signupPage.sendkeyToSignUpTextbox(firstName, "firstname");
		signupPage.sendkeyToSignUpTextbox(lastName, "lastname");
		signupPage.sendkeyToSignUpTextbox("0909181818", "phone");
		signupPage.sendkeyToSignUpTextbox("abcabc", "email");
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("123456789", "confirmpassword");
		
		log.info("SIGN UP - STEP 02 : Click to Sign up button");
		signupPage.clickToSubmitButtonSignUp();
		
		log.info("SIGN UP - STEP 02 : Verify invalid email message");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Email field must contain a valid email address."), "The Email field must contain a valid email address.");
	}

	@Test
	public void TC_03_InputPasswordLessThanSixDigits() {
		log.info("SIGN UP - STEP 01 : Clear textbox ");
		signupPage.ClearToDynamicTextboxSignUpPage("email");
		signupPage.ClearToDynamicTextboxSignUpPage("password");
		signupPage.ClearToDynamicTextboxSignUpPage("confirmpassword");
		
		log.info("SIGN UP - STEP 02 : Input password less than 6 characters");
		signupPage.sendkeyToSignUpTextbox(email, "email");
		signupPage.sendkeyToSignUpTextbox("123", "password");
		signupPage.sendkeyToSignUpTextbox("123", "confirmpassword");
		
		log.info("SIGN UP - STEP 03 : Click to Sign up button");
		signupPage.clickToSubmitButtonSignUp();
		
		log.info("SIGN UP - STEP 04 : Varify password message");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Password field must be at least 6 characters in length."), "The Password field must be at least 6 characters in length.");
	}
	
	@Test
	public void TC_04_InputPasswordNotSame() {
		log.info("SIGN UP - STEP 01 : Clear textbox");
		signupPage.ClearToDynamicTextboxSignUpPage("password");
		signupPage.ClearToDynamicTextboxSignUpPage("confirmpassword");
		
		log.info("SIGN UP - STEP 02 : Input password and confirm password not same");
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("12345", "confirmpassword");
		
		log.info("SIGN UP - STEP 03 : Click to Sign up button");
		signupPage.clickToSubmitButtonSignUp();
		
		log.info("SIGN UP - STEP 04 :verify passowrd message");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("Password not matching with confirm password."), "Password not matching with confirm password.");
	}
	
	@Test
	public void TC_05_RegisterAccountSuccess() {
		log.info("SIGN UP - STEP 01 : Clear textbox ");
		signupPage.ClearToDynamicTextboxSignUpPage("password");
		signupPage.ClearToDynamicTextboxSignUpPage("confirmpassword");
		
		log.info("SIGN UP - STEP 02 : Input password correct all field");
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("123456789", "confirmpassword");
		
		log.info("SIGN UP - STEP 03 : Click to Sign up button");
		accountPage = signupPage.clickToSubmitButtonSignUp();

		log.info("SIGN UP - STEP 04 :verify account page message displayed");
		verifyEquals(accountPage.isNameCustomerDisplay(), "Hi, " + firstName + " " + lastName);
		verifyTrue(accountPage.isBookingStatusDisplay("Nothing Booked Yet"));
		
			
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
