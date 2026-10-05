package rahulshettyAcademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAcademy.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement userPass;
	

	@FindBy(css=".btn.btn-block.login-btn")
	WebElement loginButton;
	
	
	public void Login(String email,String password)
	{
		username.sendKeys(email);
		userPass.sendKeys(password);
		loginButton.click();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	
	
	
}
