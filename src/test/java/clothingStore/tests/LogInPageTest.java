package clothingStore.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import clothingStore.pageObject.HomePage;
import clothingStore.pageObject.LogInPage;
import clothingStore.pageObject.MyAccountPage;
import clothingStore.testComponents.BaseTest;


public class LogInPageTest extends BaseTest{
	
	LogInPage logInPage;
	HomePage homePage;
	MyAccountPage  myAccountPage;
	String newEmail="ymaki@hotmail.com";
	String userEmail="dummyadresa1@gmail.com";
	String password= "MvPPVjTE9qm3Pwn";
	String expectedLoggedInMessage = "Welcome to your account page";
	String expectedErrorMsg= "Error: Username is required.";
	String wrongEmail="hthth@outlook.com";
	String wrongPassword="1111111";
	String wrongDataMsg="ERROR: The username or password you entered is incorrect. Lost your password?";
	String expectedRegistrationErrorMsg=" Please provide a valid email address.";
	
	
	@Test(description="When entering valid email in the registration form user should be able to register successfully.")
	public void validateRegisterOption() {
		LogInPage logInPage=new LogInPage(driver);
		logInPage=logInPage.goToLogInPage();
		myAccountPage=logInPage.registerWithEmail(newEmail);	
	}
	@Test(description="When user tries to register without entering details, error message with expected text should be displayed"
			,groups="errorValidation")
	public void varifyRegistrationErrorMessage() {
		homePage=new HomePage(driver);
		logInPage=homePage.goToLogInPage();
		logInPage.registerWithoutEmail();
		String registrationErrorMsg=logInPage.getErrorMessage();
		Assert.assertEquals(expectedRegistrationErrorMsg, registrationErrorMsg); 
		
	} 
	
   @Test (description="When users is successfully logged in, new Page with account information should be displayed as well as welcoming message with expected text")
   public void verifyMsgWhenLoggingWithCorrectData() {
	   homePage=new HomePage(driver);
	   logInPage=homePage.goToLogInPage();
	   myAccountPage= logInPage.logIn(userEmail, password);  
	   String actuaLoggedInMsg= myAccountPage.getWelcomeMessage(); 
	   Assert.assertEquals(actuaLoggedInMsg, expectedLoggedInMessage);
   }
   
   @Test (description="When user tries to register without entering details, error message with expected text should be displayed", groups="errorValidation")
   public void verifyErrorMsgWhenLoggingWithoutData() {
	   homePage=new HomePage(driver);
	   logInPage=homePage.goToLogInPage();
	   logInPage.clickOnLogInBtn();
	   String actualMsg=logInPage.getErrorMessage();
	   Assert.assertEquals(actualMsg, expectedErrorMsg);
   } 
   
   @Test(description="If wrong data is entered, logging should be unabled and error message with expected text should be displayes",
		   groups="errorValidation")
   public void verifyMessageWhenLoggingInWithWrongData() {
	   homePage=new HomePage(driver);
	   logInPage=homePage.goToLogInPage();
	   logInPage.logIn(wrongEmail, wrongPassword); 
	   String wrongPswMsg=logInPage.getErrorMessage();
	   Assert.assertEquals(wrongDataMsg, wrongPswMsg);
   }
   
	
}
