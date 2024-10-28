package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import EcommercePageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	

	public WebDriver initialazeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Sample\\SeleniumPractise\\src\\main\\java\\Framework\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.setBrowserVersion("130");
		    driver = new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.getProperty("webdriver.edge.driver","edge.exe");
			WebDriver driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.manage().window().maximize();
		return driver;
		   
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver= initialazeDriver();
		 landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}


