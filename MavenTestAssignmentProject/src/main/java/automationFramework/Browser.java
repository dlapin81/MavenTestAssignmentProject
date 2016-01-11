package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;

public class Browser {
	private static WebDriver driver = new FirefoxDriver();
	
	private static WebElement findFlementByID;
	private static WebElement foundWebElementByXPath;
	private static String StringFromXPath;
	
	public static void Goto(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	public static String getTitle() {		
		return driver.getTitle();
	}

	public static void findWebElementById(String elementId)
	{
		findFlementByID = driver.findElement(By.id(elementId));
	}

	// Enter keyword to search box and press submit button
	public static void searchWebElement(String keyword) {
		findFlementByID.sendKeys(keyword);
		findFlementByID.submit();
	}

	public static void selectElementByValue(String selectElementByValue) {
		Select selectElement = new Select(findFlementByID);
		selectElement.selectByValue(selectElementByValue);
	}
	
	public static String returnStringByXPath(String xPath) {
		//foundWebElementByXPath =  (new WebDriverWait(driver, 10))
				  //.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		//System.out.println("Inside ReturnStringByXPath: " + foundWebElementByXPath.getText().toString());
		foundWebElementByXPath = driver.findElement(By.xpath(xPath));
		return foundWebElementByXPath.getText().toString();
	}
	
	public static String returnStringById(String id) {
		findWebElementById(id);
		return findFlementByID.getText().toString();
	}

	//check if menu option is selected (contains selected keyword)
	public static boolean optionSelected(String checkKeyword, String xPath) {
		StringFromXPath = returnStringByXPath(xPath);
		if(checkKeyword.equals(StringFromXPath) && foundWebElementByXPath.isSelected()){
			return true;
	    }
		else
		{
			return false;
		}
	}
	
	public static void searchWebElementByXPath(String xPath) {
		foundWebElementByXPath = driver.findElement(By.xpath(xPath));
	}
	
	public static void clickOnWebElement() {
		foundWebElementByXPath.click();
	}
	
	public static void Close() {
		driver.quit();
	}
}
