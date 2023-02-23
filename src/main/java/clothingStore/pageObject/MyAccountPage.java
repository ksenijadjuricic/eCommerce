package clothingStore.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class MyAccountPage extends AbstractComponents {
    WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//div[contains(@class,'content')]/h3")
	WebElement loggedInMessage;
	@FindBy (xpath="//div[contains(@class, 'MyAccount-dashboard')]/a[1]")
	WebElement recentOrderBtn;
	@FindBy (xpath="//div[contains(@class, 'MyAccount-dashboard')]/a[2]")
	WebElement addressBtn;
	@FindBy (xpath="//div[contains(@class, 'MyAccount-dashboard')]/a[3]")
	WebElement accountDetailsBtn;
	@FindBy(css=".content-product")
	List <WebElement> products;
	
	
	public String getWelcomeMessage() {
		waitForElementToAppear(loggedInMessage);
		String message=loggedInMessage.getText();
		return message;
	}
	
	public RecentOrdersPage goToRecentOrders() {
		recentOrderBtn.click();
		RecentOrdersPage recentOrdersPage =new RecentOrdersPage(driver);
		return recentOrdersPage;
	}
	
	public AddressPage goToAddressPage() {
		addressBtn.click();
		AddressPage addressPage =new AddressPage(driver);
		return addressPage;
	}
	public AccountDetailsPage goToAccountDetailsPage() {
		accountDetailsBtn.click();
		AccountDetailsPage accountDetailsPage =new AccountDetailsPage(driver);
		return accountDetailsPage;
	}
	
	public int getDisplayedProductsList() {
		int numberOfProducts=products.size();
		return numberOfProducts;
	}
	
}
