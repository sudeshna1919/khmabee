package pages;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommoMethods {
	
	WebDriver driver;
	
	public JavascriptExecutor jsExecutor;
	
	
	public CommoMethods(WebDriver driver) {
        
		this.driver = driver;
		
		this.jsExecutor = (JavascriptExecutor) driver;
        
		PageFactory.initElements(driver, this);
    }

	
	public static String removeHiddenCharacters(String input) {
        // Using regex to remove non-printable characters
        return input.replaceAll("[\\p{C}]", "");
    }
	
	public void waitForElementToBeVisible(WebElement element, int i) {
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
        
		wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Example of waiting for an element to be clickable
    public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Example of waiting for an element to be present in the DOM
    public void waitForElementToBePresent(WebElement element, int timeoutInSeconds) {
        
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void scrollToElement(WebElement element) {
               
    	jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void clearField(WebElement element) {
    	
    	element.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
    }
    
	
}
