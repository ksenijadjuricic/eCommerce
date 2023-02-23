package clothingStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import clothingStore.abstarctComponents.AbstractComponents;

public class AccountDetailsPage extends AbstractComponents{
WebDriver driver;
	public AccountDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
