package StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import EcommercePageObjects.CartPage;
import EcommercePageObjects.CheckOutPage;
import EcommercePageObjects.ConfirmationPage;
import EcommercePageObjects.LandingPage;
import EcommercePageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImplt extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_Landed_On_Ecommerce_Page() throws IOException 
	{
		landingPage= launchApplication();
		
	}
	@Given("^Logged in with UserName (.+) and password (.+)$")
	public void logged_in_username_and_password(String username,String password) {
		 productCatalogue= landingPage.loginApplication(username,password);
	}
	
	@ When("^I add product (.+)  to cart$")
	public void i_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	@And("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		CartPage cartpage= productCatalogue.goToCartPage();
		   Boolean match= cartpage.VerifyProductDisplay(productName);
		   Assert.assertTrue(match);
		   CheckOutPage checkoutPage= cartpage.goToCheckout();
		   checkoutPage.selectCountry();
		   confirmationPage=checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	
	public void message_displayed_on_confirmationPage(String string) {

		   String confirmmessage = confirmationPage.getConfirmationMssg();
	       Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	       driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string,landingPage.getErrorMessage());
		driver.close();
	}
	

}
