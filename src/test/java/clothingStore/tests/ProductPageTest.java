package clothingStore.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import clothingStore.pageObject.ClothesPage;
import clothingStore.pageObject.HomePage;
import clothingStore.pageObject.ProductPage;
import clothingStore.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPageTest extends BaseTest {
	
	String productName="Bag Bordo";
	String itemNeeded1="Mini Dress Roxy";
	String itemNeeded2="Dress Ena";
	String[] itemsNeeded= {"Mini Dress Roxy","Dress Ena"};
	String itemName="Dress Ena";
	String itemName2="Knit Cut Out Shirt Kellina";
	String expectedTextMsg="Product added.";
	String productsQuantity="2";
	String expectedAlertMsg="Please select some product options before adding this product to your basket.";
	//List <WebElement> products= driver.findElements(By.cssSelector(".product-title"));
	@Test(description="Add To Cart should be clickable and a notification that item is successfully added to cart should appear with expected text,"
			+ "Number of products present in the cart should increes for selected amount")
	public void validateQuantityDisplay() {
	 	HomePage homePage= new HomePage(driver);
    	ProductPage productPage= homePage.searchProductByName(productName);
		String observedQuantity=productPage.getCartQuantity();
		productPage.addToCart();
		boolean currentQuantity=productPage.validateQuantity(observedQuantity);
		Assert.assertTrue(currentQuantity);
		}
		
    @Test(description="Add To Cart should be clickable and a notification that item is successfully added to cart should appear with expected text")
	public void validatePopUpMessage() {
    	HomePage homePage= new HomePage(driver);
    	ProductPage productPage= homePage.searchProductByName(productName);
    	productPage.addToCart();
    	String observedText=productPage.getMessage();
        Assert.assertTrue(observedText.equalsIgnoreCase(expectedTextMsg)); 
		
	}
    
    @Test(description="The user should be able to select the desired attribute of the product such as color,size and to add more than one product to cart")
    public void validateProductOptions() {
    	HomePage homePage= new HomePage(driver);
    	ProductPage productPage= homePage.searchProductByName(itemName2);
    	productPage.selectColor();
    	productPage.selectSize();
    	productPage.setQuantity(productsQuantity);
    	productPage.addToCart(); 	
    	
    } 
    
    @Test(description="If the user tries to add product to the cart without selecting attributes of the product, pop up with expected text should appear",
    		groups="ErrorValidation")
    public void validateErrorMessage() {
    	HomePage homePage= new HomePage(driver);
    	ProductPage productPage= homePage.searchProductByName(itemName);
    	productPage.addToCart();
    	String alertMsg=productPage.getAlertMessage();
    	Assert.assertTrue(alertMsg.equalsIgnoreCase(expectedAlertMsg));
    } 
  /*@Test
    public void validateCartProducts() throws InterruptedException {
	 
    	HomePage homePage= new HomePage(driver);
    	ClothesPage clothesPage=homePage.clickOnPromoLink();
    	/*clothesPage.addToCart(itemNeeded1);
    	goBack();
    	clothesPage.addToCart(itemNeeded2); 
    	//clothesPage.getProductByName(itemName);
    	clothesPage.addCart(driver, itemsNeeded); */
    	
    	
    	
		}
    	
    	
    
