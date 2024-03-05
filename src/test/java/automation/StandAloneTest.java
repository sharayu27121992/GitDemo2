package automation;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.TestComponent.BaseClass;
import automation.pageobject.LoginPage;
import automation.pageobject.ProductCart;
import automation.pageobject.cartPage;
import automation.pageobject.checkOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseClass{
	

	@Test (dataProvider = "getdata")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String ProductName = "ZARA COAT 3";	
		 loginpage.LoginApplication(input.get("email"), input.get("password"));
		ProductCart productcart  = new ProductCart(driver);
		List<WebElement> products = productcart.getProduct();
		productcart.getProductByName(input.get("Productname"));
		productcart.addProductToCart(input.get("Productname"));
		productcart.clickOnCart();
		Boolean match = productcart.verifyProductDisplay(input.get("Productname"));
		Assert.assertTrue(match);
		cartPage cartpage = new cartPage(driver);
		cartpage.clickOnCheckoutButton();
		cartpage.enterCountryName("India");
		takeScreenshot("LoginPage");
		checkOutPage checkout = new checkOutPage(driver);
		
	}
	
//	@DataProvider
//	public Object[] [] getData()
//	{
//		return new Object [][] {{"anshika@gmail.com","Iamking@000","IPHONE 13 PRO"},{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}};
//		
//	}
	public void takeScreenshot(String name) throws IOException
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\USER\\eclipse-workspace\\SeleniumFrameworkDesign\\"+ name + ".png"));
		
	}
	
	@DataProvider 
	public Object [][] getdata()
	{
		HashMap <String, String> map= new HashMap <String,String>();
		map.put("email", "anshika@gmail.com");
		map.put("password", "Iamking@000");
		map.put("Productname", "IPHONE 13 PRO");
		
		HashMap <String, String> map1= new HashMap <String,String>();
		map1.put("email", "anshika@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("Productname", "ZARA COAT 3");
		return new Object[][] {{map},{map1}} ; 
		
		
	}
}
