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

public class SubmitOrderTest extends BaseTest {

       @Test
       public void submitOrder() throws IOException
       {
		
		
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue= landingPage.loginApplication("pandugad@gmail.com", "Sharath@97");
		
	 
	    
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
		
	   CartPage cartpage= productCatalogue.goToCartPage();
	   Boolean match= cartpage.VerifyProductDisplay(productName);
	   Assert.assertTrue(match);
	   CheckOutPage checkoutPage= cartpage.goToCheckout();
	   checkoutPage.selectCountry();
	   ConfirmationPage confirmationPage=checkoutPage.submitOrder();
	   
	   String confirmmessage = confirmationPage.getConfirmationMssg();
       Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    

	}

}
