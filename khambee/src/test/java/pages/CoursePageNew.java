package pages;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoursePageNew {
	
	WebDriver driver;
	
	CommoMethods waitHelper = new CommoMethods(driver);
	
	@FindBy(xpath="(//div[@class='_opening_page_f7dcl_25']//h1)[1]")
	WebElement courseHeading;
	
	@FindBy(xpath="//div[@class='Course-name-container']//span[1]")
	WebElement courseName;
	
	@FindBy(xpath="//p[contains(text(),'Batch Number')]/following-sibling::span")
	WebElement batchNumber;
	
	@FindBy(xpath="//p[contains(text(),'Current Enrollments')]/following-sibling::span")
	WebElement currentEnrollments;
	
	@FindBy(xpath="//div[@class='Course-name-container']//span[2]")
	WebElement courseStatus;
	
	@FindBy(xpath="(//button[@class='Configure-Course-btn'])[1]")
	WebElement configureCourse;
	
	@FindBy(xpath="//div[@class='content']/p")
	WebElement configureHeading;
	
	@FindBy(xpath="(//button[@class='Configure-Course-btn'])[2]")
	WebElement pauseAndResume;
	
	@FindBy(xpath="//button[@class='Configure-Course-btn']//span")
	WebElement extend;
	
	@FindBy(xpath="//button[@class='End-batch-btn']")
	WebElement endOnGoingBatch;
	
	@FindBy(tagName="select")
	WebElement selectBatchForEnding;
	
	@FindBy(xpath="//button[normalize-space()='End Batch']")
	WebElement endBatch;
	
	@FindBy(xpath="//div[@class='new_event_form_bottom']")
	WebElement cancelForSelectBatch;
	
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
	
	@FindBy(xpath="(//header[@class='HeaderContainer'])[1]")
	WebElement courseInformationHeading;
	
	@FindBy(xpath="//div[text()='Pricing']")
	WebElement pricing;
	
	@FindBy(xpath="//header[@class='headerContainer']")
	WebElement pricingDetailsInPricingSection;
	
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
	
	@FindBy(xpath="//div[@class='inputContainer']//h3[text()='Course Name*']/following-sibling::input[@type='text']")
	WebElement courseTitle;
	
	@FindBy(xpath="//textarea[@placeholder='Provide a quick and short description for your course for users to get a quick understanding of your course in 120 characters']")
	WebElement courseDescription;
	
	@FindBy(id="course-thumbnail")
	WebElement courseThumbnail;
	
	@FindBy(xpath="(//div[@class='imgUploadedCourse']//*[name()='svg'])[2]")
	WebElement delImage;
	
	@FindBy(xpath="//div[@class='inputContainer'][h3[text()='Course Badge']]//input[@type='text']")
	WebElement courseBadge;
	
	@FindBy(xpath="//section[@class='basicInfoContainer']//div[@class='inputContainer'][1]//input[@type='text']")
	WebElement usp1;
	
	@FindBy(xpath="//section[@class='basicInfoContainer']//div[@class='inputContainer'][2]//input[@type='text']")
	WebElement usp2;
	
	@FindBy(xpath="//section[@class='basicInfoContainer']//div[@class='inputContainer'][3]//input[@type='text']")
	WebElement usp3;
	
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
	
	@FindBy(xpath="(//div[@class='Row-Styles'])[3]//div")
	WebElement existingCouponcode;
	
	
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
	
	@FindBy(xpath="(//div[@class='classLink']//span[contains(@class, 'MuiButtonBase-root')])[1]")
	WebElement startingClassLink;
	
	@FindBy(xpath="//input[@placeholder='Enter your Course WhatsApp Group link here']")
	WebElement whatsAppGroup;
	
	@FindBy(xpath="(//div[@class='classLink']//span[contains(@class, 'MuiButtonBase-root')])[2]")
	WebElement softStop;
	
	@FindBy(xpath="(//div[@class='classLink']//span[contains(@class, 'MuiButtonBase-root')])[2]")
	WebElement hardStop;
	
	public CoursePageNew(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }

	//this method is to check active, inactive, class started, batchfilled, pause status of course
	public String getCourseStatus() {
		
		waitHelper.waitForElementToBeVisible(courseStatus, 10);
		
		String status = courseStatus.getText();
		
		return status;
	}
	
	public String getBatchNumber() {
		
		waitHelper.waitForElementToBeVisible(batchNumber, 10);
		
		String batch = batchNumber.getText();
		
		return batch;
	}
	
	public String getCurrentEnrollments() {
		
		waitHelper.waitForElementToBeVisible(currentEnrollments, 10);
		
		String enrollments = currentEnrollments.getText();
		
		return enrollments;
	}
	
	public void clickOnExtends() {
		
		waitHelper.waitForElementToBeClickable(extend, 10);
		
		extend.click();
	}
	
	public boolean isEndOnGoingDisplayed() {
		
		boolean endOn = endOnGoingBatch.isDisplayed();
		
		return endOn;
	}
	
	public void clickOnEndOnGoingBatch() {
		
		waitHelper.waitForElementToBeClickable(endOnGoingBatch, 10);
		
		endOnGoingBatch.click();
	}
	
	public void selectBatchToEnd(String batchNO) {
		
		waitHelper.waitForElementToBeVisible(selectBatchForEnding, 10);
		
		Select batchSelecting = new Select(selectBatchForEnding);
		
		batchSelecting.selectByVisibleText(batchNO);
	}
	
	public void clickOnEndBatch() {
		
		waitHelper.waitForElementToBeClickable(endBatch, 10);
		
		endBatch.click();
	}
	
	public void clickOnCancelForEndBatch() {
		
		waitHelper.waitForElementToBeClickable(cancelForSelectBatch, 10);
		
		cancelForSelectBatch.click();
	}
	
	public boolean isPauseDisplayed() {
		
		waitHelper.waitForElementToBeClickable(pauseAndResume, 10);
		
		return pauseAndResume.isDisplayed();
		
	}
	
	public void clickOnPauseAndResume() {
		
		waitHelper.waitForElementToBePresent(pauseAndResume, 10);
		
		waitHelper.waitForElementToBeClickable(pauseAndResume, 10);
		
		pauseAndResume.click();
		
	}
	
	public boolean isResumeDisplayed() {
		
		waitHelper.waitForElementToBePresent(pauseAndResume, 10);
		
		return pauseAndResume.isDisplayed();
	}
	
	public void clickOnConfigureCourse() {
		
		waitHelper.waitForElementToBeClickable(configureCourse, 10);
		
		configureCourse.click();
	}
	
	public String getConfigureCourseHeading() {
		
		waitHelper.waitForElementToBePresent(configureHeading, 10);
		
		String heading = configureHeading.getText();
		
		return heading;
	}
	
	public boolean isCourseActive() {
		
		waitHelper.scrollToElement(activeToggle);
		
		waitHelper.waitForElementToBePresent(activeToggle, 10);
		
		boolean priceToggle = activeToggle.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return priceToggle;
	}
	
	public void makeCourseActive_Inactive() {
		
		waitHelper.scrollToElement(activeToggle);
		
		waitHelper.waitForElementToBeClickable(activeToggle, 10);
		
		activeToggle.click();
		
	}
	
	public void saveOptionOnTop() {

		waitHelper.scrollToElement(saveButtonOnTop);
		
		waitHelper.waitForElementToBeClickable(saveButtonOnTop, 10);
		
		saveButtonOnTop.click();
	}
	
	public void clickOnNextButton() {
		
		waitHelper.scrollToElement(nextButton);
		
		waitHelper.waitForElementToBeClickable(nextButton, 10);
		
		nextButton.click();
			
	}
	
	public void ClickOnCourseInformation() {
		
		waitHelper.waitForElementToBeVisible(courseInformation, 10);
		
		courseInformation.click();
	}
	
	public void enterCourseTitle(String name) {
		
		waitHelper.waitForElementToBeVisible(courseTitle, 10);
		
		courseTitle.sendKeys(name);
		
	}
	
	public void removeCourseTitle() {
		
		waitHelper.waitForElementToBeVisible(courseTitle, 10);
		
		waitHelper.clearField(courseTitle);
	}
	
	public void enterCourseDecription(String description) {
		
		waitHelper.waitForElementToBeVisible(courseDescription, 10);
		
		courseDescription.sendKeys(description);
	}
	
	public void removeCourseDescription() {
		
		waitHelper.waitForElementToBeVisible(courseDescription, 10);
		
		waitHelper.clearField(courseDescription);
	}
	
	public void uploadCourseThumbnail(String Img) throws AWTException {
		
		waitHelper.waitForElementToBeVisible(courseDescription, 10);
		
		courseThumbnail.sendKeys(Img);
		
	}
	
	public void removeCourseThumbnail() {
		
		waitHelper.waitForElementToBeClickable(courseDescription, 10);
		
		delImage.click();
	}
	
	public void enterUsp1(String usp) {
		
		waitHelper.waitForElementToBeVisible(usp1, 10);
		
		usp1.sendKeys(usp);
	}
	
	public void removeUsp1() {
		
		waitHelper.waitForElementToBeVisible(usp1, 10);
		
		waitHelper.clearField(usp1);
	}
	
	public void enterUsp2(String usp) {
		
		waitHelper.waitForElementToBeVisible(usp2, 10);
		
		usp1.sendKeys(usp);
	}
	
	public void removeUsp2() {
		
		waitHelper.waitForElementToBeVisible(usp2, 10);
		
		waitHelper.clearField(usp2);
	}
	
	public void enterUsp3(String usp) {
		
		waitHelper.waitForElementToBeVisible(usp3, 10);
		
		usp1.sendKeys(usp);
	}
	
	public void removeUsp3() {
		
		waitHelper.waitForElementToBeVisible(usp3, 10);
		
		waitHelper.clearField(usp3);
	}
	
	public void giveBadgeForCourse(String badge) {
		
		waitHelper.waitForElementToBeVisible(courseBadge, 10);
		
		courseBadge.sendKeys(badge);
	}
	
	public void removeBadge() {
		
		waitHelper.waitForElementToBeVisible(courseBadge, 10);
		
		waitHelper.clearField(courseBadge);
	}
	
	public void navigateToPricing() {
		
		waitHelper.waitForElementToBeClickable(pricing, 10);
		
		pricing.click();
	}
	
	public String getPricingHeading() {
		
		waitHelper.waitForElementToBeVisible(pricingDetailsInPricingSection, 10);
		
		String heading = pricingDetailsInPricingSection.getText();
		
		return heading;
	}
	
	public void makeCoursePaidOrFree() {
		
		waitHelper.waitForElementToBeVisible(toggleForPrice, 10);
		
		toggleForCoupon.click();
	}
	
	public void setCoursePrice(String price) {
		
		waitHelper.waitForElementToBeVisible(fullPrice, 10);
		
		fullPrice.sendKeys(price);
	}
	
	public void removeCoursePrice() {
		
		waitHelper.waitForElementToBeVisible(fullPrice, 10);
		
		waitHelper.clearField(fullPrice);
	}
	
	public void enterDiscountedPrice(String price) {
		
		waitHelper.waitForElementToBeVisible(discountedPrice, 10);
		
		discountedPrice.sendKeys(price);

	}
	
	
	
	
}
