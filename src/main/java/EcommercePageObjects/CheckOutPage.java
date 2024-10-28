package EcommercePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ecommerce.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
   
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	
	}
//	@FindBy(css=".action__submit")
//	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')][2])")
	WebElement selectCountry;
	
	By results= By.cssSelector(".ta-results");
	
	
	//public void selectCountry(String countryName) 
	public void selectCountry(){
		
		
		Actions a = new Actions(driver);
		   a.sendKeys(country,"India").build().perform();
		   
		// waitForElementToAppear(By.cssSelector(".ta-results"));
		   
		   selectCountry.click();	  
	}
		
	
	public ConfirmationPage submitOrder()
	{
//		
//		WebElement element = driver.findElement(By.cssSelector(".action__submit"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
		WebElement element = driver.findElement(By.cssSelector(".action__submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		
		return new ConfirmationPage(driver);
	}
	
	
	//WebDriverWait wait = new WebDriverWait(driver,10);
//	
//	//driver.findElement(By.cssSelector(".action__submit")).click();
//    WebElement button = driver.findElement(By.cssSelector(".action__submit"));
//    
//    // Wait for the element to be clickable
//    wait.until(ExpectedConditions.elementToBeClickable(button)).click();WebElement element = driver.findElement(By.cssSelector(".action__submit"));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	element.click();
}
