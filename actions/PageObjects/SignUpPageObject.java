package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.AbtractPageUI;
import PageUIs.SignUpPageUI;
import commons.PageManagementObjects;
import commons.abtractPage;

public class SignUpPageObject extends abtractPage {
	WebDriver driver;

	public SignUpPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSignUpFormDisPlay() {
		waitForElementVisisble(driver, SignUpPageUI.SIGN_UP_FORM);
		return isControlDisplayed(driver, SignUpPageUI.SIGN_UP_FORM);
	}

	public void sendkeyToSignUpTextbox(String textboxValue, String values) {
		waitForElementVisisble(driver, AbtractPageUI.DYNAMIC_SIGN_UP_TEXTBOX, values);
		sendkeyToElement(driver, AbtractPageUI.DYNAMIC_SIGN_UP_TEXTBOX, textboxValue, values);
	}

	public AccountPageObject clickToSubmitButtonSignUp() {
		waitForElementVisisble(driver, SignUpPageUI.SUBMIT_BUUTON_SIGN_UP);
		clickToElement(driver, SignUpPageUI.SUBMIT_BUUTON_SIGN_UP);
		return PageManagementObjects.getAccountPageObject(driver);
	}

	public String GetErrorMessageSignUpPage(String values) {
		waitForElementVisisble(driver, AbtractPageUI.DYNAMIC_SIGN_UP_ERROR_MESSAGE, values);
		return getTextElement(driver, AbtractPageUI.DYNAMIC_SIGN_UP_ERROR_MESSAGE, values);
	}
	
	public void ClearToDynamicTextboxSignUpPage(String values) {
		waitForElementVisisble(driver, AbtractPageUI.DYNAMIC_SIGN_UP_TEXTBOX, values);
		ClearToElement(driver, AbtractPageUI.DYNAMIC_SIGN_UP_TEXTBOX, values);
	}

}
