package EcommercePageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	
	WebDriver driver;
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	public Boolean VerifyProductDisplay(String productName) {
	Boolean match = cartProducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
   return match;
 	}
	
	

	public CheckOutPage goToCheckout() {
		// TODO Auto-generated method stub
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(checkoutEle).click().perform();
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		return new CheckOutPage(driver);
		//.totalRow button
		
	}
}
