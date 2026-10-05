package rahulshettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAcademy.AbstractComponent.AbstractComponent;

public class ProductCatologue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatologue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	By productBy = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");
	
	public List<WebElement> getproducttList()
	
	{
		waitForElementToAppear(productBy);
		
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getproducttList().stream().filter(product->product.
				findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		return prod;
	}
	
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(toastMessage);
	}
	
	
	
}
