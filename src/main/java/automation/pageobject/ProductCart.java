package automation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCart extends AbstractComponent {

	WebDriver driver;
	public ProductCart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	@FindBy (css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy (css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy (css=".cartSection \\h3")
	List<WebElement> cartProducts;
	
	@FindBy (css=".ng-animating")
	WebElement loader;
	
	By ProductList = By.cssSelector(".col-lg-4");
	By list = By.cssSelector("b");
	By name = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");
	//By loader = By.cssSelector(".ng-animating");
	
	public  List<WebElement> getProduct()
	{
		waitForElementToApper(ProductList);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement text = products.stream()
				.filter(product -> product.findElement(list).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return text;
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException
	{
		WebElement text = getProductByName(ProductName);
	    text.findElement(name).click();
		waitForElementToApper(toastMessage);
		waitForInvisibilityOfElementLocated(loader);
		
	}
	
	public void clickOnCart()
	{
		cart.click();
	}
	
	public boolean verifyProductDisplay(String ProductName)
	{		
	Boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(ProductName));
	return match;
	
	}
}
