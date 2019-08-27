package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.AccountPageUI;
import commons.PageManagementObjects;
import commons.abtractPage;

public class AccountPageObject extends abtractPage{
	WebDriver driver;
	
	public AccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String isNameCustomerDisplay() {
		waitForElementVisisble(driver, AccountPageUI.CUSTOMER_NAME_ACCOUNT);
		return getTextElement(driver, AccountPageUI.CUSTOMER_NAME_ACCOUNT);
	}

	public boolean isBookingStatusDisplay(String exptectedText) {
		waitForElementVisisble(driver, AccountPageUI.BOOKING_STATUS);
		String actualText = getTextElement(driver, AccountPageUI.BOOKING_STATUS);
		return actualText.contains(exptectedText);
	}

	public void clickToAccountDropdown() {
		waitForElementVisisble(driver, AccountPageUI.ACCOUNT_DROPDOWN);
		clickToElement(driver, AccountPageUI.ACCOUNT_DROPDOWN);
	}

	public LoginPageObject clickToLogoutLink() {
		waitForElementVisisble(driver, AccountPageUI.LOG_OUT_LINK);
		clickToElement(driver, AccountPageUI.LOG_OUT_LINK);
		return PageManagementObjects.getLoginPageObject(driver);
	}

	public void clickToMyProfileLink() {
		waitForElementVisisble(driver, AccountPageUI.MY_PROFILE_LINK);
		clickToElement(driver, AccountPageUI.MY_PROFILE_LINK);
	}

	public void inputIntoPasswordTextbox(String value) {
		waitForElementVisisble(driver, AccountPageUI.PASSWORD_ACCOUNT_PAGE);
		sendkeyToElement(driver, AccountPageUI.PASSWORD_ACCOUNT_PAGE, value);
	}

	public void inputIntoConfirmPasswordTextbox(String value) {
		waitForElementVisisble(driver, AccountPageUI.COMFIRM_PASSWORD_ACCOUNT_PAGE);
		sendkeyToElement(driver, AccountPageUI.COMFIRM_PASSWORD_ACCOUNT_PAGE, value);
	}

	public void clickToSubmitButton() {
		waitForElementVisisble(driver, AccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AccountPageUI.SUBMIT_BUTTON);
	}

	public boolean isMessageUpdateSuccessfullyDisplayed(String expectedText) {
		waitForElementVisisble(driver, AccountPageUI.UPDATE_MESAAGE_SUCCESSFULLY);
		String actualText = getTextElement(driver, AccountPageUI.UPDATE_MESAAGE_SUCCESSFULLY);
		return actualText.equals(expectedText);
	}

	public String getEmailValue(String value) {
		waitForElementVisisble(driver, AccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, AccountPageUI.EMAIL_TEXTBOX, value);
	}
	
}
