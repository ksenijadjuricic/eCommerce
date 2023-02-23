package clothingStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class ResetPasswordPage extends AbstractComponents{
WebDriver driver;
	public ResetPasswordPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath=".woocommerce-error")
	WebElement paragraph;
	@FindBy (id="user_login")
	WebElement emailField;
	@FindBy(xpath="//p[contains(@class,'woocommerce-form-row')]/button")
	WebElement resetBtn;
	@FindBy (css=".woocommerce-message")
	WebElement message;


public String getErrorMessage() {
	waitForElementToAppear(paragraph);
	String message=paragraph.getText();
	return message;
}
/*public void getEmail(String email) {
	emailField.sendKeys(email);
} */
public void clickOnResetPsw() {
	resetBtn.click();
} 
public void resetPassword(String email) {
	emailField.sendKeys(email);
	resetBtn.click();
	
}
public String getMessage() {
	String messageText=message.getText();
	return messageText;
	
}



}