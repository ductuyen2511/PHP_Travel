package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.AccountPageUI;
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
}
