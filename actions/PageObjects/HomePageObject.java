package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.HomePageUI;
import commons.PageManagementObjects;
import commons.abtractPage;

public class HomePageObject extends abtractPage{
	WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountLink() {
		waitForElementVisisble(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public SignUpPageObject clickToSignUpLink() {
		waitForElementVisisble(driver, HomePageUI.SIGN_UP_LINK);
		clickToElement(driver, HomePageUI.SIGN_UP_LINK);
		return PageManagementObjects.getSignUPageObject(driver);
	}
}
