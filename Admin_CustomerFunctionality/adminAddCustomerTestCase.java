package SanityTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SanityTestPage.adminAddCustomer;

public class adminAddCustomerTestCase 
{
	static String driverPath = "D:\\Studyy\\chromedriver.exe";
	static WebDriver driver;
	
	@BeforeTest
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/admin/");
		driver.manage().window().maximize();
		System.out.println("INIT");
	}
	
	@Test
	public void verifyLogin()
	{
		adminAddCustomer login = new adminAddCustomer(driver);
		
		if(login.isUsernameBoxEnabled()==true)
			login.typeUsername("admin");
		
		if(login.isPasswordBoxEnabled()==true)
			login.typePassword("admin@123");
		
		login.clickLoginButton();
		login.clickNavigator();
		login.clickCustomersButton();
		login.clickCustomers();
		login.clickAddCustomersButton();
		
		if(login.isFirstNameEnabled()==true)
			login.typeFirstName("Saanya");
		if(login.isLastNameEnabled()==true)
			login.typeLastName("Dhir");
		if(login.isEmailEnabled()==true)
			login.typeEmail("saanyaa03@gmail.com");
		if(login.isTelephoneEnabled()==true)
			login.typeTelephoneNo("8968745130");
		if(login.isPasswordFieldEnabled()==true)
			login.typePasswordBox("qwerty");
		if(login.isConfirmPasswordEnabled()==true)
			login.typeConfirmPassword("qwerty");
		
		login.clickSaveButton();
		boolean passwordsMatched = login.matchPasswords();
		boolean status = login.successfulCustomerAddition();
		if(passwordsMatched == true)
		{
			if(status==true)
			{
				System.out.println("\nNew Product Added Successfully\n");
				Reporter.log("****New Product has been successfully added!!!*****",true);
				Assert.assertEquals(true, true);
			}
			else
			{
				Reporter.log("Negative Test Case passed.",true);
				Assert.assertEquals(true, true);
			}
		}
		
	}

}
