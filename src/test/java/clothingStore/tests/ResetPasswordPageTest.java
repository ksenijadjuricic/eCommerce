package clothingStore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import clothingStore.pageObject.LogInPage;
import clothingStore.pageObject.ResetPasswordPage;
import clothingStore.testComponents.BaseTest;

public class ResetPasswordPageTest extends BaseTest {
	LogInPage logInPage;
	ResetPasswordPage resetPasswordPage;
	String expectedText="Enter a username or email address.";
	String email="ymakis@gmail.com";
	String expectedMessage= "Password reset email has been sent.";
	
	@Test(description="When clicking on Reset Password without providing data,error message with expected text should be displayed" ,
			groups= "errorValidaton")
	public void verifyErrorMessage() {
		logInPage=new LogInPage(driver);
		ResetPasswordPage resetPasswordPage=logInPage.goToLostYouPassword();
		resetPasswordPage.clickOnResetPsw();
		String message=resetPasswordPage.getErrorMessage();
		Assert.assertEquals(message,expectedText);
	}
	

		@Test(description="When entering email and clicking on Reset Password, message with expected text should be displayed")
		public void resetPasswordAndVerifyMessage() {
			logInPage=new LogInPage(driver);
			ResetPasswordPage resetPasswordPage=logInPage.goToLostYouPassword();
			resetPasswordPage.resetPassword(email);
			String message=resetPasswordPage.getMessage();
			Assert.assertEquals(message, expectedMessage);
		}
			
		
		

}

