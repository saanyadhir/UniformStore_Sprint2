/**
 * 
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


 //This class will store all the locators and methods of Login page
 
public class UniformStoreAdminLoginPage {
WebDriver driver;	

By username= By.id("input-username");

By password = By.id("input-password");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");

By HeaderText = By.xpath("//*[contains(text(),'Dashboard')]/parent::div");


//creating parameterized constructor to initialize WebDriver reference
public UniformStoreAdminLoginPage(WebDriver driver)
{
	this.driver =driver;
}

public boolean isHeaderFound()

{
	
	boolean found=false;
	try {
		
		WebElement element = driver.findElement(HeaderText);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Dashboard header present in page?
		found=driver.findElement(HeaderText).isDisplayed();
	}
	
	catch (NoSuchElementException e)
	{
		found=false;
	}
	
	return found;
	
}	
	

	public boolean AdminLogin(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginbutton).click();
		
		boolean success=this.isHeaderFound();
		
		return success;
		
	
	}

	public String getUSLoginTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println(driver.getTitle());
		String curTitle = driver.getTitle();
		return curTitle;
		
		
	}

}


