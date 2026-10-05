package rahulshettyAcademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAcademy.AbstractComponent.AbstractComponent;

public class dashBoardPage extends AbstractComponent {

	WebDriver driver;

	public dashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@placeholder='Select Country']")
	WebElement enterCountry;
	
	@FindBy (xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	@FindBy (css=".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	
	By Results = By.cssSelector(".ta-results.list-group.ng-star-inserted");
	
	By grabText = By.cssSelector(".hero-primary");
	
	public void selectCountry(String countryName)
	{
		Actions act = new Actions(driver);
		act.sendKeys(enterCountry,countryName).build().perform();
		waitForElementToAppear(Results);
		selectCountry.click();
		placeOrder.click();
		
		waitForElementToAppear(grabText);
		
		
		
	}

	public String verifyMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}

