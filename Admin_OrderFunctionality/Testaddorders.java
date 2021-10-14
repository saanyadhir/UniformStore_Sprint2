package com.appname.Testcase;

import org.testng.annotations.Test;


	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.appname.pages.addOrders;
	//import com.appname.pages.retailAdminLoginPage;


	public class Testaddorders {
		static WebDriver driver;
		static addOrders RETdminlogin; 

		

		@BeforeTest
		public void initdriver()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOUMYA HUGAR\\Documents\\CAPGEMINI\\sample\\chromedriver_win32\\chromedriver.exe");
	    	
	    	driver = new ChromeDriver();
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	driver.manage().window().maximize();
	    	RETdminlogin=new addOrders(driver);
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
	public void all_func()
	{
		RETdminlogin.func();
	}
	
	
	@Test(priority=4)
	public void add2()
	{
		RETdminlogin.selectCust();
	}
	@Test(priority=5)
	public void check_product_type()
	{
		RETdminlogin.product_type();
	}
	@Test(priority=6)
	public void check_paymentdetails()
	{
		RETdminlogin.pay_det();
	}
	@Test(priority=7)
	public void check_shippingdetails()
	{
		RETdminlogin.ship_det();
	}
	@Test(priority=8)
	public void check_totalsshippingmethod()
	{
		RETdminlogin.total_shipmeth();
	}
	@Test(priority=7)
	public void check_totalpaymentmethod()
	{
		RETdminlogin.total_paymeth();
	}
	
}
