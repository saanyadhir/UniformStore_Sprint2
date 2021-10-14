package SanityTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class adminSearchProduct 
{
	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
	By loginStatus = By.cssSelector("#content > div.page-header > div > h1");
	By navigator = By.xpath("//*[@id=\"button-menu\"]/i");
	By catalogButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"catalog\"]");
	By productButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"catalog\"]//child::a[text()=\"Products\"]");
	
	By productName = By.id("input-name");
	By price = By.id("input-price");
	By status = By.id("input-status");
	By model = By.id("input-model");
	By quantity = By.id("input-quantity");
	By filterButton = By.xpath("//*[@id=\"button-filter\"]");
	
	By results = By.xpath("//*[@id=\"form-product\"]/div/table/tbody/tr[1]/td[3]");
	
	public adminSearchProduct(WebDriver driver)
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
	
	public void clickCatalogButton()
	{
		driver.findElement(catalogButton).click();
		System.out.println("Ctalog");
	}
	
	public void clickProductsButton()
	{
		driver.findElement(productButton).click();
		System.out.println("product");
	}
	
	public void typeProductName(String pname)
	{
		driver.findElement(productName).sendKeys(pname);
	}
	public void selectStatus(String st)
	{
		driver.findElement(status).sendKeys(st);;
	}
	public void typeModel(String m)
	{
		driver.findElement(model).sendKeys(m);
	}
	public void typePrice(String pr)
	{
		driver.findElement(price).sendKeys(pr);
	}
	public void typeQuantity(String qty)
	{
		driver.findElement(quantity).sendKeys(qty);
	}
	
	public boolean isProductNameEnabled()
	{
		if(driver.findElement(productName).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isStatusEnabled()
	{
		if(driver.findElement(status).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isModelEnabled()
	{
		if(driver.findElement(model).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isPriceEnabled()
	{
		if(driver.findElement(price).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isQuantityEnabled()
	{
		if(driver.findElement(quantity).isEnabled())
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
