package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.adminlogin;

public class addCategory {
	
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
		driver.findElement(By.xpath("//*[@id=\"catalog\"]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"catalog\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a[1]")).click();
		driver.findElement(By.id("input-name1")).sendKeys("School Tie");
		driver.findElement(By.id("input-meta-title1")).sendKeys("T 01");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button")).click();
		
		Assert.assertEquals(true,adminlogin.successfulCategoryAddition());

		//WebElement msg=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]"));
		//String text=msg.getText();
		//Assert.assertEquals(text,"Success: You have modified categories!");
		//("Success: You have modified categories!×);
		
		
	}
	
}








