package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 @FindBy(xpath="//input[@placeholder='Enter your email or number']")
	 WebElement email;
	 
	 @FindBy(xpath="//input[@type='password']")
	 WebElement pass;
	 
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement logIn;
	 
	 @FindBy(xpath="//span[normalize-space()='Log out']")
	 WebElement logOut;
	 
	 @FindBy(xpath="//p[contains(text(),'Invalid')]")
	 WebElement errMessage;
	 
	 public LoginPage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	 
	 
	 public void enterEmail(String emailId) {
		 
		 email.sendKeys(emailId);
	}
	 
	 public void enterPass(String password) {
		 
		 pass.sendKeys(password);
	 }
	 
	 public void click_on_LogIn() {
		 logIn.click();
	 }
	 
	 public String  directed_to_home_page() {
		 
		 String out=logOut.getText();
		 
		 return out; 
		 
	 }
	 
	 public void log_out() {
		 
		 logOut.click();
		 
	 }
	 
	 public String error_Message() {
		 
		 String error = errMessage.getText();
		 
		 return error;
		 
	 }
	 
	 public boolean isButtonDisabled() {
	       
	       return !logIn.isEnabled();
	    }


}
