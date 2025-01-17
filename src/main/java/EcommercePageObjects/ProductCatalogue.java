package EcommercePageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}


	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//We can write above step in another format as below using Page Factoring
	
	//Page Factory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage= By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) 
	{
		WebElement prod =   getProductList().stream().filter(product->
		   product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		   return prod; 
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		waitForElementToAppear(toastMessage);
		
		waitForElementToDisappear(spinner);
	}

	
	
	

}
