package UniformPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class adminSearchCustomerPage {
	
	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
	By loginStatus = By.cssSelector("#content > div.page-header > div > h1");
	By navigator = By.xpath("//*[@id=\"button-menu\"]/i");
	By customersButton = By.xpath("//*[@id=\"customer\"]/a");
	By customerfieldButton = By.xpath("//body/div/nav/ul/li[6]/ul/li/a");
	
	By customerName = By.id("input-name");
	By customergroup = By.id("input-customer-group");
	By approved = By.id("input-approved");
	By status = By.id("input-status");
	By dateadded = By.id("input-date-added");
	By email = By.id("input-email");
	By ip = By.id("input-ip");
	By filterButton = By.id("button-filter");
	
	By results = By.xpath("//tbody/tr[1]");
	
	public adminSearchCustomerPage(WebDriver driver)
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
		System.out.println("Customers");
	}
	
	public void clickCustomersfieldButton()
	{
		driver.findElement(customerfieldButton).click();
		System.out.println("customerlist");
	}
	
	public void typecustomerName(String pname)
	{
		driver.findElement(customerName).sendKeys(pname);
	}
	public void customergroupclick()
	{
		driver.findElement(customergroup).click();
		
	}
	public void customergroup()
	{
		//driver.findElement(customergroup).click();
		driver.findElement(By.xpath("//*[@id=\"input-customer-group\"]/option[5]")).click();
	}
	
	public void approvedclick()
	{
		driver.findElement(approved).click();
		
	}
	public void approved() {
		// TODO Auto-generated method stub
		//driver.findElement(approved).click();
		driver.findElement(By.xpath("//*[@id=\"input-approved\"]/option[2]")).click();;
	}
	
	public void selectStatusclick()
	{
		driver.findElement(status).click();
		
	}
	public void selectStatus() {
		// TODO Auto-generated method stub
		//driver.findElement(status).click();
		driver.findElement(By.xpath("//*[@id=\"input-status\"]/option[2]")).click();;
	}
	public void dateadded()
	{
		driver.findElement(dateadded).click();
		String tosearch = "2021-10-11";
		driver.findElement(dateadded).sendKeys(tosearch);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div/div[4]/div/div/span/button/i"));
		
	}
	public void typeemail(String pr)
	{
		driver.findElement(email).sendKeys(pr);
	}
	public void typeip(String q)
	{
		driver.findElement(ip).sendKeys(q);
	}
	
	public boolean iscustomerNameEnabled()
	{
		if(driver.findElement(customerName).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean iscustomergroupEnabled()
	{
		if(driver.findElement(customergroup).isEnabled())
			return true;
		else
			return false;
	}

	public boolean isapprovedEnabled() {
		// TODO Auto-generated method stub
		if(driver.findElement(approved).isEnabled())
			return true;
		else
			return false;
	}

	public boolean isStatusEnabled() {
		// TODO Auto-generated method stub
		if(driver.findElement(status).isEnabled())
			return true;
		else
			return false;
	}


	
	
	public boolean isdateadded()
	{
		if(driver.findElement(dateadded).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isemailEnabled()
	{
		if(driver.findElement(email).isEnabled())
			return true;
		else
			return false;
	}
	
	
	
	public void clickFilterButton()
	{
		driver.findElement(filterButton).click();
	}
	
	public boolean successfulSearch()
	{
		boolean status;
		try
		{
			driver.findElement(results);
			status = true;
		}
		catch(NoSuchElementException e)
		{
			status = false;
		}
		return status;
	}
}





