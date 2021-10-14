package SanityTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class adminProductReturnTestCase 
{
	static String driverPath = "D:\\Studyy\\chromedriver.exe";
	static WebDriver driver;
	final String order_id="1001";
	
	@BeforeTest
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/admin/index.php?route=sale/return&token=pWRVsjCorcKXvpSeXUS2MsSIws0xZVYy");
		driver.manage().window().maximize();
		System.out.println("INIT");
	}
	
	@Test
	public void filterByOrderId()
	{
		boolean filterSuccess = false;
		SanityTestPage.adminProductReturn login = new SanityTestPage.adminProductReturn(driver);
		if(login.isUsernameBoxEnabled()==true)
			login.typeUsername("admin");
		
		if(login.isPasswordBoxEnabled()==true)
			login.typePassword("admin@123");
		
		login.clickLoginButton();
		//login.clickNavigator();
		//login.clickSalesButton();
		//login.clickReturnsLink();
		
		filterSuccess = login.searchByOrderID(order_id);
		driver.findElement(By.id("button-filter")).click();
		Assert.assertEquals(filterSuccess,true);
	}
	
}
