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

import rahulshettyAcademy.PageObjects.LoginPage;

public class StandAloneTest {
	public static WebDriver driver;


	public static void main(String[] args){
		// TODO Auto-generated method stub
		
        ChromeOptions options = new ChromeOptions();

//To set the zoom level in chromedriver as 90%

        options.addArguments("--force-device-scale-factor=0.9");

        options.addArguments("--high-dpi-support=1");
        driver = new ChromeDriver(options);
        LoginPage lp = new LoginPage(driver);
		//WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();
		String productName = "iphone 13 pro";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("mankarsharayu@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sharayu@27");
		driver.findElement(By.cssSelector(".btn.btn-block.login-btn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));//total products
		
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		System.out.println("Total no of Products " +products.size());
		
		WebElement prod = products.stream().filter(product->product.
				findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));

		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']"))).click();		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		
		List<WebElement>itemsInCart =  driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match = itemsInCart.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
	
		Assert.assertTrue(match);

		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		js.executeScript("scrollBy(0,300)");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button"))).click();
		
		Actions act = new Actions(driver);
		 WebElement country = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));

		act.sendKeys(country, "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".hero-primary")));
		
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		
	}

}
