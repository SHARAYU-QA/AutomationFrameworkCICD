package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyAcademy.AbstractComponent.AbstractComponent;
import rahulshettyAcademy.PageObjects.CartPage;
import rahulshettyAcademy.PageObjects.LoginPage;
import rahulshettyAcademy.PageObjects.ProductCatologue;
import rahulshettyAcademy.PageObjects.dashBoardPage;

public class SubmitOrderTest {
	public static WebDriver driver;


	public static void main(String[] args){
		// TODO Auto-generated method stub
		
        ChromeOptions options = new ChromeOptions();

//To set the zoom level in chromedriver as 90%

        options.addArguments("--force-device-scale-factor=1.0");

        options.addArguments("--high-dpi-support=1");
        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String productName = "iphone 13 pro";
		
		LoginPage lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		lp.goTo();
		lp.Login("mankarsharayu@gmail.com", "Sharayu@27");//login and click on login button
		ProductCatologue productcatologue = new ProductCatologue(driver);
		List<WebElement> products = productcatologue.getproducttList();//get the productList
		productcatologue.addProductToCart(productName);//get productname
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		System.out.println("Total no of Products " +products.size());
		productcatologue.goToCartPage();
		
		CartPage cp = new CartPage(driver);
		cp.goToCartPage();
		boolean match = cp.verifyProduct(productName);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		
		//List<WebElement>itemsInCart =  driver.findElements(By.cssSelector(".cartSection h3"));
		
		//boolean match = itemsInCart.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		System.out.println("Match result: " + match);

		Assert.assertTrue(match);

		cp.clickOnCheckOutButton();
		dashBoardPage dp = new dashBoardPage(driver);
		dp.selectCountry("india");

		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".hero-primary")));
		
	String confirmMessage = dp.verifyMessage();
	System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		
	}

}
