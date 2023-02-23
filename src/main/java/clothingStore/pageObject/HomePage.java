package clothingStore.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import clothingStore.abstarctComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
    WebDriver driver;
	public HomePage (WebDriver driver) {
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css=".content-product")
	List <WebElement> featuredProducts;
	@FindBy (css=".show-quickly")
	WebElement featuredProduct=featuredProducts.get(0);
	@FindBy (xpath="(//a[@class='product-content-image'])[3]")
    WebElement productImage;
	@FindBy (xpath="//div[contains(@class,'category-grid')]")
	List<WebElement> categoryContainers;
	@FindBy (xpath="(//span[@class='text-nowrap'])[3]")
	WebElement headerPromoText;
	@FindBy (linkText="View the Collection")
	WebElement headerPromoLink;

public void goTo() {
	driver.get("https://etualshop.com/en/home/");
	}
	
	public ProductPage getFeaturedProduct() {
		scrollBy("window.scrollBy(0,1300)");
		waitForElementsToAppear(featuredProducts);
		WebElement product=featuredProducts.get(2);
		product.click();
		ProductPage productPage =new ProductPage(driver);
		return productPage;
		}
	
	public int getTheNumberOfDisplayedFeaturedProducts() {
		int numberOfProducts=featuredProducts.size();
		return numberOfProducts;
	}
	
	public ProductPage clickOnProductImage() {
		scrollBy("window.scrollBy(0,1300)");
		waitForElementToBeClickable(productImage);
		productImage.click();
		ProductPage productPage= new ProductPage(driver);
		return productPage;
	}
		
		public void clickOnEachCategoryContainer() {
			scrollBy("window.scrollBy(0,700)");
			waitForElementsToAppear(categoryContainers);
			for(int i=0; i<categoryContainers.size(); i++) {
				
				
				WebElement container=categoryContainers.get(i);
				container.click();
				driver.navigate().back();
				waitForElementsToAppear(categoryContainers);
			}
		}
	
	
		public String varifyVisabilityAndGetHeaderPromoText() {
			waitForElementToAppear(headerPromoText);
			 String text=headerPromoText.getText();
			 return text;
		}
		
		
		public ClothesPage clickOnPromoLink() {
			waitForElementToAppear(headerPromoLink);
			headerPromoLink.click();
			ClothesPage clothesPage=new ClothesPage(driver);
			return clothesPage;
			
		}
		public String getLinkText() {
			String linkText=headerPromoLink.getText();
			return linkText;
		}
		
	}
	
	
	//public void clikOn
	

