package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.*;

public class UserSideStepDefinitions {
	
	WebDriver driver;
	
	HomePage hP;
	
	WebsitePage wP;
	
	UserSidePage uP;
	
	@Before
	public void inititalizeTheDrivers() throws IOException {
		
		driver = BaseSetUp.initializeWebDriver();
		
		hP = new HomePage(driver);
		
		wP = new WebsitePage(driver);
		
		uP = new UserSidePage(driver);
		
	}
	
	@Then("user should be navigated to his website")
	public void navigateToUserWebsite() throws InterruptedException {
		
		String expectedUrl = "https://testingmentoring.khambee.com/"; // Replace with the expected URL of the user's website
        
		Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
		
		Thread.sleep(2000);
		
		
			
	}
	
	@When("user clicks on enroll now on landing page")
	public void clickingOnEnrollOnLandingPage() {
		
		uP.clickOnEnrollOnLandingPage();
		
	}
	
	@Then("^user will navigate to (.*)$")
	public void validateCoursePage(String heading) {
		
		String expected = heading;
		
		String actual = uP.getCoursePageHeading();
		
		Assert.assertEquals(expected, actual);
	}
	
	@And("user clicks on enroll now on course page")
	public void clickingOnEnrollOnCoursePage() {
		
		uP.clickonEnrollOnCoursePage();
		
	}
	
	@And("^student fills the form (.*), (.*), (.*)$")
	public void studentFillsTheForm(String name, String email, String number) {
		
		uP.enterFullName(name);
		
		uP.enterEmailId(email);
		
		uP.enterMobileNumber(number);

	}
	
	@When("student clicks on Book your seat")
	public void clickingOnBookYourSeat() {
		
		uP.clickOnBookYourSeat();
	}
	
	@Then("^seat should be booked for the student with confirmation (.*)$")
	public void validateSeatBooking(String message) throws InterruptedException {
		
		Thread.sleep(5000);
		
		String expected = message;
		
		String actual = uP.getConfirmationForSeatBooking();
		
		Assert.assertEquals(expected, actual);
	}
	

}
