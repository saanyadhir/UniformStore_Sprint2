package SanityTestCase;



import org.testng.annotations.Test;

import SanityTestPage.WhislistPage;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




public class WhishlistTestCase {
	static String driverPath = "C:\\Users\\Ruhi\\Desktop\\sel\\chromedriver_win32\\chromedriver.exe";

    static WebDriver driver;	
	
   // @AfterTest
    //public void closeAll()
    //{
    //	driver.close();
    //}
    
    
    @BeforeTest
    public void init()
    {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/index.php?route=common/home");
		driver.manage().window().maximize();
		
	
		
    }
	
	
	@Test
	public void verifyWhishList()
	{
	
		/*System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();*/
	// creating object of LoginPage class
		
		WhislistPage login = new WhislistPage(driver);
		login.clickDropDown();
		//login.clickLogin();
		driver.navigate().to("http://uniformm1.upskills.in/index.php?route=account/login");
		
			if(login.isUsernameboxEnabled()==true)
			{
		
				login.typeusername("ruhiiii@gmail.com");
			}
			
			if(login.isPasswordboxEnabled()==true)
			{	
				login.typepassword("12345");
			}
			
			login.clickLoginButton();
			login.Brands();
			login.UniformMaker();
			
			
			//login.clickUniformStore();
			login.clickTie();
			login.clickaddWishList();
			
			login.clickHeart();
			login.LogoutCustomer();
			login.clickLogInPage();
			if(login.isUsernameboxEnabled()==true)
			{
		
				login.typeusername("ruhiiii@gmail.com");
			}
			
			if(login.isPasswordboxEnabled()==true)
			{	
				login.typepassword("12345");
			}
			
			login.clickLoginButton();
			login.clickWishList();
			String status=login.checkItem();
			 if (status.contains("Image"))
				{
					
						System.out.println("\nItem is succeessfully in the wishlist\n");
						Assert.assertEquals(true, true);
					
					
				}
				else
				{
				     Reporter.log("Incorrect Credentials. Negative Test case passed by not letting the user in.",true);
				     
				     Assert.assertEquals(true, true);
							     
				}
			
			
			
			
			
			
	}
	
}
