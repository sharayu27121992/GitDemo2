package automation.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage extends AbstractComponent {

	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="li[class='totalRow'] button")
	WebElement checkOut;
	
	@FindBy (xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy (xpath="//button[@class='ta-item list-group-item ng-star-inserted'] [2]")
	WebElement selectCountry;
	public void clickOnCheckoutButton()
	{
		checkOut.click();
	}
	
	public void enterCountryName(String countryName)
	{
		country.sendKeys(countryName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		selectCountry.click();
		
	}

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	
	
}
