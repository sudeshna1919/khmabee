package stepDefinitions;

import java.awt.AWTException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;


public class CourseStepDefinitions {
	
		//declaring the variables
		WebDriver driver;
	
		HomePage hP;
	
		CoursePage courseSetUp;
		
		WebsitePage wP;
		
		String initialSeats;
		
		int seatsFirst;
		
		UserSidePage uP;

		//Closing the driver instance
	@After
	public void tearDown() throws InterruptedException {
		
			Thread.sleep(2000);
		
			BaseSetUp.quitDriver();
		}
	
		//method to validate home page
	@Given("user navigates to home page")
	public void user_navigates_to_home_page() {
		
			//initializing the driver in this class with base class
			this.driver = BaseSetUp.driver;
		
			hP = new HomePage(driver);
			
			wP = new WebsitePage(driver);
		
			uP = new UserSidePage(driver);
			
			courseSetUp = new CoursePage(driver);
		
			String expected = "Welcome to KhamBee";
		
			String actual = hP.validate_homePage();
		
			Assert.assertTrue(actual.contains(expected));
		
		}
		
	@When("user clicks on course")
	public void user_clicks_on_course() throws InterruptedException {
			
			hP.click_on_course();
			
			Thread.sleep(1000);
			
			//initialSeats = courseSetUp.getCurrentEnrollments();
					
	}
		
	@Then("user should be navigated to his course page")
	public void user_should_be_navigated_to_his_course_page() {
			
			String expected ="Courses";
			
			String actual = courseSetUp.validate_course_Section();
			
			Assert.assertEquals(expected, actual);
		}
		
		//user navigates to course page
	@Given("user is on course page")
	public void user_is_on_course_page() throws InterruptedException {
		
			this.driver = BaseSetUp.driver;
		
			hP = new HomePage(driver);
		
			courseSetUp = new CoursePage(driver);
		
			hP.click_on_course();
			
			uP = new UserSidePage(driver);

			//seatsFirst = Integer.parseInt(courseSetUp.getCurrentEnrollments());
			
			String expected ="Courses";
		
			String actual = courseSetUp.validate_course_Section();
		
			Assert.assertEquals(expected, actual);
		
		}
		
	@When("user clicks on configure course")
	public void user_clicks_on_configure_course() {
		
			courseSetUp.configure_course();
		}
		
	@Then("user should be navigated to course configuration")
	public void user_should_be_navigated_to_course_configuration() {
			
			String expected ="Configure your Course details and availabilty for your user";
			
			String actual = courseSetUp.validate_configure_course();
			
			Assert.assertEquals(expected, actual);
		}
		
	@And("user erased the fields")
	public void user_erases_the_fields() throws InterruptedException {
			
			Thread.sleep(1000);
			
			courseSetUp.remove_course_title();
			
			Thread.sleep(1000);
			
			courseSetUp.remove_course_description();
			
			Thread.sleep(1000);
			
			courseSetUp.remove_image();
			
			Thread.sleep(1000);
			
			courseSetUp.remove_usp1();
			
			Thread.sleep(1000);
			
			courseSetUp.remove_usp2();
			
			Thread.sleep(1000);
			
			courseSetUp.remove_usp3();
		}
	
	@And("^user gives (.*), (.*) and uploads(.*)$")
	public void user_gives_title_description_and_uploads_Image(String title, String descri, String image) throws InterruptedException, AWTException {
		
			courseSetUp.enter_course_tile(title);
		
			courseSetUp.enter_course_decription(descri);
			
			String cleanFilePath = CommoMethods.removeHiddenCharacters(image);
			
			courseSetUp.enter_course_thumbnail(cleanFilePath);
			
			Thread.sleep(2000);
		}
	
	@And("^user entered (.*), (.*) and (.*)$")
	public void user_enters_usp1_usp2_and_usp3(String usp1, String usp2, String usp3) {
		
			courseSetUp.enter_usp1(usp1);
		
			courseSetUp.enter_usp2(usp2);
		
			courseSetUp.enter_usp3(usp3);
		
		}
	
	@When("clicked on save changes")
	public void clicked_on_save_changes() throws InterruptedException {
		
		courseSetUp.click_on_save_on_top();
		Thread.sleep(1000);
		
	}
	
	@Then("^user should gets a toast (.*)$")
	public void user_should_get_a_toast(String message) {
		
		String expected = message;
		
		String actual=courseSetUp.get_Toast();
		
		Assert.assertEquals(expected, actual);
	}
	
	@And("^user enters (.*),  (.*)$")
	public void user_enters_title_description(String title, String description) {
		
		courseSetUp.enter_course_tile(title);
		
		courseSetUp.enter_course_decription(description);
	}
	
	
	@When("user clicks on next")
	public void user_clicks_on_next() {
		
		courseSetUp.next_option();
	}
	
	@Then("user should be navigated to pricing section")
	public void user_should_be_navigated_to_pricing_section() {
		
		String expected = "Pricing Details";
		
		String actual= courseSetUp.validate_pricing_Section();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@When("user clicks on course details page")
	public void user_clicks_on_course_details_page() {
		
		courseSetUp.open_course_details();
	}
	
	@And("user delete the fields")
	public void user_delete_the_fields() {
		
		courseSetUp.remove_course_details();
		
		if (courseSetUp.isFieldNotEmpty()) {
	        
			courseSetUp.remove_benefits_of_course();
	    }
		
		
		courseSetUp.remove_requirements_of_course();;
		
		courseSetUp.remove_instructor_name();
		
		courseSetUp.remove_instrctor_description();
		
		System.out.println(courseSetUp.isInstructorImageFieldNotEmpty());
		
		if(!(courseSetUp.isInstructorImageFieldNotEmpty())) {
			
			courseSetUp.remove_image();
		}
	}
	
	@And("^user write (.*), (.*), and (.*)$")
	public void user_write_course_details_Benefits_and_requirements(String courseDetails, String benefits, String requirements){
		
		courseSetUp.enter_course_details(courseDetails);
		
		courseSetUp.enter_benefits_of_course(benefits);
		
		courseSetUp.enter_requirements_of_course(requirements);
	}
	
	@And("^user writes (.*),  (.*), and (.*)$")
	public void user_writes_instructor_name_description_and_instructor_image(String name, String description, String image) {
		
		courseSetUp.enter_instructor_name(name);
		
		courseSetUp.enter_instructor_description(description);
		
		if(courseSetUp.isInstructorImageFieldNotEmpty()) {
		
			String cleanFilePath = CommoMethods.removeHiddenCharacters(image);
			
			courseSetUp.upload_instructor_image(cleanFilePath);
		}
	}
	
	@And("user clicks on Add module")
	public void userClicksOnAddModule() {
		
		courseSetUp.click_on_add_moudle();
	}
	
	@When("^input (.*), (.*)$")
	public void enterModuleNameDescription(String name, String description) throws InterruptedException{
		
		courseSetUp.enter_module_name(name);
		Thread.sleep(1000);
		courseSetUp.enter_moudle_description(description);
		Thread.sleep(1000);
		
	}
	
	@When("^user inputs (.*) and (.*)$")
	public void enterModuleDurationOrder(String duration, String order) throws InterruptedException {
		
		courseSetUp.enter_duration_of_moudle(duration);
		Thread.sleep(1000);
		
		courseSetUp.enter_order_of_moudle(order);
		Thread.sleep(1000);
	}
	
	@When("press on save changes")
	public void  press_on_save_changes() throws InterruptedException {
		courseSetUp.save_changes();
		Thread.sleep(2000);
	}
	
	@And("user clicks on edit module")
	public void editModule() {
		courseSetUp.edit_module();
	}
	
	@And("clears the details")
	public void clearDetails() {
		
		courseSetUp.remove_module_name();
		
		if(courseSetUp.getModuleDescription()) {
				
			courseSetUp.remove_module_description();
		}
		
		if(courseSetUp.getModuleduration()) {
			
			courseSetUp.remove_duration_of_module();
		}
		
		courseSetUp.remove_order_of_moudle();
	}
	
	@And("user clicks on delete for a module")
	public void deleteModule() {
		
		courseSetUp.delete_module();
	}
	
	@And("user clicks on pricing")
	public void clickOnPricing() {
		
		courseSetUp.open_pricing();
	}
	
	@When("user makes course paid")
	public void makeCoursePaid() {
		
		courseSetUp.make_paid_course();
	}
	
	@Then("user should see the Full price field")
	public void validatePricingSection() {
		
		Assert.assertTrue(courseSetUp.validateFullPrice());
		
	}
	
	@And("user cleared the pricing")
	public void removeFullPrice() {
		
		if(courseSetUp.isFullPriceEmpty()) {
			
			courseSetUp.remove_full_price();
		}
		
	}
	
	@And("^user sets (.*) for the course$")
	public void setPriceForCourse(String price) {
		
		if(courseSetUp.isFullPriceEmpty()) {
			
			courseSetUp.remove_full_price();
		}
		
		courseSetUp.enter_price_for_course(price);
	}
	
	@When("^user fills (.*)$")
	public void enterDiscountedPrice(String disPrice) {
		
		courseSetUp.enter_discounted_price(disPrice);
	}
	
	@SuppressWarnings("deprecation")
	@Then("^(.*) should be updated")
	public void caluclateDiscountedPercentage( double discount) {
		
		double expectedPercentage = discount;
		
		double actualPercentage = courseSetUp.getDiscountedPercentage();
		
		double delta = 0.01;
		
		Assert.assertEquals(expectedPercentage, actualPercentage, delta);
		
	}
	
	 //i am not able to enter discount percentage in points
	@When("^user filled (.*)$")
	public void enterDiscountedPercentage(String disPrice) {
		
		courseSetUp.enter_discount_for_course(disPrice);
	}
	
	@Then("^(.*) should get updated")
	public void caluclateDiscountedPrice( double discount) {
		
		double expectedPercentage = discount;
		
		double actualPercentage = courseSetUp.getDiscountedPrice();
		
		double delta = 0.01;
		
		Assert.assertEquals(expectedPercentage, actualPercentage, delta);
		
	}
	
	@And("user clicks on create a coupon")
	public void clickOnCreateCoupon() {
		courseSetUp.click_on_Create_Coupon_code();
	}
	
	@And("^user input name, (.*), (.*), and  (.*)$")
	public void enterDetailsForCoupon( String discount, String uses, String date) {
		
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
		courseSetUp.enter_coupon_Code_title(generatedString);
		courseSetUp.enter_discount_for_the_coupon(discount);
		courseSetUp.enter_no_of_uses_for_coupons(uses);
		courseSetUp.select_expiry_date(date);
	}
	
	@And("^user sets (.*), (.*), (.*), and  (.*)$")
	public void enterInvalidDetails(String name, String discount, String uses, String date) {
		
		courseSetUp.enter_coupon_Code_title(name);
		courseSetUp.enter_discount_for_the_coupon(discount);
		courseSetUp.enter_no_of_uses_for_coupons(uses);
		courseSetUp.select_expiry_date(date);
		
	}
	
	@And("^user  enters already existing couponcode name, (.*), (.*), and   (.*)$")
	public void validateExistingCouponCodeName(String discount, String uses, String date ) {
		
		String name = courseSetUp.getExistingCouponCodeName();
		courseSetUp.enter_coupon_Code_title(name);
		courseSetUp.enter_discount_for_the_coupon(discount);
		courseSetUp.enter_no_of_uses_for_coupons(uses);
		courseSetUp.select_expiry_date(date);
		
		
	}
	
	@And("^the user toggles the course to (.*)$")
	public void the_user_toggles_the_course_to_status(String status) {
	 
	        
	        
	        if (status.equals("Paid")) {
	            if (!courseSetUp.isCoursePaid()) {
	                courseSetUp.make_paid_course();
	            }
	        } else if (status.equals("Free")) {
	            if (courseSetUp.isCoursePaid()) {
	            	 courseSetUp.make_paid_course();
	            }
	        }
	    }
	 
	@And("user checks the toggle and makes it paid if it is free")
	public void checkTheCourseIsPaid(){
		 
		 if(!courseSetUp.isCoursePaid()) {
			 
			 courseSetUp.make_paid_course();
		 }
	 }
	 
	@Then("^the course should be marked as (.*)$")
	public void checkThePriceStatus(String status) {
		 
		 String expected = status;
		 
		 String actual = courseSetUp.statusOfPrice();
		 
		 Assert.assertTrue(actual.contains(expected));
	 }
	 
	@And("user clicks on edit option")
	public void editCoupon() {
		 courseSetUp.click_on_edit_coupon_code();
	 }
	 
	@And("user removes the details")
	public void eraseTheDetailsOfCoupon() {
		 courseSetUp.remove_coupon_code_title();
		 courseSetUp.remove_discount_for_the_coupon();
		 courseSetUp.remove_no_of_uses_for_coupons();
		 courseSetUp.remove_expiry_date();
	 }
	
	@And("user checks the toggle for referral and makes it active if it is inactive")
	public void checkToggleForReferral() {
		
		if(!courseSetUp.isReferralActive()) {
			
			courseSetUp.set_active_referral();
		}
	}
	
	@And("user clicks configure referral code")
	public void configureReferral() {
		
		courseSetUp.click_configure_referral();
	}
	
	@And("user removed the details")
	public void clearDetailsOfReferral() {
		
		courseSetUp.remove_discount_for_referral();
		courseSetUp.remove_number_of_uses_for_referral();
		courseSetUp.remove_cashBack_give_to_referrer();
	}
	
	@When("^user provides (.*), (.*), (.*)$")
	public void enterDetailsForReferral(String discount, String uses, String cashBack) {
		
		courseSetUp.enter_discount_for_referral(discount);
		courseSetUp.enter_cashBack_given_to_referrer(cashBack);
		courseSetUp.set_number_of_uses_for_referral(uses);
	}
	
	@And("user clicks on check box for international price")
	public void selectCheckBoxForInternationalPrice() {
		
		if(!courseSetUp.isInternationalPriceSelected()) {
			
			courseSetUp.internation_price_selection();
		}
	
	}
	
	@And("^user set international (.*) for the course$")
	public void enterInternationalPrice(String price) {
		
		if(courseSetUp.isInternationalFullPriceEmpty()) {
			
			courseSetUp.remove_internation_price();
		}
		courseSetUp.enter_international_price(price);
	}
	
	@When("^user is entering (.*)$")
	public void enterInternationalDiscountedPrice(String price) {
		
		courseSetUp.enter_international_discounted_price(price);
	}
	
	@Then("^(.*) should is updated$")
	public void checkInternationalDiscountPercentage(float discount) {
		
		float expectedPercentage= discount;

		float actualPercentage = courseSetUp.getInternationalDiscountPercentage();
		
		Assert.assertEquals(expectedPercentage, actualPercentage, actualPercentage);
		
	}
	
	@When("^user has enters (.*)$")
	public void enterInternationalDiscountedPercentage(String discountPercentage) {
		
		courseSetUp.enter_international_discount_percentage(discountPercentage);
	}
	
	@Then("^(.*) should update$")
	public void checkInternationalDiscountedPrice(float price) {
		
		float expectedInternationalDiscountprice =  price;
		
		float actualInternationalDiscountPrice = courseSetUp.getInternationalDiscountedPrice();
		
		Assert.assertEquals(expectedInternationalDiscountprice, actualInternationalDiscountPrice, actualInternationalDiscountPrice);
		
	}
	
	@And("user clicks on Batch details")
	public void gotToBatchDetails() {
		
		courseSetUp.click_on_batch_details();
		
		SharedData.numberOfStudents = courseSetUp.getNumberOfStudentsPerBatch();
		
		System.out.println(SharedData.numberOfStudents);
	}
	
	@And("removes the fields if already filled")
	public void removeTheFields() {
		
		if(!courseSetUp.isCourseDateEmpty()) {
			
			courseSetUp.remove_Start_date();
		}
		
		if(!courseSetUp.isNumberOfClassesEmpty()) {
			
			courseSetUp.remove_number_of_classes();
		}
		
		if(!courseSetUp.isNumberOfStudentsEmpty()) {
			
			courseSetUp.remove_number_of_student();
		}
		
		if(!courseSetUp.isDurtionEmpty()) {
			
			courseSetUp.remove_duration_of_course();
		}
	}
	
	@And("^user is providing (.*), (.*), (.*), (.*), (.*)$")
	public void provideDetailsForBatch(String date, String time, String classes, String students, String duration) {
		
		courseSetUp.set_course_date(date);
		
		courseSetUp.open_start_time();
		
		courseSetUp.set_start_time_of_course(time);
		
		courseSetUp.set_number_of_classes(classes);
		
		courseSetUp.set_number_of_students(students);
		
		courseSetUp.set_duration_of_course(duration);
	
	}
	
	@And("^selects (.*), (.*), (.*)$")
	public void selectTypeOfStopAndLink(String link, String softstop, String hardstop) {

		
		if (link.equals("yes")) {
            if (courseSetUp.isStartingClassActive()) {
            	courseSetUp.set_starting_class_link();
            }
        } else if (link.equals("no")) {
            if (!courseSetUp.isStartingClassActive()) {
            	courseSetUp.set_starting_class_link();
            }
        }
		
		
		if (softstop.equals("yes")) {
            if (courseSetUp.isSoftStopSelected()) {
            	courseSetUp.set_soft_stop();
            }
        } else if (softstop.equals("no")) {
            if (!courseSetUp.isSoftStopSelected()) {
            	courseSetUp.set_soft_stop();
            }
        }
	
	
	if (hardstop.equals("yes")) {
        if (courseSetUp.isHardStopSelected()) {
        	courseSetUp.set_hard_Stop();
        }
    } else if (hardstop.equals("no")) {
        if (!courseSetUp.isHardStopSelected()) {
        	courseSetUp.set_hard_Stop();
        }
    }
}
	
	@Then("extends option should be available")
	public void checkExtendIsDisplayed() {
		
		Assert.assertTrue(courseSetUp.isExtendDisplayed());
	}

	@And("if course is inactive then make active")
	public void makingCourseActiveAfterExtendingDate() {

		
		if(!courseSetUp.isCourseActive()) {
			
			courseSetUp.make_course_active();
		}
		
	}

	@When("user clicks on extend")
	public void clickOnExtend() {
		
		courseSetUp.extendTheBatch();
		
	}

	@Then("user should be navigated to batch details page")
	public void checkNavigationToBatchDetails() {
		
		String expected ="Set up the details for the batch and your recurring classes";
		
		String actual = courseSetUp.getBatchDetailsHeading();
		
		Assert.assertEquals(expected,actual);
		
	}

	@Then("expect course start date all the other details should be filled")
	public void validateBatchDetailsFieldsForExtend() {
		
		Assert.assertTrue(courseSetUp.isCourseDateEmpty());
		
		Assert.assertFalse(courseSetUp.isNumberOfStudentsEmpty());
		
		Assert.assertFalse(courseSetUp.isDurtionEmpty());
		
		Assert.assertFalse(courseSetUp.isNumberOfClassesEmpty());
	}

	@Then("course should be inactive")
	public void courseShouldbeInactiveForExtend() {
		
		Assert.assertFalse(courseSetUp.isCourseActive());
	}

	@When("Class has started")
	public void checkIfClassStarted() {
		
		LocalDate currentDate = LocalDate.now();
		
		String dateString = courseSetUp.getCourseStartDate();
		
		System.out.println(dateString);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		
		LocalDate date = LocalDate.parse(dateString, formatter);
		
		System.out.println(date);
		System.out.println(currentDate);
      
        Assert.assertEquals(currentDate, date);
    }
	
	@Then("endongoing batch should be displayed")
	public void checkEndOnGoingBatch() {
		
		Assert.assertTrue(courseSetUp.isEndOnGoingDisplayed());
		
		
	}
	@Then("current enrollments should be increased by 1")
    public void current_enrollments_should_be_increased_by_1() {
        
		int Seats =  Integer.parseInt(initialSeats) + 1;   
        	
        String expectedSeats = String.valueOf(Seats);
        
        System.out.println("2."+expectedSeats);
        
        String  actualSeats = courseSetUp.getCurrentEnrollments();
         
        seatsFirst = Integer.parseInt(actualSeats);
        System.out.println("3."+actualSeats);
        
        Assert.assertEquals(expectedSeats, actualSeats);
    }
	
	@Then("^course should be (.*)$")
	public void checkCourseStatus(String status) {
		
		String expected = status;
		
		String actual = courseSetUp.getStatusOfCourseOnCourseList();
		
		Assert.assertEquals(expected,actual);
		
		
	}
	
	@And("current date is equal to start date")
	public void  checkCurrentDateAndStartDate() {
		
		LocalDate currentDate = LocalDate.now();
		
		String dateString = courseSetUp.getCourseStartDate();
		 
		 LocalDate dateFromString = LocalDate.parse(dateString);
		 
		 
		 
		 Assert.assertTrue(dateFromString.isEqual(currentDate));
	}
	
	@And("user books (.*) students for the course")
	public void BookSeat(String seats) throws InterruptedException {
		
		int currentEnrollments ; 
		
		int noOfSeatsPerBatch= Integer.parseInt(SharedData.numberOfStudents);
		
		if(seatsFirst>noOfSeatsPerBatch) {
			
			currentEnrollments =seatsFirst - noOfSeatsPerBatch;
		}
		else {
			currentEnrollments = noOfSeatsPerBatch- seatsFirst;
		}
		
		if(seatsFirst < noOfSeatsPerBatch) {
			for (int i = 0; i < currentEnrollments; i++) {
			
				uP.enrollStudents();
			
				Thread.sleep(5000);
				uP.clickOnBackToHome();
            
			}
		}
	}
	
	@And("if soft stop selected$")
	public void IfSoftStopSelected(String selection) {
		
		Assert.assertTrue(courseSetUp.isSoftStopSelected());		
	}
	
	@And("if current Enrollments is equal to or greater than number of students per batch")
	public void CheckCurrentEnrollmentsAndBatchSeats() {
		
		String current = courseSetUp.getCurrentEnrollments();
		int currentEnrollments = Integer.parseInt(current);
		int batchSeats = Integer.parseInt(SharedData.numberOfStudents);
		 Assert.assertTrue(currentEnrollments>= batchSeats);
	}
	
	@Then("batch filled should displayed")
	public void checkISBatchfilled() {
		
		Assert.assertTrue(courseSetUp.isBatchFilledDisplayed());
	}
	
	@Then("Paused is displayed")
	public void checkPauseForCourse() {
		
		Assert.assertTrue(courseSetUp.isCoursePausedDisplayed());
	}
		
}

