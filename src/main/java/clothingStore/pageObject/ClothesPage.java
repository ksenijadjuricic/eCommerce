package clothingStore.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class ClothesPage extends AbstractComponents{
    WebDriver driver;
	public ClothesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".product-title")
	List <WebElement> products; 
	//List <WebElement> products= driver.findElements(By.cssSelector(".product-title"));
	@FindBy(xpath="//a[contains(@class,'add_to_cart_button')]")
	WebElement addToCart;
	 @FindBy(xpath="//button[contains(@class,'single_add_to_cart_button')][1]")
	 WebElement addToCartButton;
	 @FindBy(xpath="//div[contains(@class,'et-notify')]")
		WebElement popUp;
	 
	 
	 By productsBy = By.cssSelector(".product-title");
	 By addTocart = By.xpath("//a[contains(@class,'add_to_cart_button')]");
	 public List<WebElement> getProductList()
	 {
		 return products;
	 }
	 
	 public WebElement getProductByName(String productName)
	 {
		 WebElement prod = getProductList().stream().filter(product ->
		 product.findElement(By.cssSelector("a")).getText().equals(productName)).findFirst().orElse(null);
		 return prod;
	 }
	 
	 public void addToCart(String productName)
	 {
		 WebElement prod = getProductByName(productName);
		 prod.findElement(addTocart).click();
	 }
	
	 
	 
//	 public void getProductsNames() throws InterruptedException {
//		int j=0;
//	
//		for(int i=0; i< products.size(); i++) {
//			String[] name=products.get(i).getText().split("-");
//			String formatedName= name[0].trim();
//			
//		  	
//		
//		if(itemsNeeded.contains(formatedName)) {
//			
//		  j++;
//		  
//		
//					products.get(i).click();
//					addToCartButton.click();
//					waitForElementToAppear(popUp);
//					driver.navigate().back();
//				   
//					waitForElementsToAppear(products);
//					
//					if(j==itemsNeeded.size()) {break;}
//		}
//		}
//	}
	 public void addCart(WebDriver driver, String[] products) {
			int count = 0;
			
			List<WebElement> productNameList = driver.findElements(By.cssSelector(".product-title"));
	 
			for (int i = 0; i < productNameList.size(); i++) 
			{
				for (int j = 0; j < products.length; j++)
					if (productNameList.get(i).getText().contains(products[j].toString())) 
					{
						count++;
						driver.findElements(By.cssSelector("div[class='content-product']")).get(i).click();
						driver.findElement(By.xpath("//button[contains(@class,'single_add_to_cart_button')][1]")).click();
						driver.navigate().back();
	 
						if (count == products.length)
							break;
					}
			}
	 }
}


