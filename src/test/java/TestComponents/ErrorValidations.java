package TestComponents;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import EcommercePageObjects.CartPage;
import EcommercePageObjects.CheckOutPage;
import EcommercePageObjects.ConfirmationPage;
import EcommercePageObjects.LandingPage;
import EcommercePageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {

       @Test
       public void submitOrder() throws IOException
       {
		
		
		String productName="ZARA COAT 3";
		landingPage.loginApplication("pandugad@gmail.com", "Shar@97");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	 
	    
		
		

	}

}
