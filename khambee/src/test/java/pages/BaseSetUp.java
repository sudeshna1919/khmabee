package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSetUp {
	
	public static WebDriver driver;

    
	public static WebDriver initializeWebDriver() throws IOException {  
		if(driver == null) {
    	driver = new ChromeDriver();
		//driver = new EdgeDriver();
	
        // To maximize browser  
       driver.manage().window().maximize();  
      
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://dashboard.khambee.com/"); 
		} 
        return driver;
    	
	}
	
	@After
	 public static void quitDriver() {  
		if (driver != null) {
            driver.quit();
            driver = null;
        } 
    }
	


}
