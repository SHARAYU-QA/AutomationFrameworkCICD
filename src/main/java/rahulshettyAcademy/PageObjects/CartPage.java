package rahulshettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAcademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> ListOfproductName;

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	public boolean verifyProduct(String ProductName) {
		boolean match = ListOfproductName.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public void clickOnCheckOutButton() 
	{
		checkOut.click();

	}

}
