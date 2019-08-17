package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class abtractTest {
	WebDriver driver;
	
	public WebDriver runMultiBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("chromeheadless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size =1366x768");
			driver = new ChromeDriver(options);
		}else {
			System.out.println("please choose a browser to run !");
		}
		driver.get("https://www.phptravels.net");
		driver.manage().timeouts().implicitlyWait(constants.LONG_TIME, TimeUnit.SECONDS);
		return driver;
	}
	
	public int RandomEmail() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
