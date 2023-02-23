package clothingStore.tests;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import clothingStore.pageObject.CheckoutPage;
import clothingStore.pageObject.HomePage;
import clothingStore.pageObject.ProductPage;
import clothingStore.testComponents.BaseTest;

public class CheckoutPageTest extends BaseTest{
	
	/*@Test(dataProvider="getData")
	public void fillIn(HashMap<String,String> input ){
		HomePage  homePage=new HomePage(driver);
		ProductPage productPage=homePage.getFeaturedProduct();
		productPage.addToCart();
		CheckoutPage checkoutPage =productPage.goToCheckout();
		checkoutPage.fillIn(input.get("firstName"),input.get("lastName"),input.get("companyName"),input.get("address"),input.get("apartmentNumber"),input.get("cityName"),input.get("zip"),input.get("phoneNumber"),input.get("email"),input.get("notes"));
		checkoutPage.SelectDistrcit("Central Banat");
		//checkoutPage.selectCountry("Serbia"); 
	} */
	@Test(description="If product was successfully added to cart, after clicking on Buy now option,confirmation message should appear")
	public void validateMessage() {
		HomePage  homePage=new HomePage(driver);
		ProductPage productPage=homePage.getFeaturedProduct();
		String productName=productPage.getProductName();
		productPage.addToCart();
		CheckoutPage checkoutPage =productPage.goToCheckout();
		String observedMsg=checkoutPage.getMessage();
		Assert.assertEquals("View Basket" + productName +"has been added to your basket.",observedMsg);
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
	/*	HashMap<String,String> map= new HashMap<String,String>();
		map.put("firstName","Ksenija");
		map.put("lastName","Djuricic");
		map.put("companyName","Djuricic");
		map.put("address","Topolska");
		map.put("apartmentNumber","18");
		map.put("cityName","Beograd");
		map.put("zip","11000");
		map.put("phoneNumber","123456");
		map.put("email","dummyadresa@gmail.com");
		map.put("notes","selenium Automation");
		
		HashMap<String,String> map1= new HashMap<String,String>();
		map1.put("firstName","James");
		map1.put("lastName","Bond");
		map1.put("companyName","Universal Exports");
		map1.put("address","417 Longstream Road");
		map1.put("apartmentNumber","007");
		map1.put("cityName","London");
		map1.put("zip","E1 6AN");
		map1.put("phoneNumber","007007007");
		map1.put("email","bond.jamesbond@gmail.com");
		map1.put("notes","Shocking. Positively shocking."); */
		List <HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//clothingStore//data//data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
