
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 
public class manufactureradminlogin {
static WebDriver driver;	

By username= By.id("input-username");
By password = By.id("input-password");
By loginstatus = By.cssSelector("#flash");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
static By successfulAddition=By.xpath("//*[contains(text(),\"Success\")]");

public manufactureradminlogin(WebDriver driver)
{
	this.driver =driver;
}
public void typeusername(String s)
{
	driver.findElement(username).sendKeys(s);
}

public void typepassword(String p) {
	driver.findElement(password).sendKeys(p);
}
public void clickLoginButton()
{
	driver.findElement(loginbutton).click();
}

public static boolean successfulProductAddition()
{
	boolean success;
	try
	{
		driver.findElement(successfulAddition);
		success = true;
	}
	catch(NoSuchElementException e)
	{
		success = false;
	}
	return success;
	
}
}
	

