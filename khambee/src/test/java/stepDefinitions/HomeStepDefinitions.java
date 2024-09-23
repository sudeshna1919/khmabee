package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.BaseSetUp;
import pages.CoursePage;
import pages.HomePage;

public class HomeStepDefinitions {
	
	WebDriver driver;

	HomePage hP;
	
	@When("user is on home page")
	public void user_is_on_home_page() {
		
		this.driver = BaseSetUp.driver;
		
		hP = new HomePage(driver);
				
		driver.getPageSource().contains("Hey sudeshna! Welcome to CreatorX ");
		
		hP.clickOnHome();
		
		
	}

	@Then("user clicks on visit your web site")
	public void user_clicks_on_visit_your_web_site() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='_authorized__header__button_1jcsg_73']")).click();
	}

	@Then("user should be navigated his web _site")
	public void user_should_be_navigated_his_website() {
		
		String parent=driver.getWindowHandle();
		
		Set<String> child=driver.getWindowHandles();
	}

	@Then("user clicks on View My Enrollments")
	public void user_clicks_on_View_My_Enrollments() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='_header__button_1jcsg_347']")).click();
	}

	@Then("user should be navigated to Course section")
	public void user_should_be_navigated_to_Course_section() {
		
		driver.findElement(By.xpath("//h1[normalize-space()='Courses']")).isDisplayed();
		
		driver.close();
	}



}
