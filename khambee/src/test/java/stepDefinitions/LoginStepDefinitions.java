package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseSetUp;
import pages.LoginPage;

public class LoginStepDefinitions {
	
	WebDriver driver;
	
	LoginPage logIn;
	
	@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(2000);
		
        BaseSetUp.quitDriver();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException {
		
		driver = BaseSetUp.initializeWebDriver();
		
		 driver = BaseSetUp.driver;
		 
		logIn = new LoginPage(driver);
			
	}

	
	@When("^user enters (.*) and (.*)$")
	public void user_enters_user_name_and_password(String username, String password) throws InterruptedException  {
		
		Thread.sleep(5000);
		
		logIn.enterEmail(username);
		
		logIn.enterPass(password);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		
		logIn.click_on_LogIn();
		
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
	    
		String expected ="Log out";
		
		String actual = logIn.directed_to_home_page();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() throws InterruptedException {
		
		Thread.sleep(5000);
		
		String expected = "Invalid";
		
		String actual = logIn.error_Message();
		
		Assert.assertTrue("expectedText found", actual.contains(expected));
	
    }
	
	@Then("Login should be disabled")
	public void Login_should_be_disabled() throws InterruptedException {
		 
		Assert.assertTrue("Button is not disabled", logIn.isButtonDisabled());
				
    }


}
