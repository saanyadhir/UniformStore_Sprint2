package SanityTestPage;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 //This class will store all the locators and methods of Login page
 
public class WhislistPage {
WebDriver driver;	
By email= By.id("input-email");
By password = By.xpath("//*[@id=\"input-password\"]");
By loginstatus = By.cssSelector("#content > h1");

By loginbutton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

By footerText = By.xpath("//*[contains(text(),'Uniform Store')]");
By WishListText=By.linkText("Wish List");
By UniformStore=By.linkText("Uniform Store");
By Tie= By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/a/img");
By ButtonWishList=By.xpath("//*[@id=\"product\"]/div[2]/div/button[1]");
By ruhiMorajkar=By.xpath("//*[@id=\"top-links1\"]/ul/li[3]/a/span[1]");
By heart=By.xpath("//*[@id=\"wishlist-total\"]/i");
By LogOut=By.linkText("Logout");
By LogInPage=By.xpath("//*[@id=\"column-right\"]/div/div[2]/a[1]");
By TishirtWishList=By.xpath("//*[@id=\"content\"]/div[1]/table/thead/tr/td[1]");
By dropdown=By.xpath("//*[@id=\"top-links1\"]/ul/li[3]/a/i");
By brands=By.linkText("Brands");
By UniformMaker=By.linkText("UniformMaker");
		


//By SignUpBotton=By.linkText("Sign up!");
//creating parameterized constructor to initialize WebDriver reference
public WhislistPage(WebDriver driver)
{
	this.driver =driver;
}


public void typeusername(String s)
{
	driver.findElement(email).sendKeys(s);
}


public void typepassword(String p) {
	driver.findElement(password).sendKeys(p);
}

/*public boolean isUsernameboxAvailable()
{

	if (driver.findElement(email).isDisplayed()) {
		return true;
	}
	else
	{
		return false;
	}
	
	}*/
public boolean isUsernameboxEnabled()
{

	if (driver.findElement(email).isEnabled()) {
		return true;
	}
	else
	{
		return false;
	}
	
	}

public boolean isPasswordboxEnabled()
{

	if (driver.findElement(password).isEnabled()) {
		return true;
	}
	else
	{
		return false;
	}
	
}


/*public String readTitle()
{
         return driver.getTitle();
}*/
/*
public Point  getPositionOfUsernamebox()   
{
	return driver.findElement(username).getLocation();
}
*/

public void clickLoginButton()
{
	driver.findElement(loginbutton).click();

	//System.out.println("Login success:" + home.checkLogoutButtonExists());
	
}
public  void clickWishList()
{
	driver.findElement(WishListText).click();
}
public void clickUniformStore()
{
	driver.findElement(UniformStore).click();
}
public void clickTie()
{
	driver.findElement(Tie).click();
}

public void clickaddWishList()
{
	driver.findElement(ButtonWishList).click();
}
public void dropDown()
{
	driver.findElement(ruhiMorajkar).click();
}
public void clickHeart()
{
	driver.findElement(heart).click();
}
public void LogoutCustomer()
{
	driver.findElement(LogOut).click();
}
public void clickLogInPage()
{
	driver.findElement(LogInPage).click();
}
public String checkItem()
{
  return driver.findElement(TishirtWishList).getText();
}
public void clickDropDown()
{
	driver.findElement(dropdown).click();
}
public String getLoginStatus()
{
	System.out.println("helo"+driver.findElement(loginstatus).getText());
	return driver.findElement(loginstatus).getText();
}
public void Brands()
{
	driver.findElement(brands).click();
}
public void UniformMaker()
{
	driver.findElement(UniformMaker).click();
}


public String getFooterString()
{
	
	//System.out.println(driver.findElement(footerText).getText());
	//return footerText.toString();
	//return driver.findElement(footerText).getText();
	String footerString;
	try {
		footerString=driver.findElement(footerText).getText();
	}
	catch(NoSuchElementException e)
	{
		footerString="Not found";
	}
	return footerString;
}

public boolean isFooterFound()

{
	
	boolean found=false;
	try {
		
		found=driver.findElement(footerText).isDisplayed();
	}
	
	catch (NoSuchElementException e)
	{
		found=false;
	}
	
	return found;
	
}
//public void clickSignUp()
//{
//	driver.findElement(SignUpBotton).click();
//}*/



}