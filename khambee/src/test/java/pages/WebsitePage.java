package pages;

import java.time.Duration;
import pages.*;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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

public class WebsitePage {

	WebDriver driver;
	
	CommoMethods waitHelper;
	
	Actions actions;
	
	@FindBy(xpath="//button[@role='tab']")
	WebElement websiteHomePage;
	
	@FindBy(xpath="(//h1[normalize-space()='Hero Section*']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement heroDropDown;
	
	@FindBy(xpath="(//h1[normalize-space()='Course Section*']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement courseDropDown;
	
	@FindBy(xpath="(//h1[normalize-space()='Content Section']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement contentDropDown;
	
	@FindBy(xpath="(//h1[normalize-space()='Closing Section']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement closingDropDown;
	
	@FindBy(xpath="(//h1[normalize-space()='Footer Section*']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement footerDropDown;

	@FindBy(xpath="//h3[normalize-space()='Hero Title*']")
	WebElement heroTitle;
	
	@FindBy(xpath="//h3[normalize-space()='Closing Title*']")
	WebElement closingTitle;
	
	@FindBy(xpath="//h3[normalize-space()='Choose Orientation of the Section*']")
	WebElement contentTitle;
	
	@FindBy(xpath="//h3[normalize-space()='Course Section Title*']")
	WebElement courseTitle;
	
	@FindBy(xpath="//h3[normalize-space()='Section Title*']")
	WebElement slotTitle;
	
	@FindBy(xpath="//h1[normalize-space()='Footer Section*']")
	WebElement footerTitle;
	
	@FindBy(xpath="//div[@class='OrientationSection']//input[@type='text']")
	WebElement Title;
	
	@FindBy(xpath="//div[@class='OrientationSection']//textarea[@type='text']")
	WebElement description;
	
	@FindBy(id="company-logo")
	WebElement imageUpload;
	
	@FindBy(xpath="//span[@class='blue__text']")
	WebElement clicktoUpload;
	
	@FindBy(xpath="//input[@placeholder='Enter the YouTube link for your video here']")
	WebElement youTubeLinkForContentSection;
	
	@FindBy(xpath="//input[@placeholder='Enter the name of your Brand here']")
	WebElement brandName;
	
	@FindBy(xpath="//input[@placeholder='Enter your Instagram Profile links here']")
	WebElement insta;
	
	@FindBy(xpath="//input[@placeholder='Enter your Facebook Profile link here']")
	WebElement facebook;
	
	@FindBy(xpath="//input[@placeholder='Enter your YouTube Channel links here']")
	WebElement youTube;
	
	@FindBy(xpath="(//div[@class='imgUploadedCourse']//*[name()='svg'])[2]")
	WebElement delImage;
	
	@FindBy(xpath="//button[@class='saveBtn']")
	WebElement save;
	
	@FindBy(xpath="//div[@role='status']")
	WebElement toast;
	
	@FindBy(xpath="//section[@class='HeroSectionContainer']")
	WebElement herosection;
	
	@FindBy(xpath="//div[@class='OrientationSection']//select")
	WebElement selecOpt;
	
	@FindBy(xpath="//button[@class='deleteBtn']")
	WebElement deleteSection;
	
	@FindBy(xpath="//h3[normalize-space()='Delete this Section']")
	WebElement deletePopUp;
	
	@FindBy(xpath="//button[@class='deletebtn']")
	WebElement deleteConfirm;
	
	@FindBy(xpath="//button[@class='CancelIndelete']")
	WebElement cancelDelete;
	
	@FindBy(xpath="//button[normalize-space()='Add a New Section']")
	WebElement addNewSection;
	
	@FindBy(xpath="//button[normalize-space()='Add Section']")
	WebElement addSection;
	
	@FindBy(xpath="//span[contains(text(),'Provide the content for the ')]")
	WebElement heading;
	
	@FindBy(xpath="//section[@id='ContentSectionFormContainer']//input/ancestor::section/preceding-sibling::section/header[@class='TitleContainer']//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
	WebElement Toggle;
	
	@FindBy(xpath="//section[@class='CourseSectionFormContainer']//input/ancestor::section/preceding-sibling::section/header[@class='TitleContainer']//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
	WebElement courseToggle;
	
	@FindBy(xpath="//input[@placeholder='Enter your Brand Tagline here']")
	WebElement BrandTagline;
	
	@FindBy(xpath="//input[@placeholder='Eg. 2024 Khambee']")
	WebElement BrandCopyRight;
	
	@FindBy(xpath="//input[@placeholder='Enter your Twitter(X) Profile link here']")
	WebElement TwitterUrl;
	
	@FindBy(xpath="//input[@placeholder='Enter your LinkedIn Profile link here']")
	WebElement LinkedInUrl;
	
	@FindBy(xpath="(//div[@class='backlink']//button)[1]")
	WebElement TermsAndConditionsButton;
	
	@FindBy(xpath="(//div[@class='backlink']//button)[2]")
	WebElement DeliverAndShippingPolicyButton;
	
	@FindBy(xpath="(//div[@class='backlink']//button)[3]")
	WebElement RefundPolicyButton;
	
	@FindBy(xpath="(//div[@class='backlink']//button)[4]")
	WebElement PrivacyPolicyButton;
	
	@FindBy(xpath="(//div[@class='backlink']//button)[5]")
	WebElement PricingPolicyButton;
	
	@FindBy(xpath="//textarea[@name='Terms and Conditions']")
	WebElement TextBoxForTermsAndConditions;
	
	@FindBy(xpath="//button[normalize-space()='Add Terms and Conditions']")
	WebElement AddTermsAndConditionsButton;
	
	@FindBy(xpath="//h4[normalize-space()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//textarea[@name='Delivery & Shipping Policy']")
	WebElement TextBoxForDeliverAndShipping;
	
	@FindBy(xpath="//button[normalize-space()='Add Delivery & Shipping Policy']")
	WebElement AddDeliverAndShippingButtonPolicyButton;
	
	@FindBy(xpath="//textarea[@name='Refund Policy']")
	WebElement TextBoxForRefundPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Add Refund Policy']")
	WebElement AddRefundPolicyButton;
	
	@FindBy(xpath="//textarea[@name='Privacy Policy']")
	WebElement TextBoxForPrivacyPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Add Privacy Policy']")
	WebElement AddPrivacyPolicyButton;
	
	@FindBy(xpath="//textarea[@name='Pricing Policy']")
	WebElement TextBoxForPricingPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Add Pricing Policy']")
	WebElement AddPricingPolicyButton;
	
	@FindBy(xpath="(//button[contains(text(),'View Website')])[2]")
	WebElement visitWebsite;
	
	@FindBy(xpath="(//h1[normalize-space()='Gallery Section']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement gallerySectionDropdown;
	
	@FindBy(xpath="//h3[contains(text(),'Gallery Title*')]/parent::div//input")
	WebElement galleryTitle;
	
	@FindBy(xpath="//section[@id='ContentSectionFormContainer']//div[@class='description']//textarea")
	WebElement galleryDescription;
	
	@FindBy(xpath="//button[@class=\"addBtn\"]/parent::div//input")
	WebElement addImageForGallery;
	
	@FindBy(xpath="//button[@class='commnSaveBtn']")
	WebElement saveGallerySection;
	
	@FindBy(xpath="(//h1[normalize-space()='Call To Action Section']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement callToActionDropDown;
	
	@FindBy(xpath="//h3[contains(text(),'Section Title*')]/parent::div//input")
	WebElement titleForLeadAndCall;
	
	@FindBy(xpath="//section[@id='ContentSectionFormContainer']//div[@class='description']//textarea")
	WebElement descriptionForLeadAndCall;
	
	@FindBy(xpath="//h3[contains(text(),'Call To Action Button Text*')]/parent::div//input")
	WebElement callToActionButtonTextForLeadAndCall;
	
	@FindBy(xpath="//h3[contains(text(),'Call To Action Button Link*')]/parent::div//input")
	WebElement callToActionButtonLink;
	
	@FindBy(xpath="(//h1[normalize-space()='Lead Magnet Section']/ancestor::header[@class='TitleContainer']/child::div[@class='activeSectionContainer']//span)[1]")
	WebElement LeadMagnetSectionDropDown;
	
	@FindBy(xpath="(//h3[contains(text(),'Users Mobile Number')]/parent::div/child::div//input)[1]")
	WebElement mobileNumberCheckBox;
	
	@FindBy(xpath="(//h3[contains(text(),'Users Name')]/parent::div/child::div//input)[1]")
	WebElement usersNameCheckBox;
	
	@FindBy(xpath="//h1[contains(text(),'Course Section*')]/parent::div/preceding-sibling::div//div//div[contains(@class, 'MuiStack-root')]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForCourse;
	
	@FindBy(xpath="//h1[contains(text(),'Lead Magnet Section')]/parent::div/preceding-sibling::div//div//div[contains(@class, 'MuiStack-root')]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForLeadMagnet;
	
	@FindBy(xpath="//h1[contains(text(),'Gallery Section')]/parent::div/preceding-sibling::div//div//div[contains(@class, 'MuiStack-root')]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForGallery;
	
	@FindBy(xpath="//h1[contains(text(),'Call To Action Section')]/parent::div/preceding-sibling::div//div//div[contains(@class, 'MuiStack-root')]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForCallToAction;
	
	@FindBy(xpath="//h1[contains(text(),'Content Section')]/parent::div/preceding-sibling::div//div//div[contains(@class, 'MuiStack-root')]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForContent;
	
	@FindBy(xpath="//h1[contains(text(),'Closing Section')]/parent::div/preceding-sibling::div//div//div[contains(@class, 'MuiStack-root')]//span[contains(@class, 'MuiButtonBase-root')]")
	WebElement toggleForClosing;
	
	@FindBy(xpath="//input[@placeholder='Enter the YouTube link for your video here']")
	WebElement youTubeLinkForContent;
	
	@FindBy(xpath="//section[@class='HeroSecContainer']")
	WebElement heroSection;
	
	@FindBy(xpath="//div[@class='GallerySectionContainer']")
	WebElement gallerySection;
	
	@FindBy(xpath="//div[@class='courseSection-Container']")
	WebElement courseSection;
	
	@FindBy(xpath="//section[@class='LeadMagnetSection']")
	WebElement leadMagnetSection;
	
	@FindBy(xpath="//div[@class='ctaSection-container']")
	WebElement CTAsection;
	
	@FindBy(xpath="//div[@class='closingSectionContainer']")
	WebElement closingSection;
	
	@FindBy(xpath="(//section[@class='MainContentContainer '])[1]")
	WebElement contentSection;
	
	
	
	public WebsitePage(WebDriver driver) {
		 
		 this.driver = driver; 
		 
		 this.waitHelper = new CommoMethods(driver);
		 
		 this.actions = new Actions(driver);
		 
		 PageFactory.initElements(driver, this); 
	 }
 
 	
	public String validate_website_section() {
 		
 		String website_Section_Heading = websiteHomePage.getText();
 		
 		return website_Section_Heading;
 	}
	
	
	public int  check_no_of_Section() {
		
		int no_of_section;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> default_no_of_sections = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='HeroSectionContainer']")));
		
		no_of_section = default_no_of_sections.size();
		
		System.out.print(no_of_section);
		
		return no_of_section;
	}
	
	public void opening_hero_section() {

		heroDropDown.click();

	}
	
	public void opening_content_section() {
		
		contentDropDown.click();
	}
	
	public void opening_closing_section() {
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", closingDropDown);*/

		closingDropDown.click();

	}
	
	public void opening_course_section() {
		
		courseDropDown.click();
	}
	
	
	public void opening_footer_section() {
		
		footerDropDown.click();
	}

	public String validate_Hero_section() {
		
		String title;
		
		title = heroTitle.getText();
		
		return title;
	}
	public String validate_content_section() {
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)" );*/
		
		String title;
		
		title = contentTitle.getText();
		
		return title;
	}
	
	
	public String validate_closing_section() {
				
		String title;
		
		title = closingTitle.getText();
		
		return title;
	}
	
	public String validate_course_section() {
		
		
		String title;
		
		title = courseTitle.getText();
		
		return title;
	}
	
	
	public String validate_footer_section() {
		
		waitHelper.scrollToElement(footerTitle);
		
		String title;
		
		title = footerTitle.getText();
		
		return title;
	}
	
	public void clear_title() {
		
		Title.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	
	public void clear_description() {
		
		description.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	public boolean check_delete_image_is_displayed() {
		
		boolean intialUpload = delImage.isDisplayed();
		
		System.out.println(intialUpload);
		
		return intialUpload;
	}
	
	public void del_Image() {
		
		delImage.click();
		
	}
	
	public void clear_brand_name() {
		
		brandName.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void clear_insta_link() {
		
		insta.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}

	public void clear_face_book_link() {
	
		facebook.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}

	public void clear_you_tube_link() {
	
		youTube.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
   public void select_option(String choosedOption) throws InterruptedException {
		
		selecOpt.click();
		
		Thread.sleep(3000);
		
		Select myOption = new Select(selecOpt);
		
		myOption.selectByVisibleText(choosedOption);
		
	}
	
	public void deleting_section() {
		
		deleteSection.click();
	}
	
	public boolean check_delete_Section_display() {
		
		boolean isDeleteButtonPresent;
		
		try {
		    
		    isDeleteButtonPresent = deleteSection.isDisplayed();
		
		} catch (Exception e) {
		   
			isDeleteButtonPresent = false;
		}
		
		return isDeleteButtonPresent;
	}
	
	public boolean check_delete_popup() {
		
		boolean isdeletepoupdisplayed;
		
		try {
		    
			isdeletepoupdisplayed = deleteSection.isDisplayed();
		
		} catch (Exception e) {
		   
			isdeletepoupdisplayed = false;
		}
		
		return isdeletepoupdisplayed;
		
	}
	
	public void confirm_delete_section() {
		
		deleteConfirm.click();
	}
	
	
	public void enter_title(String giventitle) {
		
		Title.sendKeys(giventitle);
		
	}
	
	public void enter_description(String describe) {
		
		description.sendKeys(describe);
		
	}
	
	public void upload_Image(String Img) {
		
		imageUpload.sendKeys(Img);
	
	}
	
	public void enterYouTubeLink(String link) {
		
		youTubeLinkForContent.sendKeys(link);
	}
	
	public void clearYouTubeLink() {
		
		youTubeLinkForContent.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public boolean isYoutubeLinkDisabled() {
		
		boolean status = youTubeLinkForContent.isEnabled();
		
		return status;
	}
	public void enter_brand_name(String giventitle) {
		
		
		brandName.sendKeys(giventitle);
		
	}
	
	public void enter_insta_link(String giventitle) {
	
		insta.sendKeys(giventitle);
	
	}

	public void enter_face_book_link(String giventitle) {
	
		facebook.sendKeys(giventitle);
	
	}

	public void enter_you_tube_link(String giventitle) {
	
		youTube.sendKeys(giventitle);
	
	}
	
	public void click_add_new_section() {
		
		addNewSection.click();
	}
	
	public boolean check_add_new_section_button() throws InterruptedException {
		
		Thread.sleep(2000);
		
		boolean isAddNewSectionDisplayed ;
		
		try{
			isAddNewSectionDisplayed = addNewSection.isDisplayed();
			
			System.out.println(isAddNewSectionDisplayed);
		}
		catch (Exception e) {
			   
			isAddNewSectionDisplayed = false;
		}
		
		
		return isAddNewSectionDisplayed;
	}
	
	public void click_add_section() {
		
		addSection.click();
	}
	
	public boolean isAddSectionDisabled() {
		
		boolean AddSectionDisabled = addSection.isEnabled();
		
		return AddSectionDisabled;
	}
	
	public String get_new_Section_form_heading() {
		
		String formHeading = heading.getText();
		
		return formHeading;
	
	}

	public void save_changes() {
		
		save.click();
	}
	
	public boolean isSaveChangesEnabled() {
		
		boolean saveChanges = save.isEnabled();
		
		return saveChanges;
	}
	
	public void EnterBrandTagLine(String tagLine) {
		
		BrandTagline.sendKeys(tagLine);
	}
	
	public void ClearBrandTagLine() {
		
		BrandTagline.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void EnterBrandCopyRight(String copyRight) {
		
		BrandCopyRight.sendKeys(copyRight);
	}
	
	public void ClearBrandCopyRight() {
		
		BrandCopyRight.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void EnterTwitterUrl(String url) {
		
		TwitterUrl.sendKeys(url);
	}
	
	public void ClearTwitterUrl() {
		
		TwitterUrl.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void EnterLinkedInUrl(String url) {
		
		LinkedInUrl.sendKeys(url);
	}
	
	public void ClearLinkedInUrl() {
		
		LinkedInUrl.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	//Terms and conditions in footer
	
	public void ClickOnAddTermsAndConditions() {
		
		TermsAndConditionsButton.click();
	}
	
	public boolean isTextChangedForTermsAndConditions() {
		
		String text ="Show Terms and Conditions";
		
		String changedText= TermsAndConditionsButton.getText();
		
		boolean isTextChanged;
		
		if(text.equalsIgnoreCase(changedText)) {
			
			isTextChanged = true;
		}
		
		else {
			isTextChanged = false;
		}
		
		return isTextChanged;
	}
	
	public void EnterTermsAndConditions(String TermsAndConditions) {
		
		TextBoxForTermsAndConditions.sendKeys(TermsAndConditions);
	}
	
	public void ClearTermsAndConditions() {
		
		TextBoxForTermsAndConditions.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void ClickOnAddTermsAndCondtionsButton() {
		
		AddTermsAndConditionsButton.click();
	}
	
	
	
	
	//Delivery and shipping policy in footer
	
	public void ClickOnAddDeliveryAndShippingPolicy() {
		
		DeliverAndShippingPolicyButton.click();
	}
	
	public boolean isTextChangedForDeliveryAndShipping() {
		
		String text ="Show Delivery & Shipping Policy";
		
		String changedText= DeliverAndShippingPolicyButton.getText();
		
		boolean isTextChanged;
		
		if(text.equalsIgnoreCase(changedText)) {
			
			isTextChanged = true;
		}
		
		else {
			isTextChanged = false;
		}
		
		return isTextChanged;
	}
	
	public void EnterDeliveryAndShippingPolicy(String TermsAndConditions) {
		
		TextBoxForDeliverAndShipping.sendKeys(TermsAndConditions);
	}
	
	public void ClearDeliveryAndShippingPolicy() {
		
		TextBoxForDeliverAndShipping.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void ClickOnAddDeliveryAndShippingPolicyButton() {
		
		AddDeliverAndShippingButtonPolicyButton.click();
	}
	
	
	//Refund Policy in Footer
	
	public void ClickOnAddRefundPolicy() {
		
		RefundPolicyButton.click();
	}
	
	public boolean isTextChangedForRefund() {
		
		String text ="Show Refund Policy";
		
		String changedText= RefundPolicyButton.getText();
		
		boolean isTextChanged;
		
		if(text.equalsIgnoreCase(changedText)) {
			
			isTextChanged = true;
		}
		
		else {
			isTextChanged = false;
		}
		
		return isTextChanged;
	}
	
	public void EnterRefundPolicy(String TermsAndConditions) {
		
		TextBoxForRefundPolicy.sendKeys(TermsAndConditions);
	}
	
	public void ClearRefundPolicy() {
		
		TextBoxForRefundPolicy.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void ClickOnAddRefundPolicyButton() {
		
		AddRefundPolicyButton.click();
	}
	
	//privacy policy in footer
	
	public void ClickOnAddPrivacyPolicy() {
		
		PrivacyPolicyButton.click();
	}
	
	public boolean isTextChangedForPrivacy() {
		
		String text ="Show Privacy Policy";
		
		String changedText= PrivacyPolicyButton.getText();
		
		boolean isTextChanged;
		
		if(text.equalsIgnoreCase(changedText)) {
			
			isTextChanged = true;
		}
		
		else {
			isTextChanged = false;
		}
		
		return isTextChanged;
	}
	
	public void EnterPrivacyPolicy(String TermsAndConditions) {
		
		TextBoxForPrivacyPolicy.sendKeys(TermsAndConditions);
	}
	
	public void ClearPrivacyPolicy() {
		
		TextBoxForPrivacyPolicy.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void ClickOnAddPrivacyPolicyButton() {
		
		AddPrivacyPolicyButton.click();
	}
	
	//Pricing policy in footer
	public void ClickOnAddPricingPolicy() {
		
		PricingPolicyButton.click();
	}
	
	public boolean isTextChangedForPricing() {
		
		String text ="Show Pricing Policy";
		
		String changedText= PricingPolicyButton.getText();
		
		boolean isTextChanged;
		
		if(text.equalsIgnoreCase(changedText)) {
			
			isTextChanged = true;
		}
		
		else {
			isTextChanged = false;
		}
		
		return isTextChanged;
	}
	
	public void EnterPricingPolicy(String TermsAndConditions) {
		
		TextBoxForPricingPolicy.sendKeys(TermsAndConditions);
	}
	
	public void ClearPricingPolicy() {
		
		TextBoxForPricingPolicy.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void ClickOnAddPricingPolicyButton() {
		
		AddPricingPolicyButton.click();
	}
	
	
	public String get_Toast() {
		
		String alert;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	    wait.until(ExpectedConditions.visibilityOf(toast));
		
	    alert = toast.getText();
		
		return alert;
		
	}
	
	public boolean isImageFieldNotEmpty() {
		   
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	        
	        wait.until(ExpectedConditions.visibilityOf(clicktoUpload));
	        
	        return true; // Element is found and visible
	    } catch (Exception e) {
	        
	    	return false; // Element is not found or visible
	    }
	
	
	}
	
	public void openGallerySection() {
		
		gallerySectionDropdown.click();
		
	}
	
	public void enterGalleryTitle(String title) {
		
		galleryTitle.sendKeys(title);
	}
	
	public void clearGalleryTitle() {
		
		galleryTitle.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enterGalleryDescription(String description) {
		
		galleryDescription.sendKeys(description);
		
	}
	
	public void clearGalleryDescription() {
		
		galleryDescription.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	
	public void uploadGalleryImages(String image) {
		
		addImageForGallery.sendKeys(image);
	}
	
	public int checkLimitOfGalleryImages() {
		
		List<WebElement> limit = driver.findElements(By.xpath("//div[@class='imgUploadedCourse']"));
		
		int count= limit.size();
		
		return count;
	}
	
	public void clickOnSaveGallerySection() {
		
		saveGallerySection.click();
		
	}
	
	public String[] getExistingImageNames() {
		
		List<WebElement> paths = driver.findElements(By.xpath("//div[@class=\"file_name\"]//h5"));
		
		String[] pathurl = new String[paths.size()];
		
		for(int i=0; i<pathurl.length;i++) {
			
			pathurl[i] = paths.get(i).getText();
		}
	
		return pathurl;
	}
	
	
	public void clickOnVisitWebsite() {
		
		
		visitWebsite.click();
	}
	
	public void openCallToAction() {
		
		callToActionDropDown.click();
	}
	
	public void enterTitleForLeadAndCall(String title) {
		
		titleForLeadAndCall.sendKeys(title);
	}
	
	public void clearTitleForLeadAndCall() {
		
		titleForLeadAndCall.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enterdescripitionForLeadAndCall(String description) {
		
		descriptionForLeadAndCall.sendKeys(description);
	}
	
	public void clearDescriptionForLeadAndCall() {
		
		descriptionForLeadAndCall.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void EntercallToActionButtonTextForLeadAndCall(String text) {
		
		callToActionButtonTextForLeadAndCall.sendKeys(text);
	}
	
	public void clearCallToActionButtonTextForLeadAndCall() {
		
		callToActionButtonTextForLeadAndCall.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
	}
	
	public void enterCallToActionButtonLink(String link) {
		
		callToActionButtonLink.sendKeys(link);
	}
	
	public void clearCallToActionButtonLink() {
		
		callToActionButtonLink.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		
	}
	
	public void changeStatusOfGallerySection() {
		
		
		toggleForGallery.click();
	}
	
	public boolean isGallerySectionActive() {
		
		
		boolean Toggle = toggleForGallery.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return Toggle;
	}
	
	public void changeStatusOfCourseSection() {
		
		toggleForCourse.click();
	}
	
	public boolean isCourseSectionActive() {
		
		
		boolean Toggle = toggleForCourse.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return Toggle;
	}
	
	public void changeStatusOfContentSection() {
		
		toggleForContent.click();
	}
	
	public boolean isContentSectionActive() {
		
		
		boolean Toggle = toggleForContent.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return Toggle;
	}
	
	public void changeStatusOfCallToActionSection() {
		
		toggleForCallToAction.click();
	}
	
	public boolean isCallToActionSectionActive() {
		
		
		boolean Toggle = toggleForCallToAction.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return Toggle;
	}
	
	public void changeStatusOfLeadMagnetSection() {
		
		toggleForLeadMagnet.click();
	}
	
	public boolean isLeadMagnetSectionActive() {
		
		
		boolean Toggle = toggleForLeadMagnet.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return Toggle;
	}
	
	public void changeStatusOfClosingSection() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closingDropDown);
		
		toggleForClosing.click();
	}
	
	public boolean isClosingSectionActive() {
		
		
		boolean Toggle = toggleForClosing.getAttribute("class").contains("Mui-checked Mui-checked");
		
		return Toggle;
	}
	
	public boolean isGallerySectionPresent() {
		
		try {
			
			return gallerySection.isDisplayed();
		
		} catch(NoSuchElementException e) {
			
			System.out.println("in catch");
			
			return false;
		}
		
	}
	
	public boolean isContentSectionPresent() {
		
		try {
		
			return contentSection.isDisplayed();
		
		}catch (NoSuchElementException e) {
			
			System.out.println("in catch");
			return false;
		}
	
	}
	
	public boolean isClosingSectionPresent() {
		
		try {
			
			return closingSection.isDisplayed();
	    
		} catch (NoSuchElementException e) {
	        
			
	        return false;
	    }
		
	}
	public boolean isLeadSectionPresent() {
		
		try { 
		
			return leadMagnetSection.isDisplayed();
		
		}catch (NoSuchElementException e) {
			
			return false;
		}
	}	
	
	public boolean isCTASectionPresent() {
		
		try {
			
			return CTAsection.isDisplayed();
		
		}catch (NoSuchElementException e) {
			
			return false;
			
		}
	}
	
	
}