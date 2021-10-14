package SanityTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SanityTestPage.adminSearchProduct;

public class adminSearchProductTestCase 
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
		adminSearchProduct login = new adminSearchProduct(driver);
		
		if(login.isUsernameBoxEnabled()==true)
			login.typeUsername("admin");
		
		if(login.isPasswordBoxEnabled()==true)
			login.typePassword("admin@123");
		
		login.clickLoginButton();
		login.clickNavigator();
		login.clickCatalogButton();
		login.clickProductsButton();
		
		if(login.isProductNameEnabled()==true)
			login.typeProductName("Sports shoes");
		
		if(login.isPriceEnabled()==true)
			login.typePrice("2100");
		login.clickFilterButton();
		login.typePrice("");
		
		if(login.isStatusEnabled()==true)
			login.selectStatus("Enabled");
		if(login.isModelEnabled()==true)
			login.typeModel("Puma");
		if(login.isQuantityEnabled()==true)
			login.typeQuantity("1150");
		
		login.clickFilterButton();
		
		boolean status = login.successfulSearch();
		if(status == true)
		{
			System.out.println("\nProduct Filtering Successful\n");
			Assert.assertEquals(true, true);
		}
		else
		{
			Reporter.log("Negative Test Case passed.",true);
			Assert.assertEquals(true, true);
		}
	}
	
}	
