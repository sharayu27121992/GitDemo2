package automation.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkOutPage extends AbstractComponent{

	WebDriver driver;
	public checkOutPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".hero-primary")
	WebElement matchTitle;
	
	@FindBy (css=".action__submit")
	WebElement placeOrder;
	
	public void clickOnCheckout()
	{
		placeOrder.click();
		String title = "THANKYOU FOR THE ORDER.";
		String expected = matchTitle.getText();
		System.out.println(expected);
	}
	
	
}
