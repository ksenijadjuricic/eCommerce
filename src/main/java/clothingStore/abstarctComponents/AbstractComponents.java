package clothingStore.abstarctComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import clothingStore.pageObject.LogInPage;
import clothingStore.pageObject.ProductPage;
import clothingStore.pageObject.SearchedProductsPage;

public class AbstractComponents {
WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//PROVERI DA LI MOZE BEZ THREAD SLEEP
	@FindBy(xpath="//input[@class='form-control'][1]")
	WebElement searchBar;
	@FindBy(css="p[class*='ajax-item-title']")
	List<WebElement> listOfProducts;
	@FindBy(xpath="//button[contains(@class, 'search-button')]")
	WebElement searchButton;
	@FindBy (id="lang_choice_polylang-2")
	WebElement languageChoice;
	@FindBy(css="div[class*='et_b_header-account']")
	WebElement myAccountIcon;
	@FindBy(css="span[data-tab='register']")
	WebElement register;
	@FindBy(id="reg_email")
	WebElement registerEmailField;
	@FindBy (css="button[name='register']")
	WebElement registerBtn;
	@FindBy (css="button[name='login']")
	WebElement logInBtn;
	@FindBy (xpath="//span[@class='et-svg'][1]")
	WebElement addToCartIcon;
	@FindBy (xpath="(//span[contains(@class,'et-cart-quantity')])[1]")
	WebElement cartQuantity;
	
	public void waitForElementToAppear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));
	}
	
	public void waitForElementToAppearBy(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementsToAppear(List<WebElement> findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));
	}
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public void scrollBy(String parameters) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript(parameters);
		
		}
   public SearchedProductsPage searchProductsByName(String productName) {
	   searchBar.sendKeys(productName);
	   searchButton.click();
	   SearchedProductsPage searchedProductsPage =new SearchedProductsPage(driver);
	   return searchedProductsPage;
   }
   
   public ProductPage searchProductByName(String productName) {
	   searchBar.sendKeys(productName);
	   searchButton.click();
	   ProductPage productPage =new ProductPage(driver);
	   return productPage;
   }
   
   public List<WebElement> getResultList(String searchTerm) {
	   waitForElementToAppear(searchBar);
	   searchBar.sendKeys(searchTerm);
	   waitForElementsToAppear(listOfProducts);
	   return listOfProducts;
   }
   
public SearchedProductsPage clickOnSearchButton() {
	waitForElementToAppear(searchButton);
	searchButton.click();
	SearchedProductsPage searchedProductsPage=new SearchedProductsPage(driver);
	return searchedProductsPage;
}

public void selectEnglishLanguage() throws InterruptedException {
	waitForElementToAppear(languageChoice);
	languageChoice.click();
	Select dropdown=new Select(languageChoice);
	Thread.sleep(3000);
	dropdown.selectByIndex(1);
}

public void selectSerbianLanguage() throws InterruptedException {
	waitForElementToAppear(languageChoice);
	languageChoice.click();
	Select dropdown=new Select(languageChoice);
	Thread.sleep(3000);
	dropdown.selectByIndex(0);
}

public String getTitle() {
	String title=driver.getTitle();
	return title;
}



public LogInPage getEmailAndRegister(String email) {
	myAccountIcon.click();
	waitForElementToAppear(	registerEmailField);
	registerEmailField.sendKeys(email);
	register.click();
	LogInPage logInPage = new LogInPage(driver);
	return logInPage;
}

/*public LogInPage clickOnRegisterBtn() {
	waitForElementToAppear(registerBtn);
	registerBtn.click();
	LogInPage logInPage = new LogInPage(driver);
	return logInPage;
	} */
public LogInPage goToLogInPage() {
	myAccountIcon.click();
	logInBtn.click();
	LogInPage logInPage=new LogInPage(driver);
	return logInPage;
}

public void gotToAddToCart() {
	addToCartIcon.click();
}

public String getCartQuantity() {
	String number=cartQuantity.getText();
	return number;
}



}


