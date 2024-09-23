package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursePage {

	WebDriver driver;
	
	@FindBy(xpath="//h1[normalize-space()='Courses']")
	WebElement courseHeading;
	
	@FindBy(xpath="//p[contains(text(),'Current Enrollments')]/following-sibling::span")
	WebElement currentEnrollments;
	
	@FindBy(xpath="//button[@class='Configure-Course-btn']")
	WebElement configureCourse;
	
	@FindBy(xpath="(//button[@class='Configure-Course-btn'])[2]")
	WebElement configureCourseWhenExtendsAvaillable;
	
	@FindBy(xpath="(//button[text()=' Extend'])[1]")
	WebElement extendCourse;
	
	@FindBy(xpath="//button[@class='End-batch-btn']")
	WebElement endOnGoing;
	
	@FindBy(xpath="(//button[text()='Start new batch '])[1]")
	WebElement startNewBatch;
	
	@FindBy(xpath="(//button[contains(text(),'Pause')])[1]")
	WebElement pause;
	
	@FindBy(xpath="(//button[contains(text(),'Resume')])[1]")
	WebElement resume;
	
	@FindBy(xpath="(//span[contains(text(),'Course Paused')])[1]")
	WebElement coursePaused;
	
	@FindBy(xpath="//span[@class='activeCourse']")
	WebElement courseStatusOnListPage;
	
	@FindBy(xpath="((//p[@class='Current-Enrollments'])/following::span)[1]")
	WebElement batchNumber;
	
	@FindBy(xpath="//div[@class='courseTopbarleft']//*[name()='svg']")
	WebElement backTOList;
	
	@FindBy(xpath="//div[@class='activeToggle']//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement activeToggle;
	
	@FindBy(xpath="//button[@class='save_btn']")
	WebElement saveButtonOnTop;
	
	@FindBy(xpath="//button[@class='course__next__btn']")
	WebElement nextButton;
	
	@FindBy(xpath="//div[text()='Course Information']")
	WebElement courseInformation;
	
	@FindBy(xpath="//div[text()='Pricing']")
	WebElement pricing;
	
	@FindBy(xpath="//h1[normalize-space()='Pricing Details']")
	WebElement pricingDetails;
	
	@FindBy(xpath="//div[text()='Course Details Page']")
	WebElement courseDetailsPage;
	
	@FindBy(xpath="//div[text()='Batch Details']")
	WebElement batchDetails;
	
	@FindBy(xpath="//p[contains(text(),'Set up the details for the batch and your recurring classes')]")
	WebElement textForBatchDetails;
	
	@FindBy(xpath="//div[text()='Certificate']")
	WebElement certificate;
	
	@FindBy(xpath="//div[text()='Additional Settings']")
	WebElement addSetting;
	
	@FindBy(xpath="//div[@class='content']/p")
	WebElement configureHeading;
	
	@FindBy(xpath="//div[@class='inputContainer']//h3[text()='Course Name*']/following-sibling::input[@type='text']")
	WebElement courseTitle;
	
	@FindBy(xpath="//textarea[@placeholder='Provide a quick and short description for your course for users to get a quick understanding of your course in 120 characters']")
	WebElement courseDescription;
	
	@FindBy(id="course-thumbnail")
	WebElement courseThumbnail;
	
	//use this to delete any image
	@FindBy(xpath="(//div[@class='imgUploadedCourse']//*[name()='svg'])[2]")
	WebElement delImage;
	
	@FindBy(xpath="//section[@class='basicInfoContainer']//div[@class='inputContainer'][1]//input[@type='text']")
	WebElement usp1;
	
	@FindBy(xpath="//div[@class='inputContainer'][h3[text()='Unique Selling Point 2*']]//input[@type='text']")
	WebElement usp2;
	
	@FindBy(xpath="//div[@class='inputContainer'][h3[text()='Unique Selling Point 3*']]//input[@type='text']")
	WebElement usp3;
	
	@FindBy(xpath="//div[contains(@class,'toggle_free')]//input[@type='checkbox']")
	WebElement paidCourse;
	
	@FindBy(xpath="//span[@class='Paid-Course']/following-sibling::div//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForPrice;
	
	@FindBy(xpath="//input[@placeholder='Enter total course price']")
	WebElement fullPrice;
	
	@FindBy(xpath="//input[@placeholder='Enter discounted price']")
	WebElement discountedPrice;
	
	@FindBy(xpath="//input[@placeholder='Enter discount percentage']")
	WebElement discountedPercentage;
	
	@FindBy(xpath="//div[@class='internationalPricingCheck']//input")
	WebElement internationalPrice;
	
	@FindBy(xpath="//div[@class='intenationalPricing']//input[@placeholder='Enter total course price']")
	WebElement internationalFullPrice;
	
	@FindBy(xpath="//span[contains(text(),'Discounted International Price')]/following-sibling::div//input")
	WebElement internationalDiscountedPrice;
	
	@FindBy(xpath="//div[@class='intenationalPricing']//input[@placeholder='Enter discount percentage']")
	WebElement internationalDiscountPercentage;
	
	@FindBy(xpath="//button[@class='CreateCoupon']")
	WebElement createCoupon;
	
	@FindBy(xpath="(//div[@class='editButton'])[1]")
	WebElement editCoupon;
	
	@FindBy(xpath="(//div[@class='Row-Styles']//div[6])[1]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForCoupon;
	
	@FindBy(xpath="=(//div[@class='Row-Styles']//div[5])[1]//input[@type='checkbox']")
	WebElement checkBoxForCoupon;
	
	@FindBy(id="CouponCode")
	WebElement couponCodeName;
	
	//can use same xpath for discount for referral
	@FindBy(id="Discount")
	WebElement couponCodeDiscount;
	
	@FindBy(id="NumberCouponCode")
	WebElement couponCodeNumberOfUses;
	
	@FindBy(id="Date")
	WebElement expiryDate;
	
	@FindBy(xpath="//button[@class='SaveChanges']")
	WebElement saveChanges;
	
	@FindBy(xpath="//button[@class='Cancel']")
	WebElement cancelForCouponCode;
	
	@FindBy(xpath="(//span[@class='activereferral']/following-sibling::div//span[contains(@class, 'MuiButtonBase-root')])[2]")
	WebElement toggleForReferral;
	
	@FindBy(xpath="//button[text()='Configure Referral Code']")
	WebElement configureReferral;
	
	@FindBy(css = "[class='CashbackGiven'] [id='Discount']")
	WebElement cashBackGivenToReferrers;
	
	@FindBy(xpath="//h3[text()='Course Details*']/following-sibling::textarea")
	WebElement courseDetails;
	
	@FindBy(xpath="//h3[text()='Benefits of your Course']/following-sibling::textarea")
	WebElement benefitsOfCourse;
	
	@FindBy(xpath="//h3[text()='Requirements for the Course*']/following-sibling::textarea")
	WebElement requirementsForCourse;
	
	@FindBy(xpath="//h3[text()='Instructor Name*']/following-sibling::input")
	WebElement instructorName;
	
	@FindBy(xpath="//h3[text()='Instructor Description*']/following-sibling::textarea")
	WebElement instructorDescription;
	
	@FindBy(xpath="//input[@id='company-logo']")
	WebElement instructorImage;
	
	@FindBy(xpath="//button[text()='Add a Module ']")
	WebElement addModule;
	
	@FindBy(xpath="(//div[@class='editButton']/child::span[1])[1]")
	WebElement editModule;
	
	@FindBy(xpath="(//div[@class='editButton']/child::span)[2]")
	WebElement deleteModule;
	
	@FindBy(id="ModuleName")
	WebElement moduleName;
	
	@FindBy(id="ModuleDescripiton")
	WebElement moduleDescription;
	
	@FindBy(css="[class='discountInputContainer'] [id='ModuleDescription']")
	WebElement durationOfModule;
	
	@FindBy(id="moduleOrder")
	WebElement moduleOrder;
	
	@FindBy(xpath="//input[@type='date']")
	WebElement courseStartDate;
	
	@FindBy(tagName = "select")
	WebElement startTimeforCourse;
	
	@FindBy(xpath="//label[text()='Number of Classes per Batch']/following-sibling::input[@type='number']")
	WebElement numberOfClassesPerBatch;
	
	@FindBy(xpath="//label[text()='Number of Students per Batch*']/following-sibling::input[@type='number']")
	WebElement numberofStudentsPerBatch;
	
	@FindBy(xpath="//label[text()='Duration of Course*']/following-sibling::input[@type='number']")
	WebElement durationOfCourse;
	
	//take the xapth in list of webElements for class timings
	
	@FindBy(xpath="(//div[@class='classLink']//span[contains(@class, 'MuiButtonBase-root')])[1]")
	WebElement startingClassLink;
	
	@FindBy(xpath="//input[@placeholder='Enter your Course WhatsApp Group link here']")
	WebElement whatsAppGroup;
	
	@FindBy(xpath="(//div[@class='classLink']//span[contains(@class, 'MuiButtonBase-root')])[2]")
	WebElement softStop;
	
	@FindBy(xpath="(//div[@class='classLink']//span[contains(@class, 'MuiButtonBase-root')])[2]")
	WebElement hardStop;
	
	@FindBy(xpath="//span[@class='Paid-Course']/parent::div[@class=' toggle_free']//input[@type='checkbox']")
	WebElement certifiedCourse;
	
	//@FindBy(xpath="//div[@class='CertificateContainer']//img")//take this in list
	
	@FindBy(id="course-signature")
	WebElement courseSignature;
	
	@FindBy(xpath="//input[@placeholder='Number of seats remaining for your course']")
	WebElement seatRemaining;
	
	@FindBy(xpath="//div[@role='status']")
	WebElement toast;
	
	@FindBy(xpath="//span[@class='blue__text']")
	WebElement clickToUpload;
	
	@FindBy(css="section.CouponListContainer section#moduleList table.custom-table")
	WebElement table;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3'])[2]")
	WebElement toggleForCertificate;
	
	@FindBy(xpath="(//div[@class='Row-Styles'])[3]//div")
	WebElement existingCouponcode;
	
	@FindBy(xpath="//span[@class='batchFilled']")
	WebElement batchFilled;
	
	@FindBy(xpath="(//span[contains(text(),'Class Started')])[1]")
	WebElement classStarted;
	
	
	
	public CoursePage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	
	public String getCurrentEnrollments() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	    wait.until(ExpectedConditions.visibilityOf(currentEnrollments));
		
		String enrollments = currentEnrollments.getText();
		
		return enrollments;
	}
	
	public String validate_course_Section() {
		
		String actual = courseHeading.getText();
		
		return actual;
		
	}
	
	public boolean isCourseActive() {

		
		boolean priceToggle = activeToggle.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
 	public void make_course_active() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", activeToggle);

	}
	
	public void save_option_to_move_next_section() {
		
		saveButtonOnTop.click();
	}
	
	public void next_option() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", nextButton);
		//nextButton.click();
	}
	
	public void configure_course() {
		
		configureCourse.click();
	}
	
	public String validate_configure_course() {
		
		String actual = configureHeading.getText();
		
		return actual;
	}
	
	public void click_on_save_on_top() {

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='save_btn']")));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", saveButtonOnTop);
		
		//saveButtonOnTop.click();
	}
	
	public void clickOnEndOnGoing() {
		
		endOnGoing.click();
	}
	
	public boolean isEndOnGoingDisplayed() {
		
		boolean endOn = endOnGoing.isDisplayed();
		
		return endOn;
	}
	
	public boolean isStartNewBatchDisplayed() {
		
		return startNewBatch.isDisplayed();
	}
	
	public void clickOnStartNewBatch() {
		
		startNewBatch.click();
	}
	
	public void selectBatch(String batch) {
		
		Select myOption = new Select(startTimeforCourse);
		
		myOption.selectByVisibleText(batch);
	}
	
	public boolean isPauseDisplayed() {
		
		return pause.isDisplayed();
		
	}
	
	public void clickOnPause() {
		
		pause.click();
	}
	
	public boolean isBatchFilledDisplayed() {
		
		return batchFilled.isDisplayed();
		
	}
	
	public boolean isClassStartedDisplayed() {
		
		return classStarted.isDisplayed();
	}
	
	public boolean isResumeDisplayed() {
		
		return resume.isDisplayed();
	}
	
	public void clickOnResume() {
		
		resume.click();
	}
	
	public boolean isCoursePausedDisplayed() {
		
		return coursePaused.isDisplayed();
	}
	
	public String getBatchNumber() {
		
		return batchNumber.getText();
	}
	
	public String getStatusOfCourseOnCourseList() {
		
		return courseStatusOnListPage.getText();
	}
	//coursedetails
	
	public void ClickOnCourseInformation() {
		
		courseInformation.click();
	}
	
	public void enter_course_tile(String name) {
		
		courseTitle.sendKeys(name);
		
	}
	
	public void remove_course_title() {
		
		courseTitle.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	
	public void enter_course_decription(String description) {
		
		courseDescription.sendKeys(description);
	}
	
	public void remove_course_description() {
		
		courseDescription.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_course_thumbnail(String Img) throws AWTException {

		courseThumbnail.sendKeys(Img);
		
	}
	
	public void remove_course_thumbnail() {
		
		delImage.click();
	}
	
	public void enter_usp1(String usp) {
		
		usp1.sendKeys(usp);
	}
	
	public void remove_usp1() {
		
		usp1.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_usp2(String usp) {
		
		usp2.sendKeys(usp);
	}
	
	public void remove_usp2() {
		
		usp2.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_usp3(String usp) {
		
		usp3.sendKeys(usp);
	}
	
	public void remove_usp3() {
		
		usp3.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	//pricing details
	
	public void open_pricing() {
		
		pricing.click();
	}
	
	public String validate_pricing_Section() {
		
		String actual = pricingDetails.getText();
		
		return actual;
	}
	
	public void make_paid_course() {
		
		paidCourse.click();
	}
	
	public void enter_price_for_course(String price) {
		
		fullPrice.sendKeys(price);
	}
	
	public void remove_full_price() {
		
		fullPrice.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_discounted_price(String price) {
		
		discountedPrice.sendKeys(price);
	}
	
	public void remove_discounted_price() {
		
		discountedPrice.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);	
	}
	
	public void enter_discount_for_course(String percentage) {
		
		discountedPercentage.sendKeys(percentage);
	}
	
	public void remove_discount_percentage() {
		
		discountedPercentage.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void internation_price_selection() {
		
		internationalPrice.click();
	}
	
	public void enter_international_price(String price) {
		
		internationalFullPrice.sendKeys(price);
	}
	
	public void remove_internation_price() {
		
		internationalFullPrice.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_international_discounted_price(String price) {
		
		internationalDiscountedPrice.sendKeys(price);
	}
	
	public void remove_international_discounted_price() {
		
		internationalDiscountedPrice.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_international_discount_percentage(String price) {
		
		internationalDiscountPercentage.sendKeys(price);
	}
	
	public void remove_international_discount_percentage() {
		
		internationalDiscountPercentage.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public float getInternationalDiscountedPrice() {
		
		String price = internationalDiscountedPrice.getAttribute("value");
		
		return Float.parseFloat(price);
	}
	
	public float getInternationalDiscountPercentage() {
		
		String price = internationalDiscountPercentage.getAttribute("value");
		
		return Float.parseFloat(price);
	}
	
    public void click_on_Create_Coupon_code() {
		
		createCoupon.click();
	}
	
	public void enter_coupon_Code_title(String title) {
		
		couponCodeName.sendKeys(title);
	}
	
	public void remove_coupon_code_title() {
		
		couponCodeName.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_discount_for_the_coupon(String discount) {
		
		couponCodeDiscount.sendKeys(discount);
	}
	
	public void remove_discount_for_the_coupon() {
		
		couponCodeDiscount.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_no_of_uses_for_coupons(String num) {
		
		couponCodeNumberOfUses.sendKeys(num);
	}
	
	public void remove_no_of_uses_for_coupons() {
		
		couponCodeNumberOfUses.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void select_expiry_date(String date) {
		
		
		expiryDate.sendKeys(date);
	}
	
	public void save_changes() {
		
		saveChanges.click();
	}
	
	public void cancel_changes() {
		
		cancelForCouponCode.click();
	}
	
	public void click_on_edit_coupon_code() {
		
		editCoupon.click();
	}
	
	public void remove_expiry_date() {
		
		expiryDate.clear();
	}
	
	public void check_display_coupon() {
		
		checkBoxForCoupon.click();
	}
	
	public void set_status_of_coupon() {
		
		toggleForCoupon.click();
	}
	
	public void set_active_referral() {
		
		toggleForReferral.click();
	}
	
	public void click_configure_referral() {
		
		configureReferral.click();
	}
	
	public void enter_discount_for_referral(String discount) {
		
		couponCodeDiscount.sendKeys(discount);
	
	}
	
	public void remove_discount_for_referral() {
		
		couponCodeDiscount.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void set_number_of_uses_for_referral(String num) {
		
		couponCodeNumberOfUses.sendKeys(num);
	}
	
	public void remove_number_of_uses_for_referral() {
		
		couponCodeNumberOfUses.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_cashBack_given_to_referrer(String num) {
		
		cashBackGivenToReferrers.sendKeys(num);
	}
	
	public void remove_cashBack_give_to_referrer() {
		
		cashBackGivenToReferrers.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	//course details
	
	public void open_course_details() {
		
		courseDetailsPage.click();
	}
	
	public void enter_course_details(String details) {
		
		courseDetails.sendKeys(details);
	}
	
	public void remove_course_details() {
		
		courseDetails.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	
	public void enter_benefits_of_course(String benefits) {
		
		benefitsOfCourse.sendKeys(benefits);
	}
	
	public void remove_benefits_of_course() {
		
		benefitsOfCourse.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	
	public void enter_requirements_of_course(String requirements) {
		
		requirementsForCourse.sendKeys(requirements);
	}
	
	public void remove_requirements_of_course() {
		
		requirementsForCourse.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_instructor_name(String name) {
		
		instructorName.sendKeys(name);
	}
	
	public void remove_instructor_name() {
		
		instructorName.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_instructor_description(String description) {
		
		instructorDescription.sendKeys(description);
	}
	
	public void remove_instrctor_description() {
		
		instructorDescription.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void upload_instructor_image(String url) {
		
		instructorImage.sendKeys(url);	
	}
	
	public void remove_image() {
		
		delImage.click();
	}
	
	public void click_on_add_moudle() {
		
		addModule.click();
	}
	
	public void enter_module_name(String name) {
		
		moduleName.sendKeys(name);
	}
	
	public void remove_module_name() {
		
		moduleName.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_moudle_description(String description) {
		
		moduleDescription.sendKeys(description);
	}
	
	public void remove_module_description() {
		
		moduleDescription.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_duration_of_moudle(String duration) {
		
		durationOfModule.sendKeys(String.valueOf(duration));
	}
	
	public void remove_duration_of_module() {
		
		durationOfModule.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enter_order_of_moudle(String order) {
		
		moduleOrder.sendKeys(String.valueOf(order));
	}
	
	public void remove_order_of_moudle() {
		
		moduleOrder.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void edit_module() {
		
		editModule.click();
	}
	
	public void delete_module() {
		
		deleteModule.click();
	}
	
	// batch details
	
	public void click_on_batch_details() {
		
		batchDetails.click();
	}
	
	public String getBatchDetailsHeading() {
		
		String heading = textForBatchDetails.getText();
		
		return heading;
	}

	public void set_course_date(String date) {
		
		courseStartDate.sendKeys(date);
	}
	
	public void open_start_time() {
		
		startTimeforCourse.click();
	}

	public boolean isCourseDateEmpty() {
		
		String startDate = courseStartDate.getAttribute("value");
		
		boolean startDateEmpty;
		
		if(startDate.isEmpty()) {
			
			startDateEmpty = true;
		}else {
			
			startDateEmpty = false;
		}
		
		return startDateEmpty;
	}
	
	public String getCourseStartDate() {
		
		String startDate = courseStartDate.getAttribute("value");
		
		return startDate;
	}
	
	public void remove_Start_date() {
		
		courseStartDate.sendKeys( Keys.DELETE);
		courseStartDate.sendKeys(Keys.TAB);
		courseStartDate.sendKeys( Keys.DELETE);
		courseStartDate.sendKeys(Keys.TAB);
		courseStartDate.sendKeys( Keys.DELETE);
		
	}
	
	public void set_start_time_of_course(String choosedOption) {
		
		Select myOption = new Select(startTimeforCourse);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", startTimeforCourse);
		
		
		myOption.selectByVisibleText(choosedOption);
	}
	
	public void set_number_of_classes(String num) {
		
		numberOfClassesPerBatch.sendKeys(num);
	}
	
	public boolean isNumberOfClassesEmpty() {
		
		String classes = numberOfClassesPerBatch.getText();
		
		boolean classesEmpty;
		
		if(classes != null) {
			
			classesEmpty = false;
		}else {
			
			classesEmpty = true;
		}
		
		return classesEmpty;
	}
	
	public void remove_number_of_classes() {
		
		numberOfClassesPerBatch.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void set_number_of_students(String num) {
		
		numberofStudentsPerBatch.sendKeys(num);
	}
	
	public boolean isNumberOfStudentsEmpty() {
		
		String student = numberofStudentsPerBatch.getText();
		
		boolean StudentEmpty;
		
		if(student != null) {
			
			StudentEmpty = false;
		}else {
			
			StudentEmpty = true;
		}
		
		return StudentEmpty;
	}
	
	public String getNumberOfStudentsPerBatch() {
		
		return numberofStudentsPerBatch.getAttribute("value");
	}
	public void remove_number_of_student() {
		
		numberofStudentsPerBatch.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void set_duration_of_course(String duration) {
		
		durationOfCourse.sendKeys(duration);
	
	}
	
	public boolean isDurtionEmpty() {
		
		String duration = durationOfCourse.getText();
		
		boolean durationEmpty;
		
		if(duration != null) {
			
			durationEmpty = false;
		}else {
			
			durationEmpty = true;
		}
		
		return durationEmpty;
	}
	
    public void remove_duration_of_course() {
		
		durationOfCourse.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
    public void select_class_timings(String day) {
		
		
		

	}
	
    public void set_starting_class_link() {
		
		startingClassLink.click();
	}
	
	public void enter_whatsapp_group(String group) {
		
		whatsAppGroup.sendKeys(group);
	}
	
	public void remove_whatsapp_group() {
		
		whatsAppGroup.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void set_soft_stop() {
		
		softStop.click();
	}
	
	public void set_hard_Stop() {
		
		hardStop.click();
	}
	
	public void extendTheBatch() {
		
		extendCourse.click();
		
	}
	
	
	//certification details
	
	public void open_certification_Details() {
		
		certificate.click();
	}
	
	public void set_certification_active() {
		
		certifiedCourse.click();
	}
	
	public void select_certificate() {
		
		
	}
	
    public void upload_signature(String sign) {
		
		courseSignature.sendKeys(sign);
	}
	
	public void clickOnToggleForCertificate() {
		
		toggleForCertificate.click();
	}
	
	//additional settings
	
	public void open_additional_settings() {
		
		addSetting.click();
	}
	
	public void enter_seats_remaining(String seats) {
		
		seatRemaining.sendKeys(seats);
	}
	
	public void remove_seats_remaining() {
		
		seatRemaining.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	
	public void open_show_case_coupon() {
		
		startTimeforCourse.click();
	}
	
	public String get_Toast() {
		
		String alert;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	    wait.until(ExpectedConditions.visibilityOf(toast));
		
	    alert = toast.getText();
		
		return alert;
		
	}
	
	public void clickOnElement(String elementName) {
        switch (elementName.toLowerCase()) {
            case "course information":
                courseInformation.click();
                break;
            case "pricing":
                pricing.click();
                break;
            case "course details page":
                courseDetailsPage.click();
                break;
            case "batch details":
                batchDetails.click();
                break;
            case "certificate":
                certificate.click();
                break;
            case "additional settings":
                addSetting.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid element name: " + elementName);
        }
	
	}
	
	public boolean isFieldNotEmpty() {
	    
		return benefitsOfCourse.getText() != null && ! benefitsOfCourse.getText().isEmpty();
	}
	
	public boolean isInstructorImageFieldNotEmpty() {
	   
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	        
	        wait.until(ExpectedConditions.visibilityOf(clickToUpload));
	        
	        return true; // Element is found and visible
	    } catch (Exception e) {
	        
	    	return false; // Element is not found or visible
	    }
	
	
	}
	
	public boolean getModuleDescription() {
		
		boolean textInDescription;
		
		String description = moduleDescription.getText();
		
		if(description != null) {
			textInDescription = true;
		}
		else {
			textInDescription= false;
		}
	
		return textInDescription;
		
	}
	
	public boolean getModuleduration() {
		
		boolean duration;
		
		String description = durationOfModule.getText();
		
		if(description != null) {
			
			duration = true;
		}
		else {
			duration = false;
		}
	
		return duration;
		
	}	
	
	public boolean validateFullPrice() {
		
		boolean FullPrice = fullPrice.isDisplayed();
				
		return FullPrice;
	}
	
	public boolean isFullPriceEmpty() {
		
		boolean priceValue = fullPrice.getAttribute("value") !=null && !fullPrice.getAttribute("value").isEmpty();
		
		return priceValue;
		
	}
	
	public static double calculateDiscountPercentage(double originalPrice, double discountedPrice) {
        
		if (originalPrice <= 0) {
            throw new IllegalArgumentException("Original price must be greater than 0");
        }

        double discountPercentage = ((originalPrice - discountedPrice) / originalPrice) * 100;
        
        return discountPercentage;
    }
	
	public double getDiscountedPrice() {
		
		String price = discountedPrice.getAttribute("value");
		
		return Double.parseDouble(price);
	}
	
	public double getDiscountedPercentage() {
		
		String price = discountedPercentage.getAttribute("value");
			
		return Double.parseDouble(price);
	}
	
	public boolean isCoursePaid() {
		
		boolean priceToggle = toggleForPrice.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
	public String statusOfPrice() {
		
		String status= driver.findElement(By.xpath("//span[@class='Paid-Course']")).getText();
		
		return status;
	}
	
	public boolean isReferralActive() {
		
		boolean referralToggle = toggleForReferral.getAttribute("class").contains("Mui-checked Mui-checked");
		
		
		return referralToggle;
	}
	
	public boolean isInternationalPriceSelected() {
		
		boolean internationalPriceCheckBox = driver.findElement(By.xpath("(//div[@class='internationalPricingCheck']//span[contains(@class, 'MuiButtonBase-root')])[1]")).getAttribute("class").contains("Mui-checked MuiCheckbox-root");
		
		return internationalPriceCheckBox;
	}
	
	public boolean isInternationalFullPriceEmpty() {
		
		boolean price = internationalFullPrice.getAttribute("value") !=null && !fullPrice.getAttribute("value").isEmpty();
		
		return price;
	}
	
	public int getNumberOfModules() {
	
		int serialNo ;
		
		List<WebElement> number = driver.findElements(By.xpath("//table[@class='custom-table']//tbody//td[1]"));
		
		serialNo = number.size();
		
		return serialNo;
	}
	
	public String getExistingCouponCodeName() {
		
		String name = existingCouponcode.getText();
		
		return name;
	}
	
	public void clickOnCheckBoxForCoupon() {
		
		checkBoxForCoupon.click();
	}
	
	public boolean isCouponActive() {
		
		
		boolean priceToggle = toggleForCoupon.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
	public void makeCouponActiveAndInActive() {
		
		toggleForCoupon.click();
	}
	
	public boolean isStartingClassActive() {
		
		
		boolean priceToggle = startingClassLink.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
	public boolean isSoftStopSelected() {
		
		boolean priceToggle = softStop.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
	public boolean isHardStopSelected() {
		
		
		boolean priceToggle = hardStop.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
	public boolean isExtendDisplayed() {
		
		boolean extend = extendCourse.isDisplayed();
		
		return extend;
	}
	
	public String getTomorrowDate() {
	    LocalDate tomorrow = LocalDate.now().plusDays(1);
	    return tomorrow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
	
	
	
	//New batch created successfully. Please specify new Start Date and Batch Size!

}
	

	
	
