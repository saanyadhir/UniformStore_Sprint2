package SanityTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class adminAddCustomer 
{
	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
	By loginStatus = By.cssSelector("#content > div.page-header > div > h1");
	By navigator = By.xpath("//*[@id=\"button-menu\"]/i");
	By customersButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"customer\"]");
	By customers = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"customer\"]//child::a[text()=\"Customers\"]");
	By addCustomerButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
	
	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
	By pwd = By.id("input-password");
	By cpwd = By.id("input-confirm");
	By saveButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button/i");
	By successfulAddition = By.xpath("//*[contains(text(),\"Success\")]"); 
	
	public adminAddCustomer(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void typeUsername(String un)
	{
		driver.findElement(username).sendKeys(un);
	}
	public void typePassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	public boolean isUsernameBoxEnabled()
	{
		if(driver.findElement(username).isEnabled())
			return true;
		else
			return false;
	}
	public boolean isPasswordBoxEnabled()
	{
		if(driver.findElement(password).isEnabled())
			return true;
		else
			return false;
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public void clickNavigator()
	{
		driver.findElement(navigator).click();
	}
	
	public void clickCustomersButton()
	{
		driver.findElement(customersButton).click();
	}
	
	public void clickCustomers()
	{
		driver.findElement(customers).click();
	}
	
	public void clickAddCustomersButton()
	{
		driver.findElement(addCustomerButton).click();
	}
	
	public void typeFirstName(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	public void typeLastName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	public void typeEmail(String emailid)
	{
		driver.findElement(email).sendKeys(emailid);
	}
	public void typeTelephoneNo(String telno)
	{
		driver.findElement(telephone).sendKeys(telno);
	}
	public void typePasswordBox(String pass)
	{
		driver.findElement(pwd).sendKeys(pass);
	}
	public void typeConfirmPassword(String cpass)
	{
		driver.findElement(cpwd).sendKeys(cpass);
	}
	
	public boolean isFirstNameEnabled()
	{
		if(driver.findElement(firstName).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isLastNameEnabled()
	{
		if(driver.findElement(lastName).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isEmailEnabled()
	{
		if(driver.findElement(email).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isTelephoneEnabled()
	{
		if(driver.findElement(telephone).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isPasswordFieldEnabled()
	{
		if(driver.findElement(pwd).isEnabled())
			return true;
		else
			return false;
	}
	public boolean isConfirmPasswordEnabled()
	{
		if(driver.findElement(cpwd).isEnabled())
			return true;
		else
			return false;
	}
	
	public void clickSaveButton()
	{
		driver.findElement(saveButton).click();
	}
	
	public boolean matchPasswords()
	{
		boolean matched=false;
		try
		{
			if(driver.findElement(pwd) == driver.findElement(cpwd))
				matched = true;
		}
		catch(Exception e)
		{
			matched = false;
		}
		return matched;
	}
	public boolean successfulCustomerAddition()
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
