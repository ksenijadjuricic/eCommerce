package clothingStore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import clothingStore.pageObject.AccountDetailsPage;
import clothingStore.pageObject.AddressPage;
import clothingStore.pageObject.HomePage;
import clothingStore.pageObject.LogInPage;
import clothingStore.pageObject.MyAccountPage;
import clothingStore.pageObject.RecentOrdersPage;
import clothingStore.testComponents.BaseTest;

public class MyAccountPageTest extends BaseTest {
	
	HomePage homePage;
	LogInPage logInPage;
	MyAccountPage myAccountPage;
	RecentOrdersPage recentOrdersPage;
	AddressPage addressPage;
	  AccountDetailsPage accountDetailsPage;
	
	String userEmail="dummyadresa1@gmail.com";
	String password= "MvPPVjTE9qm3Pwn";
	int expectedNmbrOfDisplayedProducts=7;
	
	@Test
	public void logIn() {
		   homePage=new HomePage(driver);
		   logInPage=homePage.goToLogInPage();
		   myAccountPage= logInPage.logIn(userEmail, password); 
	}
	
	@Test(description="When clicking on Recent Orders options, new Page with displayed orders should be displayed",
			dependsOnMethods="logIn")
	public void validateRecentOrdersButton() {
		
		 recentOrdersPage=myAccountPage.goToRecentOrders();
		
	}
	
@Test(description="When clicking on Address options, new Page with displayed shipping and billing address should be displayed")
	public void validateAddressButton() {
		homePage=new HomePage(driver);
		   logInPage=homePage.goToLogInPage();
		   myAccountPage= logInPage.logIn(userEmail, password); 
		  addressPage=myAccountPage.goToAddressPage();
		
	}
	
	@Test(description="When clicking on Account Details options, new Page with options to modify account informations should be displayed",
			dependsOnMethods="logIn")
	public void validateAccountDetailsButton() {
		homePage=new HomePage(driver);
		   logInPage=homePage.goToLogInPage();
		   myAccountPage= logInPage.logIn(userEmail, password); 
		   accountDetailsPage=myAccountPage.goToAccountDetailsPage();
		
	}
	
	@Test(description="Number of Products displayed should be the same as the number customer required",
			 dependsOnMethods="logIn")
		public void validateTheNumberOfDisplayedProducts() {
		homePage=new HomePage(driver);
		   logInPage=homePage.goToLogInPage();
		   myAccountPage= logInPage.logIn(userEmail, password); 
			int actualNmbrOfDisplayedProducts=myAccountPage.getDisplayedProductsList();
			Assert.assertEquals(actualNmbrOfDisplayedProducts,expectedNmbrOfDisplayedProducts );
		}  
	
	
	

}
