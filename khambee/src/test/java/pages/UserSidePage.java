package pages;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserSidePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Enroll Now')]")
	WebElement enrollNowOnLandingPage;
	
	@FindBy(xpath="//button[@class='cta-button  ']")
	WebElement enrollNowOnCoursePage;
	
	@FindBy(xpath="//button[normalize-space()='Apply Now!']")
	WebElement applyNow;
	
	@FindBy(xpath="//input[@placeholder='Enter your Full name']")
	WebElement fullName;
	
	@FindBy(xpath="//input[@placeholder='Enter your Email Id']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@placeholder='Enter your Mobile Number']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//button[normalize-space()='Book your seat']")
	WebElement bookYourSeat;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Name']")
	WebElement leadName;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Mobile Number']")
	WebElement leadMobileNumber;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Email ID']")
	WebElement leadEmailId;
	
	@FindBy(xpath="//button[contains(text(), \"I'm Interested!\")]")
	WebElement imInterested;
	
	@FindBy(xpath="//div[@class='popup-form-bottom']//span")
	WebElement mayBeLater;
	
	@FindBy(xpath="//h1[contains(text(),'Testing')]")
	WebElement coursePageHeading;
	
	@FindBy(xpath="//span[contains(text(),'Your Seat for the course has been Booked!')]")
	WebElement confirmationMessageForSeatBooking;
	
	@FindBy(xpath="//button[contains(text(),'Back to home ')]")
	WebElement backToHome;
	
	
	
	
	public UserSidePage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	
	public void clickOnEnrollOnLandingPage() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", enrollNowOnLandingPage);
		
	}
	
	public void clickonEnrollOnCoursePage() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", enrollNowOnCoursePage);
		
		
	}
	
	public void enterFullName(String name) {
		
		fullName.sendKeys(name);
		
	}
	
	public void enterEmailId(String email) {
		
		emailId.sendKeys(email);
	}
	
	public void enterMobileNumber(String number) {
		
		mobileNumber.sendKeys(number);
	
	}
	
	public void clickOnBookYourSeat() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", bookYourSeat);
		
	}
	
	public void clickOnApplyNow() {
		
		applyNow.click();
	}
	
	public void enterNameForLeadForm(String name) {
		
		leadName.sendKeys(name);
	}
	
	public void enterMobileNumberForLeadForm(String number) {
		
		leadMobileNumber.sendKeys(number);
	}
	
	public void enterEmailIdForLeadForm(String email) {
		
		leadEmailId.sendKeys(email);
	}
	
	public void clickOnImInterested() {
		
		imInterested.click();
	}
	
	public void clickOnMaybeLater() {
		
		mayBeLater.click();
	}
	
	public String getCoursePageHeading() {
		
		String heading = coursePageHeading.getText();
		
		return heading;
	}
	
	public String getConfirmationForSeatBooking() {
		
		String confirm = confirmationMessageForSeatBooking.getText();
		
		return confirm;
		
	}
	
	public void enrollStudents() {
		
		fullName.sendKeys("sudeshna");
		emailId.sendKeys("sudeshnashetty@gmail.com");
		mobileNumber.sendKeys("9133690791");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", bookYourSeat);
		
	}
	
	public void clickOnBackToHome() {
		
		backToHome.click();
	}
	
	
	
	

}
