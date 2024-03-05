package automation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.TestComponent.BaseClass;
import automation.pageobject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 extends BaseClass{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//initializeDriver();
		
		String ProductName= "ZARA COAT 3";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // global wait
		LoginPage login = new LoginPage(driver);
		//login.landingOnUrl();
		login.LoginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		//int count = product.size();
		
		WebElement text = products.stream().
		filter(product-> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		text.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //exlpicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> carPrducts = driver.findElements(By.cssSelector(".cartSection \\h3"));		
		Boolean match = carPrducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'] [2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String title = "THANKYOU FOR THE ORDER.";
		String expected = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(expected);
		Assert.assertEquals(title, expected);
		
	}

}
