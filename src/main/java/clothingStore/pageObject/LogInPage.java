package clothingStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class LogInPage extends AbstractComponents{
    WebDriver driver;
	public LogInPage(WebDriver driver) {
		super(driver);
	    this.driver=driver;
	    PageFactory.initElements(driver, this);

}
	@FindBy (id="username")
	WebElement usernameField;
	@FindBy (id="password")
	WebElement passwordField;
	@FindBy (css="button[name='login']")
	WebElement logInBtn;
	@FindBy (css=".mob-hide")
	WebElement lostYourPassword;
	@FindBy (css=".woocommerce-error")
	WebElement errorMessage;
	@FindBy (css="input[name='email']")
	WebElement emailField;
	@FindBy (css="button[name='register']")
	WebElement registerBtn;

	

	
	
	public MyAccountPage logIn(String username, String password) {
		waitForElementToAppear(usernameField);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		logInBtn.click();
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		return myAccountPage;
		
	}
	
	 
	 public ResetPasswordPage goToLostYouPassword() {
			goToLogInPage();
			lostYourPassword.click();
			ResetPasswordPage resetPasswordPage=new ResetPasswordPage(driver);
			return resetPasswordPage;
	 }

	 
	 public String getErrorMessage() {
		 waitForElementToAppear(errorMessage);
		 String text=errorMessage.getText();
		 return text;
	 }
	 
	 public void clickOnLogInBtn() {
		 logInBtn.click();
	 }
	 public MyAccountPage registerWithEmail(String email) {
		 goToLogInPage();
		 emailField.sendKeys(email);
		 registerBtn.click();
		 MyAccountPage myAccountPage=new MyAccountPage(driver);
		 return myAccountPage;
	 }
	 public void registerWithoutEmail() {
		 goToLogInPage();
		 registerBtn.click();
	 }
	
}