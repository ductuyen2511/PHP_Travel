package commons;

import org.openqa.selenium.WebDriver;

import PageObjects.AccountPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.SignUpPageObject;

public class PageManagementObjects {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static SignUpPageObject getSignUPageObject(WebDriver driver) {
		return new SignUpPageObject(driver);
	}
	
	public static AccountPageObject getAccountPageObject(WebDriver driver) {
		return new AccountPageObject(driver);
	}
}
