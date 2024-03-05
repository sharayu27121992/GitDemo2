package automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.TestComponent.BaseClass;

public class ErrorValidation extends BaseClass {

	@Test
	public void errorValidation()
	{
	 String ProductName = "ZARA COAT 3";	
	 loginpage.LoginApplication("anshia@gmail.com", "Iamking@000");
	 
	 Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMessage());
	 
	 
	}
}
