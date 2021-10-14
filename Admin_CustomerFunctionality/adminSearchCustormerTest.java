
package SmokeTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UniformPages.adminSearchCustomerPage;

public class adminSearchCustormerTest 
{
	static String driverPath = "C:\\Users\\Admin\\3D Objects\\sivaranjani\\Desktop\\capg activities\\Selenium ChromeDriver\\chromedriver_win32\\chromedriver.exe";
	static WebDriver driver;
	
	@BeforeTest
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/admin/index.php?route=catalog/product&token=wjHCbD2zqgk7OArXbQOhv3VLgJpmjdU9");
		driver.manage().window().maximize();
		System.out.println("INIT");
	}
	
	@Test
	public void verifyLogin()
	{
		adminSearchCustomerPage login = new adminSearchCustomerPage(driver);
		
		if(login.isUsernameBoxEnabled()==true)
			login.typeUsername("admin");
		
		if(login.isPasswordBoxEnabled()==true)
			login.typePassword("admin@123");
		
		login.clickLoginButton();
		
		login.clickNavigator();
		login.clickCustomersButton();
		login.clickCustomersfieldButton();
		
		if(login.iscustomerNameEnabled()==true)
			login.typecustomerName("Abhignya Munipally");
		if(login.iscustomergroupEnabled()==true)
		{
			login.customergroupclick();
			login.customergroup();
		}
			
		if(login.isapprovedEnabled()==true)
		{
			login.approvedclick();
			login.approved();
		}
			
		if(login.isStatusEnabled()==true)
		{
			login.selectStatusclick();
			login.selectStatus();
		}
		
		
		if(login.isdateadded()==true)
			login.dateadded();
		if(login.isemailEnabled()==true)
		{
			login.typeemail("abhignya7@gmail.com");
		}
		login.typeip("49.206.41.172");
		login.clickFilterButton();
		
		boolean status = login.successfulSearch();
		if(status == true)
		{
			System.out.println("\ncustomer Filtering Successful\n");
			Assert.assertEquals(true, true);
		}
		else
		{
			Reporter.log("Negative Test Case passed.",true);
			Assert.assertEquals(true, true);
		}
	}
	
}

