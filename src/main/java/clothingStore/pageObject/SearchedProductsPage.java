package clothingStore.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class SearchedProductsPage extends AbstractComponents {
    WebDriver driver;
	public SearchedProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(css=".product-title")
	List <WebElement> listOfSearchedProducts;
	@FindBy(xpath="//div[@class='empty-category-block']/h2")
	WebElement message;
	@FindBy(xpath="//a[contains(@class,'medium')]")
	WebElement returnBtn;
	
	public List<WebElement> getListOfSearchedProducts() {
		waitForElementsToAppear(listOfSearchedProducts);
		return listOfSearchedProducts;
	}

	public String getNoMatchedProductsMessage() {
		waitForElementToAppear(message);
		String noMatchesMessage=message.getText();
		return noMatchesMessage;
	}
    public ShopPage clickOnReturn() {
    	waitForElementToAppear(returnBtn);
    	returnBtn.click();
    	ShopPage shopPage = new ShopPage(driver);
    	return shopPage;
    }
    
    
}

