package com.phptravel.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.AccountPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.SignUpPageObject;
import commons.PageManagementObjects;
import commons.abtractTest;

public class Account_SignUp extends abtractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	SignUpPageObject signupPage;
	AccountPageObject accountPage;

	String firstName = "Le Duc";
	String lastName = "Tuyen";
	String email = "ductuyen" + RandomEmail() + "@gmail.com";
	public static String PASSWORD = "123456";
	public static String CONFIRM_PASSWORD = "123456";
	public static String EMAIL;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = runMultiBrowser(browserName);

		homePage = PageManagementObjects.getHomePageObject(driver);
		System.out.println("driver testcase layer :" + driver.toString());
	}

	@BeforeMethod
	public void runbeforeMethod() {
		homePage.clickToMyAccountLink();
		signupPage = homePage.clickToSignUpLink();
	}

	@Test
	public void TC_01_InputEmptyAllFields() {
		log.info("SIGN UP - STEP 01 : Verify Sign up form is displayed");
		verifyTrue(signupPage.isSignUpFormDisPlay());

		log.info("SIGN UP - STEP 02 : Click To Sign Up button");
		signupPage.clickToSubmitButtonSignUp();

		log.info("SIGN UP - STEP 03 : Verify empty all field");
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
		log.info("SIGN UP - STEP 01 : Input invalid email");
		signupPage.sendkeyToSignUpTextbox(firstName, "firstname");
		signupPage.sendkeyToSignUpTextbox(lastName, "lastname");
		signupPage.sendkeyToSignUpTextbox("0909181818", "phone");
		signupPage.sendkeyToSignUpTextbox("abcabc", "email");
		signupPage.sendkeyToSignUpTextbox("123", "password");
		signupPage.sendkeyToSignUpTextbox("123", "confirmpassword");

		log.info("SIGN UP - STEP 02 : Click to Sign up button");
		signupPage.clickToSubmitButtonSignUp();

		log.info("SIGN UP - STEP 03 : Varify password message");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("The Password field must be at least 6 characters in length."), "The Password field must be at least 6 characters in length.");
	}

	@Test
	public void TC_04_InputPasswordNotSame() {
		log.info("SIGN UP - STEP 01 : Input password and confirm password are not same");
		signupPage.sendkeyToSignUpTextbox(firstName, "firstname");
		signupPage.sendkeyToSignUpTextbox(lastName, "lastname");
		signupPage.sendkeyToSignUpTextbox("0909181818", "phone");
		signupPage.sendkeyToSignUpTextbox("abcabc", "email");
		signupPage.sendkeyToSignUpTextbox("123", "password");
		signupPage.sendkeyToSignUpTextbox("123456789", "confirmpassword");

		log.info("SIGN UP - STEP 02 : Click to Sign up button");
		signupPage.clickToSubmitButtonSignUp();

		log.info("SIGN UP - STEP 03 :verify passowrd message");
		verifyEquals(signupPage.GetErrorMessageSignUpPage("Password not matching with confirm password."), "Password not matching with confirm password.");
	}

	@Test
	public void TC_05_RegisterAccountSuccess() {
		log.info("SIGN UP - STEP 01 : Input all valid field");
		signupPage.sendkeyToSignUpTextbox(firstName, "firstname");
		signupPage.sendkeyToSignUpTextbox(lastName, "lastname");
		signupPage.sendkeyToSignUpTextbox("0909181818", "phone");
		signupPage.sendkeyToSignUpTextbox(email, "email");
		signupPage.sendkeyToSignUpTextbox("123456789", "password");
		signupPage.sendkeyToSignUpTextbox("123456789", "confirmpassword");

		log.info("SIGN UP - STEP 02 : Click to Sign up button");
		accountPage = signupPage.clickToSubmitButtonSignUp();

		log.info("SIGN UP - STEP 03 : verify account page message displayed");
		verifyEquals(accountPage.isNameCustomerDisplay(), "Hi, " + firstName + " " + lastName);
		verifyTrue(accountPage.isBookingStatusDisplay("Nothing Booked Yet"));

		log.info("SIGN UP - STEP 04 : Click to my profile link");
		accountPage.clickToMyProfileLink();

		log.info("SIGN UP - STEP 05 : Input password");
		accountPage.inputIntoPasswordTextbox(PASSWORD);

		log.info("SIGN UP - STEP 06 : Input confirm password");
		accountPage.inputIntoConfirmPasswordTextbox(CONFIRM_PASSWORD);

		log.info("SIGN UP - STEP 07 : Click submit button");
		accountPage.clickToSubmitButton();

		log.info("SIGN UP - STEP 08 : Get email value");
		EMAIL = accountPage.getEmailValue("value");
		log.info("email value" + EMAIL);

		log.info("SIGN UP - STEP 09 : veirfy message update successfully");
		verifyTrue(accountPage.isMessageUpdateSuccessfullyDisplayed("Profile Updated Successfully."));
	}

	public void TC_06_AccountLogout() {
		log.info("LOG OUT - STEP 01 : click to account dropdown list");
		accountPage.clickToAccountDropdown();

		log.info("LOG OUT - STEP 02 : click to log out link");
		loginPage = accountPage.clickToLogoutLink();

		log.info("LOG OUT - STEP 03 : verify login form is displayed");
		loginPage.isLoginFormDisplayed();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
