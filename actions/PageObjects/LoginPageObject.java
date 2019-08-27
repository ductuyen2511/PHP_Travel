package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.LoginPageUI;
import commons.abtractPage;

public class LoginPageObject extends abtractPage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void isLoginFormDisplayed() {
		waitForElementVisisble(driver, LoginPageUI.LOGIN_FORM);
		isControlDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

	public void inputIntoEmailTextbox(String value) {
		waitForElementVisisble(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);
	}

	public void inputIntoPasswordTextbox(String value) {
		waitForElementVisisble(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
	}

	public void clickToLoginButton() {
		waitForElementVisisble(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
