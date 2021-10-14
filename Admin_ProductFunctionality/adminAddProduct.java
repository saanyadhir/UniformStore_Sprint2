package SanityTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class adminAddProduct 
{
	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
	By loginStatus = By.cssSelector("#content > div.page-header > div > h1");
	By navigator = By.xpath("//*[@id=\"button-menu\"]/i");
	By catalogButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"catalog\"]");
	By productButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"catalog\"]//child::a[text()=\"Products\"]");
	//By productButton = By.partialLinkText("Products");
	By addProductButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
	
	By productName = By.id("input-name1");
	By metaTitle = By.id("input-meta-title1");
	By dataTab = By.xpath("//*[@id=\"form-product\"]/ul/li[2]/a");
	By modelName = By.id("input-model");
	By price = By.id("input-price");
	By quantity = By.id("input-quantity");
	By saveButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");
	By successfulAddition = By.xpath("//*[contains(text(),\"Success\")]"); 
	
	public adminAddProduct(WebDriver driver)
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
	
	public void clickAddProductButton()
	{
		driver.findElement(addProductButton).click();
	}
	
	public void typeProductName(String pname)
	{
		driver.findElement(productName).sendKeys(pname);
	}
	public void typeMetaTitle(String mtitle)
	{
		driver.findElement(metaTitle).sendKeys(mtitle);
	}
	public void typeModel(String model)
	{
		driver.findElement(modelName).sendKeys(model);
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
	
	public boolean isMetaTitleEnabled()
	{
		if(driver.findElement(metaTitle).isEnabled())
			return true;
		else
			return false;
	}
	
	public boolean isModelEnabled()
	{
		if(driver.findElement(modelName).isEnabled())
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
	
	public void clickDataTabButton()
	{
		driver.findElement(dataTab).click();
	}
	
	public void clickSaveButton()
	{
		driver.findElement(saveButton).click();
	}
	
	public boolean successfulProductAddition()
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
