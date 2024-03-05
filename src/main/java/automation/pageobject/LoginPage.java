package automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//driver.findElement(By.id("userEmail"))
	@FindBy (id="userEmail")
	WebElement email;
	
	@FindBy (id="userPassword")
	WebElement pass;
	
	@FindBy (name="login")
	WebElement clickOnSubmit;
	
	@FindBy (css="[class*='flyInOut']")
	WebElement incorrectErrorMessage;

	public void LoginApplication(String username, String password)
	{
		email.sendKeys(username);
		pass.sendKeys(password);
		clickOnSubmit.click();
		
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToApper(incorrectErrorMessage);
		return incorrectErrorMessage.getText();
		
	}
	public void goTO()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
}
