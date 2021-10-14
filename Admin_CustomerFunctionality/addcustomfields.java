
package testcases;

import java.util.Random;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.adminlogin;

public class addcustomfields {
	
	static String driverPath = "D:\\chromedriver";
	@Test
	public void verifylogin()
	{
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/admin/index.php?route=customer/custom_field/add&token=2K1sykKffoDrLD7Q19zNuvYTksxHAOcJ");
		driver.manage().window().maximize();
		
		adminlogin login = new adminlogin(driver);
		Random rd=new Random();
		int result=Math.abs(rd.nextInt());
		String s=Integer.toString(result);
		
		login.typeusername("admin");
		login.typepassword("admin@123");
		login.clickLoginButton();
		driver.findElement(By.xpath("//*[@id=\"catalog\"]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"customer\"]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"customer\"]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a")).click();
		driver.findElement(By.name("custom_field_description[1][name]")).sendKeys("Rohini1");
		driver.findElement(By.id("input-location")).click();
		Select loc=new Select(driver.findElement(By.id("input-location")));
		loc.selectByVisibleText("Address");
		 
		 driver.findElement(By.id("input-type")).click();
		Select typ=new Select(driver.findElement(By.id("input-type")));
		typ.selectByVisibleText("Radio");
		 
		 driver.findElement(By.name("custom_field_customer_group[2][customer_group_id]")).click();
		 driver.findElement(By.name("custom_field_customer_group[9][required]")).click();
		 
		 driver.findElement(By.id("input-status")).click();
		 Select stat=new Select(driver.findElement(By.id("input-status")));
		 stat.selectByVisibleText("Enabled");
		 
		 driver.findElement(By.id("input-sort-order")).sendKeys("1");
		 
		 driver.findElement(By.xpath("//*[@id=\"custom-field-value\"]/tfoot/tr/td[2]/button/i")).click();
		 
		 driver.findElement(By.name("custom_field_value[0][custom_field_value_description][1][name]")).sendKeys("Rohini11");
				
			driver.findElement(By.xpath("//*[@id=\"custom-field-value-row0\"]/td[2]/input")).sendKeys("1");
		 
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button/i")).click();
	
		
		
		
	Assert.assertEquals(true,adminlogin.successfulProductAddition());
			
		
	}

}



