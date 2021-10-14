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
import com.appname.pages.FilteringOrders;
//import com.appname.pages.retailAdminLoginPage;






public class TestFilteringOrders {
	static WebDriver driver;
	static FilteringOrders RETdminlogin; 

	

	@BeforeTest
	public void initdriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOUMYA HUGAR\\Documents\\CAPGEMINI\\sample\\chromedriver_win32\\chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	RETdminlogin=new FilteringOrders(driver);
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

@Test(priority=4)
public void add()
{
	RETdminlogin.filter();
}
@Test(priority=5)
public void adds()
{
	RETdminlogin.OstatusFilter();
}
/*@Test(priority=6)
public void Dateadd()
{
	RETdminlogin.DateAddedFilter();
}*/	
@Test(priority=6)
public void CustomerFil()
{
	RETdminlogin.CustomerFilter();
}
@Test(priority=7)
public void TotalFilters()
{
	RETdminlogin.TotalFilter();
}
/*@Test(priority=9)
public void DateFilters()
{
	RETdminlogin.DateModifiedFilter();
}*/
@Test(priority=8)
public void finalFilters()
{
	RETdminlogin.fill();
}
}


