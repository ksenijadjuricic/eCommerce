package clothingStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class ProductPage extends AbstractComponents {
    WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	 @FindBy(xpath="//button[contains(@class,'single_add_to_cart_button')][1]")
	 WebElement addToCartButton;
		@FindBy (xpath="//button[contains(@class,'et-single-buy-now')]")
		WebElement buyNow;
		@FindBy(css="input[name='quantity']")
		WebElement quantityField;
		@FindBy(xpath="//div[contains(@class,'et-notify')]")
		WebElement popUp;
		@FindBy (xpath="(//span[contains(@class,'et-cart-quantity')])[1]")
		WebElement cartQuantity;
		@FindBy (xpath="(//span[contains(@class,'item-span')])[1]")
		WebElement productColor;
		@FindBy (xpath="(//span[contains(@class,'item-span')])[3]")
		WebElement productSize;
		@FindBy(xpath="//button[contains(@class,'single-buy-now')]")
		WebElement buyNowBtn;
		@FindBy(xpath="//h1[contains(@class,'product_title')]")
		WebElement productName;
		
		
		
	 
	 public void addToCart() {
		 addToCartButton.click();
	 }
	 
	 public String getMessage() {
	   waitForElementToAppear(popUp);
		String message= popUp.getText();
		return message;
	 } 
	  public boolean validateQuantity(String expectedText) {
		  String observedText=cartQuantity.getText();
		  if(observedText.equals(expectedText)) {
			  return true;
		  }
		  return false;
	  }
   
	 /* public String getMesageText() {
		  waitForElementToAppear(popUp);
		  String text=popUp.getText();
		  return text;
	  } */
	  
	  public void selectColor() {
		  productColor.click();
	  }
	  public void selectSize() {
		  productSize.click();
	  }
	  
	  public void setQuantity(String quantity) {
		  quantityField.sendKeys(quantity);
	  }
	 public String getAlertMessage() {
		 String alert=driver.switchTo().alert().getText();
		 return alert;
	 }
	 
	 public CheckoutPage goToCheckout() {
		 buyNowBtn.click();
		 CheckoutPage checkoutPage =new CheckoutPage(driver); 
		 return checkoutPage;
		 }
	 public String getProductName() {
		 String name=productName.getText();
		 return name;
	 }
}
