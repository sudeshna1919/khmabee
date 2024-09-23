package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	 @FindBy(xpath="//a[@class='MyProfile_main__content__left__button__Olrb2']")
	 WebElement websiteURL;
	 
	 @FindBy(xpath="//div[@class='fullIcons']//span[contains(text(),'Home')]")
	 WebElement home;
	 
	 @FindBy(xpath="")
	 WebElement viewBookings;
	 
	 @FindBy(xpath="//span[normalize-space()='Website']")
	 WebElement website;
	 
	 @FindBy(xpath="//h1[contains(text(),'Welcome to KhamBee')]")
	 WebElement dasboard;
	 
	 @FindBy(xpath="//span[normalize-space()='Courses']")
	 WebElement course;
	 
	
	public HomePage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	
	public void clickOnHome() {
		
		home.click();
	}
	
	public String validate_homePage() {
		
		String text_On_Dashboard = dasboard.getText();
		
		return text_On_Dashboard;
	}
	
	public void click_On_Website() throws InterruptedException {
		
		Thread.sleep(3000);
		
		website.click();
	}
	
	public void click_on_course() throws InterruptedException {
		
		Thread.sleep(3000);
		
		course.click();
	}
}
