
package testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.manufactureradminlogin;

public class admin_addmanufacturers {
	
	static String driverPath = "D:\\chromedriver";
	@Test
	public void verifylogin()
	{
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/admin/index.php?route=common/dashboard&token=GojamxBwtSmLEAaHnCBgb3P8yKe4N2vQ");
		driver.manage().window().maximize();
		
		manufactureradminlogin login = new manufactureradminlogin(driver);
		Random rd=new Random();
		int result=Math.abs(rd.nextInt());
		String s=Integer.toString(result);
		
		login.typeusername("admin");
		login.typepassword("admin@123");
		login.clickLoginButton();
		driver.findElement(By.xpath("//*[@id=\"catalog\"]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"catalog\"]/ul/li[7]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a")).click();
		driver.findElement(By.id("input-name")).sendKeys("Rohini1"+s);
		driver.findElement(By.id("input-keyword")).sendKeys(s);
		driver.findElement(By.id("input-sort-order")).sendKeys("01");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button/i")).click();
		
		
		
		Assert.assertEquals(true,manufactureradminlogin.successfulProductAddition());
			
		
	}

}



