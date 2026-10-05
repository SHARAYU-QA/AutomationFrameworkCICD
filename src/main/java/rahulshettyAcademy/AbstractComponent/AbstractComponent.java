package rahulshettyAcademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	
	@FindBy (css="[routerlink*='cart']")
	WebElement clickOnCartButton;
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(By toastMessage)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastMessage));
		
	}
	
	public void goToCartPage()
	{
	
		clickOnCartButton.click();
	}
	
	public void scrollWindow()
	{
         JavascriptExecutor js =(JavascriptExecutor) driver;
		
		js.executeScript("scrollBy(0,600)");
	}
	
	
	public void actionsMethods(WebElement element)
	{
		
		
	}

}
