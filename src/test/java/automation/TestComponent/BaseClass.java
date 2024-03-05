package automation.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import automation.pageobject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	 public static WebDriver driver;
     public LoginPage loginpage;

	public  WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\automation\\pageobject\\resources\\globalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		else
		{
			System.out.println("check data file");
		}
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod()
	public  LoginPage lunchApplication () throws IOException 
	{
	    driver = initializeDriver();
		  loginpage = new LoginPage (driver);
		  loginpage.goTO(); 
		  return loginpage;
		 
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
