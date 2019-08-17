package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abtractPage {
	public void getCurrentURl(WebDriver driver) {
		driver.getCurrentUrl();
	}
	
	public void getTitle(WebDriver driver) {
		driver.getTitle();
	}
	
	public void backToBrowser(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void fowardToBrowser(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshToBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		System.out.println("acutual text = " + element.getText());
		return element.getText();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String textboxValue, String...values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(textboxValue);
	}
	
	public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}
	
	public void ClearToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void ClearToElement(WebDriver driver, String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void waitForElementVisisble(WebDriver driver, String locator) {
		wait = new WebDriverWait(driver, constants.SHORT_TIME);
		byLocator = By.xpath(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitForElementVisisble(WebDriver driver, String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		wait = new WebDriverWait(driver, constants.SHORT_TIME);
		byLocator = By.xpath(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitForElementInvisisble(WebDriver driver, String locator) {
		wait = new WebDriverWait(driver, constants.SHORT_TIME);
		byLocator = By.xpath(locator);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlUndisplay(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		
		if (elements.size() == 0) {
			return true;
		}else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isControlEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public Object clicktoElementbyJS(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].click();", element);
	}
	
	public Object sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		js = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].setAttribute('value', '" + value + "');", element);
	}
	
	public Object removeAttributeByJS(WebDriver driver, String locator, String atribute) {
		js = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].removeAttribute('" + atribute + "');", element);
	}
	
	public Object scrollToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	
	WebElement element;
	List<WebElement> elements;
	WebDriverWait wait;
	By byLocator;
	JavascriptExecutor js;
}
