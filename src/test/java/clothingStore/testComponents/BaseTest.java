package clothingStore.testComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import clothingStore.pageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		 Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\clothingStore\\resources\\GlobalData.properties");
        prop.load(fis);
        String browserName=	System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
        
        if(browserName.contains("chrome")) {
        	ChromeOptions options=new ChromeOptions();
        	WebDriverManager.chromedriver().setup();
        	
        	if(browserName.contains("headless")){
    			options.addArguments("headless");
    			}
        	driver=new ChromeDriver(options);
        	//driver.manage().window().setSize(new Dimension(1440,900));
        }
        
        
        	else if(browserName.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver" , "C:\\Users\\kseni\\geckodriver.exe");
        	driver= new FirefoxDriver();
        }
        	else if(browserName.equalsIgnoreCase("edge")) {
        		System.setProperty("webdriver.edge.driver","C:\\Users\\kseni\\msedgedriver.exe");
                driver=new EdgeDriver();
        	}
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
        
       
	}
	
	
		public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
		{
			//read json to string
		String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
				StandardCharsets.UTF_8);
		
		//String to HashMap- Jackson Datbind
		
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data; }
		  
		  
	public void scrollBy(String parameters) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(parameters);
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void launchApplication() throws IOException {
		driver=initializeDriver();
      
		driver.get("https://etualshop.com/en/home/");
		
	}
	
	public void goBack() {
		driver.navigate().back();
	}

	/* @AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	} */
}
