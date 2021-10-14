package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.adminlogin;

public class addCustomergroups {
	
	static String driverPath = "C:\\CHROME driver\\";
	@Test
	public void verifylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/admin/index.php?route=common/dashboard&token=GojamxBwtSmLEAaHnCBgb3P8yKe4N2vQ");
		driver.manage().window().maximize();
		
		adminlogin login = new adminlogin(driver);
		
		login.typeusername("admin");
		login.typepassword("admin@123");
		login.clickLoginButton();
		driver.findElement(By.xpath("//*[@id=\"customer\"]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"customer\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"form-customer-group\"]/div[1]/div/div/input")).sendKeys("Loyal Customers");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button/i")).click();
		
		Assert.assertEquals(true,adminlogin.successfulCustomerAddition()); 
		
	}
	
}


