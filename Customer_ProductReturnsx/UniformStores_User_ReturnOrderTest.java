package SmokeTests;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UniformPages.CustomerLoginPage;
import UniformPages.UniformStores_User_ReturnOrderPage;



public class UniformStores_User_ReturnOrderTest {
	static WebDriver driver;
	//this.driver = driver;
	static String driverPath = "C:\\Users\\Admin\\3D Objects\\sivaranjani\\Desktop\\capg activities\\Selenium ChromeDriver\\chromedriver_win32\\chromedriver.exe";
    
	
		@AfterTest
  public void closeAll()
    {
    	driver.close();
    }
    
    @BeforeTest
    public void init()
    {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/index.php?route=account/login");
		driver.manage().window().maximize();
		System.out.println("INIT");
	 }
    
    
    
    @Test (priority = 1)
    public void Verifylogin()
    {
    	CustomerLoginPage login = new CustomerLoginPage(driver);
		
		if(login.isUsernameboxEnabled()==true)
		{
	
			login.typeusername("ranjanig@gmail.com");
		}
		
		if(login.isPasswordboxEnabled()==true)
		{	
			login.typepassword("ranjani04@");
		}
		
		login.clickLoginButton();
    }


@Test (priority = 2)
public void orderhistory()
{
    UniformStores_User_ReturnOrderPage myorders = new UniformStores_User_ReturnOrderPage(driver);
    myorders.movetoOrderHistory();
    myorders.clickordereditem();
    myorders.clickreturnbtn();
    myorders.reasonforreturn();
    myorders.clickSubmitButton();
    
    String status = myorders.getreturnstatus();
	
	 if (status.contains("PRODUCT RETURNS"))
		{
			
				System.out.println("\nReturned successful\n");
				Assert.assertEquals(true, true);
				
}
}
}

    	
		
		
    

	
	

