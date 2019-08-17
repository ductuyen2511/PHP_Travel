package PageObjects;

import org.openqa.selenium.WebDriver;

import commons.abtractPage;

public class LoginPageObject extends abtractPage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
