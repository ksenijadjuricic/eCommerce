package clothingStore.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
/*  @FindBy ()
	WebElement ;  */
	@FindBy (id="billing_first_name")
	WebElement firstNameField ;
	@FindBy (id="billing_last_name")
	WebElement lastNameField;
	@FindBy (id="billing_company")
	WebElement companyField ;
	@FindBy (id="billing_address_1")
	WebElement addressField ;
	@FindBy (id="billing_address_2")
	WebElement apartmentField ;
	@FindBy (id="billing_city")
	WebElement cityField;
	@FindBy (id="billing_postcode")
	WebElement zipField;
	@FindBy (id="billing_phone")
	WebElement phoneField;
	@FindBy (id="billing_email")
	WebElement emailField;
	@FindBy (id="order_comments")
	WebElement commentsField;
	@FindBy (xpath="(//span[contains(@class,'select2-selection')])[2]")
	WebElement countryDropdown;
	@FindBy (xpath="//li[contains(@class,'select2-results__option' )]")
	List <WebElement> countryOptions;
	@FindBy (xpath="(//span[contains(@class,'selection__rendered')])[2]")
	WebElement districtField;
	@FindBy (css=".woocommerce-message")
	WebElement textMsg;
	
	@FindBy(xpath="//*[@id='select2-billing_state-container']")
	WebElement districtDrp;
	
	@FindBy (css="li[class='select2-results__option']")
	List <WebElement> districtOptions;
	//By results=By.cssSelector(".select2-results");
	public void fillIn(String firstName, String lastName, String companyName, String address,String apartmentNumber,String cityName
			, String zipNumber, String phoneNumber,String email,String notes) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		companyField.sendKeys(companyName);
		addressField.sendKeys(address);
		apartmentField.sendKeys(apartmentNumber);
		cityField.sendKeys(cityName);
		zipField.sendKeys(zipNumber);
		phoneField.sendKeys(phoneNumber);
		emailField.sendKeys(email);
		commentsField.sendKeys(notes);
		
		
		
	}
	public void DistrcitSelection(String value)
	{
		driver.findElement(By.xpath("//li[text()='"+value+"']")).click();
	}
	 public void countrySelection(String countryName) {
		 driver.findElement(By.xpath("//li[text()='"+countryName+"']")).click();
	 }
	public void SelectDistrcit(String districtName)
	{
		districtDrp.click();
		DistrcitSelection(districtName);
	}

	public void selectCountry(String countryName) {
		waitForElementToAppear(countryDropdown);
		countryDropdown.click();
		countrySelection(countryName);
	}
	
	public String getMessage() {
		waitForElementToAppear(textMsg);
     String  message=textMsg.getText();
    return message;


}
}
