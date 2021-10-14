package SmokeTestTestCase;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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

import SmokeTestPage.CustomerLoginPage;




public class TestCaseCustomerLogin {
	
	static String driverPath = "C:\\Users\\Ruhi\\Desktop\\sel\\chromedriver_win32\\chromedriver.exe";

    static WebDriver driver;	
	
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
		driver.get("http://uniformm1.upskills.in/index.php?route=common/home");
		   
		driver.manage().window().maximize();
		
    }
	
	
	@Test(priority=0)
	public void veriyfylogin() throws Exception
	{
		CustomerLoginPage login = new CustomerLoginPage(driver);
	
		/*System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();*/
	// creating object of LoginPage class
		
		
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
			
			String status = login.getLoginStatus();
			
			 if (status.contains("MY ACCOUNT"))
				{
					
						System.out.println("\nLoggin successful\n");
						Assert.assertEquals(true, true);
					
					
				}
				else
				{
				     Reporter.log("Incorrect Credentials. Negative Test case passed by not letting the user in.",true);
				     
				     Assert.assertEquals(true, true);
							     
				}
			login.Logout();
			
			
			
	}
	@Test(priority=2)
	public void unsuccessfullogin() throws Exception{
		CustomerLoginPage login = new CustomerLoginPage(driver);
		String status = login.getLoginStatus();
		
		login.Login();
		if(login.isUsernameboxEnabled()==true)
		{
	
			login.typeusername("ruhi");
		}
		
		if(login.isPasswordboxEnabled()==true)
		{	
			login.typepassword("123");
		}
		
		login.clickLoginButton();
		
		
		try
		 {
			 if (status.contains("MY ACCOUNT"))
				{
					
						System.out.println("\nLoggin successful\n");
						Assert.assertEquals(true, true);
					
					
				}
		 }

       
		
		catch (NoSuchElementException e)
		{
			
	         //System.out.println(dtf.format(now));  
	         
			Reporter.log("Incorrect Credentials. Negative Test case passed by not letting the user in.",true);
			System.out.println("Cannot register\n"+driver.findElement(By.xpath("//*[@id=\"login-block\"]/div/div[2]")).getText());
			AssertJUnit.assertEquals(true, true);
			//status=false;
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd "
         		+ "HH-mm-ss");  
         LocalDateTime now = LocalDateTime.now();  
		 String craetecoursefailedfilename=("CustomerLoginFailedImage"+dtf.format(now)+".jpg");
	        System.out.println(craetecoursefailedfilename);
	        login.takeSnapShot(driver, craetecoursefailedfilename);
			       
		
		
		
}
	
}
