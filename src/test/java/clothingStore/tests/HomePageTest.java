package clothingStore.tests;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import clothingStore.pageObject.HomePage;
import clothingStore.pageObject.SearchedProductsPage;
import clothingStore.testComponents.BaseTest;

public class HomePageTest extends BaseTest{
	HomePage homePage;
	int expectedNumberOfProducts=8;
	String headerPromoTextExpected="The new collection is on the site!";
	String linkTextText="View it";
	String searchTerm="purple";
	String pageTitleEng= "Home - Etualshop.com";
	String pageTitleSrb= "Početna - Etualshop.com";
	String newEmail="ymakis@hotmail.com";
	
	 @Test(description="Number of Featured Products displayed should be the same as the number customer required")
	public void validateTheNumberOfDisplayedFeaturedProducts() {
		homePage=new HomePage(driver);
		int actualNumberOfProducts=homePage.getTheNumberOfDisplayedFeaturedProducts();
		Assert.assertEquals(actualNumberOfProducts,expectedNumberOfProducts );
	}
	
	@Test(description="Image should be clickable and shoul navigate to next page where user can add that product to cart")
	public void checkIfProductImageIsClickable() {
		homePage=new HomePage(driver);
		homePage.clickOnProductImage();
	}
	
	@Test(description="When Category container is clicked, it should open a new page")
	public void checkIfCategoryImagesAreClickable() {
		homePage=new HomePage(driver);
		homePage.clickOnEachCategoryContainer();
	}
   
	@Test(description="Promotional text should be visible and text should be as per customer requirments")
	public void checkPromotionalText() {
		homePage=new HomePage(driver);
		String headerText=homePage.varifyVisabilityAndGetHeaderPromoText();
		Assert.assertEquals(headerPromoTextExpected, headerText);
	} 
	
	@Test(description="Link-text under Promo Header should be clicable and should open page with products under new Collection ")
	public void verifyPromoLinkTextIsClickable() {
		homePage=new HomePage(driver);
		homePage.clickOnPromoLink();
		
	}
	
	@Test(description="The text content of Link-text should be as per the requirments")
	public void verifyLinkTextText() {
		homePage=new HomePage(driver);
		String text=homePage.getLinkText();
		Assert.assertEquals(text, linkTextText); 
	} 
	
	@Test(description="Search results should be relevant to the search query.")
	public void validateSearch() {
		homePage=new HomePage(driver);
		List<WebElement> collectionProductLinks=homePage.getResultList(searchTerm);
		for(int i=0; i<collectionProductLinks.size(); i++) {
			String productName=collectionProductLinks.get(i).getText();
			if(productName.toLowerCase().contains(searchTerm.toLowerCase())) {
				Assert.assertTrue(true, searchTerm + "is displayed on product title: " + productName);
			}
			else {
				Assert.assertFalse(false, searchTerm + "is not displayed on product title: " +productName);
			}
			
		}
		
	//check if new page is open with results relevant to query
		
	SearchedProductsPage searchedProductsPage=homePage.clickOnSearchButton();
	List <WebElement>searchedProducts=searchedProductsPage.getListOfSearchedProducts();
	for(int i=0; i<searchedProducts.size(); i++) {
		String searchedPrNames=searchedProducts.get(i).getText();
		if(searchedPrNames.toLowerCase().contains(searchTerm.toLowerCase())) {
			Assert.assertTrue(true, searchTerm + "is displayed on product title: " + searchTerm + "on new page");
		}
		else {
			Assert.assertFalse(false,searchTerm + "is not displayed on product title: " + searchTerm + "on new page" );
		}
	}
	} 
	
	

	@Test(description="When there is no mathes for searched results no matches, new page should be open with appropiate message",
			groups="errorValidation")
	public void validateSearchWithNegativeScenario() {
		
		homePage=new HomePage(driver);
		SearchedProductsPage searchedProductsPage=homePage.searchProductsByName("{");
		String noMatchesMessage=searchedProductsPage.getNoMatchedProductsMessage();
		Assert.assertEquals(noMatchesMessage, "NO PRODUCTS WERE FOUND");
	    
		//check if Retun Button is clickable and is returning Shop Page
		searchedProductsPage.clickOnReturn(); 
} 
	
	@Test(description="Both Eng and Srb options should be clickable and page should be displayed in selected language")
	public void validateLanguageDropdown() throws InterruptedException {
		//select ENG and check if title is in English Language
		
		homePage=new HomePage(driver);
		homePage.selectEnglishLanguage();
		String title=homePage.getTitle();
		Assert.assertEquals(pageTitleEng, homePage.getTitle());
	
		//select SRB and check if title is in Serbian Language
		homePage.selectSerbianLanguage();
		Assert.assertEquals(pageTitleSrb,homePage.getTitle());
		
	} 
	
	@Test(description="When entering email to register, Register button should be clickable and should open New Page to Log in")
	public void RegisterWithNewEmail(String email) {
		homePage=new HomePage(driver);
		homePage.getEmailAndRegister(newEmail);
	
	}
	

	}


