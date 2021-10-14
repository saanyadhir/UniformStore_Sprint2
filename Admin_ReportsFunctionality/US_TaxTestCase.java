package com.appname.Testcase;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.appname.pages.US_TaxPages;
//import com.appname.pages.retailAdminLoginPage;






public class US_TaxTestCase {
	static WebDriver driver;
	static US_TaxPages RETdminlogin; 
	
	
@BeforeTest
	public void initdriver()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	RETdminlogin=new US_TaxPages(driver);
    	//driver.get("http://retailm1.upskills.in/admin/index.php?route=catalog/product&token=GZ9t9SSlr5HETdCieWZGX4bm7CWYvgSu");
    	//driver.get("http://uniformm1.upskills.in/admin/index.php?route=sale/order&filter_order_status=5%2C1%2C2%2C12%2C3&token=9WjiKUWAK0fhz0nqypDrXk5NFKaCOg7k");
    	driver.get("http://uniformm1.upskills.in/admin/index.php?route=common/login");
	}
	@AfterTest
	public void teardown()
	{
		 driver.quit();
	}
	
	
@Test(priority=1)
public void user_is_on_admin_login_page() {
    // Write code here that turns the phrase above into concrete actions

	
	String curTitle = RETdminlogin.getUSLoginTitle(driver);
	
	Assert.assertEquals(curTitle, "Administration");
}

@Test(priority=2)
public void user_enters_correct_and_and_clicks_login() {
    // Write code here that turns the phrase above into concrete actions
	
	RETdminlogin.AdminLogin("admin","admin@123");
}





@Test(priority=3)
public void admin_homepage_should_be_loaded_successfully() {
    // Write code here that turns the phrase above into concrete actions

	boolean isloginsuccess=RETdminlogin.isHeaderFound();
	Assert.assertEquals(isloginsuccess, true);
	
}



@Test(priority=5)
public void startdate()
{
	RETdminlogin.TaxstatusFilter();
}

@Test(priority=6)
public void enddate()
{
	RETdminlogin.TaxstatusFilter2();
}

@Test(priority=7)
public void group()
{
	RETdminlogin.TaxstatusFilter3();
}

@Test(priority=8)
public void order()
{
	RETdminlogin.TaxstatusFilter4();
}



}