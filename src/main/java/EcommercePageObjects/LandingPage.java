package EcommercePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}


	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//We can write above step in another format as below using Page Factoring
	
	//Page Factory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//How the findby annotations will work means in constructor we are defining the pagefactory initElements we are initilizing the elements using the driver 
	
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")   //istead of id we can write xpath,css,ClassName...
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	

}
