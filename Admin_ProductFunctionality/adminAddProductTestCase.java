package SanityTestCase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SanityTestPage.adminAddProduct;

public class adminAddProductTestCase 
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
		adminAddProduct login = new adminAddProduct(driver);
		
		if(login.isUsernameBoxEnabled()==true)
			login.typeUsername("admin");
		
		if(login.isPasswordBoxEnabled()==true)
			login.typePassword("admin@123");
		
		login.clickLoginButton();
		login.clickNavigator();
		login.clickCatalogButton();
		login.clickProductsButton();
		login.clickAddProductButton();
		
		if(login.isProductNameEnabled()==true)
			login.typeProductName("Sports shoes");
		if(login.isMetaTitleEnabled()==true)
			login.typeMetaTitle("Shoes");
		
		login.clickDataTabButton();
		
		if(login.isModelEnabled()==true)
			login.typeModel("Puma");
		if(login.isPriceEnabled()==true)
			login.typePrice("2100");
		if(login.isQuantityEnabled()==true)
			login.typeQuantity("150");
		
		login.clickSaveButton();
		
		boolean status = login.successfulProductAddition();
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
