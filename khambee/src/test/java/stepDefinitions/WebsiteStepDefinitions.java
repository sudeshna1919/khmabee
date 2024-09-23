package stepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;


public class WebsiteStepDefinitions {
	
	WebDriver driver;
	
	HomePage hP;
	
	WebsitePage wP;
	 
	int number;
	
	boolean ActualStatus;
	
	String sectionStatus;
	

	/*@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(2000);
		
        BaseSetUp.quitDriver();
    }*/

	@Given("user is on the web site page")
	public void user_clicks_on_web_site() throws InterruptedException {
		
		this.driver = BaseSetUp.driver;
		
		hP = new HomePage(driver);
		
		wP = new WebsitePage(driver); 
		
		hP.click_On_Website();
	}
	

	@When("user is navigated to web site section")
	public void user_is_navigated_to_web_site_section() {
		
		String expected = "Homepage";
		
		String actual = wP.validate_website_section();
		
		Assert.assertEquals(expected, actual);
	}
	
	@When("there are six sections")
	public void there_are_six_sections() {
		
		int expected = 6;
		
		int actual = wP.check_no_of_Section();
		
		Assert.assertEquals(expected, actual);
		
	}
	

	@When("user clicks on the Hero section")
	public void user_clicks_on_the_Hero_section() {
		
		 wP.opening_hero_section();
		
	}
	
	@When("user clicks on the Content section")
	public void user_clicks_on_the_Content_section() {
		
		 wP.opening_content_section();
		
	}
	
	@When("user clicks on the closing section")
	public void user_clicks_on_the_closing_section() {
		
		 wP.opening_closing_section();
		
	}
	
	@When("user clicks on the course section")
	public void user_clicks_on_the_course_section() {
		
		wP.opening_course_section();
	}
	
	@When("user clicks on the footer section")
	public void user_clicks_on_the_footer_section() {
		
		wP.opening_footer_section();
	}
	
	@When("^user typed (.*), (.*) and uploads (.*)$")
	public void user_typed_title_description_and_uploads_Image(String title, String descri, String image) throws InterruptedException {
		
		Thread.sleep(1000);
		
		wP.enter_title(title);

		wP.enter_description(descri);
		
		String cleanFilePath = CommoMethods.removeHiddenCharacters(image);
		
		wP.upload_Image(cleanFilePath);
		
		Thread.sleep(2000);
		
	}
	
	@When("^user types (.*),  (.*)$")
	public void user_types_title_description(String title, String descri) {
		
		wP.enter_title(title);

		wP.enter_description(descri);
		
	}
	
	@When("^user has filled (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
	public void enterFooterSectionDetails(String brand, String tagline, String copyright, String gram, String facebook, String youtube, String twitter, String linkedIn) throws InterruptedException {
		
		wP.enter_brand_name(brand);
		
		wP.EnterBrandTagLine(tagline);
		
		wP.EnterBrandCopyRight(copyright);
		
		wP.enter_insta_link(gram);
		
		Thread.sleep(5000);
		
		wP.enter_face_book_link(facebook);
		
		wP.enter_you_tube_link(youtube);
		
		wP.EnterTwitterUrl(twitter);
		
		wP.EnterLinkedInUrl(linkedIn);
		
	}
	
	@When("^there are (.*) sections$")
	public void there_are_section_count_sections(int n) {
		
		int actual = wP.check_no_of_Section();
		
		Assert.assertEquals(n, actual);
		
	}
	
	@When("User clicks on save changes")
	public void User_clicks_on_save_changes() {
		
		wP.save_changes();
		
	}
	
	@When("the user selects the delete option")
	public void the_user_selects_the_delete_option() {
		
		wP.deleting_section();
	}
	
	@When("the user confirms the deletion")
	public void the_user_confirms_the_deletion() {
		
		wP.confirm_delete_section();

	}
	
	@When("user presses on add new section")
	public void user_presses_on_add_new_section() throws InterruptedException {
		
		Thread.sleep(2000);
		
		wP.click_add_new_section();
	}
	
	@When("user hits add section")
	public void user_hits_add_section(){
		
		wP.click_add_section();
	}
	
	
	@And("user opens hero section")
	public void user_opens_hero_section() throws InterruptedException {
		
		wP.opening_hero_section();	
	}
	
	@And("user opens closing section")
	public void user_opens_closing_section() {
		
		wP.opening_closing_section();
	}
	
	@And("user clears the fields")
	public void user_clears_the_fields() throws InterruptedException {
		
		wP.clear_title();
		
		Thread.sleep(2000);
		
		wP.clear_description();
		
		Thread.sleep(1000);
		
		if(!(wP.isImageFieldNotEmpty())) {
		
			wP.del_Image();
		}
		
		Thread.sleep(1000);
		
	}
	
	@And("user cleared the fields")
	public void user_cleard_the_fields() throws InterruptedException {
		
		wP.clear_title();
		
		Thread.sleep(2000);
		
		wP.clear_description();
		
	}
	
	
	@And("user erases the fields")
	public void user_erases_the_fields() {
		
		wP.clear_brand_name();
		
		wP.ClearBrandTagLine();
		
		wP.ClearBrandCopyRight();
		
		wP.clear_insta_link();
		
		wP.clear_face_book_link();
		
		wP.clear_you_tube_link();
		
		wP.ClearTwitterUrl();
		
		wP.ClearLinkedInUrl();
	}
	
	@And("^user selects the orientation of the section (.*)$")
	public void user_selects_the_orientation_of_the_section_orientation(String orientation) throws InterruptedException{
		
		System.out.println(orientation);
		
		wP.select_option(orientation);
		
	}
	
	@And("user is navigates to web site section")
	public void user_is_navigates_to_web_site_section() {
		
		String expected = "Homepage";
		
		String actual = wP.validate_website_section();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	
	

	@And("user triggers add section button")
	public void user_triggers_add_section() {
		
		wP.click_add_section();
	}
	
	
	@And("clicks on save changes")
	public void clicks_on_save_changes() {
		
		wP.save_changes();
	}
	
	
	
	@And("^selects from the drop down the (.*)$")
	public void selects_from_the_drop_down_the_section(String sectionName) throws InterruptedException {
		
		wP.select_option(sectionName);
	}
	
	@And("user clicks on visit website")
	public void clickOnVisitWebiste() {
		
		SharedData.originalWindow = driver.getWindowHandle();

		wP.clickOnVisitWebsite();
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		}
	}
	
	
	@Then("section form should be displayed")
	public void section_form_should_be_displayed() {
		
		String expected ="Provide the content for the ";
		
		String actual=wP.get_new_Section_form_heading();
		
		Assert.assertTrue(actual.contains(expected));
		
	}
	
	@Then("by default six sections for the web site")
	public void by_default_six_sections_for_the_web_site() {
		
		int expected = 6;
		
		int actual = wP.check_no_of_Section();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Then("the Hero section should be displayed")
	public void the_Hero_section_should_be_displayed() {
		
		String expected ="Hero Title*";
		
		String actual = wP.validate_Hero_section();
		
		Assert.assertEquals(expected, actual);
	
	}
	@Then("the Content section should be displayed")
	public void the_Content_section_should_be_displayed() {
		
		String expected ="Choose Orientation of the Section*";
		
		String actual = wP.validate_content_section();
		
		Assert.assertEquals(expected, actual);
	
	}
	@Then("the closing section should be displayed")
	public void the_closing_section_should_be_displayed() {
		
		String expected ="Closing Title*";
		
		String actual = wP.validate_closing_section();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Then("the course section should be displayed")
	public void the_course_section_should_be_displayed() {
		
		String expected ="Course Section Title*";
		
		String actual = wP.validate_course_section();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Then("the footer section should be displayed")
	public void the_footer_section_should_be_displayed() {
		
		String expected ="Footer Section*";
		
		String actual = wP.validate_footer_section();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Then("a confirmation pop up should be displayed")
	public void a_confirmation_pop_up_should_be_displayed() {
		
		Assert.assertTrue(wP.check_delete_popup());
	}
	

	@Then("^user should get a toast (.*)$ for deleted section")
	public void user_should_get_a_toast_message_for_deleted_section(String message) {
		
		String expected =message;
		
		String actual=wP.get_Toast();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Then("^user should get a toast (.*)$")
	public void user_should_get_a_toast(String message) {
		
		String expected =message;
		
		String actual=wP.get_Toast();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Then("delete section should not present")
	public void delete_section_should_not_present() {
		
		Assert.assertFalse(wP.check_delete_Section_display());
	}
	
	@Then("delete section should be present")
	public void delete_section_should_be_present() {
		
		Assert.assertTrue(wP.check_delete_Section_display());
	}
	
	@Then("Add new section should not be displayed")
	public void Add_new_section_should_not_be_displayed() throws InterruptedException {
		
		Assert.assertFalse(wP.check_add_new_section_button());
	}
	
	@Then("Add new section should be displayed")
	public void Add_new_section_should_be_displayed() throws InterruptedException {
		
		Assert.assertTrue(wP.check_add_new_section_button());
	}
	
	@Then("Add new section should {string} be displayed")
    public void add_new_section_should_be_displayed(String displayStatus) throws InterruptedException {
        // Check if the "Add new section" button is displayed or not
        boolean isDisplayed = wP.check_add_new_section_button();

        if (displayStatus.equals("not")) {
            Assert.assertFalse(isDisplayed);
        } else {
        	Assert.assertTrue(isDisplayed);
        }

        // Clean up
        driver.quit();
    }
	
	@And("user returns to creator dashboard")
	public void returnToCreatorWebsite() {
		
		driver.switchTo().window(SharedData.originalWindow);
	}
	
	@Then("save changes should be disabled")
	public void checkSaveChangesStatus() {
		
		Assert.assertFalse(wP.isSaveChangesEnabled());
	}
	
	@Then("add section button should be disabled")
	public void checkAddSectionButton() {
		
		Assert.assertFalse(wP.isAddSectionDisabled());
	}

	
	@When("user clicks to add terms and conditions")
	public void selectAddTermsAndConditions() {
		
		wP.ClickOnAddTermsAndConditions();
	}
	
	@And("user clear terms and conditions if already filled")
	public void clearContentForTerms() {
		
		if(wP.isTextChangedForTermsAndConditions()) {
			
			wP.ClearTermsAndConditions();
		}
	}
	
	@And("^user defines his own (.*)$")
	public void writeTermsAndConditions(String content) {
		
		wP.EnterTermsAndConditions(content);
	}
	
	@When("user clicks on AddTermsAndConditions")
	public void saveTermsAndConditions() {
		
		wP.ClickOnAddTermsAndCondtionsButton();
	}
	
	@When("user clicks to add delivery and shipping policy")
	public void selectDeliveryAndShippingPolicy() {
		
		wP.ClickOnAddDeliveryAndShippingPolicy();
	}
	
	@And("user clear deliver and shipping policy if already filled")
	public void clearContentForDelivery() {
		
		if(wP.isTextChangedForDeliveryAndShipping()) {
			
			wP.ClearDeliveryAndShippingPolicy();
		}
	}
	
	
	@And("^user writes his own (.*)$")
	public void writeDeliveryAndShippingPolicy(String content) {
		
		wP.EnterDeliveryAndShippingPolicy(content);
	}
	
	@When("user clicks on AddDeliveryAndShippingPolicy")
	public void saveDeliverAndShippingPolicy() {
		
		wP.ClickOnAddDeliveryAndShippingPolicyButton();
	}
	
	@When("user clicks to add refund policy")
	public void selectAddRefundPolicy() {
		
		wP.ClickOnAddRefundPolicy();
	}
	
	@And("user clear refund policy if already filled")
	public void clearContentForRefund() {
		
		if(wP.isTextChangedForRefund()) {
			
			wP.ClearRefundPolicy();
		}
	}
	
	@And("^user defined his own (.*)$")
	public void writeRefundPolicy(String content) {
		
		wP.EnterRefundPolicy(content);
	}
	
	@When("user clicks on AddRefundPolicy")
	public void saveRefundPolicy() {
		
		wP.ClickOnAddRefundPolicyButton();
	}
	
	@When("user clicks to add privacy policy")
	public void selectAddPrivacyPolicy() {
		
		wP.ClickOnAddPrivacyPolicy();
	}
	
	@And("user clear privacy policy if already filled")
	public void clearContentForprivacy() {
		
		if(wP.isTextChangedForPrivacy()) {
			
			wP.ClearPrivacyPolicy();
		}
	}
	
	
	@And("^user creates his own (.*)")
	public void writePrivacyPolicy(String content) {
		
		wP.EnterPrivacyPolicy(content);
		
	}
	
	@When("user clicks on AddPrivacyPolicy")
	public void savePrivacyPolicy() {
		
		wP.ClickOnAddPrivacyPolicyButton();
	}
	
	@When("user clicks to add pricing policy")
	public void selectPricingPolicy() {
		
		wP.ClickOnAddPricingPolicy();
	}
	
	@And("user clear pricing policy if already filled")
	public void clearContentForpricing() {
		
		if(wP.isTextChangedForPricing()) {
			
			wP.ClearPricingPolicy();
		}
	}
	
	@And("^user created his own (.*)")
	public void writePricingyPolicy(String content) {
		
		wP.EnterPricingPolicy(content);
		
	}
	
	@When("user clicks on AddPricingPolicy")
	public void savePricingPolicy() {
		
		wP.ClickOnAddPricingPolicyButton();
	}
	
	@And("user opens gallery section")
	public void selectGallerySection() {
		
		wP.openGallerySection();
	}
	
	@And("user clear the fields if already filled")
	public void clearGallerySection() throws InterruptedException {
		
		wP.clearGalleryTitle();
		
		wP.clearGalleryDescription();
		
		int j = wP.checkLimitOfGalleryImages();
		
		if(wP.checkLimitOfGalleryImages() >=1 ) {
			
			for(int i=j; i>=1; i--) {
					
				wP.del_Image();
			
		}
			
		}
		
	}
	
	@When("^user redefines gallery (.*)  (.*) and uploads (.*),  (.*)$")
	public void enterGalleryDetails(String title, String description, String num, String image) throws InterruptedException {
		
		wP.enterGalleryTitle(title);
		
		wP.enterGalleryDescription(description);
		
		 number = Integer.parseInt(num);
		 
		 String[] imagePaths = image.split(",");
		 
		for(int i=0; i<number; i++) {
			
			if(wP.checkLimitOfGalleryImages() < 6) {
				
					if((wP.isImageFieldNotEmpty())) {
						
						wP.upload_Image(imagePaths[i].trim());
			    	
					}
					else {
						
						wP.uploadGalleryImages(imagePaths[i].trim());
					}
				}
		
			}
		}
		
	@And("clicks on save changes for gallery section")
	public void saveGallerySectionChanges() {
		
		wP.clickOnSaveGallerySection();
	}
	
	@And("user clear the image field")
	public void deleteAnyImage() {
		
		wP.del_Image();
		
	}
	
	@When("^user uploads invalid format of (.*)$")
	public void uploadInvalidImage(String image) {
		
		wP.uploadGalleryImages(image);
	}
	
	@When("^user redefined gallery (.*)  (.*)$")
	public void enterGalleryDetailsWithoutImage(String title, String description) throws InterruptedException {
		
		wP.enterGalleryTitle(title);
		
		wP.enterGalleryDescription(description);
	}
	
	@When("user uploads exisiting image")
	public void uploadExistingImage() {
		
		String basePath= "C:\\Users\\DELL\\Downloads\\";
		
		String existingsImages[] = wP.getExistingImageNames();
		
		String img = basePath + existingsImages[0];
		
		if(wP.checkLimitOfGalleryImages() == 6) {
			
			wP.del_Image();
		
		}
			
			wP.uploadGalleryImages(img);
	}
	
	@When("^(.*), (.*), (.*), (.*) are provided by user$")
	public void enterCallToActionDetails(String title, String description, String buttonText, String buttonLink) {
		
		wP.enterTitleForLeadAndCall(title);
		
		wP.enterdescripitionForLeadAndCall(description);
		
		wP.EntercallToActionButtonTextForLeadAndCall(buttonText);
		
		wP.enterCallToActionButtonLink(buttonLink);
		
	}
	
	@And("user clicks on the call to action section")
	public void selectCallToActionSection() {
		
		wP.openCallToAction();
		
	}
	
	@And("user clears the fields of call to action section")
	public void clearTheFields() {
		
		wP.clearTitleForLeadAndCall();
		
		wP.clearDescriptionForLeadAndCall();
		
		wP.clearCallToActionButtonTextForLeadAndCall();
		
		wP.clearCallToActionButtonLink();
		
	}
	
	@And("clicks on save changes for section")
	public void clickOnSaveChangesForSections() {
		
		wP.clickOnSaveGallerySection();
	}
	
	@And("clears image field if already uploaded")
	public void deleteImage() {
		
		if(!(wP.isImageFieldNotEmpty())) {
			
			wP.del_Image();
		}
	}
	
	@When("^user tries to upload (.*)$")
	public void uploadImage(String image) {
		
		wP.upload_Image(image);
	}
	
	
	
	@And("^user checks the status of (.*)$")
	public void checkStatusOfSection(String section) {
		
		switch(section) {
		
		 case "Gallery":
			 
			 ActualStatus = wP.isGallerySectionActive();
			 
			 System.out.println(ActualStatus);
			 
			 break;
			 
		 case "LeadMagnet":
			 
			 ActualStatus = wP.isLeadMagnetSectionActive();
			 
			 break;
			 
		 case "Course":
			 
			 ActualStatus = wP.isCourseSectionActive();
			 
			 break;
			 
		 case "Content":
			 
			 ActualStatus = wP.isContentSectionActive();
			 
			 break;
			 
		 case "Closing":
			 
			 ActualStatus = wP.isClosingSectionActive();
			 
			 System.out.println(ActualStatus);
			 
			 break;
			 
		 case "CallToAction":
			 
			 ActualStatus = wP.isCallToActionSectionActive();
			 
			 break;
		}
		
		if(ActualStatus == true) {
			
			sectionStatus = "Active";
		}
		else {
			
			sectionStatus = "Inactive";
				
		}
	}
	
	@When("^user changes the (.*) of (.*)$")
	public void changeStatus(String status, String section) throws InterruptedException {
		
		Thread.sleep(4000);
		
		switch(section) {
			
			case "Gallery":
				
					if(sectionStatus.equals(status)) {
					
						wP.changeStatusOfGallerySection();
						
						Thread.sleep(10000);
					
					}
				
				wP.changeStatusOfGallerySection();
		
				 break;
			
			case "LeadMagnet":
				 
				if(sectionStatus.equals(status)) {
					
					wP.changeStatusOfLeadMagnetSection();
					
				}
				
				Thread.sleep(4000);
				
				wP.changeStatusOfLeadMagnetSection();
				
				break;
				 
			 case "Course":
				 
				 if(sectionStatus.equals(status)) {
						
						wP.changeStatusOfCourseSection();
						
					}
				 
				 Thread.sleep(4000);
					
					wP.changeStatusOfCourseSection();
					
					break;
				 
			 case "Content":
				 
				 if(sectionStatus == status) {
						
						wP.changeStatusOfContentSection();
						
					}
				 Thread.sleep(4000);
					
				 wP.changeStatusOfContentSection();
					
					break;
				 
			 case "Closing":
				 
				 if(sectionStatus == status) {
						
						wP.changeStatusOfClosingSection();
						
					}
				 Thread.sleep(4000);
					
					wP.changeStatusOfClosingSection();
					
					break;
				 
			 case "CallToAction":
				 
				 if(sectionStatus.equals(status)) {
						
						wP.changeStatusOfCallToActionSection();
						
					}
				 
				 Thread.sleep(4000);
					
					wP.changeStatusOfCallToActionSection();
					
					break;		
		}
			
	}
	
	@And("if image is uploaded")
	public void checkIfImageIsUploaded() {
		
		ActualStatus = wP.isImageFieldNotEmpty();
		
	}
	
	@Then("youtube link should be disabled")
	public void isYouTubeDisabled() {
		
		Assert.assertEquals(ActualStatus, wP.isYoutubeLinkDisabled());
	}
	
	@Then("^(.*) on the website should be (.*)$")
	public void checkSectionOnUserWebsite(String section, String state) {
		
		switch(section){
			
		case "Gallery":
		
				ActualStatus = wP.isGallerySectionPresent();
		
					if(ActualStatus == true) {
			
							sectionStatus = "Present";
					}else {
							sectionStatus ="Absent";
					}
					
					break;
					
		case "Closing":
			
			ActualStatus = wP.isClosingSectionPresent();
			
			System.out.println(ActualStatus);
	
				if(ActualStatus == true) {
		
						sectionStatus = "Present";
				}else {
						sectionStatus ="Absent";
				}
			break;
	}
		Assert.assertEquals(state, sectionStatus);
	}
	
	@When("^user changed the (.*) of (.*)$")
	public void changeStatusOfSection(String status, String section) throws InterruptedException {
		
		Thread.sleep(4000);
		
		switch(section) {
			
			case "Gallery":
				
					if(!sectionStatus.equals(status)) {
					
						wP.changeStatusOfGallerySection();
						
						Thread.sleep(10000);
					}
			
				 break;
			
			case "LeadMagnet":
				 
				if(!sectionStatus.equals(status)) {
					
					wP.changeStatusOfLeadMagnetSection();
					
				}
				
				break;
				 
			 case "Course":
				 
				 if(!sectionStatus.equals(status)) {
						
						wP.changeStatusOfCourseSection();
						
					}
					
					break;
				 
			 case "Content":
				 
				 if(!sectionStatus.equals(status)) {
						
						wP.changeStatusOfContentSection();
						
					}
					
					break;
				 
			 case "Closing":
				 
				 if(!sectionStatus.equals(status)) {
						
						wP.changeStatusOfClosingSection();
						
					}
					
					break;
				 
			 case "CallToAction":
				 
				 if(!sectionStatus.equals(status)) {
						
						wP.changeStatusOfCallToActionSection();
						
					}
					
					break;		
		}
			
	}
	
	
}
