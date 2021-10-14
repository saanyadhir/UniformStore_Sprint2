package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.adminlogin;

public class admin_categorypage {
	
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

		
 }
}

